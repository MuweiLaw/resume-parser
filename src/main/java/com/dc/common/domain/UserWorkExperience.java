package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户工作经历表 lds_user_work_experience
 *
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserWorkExperience implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = 2904155571571460489L;

    /**
     * 主键
     */
    private Long idKey;

    /**
     * 工作经历Id
     */
    private String workExpId;

    /**
     * 个人用户Id
     */
    private String userId;

    /**
     * 简历Id
     */
    private String resumeId;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 公司名称
     */
    private String companyName;

    /**
     * 公司规模（见数据字典COMPANY_SIZE）
     */
    private String companySize;

    /**
     * 公司性质(见数据字典COMPANY_TYPE)
     */
    private String companyNature;

    /**
     * 部门
     */
    private String department;

    /**
     * 职能：
     */
    private String function;

    /**
     * 职位
     */
    private String position;

    /**
     * 月薪（见数据字典SALARY_LEVEL）
     */
    private String monthlySalary;

    /**
     * 行业(见数据字典INDUSTRIES)
     */
    private String industry;

    /**
     * 工作类型(见数据字典JOB_TYPE)
     */
    private String jobType;

    /**
     * 下属人数
     */
    private Integer subordinates;

    /**
     * 汇报对象
     */
    private String reportingObject;

    /**
     * 离职原因
     */
    private String leavingReasons;

    /**
     * 是否有海外工作经历：N：否，Y：是
     */
    private String hasOverseas;

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
     * 工作说明
     */
    private String jobDescription;

    /**
     * 主要成就
     */
    private String mainAchievement;

    public String getMainAchievement() {
        return mainAchievement;
    }

    public void setMainAchievement(String mainAchievement) {
        this.mainAchievement = mainAchievement;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * 获取 主键 lds_user_work_experience.id_key
     *
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /**
     * 设置 主键 lds_user_work_experience.id_key
     *
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /**
     * 获取 工作经历Id lds_user_work_experience.work_exp_id
     *
     * @return 工作经历Id
     */
    public String getWorkExpId() {
        return workExpId;
    }

    /**
     * 设置 工作经历Id lds_user_work_experience.work_exp_id
     *
     * @param workExpId 工作经历Id
     */
    public void setWorkExpId(String workExpId) {
        this.workExpId = workExpId == null ? null : workExpId.trim();
    }

    /**
     * 获取 个人用户Id lds_user_work_experience.user_id
     *
     * @return 个人用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 个人用户Id lds_user_work_experience.user_id
     *
     * @param userId 个人用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 简历Id lds_user_work_experience.resume_id
     *
     * @return 简历Id
     */
    public String getResumeId() {
        return resumeId;
    }

    /**
     * 设置 简历Id lds_user_work_experience.resume_id
     *
     * @param resumeId 简历Id
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    /**
     * 获取 开始时间 lds_user_work_experience.begin_date
     *
     * @return 开始时间
     */
    public Date getBeginDate() {
        return beginDate;
    }

    /**
     * 设置 开始时间 lds_user_work_experience.begin_date
     *
     * @param beginDate 开始时间
     */
    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    /**
     * 获取 结束时间 lds_user_work_experience.end_date
     *
     * @return 结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置 结束时间 lds_user_work_experience.end_date
     *
     * @param endDate 结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取 公司名称 lds_user_work_experience.company_name
     *
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置 公司名称 lds_user_work_experience.company_name
     *
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /**
     * 获取 公司规模（见数据字典COMPANY_SIZE） lds_user_work_experience.company_size
     *
     * @return 公司规模（见数据字典COMPANY_SIZE）
     */
    public String getCompanySize() {
        return companySize;
    }

    /**
     * 设置 公司规模（见数据字典COMPANY_SIZE） lds_user_work_experience.company_size
     *
     * @param companySize 公司规模（见数据字典COMPANY_SIZE）
     */
    public void setCompanySize(String companySize) {
        this.companySize = companySize == null ? null : companySize.trim();
    }

    /**
     * 获取 公司性质(见数据字典COMPANY_TYPE) lds_user_work_experience.company_nature
     *
     * @return 公司性质(见数据字典COMPANY_TYPE)
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * 设置 公司性质(见数据字典COMPANY_TYPE) lds_user_work_experience.company_nature
     *
     * @param companyNature 公司性质(见数据字典COMPANY_TYPE)
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature == null ? null : companyNature.trim();
    }

    /**
     * 获取 部门 lds_user_work_experience.department
     *
     * @return 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置 部门 lds_user_work_experience.department
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 获取 职能： lds_user_work_experience.function
     *
     * @return 职能：
     */
    public String getFunction() {
        return function;
    }

    /**
     * 设置 职能： lds_user_work_experience.function
     *
     * @param function 职能：
     */
    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }

    /**
     * 获取 职位 lds_user_work_experience.position
     *
     * @return 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置 职位 lds_user_work_experience.position
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * 获取 月薪（见数据字典SALARY_LEVEL） lds_user_work_experience.monthly_salary
     *
     * @return 月薪（见数据字典SALARY_LEVEL）
     */
    public String getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * 设置 月薪（见数据字典SALARY_LEVEL） lds_user_work_experience.monthly_salary
     *
     * @param monthlySalary 月薪（见数据字典SALARY_LEVEL）
     */
    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary == null ? null : monthlySalary.trim();
    }

    /**
     * 获取 行业(见数据字典INDUSTRIES) lds_user_work_experience.industry
     *
     * @return 行业(见数据字典INDUSTRIES)
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置 行业(见数据字典INDUSTRIES) lds_user_work_experience.industry
     *
     * @param industry 行业(见数据字典INDUSTRIES)
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /**
     * 获取 工作类型(见数据字典JOB_TYPE) lds_user_work_experience.job_type
     *
     * @return 工作类型(见数据字典JOB_TYPE)
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * 设置 工作类型(见数据字典JOB_TYPE) lds_user_work_experience.job_type
     *
     * @param jobType 工作类型(见数据字典JOB_TYPE)
     */
    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    /**
     * 获取 下属人数 lds_user_work_experience.subordinates
     *
     * @return 下属人数
     */
    public Integer getSubordinates() {
        return subordinates;
    }

    /**
     * 设置 下属人数 lds_user_work_experience.subordinates
     *
     * @param subordinates 下属人数
     */
    public void setSubordinates(Integer subordinates) {
        this.subordinates = subordinates;
    }

    /**
     * 获取 汇报对象 lds_user_work_experience.reporting_object
     *
     * @return 汇报对象
     */
    public String getReportingObject() {
        return reportingObject;
    }

    /**
     * 设置 汇报对象 lds_user_work_experience.reporting_object
     *
     * @param reportingObject 汇报对象
     */
    public void setReportingObject(String reportingObject) {
        this.reportingObject = reportingObject == null ? null : reportingObject.trim();
    }

    /**
     * 获取 离职原因 lds_user_work_experience.leaving_reasons
     *
     * @return 离职原因
     */
    public String getLeavingReasons() {
        return leavingReasons;
    }

    /**
     * 设置 离职原因 lds_user_work_experience.leaving_reasons
     *
     * @param leavingReasons 离职原因
     */
    public void setLeavingReasons(String leavingReasons) {
        this.leavingReasons = leavingReasons == null ? null : leavingReasons.trim();
    }

    /**
     * 获取 是否有海外工作经历：N：否，Y：是 lds_user_work_experience.has_overseas
     *
     * @return 是否有海外工作经历：N：否，Y：是
     */
    public String getHasOverseas() {
        return hasOverseas;
    }

    /**
     * 设置 是否有海外工作经历：N：否，Y：是 lds_user_work_experience.has_overseas
     *
     * @param hasOverseas 是否有海外工作经历：N：否，Y：是
     */
    public void setHasOverseas(String hasOverseas) {
        this.hasOverseas = hasOverseas == null ? null : hasOverseas.trim();
    }

    /**
     * 获取 创建人 lds_user_work_experience.created_by
     *
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置 创建人 lds_user_work_experience.created_by
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取 更新人 lds_user_work_experience.updated_by
     *
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置 更新人 lds_user_work_experience.updated_by
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取 创建时间 lds_user_work_experience.created_date
     *
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置 创建时间 lds_user_work_experience.created_date
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取 更新时间 lds_user_work_experience.updated_date
     *
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置 更新时间 lds_user_work_experience.updated_date
     *
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
        sb.append(", workExpId=").append(workExpId);
        sb.append(", userId=").append(userId);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", beginDate=").append(beginDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", companyName=").append(companyName);
        sb.append(", companySize=").append(companySize);
        sb.append(", companyNature=").append(companyNature);
        sb.append(", department=").append(department);
        sb.append(", function=").append(function);
        sb.append(", position=").append(position);
        sb.append(", monthlySalary=").append(monthlySalary);
        sb.append(", industry=").append(industry);
        sb.append(", jobType=").append(jobType);
        sb.append(", subordinates=").append(subordinates);
        sb.append(", reportingObject=").append(reportingObject);
        sb.append(", leavingReasons=").append(leavingReasons);
        sb.append(", hasOverseas=").append(hasOverseas);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append("]");
        return sb.toString();
    }
}