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
				<img src="${sessionScope.user.avatarUrl!=null?sessionScope.user.avatarUrl:'/static/img/admin.png'}" class="img-thumbnail img-circle" style="width: 32px;height: 32px">
				<span>${sessionScope.user.name}</span>
				<div class="btn-group pull-right">
				  <button type="button" id="editBtn" class="btn btn-info">编辑</button>
				  <button type="button" id="saveBtn" class="btn btn-warning hidden">保存</button>
				  <button type="button" id="shareBtn" class="btn btn-primary">${requestScope.note.share == 1?'取消分享':'分享' }</button>
				</div>
			</div>
			<div class="panel-body">
				<style type="text/css">
					.title{font-size:24px;}
					.time{font-size:12px;color:#898989;box-shadow: inset 0 1px 0 rgba(255,255,255,.15),0 1px 1px rgba(0,0,0,.075);}
				</style>
				<form method="post" id="noteInfo">
					<input name="id" class="visibility-hidden" value="${requestScope.note.id}">
					<input id="share" name="share" class="visibility-hidden" value="${requestScope.note.share}">
					<div class="text-center title" id="title">
						<div>${requestScope.note.title}</div>
						<input class="form-control text-center hidden" value="${requestScope.note.title}">
					</div>
					<div class="form-group text-right time" id="created">
						<div><fmt:formatDate value="${requestScope.note.created }" pattern="yyyy-MM-dd HH:mm"/></div>
						<div class="hidden"><fmt:formatDate value="${requestScope.note.created }" pattern="yyyy-MM-dd HH:mm"/></div>
					</div>
					<div class="form-group text-center" id="pic">
						<img src="${fn:contains(requestScope.note.pic,'/userfiles/')?requestScope.note.pic:'/static/img/none.png'}" class="img-thumbnail">
						<img src="${fn:contains(requestScope.note.pic,'/userfiles/')?requestScope.note.pic:'/static/img/none.png'}" class="img-thumbnail hidden">
					</div>
					<div class="form-group" id="content">
						<div class="well">${requestScope.note.content }</div>
						<textarea name="content" class="form-control hidden" rows="3" value="${requestScope.note.content }"></textarea>
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
	setTitle('${requestScope.note.title}');
	function saveNote() {
		var data = serialize('#noteInfo');
		ajax('/rest/note/update', data, function(data) {
			window.location.reload(true);
		}, function(e) {
			_alert(e.msg || '服务器异常！请稍后重试...','danger');
		});
	}
	// 分享
	$('#shareBtn').click(function() {
		$('#share').val(${requestScope.note.share == 1?0:1 });
		saveNote();
	});
	// 编辑
	$('#editBtn').click(function() {
		$('#saveBtn').removeClass('hidden');
		$(this).addClass('hidden');
		$('#noteInfo>div>:nth-child(2)').removeClass('hidden');
		$('#noteInfo>div>:first-child').addClass('hidden');
	});
	// 保存
	$('#saveBtn').click(function() {
		$('#editBtn').removeClass('hidden');
		$(this).addClass('hidden');
		$('#noteInfo>div>:nth-child(2)').addClass('hidden');
		$('#noteInfo>div>:first-child').removeClass('hidden');
	});
</script>
</html>
