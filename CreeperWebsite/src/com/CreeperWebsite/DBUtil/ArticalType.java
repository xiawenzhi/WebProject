package com.CreeperWebsite.DBUtil;

public enum ArticalType {
	ARTICAL_TYPE_0("0", "��ѧ����"),
	ARTICAL_TYPE_1("1", "�����"),
	ARTICAL_TYPE_2("2", "����"),
	ARTICAL_TYPE_3("3", "���ı���"),
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
