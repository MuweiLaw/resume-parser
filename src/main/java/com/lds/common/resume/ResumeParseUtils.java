package com.lds.common.resume;

import com.alibaba.fastjson.JSONObject;
import com.lds.common.resume.domain.*;
import com.lds.common.resume.io.InputStreamCacher;
import com.lds.common.resume.parser.*;
import com.lds.common.resume.processor.ConvertProcessor;
import com.lds.common.resume.processor.EmlConvertProcessor;
import com.lds.common.resume.processor.OfficeOpenXMLConvertProcessor;
import com.lds.common.resume.processor.StandardConvertProcessor;
import com.lds.common.resume.util.EncodingDetectUtils;
import com.lds.common.resume.util.Word2HtmlUtils;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.tika.config.TikaConfig;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TemporaryResources;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MediaType;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class ResumeParseUtils {

    static List<ConvertProcessor> conversions = new ArrayList<>();
    static {
        conversions.add(new StandardConvertProcessor());
        conversions.add(new OfficeOpenXMLConvertProcessor());
        conversions.add(new EmlConvertProcessor());
    }

    public static String converResume(InputStream in) throws ResumeParseException {
        try {
            InputStreamCacher inputStreamCacher = new InputStreamCacher(in);

            String mediaType = parseMediaType(inputStreamCacher.getInputStream());
            String chartset = EncodingDetectUtils.detect(inputStreamCacher.getInputStream());
            System.out.println(chartset);
            for (ConvertProcessor cp : conversions) {
                if (cp.isSupport(mediaType)) {
                    return cp.convert(inputStreamCacher.getInputStream(), chartset);
                }
            }
            log.error("不支持的格式");
            throw new ResumeParseException("不支持的格式！！！");
        }catch (Exception e){
            throw new ResumeParseException(e.getMessage(),e);
        }
    }

    public static String parseResume(File file) throws ResumeParseException, FileNotFoundException {
        try {
            converHtmlFile(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return parseResume(new FileInputStream(file));
    }

    public static String parseResume(InputStream in) throws ResumeParseException {
        long startTime = System.currentTimeMillis();
        String content = null;
        try {
            content = converResume(in);


        } catch (Exception e) {
            throw new ResumeParseException("简历转换异常,"+ e.getMessage(),e);
        }
        //基础信息
        BasicInfoParser infoParser = new BasicInfoParser(content);
        BasicInfo basicInfo = infoParser.parse();
        //期望行业
        CareerObjectiveParser careerObjectiveParser = new CareerObjectiveParser(content);
        CareerObjective careerObjective = careerObjectiveParser.parse();

        //工作经历
        WorkExperienceParser workExperienceParser = new WorkExperienceParser(content);
        List<WorkExperience> WorkExperiences = workExperienceParser.parse();

        //工作经历
        ProjectExperienceParser projectExperienceParser = new ProjectExperienceParser(content);
        List<ProjectExperience> projectExperiences = projectExperienceParser.parse();

        //教育经历
        EducationParser educationParser = new EducationParser(content);
        List<Education> educations = educationParser.parse();

        Resume resume = new Resume();
        BeanUtils.copyProperties(basicInfo,resume);
        resume.setCareerObjective(careerObjective);
        resume.setEducations(educations);
        resume.setWorkExperiences(WorkExperiences);
        resume.setProjectExperiences(projectExperiences);
        System.out.println("cost times" + (System.currentTimeMillis() - startTime) + " ms.");
        return JSONObject.toJSONString(resume);
    }


    protected static String parseMediaType(InputStream in) throws IOException {
        TikaConfig config = TikaConfig.getDefaultConfig();
        try {
            TikaInputStream tis = TikaInputStream.get(in, new TemporaryResources());
            Detector detector = config.getDetector();
            MediaType detect = detector.detect(tis, new Metadata());
            String mediaType = detect.getBaseType().toString();
            System.out.println("detect = " + detect);
            return mediaType;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return null;
    }

    private static void converHtmlFile(File f) throws Exception {
        InputStream in = new FileInputStream(f);
        InputStreamCacher inputStreamCacher = new InputStreamCacher(in);
        String content = ResumeParseUtils.converResume(inputStreamCacher.getInputStream());

        String pathStr = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf(File.separator));
        pathStr = pathStr + File.separator + "html" + File.separator + f.getName().substring(0, f.getName().indexOf(".")) + ".html";


        //String chartset = EncodingDetectUtils.detect(inputStreamCacher.getInputStream());
        Word2HtmlUtils.writeFile(content, pathStr, null);
    }


}