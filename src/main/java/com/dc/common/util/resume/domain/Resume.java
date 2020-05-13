package com.dc.common.util.resume.domain;


import lombok.Data;
import lombok.ToString;

import java.util.Date;
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
    private Byte yearOfWorkExperience;

    //工作经历
    private List<WorkExperience> workExperiences;

    //项目经历
    private List<ProjectExperience> projectExperiences;

    //教育经历
    private List<Education> educations;

    //求职意向
    private CareerObjective careerObjective;

    //技能
    private List<Skills> skills;
    //证书
    private List<Certificate> Certificate;
    //自我评价
    private SelfEvaluation selfEvaluation;
    //生日
    private Date birthday;
    //性别
    private String sex;

    //学历
    private String degree;
    //工作状态
    private String jobStatus;
    //身高
    private Integer height;
    //年薪
    private Double annualIncome;
    //基本工资
    private Double basePay;
    //补贴/津贴
    private Double allowance;
    //奖金/佣金
    private Double commission;
}
