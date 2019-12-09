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
     * @Description: //TODO
     * @author Murray Law
     * @date 2019/12/5 17:56
     */
    public CareerObjective parse() {
//        职业目标
        CareerObjective careerObjective = new CareerObjective();
//
        careerObjective.setExpectingIndustry(matchExpectingInsuatry());
        careerObjective.setExpectingSalary(matchExpectingSalary());
        careerObjective.setExpectingPosition(matchExpectingPosition());
        careerObjective.setExpectingLocation(matchExpectingLocation());
        careerObjective.setHiredate(matchHiredate());

        return careerObjective;
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: //TODO 返回期望职能
     * @author Murray Law
     * @date 2019/12/6 14:01
     */
    private String matchExpectingInsuatry() {
        String industry = "";
        StringBuffer expectingIndustry = new StringBuffer();//期待行业
        Elements industrys = root.getElementsMatchingOwnText("求职意向");
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
        Elements elements = root.getElementsMatchingOwnText("行业：");
        if (elements.size() > 0) {
            return elements.get(0).nextElementSibling().text();
        }
        return "";
    }


    /**
     * @return java.lang.String
     * @Param []
     * @Description: //TODO 返回期望薪资
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
        return root.getElementsMatchingOwnText("期望薪资：").get(0).nextElementSibling().text();
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: //TODO 返回期望职位
     * @author Murray Law
     * @date 2019/12/6 13:59
     */
    private String matchExpectingPosition() {
        return Job.getJobTitles(content);
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: //TODO
     * @author Murray Law
     * @date 2019/12/6 15:07
     */
    private String matchExpectingLocation() {
        String location = Location.getOneLocation(content);
        if (StringUtils.isNotBlank(location)) {
            return location;
        }
        return root.getElementsMatchingOwnText("地点：").get(0).nextElementSibling().text();
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: 到岗时间
     * @author Murray Law
     * @date 2019/12/8 22:12
     */
    private String matchHiredate() {
        Elements elements = root.getElementsMatchingOwnText("到岗时间：");
        if (elements.size() > 0) {
            return elements.get(0).nextElementSibling().text();
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: //TODO 返回期望工作类型
     * @author Murray Law
     * @date 2019/12/8 22:57
     */
    private String matchJobType() {
        Elements elements = root.getElementsMatchingOwnText("工作类型：");
        if (elements.size() > 0) {
            return elements.get(0).nextElementSibling().text();
        }
        return "";
    }

    //    期待工作地点内部类
    static class Hiredate {
        public static final Set<String> HIREDATE = new TreeSet<>();

        static {
            HIREDATE.add("随时");
            HIREDATE.add("1周内");
            HIREDATE.add("1个月内");
            HIREDATE.add("3个月内");
            HIREDATE.add("待定");
        }
    }
}
