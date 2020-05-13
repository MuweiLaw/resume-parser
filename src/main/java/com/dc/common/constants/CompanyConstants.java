package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

/**
 * 企业版常量
 * @author Administrator
 *
 */
public class CompanyConstants {
	
	@ConstantsMeta(name = "企业下载简历")
	public static final String DOWNLOAD = "downloadResume";
	
	
	@ConstantsMeta(name = "企业收藏简历")
	public static final String COLLECT ="collectResume";
	
	
	@ConstantsMeta(name = "企业收藏,下载，投递简历")
	public static final String ALL_RESUME = "allResume";

	//职位状态
	@ConstantsMeta(name="新建")
	public static final String POSITION_STATUS_NEW = "NEW";
	@ConstantsMeta(name="已发布")
	public static final String POSITION_STATUS_PUBLISHED = "PUBLISHED";
	@ConstantsMeta(name="暂停")
	public static final String POSITION_STATUS_SUSPEND = "SUSPEND";
	@ConstantsMeta(name="下架")
	public static final String POSITION_STATUS_CANCEl = "CANCEl";

}
