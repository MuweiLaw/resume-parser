package com.lds.common.resume.parser;

import com.lds.common.resume.domain.BasicInfo;
import com.lds.common.resume.util.StringUtils;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author wx
 * @version 1.0.0
 * @className BasicInfoParser
 * @description 基础信息解析
 * @date 2019/12/6 16:22
 */
public class BasicInfoParser extends BaseParser {

    public BasicInfoParser(String content) {
        super(content);
    }

    public BasicInfo parse() {
        BasicInfo basicInfo = new BasicInfo();
        basicInfo.setName(matchName());
        basicInfo.setMail(matchEmail());
        basicInfo.setPhone(matchPhone());
        basicInfo.setSex(matchSex());
        String birthday = matchBirthday(root);
        basicInfo.setBirthday(birthday);
        basicInfo.setAge(Integer.parseInt(matchAge(root)));
        basicInfo.setCurrentLocation(matchCurrentLocation());
        basicInfo.setDegree(matchDegree(root));
        basicInfo.setMaritalStatus(matchMaritalStatus());
        basicInfo.setYearOfWorkExperience(matchWorkExperienceLimit());
        return basicInfo;
    }

    private String matchName() {
        //51job
        Elements nameElements = root.getElementsByClass("name");
        if (nameElements.size() > 0) {
            Element nameElement = nameElements.first();
            Elements spans = nameElement.getElementsByTag("span");
            if (spans.size() > 0) {
                for (int i = 0; i < spans.size(); i++) {
                    spans.get(i).remove();
                }
                return nameElement.text();
            }
        }
        //boss
        Elements names = root.getElementsMatchingOwnText("姓名：");
        if (names.size() > 0) {
            return names.first().text().replace("姓名：", "");
        }
        //智联招聘
        Elements tables = root.getElementsByTag("table");
        if(tables.size() > 0){
            String nameRegEx = "^[\\u4e00-\\u9fa5]{2,5}";
            String firstText = tables.first().text();
            Matcher matcher = Pattern.compile(nameRegEx).matcher(firstText);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return "";
    }

    private String matchPhone() {
        String phone = "";
        String phoneRegEx = "1[3-9]{2}((\\d{8})|(\\*\\*\\*\\*\\d{4}))";
        Matcher matcher = Pattern.compile(phoneRegEx).matcher(content);
        if (matcher.find()) {
            phone = matcher.group();
        }

        return phone;
    }

    private String matchEmail() {
        String emailRegEx = "(\\w{0,}[0-9]{0,}|(\\w{0,}\\*\\*\\*\\*))@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        Matcher matcher = Pattern.compile(emailRegEx).matcher(root.text());
        String email = "";
        if (matcher.find()) {
            email = matcher.group();
        }
        return email;
    }

    private String matchWorkExperienceLimit() {
        String workExperienceLimit = "";
        String workExperienceLimitRegEx = "(\\d{1,2})(年工作经验|年 年工作经验)";
        Matcher matcher = Pattern.compile(workExperienceLimitRegEx).matcher(content);
        if (matcher.find()) {
            return matcher.group(1);
        }
        workExperienceLimitRegEx = "工作经验：";
        Elements eles = root.getElementsMatchingOwnText(workExperienceLimitRegEx);
        if (eles.size() > 0) {
            return eles.first().text().replace("工作经验：", "").replace("年", "");
        }
        return workExperienceLimit;
    }

    private String matchMaritalStatus() {
        if (root.getElementsMatchingOwnText("已婚").size() > 0) {
            return "已婚";
        }
        if (root.getElementsMatchingOwnText("未婚").size() > 0) {
            return "未婚";
        }
        return "--";
    }

    /**
     * 51job有当前位置
     * boss 没有
     *
     * @return 当前位置
     */
    private String matchCurrentLocation() {
        String currentLocationRegEx = "现居住\\s?[\\u4e00-\\u9fa5]{2,5}";
        Elements eles = root.getElementsMatchingOwnText(currentLocationRegEx);
        if (eles.size() > 0) {
            for (int i = 0; i < eles.size(); i++) {
                Element element = eles.get(i);
                Matcher matcher = Pattern.compile(currentLocationRegEx).matcher(element.text());
                if (matcher.find()) {
                    return matcher.group().replaceAll("现居住", "");
                }
            }
        }
        String location = Location.getAtMost3Location(content);
        if(StringUtils.isNotBlank(location)){
            return location;
        }
        return "";
    }

    private String matchAge(Element root) {
        //51job
        String ageRegEx = "\\d{2}岁|(\\d{2} 岁)";
        String age = "0";
        Matcher matcher = Pattern.compile(ageRegEx).matcher(content);
        if (matcher.find()) {
            age = matcher.group();
            if (age.indexOf("岁") > -1) {
                return age.replaceAll("岁", "").replace(" ","");
            }
        }
        //boss
        Elements eles = root.getElementsMatchingOwnText("年龄：");
        if (eles.size() > 0) {
            return eles.first().text().replace("年龄：", "");
        }
        return "0";
    }

    private String matchBirthday(Element root) {
        //51job
        String birthdayRegEx = "(\\d{4}年\\d{1,2}月\\d{1,2}日)";
        Matcher matcher = Pattern.compile(birthdayRegEx).matcher(content);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    private String matchSex() {
        if (root.getElementsMatchingOwnText("男").size() > 0) {
            return "男";
        }
        if (root.getElementsMatchingOwnText("女").size() > 0) {
            return "女";
        }
        return "男";
    }
}
