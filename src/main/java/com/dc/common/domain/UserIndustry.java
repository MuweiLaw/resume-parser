package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户行业类
 * @ClassName: UserIndustry
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/10 16:31
 */
@Data
@ToString
public class UserIndustry implements Serializable {

    private static final long serialVersionUID = -7673251418174518472L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 行业Id
     */
    private String industryId;
    /**
     * 行业名
     */
    private String industry;
    /**
     * 行业的父级ID
     */
    private String industryParentId;
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
