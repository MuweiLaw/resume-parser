package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * 用户求职意向表 lds_user_intention
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserIntention implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 5058044684134766861L;

    /** 
     * 主键
     */ 
    private Long idKey;

    /** 
     * 个人用户Id
     */ 
    private String userId;

    /** 
     * 简历Id
     */ 
    private String resumeId;

    /** 
     * 期望薪资类型（见数据字典SALARY_TYPE）
     */ 
    private String salaryType;

    /** 
     * 期望薪资(见数据字典SALARY_LEVEL)
     */ 
    private String expectSalary;

    /** 
     * 期望工作地点（见数据字典AREA）
     */ 
    private String workAddress;

    /** 
     * 职位
     */ 
    private String workPosition;

    /** 
     * 职能
     */ 
    private String workFunction;

    /** 
     * 行业(见数据字典INDUSTRIES)
     */ 
    private String industry;

    /** 
     * 到岗时间（见数据字典POST_AVAILABLE_TIME）
     */ 
    private String comeTime;

    /** 
     * 工作类型(见数据字典WORK_TYPE)
     */ 
    private String workType;

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
     * 自我评价
     */ 
    private String selfEvaluation;

    /** 
     * 获取 主键 lds_user_intention.id_key
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /** 
     * 设置 主键 lds_user_intention.id_key
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /** 
     * 获取 个人用户Id lds_user_intention.user_id
     * @return 个人用户Id
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * 设置 个人用户Id lds_user_intention.user_id
     * @param userId 个人用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /** 
     * 获取 简历Id lds_user_intention.resume_id
     * @return 简历Id
     */
    public String getResumeId() {
        return resumeId;
    }

    /** 
     * 设置 简历Id lds_user_intention.resume_id
     * @param resumeId 简历Id
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    /** 
     * 获取 期望薪资类型（见数据字典SALARY_TYPE） lds_user_intention.salary_type
     * @return 期望薪资类型（见数据字典SALARY_TYPE）
     */
    public String getSalaryType() {
        return salaryType;
    }

    /** 
     * 设置 期望薪资类型（见数据字典SALARY_TYPE） lds_user_intention.salary_type
     * @param salaryType 期望薪资类型（见数据字典SALARY_TYPE）
     */
    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType == null ? null : salaryType.trim();
    }

    /** 
     * 获取 期望薪资(见数据字典SALARY_LEVEL) lds_user_intention.expect_salary
     * @return 期望薪资(见数据字典SALARY_LEVEL)
     */
    public String getExpectSalary() {
        return expectSalary;
    }

    /** 
     * 设置 期望薪资(见数据字典SALARY_LEVEL) lds_user_intention.expect_salary
     * @param expectSalary 期望薪资(见数据字典SALARY_LEVEL)
     */
    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary == null ? null : expectSalary.trim();
    }

    /** 
     * 获取 期望工作地点（见数据字典AREA） lds_user_intention.work_address
     * @return 期望工作地点（见数据字典AREA）
     */
    public String getWorkAddress() {
        return workAddress;
    }

    /** 
     * 设置 期望工作地点（见数据字典AREA） lds_user_intention.work_address
     * @param workAddress 期望工作地点（见数据字典AREA）
     */
    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress == null ? null : workAddress.trim();
    }

    /** 
     * 获取 职位 lds_user_intention.work_position
     * @return 职位
     */
    public String getWorkPosition() {
        return workPosition;
    }

    /** 
     * 设置 职位 lds_user_intention.work_position
     * @param workPosition 职位
     */
    public void setWorkPosition(String workPosition) {
        this.workPosition = workPosition == null ? null : workPosition.trim();
    }

    /** 
     * 获取 职能 lds_user_intention.work_function
     * @return 职能
     */
    public String getWorkFunction() {
        return workFunction;
    }

    /** 
     * 设置 职能 lds_user_intention.work_function
     * @param workFunction 职能
     */
    public void setWorkFunction(String workFunction) {
        this.workFunction = workFunction == null ? null : workFunction.trim();
    }

    /** 
     * 获取 行业(见数据字典INDUSTRIES) lds_user_intention.industry
     * @return 行业(见数据字典INDUSTRIES)
     */
    public String getIndustry() {
        return industry;
    }

    /** 
     * 设置 行业(见数据字典INDUSTRIES) lds_user_intention.industry
     * @param industry 行业(见数据字典INDUSTRIES)
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /** 
     * 获取 到岗时间（见数据字典POST_AVAILABLE_TIME） lds_user_intention.come_time
     * @return 到岗时间（见数据字典POST_AVAILABLE_TIME）
     */
    public String getComeTime() {
        return comeTime;
    }

    /** 
     * 设置 到岗时间（见数据字典POST_AVAILABLE_TIME） lds_user_intention.come_time
     * @param comeTime 到岗时间（见数据字典POST_AVAILABLE_TIME）
     */
    public void setComeTime(String comeTime) {
        this.comeTime = comeTime == null ? null : comeTime.trim();
    }

    /** 
     * 获取 工作类型(见数据字典WORK_TYPE) lds_user_intention.work_type
     * @return 工作类型(见数据字典WORK_TYPE)
     */
    public String getWorkType() {
        return workType;
    }

    /** 
     * 设置 工作类型(见数据字典WORK_TYPE) lds_user_intention.work_type
     * @param workType 工作类型(见数据字典WORK_TYPE)
     */
    public void setWorkType(String workType) {
        this.workType = workType == null ? null : workType.trim();
    }

    /** 
     * 获取 创建人 lds_user_intention.created_by
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * 设置 创建人 lds_user_intention.created_by
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /** 
     * 获取 更新人 lds_user_intention.updated_by
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /** 
     * 设置 更新人 lds_user_intention.updated_by
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /** 
     * 获取 创建时间 lds_user_intention.created_date
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 创建时间 lds_user_intention.created_date
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** 
     * 获取 更新时间 lds_user_intention.updated_date
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /** 
     * 设置 更新时间 lds_user_intention.updated_date
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /** 
     * 获取 自我评价 lds_user_intention.self_evaluation
     * @return 自我评价
     */
    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    /** 
     * 设置 自我评价 lds_user_intention.self_evaluation
     * @param selfEvaluation 自我评价
     */
    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation == null ? null : selfEvaluation.trim();
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
        sb.append(", resumeId=").append(resumeId);
        sb.append(", salaryType=").append(salaryType);
        sb.append(", expectSalary=").append(expectSalary);
        sb.append(", workAddress=").append(workAddress);
        sb.append(", workPosition=").append(workPosition);
        sb.append(", workFunction=").append(workFunction);
        sb.append(", industry=").append(industry);
        sb.append(", comeTime=").append(comeTime);
        sb.append(", workType=").append(workType);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", selfEvaluation=").append(selfEvaluation);
        sb.append("]");
        return sb.toString();
    }
}