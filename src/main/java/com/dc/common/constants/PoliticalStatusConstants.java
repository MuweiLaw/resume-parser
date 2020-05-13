package com.dc.common.constants;


import com.dc.annotation.ConstantsMeta;

@ConstantsMeta(comment="政治面貌",group="POLITICAL_STATUS")
public class PoliticalStatusConstants {
	@ConstantsMeta(name="中共党员")
	public static final String POLITICAL_STATUS_CCP_MEMBER = "CCP_MEMBER";
	@ConstantsMeta(name="民主党派人士")
	public static final String POLITICAL_STATUS_DP_MEMBER = "DP_MEMBER";
	@ConstantsMeta(name="无党派民主人士")
	public static final String POLITICAL_STATUS_INDEPENDENT_DEMOCRAT = "INDEPENDENT_DEMOCRAT";
	@ConstantsMeta(name="普通公民")
	public static final String POLITICAL_STATUS_CITIZEN = "CITIZEN";
	@ConstantsMeta(name="共青团员")
	public static final String POLITICAL_STATUS_CYL_MEMBER = "CYL_MEMBER";
}
