<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; UTF-8">
<title>爬山虎账号注册</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/base.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/login_reg.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/reg.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/media_reg.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/media_login.css">
</head>
<body>
    <main id="container" class="container">
		<section class="page account-page" id="reg">
			<header class="header">
				<h1 class="logo">
					<svg width="100%" height="100%" version="1.1" xmlns="http://www.w3.org/2000/svg"><rect width="50" height="50" style="fill:#ef5b00"></rect><rect x="11.25" y="15" width="5" height="20" style="fill:#FFFFFF"></rect><rect x="11.25" y="15" width="12.5" height="5" style="fill:#FFFFFF"></rect><rect x="26.25" y="22.5" width="5" height="12.5" style="fill:#FFFFFF"></rect><rect x="33.75" y="15" width="5" height="20" style="fill:#FFFFFF"></rect><circle cx="23.75" cy="22.5" r="7.5" fill="#FFFFFF"></circle><rect x="16.25" y="20" width="7.5" height="15" style="fill:#ef5b00"></rect><rect x="16.25" y="22.5" width="10" height="12.5" style="fill:#ef5b00"></rect><circle cx="23.75" cy="22.5" r="2.5" fill="#ef5b00"></circle><rect x="18.75" y="22.5" width="5" height="12.5" style="fill:#FFFFFF"></rect></svg>
				</h1>
				<h2 class="title">爬山虎账号注册</h2>
			</header>
			<section class="section form" id="reg">
				<form name="" action="../servlet/CoreServlet?TypeCode=9" method="post" enctype="" id="regist">
				<div class="form-item accounts">
					<input class="" type="text" name="userId" placeholder="邮箱/手机号码"/>
				</div>
				<div class="form-item">
					<input class="" type="password" name="userPwd" placeholder="密码"><br>
				</div>
				<div class="form-item">
					<input class="" type="password" name="confirmPwd" placeholder="确认密码"><br>
				</div>
				<div class="form-item check_code">
					<input type="text" name="" class="form-itemR" value="" placeholder="图片验证码"/>
					<a href="" class="form-itemL">
						<img src="./images/check_code.png">
					</a>
				</div>
				<button class="form-item btn">立即注册</button><br>
				</form>
			</section>
			<footer class="footer">
				<div class="options">
					<a href="login.jsp"><br>立即登录</a>
				</div>
			</footer>
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