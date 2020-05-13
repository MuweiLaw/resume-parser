package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

/**
 * 个人模块相关常量
 * 
 * @author lvhaoyu
 *
 */
public class PersonConstants {

	@ConstantsMeta(name = "热门职业")
	public static final String Hot_JOBS = "hotJobs";

	@ConstantsMeta(name = "推荐职位")
	public static final String RECOMMENDE_JOB = "recommendedJob";

	@ConstantsMeta(name = "发布时间")
	public static final String PUBLISH_DATE = "publishDate";

	@ConstantsMeta(name = "薪资最高")
	public static final String SALARY_ORDER = "salaryOrder";

	@ConstantsMeta(name = "排序策略   (降序)")
	public static final String ORDER_DESC = "DESC";

	@ConstantsMeta(name = "排序策略   (升序)")
	public static final String ORDER_ASC = "ASC";

	@ConstantsMeta(name = "职位搜索记录类型")
	public static final String JOB_SEARCH_TYPE = "job";

	@ConstantsMeta(name = "公司搜索记录类型")
	public static final String COMPANY_SEARCH_TYPE = "company";

	@ConstantsMeta(name = "全部企业")
	public static final String ALL_COMPANY = "allCompany";
	
	@ConstantsMeta(name = "企业搜索-智能推荐")
	public static final String INTELLIGENCE_RECOMMEND = "recommend";

	@ConstantsMeta(name = "热门企业")
	public static final String POPULAR_ENTERPEISE = "PopularEnterprise";

	@ConstantsMeta(name = "快速处理的企业")
	public static final String IMMEDIATE_PROCESSING = "immediateProcessing";

	@ConstantsMeta(name = "最新发布职位的企业")
	public static final String LATEST_RELEASE = "latestRelease";

	@ConstantsMeta(name = "所有人可见")
	public static final String RESUME_PRIVACY_STATUS_PUBLIC = "PUBLIC";

	@ConstantsMeta(name = "所投公司可见")
	public static final String RESUME_PRIVACY_STATUS_CHOOSEN = "CHOOSEN";
	
	@ConstantsMeta(name = "热门职位名称str")
	public static final String HOT_JOB_NAME_STR = "hotJobNameStr";
}