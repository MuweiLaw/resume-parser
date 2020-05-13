package com.dc.framework.page;

import org.apache.ibatis.session.RowBounds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @version v1.0.0
 * @className PageContext
 * @description 分页上下人对象
 * @date 2019/12/14 20:51
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class PageContext {

    @SuppressWarnings("unchecked")
    private Map p = new HashMap();
    private boolean usePagination = true;
    private boolean useSort = true;
    private List<SortInfo> sorts = new ArrayList<>();
    private RowBounds rowBounds;

    public RowBounds getRowBounds() {
        return rowBounds;
    }

    public void setRowBounds(RowBounds rowBounds) {
        this.rowBounds = rowBounds;
    }

    @SuppressWarnings("unchecked")
    public Map getP() {
        return p;
    }

    public void addSort(SortInfo sortInfo) {
        sorts.add(sortInfo);
    }

    public void addSorts(List<SortInfo> sortInfo) {
        if (null != sortInfo && sortInfo.size() > 0)
            sorts.addAll(sortInfo);
    }

    public void addSort(String field, String sortvalue) {
        addSort(new SortInfo(field, sortvalue));
    }

    public void removeSort(String sortField) {
        for (SortInfo s : sorts) {
            if (s.getSortField().equalsIgnoreCase(sortField)) {
                sorts.remove(s);
                break;
            }
        }
    }

    public List<SortInfo> getSorts() {
        return sorts;
    }

    @SuppressWarnings("unchecked")
    public void addParam(Object key, Object value) {
        p.put(key, value);
    }

    public void removeParam(Object key) {
        p.remove(key);
    }

    @SuppressWarnings("unchecked")
    public void addParams(Map params) {
        if (null != params && params.size() > 0)
            p.putAll(params);
    }

    public boolean isUsePagination() {
        return usePagination;
    }

    public void setUsePagination(boolean usePaging) {
        this.usePagination = usePaging;
    }

    public boolean isUseSort() {
        return useSort;
    }

    public void setUseSort(boolean useSort) {

        this.useSort = useSort;
    }
}
