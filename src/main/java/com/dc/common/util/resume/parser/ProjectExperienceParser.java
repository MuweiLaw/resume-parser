package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.ProjectExperience;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wx
 * @version 1.0.0
 * @className ProjectExperienceParser
 * @description TODO
 * @date 2019/12/6 17:08
 */
public class ProjectExperienceParser extends BaseParser {

    public ProjectExperienceParser(String content) {
        super(content);
    }

    public List<ProjectExperience> parse() {
        List<ProjectExperience> projectExperiences = new ArrayList<>();
        Elements proectExperienceTag = root.getElementsMatchingOwnText("^项目经验$");
        Element proectExperiencesParent = null;
        //51Job和卓聘
        if (proectExperienceTag.size() > 0) {

            //51Job
            if (proectExperienceTag.first().getElementsByAttributeValue("class", "plate1").size() > 0) {
                //获取项目经验标签的下一个元素
                proectExperiencesParent = proectExperienceTag.first().parent().nextElementSibling();
                if (null != proectExperiencesParent) {
                    return classParseFor51job(projectExperiences, proectExperiencesParent);
                }
            }
            //卓聘
            if (proectExperienceTag.first().getElementsByAttributeValue("style", "font-size: 14px;").size() > 0) {
                proectExperiencesParent = proectExperienceTag.first().parent().parent().parent().parent().parent();
                return classParseForZhuoPin(projectExperiences, proectExperiencesParent);
            }
            //人才热线

            if (proectExperienceTag.first().getElementsByAttributeValue("style", "font:12px/20px Arial; color:#ffffff; padding:0 25px; height:20px;").size() > 0) {
                proectExperiencesParent = proectExperienceTag.first().parent().nextElementSibling().child(0);
                return classParseForRenCai(projectExperiences, proectExperiencesParent);

            }
            Elements peEles = proectExperienceTag.first().nextElementSiblings();
            ProjectExperience pe = null;
            for (Element ele : peEles) {
                if (ele.text().contains("项目名称")) {
                    pe = new ProjectExperience();
                    pe.setProjectName(ele.text().replace("项目名称", "").replace(":", ""));
                }
                if (ele.text().contains("项目描述")) {
                    pe.setProjectDescription(ele.text().replace("项目描述", "").replace(":", ""));
                }
                if (ele.text().contains("项目职责")) {
                    pe.setDutyDescription(ele.text().replace("项目职责", "").replace(":", ""));
                    projectExperiences.add(pe);
                }
            }
        }
        //智联
        proectExperienceTag = root.getElementsMatchingOwnText("^项目经历$");
        if (proectExperienceTag.size() > 0) {
            if (proectExperienceTag.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0 || proectExperienceTag.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\r\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\r\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\r\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0) {
                //智联: 获取项目经验标签的下一个元素
                proectExperiencesParent = proectExperienceTag.first().parent().parent().nextElementSibling();
                if (null != proectExperiencesParent) {
                    return classParseForZhiLian(projectExperiences, proectExperiencesParent);
                }
            }
            if (proectExperienceTag.first().getElementsByAttributeValue("face", "宋体").size() > 0) {
                proectExperiencesParent=proectExperienceTag.first().parent().parent().parent().nextElementSibling();
                return classParseForZhiLian(projectExperiences, proectExperiencesParent);
            }
        }

        return projectExperiences;
    }

    private List<ProjectExperience> classParseFor51job(List<ProjectExperience> projectExperiences, Element
            proectExperiencesParent) {
        Elements tba = proectExperiencesParent.getElementsByAttributeValue("class", "tba");
        if (tba.size() > 0) {
            tba.stream().forEach(ptd -> {
                ProjectExperience projectExperience = new ProjectExperience();
                Elements tds = ptd.getElementsByTag("td");
                tds.stream().forEach(td -> {
                    Elements workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-");
                    if (workTime.size() > 0) {
                        String[] workTimeArr = workTime.text().split("-");
                        projectExperience.setBeginDate(convert2Date("yyyy/MM", workTimeArr[0]));
                        projectExperience.setEndDate(convert2Date("yyyy/MM", workTimeArr[1]));
                        projectExperience.setProjectName(workTime.first().nextElementSibling().text());
                    }
                    Elements companyEles = td.getElementsMatchingOwnText("公司");
                    if (companyEles.size() > 0) {
                        if (null != companyEles.first().nextElementSibling()) {
                            projectExperience.setCompanyName(td.getElementsMatchingOwnText("公司").first().nextElementSibling().text());
                        }
                    }
                    Elements projectEles = td.getElementsMatchingOwnText("项目描述");
                    if (projectEles.size() > 0) {
                        if (null != projectEles.first().nextElementSibling()) {
                            projectExperience.setProjectDescription(projectEles.first().nextElementSibling().html());
                        }
                    }
                    projectEles = td.getElementsMatchingOwnText("工作描述");
                    if (projectEles.size() > 0) {
                        if (null != projectEles.first().nextElementSibling()) {
                            projectExperience.setProjectDescription(projectEles.first().nextElementSibling().html());
                        }
                    }
                    Elements dutyEles = td.getElementsMatchingOwnText("责任描述");
                    if (dutyEles.size() > 0) {
                        if (null != dutyEles.first().nextElementSibling()) {
                            projectExperience.setDutyDescription(dutyEles.first().nextElementSibling().html());
                        }
                    }
                });
                projectExperiences.add(projectExperience);
            });
        }
        return projectExperiences;
    }

    /**
     * @return java.util.List<com.dc.common.util.resume.domain.ProjectExperience>
     * @Param [proectExperiencesParent]
     * @Description: 智联的类解析
     * @author Murray Law
     * @date 2019/12/11 19:56
     */
    private List<ProjectExperience> classParseForZhiLian(List<ProjectExperience> projectExperiences, Element
            proectExperiencesParent) {
        Elements trs = proectExperiencesParent.child(0).children();
        ProjectExperience projectExperience = new ProjectExperience();
        for (Element tr : trs) {
            Elements dateAndName = tr.getElementsMatchingOwnText("\\d{2,4}.\\d{1,2} - ");
            if (dateAndName.size() > 0) {
                String[] dateAndNameArr = dateAndName.text().split(" ");
                projectExperience.setBeginDate(convert2Date("yyyy.MM", dateAndNameArr[0]));
                projectExperience.setEndDate(convert2Date("yyyy.MM", dateAndNameArr[2]));
                projectExperience.setProjectName(dateAndNameArr[3]);
            }
            Elements dutyDescription = tr.getElementsMatchingOwnText("^责任描述：$");
            if (dutyDescription.size() > 0) {
                projectExperience.setDutyDescription(dutyDescription.get(0).parent().parent().nextElementSibling().text());
            }
            Elements projectDescription = tr.getElementsMatchingOwnText("^项目描述：$");
            if (projectDescription.size() > 0) {
                projectExperience.setProjectDescription(projectDescription.get(0).parent().parent().nextElementSibling().text());
                ProjectExperience projectExperience1 = new ProjectExperience();
                projectExperience1.setBeginDate(projectExperience.getBeginDate());
                projectExperience1.setEndDate(projectExperience.getEndDate());
                projectExperience1.setProjectName(projectExperience.getProjectName());
                projectExperience1.setDutyDescription(projectExperience.getDutyDescription());
                projectExperience1.setProjectDescription(projectExperience.getProjectDescription());
                projectExperience1.setBeginDate(projectExperience.getBeginDate());
                projectExperiences.add(projectExperience1);
//                }
            }
        }
        return projectExperiences;
    }

    //卓聘
    private List<ProjectExperience> classParseForZhuoPin(List<ProjectExperience> projectExperiences, Element proectExperiencesParent) {
        ProjectExperience projectExperience = new ProjectExperience();
        //第一个项目经验描述
        Element elementsByZhuoPin = proectExperiencesParent.nextElementSibling();
        //遍历符合条件的项目经验
        while (elementsByZhuoPin.getElementsByAttributeValue("style", "height: 30px; line-height: 30px; font-size: 14px; width: 710px;").size() == 0) {
            Elements dateAndName = elementsByZhuoPin.getElementsByAttributeValue("style", "font-weight: bold; font-size: 12px;");
            if (dateAndName.size() > 0) {
                String[] arr = dateAndName.text().split(" ");
                String[] arr1 = dateAndName.text().split(" \\| ");
                projectExperience.setBeginDate(convert2Date("yyyy年MM月", arr[0]));
                projectExperience.setEndDate(convert2Date("yyyy年MM月", arr[2]));
                projectExperience.setProjectName(arr1[1]);
            } else {
                ProjectExperience projectExperienceCopy = new ProjectExperience();
                Elements elements = elementsByZhuoPin.getElementsMatchingOwnText("^项目描述：$");
                if (elements.size() > 0) {
                    projectExperienceCopy.setProjectDescription(elements.first().parent().nextElementSibling().text());
                }
                elements = elementsByZhuoPin.getElementsMatchingOwnText("^项目职责：$");
                if (elements.size() > 0) {
                    projectExperienceCopy.setDutyDescription(elements.first().parent().nextElementSibling().text());
                }
                projectExperienceCopy.setBeginDate(projectExperience.getBeginDate());
                projectExperienceCopy.setEndDate(projectExperience.getEndDate());
                projectExperienceCopy.setProjectName(projectExperience.getProjectName());
                projectExperiences.add(projectExperienceCopy);
            }
            elementsByZhuoPin = elementsByZhuoPin.nextElementSibling();
        }
        return projectExperiences;

    }

    private List<ProjectExperience> classParseForRenCai(List<ProjectExperience> projectExperiences, Element proectExperiencesParent) {
        proectExperiencesParent.children().stream().forEach(proectExperiencEle -> {
            if (!"".equals(proectExperiencEle.text())) {
                ProjectExperience projectExperience = new ProjectExperience();
                projectExperience.setProjectName(proectExperiencEle.getElementsByTag("strong").text());
                String[] arr = proectExperiencEle.getElementsByTag("span").text().split("至");
                projectExperience.setBeginDate(convert2Date("yyyy/MM", arr[0]));
                projectExperience.setEndDate(convert2Date("yyyy/MM", arr[1]));
                Elements dutyDescription = proectExperiencEle.getElementsMatchingOwnText("^项目职责：$");
                if (dutyDescription.size() > 0) {
                    projectExperience.setDutyDescription(dutyDescription.first().nextElementSibling().text());
                }
                Elements projectDescription = proectExperiencEle.getElementsMatchingOwnText("^项目描述：$");
                if (projectDescription.size() > 0) {
                    projectExperience.setProjectDescription(projectDescription.first().nextElementSibling().text());
                }
                projectExperiences.add(projectExperience);
            }
        });
        return projectExperiences;
    }


}
