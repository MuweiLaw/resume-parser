package com.lds.common.resume.parser;

import com.lds.common.resume.domain.Skills;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 技能/语言的解析类
 * @author:MuweiLaw
 * @Date:2019/12/8 13:27
 */

public class SkillsParser extends BaseParser {
    public SkillsParser(String content) {
        super(content);
    }

    public List<Skills> parse() {
        ArrayList<Skills> list = new ArrayList<>();
//        找到51job的技能特长模块全部元素
        Elements skills51Eles = root.getElementsMatchingOwnText("^技能特长$");
//        找到智联证书模块全部元素
        Elements zhiLianCertificatCeEles = root.getElementsMatchingOwnText("^证书$");
//        找到智联语言能力模块全部元素
        Elements zhiLianLanguageEles = root.getElementsMatchingOwnText("^语言能力$");
//        找到智联专业技能模块全部元素
        Elements zhiLianSkillsEles = root.getElementsMatchingOwnText("^专业技能$");
        //            获取智联证书说明的元素
        if (zhiLianCertificatCeEles.size() > 0) {
            zhiLianCertificatCeEles = zhiLianCertificatCeEles.get(0).parent().parent().nextElementSibling().getElementsByAttributeValue("style", "font-size:9.0pt;font-family:\n  宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:\n  宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;\n  mso-hansi-theme-font:minor-latin");
        }
        //            获取智联语言说明的元素
        if (zhiLianLanguageEles.size() > 0) {
            zhiLianLanguageEles = zhiLianLanguageEles.get(0).parent().parent().nextElementSibling().getElementsByAttributeValue("style", "font-size:9.0pt;\n  font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;\n  mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:\n  Calibri;mso-hansi-theme-font:minor-latin");
        }
        //            获取智联技能说明的元素
        if (zhiLianSkillsEles.size() > 0) {
            zhiLianSkillsEles = zhiLianSkillsEles.get(0).parent().parent().nextElementSibling().getElementsByTag("span");
        }
//        获取51Job的技能列表
        if (skills51Eles.size() > 0) {
            Element educationEleParent = skills51Eles.first().parent().nextElementSibling();
            Elements skillOrCertificateNameEle = educationEleParent.getElementsByAttributeValue("style", "text-align:right;width:120px;font-size:13px;font-weight:bold;color:#666;word-break:break-all;");
            Elements skillProficiencyEle = educationEleParent.getElementsByAttributeValue("class", "skco");
            skillOrCertificateNameEle.stream().forEach(element -> {
                Skills skills = new Skills();
                skills.setSkillOrCertificateName(Jsoup.parse(element.toString()).text());
                list.add(skills);
            });
            String[] arr1 = Jsoup.parse(skillProficiencyEle.toString()).text().split(" ");
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setSkillProficiency(arr1[i]);
            }
            Elements certificateEles = educationEleParent.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}");
            if (certificateEles.size() > 0) {
                if (educationEleParent.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}").size() == 0) {
                    certificateEles.stream().forEach(element -> {
                        Skills skills = new Skills();
                        skills.setCertificateDate(Jsoup.parse(element.toString()).text());
                        skills.setSkillOrCertificateName(element.nextElementSibling().text());
                        list.add(skills);
                    });
                }
            }
        }
//        获取智联的证书列表
        if (zhiLianCertificatCeEles.size() > 0) {
            for (int i = 0; i < zhiLianCertificatCeEles.size(); i++) {
                String[] arr = zhiLianCertificatCeEles.get(i).text().split(" ");
                Skills skills = new Skills();
                skills.setCertificateDate(arr[0]);
                skills.setSkillOrCertificateName(arr[1]);
                list.add(skills);
            }
        }
//        获取智联的语言能力列表
        if (zhiLianLanguageEles.size() > 0) {
            for (int i = 0; i < zhiLianLanguageEles.size(); i++) {
                String[] arr = zhiLianLanguageEles.get(i).text().split("： ");
                Skills skills = new Skills();
                skills.setSkillOrCertificateName(arr[0]);
                skills.setSkillProficiency(arr[1]);
                list.add(skills);
            }
        }

//            获取智联的技能特长列表
        if (zhiLianSkillsEles.size() > 0) {
            for (int i = 0; i < zhiLianSkillsEles.size(); i += 2) {
                String[] arr = zhiLianSkillsEles.get(i).text().split("：");
                Skills skills = new Skills();
                skills.setSkillOrCertificateName(arr[0]);
                skills.setSkillProficiency(arr[1]);
                list.add(skills);
            }

        }
        return list;
    }
}

