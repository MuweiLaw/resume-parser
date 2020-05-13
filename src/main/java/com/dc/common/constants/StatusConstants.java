package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group="EXE_STATUS",comment="执行状态")
public class StatusConstants {
	
	@ConstantsMeta(name="初始化")
	public static final String NORMAL = "N";
	@ConstantsMeta(name="成功")
	public static final String SUCCESS = "S";
	@ConstantsMeta(name="失败")
	public static final String FAILURE = "F";
	@ConstantsMeta(name="工作中")
	public static final String WORK = "W";
	@ConstantsMeta(name="重新执行")
	public static final String RERUN = "R";
	
}
