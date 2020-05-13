package com.dc.common.domain;

import java.io.Serializable;
import java.util.Date;

/** 
 * 企业用户表 lds_company_info
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class CompanyInfo implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2036893661822809710L;

    /** 
     * 主键
     */ 
    private Long idKey;

    /** 
     * 企业用户Id
     */ 
    private String companyId;

    /** 
     * 用户名
     */ 
    private String userName;

    /** 
     * 公司名称
     */ 
    private String companyName;

    /** 
     * 联系电话
     */ 
    private String phone;

    /** 
     * 邮箱
     */ 
    private String email;

    /** 
     * 公司所在省(数据字典AREA)
     */ 
    private String province;

    /** 
     * 公司所在市(数据字典AREA)
     */ 
    private String city;

    /** 
     * 公司所在区(数据字典AREA)
     */ 
    private String dist;

    /** 
     * 公司详细地址
     */ 
    private String addrDetail;

    /** 
     * 所属行业(数据字典AREA)
     */ 
    private String industry;

    /** 
     * 公司规模(数据字典AREA)
     */ 
    private String scale;

    /** 
     * 公司类别(数据字典AREA)
     */ 
    private String companyType;

    /** 
     * 融资阶段(数据字典Financing_stage)
     */ 
    private String financingStage;

    /** 
     * 企业法人
     */ 
    private String legalPerson;

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
     * 联系人
     */ 
    private String contacts;

    /** 
     * 座机号码
     */ 
    private String telephone;

    /** 
     * 公司官网
     */ 
    private String webUrl;

    /** 
     * 公司简介
     */ 
    private String briefInfo;

    /** 
     * 公司标签(COMPANY_TAGS)
     */ 
    private String companyTags;

    /** 
     * 公司所在经度
     */ 
    private String longitude;

    /** 
     * 公司所在纬度
     */ 
    private String latitude;

    /** 
     * 公司注册资本
     */ 
    private Integer registeredCapital;

    /** 
     * 公司简称
     */ 
    private String abbreviation;

    /** 
     * 工商信息
     */ 
    private String businessInfo;

    /** 
     * 公司成立时间
     */ 
    private Date establishDate;

    /** 
     * 公司logo
     */ 
    private String logo;

    /** 
     * 是否是会员（是:Y  ||  N:否）
     */ 
    private String isvip;

    /** 
     * 获取 主键 lds_company_info.id_key
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /** 
     * 设置 主键 lds_company_info.id_key
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /** 
     * 获取 企业用户Id lds_company_info.company_id
     * @return 企业用户Id
     */
    public String getCompanyId() {
        return companyId;
    }

    /** 
     * 设置 企业用户Id lds_company_info.company_id
     * @param companyId 企业用户Id
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    /** 
     * 获取 用户名 lds_company_info.user_name
     * @return 用户名
     */
    public String getUserName() {
        return userName;
    }

    /** 
     * 设置 用户名 lds_company_info.user_name
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /** 
     * 获取 公司名称 lds_company_info.company_name
     * @return 公司名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /** 
     * 设置 公司名称 lds_company_info.company_name
     * @param companyName 公司名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    /** 
     * 获取 联系电话 lds_company_info.phone
     * @return 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /** 
     * 设置 联系电话 lds_company_info.phone
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /** 
     * 获取 邮箱 lds_company_info.email
     * @return 邮箱
     */
    public String getEmail() {
        return email;
    }

    /** 
     * 设置 邮箱 lds_company_info.email
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /** 
     * 获取 公司所在省(数据字典AREA) lds_company_info.province
     * @return 公司所在省(数据字典AREA)
     */
    public String getProvince() {
        return province;
    }

    /** 
     * 设置 公司所在省(数据字典AREA) lds_company_info.province
     * @param province 公司所在省(数据字典AREA)
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /** 
     * 获取 公司所在市(数据字典AREA) lds_company_info.city
     * @return 公司所在市(数据字典AREA)
     */
    public String getCity() {
        return city;
    }

    /** 
     * 设置 公司所在市(数据字典AREA) lds_company_info.city
     * @param city 公司所在市(数据字典AREA)
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /** 
     * 获取 公司所在区(数据字典AREA) lds_company_info.dist
     * @return 公司所在区(数据字典AREA)
     */
    public String getDist() {
        return dist;
    }

    /** 
     * 设置 公司所在区(数据字典AREA) lds_company_info.dist
     * @param dist 公司所在区(数据字典AREA)
     */
    public void setDist(String dist) {
        this.dist = dist == null ? null : dist.trim();
    }

    /** 
     * 获取 公司详细地址 lds_company_info.addr_detail
     * @return 公司详细地址
     */
    public String getAddrDetail() {
        return addrDetail;
    }

    /** 
     * 设置 公司详细地址 lds_company_info.addr_detail
     * @param addrDetail 公司详细地址
     */
    public void setAddrDetail(String addrDetail) {
        this.addrDetail = addrDetail == null ? null : addrDetail.trim();
    }

    /** 
     * 获取 所属行业(数据字典AREA) lds_company_info.industry
     * @return 所属行业(数据字典AREA)
     */
    public String getIndustry() {
        return industry;
    }

    /** 
     * 设置 所属行业(数据字典AREA) lds_company_info.industry
     * @param industry 所属行业(数据字典AREA)
     */
    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    /** 
     * 获取 公司规模(数据字典AREA) lds_company_info.scale
     * @return 公司规模(数据字典AREA)
     */
    public String getScale() {
        return scale;
    }

    /** 
     * 设置 公司规模(数据字典AREA) lds_company_info.scale
     * @param scale 公司规模(数据字典AREA)
     */
    public void setScale(String scale) {
        this.scale = scale == null ? null : scale.trim();
    }

    /** 
     * 获取 公司类别(数据字典AREA) lds_company_info.company_type
     * @return 公司类别(数据字典AREA)
     */
    public String getCompanyType() {
        return companyType;
    }

    /** 
     * 设置 公司类别(数据字典AREA) lds_company_info.company_type
     * @param companyType 公司类别(数据字典AREA)
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    /** 
     * 获取 融资阶段(数据字典Financing_stage) lds_company_info.financing_stage
     * @return 融资阶段(数据字典Financing_stage)
     */
    public String getFinancingStage() {
        return financingStage;
    }

    /** 
     * 设置 融资阶段(数据字典Financing_stage) lds_company_info.financing_stage
     * @param financingStage 融资阶段(数据字典Financing_stage)
     */
    public void setFinancingStage(String financingStage) {
        this.financingStage = financingStage == null ? null : financingStage.trim();
    }

    /** 
     * 获取 企业法人 lds_company_info.legal_person
     * @return 企业法人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /** 
     * 设置 企业法人 lds_company_info.legal_person
     * @param legalPerson 企业法人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /** 
     * 获取 创建人 lds_company_info.created_by
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /** 
     * 设置 创建人 lds_company_info.created_by
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    /** 
     * 获取 更新人 lds_company_info.updated_by
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /** 
     * 设置 更新人 lds_company_info.updated_by
     * @param updatedBy 更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    /** 
     * 获取 创建时间 lds_company_info.created_date
     * @return 创建时间
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /** 
     * 设置 创建时间 lds_company_info.created_date
     * @param createdDate 创建时间
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /** 
     * 获取 更新时间 lds_company_info.updated_date
     * @return 更新时间
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /** 
     * 设置 更新时间 lds_company_info.updated_date
     * @param updatedDate 更新时间
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /** 
     * 获取 联系人 lds_company_info.contacts
     * @return 联系人
     */
    public String getContacts() {
        return contacts;
    }

    /** 
     * 设置 联系人 lds_company_info.contacts
     * @param contacts 联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /** 
     * 获取 座机号码 lds_company_info.telephone
     * @return 座机号码
     */
    public String getTelephone() {
        return telephone;
    }

    /** 
     * 设置 座机号码 lds_company_info.telephone
     * @param telephone 座机号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /** 
     * 获取 公司官网 lds_company_info.web_url
     * @return 公司官网
     */
    public String getWebUrl() {
        return webUrl;
    }

    /** 
     * 设置 公司官网 lds_company_info.web_url
     * @param webUrl 公司官网
     */
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl == null ? null : webUrl.trim();
    }

    /** 
     * 获取 公司简介 lds_company_info.brief_info
     * @return 公司简介
     */
    public String getBriefInfo() {
        return briefInfo;
    }

    /** 
     * 设置 公司简介 lds_company_info.brief_info
     * @param briefInfo 公司简介
     */
    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo == null ? null : briefInfo.trim();
    }

    /** 
     * 获取 公司标签(COMPANY_TAGS) lds_company_info.company_tags
     * @return 公司标签(COMPANY_TAGS)
     */
    public String getCompanyTags() {
        return companyTags;
    }

    /** 
     * 设置 公司标签(COMPANY_TAGS) lds_company_info.company_tags
     * @param companyTags 公司标签(COMPANY_TAGS)
     */
    public void setCompanyTags(String companyTags) {
        this.companyTags = companyTags == null ? null : companyTags.trim();
    }

    /** 
     * 获取 公司所在经度 lds_company_info.longitude
     * @return 公司所在经度
     */
    public String getLongitude() {
        return longitude;
    }

    /** 
     * 设置 公司所在经度 lds_company_info.longitude
     * @param longitude 公司所在经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /** 
     * 获取 公司所在纬度 lds_company_info.latitude
     * @return 公司所在纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /** 
     * 设置 公司所在纬度 lds_company_info.latitude
     * @param latitude 公司所在纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /** 
     * 获取 公司注册资本 lds_company_info.registered_capital
     * @return 公司注册资本
     */
    public Integer getRegisteredCapital() {
        return registeredCapital;
    }

    /** 
     * 设置 公司注册资本 lds_company_info.registered_capital
     * @param registeredCapital 公司注册资本
     */
    public void setRegisteredCapital(Integer registeredCapital) {
        this.registeredCapital = registeredCapital;
    }

    /** 
     * 获取 公司简称 lds_company_info.abbreviation
     * @return 公司简称
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /** 
     * 设置 公司简称 lds_company_info.abbreviation
     * @param abbreviation 公司简称
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation == null ? null : abbreviation.trim();
    }

    /** 
     * 获取 工商信息 lds_company_info.business_info
     * @return 工商信息
     */
    public String getBusinessInfo() {
        return businessInfo;
    }

    /** 
     * 设置 工商信息 lds_company_info.business_info
     * @param businessInfo 工商信息
     */
    public void setBusinessInfo(String businessInfo) {
        this.businessInfo = businessInfo == null ? null : businessInfo.trim();
    }

    /** 
     * 获取 公司成立时间 lds_company_info.establish_date
     * @return 公司成立时间
     */
    public Date getEstablishDate() {
        return establishDate;
    }

    /** 
     * 设置 公司成立时间 lds_company_info.establish_date
     * @param establishDate 公司成立时间
     */
    public void setEstablishDate(Date establishDate) {
        this.establishDate = establishDate;
    }

    /** 
     * 获取 公司logo lds_company_info.logo
     * @return 公司logo
     */
    public String getLogo() {
        return logo;
    }

    /** 
     * 设置 公司logo lds_company_info.logo
     * @param logo 公司logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /** 
     * 获取 是否是会员（是:Y  ||  N:否） lds_company_info.isVIP
     * @return 是否是会员（是:Y  ||  N:否）
     */
    public String getIsvip() {
        return isvip;
    }

    /** 
     * 设置 是否是会员（是:Y  ||  N:否） lds_company_info.isVIP
     * @param isvip 是否是会员（是:Y  ||  N:否）
     */
    public void setIsvip(String isvip) {
        this.isvip = isvip == null ? null : isvip.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idKey=").append(idKey);
        sb.append(", companyId=").append(companyId);
        sb.append(", userName=").append(userName);
        sb.append(", companyName=").append(companyName);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", dist=").append(dist);
        sb.append(", addrDetail=").append(addrDetail);
        sb.append(", industry=").append(industry);
        sb.append(", scale=").append(scale);
        sb.append(", companyType=").append(companyType);
        sb.append(", financingStage=").append(financingStage);
        sb.append(", legalPerson=").append(legalPerson);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", updatedBy=").append(updatedBy);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", updatedDate=").append(updatedDate);
        sb.append(", contacts=").append(contacts);
        sb.append(", telephone=").append(telephone);
        sb.append(", webUrl=").append(webUrl);
        sb.append(", briefInfo=").append(briefInfo);
        sb.append(", companyTags=").append(companyTags);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", registeredCapital=").append(registeredCapital);
        sb.append(", abbreviation=").append(abbreviation);
        sb.append(", businessInfo=").append(businessInfo);
        sb.append(", establishDate=").append(establishDate);
        sb.append(", logo=").append(logo);
        sb.append(", isvip=").append(isvip);
        sb.append("]");
        return sb.toString();
    }
}