package com.CreeperWebsite.DBUtil;

public class UFunction {

	public UFunction() {
		// TODO Auto-generated constructor stub
	}

	
	public static String formatDate(String dateTime){
		if(StringUtil.isNotEmpty(dateTime)){
			return dateTime.substring(0,4) + "-" +dateTime.substring(4,6) + "-" + dateTime.substring(6,8); 
		}
		return dateTime;
	}
	
	public static String formatMD(String dateTime){
		if(StringUtil.isNotEmpty(dateTime)){
			String mon = dateTime.substring(4,5).equals("0") ? dateTime.substring(5,6) : dateTime.substring(4,6);
			String day = dateTime.substring(6,7).equals("0") ? dateTime.substring(7,8) : dateTime.substring(6,8);
			return mon + "æœ?" + day + "æ—?"; 
		}
		return dateTime;
	}
	
	public static String formatDateTime(String dateTime){
		if(StringUtil.isNotEmpty(dateTime)){
			return dateTime.substring(0,4) + "-" +dateTime.substring(4,6) + "-" + dateTime.substring(6,8) + " " 
					+ dateTime.substring(8,10) + ":" + dateTime.substring(10,12) + ":" + dateTime.substring(12,14); 
		}
		return dateTime;
	}
}
