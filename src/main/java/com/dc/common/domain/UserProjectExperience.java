package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户项目经历表 lds_user_project_experience
 *
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserProjectExperience implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = 3881140432169232101L;

    /**
     * 主键
     */
    private Long idKey;

    /**
     * 项目经历Id
     */
    private String projectExpId;

    /**
     * 个人用户Id
     */
    private String userId;

    /**
     * 简历Id
     */
    private String resumeId;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 项目名称
     */
    private String projectName;

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
     * 项目链接
     */
    private String projectLink;

    /**
     * 担任角色
     */
    private String projectRole;

    /**
     * 项目描述
     */
    private String projectDescription;
    /**
     * 责任描述
     */
    private String dutyDescription;

    public String getDutyDescription() {
        return dutyDescription;
    }

    public void setDutyDescription(String dutyDescription) {
        this.dutyDescription = dutyDescription;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    /**
     * 获取 主键 lds_user_project_experience.id_key
     *
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /**
     * 设置 主键 lds_user_project_experience.id_key
     *
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /**
     * 获取 项目经历Id lds_user_project_experience.project_exp_id
     *
     * @return 项目经历Id
     */
    public String getProjectExpId() {
        return projectExpId;
    }

    /**
     * 设置 项目经历Id lds_user_project_experience.project_exp_id
     *
     * @param projectExpId 项目经历Id
     */
    public void setProjectExpId(String projectExpId) {
        this.projectExpId = projectExpId == null ? null : projectExpId.trim();
    }

    /**
     * 获取 个人用户Id lds_user_project_experience.user_id
     *
     * @return 个人用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 个人用户Id lds_user_project_experience.user_id
     *
     * @param userId 个人用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 简历Id lds_user_project_experience.resume_id
     *
     * @return 简历Id
     */
    public String getResumeId() {
        return resumeId;
    }

    /**
     * 设置 简历Id lds_user_project_experience.resume_id
     *
     * @param resumeId 简历Id
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    /**
     * 获取 公司名称 lds_user_project_experience.company_name
     *
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置 公司名称 lds_user_project_experience.company_name
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取 开始时间 lds_user_project_experience.begin_date
     *
     * @return 开始时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置 开始时间 lds_user_project_experience.begin_date
     *
     * @param beginDate 开始时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取 结束时间 lds_user_project_experience.end_date
     *
     * @return 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置 结束时间 lds_user_project_experience.end_date
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取 项目名称 lds_user_project_experience.project_name
     *
     * @return 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置 项目名称 lds_user_project_experience.project_name
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * 获取 创建人 lds_user_project_experience.created_by
     *
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置 创建人 lds_user_project_experience.created_by
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取 更新人 lds_user_project_experience.updated_by
     *
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置 更新人 lds_user_project_experience.updated_by
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取 创建时间 lds_user_project_experience.created_date
     *
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置 创建时间 lds_user_project_experience.created_date
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取 更新时间 lds_user_project_experience.updated_date
     *
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置 更新时间 lds_user_project_experience.updated_date
     *
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取 项目链接 lds_user_project_experience.project_link
     *
     * @return 项目链接
     */
    public String getProjectLink() {
        return projectLink;
    }

    /**
     * 设置 项目链接 lds_user_project_experience.project_link
     *
     * @param projectLink 项目链接
     */
    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink == null ? null : projectLink.trim();
    }

    /**
     * 获取 担任角色 lds_user_project_experience.project_role
     *
     * @return 担任角色
     */
    public String getProjectRole() {
        return projectRole;
    }

    /**
     * 设置 担任角色 lds_user_project_experience.project_role
     *
     * @param projectRole 担任角色
     */
    public void setProjectRole(String projectRole) {
        this.projectRole = projectRole == null ? null : projectRole.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idKey=").append(idKey);
        sb.append(", projectExpId=").append(projectExpId);
        sb.append(", userId=").append(userId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", companyName=").append(companyName);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", projectName=").append(projectName);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", projectLink=").append(projectLink);
        sb.append(", projectRole=").append(projectRole);
        sb.append("]");
        return sb.toString();
    }
}