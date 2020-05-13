package com.dc.common.constants;


public interface SystemConfigConstants {
	/**apigid*/
	String apiGid = "xclmApi";
	String smsExpiryTimePid = "smsExpiryTime";//短信验证码有效时间配置pid
	String smsMaxCountPid = "smsMaxCount";//单日单账户发送验证码的最大条数
	String emailSmsExpiryTimePid = "emailSmsExpiryTime";//邮箱验证码有效时间配置pid
	String slideCaptchaThresholdPid = "slideCaptchaThreshold";//滑动验证码验证阀值


	
	/**系统环境gid*/
	String sysEnvironmentGid = "switch";
	/**系统环境pid DEV：开发，PRO：生产*/
	String sysEnvironmentPid = "enviroment";
	
	/**邮件相关*/
	String emailGid = "email";
	String sendMailAddressPid = "sendMailAddress";
	String passWordPid = "passWord";
	String SMTPHostPid = "SMTPHost";
	String SMTPPortPid = "SMTPPort";
	
	
	/**短信类型*/
	String SMS_TYPE_REGIST = "0";//注册短信
	
	/**个人用户id前缀*/
	String personal_prefix = "P";
	/**企业用户id前缀*/
	String company_prefix = "C";
	
	/**个人用户*/
	String PERSONAL = "personal";
	/**企业用户*/
	String COMPANY = "company";
	/**企业子用户*/
	String SUBCOMPANY = "subcompany";
	
	String USER_TYPE = "userType";

	String USER_INFO = "userInfo";
	/**企业用户状态*/
	String INIT= "INIT";//初始化 
	String AUTHREJECT= "AUTHREJECT";//审核拒绝
	String NORMOAL= "NORMOAL";//正常
	String SUBAUTH= "SUBAUTH";//审核中
	
	/**环境常量*/
	String DEV = "DEV";//开发环境
	String PRO = "PRO";//生产环境
	
	/**判断是非*/
	String YES = "Y";//是
	String NO = "N";//否
	
	/**图形验证码key*/
	String KAPTCHA_SESSION_KEY = "KAPTCHA_SESSION_KEY";
	
	/**四个直辖市特殊处理*/
	String BEI_JING = "BeiJing";
	String SHANG_HAI = "ShangHaiShi";
	String TIAN_JIN = "TianJing";
	String CHONG_QING = "ChongQing";
	
}
