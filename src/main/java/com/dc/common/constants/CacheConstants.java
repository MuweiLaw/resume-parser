package com.dc.common.constants;

public interface CacheConstants {
	
	/**
	 * 登录失败次数
	 */
	String LOGIN_FAIL_COUNT = "user:login:failCount";
	/**
	 * 转让失败次数
	 */
	String TRANSFER_FAIL_COUNT = "user:transfer:failCount";
	/**
	 * 踢出失败次数
	 */
	String EXIT_FAIL_COUNT = "user:exit:failCount";
	/**
	 * 缓存用户token
	 */
	String REDIS_USER_TOKEN_MAPPING_NAME = "user:pc:token";
	/**
	 * 缓存APP用户token
	 */
	String REDIS_APP_USER_TOKEN_MAPPING_NAME = "user:app:token";
	/**
	 * 缓存滑动验证码位置
	 */
	String REDIS_USER_CAPTCHA_POSITION = "user:captcha:position:";
	/**
	 * 缓存用户手机号发送注册短信验证码次数
	 */
	String REDIS_USER_REGIST_MESSAGE_COUNT = "user:regist:message:count:";
	/**
	 * 缓存用户发送短信验证码的ip
	 */
	String REDIS_USER_MESSAGE_IP="user:sendmessage:userip:";
	/**
	 * 缓存用户手机号发送注册短信验证码
	 */
	String REDIS_USER_MESSAGE_CAPTCHA = "user:message:captcha:";
	/**
	 * 缓存用户上次发送短信验证码的时间
	 */
	String REDIS_USER_MESSAGE_BEFORE_TIME = "user:message:beforetime:";
	/**
	 * 系统配置值读取
	 */
	String REDIS_KEY_PROPERTY = "PROPERTY";
	/**
	 * 缓存用户图片验证码
	 */
	String REDIS_USER_CAPTCHAS_NAME = "user:captchas";
	
	/**
	 * 消息模板
	 */
	String REDIS_MESSAGE_TEMPLATE = "message:template";
}
