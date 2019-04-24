<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
	<meta charset="GBK">
	<title>登录</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/login.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/media_login.css">

</head>

<body>
	<main id="container" class="container reg">
		<input type="checkbox" name="" value="" class="switch" id="switch">
		<label class="trigger" for="switch">
			<span></span>
		</label>
		<section class="page account-page">
			<header class="header">
				<h1 class="logo">
					<svg width="100%" height="100%" version="1.1" xmlns="http://www.w3.org/2000/svg"><rect width="50" height="50" style="fill:#ef5b00"></rect><rect x="11.25" y="15" width="5" height="20" style="fill:#FFFFFF"></rect><rect x="11.25" y="15" width="12.5" height="5" style="fill:#FFFFFF"></rect><rect x="26.25" y="22.5" width="5" height="12.5" style="fill:#FFFFFF"></rect><rect x="33.75" y="15" width="5" height="20" style="fill:#FFFFFF"></rect><circle cx="23.75" cy="22.5" r="7.5" fill="#FFFFFF"></circle><rect x="16.25" y="20" width="7.5" height="15" style="fill:#ef5b00"></rect><rect x="16.25" y="22.5" width="10" height="12.5" style="fill:#ef5b00"></rect><circle cx="23.75" cy="22.5" r="2.5" fill="#ef5b00"></circle><rect x="18.75" y="22.5" width="5" height="12.5" style="fill:#FFFFFF"></rect></svg>
				</h1>
				<h2 class="title">爬山虎账号登录</h2>
			</header>
			<section class="section">
				<form name="" action="../servlet/CoreServlet?TypeCode=8" method="post" enctype="" id="login">
				<input class="form-item" type="text" name="userId" placeholder="爬山虎账号"/><br>
				<input class="form-item" type="password" name="userPwd" placeholder="密码"><br><br>
				<input name="userType" type="radio" value="0" checked="checked">用户 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
				<input name="userType" type="radio" value="1">管理员 <br>
				<button class="form-item btn" type="submit" onclick="">立即登录</button></form><br>
			</section>
			<footer class="footer">
				<div class="options">
					<a href="reg.jsp">注册爬山虎账号</a>
					<a href="">忘记密码？</a>
				</div>
			</footer>
		</section>
		<section class="page qr-page">
			<h2 class="title">爬山虎账号扫描登录</h2>
			<p class="desc">请使用最新版爬山虎App进行扫码登录</p>
			<div class="wx_code">
				<img src="${pageContext.request.contextPath}/creeper/images/wx_code.png">
			</div>
		</section>
	</main>
	<footer id="footer">
		<div class="options">
			<a href="" class="active">简体</a>
			<a href="">繁体</a>
			<a href="">English</a>
			<a href="">常见问题</a>
		</div>
		<p class="desc">
			小米公司版权所有-京ICP备10046444-京公网安备11010802020134号-京ICP证110507号
		</p>
	</footer>
</body>
</html>