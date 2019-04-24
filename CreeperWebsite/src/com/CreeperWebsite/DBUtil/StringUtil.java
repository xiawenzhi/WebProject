package com.CreeperWebsite.DBUtil;

public class StringUtil {

	public StringUtil() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static boolean isNotEmpty(String str){
		if(str == null || "".equals(str)){
			return false;
		}else{
			return true;
		}
	}
	
	public static boolean isEmpty(String str){
		if(str == null || "".equals(str)){
			return true;
		}else{
			return false;
		}
	}
	
	
	public static String lengthControl(String str, int len){
		String result = "";
		if(str.length() < len){
			result = str;
		}else{
			result = str.substring(0, len) + "...";
		}
		return result;
	}
	
	
	public String stripHtml(String content) { 
	    
	    content = content.replaceAll("<p .*?>", "\r\n"); 
	    
	    content = content.replaceAll("<br\\s*/?>", "\r\n"); 
	    
	    content = content.replaceAll("\\<.*?>", ""); 
	    
	    content = content.replaceAll(" ", ""); 
	    return content;   
	}

	
	public static String delHtmlTag(String str){ 
	    String newstr = ""; 
	    newstr = str.replaceAll("<[.[^>]]*>","");
	    newstr = newstr.replaceAll(" ", ""); 
	    return newstr;
	}
}
