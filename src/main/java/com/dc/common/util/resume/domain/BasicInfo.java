package com.dc.common.util.resume.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 基础信息
 */
@Data
@ToString
public class BasicInfo {
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
    //祖籍
    private String registerResidency;
    //性别
    private String sex;

    //出生日期
    private Date birthday;

    //学历
    private String degree;

    //工作年限
    private int yearOfWorkExperience;
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
