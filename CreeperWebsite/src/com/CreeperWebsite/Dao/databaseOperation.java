package com.CreeperWebsite.Dao;
import java.sql.*;
import java.util.List;

import com.CreeperWebsite.DBUtil.*;
import com.CreeperWebsite.Entity.commodityEntity;
 

public class databaseOperation {

	JDBCConnection conn = new JDBCConnection();
	
	public databaseOperation() {
		// TODO Auto-generated constructor stub
		System.out.println("databaseOperation ���󴴽��ɹ���");
	}
	
	//TODO�����û��Ĳ���
	public boolean userLogin(int userId, String pwd) {   //��֤�û���¼
		String sql = "select * from userLogin where userId = " + userId + "and userPwd = '" + pwd + "'";
		
		try {
			ResultSet rs = conn.jdbcQuery(sql);
			
			if(rs.next())
			{
				return true;
			}
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
			
		return false;
	}
	
	public boolean addUser(int userId, String pwd, int userType) {   //��֤�û���¼
		String sql = "insert into userLogin(userId, userPwd, type) "
				+ "values(" + userId + ",'" + pwd + "'," + userType + ");";
		
		if(conn.jdbcUpdate(sql))
		{
			return true;
		}
			
		return false;
	}
	
	public boolean setUserStatus(int userId) {   //��֤�û���¼
		String sql = "select * from userLogin where userId = " + userId; 
		
		try {
			ResultSet rs = conn.jdbcQuery(sql);
			
			if(rs.next()) {
				System.out.println("xq");
				String sql1 = "update userLogin set status = 1 where userId = " + userId;
				
				if(conn.jdbcUpdate(sql1)) {
					return true;
				}
			}
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		return false;
	}
	
	public boolean changePassword(int userId, String pwd) {   //�û��޸�����
		String sql = "update userInfo set userPwd = '" + pwd + "'";
        
		if(conn.jdbcUpdate(sql)) {
			return true;
		}		
			
		return false;
	}
	
	public boolean changeInfo(int userId) {
		return true;
	}
	//TODO:�����µĲ���
	//TODO������Ʒ�Ĳ���
	@SuppressWarnings("null")
	public List<commodityEntity> selectBooks()
	{
		CommodityDao comm = null;
		String sql = "select * from commodity";
		
		List<commodityEntity> list = comm.GetCommodityInfos(sql);
		
		return list;
	}
	
	public boolean insertorupdateGoods(long goodsId, String goodsName, String title, String description, 
			int pre_price, int now_price, long goodsNum) { //��ƷͼƬ������������
		String sql = "select * from commdity where goodsId = " + goodsId;
		ResultSet rs = conn.jdbcQuery(sql);
		String sql1 = "";
		
		try {
			if(rs.next()) {
				sql1 = "update commdity set goodsName = '" + goodsName + "', title = '" + title + "', description = '"
						+ description + "', pre_price = " + pre_price + ", now_price = " + now_price + ", goodsNum = " + goodsNum;
			}
			else
			{
				sql1 = "insert into commdity(goodsId, goodsName, title, description, pre_price, now_price, goodsNum)"
			            + "values(" + goodsId + ", '" + goodsName + "', '" + title + "','" + description + "'," + pre_price 
			        	+ "," + now_price + "," + goodsNum +")";
			}
			
			if(conn.jdbcUpdate(sql1)) {
				return true;
			}
		} catch (SQLException e) {
            e.printStackTrace();
            return false;
        }  
				
		return false;
	}
}
