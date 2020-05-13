package com.dc.common.constants;

/**
 * 错误code及信息
 * @author David
 */
public enum ResultConstants {
	RESULT_FAIL("操作失败"),
	LOGIN_FAIL("登录失败"),
	PARAMS_IS_NULL("未接收到参数"),
	USER_NAME_IS_NULL("账号不能为空"),
	PASSWORD_IS_NULL("密码不能为空"),
	TYPE_ERROR("用户类型错误"),
	USER_NAME_NOT_EXIST("用户名不存在"),
	USER_ID_NOT_EXIST("用户不存在"),
	USER_NAME_IS_EXIST("用户名已存在"),
	USER_NAME_IS_WRONG("用户名不合法"),
	USER_TYPE_IS_WRONG("用户类型不正确"),
	LOGIN_FAIL_COUNT("登录失败次数超限"),
	LOGIN_PASSWORD_ERROR("密码输入错误"),
	RESET_PASSWORD_FAIL("重置密码失败"),
	OLD_PASSWORD_ERROR("原始密码不正确"),
	SEND_SMS_FAIL_COUNT("发送验证码次数超限"),
	SEND_SMS_FAIL("发送短信验证码失败"),
	CAPTCHA_TYPE_NOT_NULL("验证码类型不能为空"),
	CAPTCHA_NOT_NULL("验证码不能为空"),
	CAPTCHA_NOT_EXPIRY("验证码未过期"),
	CAPTCHA_NOT_IN_EXPIRY("验证码已过期,请刷新重试"),
	CAPTCHA_IS_ERROR("验证码不正确"),
	CAPTCHA_FREQUENTLY("验证码未过60秒"),
	VERIFY_CAPTCHA_ERROR("校验验证码失败"),
	NO_FIND_SMS_TEMPLATE("获取不到短信模板"),
	SAVE_SMS_INFO_FAIL("保存短信详情失败"),
	SLIDE_SMS_ERROR("滑动验证码不正确"),
	PHONENO_IS_WRONG("手机号格式不正确"),
	PHONENO_IS_EXIST("手机号已存在"),
	PHONENO_IS_NOT_EXIST("手机号不存在"),
	PHONENO_IS_NULL("手机号不能为空"),
	EMAIL_IS_NULL("邮箱不能为空"),
	EMAIL_IS_WRONG("邮箱格式不正确"),
	EMAIL_IS_EXIST("邮箱已存在"),
	SEND_EMAIL_FAIL("发送邮箱失败"),
	TWICE_PASSWORD_NOT_EQUALS("两次输入的密码不一致"),
	SAVE_USER_INFO_FAIL("保存用户信息失败"),
	SAVE_USER_INFO_WX_FAIL("保存用户微信信息失败"),
	GET_CURRENT_USER_FAIL("获取当前用户信息失败"),
	QUERY_PROVINCE_AND_AREA_EXP("查询省市区异常"),
	PHONENO_NOT_REGIST("该手机号未注册"),
	ENTERPRISE_STATE_ERROR("企业状态信息有误"),
	ALREADY_WECHAT("此微信已被绑定！"),
	AUTO_REGIST_FAIL("自动注册失败"),
	WX_WRONG("微信信息有误！"),
	NO_ADMIN("非管理员"),
	NOT_SEND_MESSAGE("次数已超,无法再发送短信");
	private String msg;
	
	private ResultConstants(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return msg;
	}
}
