package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户专业类
 * @ClassName: UserMajor
 * @Version:
 * @Author: Murray Law
 * @Date 2020/1/10 16:30
 */
@Data
@ToString
public class UserMajor implements Serializable {

    private static final long serialVersionUID = 6192055128273336872L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 专业Id
     */
    private String majorId;
    /**
     * 专业名
     */
    private String major;
    /**
     * 专业包含的字符串
     */
    private String majorContain;
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
