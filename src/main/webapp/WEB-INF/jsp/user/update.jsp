<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/head.jsp"%>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="page container-fluid">
		<%@include file="../common/alert.jsp"%>
		<div class="page-header text-center">
			<img src="${fn:contains(sessionScope.user.avatarUrl,'/userfiles/')?sessionScope.user.avatarUrl:'/static/img/admin.png'}" class="img-thumbnail img-circle" style="width: 150px;height: 150px">
		</div>
		<style type="text/css">
			.control-label{
				line-height: 34px;
				margin-bottom: 0;
			}
			.form-horizontal .col-xs-9 div{display:inline-block;}
			.form-horizontal .col-xs-9 input,.form-horizontal .col-xs-9 label{display:none;}
			.update .col-xs-9 input,.update .col-xs-9 label{display:inline-block;}
			.update .col-xs-9 div{display:none;}
		</style>
		<form class="form-horizontal" method="post" id="userInfo">
			<input name="openid" class="visibility-hidden" value="${sessionScope.user.openid}">
			<input name="id" class="visibility-hidden" value="${sessionScope.user.id}">
			<div class="form-group" id="nickName">
				<label class="col-xs-3 control-label" for="nickName">昵称：</label>
				<div class="col-xs-9">
					<div class="form-control">${sessionScope.user.nickName}</div>
					<input type="text" name="nickName" value="${sessionScope.user.nickName}" class="form-control" placeholder="请输入昵称...">
				</div>
			</div>
			<div class="form-group" id="name">
				<label class="col-xs-3 control-label" for="name">姓名：</label>
				<div class="col-xs-9">
					<div class="form-control">${sessionScope.user.name}</div>
					<input type="text" name="name" value="${sessionScope.user.name}" class="form-control" placeholder="请输入姓名...">
				</div>
			</div>
			<div class="form-group" id="gender">
				<label class="col-xs-3 control-label" for="gender">性别：</label>
				<div class="col-xs-9">
					<div class="form-control">${sessionScope.user.gender == 1?'男':'女'}</div>
					<label class="radio-inline">
					  <input type="radio" name="gender" value="1" ${sessionScope.user.gender == 1?'checked':''}>男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" value="2" ${sessionScope.user.gender == 2?'checked':''}>女
					</label>
				</div>
			</div>
			<div class="form-group" id="province">
				<label class="col-xs-3 control-label" for="province">籍贯：</label>
				<div class="col-xs-9">
					<div class="form-control" style="width: 49%;">${sessionScope.user.province}</div>
					<div class="form-control" style="width: 49%;">${sessionScope.user.city}</div>
					<input type="text" style="width: 49%;" name="province" pattern="^\d{11}$" value="${sessionScope.user.province}" class="form-control" placeholder="省">
					<input type="text" style="width: 49%;" name="city" pattern="^\d{11}$" value="${sessionScope.user.city}" class="form-control" placeholder="市">
				</div>
			</div>
			<div class="form-group" id="tel">
				<label class="col-xs-3 control-label" for="tel">电话：</label>
				<div class="col-xs-9">
					<div class="form-control">${sessionScope.user.tel}</div>
					<input type="text" name="tel" pattern="^\d{11}$" value="${sessionScope.user.tel}" class="form-control" placeholder="请输入电话...">
					<span class="help-block">电话号码为11为数字！</span>
				</div>
			</div>
			<div class="text-center">
				<button type="button" id="submit" class="btn btn-primary">修改</button>
				<button type="button" class="btn btn-danger hidden" id="cancer">取消</button>
				<%@include file="../common/close.jsp"%>
			</div>
		</form>
	</div>
	<%@include file="../common/user.jsp"%>
</body>
<script type="text/javascript">
	setTitle('我的资料');
	var edit = false;
	// 提交验证
	$('#submit').click(function() {
		if(edit){
			var data = serialize('#userInfo');
			ajax('/rest/user/update', data, function(data) {
				_alert(data.msg,'success');
				window.location.reload(true);
			}, function(e) {
				_alert(e.msg || '服务器异常！请稍后重试...','danger');
			});
		}else{
			$('#userInfo').addClass('update');
			$('#cancer').removeClass('hidden');
			$('#close').addClass('hidden');
			$('#submit').text('保存');
			edit = true;
		}
	});
	// 取消
	$('#cancer').click(function() {
		$('#userInfo').removeClass('update');
		$('#close').removeClass('hidden');
		$('#cancer').addClass('hidden');
		$('#submit').text('修改');
		edit = false;
	});
</script>
</html>
