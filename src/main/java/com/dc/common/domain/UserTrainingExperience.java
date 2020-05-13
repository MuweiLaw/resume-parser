package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description:
 * @author:MuweiLaw
 * @Date:2019/12/20 18:07
 */
@Data
@ToString
public class UserTrainingExperience implements Serializable {

    private static final long serialVersionUID = 6130634593348336160L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 培训经历Id
     */
    private String trainExpId;
    /**
     * 个人用户Id
     */
    private String userId;
    /**
     * 简历Id
     */
    private String resumeId;
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
    /**
     * 创建时间
     */
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;
}
