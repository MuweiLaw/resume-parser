package com.dc.common.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 用户地址实体类
 * @ClassName: UserLocation
 * @Version:  
 * @Author: Murray Law
 * @Date 2020/1/10 16:30
 */
@Data
@ToString
public class UserLocation implements Serializable {

    private static final long serialVersionUID = -8226094653781421175L;
    /**
     * 主键
     */
    private Long idKey;
    /**
     * 地址Id
     */
    private String locationId;
    /**
     * 地址名
     */
    private String location;
    /**
     * 地理位置的上级ID
     */
    private String locationParentId;
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
