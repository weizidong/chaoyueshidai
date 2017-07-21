<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="./head.jsp"%>
<body>
	<%@include file="./header.jsp"%>
	<style type="text/css">
		.page>div{position:absolute;top:50%;left:50%;transform: translate(-50%,-50%);}
		.page .msg{text-align:center;color:#a94442;border-color:#ebccd1;}
	</style>
	<div class="page">
		<div>
			<img src="/static/img/500.png">
			<c:if test="${requestScope.msg != null}">
				<div class="alert msg">${requestScope.msg}</div>
			</c:if>
		</div>
	</div>
</body>
<script type="text/javascript">
	setTitle('出错了');
</script>
</html>
