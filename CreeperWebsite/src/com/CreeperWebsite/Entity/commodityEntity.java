package com.CreeperWebsite.Entity;

public class commodityEntity {
	private int id;	
	private int goodsId;
	private String goodsName;
	private String title;
	private String titlePicture;
	private String description;
	private int price;
	private int goodsNum;
	private String goodsPicture;
	
	public commodityEntity(int id, int goodsId, String goodsName, String title, 
			String titlePicture, String description, int price, int goodsNum,
			String goodsPicture) {
		this.id = id;
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.title = title;
		this.titlePicture = titlePicture;
		this.description = description;
		this.price = price;
		this.goodsNum = goodsNum;
		this.goodsPicture = goodsPicture;
	}
	
	public int getid() {		
		return id;	
	}
	
	public void setid(int id) 
	{		
		this.id = id;	
	}
	
	public int getgoodsId() {		
		return goodsId;	
	}
	
	public void setgoodsId(int goodsId) 
	{		
		this.goodsId = goodsId;	
	}
	
	public String getgoodsName() {		
		return goodsName;	
	}
	
	public void setgoodsName(String goodsName) 
	{		
		this.goodsName = goodsName;	
	}
	
	public String gettitle() {		
		return title;	
	}
	
	public void settitle(String title) 
	{		
		this.title = title;	
	}
	
	public String gettitlePicture() {		
		return titlePicture;	
	}
	
	public void settitlePicture(String titlePicture) 
	{		
		this.titlePicture = titlePicture;	
	}
	
	public String getdescription() {		
		return description;	
	}
	
	public void setdescription(String description) 
	{		
		this.description = description;	
	}
	
	public int getprice() {		
		return price;	
	}
	
	public void setprice(int price) 
	{		
		this.price = price;	
	}
	
	public int getgoodsNum() {		
		return goodsNum;	
	}
	
	public void setgoodsNum(int goodsNum) 
	{		
		this.goodsNum = goodsNum;	
	}
	
	public String getgoodsPicture() {		
		return goodsPicture;	
	}
	
	public void setgoodsPicture(String goodsPicture) 
	{		
		this.goodsPicture = goodsPicture;	
	}
}
