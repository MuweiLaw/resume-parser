package com.dc.common.generator.mapper;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @description: 通用IMapper<M, E, ID>
 *      M: 实体类
 *      E: Example
 *      ID:主键的变量类型
 *
 * @date: 2019-12-15 03:09:43
 */
public interface IMapper<M, E, ID extends Serializable> {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    int countByExample(E example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(E example);

    /** 
     * 根据ID删除
     * @param id 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(ID id);

    /** 
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(M record);

    /** 
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(M record);

    /** 
     * 添加List集合对象所有字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatch(List<M> record);

    /** 
     * 添加List集合对象对应字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatchSelective(List<M> record);

    /** 
     * 根据条件查询（包含二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<M> selectByExampleWithBLOBs(E example);

    /** 
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<M> selectByExample(E example);

    /** 
     * 根据ID查询
     * @param id 主键ID
     * @return 返回查询的结果
     */
    M selectByPrimaryKey(ID id);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(M record);

    /** 
     * 根据ID修改字段（包含二进制大对象）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeyWithBLOBs(M record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(M record);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") M record, @Param("example") E example);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") M record, @Param("example") E example);

    /** 
     * 根据条件修改字段 （包含二进制大对象）
     * @param record 修改字段对象(必须含ID）
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleWithBLOBs(@Param("record") M record, @Param("example") E example);

    /** 
     * 根据主键，批量更新
     * @param record 批量修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateBatchByPrimaryKey(List<M> record);

    /** 
     * 根据主键，批量更新对应字段数据
     * @param record 批量修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateBatchByPrimaryKeySelective(List<M> record);

    /** 
     * 根据条件，批量更新对应字段数据
     * @param record 批量修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateBatchByExampleSelective(@Param("recordList") List<M> record, @Param("example") E example);

    /** 
     * 根据条件，批量更新
     * @param record 批量修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateBatchByExample(@Param("recordList") List<M> record, @Param("example") E example);
}