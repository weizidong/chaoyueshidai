<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/head.jsp"%>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="page container-fluid">
		<%@include file="../common/alert.jsp"%>
		<div class="page-header">
			<h1 class="text-center">操作说明</h1>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">1、注册新用户</div>
			<div class="panel-body">
				<h5>&emsp;如果没有账号的话，请注册一个新的账号。<u id="register"><strong>注册</strong></u></h5>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">2、绑定账号</div>
			<div class="panel-body">
				<h5>&emsp;如果已经具有账号，请绑定。<u id="update"><strong>绑定</strong></u></h5>
			</div>
		</div>
		<div class="panel panel-info">
			<div class="panel-heading">3、操作指令</div>
			<div class="panel-body">
				<h5>&emsp;在微信订阅号输入以下指令可以获得相应入口和功能：</h5>
				<h5>&emsp;(1)、“说明”：该指令可以获得操作说明页面的入口。</h5>
				<h5>&emsp;(2)、“笔记”：该指令可以获得笔记应用的入口。</h5>
				<h5>&emsp;(3)、“我”：该指令可以获得个人信息页面的入口。</h5>
			</div>
		</div>
		<div class="text-center">
			<%@include file="../common/close.jsp"%>
		</div>
	</div>
	<%@include file="../common/register.jsp"%>
</body>
<script type="text/javascript">
	setTitle('操作说明');
	// 绑定
	$('#update').click(function() {
		showModel(true);
	});
	// 注册
	$('#register').click(function() {
		showModel(false);
	});
</script>
</html>
