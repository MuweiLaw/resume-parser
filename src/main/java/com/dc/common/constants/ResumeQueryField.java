package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

/**
 * 用户角色
 *
 * @author lvhaoyu
 */
public class ResumeQueryField {

    public static final String QUERY_CONDITION_FIELD_ID = "id"; //索引ID

    public static final String QUERY_CONDITION_FIELD_RESUME_ID = "resumeId"; //简历ID

    public static final String QUERY_CONDITION_FIELD_RESUME_SNAPSHOT_ID = "resumeSnapshotId"; //简历快照Id

    public static final String QUERY_CONDITION_FIELD_USER_ID = "userId"; //用户ID

    public static final String QUERY_CONDITION_FIELD_AGE = "age"; //简历快照Id

    public static final String QUERY_CONDITION_FIELD_WORKING_YEARS = "workingYears"; //工作经验

    public static final String QUERY_CONDITION_FIELD_SEX_NAME = "sexName"; //性别名称

    public static final String QUERY_CONDITION_FIELD_SEX= "sex"; //居住地址

    public static final String QUERY_CONDITION_FIELD_RESIDENTIAL_ADDRESS= "residentialAddress"; //居住地址

    public static final String QUERY_CONDITION_FIELD_RESIDENTIAL_ADDRESS_NAME= "residentialAddressName"; //居住地址名称

    public static final String QUERY_CONDITION_FIELD_WORK_FUNCTION= "workFunction"; //职能

    public static final String QUERY_CONDITION_FIELD_RECENT_FUNCTION_NAME= "recentFunctionName"; //职能名称

    public static final String QUERY_CONDITION_FIELD_RECENT_COMPANY_NAME= "companyName"; //公司名称

    public static final String QUERY_CONDITION_FIELD_RECENT_POSITION= "recentPosition"; //职位

    public static final String QUERY_CONDITION_FIELD_TRAINING_DESCRIPTION= "trainingDescription"; //培训描述

    public static final String QUERY_CONDITION_FIELD_EDUCATION_NAME= "educationName"; //学历名称

    public static final String QUERY_CONDITION_FIELD_EDUCATION = "education"; //学历

    public static final String QUERY_CONDITION_FIELD_RESUME_UPDATE_DATE = "resumeUpdateDate"; //简历更新时间

    public static final String QUERY_CONDITION_FIELD_RESUME_UPDATE_DATE_DATE_TYPE= "updatedDate"; //简历更新时间

    public static final String QUERY_CONDITION_FIELD_RESUME_UPDATE_DATE_NAME= "resumeUpdateDateName"; //简历更新时间名称

    public static final String QUERY_CONDITION_FIELD_EXPECTED_SALARY= "expectedSalary"; //期望月薪

    public static final String QUERY_CONDITION_FIELD_EXPECTED_SALARY_NAME = "expectedSalaryName"; //期望月薪名称

    public static final String QUERY_CONDITION_FIELD_EXPECTED_SALARY_AVERAGE = "expectedSalaryAverage"; //期望月薪平均水平

    public static final String QUERY_CONDITION_FIELD_EXCEPTED_WORK_ADDRESS= "exceptedWorkAddress"; //期望工作地点

    public static final String QUERY_CONDITION_FIELD_EXCEPTED_WORK_ADDRESS_NAME= "exceptedWorkAddressName";//期望工作地点名称

    public static final String QUERY_CONDITION_FIELD_MONTHLY_SALARY= "monthlySalary"; //当前月薪

    public static final String QUERY_CONDITION_FIELD_MONTHLY_SALARY_AVERAGE= "monthlySalaryAverage"; //当前月薪平均水平

    public static final String QUERY_CONDITION_FIELD_LATEST_WORK_COMPANY= "latestWorkCompany"; //最新公司

    public static final String QUERY_CONDITION_FIELD_HAS_OVERSEAS= "hasOverseas"; //是否有海外工作经验（Y:有 N:无）

    public static final String QUERY_CONDITION_FIELD_HAS_OVERSEAS_NAME= "hasOverseasName"; //是否有海外工作经验名称

    public static final String QUERY_CONDITION_FIELD_HAS_OVERSEAS_EDU= "hasOverseasEdu"; //是否有海外留学经验（Y:有 N:无）

    public static final String QUERY_CONDITION_FIELD_HAS_OVERSEAS_EDU_NAME= "hasOverseasEduName"; //是否有海外留学经验名称

    public static final String QUERY_CONDITION_FIELD_EXPECTED_WORK_POSITION= "expectedWorkPosition"; //期望职位

    public static final String QUERY_CONDITION_FIELD_EXPECTED_WORK_POSITION_NAME= "expectedWorkPositionName"; //期望职位

    public static final String QUERY_CONDITION_FIELD_EXPECTED_WORK_FUNCTION= "expectedWorkFunction"; //期望职能

    public static final String QUERY_CONDITION_FIELD_ENGLISH_LEVEL= "englishLevel";//英语等级

    public static final String QUERY_CONDITION_FIELD_ENGLISH_LEVEL_NAME= "englishLevelName";//英语等级名称

    public static final String QUERY_CONDITION_FIELD_SPECIALTY= "specialty";//专业

    public static final String QUERY_CONDITION_FIELD_REGISTERED= "registered";//户口

    public static final String QUERY_CONDITION_FIELD_JOB_STATUS= "jobStatus";//求职状态

    public static final String QUERY_CONDITION_FIELD_INDUSTRY= "industry";//行业

    public static final String QUERY_CONDITION_FIELD_INDUSTRY_NAME= "industryName";//行业名称

    public static final String QUERY_CONDITION_FIELD_IS_DELETE= "isDelete";//是否删除

    public static final String QUERY_CONDITION_FIELD_UPDATED_DATE= "updatedDate";//基础数据更新时间

    public static final String QUERY_CONDITION_FIELD_LANGUAGE= "language";//语言

    public static final String QUERY_CONDITION_FIELD_PRIVACY_POLICY= "privacyPolicy";//隐私策略

    public static final String QUERY_CONDITION_FIELD_KEY_SEARCH= "keySearch";//关键字搜索
    
    @ConstantsMeta(name = "排序策略   (降序)")
	public static final String ORDER_DESC = "DESC";
}