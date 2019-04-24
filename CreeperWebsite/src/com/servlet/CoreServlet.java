package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CreeperWebsite.DBUtil.AddressUtil;
import com.CreeperWebsite.DBUtil.BizConstant;
import com.CreeperWebsite.DBUtil.DBUtil;
import com.CreeperWebsite.DBUtil.IPUtil;
import com.CreeperWebsite.DBUtil.Sql;
import com.CreeperWebsite.DBUtil.StringUtil;
import com.CreeperWebsite.Dao.ArticalDao;
import com.CreeperWebsite.Dao.DiscussDao;
import com.CreeperWebsite.Dao.databaseOperation;
import com.CreeperWebsite.Entity.commodityEntity;

import net.sf.json.JSONObject;

public class CoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CoreServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String TypeCode = request.getParameter("TypeCode");
		databaseOperation dbo = new databaseOperation();
		DBUtil dbUtil = new DBUtil();
		// System.out.println("get bixcode = " + TypeCode);
		request.getSession().setAttribute("rootPath", request.getContextPath());
		// System.out.println("request.getContextPath() = " + request.getContextPath());
		
		if(BizConstant.BIZ_NEWS_0.getpCode().equals(TypeCode)) {
			System.out.println("TypeCode == 0");
			String id = request.getParameter("id");
			
			String title = request.getParameter("title");
			String type = request.getParameter("type");
			String content = request.getParameter("content");
			String cover = request.getParameter("cover");
			
			String author = (String) request.getSession().getAttribute("username");
			String pdate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String click = "0";
			
			Connection conn = dbUtil.getConnection();
			try {
				
				PreparedStatement pst = null;
				
				
				if("0".equals(id)) {
					pst = conn.prepareStatement(Sql.SQL_NEWS_INSERT);
				}else {
					pst = conn.prepareStatement(Sql.SQL_NEWS_UPDATE);
					pst.setInt(8, Integer.parseInt(id));
				}
				
				pst.setString(1, cover);
				pst.setString(2, title);
				pst.setString(3, content);
				pst.setString(4, type);
				pst.setString(5, author);
				pst.setString(6, pdate);
				pst.setString(7, click);
				pst.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			response.sendRedirect(request.getContextPath()+"/servlet/CoreServlet?TypeCode=1");
			
		}else if(BizConstant.BIZ_NEWS_1.getpCode().equals(TypeCode)) {
			
			Connection conn = dbUtil.getConnection();
			ResultSet rs = null;
			try {
				String pageNo = request.getParameter("pageNo");
				String pageSize = request.getParameter("pageSize");
				
				if(StringUtil.isEmpty(pageNo)) {
					pageNo = "0";
				}
				
				if(StringUtil.isEmpty(pageSize)) {
					pageSize = "10";
				}
				System.out.println("pageNo == " + pageNo);
				System.out.println("pageSize == " + pageSize);
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_NEWS_SELECTALL);
				
				int start = Integer.parseInt(pageNo) * Integer.parseInt(pageSize);
				int end = start + Integer.parseInt(pageSize);
				pst.setInt(1, start);
				pst.setInt(2, end);
				rs = pst.executeQuery();
				
				
				List<ArticalDao> articalList = new ArrayList<ArticalDao>();
				while(rs.next()) {
					int id = rs.getInt("id");
					String img = rs.getString("img");
					String title = rs.getString("title");
					String content = new String(rs.getString("content").getBytes("ISO-8859-1"),"UTF-8");
					String clsname = rs.getString("clsname");
					String author = rs.getString("author");
					String pudate = rs.getString("pudate");
					String click = rs.getString("click");

					ArticalDao artical = new ArticalDao(id, img, title, content, 
							clsname, author, pudate, click);
					articalList.add(artical);
				}
				
				int articalCount = articalList.size();
				int size = Integer.parseInt(pageSize);
				int pageCount = articalCount / size;
				if(articalCount % size != 0){
					pageCount ++;
				}
				
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("articalList", articalList);
				request.setAttribute("pageNo", pageNo);
				
				String username = (String) request.getSession().getAttribute("userId");
				request.setAttribute("username", username);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			this.getServletContext().getRequestDispatcher("/creeper/admin.jsp").forward(request, response);
		}
		else if(BizConstant.BIZ_NEWS_2.getpCode().equals(TypeCode)) {
			String id = request.getParameter("id");
			Connection conn = dbUtil.getConnection();
			ResultSet rs = null;
			ArticalDao articals = null;
			try {
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_NEWS_SELECTBYID);
				pst.setInt(1, Integer.parseInt(id));
				rs = pst.executeQuery();
				while(rs.next()){
					articals = new ArticalDao(rs.getInt("id"), rs.getString("img"), rs.getString("title"),
							new String(rs.getString("content").getBytes("ISO-8859-1"),"UTF-8"), rs.getString("type"), rs.getString("author"),
							rs.getString("pudate"), rs.getString("click"));
					request.setAttribute("news", articals);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			PrintWriter pw = response.getWriter();
			//JSONObject jb = new JSONObject();
			pw.write(JSONObject.fromObject(articals).toString());
			pw.flush();
			pw.close();
			
		}else if(BizConstant.BIZ_NEWS_3.getpCode().equals(TypeCode)) {
			String id = request.getParameter("id");
			Connection conn = dbUtil.getConnection();
			try {
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_NEWS_DELETE);
				pst.setInt(1, Integer.parseInt(id));
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			response.sendRedirect(request.getContextPath() + "/servlet/CoreServlet?TypeCode=1");
			
		}
		else if(BizConstant.BIZ_NEWS_4.getpCode().equals(TypeCode)){
			String articalId = request.getParameter("articalId");
			Connection conn = dbUtil.getConnection();
			ResultSet rs = null;
			ArticalDao articals = null;
			System.out.println("articalId = " + articalId);
			
			try {
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_NEWS_SELECTBYID);
				pst.setInt(1, Integer.parseInt(articalId));
				rs = pst.executeQuery();
				while(rs.next()){
					int id = rs.getInt("id");
					String img = rs.getString("img");
					String title = rs.getString("title");
					String content = new String(rs.getString("content").getBytes("ISO-8859-1"),"UTF-8");
					String clsname = rs.getString("clsname");
					String author = rs.getString("author");
					String pudate = rs.getString("pudate");
					String click = rs.getString("click");
					
					articals = new ArticalDao(id, img, title, content, clsname, author, pudate, click);
					request.setAttribute("articals", articals);
				}
				
				pst = conn.prepareStatement(Sql.SQL_DISSCUSS_SELECTBYID);
				pst.setString(1, "0");
				pst.setString(2, articalId);
				rs = pst.executeQuery();

				List<DiscussDao> disList = new ArrayList<DiscussDao>(); //一级评论
				
				while(rs.next()) {
					DiscussDao discuss = new DiscussDao(rs.getInt("id"),
							rs.getString("type"), 
							rs.getString("discussId"),
							new String(rs.getString("content").getBytes("ISO-8859-1"),"UTF-8"), 
							rs.getString("userId"), 
							rs.getString("pudate"),
							rs.getString("agree"));
					
					pst = conn.prepareStatement(Sql.SQL_DISSCUSS_SELECTBYID);
					pst.setString(1, "1");
					pst.setString(2, discuss.getId() + "");
					ResultSet rssub = pst.executeQuery();
					List<DiscussDao> disListsub = new ArrayList<DiscussDao>();
					
					while(rssub.next()) {   // 二级评论
						DiscussDao discusssub = new DiscussDao(rssub.getInt("id"), 
								rssub.getString("type"), 
								rssub.getString("discussId"),
								new String(rssub.getString("content").getBytes("ISO-8859-1"),"UTF-8"), 
								rssub.getString("userId"), 
								rssub.getString("pudate"),
								rssub.getString("agree"));
						disListsub.add(discusssub);
					}
					
					discuss.setList(disListsub);
					disList.add(discuss);
				}
				articals.setList(disList);
				
				pst = conn.prepareStatement(Sql.SQL_DISSCUSS_NEARID);
				pst.setString(1, articalId);
				pst.setString(2, articalId);
				ResultSet rsnear = pst.executeQuery();
				
				while(rsnear.next()){
					if(rsnear.getInt("dir") == 0) {
						articals.setPre(rsnear.getInt("id"));
						articals.setPreTitle(StringUtil.lengthControl(rsnear.getString("title"), 15));
					} else if(rsnear.getInt("dir") == 1){
						articals.setNext(rsnear.getInt("id"));
						articals.setNextTitle(StringUtil.lengthControl(rsnear.getString("title"), 15));
					}
				} 
				
				articals.setClick(Integer.parseInt(articals.getClick()) + 1 + "");
				request.setAttribute("news", articals);
				
				pst = conn.prepareStatement(Sql.SQL_NEWS_UPDATE_CILICK);
				pst.setString(1, articals.getClick());
				pst.setInt(2, Integer.parseInt(articalId));
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			this.getServletContext().getRequestDispatcher("/creeper/artical.jsp").forward(request, response);
			
		}else if(BizConstant.BIZ_NEWS_5.getpCode().equals(TypeCode)){
			String type = request.getParameter("type");
			String id = request.getParameter("id");
			String content = new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
			String pdate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

			Connection conn = dbUtil.getConnection();
			try {
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_DISSCUSS_INSERT);
				pst.setString(1, type);
				pst.setString(2, id);
				pst.setString(3, content);
				if(request.getSession().getAttribute("username") == null){
					pst.setString(4, "From " + AddressUtil.getAddresses("ip=" + IPUtil.getIpAddress(request), "utf-8"));
				}else{
					pst.setString(4, (String)request.getSession().getAttribute("username"));
				}
				pst.setString(5, pdate);
				pst.setString(6, "0");
				
				pst.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			PrintWriter pw = response.getWriter();
			JSONObject jb = new JSONObject();
			jb.put("result", "ok");
			pw.write(jb.toString());
			pw.flush();
			pw.close();
			
		}else if(BizConstant.BIZ_NEWS_6.getpCode().equals(TypeCode)){
			String type = request.getParameter("type");
			String id = request.getParameter("id");
			String count = request.getParameter("count");
			String pdate = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String userId = IPUtil.getIpAddress(request);
			
			Connection conn = dbUtil.getConnection();
			PreparedStatement pst = null;
			PreparedStatement pstagree = null;
			String agree = null;
			try {
				
				if("1".equals(type)){
					pstagree = conn.prepareStatement(Sql.SQL_DISSCUSS_UPDATEAGREE);
				}else{
					
				}
				
				pst = conn.prepareStatement(Sql.SQL_AGREE_SELECTBYUSERID);
				pst.setString(1, userId);
				pst.setString(2, id);
				ResultSet rs = pst.executeQuery();
				if(rs.next()){
					pst = conn.prepareStatement(Sql.SQL_AGREE_DELETE);
					pst.setString(1, userId);
					pst.setString(2, id);
					pst.execute();
					count = Integer.parseInt(count) - 1 + ""; 
					agree = "0";
				}else{
					pst = conn.prepareStatement(Sql.SQL_AGREE_INSERT);
					pst.setString(1, type);
					pst.setString(2, id);
					pst.setString(3, userId);
					pst.setString(4, pdate);
					pst.execute();
					count = Integer.parseInt(count) + 1 + "";
					agree = "1";
				}
				
				pstagree.setString(1, count);
				pstagree.setString(2, id);
				pstagree.execute();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			PrintWriter pw = response.getWriter();
			JSONObject jb = new JSONObject();
			jb.put("agree", agree);
			jb.put("count", count);
			pw.write(jb.toString());
			pw.flush();
			pw.close();
		}
		else if(BizConstant.BIZ_NEWS_7.getpCode().equals(TypeCode)) {
			Connection conn = dbUtil.getConnection();
			ResultSet rs = null;
			JSONObject jb = new JSONObject();
			
			try {
				String pageNo = request.getParameter("pageNo");
				String pageSize = request.getParameter("pageSize");
				String type = request.getParameter("type");
				String keyWord = request.getParameter("keyWord");
				
				if(StringUtil.isEmpty(pageNo)) {
					pageNo = "0";
				}
				
				if(StringUtil.isEmpty(pageSize)) {
					pageSize = "5";
				}
				
				String orgSql = Sql.SQL_NEWS_SELECTALLINDEX;
				PreparedStatement pst = null;
				
				if(StringUtil.isEmpty(type) && StringUtil.isEmpty(keyWord)){
					pst = conn.prepareStatement(orgSql);
				}else if(StringUtil.isNotEmpty(type) && StringUtil.isEmpty(keyWord)){
					pst = conn.prepareStatement(orgSql + "WHERE t.clsid = ?");
					pst.setInt(3, Integer.parseInt(type));
				}else if(StringUtil.isEmpty(type) && StringUtil.isNotEmpty(keyWord)){
					pst = conn.prepareStatement(orgSql + "WHERE content like ?");
					pst.setString(3, "%" + keyWord + "%");
				}else if(StringUtil.isNotEmpty(type) && StringUtil.isNotEmpty(keyWord)){
					pst = conn.prepareStatement(orgSql + "WHERE t.clsid = ? AND content like ?");
					pst.setInt(3, Integer.parseInt(type));
					pst.setString(4, "%" + keyWord + "%");
				}
				
				int start = Integer.parseInt(pageNo) * Integer.parseInt(pageSize);
				int end = start + Integer.parseInt(pageSize);
				
				pst.setInt(1, start);
				pst.setInt(2, end);
				rs = pst.executeQuery();
				
				List<ArticalDao> newsList = new ArrayList<ArticalDao>();
				
				while(rs.next()) {
					String content = new String(rs.getString("content").getBytes("ISO-8859-1"), "UTF-8");
					content = StringUtil.lengthControl(StringUtil.delHtmlTag(content), 150);
					ArticalDao artical = new ArticalDao(rs.getInt("id"), rs.getString("img"), rs.getString("title"),
							content, rs.getString("clsname"), rs.getString("author"),
							rs.getString("pudate"), rs.getString("click"));
					newsList.add(artical);
				}
				
				int newsCount = newsList.size();
				int size = Integer.parseInt(pageSize);
				int pageCount = newsCount / size;
				if(newsCount % size != 0){
					pageCount ++;
				}
				if("0".equals(pageNo)){
					request.setAttribute("pageCount", pageCount);
					request.setAttribute("newsList", newsList);
					request.setAttribute("pageNo", pageNo);
					request.setAttribute("keyWord", keyWord);
					
					this.getServletContext().getRequestDispatcher("/creeper/index.jsp").forward(request, response);
				}else{
					jb.put("pageCount", pageCount);
					jb.put("newsList", newsList);
					jb.put("pageNo", pageNo);
					PrintWriter pw = response.getWriter();
					pw.write(jb.toString());
					pw.flush();
					pw.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if(BizConstant.BIZ_NEWS_8.getpCode().equals(TypeCode)) {
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			
			if(userId != null && userId.matches("^[1-9]\\d*$")) {
				if(dbo.userLogin(Integer.parseInt(userId), userPwd)) {
					request.setAttribute("userId", userId);
					this.getServletContext().getRequestDispatcher("/creeper/admin1.jsp").forward(request, response);
				}else {
					String str = "用户名或密码不正确，请重新输入！";
					request.setAttribute("str", str);
					this.getServletContext().getRequestDispatcher("/creeper/login.jsp").forward(request, response);
				}
			}else {
				String str = "用户名或密码不正确，请重新输入！";
				request.setAttribute("str", str);
				this.getServletContext().getRequestDispatcher("/creeper/login.jsp").forward(request, response);
			}
		}else if(BizConstant.BIZ_NEWS_9.getpCode().equals(TypeCode)) {
			String userId = request.getParameter("userId");
			String userPwd = request.getParameter("userPwd");
			String confirmPwd = request.getParameter("confirmPwd");
			
			if(userId != null && userPwd!=null && confirmPwd.equals(userPwd)&& userId.matches("^[1-9]\\d*$")) {
				if(dbo.addUser(Integer.parseInt(userId), userPwd, 0)) {
					request.setAttribute("userId", userId);
					//response.encodeRedirectUrl(arg0)
					this.getServletContext().getRequestDispatcher("/creeper/login.jsp").forward(request, response);
				}else {
					String msg = "该用户ID已经注册，请重新注册！";
					request.setAttribute("msg", msg);
					System.out.println(msg);
					this.getServletContext().getRequestDispatcher("/creeper/reg.jsp").forward(request, response);
				}
			}else {
				if(userId == null || userPwd == null || !userPwd.equals(confirmPwd)) {
					String msg = "用户名或密码不正确，请重新输入！";
					System.out.println(msg);
					request.setAttribute("msg", msg);
					this.getServletContext().getRequestDispatcher("/creeper/reg.jsp").forward(request, response);
				}
			}
		}else if(BizConstant.BIZ_NEWS_10.getpCode().equals(TypeCode)) {
			Connection conn = dbUtil.getConnection();
			ResultSet rs = null;
			try {
				String pageNo = request.getParameter("pageNo");
				String pageSize = request.getParameter("pageSize");
				
				if(StringUtil.isEmpty(pageNo)) {
					pageNo = "0";
				}
				
				if(StringUtil.isEmpty(pageSize)) {
					pageSize = "10";
				}
				System.out.println("pageNo == " + pageNo);
				System.out.println("pageSize == " + pageSize);
				PreparedStatement pst = conn.prepareStatement(Sql.SQL_NEWS_SELECTALL);
				
				int start = Integer.parseInt(pageNo) * Integer.parseInt(pageSize);
				int end = start + Integer.parseInt(pageSize);
				pst.setInt(1, start);
				pst.setInt(2, end);
				rs = pst.executeQuery();
				
				
				List<commodityEntity> commodityList = new ArrayList<commodityEntity>();
				while(rs.next()) {
					int id = rs.getInt("id");
					int goodsId = rs.getInt("goodsId");
					String goodsName = rs.getString("goodsName");
					String title = rs.getString("title");
					String titlePicture = rs.getString("titlePicture");
					String description = new String(rs.getString("description").getBytes("ISO-8859-1"),"UTF-8");
					int price = rs.getInt("price");
					int goodsNum = rs.getInt("goodsNum");
					String goodsPicture = rs.getString("goodsPicture");

					commodityEntity commodity = new commodityEntity(id, goodsId, goodsName, title, 
							titlePicture, description, price, goodsNum, goodsPicture);
					commodityList.add(commodity);
				}
				
				int commodityCount = commodityList.size();
				int size = Integer.parseInt(pageSize);
				int pageCount = commodityCount / size;
				if(commodityCount % size != 0){
					pageCount ++;
				}
				
				request.setAttribute("pageCount", pageCount);
				request.setAttribute("commodityList", commodityList);
				request.setAttribute("pageNo", pageNo);
				
				String username = (String) request.getSession().getAttribute("userId");
				request.setAttribute("username", username);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			this.getServletContext().getRequestDispatcher("/creeper/bookadmin.jsp").forward(request, response);
		}else if(BizConstant.BIZ_NEWS_11.getpCode().equals(TypeCode)) {
			
			this.getServletContext().getRequestDispatcher("/creeper/useradmin.jsp").forward(request, response);
		}
		else if(BizConstant.BIZ_NEWS_12.getpCode().equals(TypeCode)) {
			this.getServletContext().getRequestDispatcher("/creeper/bookstore.jsp").forward(request, response);
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
