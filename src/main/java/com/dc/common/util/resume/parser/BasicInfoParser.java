package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.BasicInfo;
import com.dc.common.util.ChineseNumToArabicNumUtil;
import com.dc.common.util.StringUtils;
import com.dc.resume.service.Resource;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        basicInfo.setAnnualIncome(matchAnnualIncome());
        basicInfo.setAllowance(matchAllowance());
        basicInfo.setCommission(matchCommission());
        basicInfo.setBasePay(matchBasePay());
        basicInfo.setJobStatus(matchJobStatus());
        basicInfo.setHeight(matchHeight());
        basicInfo.setMail(matchEmail());
        basicInfo.setPhone(matchPhone());
        basicInfo.setSex(matchSex());
        Date birthday = matchBirthday();
        basicInfo.setBirthday(birthday);
        basicInfo.setAge(Integer.parseInt(matchAge(root)));
        basicInfo.setCurrentLocation(matchCurrentLocation());
        basicInfo.setDegree(matchDegree(root));
        basicInfo.setMaritalStatus(matchMaritalStatus());
        basicInfo.setRegisterResidency(matchRegisterResidency());
        //卓聘
        Elements zhuoPinEles = root.getElementsByAttributeValue("width", "582");
        if (zhuoPinEles.size() > 0) {
            basicInfo.setName(getBasicInfoByZhuoPin(zhuoPinEles, 0));
            String[] arr = getBasicInfoByZhuoPin(zhuoPinEles, 1).split(" \\| ");

            String[] arr1 = arr[3].split(" ");
            if (arr1[1].contains("年工作经验")) {
                basicInfo.setYearOfWorkExperience(Integer.valueOf(arr1[0]));
            } else {
                basicInfo.setYearOfWorkExperience(Integer.valueOf(arr1[1]));
            }

        }
        if (!"".equals(matchWorkExperienceLimit())) {
            basicInfo.setYearOfWorkExperience(matchWorkExperienceLimit());
        }

        return basicInfo;
    }

    /**
     * @return
     * @Description: 匹配求职状态
     * @Param
     * @author Murray Law
     * @date 2019/12/20 0:17
     */
    private String matchJobStatus() {
        Elements elements51 = root.getElementsByAttributeValue("style", "color:#000;white-space:nowrap;");
        int elementsRenCai = root.getElementsMatchingOwnText("离职,正在找工作").size();
        int elementsZhiLian = root.getElementsMatchingOwnText("我目前处于离职状态，可立即上岗").size();
        int elementsZhiLian1 = root.getElementsMatchingOwnText("我目前在职，正考虑换个新环境").size();

        if (elements51.size() > 0) {
            return elements51.first().text();
        }
        if (elementsRenCai > 0 || elementsZhiLian > 0) {
            return "目前在找工作";
        }
        if (elementsZhiLian1 > 0 || root.getElementsMatchingOwnText("在职,观望新机会").size() > 0) {
            return "观望工作机会";
        }
        return "离职";
    }

    /**
     * @return Integer
     * @Description: 匹配身高, 仅发现人才热线有对应身高信息
     * @Param
     * @author Murray Law
     * @date 2019/12/20 1:05
     */
    private Integer matchHeight() {
        Integer height = 0;
        Elements heightElements51 = root.getElementsMatchingOwnText("^身高： $");
        Elements heightElementsRenCai = root.getElementsMatchingOwnText("^身高：$");
        if (heightElements51.size() > 0) {
            String s = heightElements51.first().nextElementSibling().text();
            height = Integer.valueOf(s.substring(0, s.length() - 2));
        }
        if (heightElementsRenCai.size() > 0) {
            String s = heightElementsRenCai.first().nextElementSibling().text();
            height = Integer.valueOf(s.substring(0, s.length() - 2));
        }
        return height;
    }

    /**
     * @return Integer
     * @Description: 匹配年薪, 仅51有年薪说明
     * @Param
     * @author Murray Law
     * @date 2019/12/20 1:08
     */
    private Double matchAnnualIncome() {
        String s;
        Elements elements51 = root.getElementsMatchingOwnText("^目前年收入：$");
        if (elements51.size() > 0) {
            if (elements51.first().children().size() == 0) {
                s = elements51.first().parent().child(1).text();
            } else {
                s = elements51.first().child(0).text();
            }
            return Double.valueOf(s.substring(0, s.length() - 2));
        }
        return 0.0;
    }

    /**
     * @return Integer
     * @Description: 匹配基本工资
     * @Param
     * @author Murray Law
     * @date 2019/12/20 1:08
     */
    private Double matchBasePay() {
        Elements Elements51 = root.getElementsMatchingOwnText("^基本工资(税前)：$");
        if (Elements51.size() > 0) {
            String s = Elements51.first().nextElementSibling().text();
            return Double.valueOf(s.substring(0, s.length() - 2));
        }
        return 0.0;
    }

    /**
     * @return Integer
     * @Description: 匹配补贴/津贴
     * @Param
     * @author Murray Law
     * @date 2019/12/20 1:08
     */
    private Double matchAllowance() {
        Elements Elements51 = root.getElementsMatchingOwnText("^补贴/津贴：$");
        if (Elements51.size() > 0) {
            String s = Elements51.first().nextElementSibling().text();
            return Double.valueOf(s.substring(0, s.length() - 2));
        }
        return 0.0;
    }

    /**
     * @return Integer
     * @Description: 匹配奖金/佣金
     * @Param
     * @author Murray Law
     * @date 2019/12/20 1:08
     */
    private Double matchCommission() {
        Elements Elements51 = root.getElementsMatchingOwnText("^奖金/佣金：$");
        if (Elements51.size() > 0) {
            String s = Elements51.first().nextElementSibling().text();
            return Double.valueOf(s.substring(0, s.length() - 2));
        }
        return 0.0;
    }

    /**
     * @return java.lang.String
     * @Description: 匹配姓名
     * @author Murray Law
     * @date 2019/12/12 15:35
     */
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
                return nameElement.text().split("\\(")[0];
            }
        }
        //智联招聘
        Elements zhiLianEles = root.getElementsByAttributeValue("style", "text-align:left;tab-stops:366.0pt");
        if (zhiLianEles.size() > 0) {
            return zhiLianEles.get(0).text();
        }
        //人才热线
        Elements RenCaiEles = root.getElementsByAttributeValue("style", "padding:10px 0 10px 25px; font:24px/20px Arial; color:#333333;");
        if (RenCaiEles.size() > 0) {
            return RenCaiEles.get(0).text().split("\\(")[0];
        }
        //boss
        Elements names = root.getElementsMatchingOwnText("姓名：");
        if (names.size() > 0) {
            return names.first().text().replace("姓名：", "");
        }
        Elements nameByZhiLian = root.getElementsByAttributeValue("style", "text-align:left;");
        if (nameByZhiLian.size() > 0) {
            return nameByZhiLian.text();
        }
        return "";
    }

    /**
     * @return java.lang.String
     * @Description: 匹配电话号码
     * @author Murray Law
     * @date 2019/12/12 15:35
     */
    private String matchPhone() {
        Elements elements = root.getElementsByAttributeValue("style", "color:#000;white-space:nowrap;");
        if (elements.size() > 0) {
            return elements.last().text();
        }
        elements = root.getElementsMatchingOwnText("手机：");
        if (elements.size() > 0) {
            String s = elements.first().text().split(" ")[0].replace("手机：", "");
            if (s.length() == 11) {
                return s;
            } else {
                Matcher matcher = Pattern.compile("1[3-9]{2}((\\d{8})|(\\*\\*\\*\\*\\d{4}))").matcher(html);
                if (matcher.find()) {
                    return matcher.group();
                }
            }

        }
        //人才热线
        elements = root.getElementsMatchingOwnText("手机号码：");
        if (elements.size() > 0) {
            return elements.first().nextElementSibling().text();
        }
        String phone = "";
        String phoneRegEx = "1[3-9]{2}((\\d{8})|(\\*\\*\\*\\*\\d{4}))";
        Matcher matcher = Pattern.compile(phoneRegEx).matcher(html);
        if (matcher.find()) {
            phone = matcher.group();
        }
        return phone;
    }

    private String matchEmail() {
        String emailRegEx = "(\\S{0,}[0-9]{0,}|(\\w{0,}\\*\\*\\*\\*))@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}";
        Matcher matcher = Pattern.compile(emailRegEx).matcher(root.text());
        String email = "";
        if (matcher.find()) {
            email = matcher.group();
        }
        String[] arr = email.split("：");
        if (arr.length > 1) {
            email = arr[1];
        }
        return email;
    }

    /**
     * @return java.lang.String
     * @Description: 匹配工作经验
     * @author Murray Law
     * @date 2019/12/12 15:36
     */
    private Integer matchWorkExperienceLimit() {
        //智联1
        Elements elesByZhiLian = root.getElementsByAttributeValue("style", "width:435.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;\r\n" +
                "border-right:none;border-top:none;border-bottom:none;");
        Elements elesByZhiLian1 = root.getElementsByAttributeValue("style", "width:435.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;\n" +
                "border-right:none;border-top:none;border-bottom:none;");
        if (elesByZhiLian.size() > 0) {
            return Integer.valueOf(elesByZhiLian.text().split(" ")[3].replace("年工作经验", ""));
        }
        if (elesByZhiLian1.size() > 0) {
            return Integer.valueOf(elesByZhiLian1.text().split(" ")[3].replace("年工作经验", ""));
        }
        //人才
        Elements renCaiEle = root.getElementsByAttributeValue("style", "font:14px/20px Arial; color:#333333;");
        if (renCaiEle.size() > 0) {
            return Integer.valueOf(renCaiEle.last().text().split("\\.")[0]);
        }
        String workExperienceLimit = "";
        String workExperienceLimitRegEx = "(\\d{1,2})(年工作经验|年 年工作经验)";
        Matcher matcher = Pattern.compile(workExperienceLimitRegEx).matcher(html);
        if (matcher.find()) {
            return Integer.valueOf(matcher.group(1));
        }
        workExperienceLimitRegEx = "工作经验：";
        Elements eles = root.getElementsMatchingOwnText(workExperienceLimitRegEx);
        if (eles.size() > 0) {
            workExperienceLimit = eles.first().text().replace("工作经验：", "").replace("年", "");
            if (ChineseNumToArabicNumUtil.isChineseNum(workExperienceLimit)) {
                return ChineseNumToArabicNumUtil.chineseNumToArabicNum(workExperienceLimit);
            }
        }
        return 0;
    }

    private String matchMaritalStatus() {
        if (root.getElementsMatchingOwnText("已婚").size() > 0) {
            return "已婚";
        }
        if (root.getElementsMatchingOwnText("未婚").size() > 0) {
            return "未婚";
        }
        if (root.getElementsMatchingOwnText("离婚").size() > 0) {
            return "离婚";
        }
        if (root.getElementsMatchingOwnText("离异").size() > 0) {
            return "离异";
        }
        if (root.getElementsMatchingOwnText("丧偶").size() > 0) {
            return "丧偶";
        }
        return "--";
    }

    /**
     * 51job,智联,人才热线
     * boss 没有
     *
     * @return 当前位置
     */
    private String matchCurrentLocation() {
        Elements currentLocationByZhiLian = root.getElementsMatchingOwnText("现居住地：");
        if (currentLocationByZhiLian.size() > 0) {
            return currentLocationByZhiLian.text().split(" \\| ")[0].replace("现居住地：", "");
        }
        Elements currentLocationByZhiLian1 = root.getElementsByAttributeValue("style", "font-size:9.0pt;\n" +
                "  font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;\n" +
                "  mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:\n" +
                "  Calibri;mso-hansi-theme-font:minor-latin");
        if (currentLocationByZhiLian1.size() > 0) {
            return currentLocationByZhiLian1.text().split(" \\| ")[0].replace(" 现居住地：", "");
        }
        //卓聘
        Elements name = root.getElementsByAttributeValue("style", "font-size: 24px; line-height: 44px; font-family: SimHei");
        if (name.size() > 0) {
            return name.first().parent().nextElementSibling().nextElementSibling().text();
        }
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
        //人才热线
        Elements elementsByRenCai = root.getElementsMatchingOwnText("^目前所在地：$");
        if (elementsByRenCai.size() > 0) {
            return elementsByRenCai.first().nextElementSibling().text();
        }

        String location = Resource.getAtMost3Location(html);
        if (StringUtils.isNotBlank(location)) {
            return location;
        }
        return "";
    }

    private String matchAge(Element root) {
        //51job
        String ageRegEx = "\\d{2}岁|(\\d{2} 岁)";
        String age = "0";
        Matcher matcher = Pattern.compile(ageRegEx).matcher(html);
        if (matcher.find()) {
            age = matcher.group();
            if (age.indexOf("岁") > -1) {
                return age.replaceAll("岁", "").replace(" ", "");
            }
        }
        //boss
        Elements eles = root.getElementsMatchingOwnText("年龄：");
        if (eles.size() > 0) {
            return eles.first().text().replace("年龄：", "");
        }//智联
        Elements elesByZhiLian = root.getElementsByAttributeValue("style", "width:435.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;\r\n" +
                "border-right:none;border-top:none;border-bottom:none;");
        Elements elesByZhiLian1 = root.getElementsByAttributeValue("style", "width:435.0000pt;padding:0.0000pt 5.4000pt 0.0000pt 5.4000pt ;border-left:none;\n" +
                "border-right:none;border-top:none;border-bottom:none;");
        if (elesByZhiLian.size() > 0) {
            return elesByZhiLian.text().split(" ")[1].replaceAll("岁", "");
        }
        if (elesByZhiLian1.size() > 0) {
            return elesByZhiLian1.text().split(" ")[1].replaceAll("岁", "");
        }
        return "0";
    }

    private Date matchBirthday() {
        //智联2.0
        Elements zhiLian = root.getElementsByAttributeValue("style", "mso-spacerun:'yes';font-family:宋体;mso-ascii-font-family:Calibri;\n" +
                "mso-hansi-font-family:Calibri;font-weight:bold;font-size:9.0000pt;\n" +
                "mso-font-kerning:1.0000pt;");
        if (zhiLian.size() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
            try {
                return sdf.parse(zhiLian.first().text().split(" ")[2].replace("(", "").replace(")", ""));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }//智联2.1
        Elements zhiLian1 = root.getElementsByAttributeValue("style", "mso-spacerun:'yes';font-family:宋体;mso-ascii-font-family:Calibri;\r\n" +
                "mso-hansi-font-family:Calibri;font-weight:bold;font-size:9.0000pt;\r\n" +
                "mso-font-kerning:1.0000pt;");
        if (zhiLian1.size() > 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");
            try {
                return sdf.parse(zhiLian1.first().text().split(" ")[2].replace("(", "").replace(")", ""));
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }
        //51job
        String birthdayRegEx = "(\\d{4}年\\d{1,2}月\\d{1,2}日)";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Matcher matcher = Pattern.compile(birthdayRegEx).matcher(html);
        if (matcher.find()) {
            try {
                return sdf.parse(matcher.group());
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }
        }

        birthdayRegEx = "(\\d{4}年\\d{1,2}月)";
        sdf = new SimpleDateFormat("yyyy年MM月");
        matcher = Pattern.compile(birthdayRegEx).matcher(html);
        if (matcher.find()) {
            if (matcher.find()) {
                try {
                    return sdf.parse(matcher.group());
                } catch (ParseException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
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

    /**
     * @return java.lang.String
     * @Description:
     * @Param []
     * @author Murray Law
     * @date 2019/12/24 0:33
     */
    private String matchRegisterResidency() {
        //智联
        Elements registerResidencyByZhiLian1 = root.getElementsMatchingOwnText("户口：");
        if (registerResidencyByZhiLian1.size() > 0) {
            String[] arr = registerResidencyByZhiLian1.text().split(" \\| ");
            if (arr.length > 1) {
                return arr[1].replace("户口：", "");
            }
            return registerResidencyByZhiLian1.text().replace("户口：", "");
        }
        //人才热线
        Elements registerResidencyByRenCai = root.getElementsMatchingOwnText("^户口所在地：$");
        if (registerResidencyByRenCai.size() > 0) {
            return registerResidencyByRenCai.first().nextElementSibling().text();
        }
        return "";
    }

    /**
     * @return org.jsoup.nodes.Element
     * @Description: 根据子信息的索引[i]从卓聘个人信息模板elements中获取子信息文本
     * @Param [i]
     * @author Murray Law
     * @date 2019/12/12 15:50
     */
    private String getBasicInfoByZhuoPin(Elements elements, int i) {
        return elements.get(0).child(0).child(0).child(i).text();

    }
}
