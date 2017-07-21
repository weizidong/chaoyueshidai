<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="../common/head.jsp"%>
<body>
	<%@include file="../common/header.jsp"%>
	<div class="page container-fluid" style="padding:0">
		<%@include file="../common/alert.jsp"%>
		<div class="panel panel-default">
			<div class="panel-heading" style="padding:10px;">
				<img src="${sessionScope.user.avatarUrl}" class="img-thumbnail img-circle" style="width: 32px;height: 32px">
				<span>${sessionScope.user.name}</span>
				<div class="btn-group pull-right">
				  <button type="button" class="btn btn-info">编辑</button>
				</div>
			</div>
			<div class="panel-body">
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
				<form class="form-horizontal" method="post" id="noteInfo">
					<input name="id" class="visibility-hidden" value="${requestScope.note.id}">
					<div class="form-group" id="title">
						<label class="col-xs-3 control-label" for="title">标题：</label>
						<div class="col-xs-9">
							<div class="form-control">${requestScope.note.title}</div>
							<input type="text" name="title" value="${requestScope.note.title}" class="form-control" placeholder="请输入标题...">
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
				</form>
			</div>
		</div>
		<style type="text/css">
		</style>
	</div>
	<%@include file="../common/user.jsp"%>
</body>
<script type="text/javascript">
	setTitle(${requestScope.note.title});
</script>
</html>
