package com.lds.common.resume.domain;


import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Resume {

    //姓名
    private String name;

    //年龄
    private int age;

    //联系电话
    private String phone;

    //邮箱
    private String mail;

    //婚姻状况
    private String maritalStatus;

    //现住地址
    private String currentLocation;

    //戶籍
    private String registerResidency;

    //工作年限
    private String yearOfWorkExperience;

    //工作经历
    private List<WorkExperience> workExperiences;

    //项目经历
    private List<ProjectExperience> projectExperiences;

    //教育经历
    private List<Education> educations;

    //求职意向
    private CareerObjective careerObjective;

}
