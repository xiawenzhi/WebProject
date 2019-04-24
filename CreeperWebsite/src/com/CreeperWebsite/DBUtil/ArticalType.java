package com.CreeperWebsite.DBUtil;

public enum ArticalType {
	ARTICAL_TYPE_0("0", "大学四年"),
	ARTICAL_TYPE_1("1", "身边事"),
	ARTICAL_TYPE_2("2", "征稿"),
	ARTICAL_TYPE_3("3", "爱心爆棚"),
	;
	
	private String pCode;
	private String pName;
	
	private ArticalType(String pCode, String pName) {
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
