package com.dc.common.util.resume.domain;

import lombok.Data;

/**
 * @author wx
 * @version v1.0.0
 * @className TikaResumeModule
 * @description Tika简历解析,模块切割DTO
 * @date 2019/12/23 16:03
 * @Copyright: 2020 www.decheng.com.cn Inc. All rights reserved.
 * 注意：本内容仅限于深圳得程信息技术有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@Data
public class TikaResumeModule {

    //用户详细信息模块
    public static final String SUBMIT_NODE_USERDETAILNFO = "userDetail";
    //自我描述模块
    public static final String INTRODUCE = "introduce";
    //求职意向模块
    public static final String INTENTION = "jobIntention";
    //工作经历模块
    public static final String WORK_EXP = "workExperience";
    //项目经历模块
    public static final String PROJECT_EXP = "projectExperience";
    //教育经历模块
    public static final String EDUCATION_EXP = "educationExperience";

    //联系方式
    public static final String CONTACT_INFO = "contactInfo";

    //模块名称
    private String moduleName;

    //模块起始下标
    private Integer start;

    //模块结束下标
    private Integer end;

    public TikaResumeModule(String moduleName, Integer start) {
        this.moduleName = moduleName;
        this.start = start;
    }
}
