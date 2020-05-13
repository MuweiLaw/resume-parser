package com.dc.common.domain;

import java.io.Serializable;

/** 
 * 用户工作经历表 lds_user_work_experience
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserWorkExperienceWithBLOBs extends UserWorkExperience implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -2282828832232574090L;

    /** 
     * 工作描述
     */ 
    private String jobDescription;

    /** 
     * 主要业绩
     */ 
    private String mainAchievement;

    /** 
     * 获取 工作描述 lds_user_work_experience.job_description
     * @return 工作描述
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /** 
     * 设置 工作描述 lds_user_work_experience.job_description
     * @param jobDescription 工作描述
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription == null ? null : jobDescription.trim();
    }

    /** 
     * 获取 主要业绩 lds_user_work_experience.main_achievement
     * @return 主要业绩
     */
    public String getMainAchievement() {
        return mainAchievement;
    }

    /** 
     * 设置 主要业绩 lds_user_work_experience.main_achievement
     * @param mainAchievement 主要业绩
     */
    public void setMainAchievement(String mainAchievement) {
        this.mainAchievement = mainAchievement == null ? null : mainAchievement.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", jobDescription=").append(jobDescription);
        sb.append(", mainAchievement=").append(mainAchievement);
        sb.append("]");
        return sb.toString();
    }
}