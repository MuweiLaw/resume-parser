package com.lds.common.resume.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author wx
 * @version 1.0.0
 * @className ProjectExperience
 * @description TODO
 * @date 2019/12/6 17:06
 */
@Data
@ToString
public class ProjectExperience {
    //项目名称
    private String projectName;
    //项目link
    private String projectLink;
    private String projectRole;
    private String beginDate;
    private String endDate;
    //公司名称
    private String companyName;
    //项目描述
    private String projectDescription;
    //责任描述
    private String dutyDescription;
}
