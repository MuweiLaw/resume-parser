package com.dc.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dc.common.util.base.LayUi;
import com.dc.common.util.base.PageUtils;
import com.dc.framework.lang.reflect.Reflections;
import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;
import com.dc.framework.dao.EntityDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class EntityServiceBase<E, ID extends Serializable> implements EntityService<E, ID> {

    public abstract EntityDao<E, ID> getEntityDao();

    protected Class<E> entityClass;

    public EntityServiceBase() {

        this.entityClass = Reflections.getSuperClassGenricType(getClass());
    }

    public int delete(E... entities) {

        return getEntityDao().delete(entities);
    }

    public int deleteById(ID... ids) {

        return getEntityDao().deleteById(ids);
    }

    public List<E> findAll() {

        return getEntityDao().findAll();
    }

    public List<E> findBy(Map<?, ?> map) {

        return getEntityDao().findBy(map);
    }

    public E findById(ID id) {
        return getEntityDao().findById(id);
    }

    public Page<E> findPage(PageContext pageContext) {

        return getEntityDao().findPage(pageContext);
    }

    public Class<E> getEntityClass() {

        return entityClass;
    }

    public int insert(E entity) {

        return getEntityDao().insert(entity);
    }

    public int update(E entity) {
        return getEntityDao().update(entity);
    }

    public LayUi getLayUI(@RequestParam Map<String, Object> params, List<E> list) {
        PageContext pageContext = new PageContext();
        int page = 0;
        int limit = 0;
        try {
            page = Integer.parseInt((String) params.get("page"));
            limit = Integer.parseInt((String) params.get("limit"));

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        RowBounds rowBounds = new RowBounds((page - 1) * limit, limit);
        pageContext.setRowBounds(rowBounds);
        pageContext.addParams(params);
        list = findPage(pageContext).getResult();
        int total = findAll().size();
        PageUtils pageUtil = new PageUtils(list, total, limit, page);
        return LayUi.data(pageUtil.getTotalCount(), pageUtil.getList());
    }
}
