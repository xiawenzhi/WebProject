package com.CreeperWebsite.DBUtil;
import java.sql.*;

public class JDBCConnection {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL = "jdbc:sqlserver://localhost:1435;DatabaseName=CreeperWebsite";
    private static final String USER ="wurongshi";
    private static final String PASSWORD ="wurongshi";
    
    private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	public JDBCConnection() {  //���캯��
		jdbcConn();
		
	}
	
	public boolean jdbcConn() {   //�������ݿ�
		try {
            //1.������������
            Class.forName(DRIVER);
            //2.������ݿ������
            conn = (Connection)DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		if(conn == null) {
			return false;
		}
		
		return true;
	}
	
	public void closeConn(){
		if(rs!=null){			
			try {
				rs.close();			
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(stmt!=null){
			try {
				stmt.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}			
	}
	
	public ResultSet jdbcQuery(String sql) {   //��ѯ����

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);			
			return rs;		
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("��ѯʧ�ܣ�");
			return null;		
		}
	}

	public boolean jdbcUpdate(String sql) {   //��ɾ�Ĳ����

		try{					
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			return true;								
		} catch(SQLException e) {			
			e.printStackTrace();
			System.out.println("����ʧ�ܣ�");
			return false;		
		}
	}
}
