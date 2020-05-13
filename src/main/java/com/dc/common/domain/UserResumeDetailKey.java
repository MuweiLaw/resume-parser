package com.dc.common.domain;

import java.io.Serializable;

/** 
 * 用户简历详细信息表 lds_user_resume_detail
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserResumeDetailKey implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = 6903378080322763484L;

    /** 
     * 主键
     */ 
    private Long idKey;

    /** 
     * 年收入
     */ 
    private Double annualIncome;

    /** 
     * 获取 主键 lds_user_resume_detail.id_key
     * @return 主键
     */
    public Long getIdKey() {
        return idKey;
    }

    /** 
     * 设置 主键 lds_user_resume_detail.id_key
     * @param idKey 主键
     */
    public void setIdKey(Long idKey) {
        this.idKey = idKey;
    }

    /** 
     * 获取 年收入 lds_user_resume_detail.annual_income
     * @return 年收入
     */
    public Double getAnnualIncome() {
        return annualIncome;
    }

    /** 
     * 设置 年收入 lds_user_resume_detail.annual_income
     * @param annualIncome 年收入
     */
    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", idKey=").append(idKey);
        sb.append(", annualIncome=").append(annualIncome);
        sb.append("]");
        return sb.toString();
    }
}