package com.CreeperWebsite.Dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.CreeperWebsite.Entity.*;
import com.CreeperWebsite.DBUtil.*;

public class userInfoDao {

	public userInfoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<userInfoEntity> GetUserInfos(String sql) {
		List<userInfoEntity> userInfos = new ArrayList<userInfoEntity>();
		JDBCConnection dbconn = new JDBCConnection();
		ResultSet rs = dbconn.jdbcQuery(sql);
		
		try{
			while(rs.next()) {
				userInfoEntity userInfo = new userInfoEntity();
				userInfo.setid(rs.getInt("id"));
				userInfo.setuserId(rs.getInt("userId"));
				userInfo.setuserName(rs.getString("userName"));
				userInfo.setuserType(rs.getInt("userType"));
				userInfo.setuserSex(rs.getInt("userSex"));
				userInfo.setuserBirth(rs.getDate("userBirth"));
				userInfo.settelNumber(rs.getString("telNumber"));
				userInfos.add(userInfo);
			}
			
			return userInfos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			dbconn.closeConn();
		}
	}
}
