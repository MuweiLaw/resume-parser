package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.TikaResumeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public abstract class BaseParser {

    protected Element root;

    protected String html;

    protected String text;

    protected SourceType sourceType;

    public BaseParser(String html) {
        this.html = html;
        this.root = Jsoup.parse(html);
        this.text = Jsoup.parse(html).text();
        if (html.contains("智联招聘")) {
            sourceType = SourceType.ZHAOPIN;
        }
    }

    public String matchDegree(Element ele) {
        String degree = "...";
        if (ele.getElementsMatchingOwnText("研究生").size() > 0) {
            return "研究生";
        }
        if (ele.getElementsMatchingOwnText("本科").size() > 0) {
            return "本科";
        }
        if (ele.getElementsMatchingOwnText("大专").size() > 0) {
            return "大专";
        }
        return degree;
    }

    public String matchDegree(String content) {
        if (content.contains("研究生")) {
            return "研究生";
        }
        if (content.contains("本科")) {
            return "本科";
        }
        if (content.contains("大专")) {
            return "大专";
        }
        if (content.contains("中专")) {
            return "中专";
        }
        return "";
    }

    protected Date convert2Date(String format, String string) {
        Date date = null;
        if ("至今".equals(string) || "今".equals(string)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
            string = "2099.12";
            try {
                date = sdf.parse(string);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            return date;
        } else {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat(format);
                date = sdf.parse(string);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
            return date;
        }
    }


    public Map<String, Object> tikaAnalyResume(String content){
        List<TikaResumeModule> list = new ArrayList<TikaResumeModule>();
        List<String> linList = new ArrayList<String>();
        int count = 0;
        /*
         * resumeNumber
         * 智联 : 1
         * 前程 : 2
         *
         * */

        int  resumeNumber = 1;
        try {
            String[] arry = content.replaceAll("\\t", "").split("\\n");
            for (String str : arry) {
                // 除去特殊空格,半角空格.
                str = str.trim().replaceAll(" ", "").replaceAll(" ", "").replaceAll("&nbsp;", "");
                if (!StringUtils.isEmpty(str)) {
                    switch (str) {
                        case "职业意向":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.INTENTION,count);
                            resumeNumber = resumeNumber==1? 3:resumeNumber;
                            break;
                        case "求职意向":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.INTENTION,count);
                            break;
                        case "自我评价":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.INTRODUCE,count);
                            break;
                        case "工作经历":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.WORK_EXP,count);
                            break;
                        case "工作经验":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.WORK_EXP,count);
                            resumeNumber = resumeNumber==1? 2:resumeNumber;
                            break;
                        case "项目经历":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.PROJECT_EXP,count);
                            break;
                        case "项目经验":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.PROJECT_EXP,count);
                            resumeNumber = resumeNumber == 1 ? 2 : resumeNumber;
                            break;
                        case "工作经历详细介绍":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.PROJECT_EXP,count);
                            resumeNumber = resumeNumber == 1 ? 4 : resumeNumber;
                            break;
                        case "教育经历":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.EDUCATION_EXP,count);
                            break;
                        case "教育背景":
                            list = addListOfTikaResumeModuleDTO(list,TikaResumeModule.EDUCATION_EXP,count);
                            break;
                        case "联系方式":
                            list = addListOfTikaResumeModuleDTO(list, TikaResumeModule.CONTACT_INFO, count);
                            resumeNumber = resumeNumber == 1 ? 4 : resumeNumber;
                            break;
                        case "培训经历":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "证书":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "最近工作":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            resumeNumber = resumeNumber==1? 2:resumeNumber;;
                            break;
                        case "最高学历/学位":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "简历内容":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "在校情况":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "技能特长":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        case "MatchingScore:":
                            list = addListOfTikaResumeModuleDTO(list, null, count);
                            break;
                        default:
                            break;
                    }
                    linList.add(str);
                    count++;
                }
            }
            Map<String, Object> map = new HashMap<>();
            map.put("linList", linList);
            map.put("moduleList", list);
            map.put("resumeNumber", resumeNumber);
            return map;
        }catch (Exception e){
            log.error("Tika简历解析异常:", e);
            return null;
        }
    }

    /**
     * 将简历解析各模块位置信息放入集合里面.
     *
     * @param list
     *            存放简历解析各模块起始,结束位置
     * @param moduleName
     *            模块名称
     * @param count
     *            模块起始下标
     * @return
     */
    public List<TikaResumeModule> addListOfTikaResumeModuleDTO(List<TikaResumeModule> list,
                                                                         String moduleName, Integer count) {
        if (list == null) {
            return null;
        }
        // 设置上一个模块结束下标
        if (list.size() > 0) {
            list.get(list.size() - 1).setEnd(count);
        }
        if (StringUtils.isNotEmpty(moduleName)) {
            list.add(new TikaResumeModule(moduleName, count));
        }
        return list;
    }

}

enum SourceType {
    BOSS, ZHAOPIN, JOB_51, CJOL
}

