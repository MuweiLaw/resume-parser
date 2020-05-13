package com.dc.common.util.resume.parser;

import com.dc.common.util.resume.domain.WorkExperience;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 工作经验解析
 */
public class WorkExperienceParser extends BaseParser {

    public WorkExperienceParser(String content) {
        super(content);
    }

    /**
     * @return java.util.List<com.dc.common.resume.domain.WorkExperience>
     * @Description: 针对51Job和智联的简历解析
     * @author Murray Law
     * @date 2019/12/11 14:05
     */
    public List<WorkExperience> parse() {
        List<WorkExperience> workExperiences = new ArrayList<>();
        //找到51job的工作经验模块抬头
        Elements workExperiencesElesBy51Job = root.getElementsMatchingOwnText("^工作经验$");
        //获取51Job的工作经验列表
        if (workExperiencesElesBy51Job.size() > 0 && workExperiencesElesBy51Job.first().getElementsByAttributeValue("class", "plate1").size() > 0) {
            Element workExperiencesParentEle = workExperiencesElesBy51Job.get(0).parent().nextElementSibling();
            //第一个工作经验
            Element firstWorkExperiencesParentEle = workExperiencesParentEle.child(0).child(0).child(0).child(0);
            WorkExperience workExperience = getWorkExperienceBy51Job(firstWorkExperiencesParentEle);
            workExperiences.add(workExperience);
            Elements workExperiencesParentEles = firstWorkExperiencesParentEle.nextElementSiblings();
            for (int i = 1; i < workExperiencesParentEles.size(); i += 2) {
                workExperiences.add(getWorkExperienceBy51Job(workExperiencesParentEles.get(i)));
            }
            return workExperiences;
        }
        //找到智联招聘的工作经验抬头
        Elements workExperiencesElesByZhiLian = root.getElementsMatchingOwnText("^工作经历$");
        //获取智联招聘类型1的工作经验列表
        if (workExperiencesElesByZhiLian.size() > 0) {
            if (workExperiencesElesByZhiLian.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0 || workExperiencesElesByZhiLian.first().getElementsByAttributeValue("style", "font-size:15.0pt;font-family:宋体;mso-ascii-font-family:\r\n" +
                    "Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;mso-fareast-theme-font:\r\n" +
                    "minor-fareast;mso-hansi-font-family:Calibri;mso-hansi-theme-font:minor-latin;\r\n" +
                    "background:#D9D9D9;mso-shading:white;mso-pattern:gray-15 auto").size() > 0) {
                Element workExperiencesParentEle = workExperiencesElesByZhiLian.get(0).parent().parent().nextElementSibling();
                while (workExperiencesParentEle.getElementsByAttributeValue("style", "width:100.0%;border-collapse:collapse;border:none;mso-yfti-tbllook:\n" +
                        " 1184;mso-padd54367301ing-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:none;mso-border-insidev:\n" +
                        " none").size() > 0 || workExperiencesParentEle.getElementsByAttributeValue("style", "width:100.0%;border-collapse:collapse;border:none;mso-yfti-tbllook:\r\n" +
                        " 1184;mso-padd54367301ing-alt:0cm 5.4pt 0cm 5.4pt;mso-border-insideh:none;mso-border-insidev:\r\n" +
                        " none").size() > 0) {
                    workExperiences.add(getWorkExperienceByZhiLian(workExperiencesParentEle));
                    workExperiencesParentEle = workExperiencesParentEle.nextElementSibling();
                }
                return workExperiences;
            }
            //获取智联招聘类型2的工作经验列表
            if (workExperiencesElesByZhiLian.first().getElementsByAttributeValue("face", "宋体").size() > 0) {
                Elements elesByZhiLian2Children = workExperiencesElesByZhiLian.first().parent().parent().parent().nextElementSibling().children();
                elesByZhiLian2Children.forEach(element -> {
                    workExperiences.add(getWorkExperienceByZhiLian2(element));
                });
            }
            //找到人才热线的工作经验模块抬头
            if (workExperiencesElesByZhiLian.first().getElementsByAttributeValue("style", "font:12px/20px Arial; color:#ffffff; padding:0 25px; height:20px;").size() > 0) {
                Elements workExperiencesTablesByRenCai = workExperiencesElesByZhiLian.first().parent().nextElementSibling().child(0).children();
                return getWorkExperienceByRenCai(workExperiences, workExperiencesTablesByRenCai);
            }
        }
        //找到卓聘的工作经验模块抬头
        Elements workExperiencesElesByZhuoPin = root.getElementsMatchingOwnText("^工作经验$");
        if (workExperiencesElesByZhuoPin.size() > 0 && workExperiencesElesByZhuoPin.first().getElementsByAttributeValue("style", "font-size: 14px;").size() > 0) {
            Element webzp = workExperiencesElesByZhuoPin.first().parent().parent().parent().parent().parent().nextElementSibling();
            return getWorkExperienceByZhuoPin(workExperiences, webzp);
        }
        return workExperiences;
    }

//    public List<WorkExperience> parse() {
//        List<WorkExperience> workExperiences = new ArrayList<>();
//        Elements workExperienceTag = root.getElementsMatchingOwnText("^工作经验$");
//        if (workExperienceTag.size() == 0) {
//            workExperienceTag = root.getElementsMatchingOwnText("^工作经历$");
//        }
//        Element workExperiencesParent = null;
//        if (workExperienceTag.size() > 0) {
//            workExperiencesParent = workExperienceTag.first().parent().nextElementSibling();
//            if (!Objects.isNull(workExperiencesParent)) {
//                Elements workExperienceEles = workExperiencesParent.getElementsByAttributeValue("class", "p15");
//                if (workExperienceEles.size() > 0) {
//                    return parseByClassOn51job(workExperienceEles);
//                }
//            }
//        }
//        if (!Objects.isNull(sourceType)) {
//            List<Element> tables = new ArrayList<>();
//            Element table = workExperiencesParent.parent().nextElementSibling();
//            while (!Objects.isNull(table) && table.tag().getName().equals("table")) {
//                tables.add(table);
//                table = table.nextElementSibling();
//            }
//            for (Element tb : tables) {
//                WorkExperience wp = new WorkExperience();
//                Elements tds = tb.getElementsByTag("td");
//                for (Element td : tds) {
//                    String text = td.text();
//                    if (StringUtils.isBlank(text)) {
//                        continue;
//                    }
//                    String workTimeRegEx = "\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}";
//                    Matcher matcher = Pattern.compile(workTimeRegEx).matcher(text);
//                    String workTime = "";
//                    if (matcher.find()) {
//                        workTime = matcher.group();
//                    }
//                    matcher = Pattern.compile("\\d{2,4}.\\d{1,2}\\s{1}-\\s{1}至今").matcher(text);
//                    if (matcher.find()) {
//                        workTime = matcher.group();
//                    }
//                    if (StringUtils.isNotBlank(workTime)) {
//                        String[] workTimeArr = workTime.split("-");
//                        wp.setStartDate(workTimeArr[0]);
//                        wp.setEndDate(workTimeArr[1]);
//                        String[] s = text.split(" ");
//                        if (s.length > 3) {
//                            wp.setCompany(s[3]);
//                        }
//                    }
//                    //公司行业
//                    String industry = com.dc.common.resume.parser.Industry.getIndustry(text);
//                    if (StringUtils.isNotBlank(industry)) {
//                        wp.setCurrentIndustry(industry);
//                    }
//                    //职位名称
//                    String jobTitle = Job.getJobTitles(text);
//                    if (StringUtils.isNotBlank(jobTitle)) {
//                        wp.setJobTitle(jobTitle);
//                    }
//                    if (td.text().contains("工作描述")) {
//                        Element workDescEle = td.nextElementSibling();
//                        String workDesc = workDescEle.text();
//                        if (StringUtils.isNotBlank(workDesc)) {
//                            wp.setDescription(workDesc);
//                        }
//                    }
//                }
//                workExperiences.add(wp);
//            }
//        }
//        return workExperiences;
//    }

//    private List<WorkExperience> parseByClassOn51job(Elements workExperienceEles) {
//        List<WorkExperience> workExperiences = new ArrayList<>();
//        Elements tables = workExperienceEles.first().getElementsByTag("table");
//        for (Element table : tables) {
//            WorkExperience wp = new WorkExperience();
//            Elements tds = table.getElementsByTag("td");
//            for (Element td : tds) {
//                Elements workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-\\d{2,4}/\\d{1,2}");
//                if (workTime.size() > 0) {
//                    String[] workTimeArr = workTime.text().split("-");
//                    wp.setStartDate(workTimeArr[0]);
//                    wp.setEndDate(workTimeArr[1]);
//                }
//                workTime = td.getElementsMatchingOwnText("\\d{2,4}/\\d{1,2}-至今");
//                if (workTime.size() > 0) {
//                    String[] workTimeArr = workTime.text().split("-");
//                    wp.setStartDate(workTimeArr[0]);
//                    wp.setEndDate(workTimeArr[1]);
//                }
//                //公司
//                Elements companySpan = td.getElementsByTag("span");
//                if (companySpan.size() > 0 && companySpan.first().getElementsMatchingOwnText("公司").size() > 0) {
//                    wp.setCompany(companySpan.text());
//                }
//                //公司行业
//                String industry = com.dc.common.resume.parser.Industry.getIndustry(td.text());
//                if (StringUtils.isNotBlank(industry)) {
//                    wp.setCurrentIndustry(industry);
//                }
//
//                //部门
//                Elements departmentEle = td.getElementsMatchingOwnText("\\S{2,5}部");
//                if (departmentEle.size() > 0) {
//                    wp.setDepartment(departmentEle.text());
//                }
//                //职位名称
//                String jobTitle = Job.getJobTitles(td.text());
//                if (StringUtils.isNotBlank(jobTitle)) {
//                    wp.setJobTitle(jobTitle);
//                }
//                String jobFunction = Job.getJobFunction(td.text());
//                if (StringUtils.isNotBlank(jobFunction)) {
//                    wp.setJobFunction(jobFunction);
//                }
//                if (td.text().contains("工作描述")) {
//                    Element workDescEle = td.nextElementSibling();
//                    String workDesc = workDescEle.html();
//                    if (StringUtils.isNotBlank(workDesc)) {
//                        wp.setDescription(workDesc);
//                    }
//                }
//            }
//            workExperiences.add(wp);
//        }
//        return workExperiences;
//    }

    private WorkExperience getWorkExperienceBy51Job(Element workExperienceElement) {
        WorkExperience workExperience = new WorkExperience();

        String[] timeArr = workExperienceElement.getElementsByAttributeValue("class", "time").get(0).text().split("-");
        workExperience.setStartDate(convert2Date("yyyy/MM", timeArr[0]));
        workExperience.setEndDate(convert2Date("yyyy/MM", timeArr[1]));
        workExperience.setCompany(workExperienceElement.getElementsByAttributeValue("class", "bold").text());
        String[] arr = workExperienceElement.getElementsByAttributeValue("class", "rtbox").text().split("\\|");
        workExperience.setCurrentIndustry(arr[0]);
        if (arr.length == 2) {
            workExperience.setCompanyNature(arr[1]);
        }
        if (arr.length == 3) {
            workExperience.setCompanySize(arr[1]);
            workExperience.setCompanyNature(arr[2]);
        }
        workExperience.setJobTitle(workExperienceElement.getElementsByAttributeValue("class", "txt3").text());
        workExperience.setDepartment(workExperienceElement.getElementsByAttributeValue("class", "bold txt3").text());
        workExperience.setDescription(workExperienceElement.getElementsByAttributeValue("class", "txt1").text());

        return workExperience;
    }

    //智联
    private WorkExperience getWorkExperienceByZhiLian(Element workExperienceElement) {
        WorkExperience workExperience = new WorkExperience();
        Elements timeAndCompanyAndJobTitleAndSalary = workExperienceElement.getElementsByAttributeValue("style", "font-size:9.0pt;font-family:宋体;mso-ascii-font-family:\n" +
                "  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;\n" +
                "  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;\n" +
                "  mso-hansi-theme-font:minor-latin");
        if (timeAndCompanyAndJobTitleAndSalary.size() == 0) {
            timeAndCompanyAndJobTitleAndSalary = workExperienceElement.getElementsByAttributeValue("style", "font-size:9.0pt;font-family:宋体;mso-ascii-font-family:\r\n" +
                    "  Calibri;mso-ascii-theme-font:minor-latin;mso-fareast-font-family:宋体;\r\n" +
                    "  mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:Calibri;\r\n" +
                    "  mso-hansi-theme-font:minor-latin");
        }
        String[] timeAndCompanyArr = timeAndCompanyAndJobTitleAndSalary.get(0).text().split(" ");
        String[] jobTitleAndSalary = timeAndCompanyAndJobTitleAndSalary.get(1).text().split(" \\| ");
        Elements currentIndustryAndDescription = workExperienceElement.getElementsByAttributeValue("style", "font-size:9.0pt;\n" +
                "  font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;\n" +
                "  mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:\n" +
                "  Calibri;mso-hansi-theme-font:minor-latin");
//        部分简历解析换行符为/r/n
        if (currentIndustryAndDescription.size() == 0) {
            currentIndustryAndDescription = workExperienceElement.getElementsByAttributeValue("style", "font-size:9.0pt;\r\n" +
                    "  font-family:宋体;mso-ascii-font-family:Calibri;mso-ascii-theme-font:minor-latin;\r\n" +
                    "  mso-fareast-font-family:宋体;mso-fareast-theme-font:minor-fareast;mso-hansi-font-family:\r\n" +
                    "  Calibri;mso-hansi-theme-font:minor-latin");
        }
        workExperience.setStartDate(convert2Date("yyyy.MM", timeAndCompanyArr[0]));
        workExperience.setEndDate(convert2Date("yyyy.MM", timeAndCompanyArr[2]));
        workExperience.setCompany(timeAndCompanyArr[3]);
        String[] arr = currentIndustryAndDescription.get(0).text().split(" \\| ");
        workExperience.setCurrentIndustry(arr[0]);
        if (arr.length == 2) {
            workExperience.setCompanyNature(arr[1].split("：")[1]);
        }
        if (arr.length == 3) {
            workExperience.setCompanyNature(arr[1].split("：")[1]);
            workExperience.setCompanySize(arr[2].split("：")[1]);
        }
        workExperience.setJobTitle(jobTitleAndSalary[0]);
        if (jobTitleAndSalary.length > 1) {
            workExperience.setSalary(jobTitleAndSalary[1]);
        }
        workExperience.setDescription(currentIndustryAndDescription.get(2).text());

        return workExperience;
    }

    //智联2
    private WorkExperience getWorkExperienceByZhiLian2(Element workExperienceElement) {
        WorkExperience workExperience = new WorkExperience();
        //遍历tr标签
        workExperienceElement.children().forEach(element -> {
            String[] arr = element.text().split(" ");
            if (arr.length == 6) {
                workExperience.setStartDate(convert2Date("yyyy.MM", arr[0]));
                workExperience.setEndDate(convert2Date("yyyy.MM", arr[2]));
                workExperience.setCompany(arr[3]);
            } else {
                String[] arr1 = element.text().split(" \\| ");
                if (arr1.length == 2) {
                    workExperience.setJobTitle(arr1[0]);
                    workExperience.setSalary(arr1[1]);
                } else {
                    Elements elements = element.getElementsMatchingOwnText("^工作描述：$");
                    if (elements.size() > 0) {
                        workExperience.setDescription(elements.first().parent().parent().nextElementSibling().text());
                    } else workExperience.setCompanyNature(element.text());
                }
            }
        });
        return workExperience;
    }

    private List<WorkExperience> getWorkExperienceByZhuoPin(List<WorkExperience> workExperiences, Element webzp) {
        Elements dateAndName = webzp.getElementsByAttributeValue("style", "font-weight: bold; font-size: 12px");
        Elements descriptions = webzp.getElementsByAttributeValue("style", "font-size: 12px; line-height: 18px; word-break: break-all;");
        WorkExperience workExperience = new WorkExperience();
        while (dateAndName.size() > 0 || descriptions.size() > 0) {
            if (dateAndName.size() > 0) {
                String[] arr = dateAndName.text().split(" \\| ");
                String[] arr1 = arr[0].split(" -- ");
                workExperience.setStartDate(convert2Date("yyyy年MM月", arr1[0]));
                workExperience.setEndDate(convert2Date("yyyy年MM月", arr1[1]));
                workExperience.setCompany(arr[1]);
                workExperience.setJobTitle(arr[2]);
            } else {
                Elements descs = descriptions.first().child(0).children();
                WorkExperience workExperienceCopy = new WorkExperience();
                for (Element desc : descs) {
                    Elements currentIndustry = desc.getElementsMatchingOwnText("行业类别：");
                    if (currentIndustry.size() > 0) {
                        String[] arr = currentIndustry.text().split("：");
                        if (arr.length > 1) {
                            workExperienceCopy.setCurrentIndustry(arr[1]);
                        }
                    }
                    Elements jobFunction = desc.getElementsMatchingOwnText("职位类别：");
                    if (jobFunction.size() > 0) {
                        String[] arr = jobFunction.text().split("：");
                        if (arr.length > 1) {
                            workExperienceCopy.setJobFunction(arr[1]);
                        }
                    }
                    Elements salary = desc.getElementsMatchingOwnText("税前收入（税前）： ");
                    if (salary.size() > 0) {
                        String[] arr = salary.text().split("： ");
                        if (arr.length > 1) {
                            workExperienceCopy.setSalary(salary.text().split("： ")[1]);
                        }
                    }
                    Elements description = desc.getElementsMatchingOwnText("^工作描述：$");
                    if (description.size() > 0) {
                        workExperienceCopy.setDescription(description.first().parent().nextElementSibling().text());
                    }
                }
                workExperienceCopy.setStartDate(workExperience.getStartDate());
                workExperienceCopy.setEndDate(workExperience.getEndDate());
                workExperienceCopy.setJobTitle(workExperience.getJobTitle());
                workExperienceCopy.setCompany(workExperience.getCompany());
                workExperiences.add(workExperienceCopy);
            }
            webzp = webzp.nextElementSibling();
            dateAndName = webzp.getElementsByAttributeValue("style", "font-weight: bold; font-size: 12px");
            descriptions = webzp.getElementsByAttributeValue("style", "font-size: 12px; line-height: 18px; word-break: break-all;");
        }
        return workExperiences;

    }

    private List<WorkExperience> getWorkExperienceByRenCai(List<WorkExperience> workExperiences, Elements workExperiencesTablesByRenCai) {
        workExperiencesTablesByRenCai.stream().forEach(workExperiencesTable -> {
            if (!"".equals(workExperiencesTable.text())) {
                WorkExperience workExperience = new WorkExperience();
                workExperience.setCompany(workExperiencesTable.getElementsByTag("strong").text());
                Elements workExperiencesTableHead = workExperiencesTable.getElementsByAttributeValue("style", "padding:0 30px 0 0;");
                workExperience.setJobTitle(workExperiencesTableHead.get(1).text());
                String[] arr = workExperiencesTableHead.get(2).text().split("至");
                workExperience.setStartDate(convert2Date("yyyy/MM", arr[0]));
                workExperience.setEndDate(convert2Date("yyyy/MM", arr[1].split(" ")[0]));
                workExperience.setSalary(workExperiencesTableHead.get(3).text());
                Elements elements = workExperiencesTable.getElementsByAttributeValue("style", "font:12px/20px Arial; color:#333333;");
                workExperience.setJobFunction(elements.get(2).text());
                workExperience.setCurrentIndustry(elements.get(3).text());
                workExperience.setDescription(workExperiencesTable.getElementsByAttributeValue("style", "font:12px/20px Arial; color:#333333; padding:10px 0 0;").first().text());
                workExperiences.add(workExperience);
            }
        });
        return workExperiences;
    }
}

