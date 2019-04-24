<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="../WEB-INF/mytag.tld" prefix="myTag" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
<link rel="stylesheet" type="text/css" href="../creeper/resources/layui/css/layui.css">

<script src="${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBar.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBarHorizontal.css" rel="stylesheet" type="text/css" />
</head>
<body>
<ul class="layui-nav">
  	<li class="layui-nav-item">
    		<font size="18">爬山虎网站后台管理系统</font>
 	</li>
  	<li class="layui-nav-item" style="float:right;">
    	<a href=""><img src="../creeper/resources/images/admin.jpg" class="layui-nav-img">${username}</a>
	    <dl class="layui-nav-child">
	      <dd><a href="javascript:;" onclick="add()">添加商品</a></dd>
	      <dd><a href="javascript:;" onclick="location.href = '../creeper/login.jsp'">登出</a></dd>
	    </dl>
  	</li>
</ul>
<!-- 菜单栏管理 -->
<ul id="MenuBar1" class="MenuBarHorizontal">
  <li><a href="#">首页</a></li>
  <li><a class="MenuBarItemSubmenu" href="#">管理</a>
    <ul>
      <li><a href="#">文章管理</a></li>
      <li><a href="#">商品管理</a></li>
      <li><a href="#">用户管理</a></li>
      <li><a href="#">征稿</a></li>
      <li><a href="#">爱心爆棚</a></li>
    </ul>
  </li>
  <li><a href="#">添加商品</a></li>
  <li><a class="MenuBarItemSubmenu" href="#">分类</a>
    <ul>
      <li><a href="#">四级</a></li>
      <li><a href="#">六级</a></li>
      <li><a href="#">托福</a></li>
      <li><a href="#">雅思</a></li>
      <li><a href="#">其它</a></li>
    </ul>
  </li>
  <li><a href="#">登出</a></li>
</ul>
<script type="text/javascript">
var MenuBar1 = new Spry.Widget.MenuBar("MenuBar1", {imgDown:"${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBarDownHover.gif", imgRight:"${pageContext.request.contextPath}/creeper/SpryAssets/SpryMenuBarRightHover.gif"});
</script>
<!-- 菜单栏结束 -->

<!-- 你的HTML代码 -->
<div style="width:100%">
	<table class="layui-table">
	  	<colgroup>
		    <col width="150">
		    <col width="200">
		    <col>
	  	</colgroup>
	  	<thead>
		    <tr>
		      <th width="5%">序号</th>
		      <th width="15%">书本名称</th>
		      <th width="10%">类型</th>
		      <th width="20%">说明</th>
		      <th width="10%">价格</th>
		      <th width="10%">库存</th>
		      <th width="10%">更新时间</th>
		      <th width="20%">操作</th>
		    </tr> 
	  	</thead>
	  	<tbody>
	  		<c:forEach var="news" items="${articalList}" varStatus="status">
				<tr>
				    <td>${status.index + 1}</td>
				    <td>${news.title}</td>
				    <td>${news.type}</td>
				    <td>${news.author}</td>
				    <td>${news.click}</td>
				    <td></td>
				    <td>${myTag:formatDateTime(news.pudate)}</td>
				    <td>
				     	<button class="layui-btn layui-btn-primary" onclick="edit(${news.id})">编辑</button>
				      	<button class="layui-btn layui-btn-primary" onclick="detail(${news.id})">详情</button>
				      	<button class="layui-btn layui-btn-danger" onclick="del(${news.id})">删除</button>
				     </td>
			  	 </tr>
			</c:forEach>
	  	</tbody>
	</table>
	<!-- 分页栏开始 -->
	<div class="layui-btn-group" style="float:left;" id="pageTurnDiv">
		<input type="hidden" name="pageCount" value="${pageCount}" >
		<input type="hidden" name="pageNo" value="${pageNo}">
	</div>
	<!-- 分页栏结束 -->
</div>


<!-- 表单部分-用于添加 -->
<div id="newsform" style="overflow:scroll; position:fixed; width:800px; height:100%; z-index:2; top:0%; left:0px; right:0px; margin-left:auto; margin-right:auto;  background-color:#fff; box-shadow: 0 0 0 50vmax rgba(0,0,0,0.6);" hidden>
	<div style="width:100%; height:40px; background-color:#009f95; line-height:40px; font-size:20px; color:#fff;">&nbsp;新增<a href="javascript:$('#newsform').hide(); $('form')[0].reset();"><i class="layui-icon" style="font-size: 30px; float:right; margin-right:10px;" >&#x1006;</i></a></div>
	<form class="layui-form" action="${pageContext.request.contextPath}/servlet/CoreServlet?TypeCode=0"  method="post" style="padding-right:30px; padding-top:30px;">
	  	<input type="hidden" name="id" value="0"/>
	  	<div class="layui-form-item">
	    		<label class="layui-form-label">标题</label>
	    		<div class="layui-input-block">
	     		<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    		</div>
	  	</div>
	  	<div class="layui-form-item">
	    		<label class="layui-form-label">类别</label>
	    		<div class="layui-input-block">
	      		<select name="type" lay-verify="required">
	        		<option value="1" selected="selected">四级</option>
	        		<option value="2">六级</option>
	        		<option value="3">托福</option>
			        <option value="4">雅思</option>
			        <option value="5">其它</option>
	      		</select>
	    		</div>
	  	</div>
	  	
	   <div class="layui-form-item">
	    		<label class="layui-form-label">说明</label>
	    		<div class="layui-input-block">
	     		<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    		</div>
	  	</div>
	  	
	  	<div class="layui-form-item layui-form-text">
	    		<label class="layui-form-label">描述</label>
		    	<div class="layui-input-block">
				<textarea id="content" name="content" style="display: none;"></textarea>
		        </div>
	  	</div>
	  	
	  	<div class="layui-form-item">
	    		<label class="layui-form-label">价格</label>
	    		<div class="layui-input-block">
	     		<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    		</div>
	    		<label class="layui-form-label">库存</label>
	    		<div class="layui-input-block">
	     		<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    		</div>
	  	</div>
	  	
	  	<div class="layui-form-item">
	  		<input type="hidden" name="cover"/>
	  		<label class="layui-form-label">封面图片</label>
		  	<button type="button" class="layui-btn" id="test1" style="float:left">
				<i class="layui-icon">&#xe67c;</i>上传图片
			</button>
			<span id="imgview"  style="float:left"></span>
	  	</div>
	  	
	  	<div class="layui-form-item">
	    		<div class="layui-input-block">
	    			<input type="hidden" name="TypeCode" value="0">
	      		<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
	      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    		</div>
	  	</div>
	</form>
</div>
<script type="text/javascript" src="../creeper/resources/layui/layui.js"></script>
<script type="text/javascript" src="../creeper/resources/js/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="../creeper/resources/js/pageturn.js"></script>
<script>
	$(function(){
		//加载分页组件
		pageTurnDiv();
		
		//编辑器部分
		layui.use('layedit', function() {
		  	var layedit = layui.layedit;
		  	//配置富文本中的上传图片，一定要在build之前
		  	layedit.set({
			  uploadImage: {
			    url: 'imageUpload', //接口url
			    type: 'post' //默认post
			  }
			});
		  	//创建富文本
		  	layedit.build('content',{
			  	height: 230
		  	}); 
		});
		
		
		layui.use('element', function(){
		  	var element = layui.element;
		});
		
		//图片上传部分
		layui.use('upload', function(){
			var upload = layui.upload; //得到 upload 对象
	 
			//创建一个上传组件
			upload.render({
			  elem: '#test1'
			  ,url: 'imageUpload'
			  ,done: function(res, index, upload){ //上传后的回
			  		var imgpath = res.data.src;
			  		$("input[name='cover']").val(imgpath);
			  		$("#imgview").html("<img src='"+imgpath+"' width='60px' height='38px' style='margin-left:20px;'/>");
			  } 
			});
		});	
		
	});
	
	//关闭编辑区
	function close(){
		$("#newsform").hide();
		$("#newsform").reset();
	}
	
	//开启编辑区
	function add(){
		$("#newsform").show();
	}
	
	//删除一条记录
	function del(id){
		layer.confirm('确定删除？', {icon:3, title:'提示'}, function(index){
			location.href = "CoreServlet?TypeCode=3&id="+ id;
			layer.close(index);
		});
	}
	
	//编辑
	function edit(id){
		$("input[name='id']").val(id);
		$("select[name='type']").attr("disabled","true");
		$.ajax({
			url : "CoreServlet?TypeCode=2&id="+ id,
			method : "get",
			success: function(data){
				var result = JSON.parse(data);
				$("input[name='title']").val(result.title);
				$("select[name='type'] option").each(function(){
				    if($(this).val() == result.type){
				    }
				});
				$("input[name='content']").html(result.content);
				$("input[name='cover']").val(result.img);
				$("#newsform").show();
			}		
		});
	}
	
	//详情
	function detail(id){
		location.href = "CoreServlet?TypeCode=4&articalId=" + id;
	}
	
</script> 
</body>
</html>