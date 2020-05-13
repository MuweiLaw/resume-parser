package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户等级类
 * @author:MuweiLaw
 * @Date:2019/12/19 11:16
 */
@Data
@ToString
public class UserSkills implements Serializable {

    private static final long serialVersionUID = 3025709477918538557L;
        /**
         * 主键
         */
        private Long idKey;
        /**
         * 技能Id
         */
        private String skillId;
    /**
     * 个人用户Id
     */
    private String userId;
    /**
     * 简历Id
     */
    private String resumeId;
    /**
     * 用户技能
     */
    private String skill;
    /**
     * 技能等级
     */
    private String skillLevel;
    /**
     * 等级证书
     */
    private String certificate;
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
    private Date createdDate;

    /**
     * 更新时间
     */
    private Date updatedDate;
    /**
     * 工作经验Id
     */
    private String WorkExpId;
}
