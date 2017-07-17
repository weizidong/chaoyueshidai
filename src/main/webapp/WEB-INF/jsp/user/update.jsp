<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/head.jsp"%>
<body>
	<div class="page container-fluid">
		<div class="page-header text-center">
			<img src="${sessionScope.user.avatarUrl }" class="img-thumbnail img-circle" style="width: 150px;height: 150px">
		</div>
		<style type="text/css">
			.control-label{
				line-height: 34px;
				margin-bottom: 0;
			}
		</style>
		<form class="form-horizontal" action="/rest/user/register" method="post">
			<input name="openid" id="openid" style="visibility: hidden;" value="${sessionScope.user.openid}">
			<div class="form-group" id="nickName">
				<label class="col-xs-3 control-label" for="nickName">昵称：</label>
				<div class="col-xs-9">
					<input type="text" name="nickName" value="${sessionScope.user.nickName}" class="form-control" placeholder="请输入昵称...">
				</div>
			</div>
			<div class="form-group" id="name">
				<label class="col-xs-3 control-label" for="name">姓名：</label>
				<div class="col-xs-9">
					<input type="text" name="name" value="${sessionScope.user.name}" class="form-control" placeholder="请输入姓名...">
				</div>
			</div>
			<div class="form-group" id="gender">
				<label class="col-xs-3 control-label" for="gender">性别：</label>
				<div class="col-xs-9">
					<label class="radio-inline">
					  <input type="radio" name="gender" value="1" checked="${sessionScope.user.gender == 1}"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="gender" value="2" checked="${sessionScope.user.gender == 2}"> 女
					</label>
				</div>
			</div>
			<div class="form-group" id="province">
				<label class="col-xs-3 control-label" for="province">籍贯：</label>
				<div class="col-xs-9">
					<input type="text" style="width: 49%;display:inline-block;" name="province" pattern="^\d{11}$" value="${sessionScope.user.province}" class="form-control" placeholder="省">
					<input type="text" style="width: 49%;display:inline-block;" name="city" pattern="^\d{11}$" value="${sessionScope.user.city}" class="form-control" placeholder="市">
				</div>
			</div>
			<div class="form-group" id="tel">
				<label class="col-xs-3 control-label" for="tel">电话：</label>
				<div class="col-xs-9">
					<input type="text" name="tel" pattern="^\d{11}$" value="${sessionScope.user.tel}" class="form-control" placeholder="请输入电话...">
					<span class="help-block">电话号码为11为数字！</span>
				</div>
			</div>
			<div class="text-center">
				<!-- <button type="submit" class="btn btn-primary">修改</button> -->
				<%@include file="../common/close.jsp"%>
			</div>
		</form>
	</div>
	<%@include file="../common/user.jsp"%>
</body>
<script type="text/javascript">
	setTitle('我的资料');
</script>
</html>
