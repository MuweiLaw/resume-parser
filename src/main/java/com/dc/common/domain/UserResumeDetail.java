package com.dc.common.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户简历详细信息表 lds_user_resume_detail
 *
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
@Data
public class UserResumeDetail extends UserResumeDetailKey implements Serializable {
    /**
     * 串行版本ID
     */
    private static final long serialVersionUID = 7546597508944678717L;

    /**
     * 个人用户Id
     */
    private String userId;

    /**
     * 用户真实姓名
     */
    private String realName;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 手机号
     */
    private String phoneNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别(见数据字典GENDER)
     */
    private String sex;

    /**
     * 开始工作年
     */
    private Date beginWorkDate;

    /**
     * 目前职位
     */
    private String currentPosition;

    /**
     * 工作经验
     */
    private Byte workingYears;

    /**
     * 目前所在公司
     */
    private String currentCompany;

    /**
     * 求职状态(见数据字典JOB_STATUS)
     */
    private String jobStatus;

    /**
     * 家庭住址
     */
    private String homeAddress;

    /**
     * 居住地址
     */
    private String residentialAddress;

    /**
     * 户口/国籍(见数据字典Administrative_areas)
     */
    private String registered;

    /**
     * 邮编
     */
    private String zipcode;

    /**
     * 婚姻状态:(见数据字典MARRIGAE_STATUS)
     */
    private String maritalStatus;

    /**
     * 证件类型:(见数据字典ID_TYPE)
     */
    private String idType;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 政治面貌(见数据字典POLITICAL_STATUS)
     */
    private String politicalStatus;

    /**
     * 其他联系方式(见数据字典CONTACT_TYPE)
     */
    private String otherContactType;

    /**
     * 其他联系号码
     */
    private String otherNumber;

    /**
     * 身高
     */
    private Integer height;

    /**
     * 个人主页
     */
    private String personalHomepage;

    /**
     * 头像路径
     */
    private String headPortraitUrl;

    /**
     * 基本工资，单位万元  默认：0
     */
    private Double basePay;

    /**
     * 补贴/津贴，单位万元  默认：0
     */
    private Double allowance;

    /**
     * 奖金/佣金，单位万元  默认：0
     */
    private Double commission;

    /**
     * 股权收益，单位万元  默认：0
     */
    private Double equityIncome;

    /**
     * z
     * 简历编号
     */
    private String resumeId;

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
     * 体重
     */
    private Integer weight;

    /**
     * 所在城市(见数据字典Administrative_areas)
     */
    private String city;

    /**
     * 自我描述
     */
    private String selfDescription;

    /**
     * 获取 个人用户Id lds_user_resume_detail.user_id
     *
     * @return 个人用户Id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置 个人用户Id lds_user_resume_detail.user_id
     *
     * @param userId 个人用户Id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 获取 用户真实姓名 lds_user_resume_detail.real_name
     *
     * @return 用户真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置 用户真实姓名 lds_user_resume_detail.real_name
     *
     * @param realName 用户真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取 出生日期 lds_user_resume_detail.birthday
     *
     * @return 出生日期
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置 出生日期 lds_user_resume_detail.birthday
     *
     * @param birthday 出生日期
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取 手机号 lds_user_resume_detail.phone_no
     *
     * @return 手机号
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * 设置 手机号 lds_user_resume_detail.phone_no
     *
     * @param phoneNo 手机号
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo == null ? null : phoneNo.trim();
    }

    /**
     * 获取 邮箱 lds_user_resume_detail.email
     *
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 邮箱 lds_user_resume_detail.email
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取 性别(见数据字典GENDER) lds_user_resume_detail.sex
     *
     * @return 性别(见数据字典GENDER)
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置 性别(见数据字典GENDER) lds_user_resume_detail.sex
     *
     * @param sex 性别(见数据字典GENDER)
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 获取 开始工作年 lds_user_resume_detail.begin_work_date
     *
     * @return 开始工作年
     */
    public Date getBeginWorkDate() {
        return beginWorkDate;
    }

    /**
     * 设置 开始工作年 lds_user_resume_detail.begin_work_date
     *
     * @param beginWorkDate 开始工作年
     */
    public void setBeginWorkDate(Date beginWorkDate) {
        this.beginWorkDate = beginWorkDate;
    }

    /**
     * 获取 目前职位 lds_user_resume_detail.current_position
     *
     * @return 目前职位
     */
    public String getCurrentPosition() {
        return currentPosition;
    }

    /**
     * 设置 目前职位 lds_user_resume_detail.current_position
     *
     * @param currentPosition 目前职位
     */
    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition == null ? null : currentPosition.trim();
    }

    /**
     * 获取 工作经验 lds_user_resume_detail.working_years
     *
     * @return 工作经验
     */
    public Byte getWorkingYears() {
        return workingYears;
    }

    /**
     * 设置 工作经验 lds_user_resume_detail.working_years
     *
     * @param workingYears 工作经验
     */
    public void setWorkingYears(Byte workingYears) {
        this.workingYears = workingYears;
    }

    /**
     * 获取 目前所在公司 lds_user_resume_detail.current_company
     *
     * @return 目前所在公司
     */
    public String getCurrentCompany() {
        return currentCompany;
    }

    /**
     * 设置 目前所在公司 lds_user_resume_detail.current_company
     *
     * @param currentCompany 目前所在公司
     */
    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany == null ? null : currentCompany.trim();
    }

    /**
     * 获取 求职状态(见数据字典JOB_STATUS) lds_user_resume_detail.job_status
     *
     * @return 求职状态(见数据字典JOB_STATUS)
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * 设置 求职状态(见数据字典JOB_STATUS) lds_user_resume_detail.job_status
     *
     * @param jobStatus 求职状态(见数据字典JOB_STATUS)
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus == null ? null : jobStatus.trim();
    }

    /**
     * 获取 家庭住址 lds_user_resume_detail.home_address
     *
     * @return 家庭住址
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * 设置 家庭住址 lds_user_resume_detail.home_address
     *
     * @param homeAddress 家庭住址
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress == null ? null : homeAddress.trim();
    }

    /**
     * 获取 居住地址 lds_user_resume_detail.residential_address
     *
     * @return 居住地址
     */
    public String getResidentialAddress() {
        return residentialAddress;
    }

    /**
     * 设置 居住地址 lds_user_resume_detail.residential_address
     *
     * @param residentialAddress 居住地址
     */
    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress == null ? null : residentialAddress.trim();
    }

    /**
     * 获取 户口/国籍(见数据字典Administrative_areas) lds_user_resume_detail.registered
     *
     * @return 户口/国籍(见数据字典Administrative_areas)
     */
    public String getRegistered() {
        return registered;
    }

    /**
     * 设置 户口/国籍(见数据字典Administrative_areas) lds_user_resume_detail.registered
     *
     * @param registered 户口/国籍(见数据字典Administrative_areas)
     */
    public void setRegistered(String registered) {
        this.registered = registered == null ? null : registered.trim();
    }

    /**
     * 获取 邮编 lds_user_resume_detail.zipcode
     *
     * @return 邮编
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * 设置 邮编 lds_user_resume_detail.zipcode
     *
     * @param zipcode 邮编
     */
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    /**
     * 获取 婚姻状态:(见数据字典MARRIGAE_STATUS) lds_user_resume_detail.marital_status
     *
     * @return 婚姻状态:(见数据字典MARRIGAE_STATUS)
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * 设置 婚姻状态:(见数据字典MARRIGAE_STATUS) lds_user_resume_detail.marital_status
     *
     * @param maritalStatus 婚姻状态:(见数据字典MARRIGAE_STATUS)
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
    }

    /**
     * 获取 证件类型:(见数据字典ID_TYPE) lds_user_resume_detail.id_type
     *
     * @return 证件类型:(见数据字典ID_TYPE)
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 设置 证件类型:(见数据字典ID_TYPE) lds_user_resume_detail.id_type
     *
     * @param idType 证件类型:(见数据字典ID_TYPE)
     */
    public void setIdType(String idType) {
        this.idType = idType == null ? null : idType.trim();
    }

    /**
     * 获取 证件号码 lds_user_resume_detail.id_number
     *
     * @return 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置 证件号码 lds_user_resume_detail.id_number
     *
     * @param idNumber 证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取 政治面貌(见数据字典POLITICAL_STATUS) lds_user_resume_detail.political_status
     *
     * @return 政治面貌(见数据字典POLITICAL_STATUS)
     */
    public String getPoliticalStatus() {
        return politicalStatus;
    }

    /**
     * 设置 政治面貌(见数据字典POLITICAL_STATUS) lds_user_resume_detail.political_status
     *
     * @param politicalStatus 政治面貌(见数据字典POLITICAL_STATUS)
     */
    public void setPoliticalStatus(String politicalStatus) {
        this.politicalStatus = politicalStatus == null ? null : politicalStatus.trim();
    }

    /**
     * 获取 其他联系方式(见数据字典CONTACT_TYPE) lds_user_resume_detail.other_contact_type
     *
     * @return 其他联系方式(见数据字典CONTACT_TYPE)
     */
    public String getOtherContactType() {
        return otherContactType;
    }

    /**
     * 设置 其他联系方式(见数据字典CONTACT_TYPE) lds_user_resume_detail.other_contact_type
     *
     * @param otherContactType 其他联系方式(见数据字典CONTACT_TYPE)
     */
    public void setOtherContactType(String otherContactType) {
        this.otherContactType = otherContactType == null ? null : otherContactType.trim();
    }

    /**
     * 获取 其他联系号码 lds_user_resume_detail.other_number
     *
     * @return 其他联系号码
     */
    public String getOtherNumber() {
        return otherNumber;
    }

    /**
     * 设置 其他联系号码 lds_user_resume_detail.other_number
     *
     * @param otherNumber 其他联系号码
     */
    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber == null ? null : otherNumber.trim();
    }

    /**
     * 获取 身高 lds_user_resume_detail.height
     *
     * @return 身高
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 设置 身高 lds_user_resume_detail.height
     *
     * @param height 身高
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 获取 个人主页 lds_user_resume_detail.personal_homepage
     *
     * @return 个人主页
     */
    public String getPersonalHomepage() {
        return personalHomepage;
    }

    /**
     * 设置 个人主页 lds_user_resume_detail.personal_homepage
     *
     * @param personalHomepage 个人主页
     */
    public void setPersonalHomepage(String personalHomepage) {
        this.personalHomepage = personalHomepage == null ? null : personalHomepage.trim();
    }

    /**
     * 获取 头像路径 lds_user_resume_detail.head_portrait_url
     *
     * @return 头像路径
     */
    public String getHeadPortraitUrl() {
        return headPortraitUrl;
    }

    /**
     * 设置 头像路径 lds_user_resume_detail.head_portrait_url
     *
     * @param headPortraitUrl 头像路径
     */
    public void setHeadPortraitUrl(String headPortraitUrl) {
        this.headPortraitUrl = headPortraitUrl == null ? null : headPortraitUrl.trim();
    }

    /**
     * 获取 基本工资，单位万元 lds_user_resume_detail.base_pay
     *
     * @return 基本工资，单位万元
     */
    public Double getBasePay() {
        return basePay;
    }

    /**
     * 设置 基本工资，单位万元 lds_user_resume_detail.base_pay
     *
     * @param basePay 基本工资，单位万元
     */
    public void setBasePay(Double basePay) {
        this.basePay = basePay;
    }

    /**
     * 获取 补贴/津贴，单位万元 lds_user_resume_detail.allowance
     *
     * @return 补贴/津贴，单位万元
     */
    public Double getAllowance() {
        return allowance;
    }

    /**
     * 设置 补贴/津贴，单位万元 lds_user_resume_detail.allowance
     *
     * @param allowance 补贴/津贴，单位万元
     */
    public void setAllowance(Double allowance) {
        this.allowance = allowance;
    }

    /**
     * 获取 奖金/佣金，单位万元 lds_user_resume_detail.commission
     *
     * @return 奖金/佣金，单位万元
     */
    public Double getCommission() {
        return commission;
    }

    /**
     * 设置 奖金/佣金，单位万元 lds_user_resume_detail.commission
     *
     * @param commission 奖金/佣金，单位万元
     */
    public void setCommission(Double commission) {
        this.commission = commission;
    }

    /**
     * 获取 股权收益，单位万元 lds_user_resume_detail.equity_income
     *
     * @return 股权收益，单位万元
     */
    public Double getEquityIncome() {
        return equityIncome;
    }

    /**
     * 设置 股权收益，单位万元 lds_user_resume_detail.equity_income
     *
     * @param equityIncome 股权收益，单位万元
     */
    public void setEquityIncome(Double equityIncome) {
        this.equityIncome = equityIncome;
    }

    /**
     * 获取 简历编号 lds_user_resume_detail.resume_id
     *
     * @return 简历编号
     */
    public String getResumeId() {
        return resumeId;
    }

    /**
     * 设置 简历编号 lds_user_resume_detail.resume_id
     *
     * @param resumeId 简历编号
     */
    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    /**
     * 获取 创建人 lds_user_resume_detail.created_by
     *
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置 创建人 lds_user_resume_detail.created_by
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /**
     * 获取 更新人 lds_user_resume_detail.updated_by
     *
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置 更新人 lds_user_resume_detail.updated_by
     *
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /**
     * 获取 创建时间 lds_user_resume_detail.created_date
     *
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置 创建时间 lds_user_resume_detail.created_date
     *
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取 更新时间 lds_user_resume_detail.updated_date
     *
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 设置 更新时间 lds_user_resume_detail.updated_date
     *
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 获取 体重 lds_user_resume_detail.weight
     *
     * @return 体重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 设置 体重 lds_user_resume_detail.weight
     *
     * @param weight 体重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 获取 所在城市(见数据字典Administrative_areas) lds_user_resume_detail.city
     *
     * @return 所在城市(见数据字典Administrative_areas)
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置 所在城市(见数据字典Administrative_areas) lds_user_resume_detail.city
     *
     * @param city 所在城市(见数据字典Administrative_areas)
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取 自我描述 lds_user_resume_detail.self_description
     *
     * @return 自我描述
     */
    public String getSelfDescription() {
        return selfDescription;
    }

    /**
     * 设置 自我描述 lds_user_resume_detail.self_description
     *
     * @param selfDescription 自我描述
     */
    public void setSelfDescription(String selfDescription) {
        this.selfDescription = selfDescription == null ? null : selfDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", userId=").append(userId);
        sb.append(", realName=").append(realName);
        sb.append(", birthday=").append(birthday);
        sb.append(", phoneNo=").append(phoneNo);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", beginWorkDate=").append(beginWorkDate);
        sb.append(", currentPosition=").append(currentPosition);
        sb.append(", workingYears=").append(workingYears);
        sb.append(", currentCompany=").append(currentCompany);
        sb.append(", jobStatus=").append(jobStatus);
        sb.append(", homeAddress=").append(homeAddress);
        sb.append(", residentialAddress=").append(residentialAddress);
        sb.append(", registered=").append(registered);
        sb.append(", zipcode=").append(zipcode);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", idType=").append(idType);
        sb.append(", idNumber=").append(idNumber);
        sb.append(", politicalStatus=").append(politicalStatus);
        sb.append(", otherContactType=").append(otherContactType);
        sb.append(", otherNumber=").append(otherNumber);
        sb.append(", height=").append(height);
        sb.append(", personalHomepage=").append(personalHomepage);
        sb.append(", headPortraitUrl=").append(headPortraitUrl);
        sb.append(", basePay=").append(basePay);
        sb.append(", allowance=").append(allowance);
        sb.append(", commission=").append(commission);
        sb.append(", equityIncome=").append(equityIncome);
        sb.append(", resumeId=").append(resumeId);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", weight=").append(weight);
        sb.append(", city=").append(city);
        sb.append(", selfDescription=").append(selfDescription);
        sb.append("]");
        return sb.toString();
    }
}