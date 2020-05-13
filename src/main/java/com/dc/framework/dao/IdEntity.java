package com.dc.framework.dao;

import java.io.Serializable;

/**
 * ID实体基类。
 * 
 * @param <ID> 实体的ID类型
 */
public class IdEntity<ID extends Serializable> {
    
    private ID id;
    
    public void setId(ID id) {

        this.id = id;
    }
    
    public ID getId() {

        return id;
    }
    
}
