package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group = "SERVICE_ID", comment = "服务编号")
public class ExecutorServiceIdConstants {
	@ConstantsMeta(name="提交简历")
	public static final String SERVICE_PERSONAL_SUBMIT_RESUME = "S0001";
	@ConstantsMeta(name="发布/更新简历")
	public static final String SERVICE_PERSONAL_PUBLISH_RESUME = "S0002";
	@ConstantsMeta(name="职位发布")
	public static final String SERVICE_COMPNAY_JOB_POSTED = "S0003";
	@ConstantsMeta(name="提交企业资质认证信息")
	public static final String SERVICE_COMPNAY_SUBMITCOMPANY_AUTH = "S0004";
	@ConstantsMeta(name="公司管理简历")
	public static final String SERVICE_COMPNAY_RESUME_MANAGEMENT = "S0005";
	@ConstantsMeta(name="职位收藏")
	public static final String SERVICE_PERSONAL_JOB_COLLECTION = "S0006";
	@ConstantsMeta(name="职位投递")
	public static final String SERVICE_PERSONAL_JOB_APPLY = "S0007";
	@ConstantsMeta(name="公司收藏简历")
	public static final String SERVICE_COMPANY_REMUSE_COLLECTION = "S0008";
	@ConstantsMeta(name="设置默认简历")
	public static final String SERVICE_SET_DEFAULT_RESUME = "S0009";
	@ConstantsMeta(name="更新职位状态")
	public static final String SERVICE_UPDATE_JOB_STATE = "S0010";
	@ConstantsMeta(name="更新简历名称")
	public static final String SERVICE_UPDATE_RESUME_NAME = "S0011";
	@ConstantsMeta(name="更新简历隐私策略")
	public static final String SERVICE_UPDATE_RESUME_PRIVACY_POLICY = "S0012";
	@ConstantsMeta(name="删除简历")
	public static final String SERVICE_DELETE_RESUME = "S0013";
	@ConstantsMeta(name="删除企业附件")
	public static final String SERVICE_DELETE_COMPANY_ATTACHMENT = "S0014";
	@ConstantsMeta(name="客户管理")
	public static final String SERVICE_CUSTOMER_MANAGE = "S0015";
	@ConstantsMeta(name="人力资源管理")
	public static final String SERVICE_HUMAN_RESOURCE_MANAGE = "S0016";
	@ConstantsMeta(name="用户搜索记录")
	public static final String SERVICE_USER_SEARCH_RECORDS = "S0017";
	@ConstantsMeta(name="企业附件上传")
	public static final String SERVICE_COMPANY_UPLOAD_ATTACHMENT = "S0018";
	@ConstantsMeta(name="公司下载简历")
	public static final String SERVICE_COMPANY_REMUSE_DOWNLOAD = "S0019";
	@ConstantsMeta(name="公司删除简历")
	public static final String SERVICE_COMPANY_REMUSE_DELETE = "S0020";
	@ConstantsMeta(name="公司面试邀请记录相关操作")
	public static final String SERVICE_COMPANY_INTERVIEW_RECORD = "S0021";
	@ConstantsMeta(name="补充公司展示资料")
	public static final String SERVICE_COMPANY_PERFECT_INFO = "S0022";
	@ConstantsMeta(name="发送消息")
	public static final String SERVICE_COMPANY_SEND_MESSAGE = "S0023";
	@ConstantsMeta(name="用户查看职位记录")
	public static final String SERVICE_VIEW_JOBS_RECORD = "S0024";
	@ConstantsMeta(name="点赞收藏")
	public static final String SERVICE_INTEREST_COLLECTION = "S0025";
	@ConstantsMeta(name="消息(面试邀请&&录用通知&&回复)管理")
	public static final String SERVICE_COMPANY_MESSAGE_UPDATE = "S0026";
	@ConstantsMeta(name="app提交简历")
	public static final String SERVICE_APP_SUBMIT_RESUME = "S0027";
	@ConstantsMeta(name="保存个人主页信息")
	public static final String SERVICE_SAVE_PERSONAL_PAGE = "S0028";
	@ConstantsMeta(name="保存企业消息反馈")
	public static final String SERVICE_SAVE_MESSAGE_FEEDBACK = "S0029";
	@ConstantsMeta(name="企业是否同意新成员")
	public static final String APP_AGREE_ORNOT_APPLY = "S0030";
	@ConstantsMeta(name="APP企业call记录")
	public static final String APP_COMPANY_CALL_RECORD = "S0031";
	@ConstantsMeta(name="APP上传附件")
	public static final String APP_SAVE_COMPANY_ATTACHMENT = "S0032";
	@ConstantsMeta(name="APP删除企业附件")
	public static final String APP_DELETE_COMPANY_ATTACHMENT = "S0033";
	@ConstantsMeta(name="更新面试邀请状态")
	public static final String SERVICE_INTERVIEW_STATUS = "S0034";
	@ConstantsMeta(name="更新录取记录状态")
	public static final String SERVICE_ADMINSSION_STATUS = "S0035";
	@ConstantsMeta(name="用户关注公司")
	public static final String SERVICE_USER_FOLLOW_COMPANY="S0036";
	@ConstantsMeta(name="用户取消关注公司")
	public static final String SERVICE_USER_CANCEL_COMPANY="S0037";
	@ConstantsMeta(name="用户取消/关注公司")
	public static final String SERVICE_USER_CANCEL_FOLLOW_COMPANY="S0038";
	@ConstantsMeta(name="更新资料审核公司名称")
	public static final String SERVICE_UPDATE_COMPANY_NAME="S0039";
	@ConstantsMeta(name="保存职位亮点")
	public static final String SERVICE_SAVE_JOB_LABEL = "S0040";
	@ConstantsMeta(name="保存发布职位信息")
	public static final String SERVICE_SAVE_JOB = "S0041";
	@ConstantsMeta(name="保存公司审核信息")
	public static final String SERVICE_SAVE_COMPANY_TO_EXAMINE = "S0042";
	@ConstantsMeta(name="保存/更新公司信息")
	public static final String SERVICE_SAVE_COMPANY_INFO = "S0043";
	@ConstantsMeta(name="保存录用记录")
	public static final String SERVICE_SAVE_ADMISSION_RECORD = "S0044";

	@ConstantsMeta(name="补充公司展示资料")  
	public static final String APP_COMPANY_PERFECT_INFO = "S0045";

	@ConstantsMeta(name="保存我的主页信息")
	public static final String SERVICE_APP_COMPANY_SAVE_HOMEPAGE_INFO = "S0046";

	@ConstantsMeta(name="注销企业账户")
	public static final String SERVICE_APP_DELTE_ACOMPANY_ACCOUNT = "S0047";

	@ConstantsMeta(name="补充公司展示资料")
	public static final String SERVICE_APP_COMPANY_PERFECT_INFO = "S0048";
	@ConstantsMeta(name="上传附件简历")
	public static final String SUBMIT_ATTACHMENT_RESUME = "S0049";

	@ConstantsMeta(name="编辑公司基本信息")
	public static final String SERVICE_EDIT_COMPANY_BASEIC_INFO = "S0050";

	@ConstantsMeta(name="企业申请加入")
	public static final String SERVICE_COMPANY_APPLY_ADD = "S0051";

	@ConstantsMeta(name="新增/编辑产品")
	public static final String SERVICE_SAVE_COMPANY_INTRODUCTION = "S0052";
	@ConstantsMeta(name="新增/编辑地址")
	public static final String SERVICE_SAVE_COMPANY_ADDRESS = "S0053";

	@ConstantsMeta(name="修改企业接收简历状态")
	public static final String SERVICE_UDATE_RESUME_FEEDBACK = "S0054";
	
	@ConstantsMeta(name="删除地址")
	public static final String SERVICE_DELETE_COMPANY_ADDRESS = "S0055";
	
	@ConstantsMeta(name="删除产品")
	public static final String SERVICE_DELETE_COMPANY_INTRODUCTION = "S0056";

	@ConstantsMeta(name="保存我的投递")
	public static final String SERVICE_SAVE_MY_DELIVERY= "S0057";
	
	@ConstantsMeta(name="企业邀请投递简历")
	public static final String SERVICE_COMPANY_INVITATION_SEND= "S0058";

	@ConstantsMeta(name="保存加入公司审核信息")
	public static final String SERVICE_SAVE_JOIN_COMPANY_AUDIT_INFO = "S0059";

	@ConstantsMeta(name="加入公司保存/更新基本信息")
	public static final String SERVICE_SAVE_JOIN_COMPANY_INFO = "S0060";
	
	@ConstantsMeta(name="企业人员操作")
	public static final String SERVICE_COMPANY_PERSONNEL_OPERATION= "S0061";

	@ConstantsMeta(name="企业用户个人信息保存")
	public static final String SERVICE_COMPANY_USER_DETAIL="S0062";
	
	@ConstantsMeta(name="企业消费操作")
	public static final String SERVICE_COMPANY_ASSETS_OPERATION="S0065";

}
