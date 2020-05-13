package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户证书表
 * @ClassName: UserCertificates
 * @Version: v1.0.0
 * @Author: Murray Law
 * @Date 2019/12/19 11:42
 */
@Data
@ToString
public class UserCertificates implements Serializable {
    private static final long serialVersionUID = 4936757030606734423L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 证书Id
     */
    private String certificateId;
    /**
     * 个人用户Id
     */
    private String userId;
    /**
     * 简历Id
     */
    private String resumeId;
    /**
     * 用户证书
     */
    private String certificate;
    /**
     * 证书获得时间
     */
    private Date gainDate;
    /**
     * 成绩
     */
    private String level;
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
}
