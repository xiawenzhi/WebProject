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

public class ArticalDao {
	public int id;
	public String img;
	public String title;
	public String content;
	public String type;
	public String author;
	public String pudate;
	public String click;
	public List<DiscussDao> list;
	public int pre;
	public int next;
	public String preTitle;
	public String nextTitle;
	
	public ArticalDao(int id, String img, String title, String content, String type, String author, String pudate, String click) {
		this.id = id;
		this.img = img;
		this.title = title;
		this.content = content;
		this.type = type;
		this.author = author;
		this.pudate = pudate;
		this.click = click;
	}
	
	public int getPre() {
		return pre;
	}
	
	public void setPre(int pre) {
		this.pre = pre;
	}
	
	public int getNext() {
		return next;
	}
	
	public void setNext(int next) {
		this.next = next;
	}
	
	public String getPreTitle() {
		return preTitle;
	}
	
	public void setPreTitle(String preTitle) {
		this.preTitle = preTitle;
	}
	
	public String getNextTitle() {
		return nextTitle;
	}
	
	public void setNextTitle(String nextTitle) {
		this.nextTitle = nextTitle;
	}
	
	public List<DiscussDao> getList() {
		return list;
	}
	
	public void setList(List<DiscussDao> list) {
		this.list = list;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getImg() {
		return img;
	}
	
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPudate() {
		return pudate;
	}
	
	public void setPudate(String pudate) {
		this.pudate = pudate;
	}
	
	public String getClick() {
		return click;
	}
	
	public void setClick(String click) {
		this.click = click;
	}
}
