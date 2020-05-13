package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户职位类
 * @ClassName: UserJob
 * @Version:  
 * @Author: Murray Law
 * @Date 2020/1/10 16:51
 */
@Data
@ToString
public class UserJob implements Serializable {

    private static final long serialVersionUID = 7054514310186092249L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 职位Id
     */
    private String jobId;
    /**
     * 职位名
     */
    private String job;
    /**
     * 职位包含的字符串
     */
    private String jobContain;
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
