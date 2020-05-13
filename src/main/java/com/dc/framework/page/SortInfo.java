package com.dc.framework.page;

/**
 * @author wx
 * @version 1.0.0
 * @className SortInfo
 * @description  排序条件
 * @date 2019/12/11 17:55
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class SortInfo {

    private String sortField;
    private String sortValue;

    public SortInfo(String sortField, String order) {

        this.sortField = sortField;
        this.setSortValue(order);
    }

    public String getSortField() {

        return sortField;
    }

    public void setSortField(String sortField) {

        this.sortField = sortField;
    }

    public void setSortValue(String sortValue) {

        this.sortValue = sortValue;
    }

    public String getSortValue() {

        return sortValue;
    }


}

