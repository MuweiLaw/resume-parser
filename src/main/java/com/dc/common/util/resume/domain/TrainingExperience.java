package com.dc.common.util.resume.domain;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2019/12/20 18:07
 */
@Data
@ToString
public class TrainingExperience {
    /**
     * 开始时间
     */
    private Date beginDate;
    /**
     * 结束时间
     */
    private Date endDate;
    /**
     * 培训课程
     */
    private String training;
    /**
     * 培训机构
     */
    private String institution;
    /**
     * 培训地点
     */
    private String address;
    /**
     * 培训描述
     */
    private String description;
}
