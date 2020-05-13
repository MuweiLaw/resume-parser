package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户简历表 lds_user_resume
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserResume implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5215452795437750304L;

    /** 
     * 主键
     */ 
    private Long idKey;

    /** 
     * 个人用户Id
     */ 
    private String userId;

    /** 
     * 简历快照Id
     */ 
    private String snapshotId;

    /** 
     * 简历Id
     */ 
    private String resumeId;

    /** 
     * 简历名称
     */ 
    private String resumeName;

    /** 
     * 简历状态
     */ 
    private String resumeStatus;

    /** 
     * 简历更新时间
     */ 
    private Date resumeUpdateTime;

    /** 
     * 隐私策略（见数据字典RESUME_PRIVACY_STATUS）
     */ 
    private String privacyPolicy;

    /** 
     * 是否删除：Y：是，N：否  默认：N
     */ 
    private String delete;

    /** 
     * 是否已经发布：Y：是，N：否
     */ 
    private String isPublished;

    /** 
     * 是否默认简历：Y：是，N：否
     */ 
    private String isDefault;

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
     * 获取 主键 lds_user_resume.id_key
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /** 
     * 设置 主键 lds_user_resume.id_key
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /** 
     * 获取 个人用户Id lds_user_resume.user_id
     * @return 个人用户Id
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * 设置 个人用户Id lds_user_resume.user_id
     * @param userId 个人用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /** 
     * 获取 简历快照Id lds_user_resume.snapshot_id
     * @return 简历快照Id
     */
    public String getSnapshotId() {
        return snapshotId;
    }

    /** 
     * 设置 简历快照Id lds_user_resume.snapshot_id
     * @param snapshotId 简历快照Id
     */
    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId == null ? null : snapshotId.trim();
    }

    /** 
     * 获取 简历Id lds_user_resume.resume_id
     * @return 简历Id
     */
    public String getResumeId() {
        return resumeId;
    }

    /** 
     * 设置 简历Id lds_user_resume.resume_id
     * @param resumeId 简历Id
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    /** 
     * 获取 简历名称 lds_user_resume.resume_name
     * @return 简历名称
     */
    public String getResumeName() {
        return resumeName;
    }

    /** 
     * 设置 简历名称 lds_user_resume.resume_name
     * @param resumeName 简历名称
     */
    public void setResumeName(String resumeName) {
        this.resumeName = resumeName == null ? null : resumeName.trim();
    }

    /** 
     * 获取 简历状态 lds_user_resume.resume_status
     * @return 简历状态
     */
    public String getResumeStatus() {
        return resumeStatus;
    }

    /** 
     * 设置 简历状态 lds_user_resume.resume_status
     * @param resumeStatus 简历状态
     */
    public void setResumeStatus(String resumeStatus) {
        this.resumeStatus = resumeStatus == null ? null : resumeStatus.trim();
    }

    /** 
     * 获取 简历更新时间 lds_user_resume.resume_update_time
     * @return 简历更新时间
     */
    public Date getResumeUpdateTime() {
        return resumeUpdateTime;
    }

    /** 
     * 设置 简历更新时间 lds_user_resume.resume_update_time
     * @param resumeUpdateTime 简历更新时间
     */
    public void setResumeUpdateTime(Date resumeUpdateTime) {
        this.resumeUpdateTime = resumeUpdateTime;
    }

    /** 
     * 获取 隐私策略（见数据字典RESUME_PRIVACY_STATUS） lds_user_resume.privacy_policy
     * @return 隐私策略（见数据字典RESUME_PRIVACY_STATUS）
     */
    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    /** 
     * 设置 隐私策略（见数据字典RESUME_PRIVACY_STATUS） lds_user_resume.privacy_policy
     * @param privacyPolicy 隐私策略（见数据字典RESUME_PRIVACY_STATUS）
     */
    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy == null ? null : privacyPolicy.trim();
    }

    /** 
     * 获取 是否删除：Y：是，N：否 lds_user_resume.delete
     * @return 是否删除：Y：是，N：否
     */
    public String getDelete() {
        return delete;
    }

    /** 
     * 设置 是否删除：Y：是，N：否 lds_user_resume.delete
     * @param delete 是否删除：Y：是，N：否
     */
    public void setDelete(String delete) {
        this.delete = delete == null ? null : delete.trim();
    }

    /** 
     * 获取 是否已经发布：Y：是，N：否 lds_user_resume.is_published
     * @return 是否已经发布：Y：是，N：否
     */
    public String getIsPublished() {
        return isPublished;
    }

    /** 
     * 设置 是否已经发布：Y：是，N：否 lds_user_resume.is_published
     * @param isPublished 是否已经发布：Y：是，N：否
     */
    public void setIsPublished(String isPublished) {
        this.isPublished = isPublished == null ? null : isPublished.trim();
    }

    /** 
     * 获取 是否默认简历：Y：是，N：否 lds_user_resume.is_default
     * @return 是否默认简历：Y：是，N：否
     */
    public String getIsDefault() {
        return isDefault;
    }

    /** 
     * 设置 是否默认简历：Y：是，N：否 lds_user_resume.is_default
     * @param isDefault 是否默认简历：Y：是，N：否
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault == null ? null : isDefault.trim();
    }

    /** 
     * 获取 创建人 lds_user_resume.created_by
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * 设置 创建人 lds_user_resume.created_by
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /** 
     * 获取 更新人 lds_user_resume.updated_by
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /** 
     * 设置 更新人 lds_user_resume.updated_by
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /** 
     * 获取 创建时间 lds_user_resume.created_date
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 创建时间 lds_user_resume.created_date
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** 
     * 获取 更新时间 lds_user_resume.updated_date
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /** 
     * 设置 更新时间 lds_user_resume.updated_date
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idKey=").append(idKey);
        sb.append(", userId=").append(userId);
        sb.append(", snapshotId=").append(snapshotId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", resumeName=").append(resumeName);
        sb.append(", resumeStatus=").append(resumeStatus);
        sb.append(", resumeUpdateTime=").append(resumeUpdateTime);
        sb.append(", privacyPolicy=").append(privacyPolicy);
        sb.append(", delete=").append(delete);
        sb.append(", isPublished=").append(isPublished);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append("]");
        return sb.toString();
    }
}