package com.dc.framework.page;

import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @version 1.0.0
 * @className Paginations
 * @description 每一页的数据
 * @date 2019/12/13 16:03
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class Paginations {

    public static RowBounds createBound(int pageNo, int pageSize) {
        int offset = (pageNo <= 1) ? 1 : ((pageNo - 1) * pageSize + 1);
        int limit = (pageNo <= 1) ? pageSize : (pageNo * pageSize + 1);
        return new RowBounds(offset, limit);
    }

    public static <E> Page<E> createPage(long totalCount, RowBounds rowBounds, List<E> result) {
        Page<E> p = new Page<E>(totalCount, rowBounds, result);
        return p;
    }

    public static PageContext createContext(Map<?, ?> params, String sortname, String sortvalue,
                                            int pageNo, int pageSize) {
        List<SortInfo> sorts = null;
        if (Strings.isNotBlank(sortname) && Strings.isNotBlank(sortvalue)) {
            sorts = new ArrayList<>();
            sorts.add(new SortInfo(sortname, sortvalue));
        }
        return createContext(params, sorts, pageNo, pageSize);

    }

    public static PageContext createContext(Map<?, ?> params, List<SortInfo> sorts, int pageNo,
                                            int pageSize) {

        return createContext(params, sorts, createBound(pageNo, pageSize));
    }

    public static PageContext createContext(Map<?, ?> params, List<SortInfo> sorts, RowBounds rowBounds) {

        PageContext context = new PageContext();
        context.addParams(params);
        context.addSorts(sorts);
        context.setRowBounds(rowBounds);
        return context;
    }
}
