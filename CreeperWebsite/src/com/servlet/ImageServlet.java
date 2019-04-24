package com.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import net.coobird.thumbnailator.Thumbnails;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet(name="imageUpload", urlPatterns="/imageUpload")  
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");  
		  Collection<Part> parts = request.getParts(); 
		  System.out.println("ÉÏ´«Í¼Æ¬£¡");
		  JSONObject result = new JSONObject();
		  for (Part part : parts) {
			  String disposition = part.getHeader("content-disposition");  
		      System.out.println("ÃèÊö" + disposition);  
		      
		      
		      String fileName = disposition.substring(disposition.lastIndexOf("=")+2, disposition.length()-1);  
		      String fileType = part.getContentType();  
		      long fileSize = part.getSize();  
		      System.out.println("fileName: " + fileName);  
		      System.out.println("fileType: " + fileType);  
		      System.out.println("fileSize: " + fileSize);  
		      
		      
		      String uploadPath = this.getServletConfig().getServletContext().getRealPath("/");
		      
		      String folder = new SimpleDateFormat("yyyyMMdd").format(new Date());
		     
		      if(!new File(uploadPath + File.separator + folder).exists()) {
		    	  	new File(uploadPath + File.separator + folder).mkdirs();
		      }
		      
		      fileName = new SimpleDateFormat("yyyyMMdd_HHmmSS").format(new Date()) + fileName.subSequence(fileName.indexOf("."), fileName.length());
		      part.write(uploadPath  + folder + File.separator + fileName);
		      
		      
		      String src = uploadPath + folder + File.separator + fileName;
		      BufferedImage bufferedImage = ImageIO.read(new File(src));   
		      int width = bufferedImage.getWidth(); 
		      int height = bufferedImage.getHeight(); 
		      
		     
		      if(width > 762){
		    	  @SuppressWarnings("deprecation")
				  double scale = new BigDecimal((float)762/width).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		    	  Thumbnails.of(src).size(762,(int) (height * scale)).keepAspectRatio(false).toFile(src);  
		      }
		      
		      result.put("code", 0);
		      result.put("msg", "ok");
		      JSONObject subObject = new JSONObject();
		      subObject.put("src", folder + File.separator + fileName );
		      subObject.put("title", fileName);
		      result.put("data", subObject);

		  }
		  PrintWriter wp = response.getWriter();
	      wp.write(result.toString());
	      wp.close();
	}

}
