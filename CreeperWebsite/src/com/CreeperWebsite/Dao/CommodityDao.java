package com.CreeperWebsite.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CreeperWebsite.DBUtil.JDBCConnection;
import com.CreeperWebsite.Entity.*;

public class CommodityDao {

	public CommodityDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<commodityEntity> GetCommodityInfos(String sql) {
		List<commodityEntity> commodityInfos = new ArrayList<commodityEntity>();
		JDBCConnection dbconn = new JDBCConnection();
		ResultSet rs = dbconn.jdbcQuery(sql);
		
		try{
			while(rs.next()) {
				commodityEntity commodityInfo = new commodityEntity();
				commodityInfo.setid(rs.getInt("id"));
				commodityInfo.setgoodsId(rs.getInt("goodsId"));
				commodityInfo.setgoodsName(rs.getString("goodsName"));
				commodityInfo.settitle(rs.getString("title"));
				commodityInfo.setdescription(rs.getString("description"));
				commodityInfo.setprice(rs.getInt("price"));
				commodityInfo.setgoodsNum(rs.getInt("goodsNum"));
				commodityInfo.setgoodsPicture(rs.getString("goodsPicture"));
				commodityInfos.add(commodityInfo);
			}
			
			return commodityInfos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			dbconn.closeConn();
		}
	}
}
