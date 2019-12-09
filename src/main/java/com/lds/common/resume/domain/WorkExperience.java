package com.lds.common.resume.domain;


import com.lds.common.resume.annatations.Label;
import lombok.Data;
import lombok.ToString;

/**
 * @version v1.0.0
 * @description 个人工作经历实体类
 * @since 1.0
 */
@Data
@ToString
public class WorkExperience {

    @Label(keys ="开始时间")
    private String startDate;
    @Label(keys ="结束时间")
    private String endDate;
    //公司
    @Label(keys ="公司")
    private String company;
    //所属行业
    @Label(keys ="所属行业")
    private String currentIndustry;
    //职位名称
    @Label(keys ="职位名称")
    private String jobTitle;
    //职位类别
    @Label(keys ="职位类别")
    private String jobFunction;
    @Label(keys ="所属部门")
    private String department;
    //月薪
    @Label(keys ="月薪")
    private double salary;
    //详细描述
    @Label(keys ="详细描述")
    private String description;

    public WorkExperience() {
    }
}
