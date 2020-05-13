package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * 数据字典表 boot_data_dictionary
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class BootDataDictionary implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 2843168681066282468L;

    /** 
     * 主键
     */ 
    private Long idKey;

    /** 
     * 树节点编号
     */ 
    private String treeId;

    /** 
     * 父节点编号
     */ 
    private String parentId;

    /** 
     * 所属分类
     */ 
    private String group;

    /** 
     * 属性
     */ 
    private String value;

    /** 
     * 字典名称
     */ 
    private String name;

    /** 
     * 备注
     */ 
    private String comment;

    /** 
     * 序号
     */ 
    private Integer orderNo;

    /** 
     * 是否生效(Y生效，N失效)
     */ 
    private String isUsed;

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

    /** 
     * 是否为凸显，Y：是，N：不是  默认：N
     */ 
    private String isHighlight;

    /** 
     * 获取 主键 boot_data_dictionary.id_key
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /** 
     * 设置 主键 boot_data_dictionary.id_key
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /** 
     * 获取 树节点编号 boot_data_dictionary.tree_id
     * @return 树节点编号
     */
    public String getTreeId() {
        return treeId;
    }

    /** 
     * 设置 树节点编号 boot_data_dictionary.tree_id
     * @param treeId 树节点编号
     */
    public void setTreeId(String treeId) {
        this.treeId = treeId == null ? null : treeId.trim();
    }

    /** 
     * 获取 父节点编号 boot_data_dictionary.parent_id
     * @return 父节点编号
     */
    public String getParentId() {
        return parentId;
    }

    /** 
     * 设置 父节点编号 boot_data_dictionary.parent_id
     * @param parentId 父节点编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /** 
     * 获取 所属分类 boot_data_dictionary.group
     * @return 所属分类
     */
    public String getGroup() {
        return group;
    }

    /** 
     * 设置 所属分类 boot_data_dictionary.group
     * @param group 所属分类
     */
    public void setGroup(String group) {
        this.group = group == null ? null : group.trim();
    }

    /** 
     * 获取 属性 boot_data_dictionary.value
     * @return 属性
     */
    public String getValue() {
        return value;
    }

    /** 
     * 设置 属性 boot_data_dictionary.value
     * @param value 属性
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /** 
     * 获取 字典名称 boot_data_dictionary.name
     * @return 字典名称
     */
    public String getName() {
        return name;
    }

    /** 
     * 设置 字典名称 boot_data_dictionary.name
     * @param name 字典名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /** 
     * 获取 备注 boot_data_dictionary.comment
     * @return 备注
     */
    public String getComment() {
        return comment;
    }

    /** 
     * 设置 备注 boot_data_dictionary.comment
     * @param comment 备注
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /** 
     * 获取 序号 boot_data_dictionary.order_no
     * @return 序号
     */
    public Integer getOrderNo() {
        return orderNo;
    }

    /** 
     * 设置 序号 boot_data_dictionary.order_no
     * @param orderNo 序号
     */
    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    /** 
     * 获取 是否生效(Y生效，N失效) boot_data_dictionary.is_used
     * @return 是否生效(Y生效，N失效)
     */
    public String getIsUsed() {
        return isUsed;
    }

    /** 
     * 设置 是否生效(Y生效，N失效) boot_data_dictionary.is_used
     * @param isUsed 是否生效(Y生效，N失效)
     */
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed == null ? null : isUsed.trim();
    }

    /** 
     * 获取 创建人 boot_data_dictionary.created_by
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * 设置 创建人 boot_data_dictionary.created_by
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /** 
     * 获取 更新人 boot_data_dictionary.updated_by
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /** 
     * 设置 更新人 boot_data_dictionary.updated_by
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /** 
     * 获取 创建时间 boot_data_dictionary.created_date
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 创建时间 boot_data_dictionary.created_date
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** 
     * 获取 更新时间 boot_data_dictionary.updated_date
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /** 
     * 设置 更新时间 boot_data_dictionary.updated_date
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /** 
     * 获取 是否为凸显，Y：是，N：不是 boot_data_dictionary.is_highlight
     * @return 是否为凸显，Y：是，N：不是
     */
    public String getIsHighlight() {
        return isHighlight;
    }

    /** 
     * 设置 是否为凸显，Y：是，N：不是 boot_data_dictionary.is_highlight
     * @param isHighlight 是否为凸显，Y：是，N：不是
     */
    public void setIsHighlight(String isHighlight) {
        this.isHighlight = isHighlight == null ? null : isHighlight.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idKey=").append(idKey);
        sb.append(", treeId=").append(treeId);
        sb.append(", parentId=").append(parentId);
        sb.append(", group=").append(group);
        sb.append(", value=").append(value);
        sb.append(", name=").append(name);
        sb.append(", comment=").append(comment);
        sb.append(", orderNo=").append(orderNo);
        sb.append(", isUsed=").append(isUsed);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", isHighlight=").append(isHighlight);
        sb.append("]");
        return sb.toString();
    }
}