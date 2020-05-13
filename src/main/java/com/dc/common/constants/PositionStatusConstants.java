package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group="POSITION_STATUS",comment="职位状态")
public class PositionStatusConstants {
	
	@ConstantsMeta(name="新建")
	public static final String POSITION_STATUS_NEW = "NEW";
	@ConstantsMeta(name="已发布")
	public static final String POSITION_STATUS_PUBLISHED = "PUBLISHED";
	@ConstantsMeta(name="暂停")
	public static final String POSITION_STATUS_SUSPEND = "SUSPEND";
	@ConstantsMeta(name="下架")
	public static final String POSITION_STATUS_CANCEl = "CANCEl";
}
