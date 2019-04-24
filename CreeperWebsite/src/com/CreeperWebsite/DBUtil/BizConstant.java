package com.CreeperWebsite.DBUtil;

public enum BizConstant {
	BIZ_NEWS_0("0","0"),
	BIZ_NEWS_1("1","1"),
	BIZ_NEWS_2("2","2"),
	BIZ_NEWS_3("3","3"),
	BIZ_NEWS_4("4","4"),
	BIZ_NEWS_5("5","5"),
	BIZ_NEWS_6("6","6"),
	BIZ_NEWS_7("7","7"),
	BIZ_NEWS_8("8", "登录"),
	BIZ_NEWS_9("9", "注册"),
	BIZ_NEWS_10("10", "商品管理"),
	BIZ_NEWS_11("11", "用户管理"),
	BIZ_NEWS_12("12", "商城"),
	;
	
	private String pCode;
	private String pName;
	
	private BizConstant(String pCode, String pName) {
		this.pCode = pCode;
		this.pName = pName;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}	
}
