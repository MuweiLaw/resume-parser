package com.dc.framework.dao;

import com.dc.framework.page.Page;
import com.dc.framework.page.PageContext;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wx
 * @version 1.0.0
 * @className EntityDao
 * @description 实体CRUD DAO接口
 * @date 2019/12/13 16:04
 */
public interface EntityDao<E, ID extends Serializable> {

    /**
     * 新增一个实体
     *
     * @param entity
     */
    public int insert(E entity);

    /**
     * 更新一个实体
     *
     * @param entity
     */
    public int update(E entity);

    /**
     * 删除一个或多个实体
     *
     * @param entities
     */
    public int delete(E... entities);

    /**
     * 删除一个或多个实体
     *
     * @param ids 实体ID集
     */
    public int deleteById(ID... ids);

    /**
     * 根据实体ID查找实体
     *
     * @param id
     * @return E
     */
    public E findById(ID id);

    /**
     * 分页查询
     *
     * @param fp 分页请求参数
     * @return Page<E>
     */
    public Page<E> findPage(PageContext fp);

    /**
     * 查找所有实体
     *
     * @return List<E>
     */
    public List<E> findAll();

    /**
     * 根据分页请求参数查询实体集
     *
     * @param fp
     * @return List<E>
     */
    public List<E> findBy(PageContext fp);

    /**
     * 根据Map参数查询实体
     *
     * @param parameter
     * @return List<E>
     */
    public List<E> findBy(Map<?, ?> parameter);
}

