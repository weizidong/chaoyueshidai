<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/head.jsp"%>
<body>
	<div class="page container-fluid" style="top:0;bottom:0;">
		<%@include file="../common/msg2.jsp"%>
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
			<button type="button" class="btn btn-danger" id="close">关闭</button>
		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">注册用户</h4>
				</div>
				<div class="modal-body">
					<form id="form" action="/rest/user/register" method="post">
						<input name="openid" id="openid" style="visibility: hidden;" value="${requestScope.openid}">
						<div class="form-group" id="tel">
							<label for="tel">电话：</label>
							<input type="text" name="tel" pattern="^\d{11}$" class="form-control" placeholder="请输入电话...">
							<span class="help-block">电话号码为11为数字！</span>
						</div>
						<div class="form-group" id="name">
							<label for="name">姓名：</label>
							<input type="text" name="name" class="form-control" placeholder="请输入姓名...">
							<span class="help-block">请输入姓名！</span>
						</div>
						<div class="form-group" id="pwd">
							<label for="pwd">密码：</label> 
							<input type="password" name="pwd" class="form-control" placeholder="请输入密码...">
							<span class="help-block">请输入密码！</span>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							<button type="submit" class="btn btn-primary">确定</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	setTitle('操作手册');
	setCheck(['tel','name','pwd']);
	// 显示弹出层
	function showModel(update) {
		$('#registerModal form').attr('action','/rest/user/' + (update ? 'sjUpdate' : 'register'));
		$('#registerModal .modal-title').text(update ? '绑定账号' : '注册用户');
		$('#registerModal').modal('show');
	}
	// 绑定
	$('#update').click(function() {
		showModel(true);
	});
	// 注册
	$('#register').click(function() {
		showModel(false);
	});
	// 提交验证
	$('#form').submit(function() {
		if(check('tel') || check('name') || check('pwd')){
			if($('#registerModal form').attr('action') == '/rest/user/register'){
				ajax('/rest/user/register',serialize('#registerModal form'),function(data){
					$('#registerModal').modal('hide');
					sucessMsg(data.msg);
			     },function(e){
					$('#registerModal').modal('hide');
			    	errorMsg(e.msg || '服务器异常！请稍后重试...');
			     });
				return false;
			}else{
				return true;
			}
		}
		return false;
	});
	// 关闭
	$('#close').click(function() {
		
	});
</script>
</html>
