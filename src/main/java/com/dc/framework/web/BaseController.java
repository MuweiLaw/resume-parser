package com.dc.framework.web;

import com.dc.framework.lang.Strings;
import com.dc.framework.lang.reflect.ClassWrapper;
import com.dc.framework.lang.reflect.Reflections;
import com.dc.framework.page.PageContext;
import com.dc.framework.service.EntityService;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

/**
 * @author wx
 * @version v1.0.0
 * @className BaseController
 * @description 封装基于实体的CRUD基本操作
 * @date 2019/12/15 22:09
 * @Copyright: 2020 www.decheng1024.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public abstract class BaseController<T, ID extends Serializable> extends FindController{

    // -------------------------------------默认Result名称--------------------------
    protected final static String JSON_RESULT = "json";
    protected final static String LIST_RESULT = "list";
    protected final static String EDIT_RESULT = "edit";

    /**
     * 进入新增或者修改时客户提交过来的id请求参数名，默认为'id',子类可以重新定义此名字如:
     *
     * <pre>
     * {
     * 	idName = "你想指定的名字"
     * }
     * </pre>
     */
    protected String idName = "id";

    /**
     * 实体ID集，执行删除时页面提交过来的实体ID集，在页面定义checkbox名字默认为'ids'
     */
    protected String ids;

    /**
     * 对应列表页面的表格分页对象及查询参数
     */
    protected PageContext pageContext;

    /**
     * CRUD实体对象
     */
    protected T entity;

    /**
     * 增、删、改时影响的记录行数
     */
    protected int rows;

    public int getRows() {
        return rows;
    }

    public String getIds() {

        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    /**
     * 执行新增或者保存
     *
     * @return
     */
    @RequestMapping("save")
    public String save() {
        ID id = getIdValue();
        if (id == null || Strings.isEmpty(id.toString())) {
            rows = getEntityService().insert(entity);
        } else {
            rows = getEntityService().update(entity);
        }
        return JSON_RESULT;
    }

    /**
     * 进入新增或者修改页面
     *
     * @return
     */
    @RequestMapping("edit")
    public String edit() {
        return EDIT_RESULT;
    }

    /**
     * 进入新增或者修改页面
     *
     * @return
     */
    @RequestMapping("input")
    public String input() {
        prepareParameter();
        return EDIT_RESULT;
    }

    /**
     * 执行删除动作
     *
     * @return
     */
    @RequestMapping("delete")
    public String delete() {
        if (ids != null) {
            rows = getEntityService().deleteById(
                    (ID[]) Strings.splitTo(ids, Strings.COMMA, getIdType()));
        }
        return JSON_RESULT;
    }

    /**
     * 进入列表页面
     *
     * @return
     */
    @RequestMapping("list")
    public String list() {
        prepareParameter();
        return LIST_RESULT;
    }
    public T getModel() {
        return entity;
    }

    /**
     * 进入新增或者列表页面时会调用此方法子类可重写实现参数初始化等动作
     */
    protected void prepareParameter() {
    }

    /**
     * 返回一个空的实体对象，也可以设置一些默认值(如进入新增页面时)
     *
     * @return
     */
    protected T getEmptyModel() {
        return ClassWrapper.wrap(getEntityService().getEntityClass()).newOne();
    }

    /**
     * 以idName为请求参数名取出请求参数并转换成具体的ID类型的值，子类可以根据需要重写此方法
     *
     * @return
     */
    protected abstract ID getIdValue() ;

    /**
     * 根据泛型类型取得实际的ID类型
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Class<ID> getIdType() {
        return Reflections.getSuperClassGenricType(getClass(), 1);
    }

    /**
     * 返回实体服务接口类
     *
     * @return
     */
    protected abstract EntityService<T, ID> getEntityService();


}
