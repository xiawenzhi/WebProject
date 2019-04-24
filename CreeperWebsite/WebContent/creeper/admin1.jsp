<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="SpryAssets/SpyMenuBarHorizontal.css">
<script type="text/javascript" src="SpryAssets/SpryMenuBar.js"></script>

<script src="${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
</head>
<body>

<!-- 菜单栏管理 -->
<ul id="MenuBar1" class="MenuBarHorizontal">
  <li><a href="#">首页</a></li>
  <li><a class="MenuBarItemSubmenu" href="#">管理</a>
    <ul>
      <li><a href="${pageContext.request.contextPath}/servlet/CoreServlet?TypeCode=1">文章管理</a></li>
      <li><a href="${pageContext.request.contextPath}/servlet/CoreServlet?TypeCode=10">商品管理</a></li>
      <li><a href="${pageContext.request.contextPath}/servlet/CoreServlet?TypeCode=10">用户管理</a></li>
      <li><a href="#">征稿</a></li>
      <li><a href="#">爱心爆棚</a></li>
    </ul>
  </li>
  <li><a href="#">大学四年</a></li>
  <li><a href="#">身边事</a></li>
  <li><a href="#">征稿</a></li>
  <li><a href="#">爱心爆棚</a></li>
  <li><a href="${pageContext.request.contextPath}/servlet/CoreServlet?TypeCode=12">社区商城</a></li>
  <li><a href="${pageContext.request.contextPath}/creeper/login.jsp">登出</a></li>
</ul>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"SpryAssets/SpryMenuBarDownHover.gif", imgRight:"../creeper/SpryAssets/SpryMenuBarRightHover.gif"});
</script>

</body>
</html>