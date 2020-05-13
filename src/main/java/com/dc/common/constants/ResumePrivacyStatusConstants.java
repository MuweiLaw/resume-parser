package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group="RESUME_PRIVACY_STATUS",comment="简历公开状态")
public class ResumePrivacyStatusConstants {
	@ConstantsMeta(name="所有人可见")
	public static final String RESUME_PRIVACY_STATUS_PUBLIC = "PUBLIC";
	@ConstantsMeta(name="所投公司可见")
	public static final String RESUME_PRIVACY_STATUS_CHOOSEN = "CHOOSEN";
	
	
}
