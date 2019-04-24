<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>爬山虎书店</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/base.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/media_index.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/creeper/css/mod.css">
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.4.0.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/creeper/js/creeperWebsite.js"></script>
</head>
<body>
<section>
	<!--顶部菜单开始-->
	<nav id="nav" class="site-topbar">
		<div class="wraper">
			
			<ul class="nav-right">
				<li><a href="#">登录</a></li>
				<li><a href="登录">注册</a></li>
				<li class="buyCar">
					<a class="i_car" href="登录">购物车（0）</a>
					<div class="content"></div>
				</li>
			</ul>
		</div>
	</nav>
	<!--顶部菜单结束-->
	<!--头部开始-->
	<header id="header" class="site-header">
		<div class="wraper">
			<hgroup class="header-left">
				<h1>小米</h1>
				<h2></h2>
			</hgroup>
			<ul class="header-middle header-menu">				
				<li>
					<a href="#">社区</a>
					
				</li>
	 		</ul>
	 		
	 		<!-- 搜索框 -->
	 		<div class="header-right">
	 			<input type="text" class="search" list="search-record" name="search">
	 			<button class="btn">搜索</button>
	 			<ul>
	 				<li>小米手机5<span>约有11件</span></li>
	 				<li>小米手机5<span>约有11件</span></li>
	 				
	 			</ul>
	 		</div>
		</div>
	</header>
	<!--头部结束-->
	
	<!--中部区域开始-->
	<div class="wraper">
		<section id="main" class="site-main clear_bottom">
			<section class="main-right">
				<div class="slider">
					<ul class="contain">
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic1.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic2.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic3.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic4.jpg"></a></li>
						<li class="item"><a href="#" alt=""><img src="./images/index_slider_pic5.jpg"></a></li>
					</ul>
				</div>
			</section>
		</section>
	</div>
		
	<!--  <section id="adv" class="wraper site-adv m-box clear_bottom">
	</section> -->
	<!--中部区域结束-->

	<!--新品上市开始-->
	<section id="sku" class="wraper m-box mi-sku">
		<input type="radio" id="sku-s1" class="sku-switch s1" name="sku-switch" hidden checked>
		<input type="radio" id="sku-s2" class="sku-switch s2" name="sku-switch" hidden>
		<header class="m-hd">
			<h2 class="m-hdL">新品上市</h2>
			<div class="m-hdR">
				<div class=" btns2">
					<a href="#" class="btn btn1 active"><label for="sku-s1">&lt;</label></a>
					<a href="#" class="btn btn2"><label for="sku-s2">&gt;</label></a>
				</div>
			</div>
		</header>
		<div class="m-box">
			<section class="span20 m-slide">
				<div class="m-slide-contain m-s2">
					<div class="m-slide-item">
						<ul class="m-cols m-col-5">
							<li class="col sku-item " onclick="imageOnclick('../servlet/imageServlet?imageId=23333')">
								<dl class="row">
									<dt><img src="./images/single/single1.png"></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single2.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single3.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single4.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single5.jpg"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
						</ul>
					</div>
					<div class="m-slide-item">
						<ul class="m-cols m-col-5">
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single6.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single10.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single7.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single8.png"></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
							<li class="col sku-item ">
								<dl class="row">
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/single/single9.jpg"><a></a></dt>
									<dd class="name">小米电视3S 43英寸</dd>
									<dd class="desc">4GB内存+128GB闪存，陶瓷版</dd>
									<dd class="price">1499元</dd>
								</dl>
							</li>
						</ul>
					</div>
				</div>
			</section>		
		</div>
	
	</section>
	<!--新品上市结束-->
	<!--热评书籍开始-->
	<section id="comment" class="wraper mi-hotCmtProd">
		<header class="m-hd">
			<h2 class="m-hdL">热评书籍</h2>
			<ul class="m-hdR">
				<li></li>
			</ul>
		</header>
		<section class="m-box">
			<ul class="m-cols m-col-4">
				<li class="col">
					<div class="row"><a href="./bookdetailInfo.jsp">
						<img src="./images/rpcp/rpcp1.jpg">
						<div class="content">
							<div class="cmt">
								自拍是一种病！拍起来真要命！蓝牙连接，比起插线的，简直提升了不少逼格～喜欢的蓝色～美哒哒～～
							</div>
							<div class="from">来自于 taurus1992 的评价</div>
							<a href="#" class="name">小米自拍杆</a>
							<a href="#" class="price">699元</a>	
						</a></div>
					</div>
				</li>
				<li class="col">
					<div class="row">
						<a href="./bookdetailInfo.jsp"><img src="./images/rpcp/rpcp2.jpg"></a>
						<div class="content">
							<div class="cmt">
								自拍是一种病！拍起来真要命！蓝牙连接，比起插线的，简直提升了不少逼格～喜欢的蓝色～美哒哒～～
							</div>
							<div class="from">来自于 taurus1992 的评价</div>
							<a href="#" class="name">小米自拍杆</a>
							<a href="#" class="price">699元</a>	
						</div>
					</div>
				</li>
				<li class="col">
					<div class="row">
						<a href="./bookdetailInfo.jsp"><img src="./images/rpcp/rpcp3.jpg"></a>
						<div class="content">
							<div class="cmt">
								自拍是一种病！拍起来真要命！蓝牙连接，比起插线的，简直提升了不少逼格～喜欢的蓝色～美哒哒～～
							</div>
							<div class="from">来自于 taurus1992 的评价</div>
							<a href="#" class="name">小米自拍杆</a>
							<a href="#" class="price">699元</a>	
						</div>
					</div>
				</li>
				<li class="col">
					<div class="row">
						<a href="./bookdetailInfo.jsp"><img src="./images/rpcp/rpcp4.jpg"></a>
						<div class="content">
							<div class="cmt">
								自拍是一种病！拍起来真要命！蓝牙连接，比起插线的，简直提升了不少逼格～喜欢的蓝色～美哒哒～～
							</div>
							<div class="from">来自于 taurus1992 的评价</div>
							<a href="#" class="name">小米自拍杆</a>
							<a href="#" class="price">699元</a>	
						</div>
					</div>
				</li>
			</ul>
		</section>
	</section>
	<!--热评书籍结束-->
	<div class="gray-section">
		<!--英语四级开始-->
		<section class="wraper mi-hard clear_bottom" id="hard">
			<header class="m-hd">
				<h2 class="m-hdL">英语四级</h2>
				<div class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span20">
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
							<div class="row">
								<span class="tip blue">有赠品</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj2.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
							<div class="row">
								<span class="tip blue">有赠品</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj4.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
							<div class="row">
								<span class="tip blue">有赠品</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj6.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
							<div class="row">
								<span class="tip blue">有赠品</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj8.png"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
				</div>
			</section>
		</section>
		<!--英语四级结束-->
		<!--英语六级开始-->
		<section class="wraper mi-hard clear_bottom" id="hard">
			<header class="m-hd">
				<h2 class="m-hdL">英语六级</h2>
				<div class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span20">
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
				</div>
			</section>
		</section>
		<!--英语六级结束-->
		<!--托福开始-->
		<section class="wraper mi-hard clear_bottom" id="hard">
			<header class="m-hd">
				<h2 class="m-hdL">托福</h2>
				<div class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span20">
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col"><a href="./bookdetailInfo.jsp">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><img src="./images/znyj/znyj5.jpg"></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div></a>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
				</div>
			</section>
		</section>
		<!--托福结束-->
		<!--雅思开始-->
		<section class="wraper mi-hard clear_bottom" id="hard">
			<header class="m-hd">
				<h2 class="m-hdL">雅思</h2>
				<div class="m-hdR">
					<div class="scan">
						<span>查看全部</span>
						<a href="#" class="icon">&gt;</a>
					</div>
				</div>
			</header>
			<section class="m-box line2">
				<div class="span20">
					<ul class="m-cols m-col-4">
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj1.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj3.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
						<li class="col">
							<div class="row">
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj5.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						<li class="col">
							<div class="row" content="音质非常好，很震撼！！美美美！ " from="来自于米米小aa 的评价 ">	  
								<span class="tip orange">免邮件</span>
								<dl>
									<dt><a href="./bookdetailInfo.jsp"><img src="./images/znyj/znyj7.jpg"></a></dt>
									<dd class="name">小米路由器3</dd>
									<dd class="desc">四天线设计，更安全更稳定</dd>
									<dd class="price">149元</dd>
								</dl>
							</div>
						</li>
					</ul>
				</div>
			</section>
		</section>
		<!--雅思结束-->
	</div>

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
</body>
</html>