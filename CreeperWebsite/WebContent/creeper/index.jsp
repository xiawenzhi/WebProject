<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="myTag" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爬山虎</title>
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="icon" href="images/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="../creeper/css/base.css">

<link rel="stylesheet" type="text/css" href="../creeper/css/style.css">
<link rel="stylesheet" type="text/css" href="../creeper/css/media_index.css">
<link rel="stylesheet" type="text/css" href="../creeper/css/mod.css">
	
<link rel="stylesheet" type="text/css" href="../creeper/resources/layui/css/layui.css"> <!-- 响应式布局 -->
<link rel="stylesheet" type="text/css" href="../creeper/resources/css/common.css"> <!-- 公共样式 -->
<link rel="stylesheet" type="text/css" href="../creeper/resources/css/index.css"> <!-- 主页样式 -->
</head>
<body background="../creeper/images/bgimage.jpg">
     <!-- 爬山虎系统的首页 -->
	<input type="hidden" name="pageCount" value="${pageCount}" >
	<input type="hidden" name="pageNo" value="${pageNo}">
	<!-- 主体部分 -->
	<div style="background:url(../creeper/images/logo.png); display:block; height:500; width:200;"></div>
	<div > 
		<div class="type">
			<ul>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=7" onclik="typeTurn(0,0)">首页</a></li>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=7&type=1" onclik="typeTurn(1,1)">大学四年</a></li>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=7&type=2" onclik="typeTurn(1,2)">身边事</a></li>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=7&type=3" onclik="typeTurn(1,3)">征稿</a></li>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=7&type=4" onclik="typeTurn(1,4)">爱心爆棚</a></li>
				<li><a style="padding:0px;" href="../servlet/CoreServlet?TypeCode=11">社区商城</a></li>
			</ul>
		</div>
	
		<!-- 搜索框 -->
		<div class="search-part">
			<form method="post" class="search" action="../servlet/CoreServlet?TypeCode=7" >
				<input type="hidden" name="type">
	    		<input class="text" type="text" name="keyWord" placeholder="请输入关键字" value="${keyWord}">
	    		<input class="button" value="搜索" type="submit">
	  		</form>
		</div>
	</div>
	
	<!-- 轮播部分 -->
	
	<!-- 文章部分 -->
	<div class="list">
		<c:forEach var="news" items="${newsList}" varStatus="status">
			<div class="new">&nbsp;
				<div class="content row">
					<div class="imgdiv">
						<a href="CoreServlet?TypeCode=4&articalId=${news.id}"><img src="${news.img}"/></a>
					</div>
					<div class="text">
						<a href="CoreServlet?TypeCode=4&articalId=${news.id}"><h4>${news.title}</h4></a>
						<p class="p1">${myTag:formatDate(news.pudate)}&nbsp;-&nbsp;<span style="color: #20B2AA;">${news.type}</span>&nbsp;-&nbsp;${news.author}&nbsp;-&nbsp;阅${news.click}</p>
						<p class="p2">${news.content}</p>
					</div>
				</div>
			</div>	
		</c:forEach>
	</div>
	
	<section>
        <footer id="footer" class="">
		     <header class="wraper footer-top">
		     </header>

		     <footer class="footer-bottom">
			       <div class="wraper">
				        <div class="info">
					         <div class="links">
					              <a href="#">加入我们</a>
					              <a href="#">线下活动</a>
					              <a href="#">免责声明</a>
					              <a href="#">联系我们</a>
					              <a href="#">移动APP</a>
					         </div>
					         <p class="desc">©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号 
					                       违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
				       </div>
				       <h3>加入爬山虎社区，让大学有目标！</h3>
			      </div>
		    </footer>
	    </footer>
    </section>
    
    
	<!-- bootstrap所需js -->
	<script type="text/javascript" src="resources/layui/layui.js"></script>
	<script type="text/javascript" src="resources/js/jquery-3.1.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			//滚动分页
			var flag = 0;
			$(window).scroll(function(){  
				console.log($(window).scrollTop() + "  " + $(document).height() + "  " +$(window).height());
				if ($(window).scrollTop() == $(document).height() - $(window).height()) {
					var pageCount = $("input[name='pageCount']").val();
					var pageNo = $("input[name='pageNo']").val();
					var keyWord = $("input[name='keyWord']").val();
					var type = $("input[name='type']").val();
					if(pageNo < pageCount){
						$.ajax({
							url:"CoreServlet?TypeCode=7",
							dataType:"json",
							data:{'keyword':keyWord, 'type':type, 'pageNo':parseInt(pageNo)+1},
							success:function(data){
								var html = "";
								$.each(data.newsList, function(i,val){      
									html += '<div class="new">&nbsp';
									html += '	<div class="content row">';
									html += '		<div class="imgdiv">';
									html += '			<a href="coreServlet?bizCode=4&id='+val.id+'"><img src="'+val.img+'"/></a>';
									html += '		</div>';
									html += '		<div class="text">';
									html += '			<a href="coreServlet?bizCode=4&id='+val.id+'"><h4>"'+val.title+'</h4></a>';
									html += '			<p class="p1">'+dateFormat(val.pudate)+'-<span style="color: #20B2AA;">'+val.type+'</span>-'+val.author+'-阅'+val.click+'</p>';
									html += '			<p class="p2">"'+val.content+'</p>';
									html += '		</div>';
									html += '	</div>';
									html += '</div>	';
								});
								
								$(".new").last().after(html);
								$("input[name='pageNo']").val(parseInt(pageNo) + 1);
							}
						});
					}else if(pageNo == pageCount && flag == 0){
						flag ++;
						var html = '<p style="text-align:center; color:#FF8C69; font-size:14px; margin-top:10px; margin-bottom:10px;">已经到底了~</p>';
						$(".new").last().after(html);
					}
				}
			});  
		});
		
		function typeTurn(opt, type){
			if(opt == 1){
				$("input[name='type']").val(type);
			}else{
				$("input[name='type']").val("");
			}
		}
		
		function showlog(){
			$(".logdiv").animate({
			      height:'toggle'
		    });
		}
		
		function dateFormat(pdate){
			return pdate.substring(0,4) + "-" + pdate.substring(4,6) + "-" + pdate.substring(6,8);
		}
	</script>
</body>
</html>