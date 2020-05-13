package com.dc.common.util.resume.domain;


import com.dc.common.util.resume.annatations.Label;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @description 个人教育经历
 * @since 1.0
 */
@Data
@ToString
public class Education {
    //开始时间
    @Label(keys ="开始时间")
    private Date startDate;
    //结束时间
    @Label(keys ="结束时间")
    private Date endDate;
    //学校
    @Label(keys ="学校")
    private String university;
    //专业
    @Label(keys ="专业")
    private String major;
    //学历
    @Label(keys ="学历")
    private String degree;
    //描述
    @Label(keys ="描述")
    private String description;

}
