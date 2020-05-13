package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户简历详细信息表 lds_user_resume_detail
 *
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
@Data
@ToString
public class UserEducationExperience extends UserEducationExperienceKey implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = 6550233402193716322L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 教育经历Id
     */
    private String educationExpId;

    /**
     * 个人用户Id
     */
    private String userId;

    /**
     * 用户真实姓名
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
     * 学校名称
     */
    private String schoolName;

    /**
     * 教育程度
     */
    private String educationLevel;

    /**
     * 是否全日制：N：否，Y：是
     */
    private String fullTime;

    /**
     * 毕业证编号
     */
    private String graduationCertNo;

    /**
     * 专业
     */
    private String specialty;

    /**
     * 专业描述
     */
    private String specialtyDescription;

    /**
     * 是否有海外留学经历：N：否，Y：是
     */
    private String hasOverseas;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 创建时间
     */
    private String createdDate;

    /**
     * 更新时间
     */
    private String updatedDate;

}