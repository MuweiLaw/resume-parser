package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(group="MARRIGAE_STATUS",comment="婚姻状态")
public class MarriageStatusConstants {
	
	@ConstantsMeta(name="未婚",group="MARRIGAE_STATUS")
	public static final String MARRIGAE_STATUS_UNMARRIED = "UNMARRIED";
	@ConstantsMeta(name="已婚",group="MARRIGAE_STATUS")
	public static final String MARRIGAE_STATUS_MARRIED = "MARRIED";
	@ConstantsMeta(name="保密",group="MARRIGAE_STATUS")
	public static final String MARRIGAE_STATUS_SECRET = "SECRET";
	
}
