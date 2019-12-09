package com.lds.common.resume.parser;

import com.lds.common.resume.domain.Education;
import com.lds.common.resume.util.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @className EducationParser
 * @description 教育经历解析
 * @date 2019/12/6 14:52
 */
public class EducationParser extends BaseParser {

    public EducationParser(String content) {
        super(content);
    }

    public List<Education> parse(){
        List<Education> educations = new ArrayList<>();
        Elements educationEles = root.getElementsMatchingOwnText("^教育经历$");

        if( educationEles.size() > 0){
            Element educationEleParent = educationEles.first().parent().nextElementSibling();

            standardHtmlParse(educations, educationEleParent);
        }
        return educations;
    }

    private void standardHtmlParse(List<Education> educations, Element educationEleParent) {
        Elements educationEle = educationEleParent.getElementsByAttributeValue("class", "p15");

        if( educationEle.size() > 0){
            educationEle.stream().forEach(element -> {
                Elements tds = element.getElementsByTag("td");
                if( tds.size() > 0){
                    Education education = new Education();
                    tds.stream().forEach( td->{
                        String text = td.text();
                        Elements workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}");
                        if( workTime.size() > 0){
                            String[] workTimeArr = workTime.text().split("-");
                            education.setStartDate(workTimeArr[0]);
                            education.setEndDate(workTimeArr[1]);
                        }
                        if( text.contains("学院") || text.contains("大学") ){
                            education.setUniversity(text);
                        }
                        //学历
                        String degree = matchDegree(text);
                        if( StringUtils.isNotBlank(degree)){
                            education.setDegree(degree);
                        }
                        //专业
                        String major = Major.getMajor(text);
                        if(StringUtils.isNotBlank(major)){
                            education.setMajor(major);
                        }
                    });
                    System.out.println("education = " + education);
                    educations.add(education);
                }
            });
        }
    }
}
