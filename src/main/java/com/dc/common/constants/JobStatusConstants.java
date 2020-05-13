package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group="JOB_STATUS",comment="个人工作状态")
public class JobStatusConstants {
	
	@ConstantsMeta(name="目前在找工作")
	public static final String JOB_STATUS_HUNTING = "HUNTING";
	@ConstantsMeta(name="观望工作机会")
	public static final String JOB_STATUS_EXPECT = "EXPECT";
	@ConstantsMeta(name="目前不想换工作")
	public static final String JOB_STATUS_NO_INTENTION = "NO_INTENTION";
	
}
