package com.CreeperWebsite.Dao;

import java.util.List;

/**
 * 
 *-------------------------------
 * @author WuRongshi
 * @date 2019Äê4ÔÂ16ÈÕ14:51:56
 * @description com.CreeperWebsite.DBUtil.ArticalDao
 *-------------------------------
 */

public class DiscussDao {
	public int id;
	public String type;
	public String discussId;
	public String content;
	public String userId;
	public String pudate;
	public String agree;
	public List<DiscussDao> list;
	
	public DiscussDao(int id, String type, String discussId, String content,String userId, String pudate, String agree) {
		this.id = id;
		this.type = type;
		this.discussId = discussId;
		this.content = content;
		this.userId = userId;
		this.pudate = pudate;
		this.agree = agree;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPudate() {
		return pudate;
	}
	public void setPudate(String pudate) {
		this.pudate = pudate;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	public String getDiscussId() {
		return discussId;
	}
	public void setDiscussId(String discussId) {
		this.discussId = discussId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<DiscussDao> getList() {
		return list;
	}
	public void setList(List<DiscussDao> list) {
		this.list = list;
	}

}
