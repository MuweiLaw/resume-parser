package com.lds.common.resume.parser;

import com.lds.common.resume.domain.CareerObjective;
import com.lds.common.resume.util.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 职业目标分析器继承基础类
 */
public class CareerObjectiveParser extends BaseParser {
    /**
     * @return
     * @Param [content]
     * @Description:
     * @author Murray Law
     * @date 2019/12/5 17:56
     */
    public CareerObjectiveParser(String content) {
        super(content);
    }

    /**
     * @return com.lds.common.resume.domain.CareerObjective
     * @Param []
     * @Description:
     * @author Murray Law
     * @date 2019/12/5 17:56
     */
    public CareerObjective parse() {
//        职业目标
        CareerObjective careerObjective = new CareerObjective();
//
//        Elements skills51Eles = root.getElementsMatchingOwnText("^求职意向$");

        careerObjective.setExpectingIndustry(matchExpectingInsuatry());
        careerObjective.setExpectingSalary(matchExpectingSalary());
        careerObjective.setExpectingPosition(matchExpectingPosition());
        careerObjective.setExpectingLocation(matchExpectingLocation());
        careerObjective.setHireDate(matchHireDate());
        careerObjective.setJobType(matchJobType());


        return careerObjective;
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: 返回期望职能
     * @author Murray Law
     * @date 2019/12/6 14:01
     */
    private String matchExpectingInsuatry() {
        String industry = "";
        StringBuffer expectingIndustry = new StringBuffer();//期待行业
        Elements industrys = root.getElementsMatchingOwnText("^求职意向$");
        if (industrys.size() > 0) {
            Element parent = industrys.first().parent().parent();
            if (StringUtils.isNotBlank(parent.tagName()) && parent.tagName().toLowerCase().equals("tbody")) {
                industry = Industry.getIndustry(parent.text());
                return industry;
            }
            industry = Industry.getIndustry(industrys.first().text());
            if (StringUtils.isNotBlank(industry)) {
                return industry;
            }

        }

        Elements elementsBy51Job = root.getElementsMatchingOwnText("行业：");
        Elements elementsByZhiLian = root.getElementsMatchingOwnText("期望从事行业：");

        if (elementsBy51Job.size() > 0) {
            if (elementsByZhiLian.size() > 0) {
                return elementsByZhiLian.get(0).parent().parent().nextElementSiblings().text();
            }
            return elementsBy51Job.get(0).nextElementSibling().text();
        }
        return "";
    }


    /**
     * @return java.lang.String
     * @Param []
     * @Description: // 返回期望薪资
     * @author Murray Law
     * @date 2019/12/6 14:00
     */
    private String matchExpectingSalary() {
        String expectingSalary = "";
        String expectingYearSalaryRegEx = "\\d{1,4}-\\d{1,4}万元/年";

        Elements eles = root.getElementsMatchingOwnText(expectingYearSalaryRegEx);
        if (eles.size() > 0) {
            for (int i = 0; i < eles.size(); i++) {
                Element element = eles.get(i);
                Matcher matcher = Pattern.compile(expectingYearSalaryRegEx).matcher(element.text());
                if (matcher.find()) {
                    return matcher.group();
                }
            }
        }
        Elements expectedSalaryElementsBy51Job = root.getElementsMatchingOwnText("期望薪资：");
        if (expectedSalaryElementsBy51Job.size() > 0) {
            return expectedSalaryElementsBy51Job.get(0).nextElementSibling().text();
        }
        Elements expectedSalaryElementsByZhiLian = root.getElementsMatchingOwnText("期望月薪：");
        if (expectedSalaryElementsByZhiLian.size() > 0) {
            return expectedSalaryElementsByZhiLian.get(0).parent().parent().nextElementSibling().text();
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: // 返回期望职位
     * @author Murray Law
     * @date 2019/12/6 13:59
     */
    private String matchExpectingPosition() {
        String expectingPosition = Job.getJobTitles(content);
        if (!"".equals(expectingPosition)) {
            return expectingPosition;
        }
        Elements expectingPositionElementsBy51Job = root.getElementsMatchingOwnText("职能/职位：");
        if (expectingPositionElementsBy51Job.size() > 0) {
            return expectingPositionElementsBy51Job.get(0).nextElementSibling().text();
        }
        Elements expectingPositionElementsByZhiLian = root.getElementsMatchingOwnText("期望从事职业：");
        if (expectingPositionElementsByZhiLian.size() > 0) {
            return expectingPositionElementsByZhiLian.get(0).parent().parent().nextElementSibling().text();
        }
        return expectingPosition;
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: //
     * @author Murray Law
     * @date 2019/12/6 15:07
     */
    private String matchExpectingLocation() {
        String location = Location.getOneLocation(content);
        if (StringUtils.isNotBlank(location)) {
            return location;
        }
        Elements expectingLocationElementBy51Job = root.getElementsMatchingOwnText("地点：");
        if (expectingLocationElementBy51Job.size() > 0) {
            Elements expectingLocationElementByZhiLian = root.getElementsMatchingOwnText("期望工作地区：");
            if (expectingLocationElementByZhiLian.size() > 0) {
                return expectingLocationElementByZhiLian.get(0).parent().parent().nextElementSibling().text();
            }
            return expectingLocationElementBy51Job.get(0).nextElementSibling().text();
        }

        return "";
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: 到岗时间
     * @author Murray Law
     * @date 2019/12/8 22:12
     */
    private String matchHireDate() {
        Elements hireDateElementsBy51Job = root.getElementsMatchingOwnText("到岗时间：");
        if (hireDateElementsBy51Job.size() > 0) {
            return hireDateElementsBy51Job.get(0).nextElementSibling().text();
        }
        Elements hireDateElementsByZhiLian = root.getElementsMatchingOwnText("目前状况：");
        if (hireDateElementsByZhiLian.size() > 0) {
            return hireDateElementsByZhiLian.get(0).parent().parent().nextElementSibling().text();
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: // 返回期望工作类型
     * @author Murray Law
     * @date 2019/12/8 22:57
     */
    private String matchJobType() {
        Elements JobTypeEementsBy51 = root.getElementsMatchingOwnText("工作类型：");
        if (JobTypeEementsBy51.size() > 0) {
            return JobTypeEementsBy51.get(0).nextElementSibling().text();
        }
        Elements JobTypeEementsByZhiLian = root.getElementsMatchingOwnText("期望工作性质：");
        if (JobTypeEementsByZhiLian.size() > 0) {
            return JobTypeEementsByZhiLian.get(0).parent().parent().nextElementSibling().text();
        }
        return "";
    }

}
