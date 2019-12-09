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
        Elements skills51Eles = root.getElementsMatchingOwnText("^技能特长$");
        Elements skillsEles = root.getElementsMatchingOwnText("^技能特长$");

        if (skillsEles.size() > 0) {
            Element educationEleParent = skillsEles.first().parent().nextElementSibling();
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
                    return list;

                }
            }
        }
        return list;
    }
}

