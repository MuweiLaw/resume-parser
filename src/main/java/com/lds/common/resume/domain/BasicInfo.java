package com.lds.common.resume.domain;

import lombok.Data;
import lombok.ToString;

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

    //性别
    private String sex;

    //出生日期
    private String birthday;

    //学历
    private String degree;

    //工作年限
    private String yearOfWorkExperience;

}
