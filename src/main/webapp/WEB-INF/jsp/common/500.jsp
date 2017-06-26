<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%@include file="./head.jsp"%>
<body>
	<%@include file="./header.jsp"%>
	<div class="page container-fluid">
		<div class="alert alert-danger" role="alert">${requestScope.msg}</div>
	</div>
	<%@include file="./footer.jsp"%>
</body>
<script type="text/javascript">
	setTitle('出错了');
</script>
</html>
