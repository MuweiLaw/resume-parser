package com.lds.common.resume.parser;

import com.lds.common.resume.domain.ProjectExperience;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
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
        if (proectExperienceTag.size() > 0) {
            //51job: 获取项目经验标签的下一个元素
            proectExperiencesParent = proectExperienceTag.first().parent().nextElementSibling();
            if (null != proectExperiencesParent) {
                return classParseFor51job(proectExperiencesParent);
            }

            Elements peEles = proectExperienceTag.first().nextElementSiblings();
            ProjectExperience pe = null;
            for (Element ele : peEles) {
                if (ele.text().contains("项目名称")) {
                    pe = new ProjectExperience();
                    pe.setProjectName(ele.text().replace("项目名称","").replace(":",""));
                }
                if(ele.text().contains("项目描述")){
                    pe.setProjectDescription(ele.text().replace("项目描述","").replace(":",""));
                }
                if(ele.text().contains("项目职责")){
                    pe.setDutyDescription(ele.text().replace("项目职责","").replace(":",""));
                    projectExperiences.add(pe);
                }
            }
        }
        return projectExperiences;
    }

    private List<ProjectExperience> classParseFor51job(Element proectExperiencesParent) {
        List<ProjectExperience> projectExperiences = new ArrayList<>();
        Elements tba = proectExperiencesParent.getElementsByAttributeValue("class", "tba");
        if (tba.size() > 0) {
            tba.stream().forEach(ptd -> {
                ProjectExperience projectExperience = new ProjectExperience();
                Elements tds = ptd.getElementsByTag("td");
                tds.stream().forEach(td -> {
                    Elements workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}");
                    if (workTime.size() > 0) {
                        String[] workTimeArr = workTime.text().split("-");
                        projectExperience.setBeginDate(workTimeArr[0]);
                        projectExperience.setEndDate(workTimeArr[1]);
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
                System.out.println("projectExperience = " + projectExperience);
                projectExperiences.add(projectExperience);
            });
        }
        return projectExperiences;
    }
}
