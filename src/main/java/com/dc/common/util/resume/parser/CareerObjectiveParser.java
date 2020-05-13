package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.CareerObjective;
import com.dc.common.util.StringUtils;
import com.dc.resume.service.Resource;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
     * @return com.dc.common.resume.domain.CareerObjective
     * @Param []
     * @Description:
     * @author Murray Law
     * @date 2019/12/5 17:56
     */
    public CareerObjective parse() {
//        职业目标
        CareerObjective careerObjective = new CareerObjective();
        careerObjective.setExpectingIndustry(matchExpectingInsuatry());
        careerObjective.setExpectingSalary(matchExpectingSalary());
        careerObjective.setExpectingPosition(matchExpectingPosition());
        careerObjective.setExpectingLocation(matchExpectingLocation());
        careerObjective.setHireDate(matchHireDate());
        careerObjective.setJobType(matchJobType());
        careerObjective.setRequireApartment(matchRequireApartment());

        return careerObjective;
    }

    /**
     * @return java.lang.String
     * @Description: 匹配期望职能
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
                industry = Resource.getIndustry(parent.text());
                return industry;
            }
            industry = Resource.getIndustry(industrys.first().text());
            if (StringUtils.isNotBlank(industry)) {
                return industry;
            }

        }
        //51
        Elements elementsBy51Job = root.getElementsMatchingOwnText("^行业：$");
        if (elementsBy51Job.size() > 0) {
            return elementsBy51Job.get(0).nextElementSibling().text();
        }
        //智联
        Elements elementsByZhiLian = root.getElementsMatchingOwnText("^期望从事行业：$");
        if (elementsByZhiLian.size() > 0) {
            return elementsByZhiLian.get(0).parent().parent().nextElementSiblings().text();
        }
        //卓聘
        Elements elementsByZhuoPin = root.getElementsMatchingOwnText("^期望行业：$");
        if (elementsByZhuoPin.size() > 0) {
            return elementsByZhuoPin.get(0).nextElementSiblings().text();
        }
        return "";

    }


    /**
     * @return java.lang.String
     * @Description: // 匹配期望薪资
     * @author Murray Law
     * @date 2019/12/6 14:00
     */
    private String matchExpectingSalary() {
        //卓聘
        Elements expectedSalaryElementsByZhuoPin = root.getElementsMatchingOwnText("^期望薪资（税前）：$");
        if (expectedSalaryElementsByZhuoPin.size() > 0) {
            return expectedSalaryElementsByZhuoPin.get(0).nextElementSibling().text();
        }
        //人才热线
        Elements renCaiEle = root.getElementsByAttributeValue("style", "font:14px/20px Arial; color:#333333;");
        if (renCaiEle.size() > 0) {
            return renCaiEle.first().text();
        }
        //51和部分卓聘
        Elements expectedSalaryElementsBy51Job = root.getElementsMatchingOwnText("^期望薪资：$");
        if (expectedSalaryElementsBy51Job.size() > 0) {
            return expectedSalaryElementsBy51Job.get(0).nextElementSibling().text();
        }
        //智联
        Elements expectedSalaryElementsByZhiLian = root.getElementsMatchingOwnText("^期望月薪：$");
        if (expectedSalaryElementsByZhiLian.size() > 0) {
            String[] arr = expectedSalaryElementsByZhiLian.first().parent().text().split("：");
            if (arr.length > 1) {
                return arr[1];
            } else {
                return expectedSalaryElementsByZhiLian.get(0).parent().parent().nextElementSibling().text();
            }
        }
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
        return "";
    }

    /**
     * @return java.lang.String
     * @Description: // 匹配期望职位
     * @author Murray Law
     * @date 2019/12/6 13:59
     */
    private String matchExpectingPosition() {
        //51
        Elements expectingPositionElementsBy51Job = root.getElementsMatchingOwnText("^职能/职位：$");
        if (expectingPositionElementsBy51Job.size() > 0) {
            return expectingPositionElementsBy51Job.first().nextElementSibling().text();
        }
        //智联
        Elements expectingPositionElementsByZhiLian = root.getElementsMatchingOwnText("^期望从事职业：$");
        if (expectingPositionElementsByZhiLian.size() > 0) {
            return expectingPositionElementsByZhiLian.first().parent().parent().nextElementSibling().text();
        }
        //卓聘
        Elements expectingPositionElementsByZhuoPin = root.getElementsMatchingOwnText("^期望职位：$");
        if (expectingPositionElementsByZhuoPin.size() > 0) {
            return expectingPositionElementsByZhuoPin.first().nextElementSibling().text();
        }
        //人才热线
        Elements expectingPositionElementsByRenCai = root.getElementsMatchingOwnText("^意向岗位：$");
        if (expectingPositionElementsByRenCai.size() > 0) {
            return expectingPositionElementsByRenCai.first().nextElementSibling().text();
        }
        return Resource.getJobTitles(html);
    }

    /**
     * @return java.lang.String
     * @Description: //
     * @author Murray Law
     * @date 2019/12/6 15:07
     */
    private String matchExpectingLocation() {
        //51
        Elements expectingLocationElementBy51Job = root.getElementsMatchingOwnText("^地点：$");
        if (expectingLocationElementBy51Job.size() > 0) {
            return expectingLocationElementBy51Job.get(0).nextElementSibling().text();
        }
        //智联
        Elements expectingLocationElementByZhiLian = root.getElementsMatchingOwnText("^期望工作地区：$");
        if (expectingLocationElementByZhiLian.size() > 0) {
            return expectingLocationElementByZhiLian.get(0).parent().parent().nextElementSibling().text();
        }
        //卓聘
        Elements expectingLocationElementByZhuoPin = root.getElementsMatchingOwnText("^工作地点：$");
        if (expectingLocationElementByZhuoPin.size() > 0) {
            return expectingLocationElementByZhuoPin.get(0).nextElementSibling().text();
        }
        String location = Resource.getOneLocation(html);
        if (StringUtils.isNotBlank(location)) {
            return location;
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Description: 到岗时间
     * @author Murray Law
     * @date 2019/12/8 22:12
     */
    private String matchHireDate() {
        //51Job
        Elements hireDateElementsBy51Job = root.getElementsMatchingOwnText("^到岗时间：$");
        if (hireDateElementsBy51Job.size() > 0) {
            return hireDateElementsBy51Job.first().nextElementSibling().text();
        }
        //智联
        Elements hireDateElementsByZhiLian = root.getElementsMatchingOwnText("^目前状况：$");
        if (hireDateElementsByZhiLian.size() > 0) {
            String[] arr = hireDateElementsByZhiLian.first().parent().text().split("：");
            if (arr.length > 1) {
                return arr[1];
            } else {
                return hireDateElementsByZhiLian.first().parent().parent().nextElementSibling().text();

            }

        }
        //人才热线
        Elements hireDateElementsByRenCai = root.getElementsMatchingOwnText("^可到岗时间：$");
        if (hireDateElementsByRenCai.size() > 0) {
            return hireDateElementsByRenCai.first().nextElementSibling().text();
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Param []
     * @Description: // 匹配期望工作类型
     * @author Murray Law
     * @date 2019/12/8 22:57
     */
    private String matchJobType() {
        //51Job
        Elements JobTypeEementsBy51 = root.getElementsMatchingOwnText("^工作类型：$");
        if (JobTypeEementsBy51.size() > 0) {
            return JobTypeEementsBy51.first().nextElementSibling().text();
        }
        //智联
        Elements JobTypeEementsByZhiLian = root.getElementsMatchingOwnText("^期望工作性质：$");
        if (JobTypeEementsByZhiLian.size() > 0) {
            return JobTypeEementsByZhiLian.first().parent().parent().nextElementSibling().text();
        }
        return "全职";
    }

    private String matchRequireApartment() {
        //人才热线
        Elements requireApartmentElesByRenCai = root.getElementsMatchingOwnText("^提供住房：$");
        if (requireApartmentElesByRenCai.size() > 0) {
            return requireApartmentElesByRenCai.first().nextElementSibling().text();
        }
        return "";
    }
}


