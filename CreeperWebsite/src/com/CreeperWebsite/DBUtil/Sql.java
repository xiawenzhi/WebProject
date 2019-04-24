package com.CreeperWebsite.DBUtil;

/**
 * 
 *-------------------------------
 * @author WuRongshi
 * @date 2019Äê4ÔÂ16ÈÕ14:51:56
 * @description com.CreeperWebsite.DBUtil.ArticalDao
 *-------------------------------
 */
public class Sql {
	
	public static final String SQL_NEWS_DROP = "DROP TABLE IF EXISTS `news`;";
	public static final String SQL_NEWS_CREATE = "CREATE TABLE `news` (\n" + 
						"  `id` int(10) NOT NULL AUTO_INCREMENT,\n" + 
						"  `img` varchar(100) DEFAULT NULL,\n" + 
						"  `title` varchar(50) DEFAULT NULL,\n" + 
						"  `content` Blob DEFAULT NULL,\n" + 
						"  `type` varchar(10) DEFAULT NULL,\n" + 
						"  `author` varchar(50) DEFAULT NULL,\n" + 
						"  `pudate` varchar(50) DEFAULT NULL,\n" + 
						"  `click` varchar(20) DEFAULT NULL,\n" + 
						"  PRIMARY KEY (`id`)\n" + 
						") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;";
	
	
	public static final String SQL_NEWS_INSERT = 
			"INSERT INTO NEWS(img, title, content, type, author, pudate, click) values (?,?,?,?,?,?,?)";

	
	public static final String SQL_NEWS_SELECTALL = 
			"SELECT a.id, img, title, content, type, author, pudate, click, b.clsname FROM news a LEFT JOIN newsclass b on a.type = b.id ORDER BY pudate DESC LIMIT ?, ?";
	
	
	public static final String SQL_NEWS_COUNT = "SELECT count(0) FROM news";
	
	
	public static final String SQL_NEWS_SELECTBYID = "SELECT a.id, img, title, content, type, author, pudate, click, b.clsname FROM news a LEFT JOIN newsclass b on a.type = b.id WHERE a.id = ?";

	
	public static final String SQL_NEWS_DELETE = "DELETE FROM news WHERE id = ?";
	
	
	public static final String SQL_NEWS_UPDATE = 
			"UPDATE NEWS SET img=?, title=?, content=?, type=?, author=?, pudate=?, click=? where id=?";
	
	public static final String SQL_NEWS_UPDATE_CILICK = 
			"UPDATE NEWS SET click=? where id=?";
	
	
	public static final String SQL_DISSCUSS_CREATE = "CREATE TABLE `discuss` (\n" + 
			"  `id` int(10) NOT NULL AUTO_INCREMENT,\n" + 
			"  `type` varchar(10) DEFAULT NULL,\n" + 
			"  `discussid` varchar(10) DEFAULT NULL,\n" + 
			"  `content` Blob DEFAULT NULL,\n" + 
			"  `userid` varchar(50) DEFAULT NULL,\n" + 
			"  `pudate` varchar(50) DEFAULT NULL,\n" + 
			"  `agree` varchar(20) DEFAULT NULL,\n" + 
			"  PRIMARY KEY (`id`)\n" + 
			") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;";
	
	
	public static final String SQL_DISSCUSS_SELECTBYID = "SELECT id, type, discussid, content, userid, pudate, agree FROM discuss WHERE type=? and discussid = ? ORDER BY agree DESC, pudate DESC LIMIT 0,10";

	
	public static final String SQL_DISSCUSS_NEARID = "(SELECT *,0 as dir FROM news WHERE id < ? ORDER BY id DESC LIMIT 1) UNION ALL (SELECT *,1 as dir FROM news WHERE id > ? LIMIT 1)";
	
	
	public static final String SQL_DISSCUSS_INSERT = "INSERT INTO discuss (type, discussid, content, userid, pudate, agree) values (?,?,?,?,?,?) ";
	
	
	public static final String SQL_DISSCUSS_UPDATEAGREE = "UPDATE discuss SET agree = ? WHERE id = ?";
	
//	public static final String SQL_AGREE_CREATE = "CREATE TABLE `agree` (\n" + 
//			"  `id` int(10) NOT NULL AUTO_INCREMENT,\n" + 
//			"  `type` varchar(10) DEFAULT NULL,\n" + 
//			"  `agreeid` varchar(10) DEFAULT NULL,\n" + 
//			"  `userid` varchar(50) DEFAULT NULL,\n" + 
//			"  `pudate` varchar(50) DEFAULT NULL,\n" + 
//			"  PRIMARY KEY (`id`)\n" + 
//			") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;";
	
	
	public static final String SQL_AGREE_INSERT = "INSERT INTO agree (type, agreeid, userid, pudate) values (?,?,?,?)";
	
	
	public static final String SQL_AGREE_SELECTBYUSERID = "SELECT type, agreeid, userid, pudate FROM agree WHERE userid = ? and agreeid=?";
	
	
	public static final String SQL_AGREE_DELETE = "DELETE  FROM agree WHERE userid = ? and agreeid=?";

	
	public static final String SQL_NEWS_SELECTALLINDEX = 
			"SELECT t.* FROM (SELECT a.id, img, title, content, type, author, pudate, click, b.id as clsid, b.clsname FROM news a LEFT JOIN newsclass b on a.type = b.id ORDER BY pudate DESC LIMIT ?, ?) t ";
	
	
	public static final String SQL_NEWS_COUNTINDEX = "SELECT count(0) FROM (SELECT a.id, img, title, content, type, author, pudate, click, b.id as clsid, b.clsname FROM news a LEFT JOIN newsclass b on a.type = b.id ORDER BY pudate DESC LIMIT ?, ?) t WHERE  t.clsid = ? AND content like ?";
}
