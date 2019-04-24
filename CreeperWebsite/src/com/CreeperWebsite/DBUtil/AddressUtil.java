package com.CreeperWebsite.DBUtil;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class AddressUtil {

	public AddressUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String getAddresses(String content, String encodingString)throws UnsupportedEncodingException {  
		
		String urlStr = "http://ip.taobao.com/service/getIpInfo.php";  
		String returnStr = getResult(urlStr, content, encodingString);  
		
		if (returnStr != null) {  
			 String[] temp = returnStr.split(",");  
			 if(temp.length<3){  
				 return "0";
		}
			 
	    String region = (temp[5].split(":"))[1].replaceAll("\"", "");  
	    region = decodeUnicode(region);
	    
		String country = "";  
		String area = "";  
		// String region = "";  
		String city = "";  
		String county = "";  
		String isp = ""; 
		
		for (int i = 0; i < temp.length; i++) {  
		    switch (i) {  
		    case 1:  
		        country = (temp[i].split(":"))[2].replaceAll("\"", "");  
		        country = decodeUnicode(country);
		        break;  
		        case 3:  
		            area = (temp[i].split(":"))[1].replaceAll("\"", "");  
		            area = decodeUnicode(area);
		        break;  
		        case 5:  
		            region = (temp[i].split(":"))[1].replaceAll("\"", "");  
		            region = decodeUnicode(region);  
		        break;   
		        case 7:  
		            city = (temp[i].split(":"))[1].replaceAll("\"", "");  
		            city = decodeUnicode(city);
		        break;   
		        case 9:  
		                county = (temp[i].split(":"))[1].replaceAll("\"", "");  
		                county = decodeUnicode(county);
		        break;  
		        case 11:  
		            isp = (temp[i].split(":"))[1].replaceAll("\"", "");  
		            isp = decodeUnicode(isp); 
		        break;  
		    }  
		}  
	    return region;  
		}  
		return null;  
	 }  
 
	 private static String getResult(String urlStr, String content, String encoding) {  
		URL url = null;  
		HttpURLConnection connection = null;  
		try {  
			url = new URL(urlStr);  
			connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(2000);
			connection.setReadTimeout(2000); 
			connection.setDoOutput(true);  
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.connect();
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.writeBytes(content);
			out.flush();
			out.close();
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), encoding));  
			StringBuffer buffer = new StringBuffer();  
			String line = "";  
			
			while ((line = reader.readLine()) != null) {  
				  buffer.append(line);  
			}  
			reader.close();  
			return buffer.toString();  
	  	} catch (IOException e) {  
	  		e.printStackTrace();  
	  	} finally {  
	  		if (connection != null) {  
	  			connection.disconnect(); 
	  		}  
	  	}  
		return null;  
	 }  
	 
	 public static String decodeUnicode(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed      encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't') {
						aChar = '\t';
					} else if (aChar == 'r') {
						aChar = '\r';
					} else if (aChar == 'n') {
						aChar = '\n';
					} else if (aChar == 'f') {
						aChar = '\f';
					}
					outBuffer.append(aChar);
				}
			} else {
				outBuffer.append(aChar);
			}
		}
		return outBuffer.toString();
	}
}
