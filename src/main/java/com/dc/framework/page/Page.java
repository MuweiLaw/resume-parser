package com.dc.framework.page;

import org.apache.ibatis.session.RowBounds;

import java.util.List;
/**
 * @author wx
 * @version v1.0.0
 * @className Page
 * @description 分页结果对象
 * @date 2019/12/14 20:51
 * @param E
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Page<E> {

    protected List<E> result;
    protected long totalCount;
    protected RowBounds rowBounds;

    public Page() {

    }

    public Page(long totalCount, RowBounds rowBounds, List<E> result) {

        setTotalCount(totalCount);
        setResult(result);
        setRowBounds(rowBounds);
    }

    public List<E> getResult() {

        return result;
    }

    public void setResult(List<E> result) {

        this.result = result;
    }

    public long getTotalCount() {

        return totalCount;
    }

    public void setTotalCount(long totalCount) {

        this.totalCount = totalCount;
    }

    public void setRowBounds(RowBounds range) {

        this.rowBounds = range;
    }

    public RowBounds getRowBounds() {

        return rowBounds;
    }

}

