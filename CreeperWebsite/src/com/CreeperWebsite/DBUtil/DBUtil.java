package com.CreeperWebsite.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 
 *-------------------------------
 * @author WuRongshi
 * @date 2019��4��16��14:51:56
 * @description com.CreeperWebsite.DBUtil
 *-------------------------------
 */
public class DBUtil {
	public static final String url = "jdbc:mysql://localhost:3306/db";
	public static final String driver = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "wurongshi";
	public Connection conn = null;
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ�");
		} catch (Exception e) {
			System.out.println("���ݿ�����ʧ��!");
			e.printStackTrace();
		}
		return conn;
	}
}
