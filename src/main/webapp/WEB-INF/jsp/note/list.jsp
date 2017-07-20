<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				  <a href="/rest/note/dyh/1/1/${sessionScope.user.openid}" class="btn btn-default">旅行日志</a>
				  <a href="/rest/note/dyh/2/1/${sessionScope.user.openid}" class="btn btn-default">灵感速记</a>
				  <a href="/rest/note/dyh/3/1/${sessionScope.user.openid}" class="btn btn-default">学习累积</a>
				</div>
			</div>
			<div class="panel-body list-group">
				<c:forEach items="${requestScope.data.list}" var="item">
					<a href="/rest/note/dyh/${item.id}" class="list-group-item my-data">
						<img src="${item.pic}" class="img-thumbnail" style="width: 48px;height: 48px">
						<div>${item.title }</div>
						<div><fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd hh:mm"/></div>
						<div>></div>
					</a>
				</c:forEach>
			</div>
		</div>
		<style type="text/css">
			.my-data{display:flex;padding:0;}
			.my-data>div{line-height:48px;}
			.my-data>div:NTH-CHILD(2){flex:1;padding:0 5px;}
			.my-data>div:NTH-CHILD(3){width:130px;padding:0 5px;}
			.my-data>div:NTH-CHILD(4){width: 10px;}
		</style>
	</div>
	<%@include file="../common/user.jsp"%>
</body>
<script type="text/javascript">
	setTitle('我的笔记');
</script>
</html>
