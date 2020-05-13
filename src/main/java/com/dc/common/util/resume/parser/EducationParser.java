package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.Education;
import com.dc.common.util.StringUtils;
import com.dc.resume.service.Resource;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Education> parse() {
        List<Education> educations = new ArrayList<>();
        Elements educationEles = root.getElementsMatchingOwnText("^教育经历$");
        if (educationEles.size() > 0) {
            //51job
            Elements educationEle = root.getElementsByAttributeValue("class", "p15");
            if (educationEle.size() > 0) {
                return classOn51job(educationEles);
            }
            //智联
            if (root.getElementsByAttributeValue("width", "710").size() > 0) {
                return zhiLian(educationEles);
            }
            //智联1
            if (root.getElementsByAttributeValue("face", "宋体").size() > 0) {
                return zhiLian1(educationEles);
            }
        }
        //boss\卓聘\人才热线
        educationEles = root.getElementsMatchingOwnText("^教育背景$");
        if (educationEles.size() > 0) {
            paragraphOZhuoPinAndRenCaiAndBoss(educations, educationEles);
        }
        return educations;
    }

    //boss\卓聘\人才热线
    private List<Education> paragraphOZhuoPinAndRenCaiAndBoss(List<Education> educations, Elements educationEles) {
        //卓聘
        if (educationEles.get(0).getElementsByAttributeValue("style", "font-size: 14px;").size() > 0) {
            Education education = new Education();
            Elements nextEles = educationEles.get(0).parent().parent().parent().parent().parent().nextElementSiblings();
            for (Element nextEleByZhuoPin : nextEles) {
                String[] arr = nextEleByZhuoPin.text().split(" \\| ");
                if (arr.length < 4) {
                    break;
                }
                String[] arr1 = arr[0].split(" -- ");
                education.setStartDate(convert2Date("yyyy年MM月", arr1[0]));
                education.setEndDate(convert2Date("yyyy年MM月", arr1[1]));
                education.setUniversity(arr[1]);
                education.setMajor(arr[2]);
                education.setDegree(arr[3]);
                if (arr.length > 4) {
                    education.setDescription(arr[4]);
                }
                educations.add(education);
            }
            return educations;
        }
        //人才热线
        Element educationEle = educationEles.first();
        if (educationEle.getElementsByAttributeValue("style", "font:12px/20px Arial; color:#ffffff; padding:0 25px; height:20px;").size() > 0) {
            Elements educationChildrenEles = educationEle.parent().nextElementSibling().child(0).children();
            educationChildrenEles.stream().forEach(educationChildrenEle -> {
                if (!"".equals(educationChildrenEle.text())) {
                    Element educationGrandsonEles = educationChildrenEle.child(0);
                    Education education = new Education();
                    Element schoolAndDegreeAndTime = educationGrandsonEles.child(0).child(0);
                    education.setUniversity(schoolAndDegreeAndTime.child(0).text());
                    education.setDegree(schoolAndDegreeAndTime.child(1).text());
                    String[] arr = schoolAndDegreeAndTime.child(2).text().split("至");
                    education.setStartDate(convert2Date("yyyy/MM", arr[0]));
                    education.setEndDate(convert2Date("yyyy/MM", arr[1]));
                    education.setMajor(educationGrandsonEles.child(1).text());
                    education.setDescription(educationGrandsonEles.child(2).text());
                    educations.add(education);
                }
            });
            return educations;
        }
        //boss
        Element nextEle;
        nextEle = educationEles.first();
        Pattern compile = Pattern.compile("\\d{2,4}.\\d{1,2}-\\d{2,4}.\\d{1,2}");

        while ((nextEle = nextEle.nextElementSibling()) != null) {
            Education education = null;
            Elements spanEles = nextEle.getElementsByTag("span");
            for (Element span : spanEles) {
                String text = span.text();
                if (StringUtils.isNotBlank(text)) {
                    Matcher matcher = compile.matcher(text);
                    if (matcher.find()) {
                        education = new Education();
                        String[] educationTimeArr = matcher.group().split("-");
                        education.setStartDate(convert2Date("yyyy/MM", educationTimeArr[0]));
                        education.setEndDate(convert2Date("yyyy/MM", educationTimeArr[1]));
                    }
                    if (text.contains("学院") || text.contains("大学")) {
                        education.setUniversity(text);
                    }
                    String degree = super.matchDegree(text);
                    if (StringUtils.isNotBlank(degree)) {
                        education.setDegree(degree);
                    }
                    String major = Resource.getMajor(text);
                    if (StringUtils.isNotBlank(major)) {
                        education.setMajor(major);
                        educations.add(education);
                    }
                }
            }
        }
        return educations;
    }

    //51job和智联
    private List<Education> classOn51job(Elements educationEles) {
        List<Education> educations = new ArrayList<>();
        Element educationEleParent = educationEles.first().parent().nextElementSibling();
        if (!Objects.isNull(educationEleParent)) {
            Elements educationEle = educationEleParent.getElementsByAttributeValue("class", "p15");
            if (educationEle.size() > 0) {
                educationEle.stream().forEach(element -> {
                    Elements tds = element.getElementsByTag("td");
                    if (tds.size() > 0) {
                        Education education = new Education();
                        tds.stream().forEach(td -> {
                            String text = td.text();
                            Elements workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}");
                            if (workTime.size() > 0) {
                                String[] workTimeArr = workTime.text().split("-");
                                education.setStartDate(convert2Date("yyyy/MM", workTimeArr[0]));
                                education.setEndDate(convert2Date("yyyy/MM", workTimeArr[1]));
                            }
                            if (text.contains("学院") || text.contains("大学") || text.contains("学校")) {
                                education.setUniversity(text);
                            }
                            //学历
                            String degree = matchDegree(text);
                            if (StringUtils.isNotBlank(degree)) {
                                education.setDegree(degree);
                            }
                            //专业
                            String major = Resource.getMajor(text);
                            if (StringUtils.isNotBlank(major)) {
                                education.setMajor(major);
                            }
                            Elements mojorEles = td.getElementsByAttributeValue("style", "padding-left:7px;");
                            if (mojorEles.size() > 0) {
                                major = mojorEles.first().text();
                                String[] arr = major.split("\\|");
                                if (arr.length == 2) {
                                    education.setMajor(arr[1]);
                                }
                            }
                            //专业描述
                            if ("专业描述：".equals(td.text())) {
                                education.setDescription(td.nextElementSibling().text());
                            }
                        });
                        educations.add(education);
                    }
                });
            }
        }
        return educations;
    }


    //智联
    private List<Education> zhiLian(Elements educationEles) {
        List<Education> educations = new ArrayList<>();
        Element educationEleParent = educationEles.first().parent().parent().nextElementSibling();
        Elements educationEle = educationEleParent.getElementsByAttributeValue("width", "710");
        if (educationEle.size() > 0) {
            Education education = new Education();
            String[] educationArr = educationEle.first().text().split(" ");
            education.setStartDate(convert2Date("yyyy.MM", educationArr[0]));
            education.setEndDate(convert2Date("yyyy.MM", educationArr[2]));
            education.setUniversity(educationArr[3]);
            education.setMajor(educationArr[4]);
            education.setDegree(educationArr[5]);
            educations.add(education);
            return educations;
        }
        return educations;
    }//智联

    private List<Education> zhiLian1(Elements educationEles) {
        List<Education> educations = new ArrayList<>();
        Elements Eles = educationEles.first().parent().parent().parent().nextElementSibling().child(0).children();
        Eles.forEach(element -> {
            Education education = new Education();
            String[] arr = element.text().split(" ");
            education.setStartDate(convert2Date("yyyy.MM", arr[0]));
            education.setEndDate(convert2Date("yyyy.MM", arr[2]));
            education.setUniversity(arr[3]);
            education.setMajor(arr[4]);
            education.setDegree(arr[5]);
            educations.add(education);
        });

        return educations;
    }
}
