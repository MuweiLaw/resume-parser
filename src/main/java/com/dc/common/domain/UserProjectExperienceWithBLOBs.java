package com.dc.common.domain;

import java.io.Serializable;

/** 
 * 用户项目经历表 lds_user_project_experience
 * @author mybatis-generator
 * date:2019/12/15 03:09
 */
public class UserProjectExperienceWithBLOBs extends UserProjectExperience implements Serializable {
    /** 
     * 串行版本ID
    */
    private static final long serialVersionUID = -4911357186607662257L;

    /** 
     * 项目描述
     */ 
    private String projectDescription;

    /** 
     * 职责描述
     */ 
    private String dutyDescription;

    /** 
     * 获取 项目描述 lds_user_project_experience.project_description
     * @return 项目描述
     */
    public String getProjectDescription() {
        return projectDescription;
    }

    /** 
     * 设置 项目描述 lds_user_project_experience.project_description
     * @param projectDescription 项目描述
     */
    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription == null ? null : projectDescription.trim();
    }

    /** 
     * 获取 职责描述 lds_user_project_experience.duty_description
     * @return 职责描述
     */
    public String getDutyDescription() {
        return dutyDescription;
    }

    /** 
     * 设置 职责描述 lds_user_project_experience.duty_description
     * @param dutyDescription 职责描述
     */
    public void setDutyDescription(String dutyDescription) {
        this.dutyDescription = dutyDescription == null ? null : dutyDescription.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", projectDescription=").append(projectDescription);
        sb.append(", dutyDescription=").append(dutyDescription);
        sb.append("]");
        return sb.toString();
    }
}