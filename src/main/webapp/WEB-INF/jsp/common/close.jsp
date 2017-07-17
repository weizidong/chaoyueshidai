<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<button type="button" class="btn btn-danger" id="close">关闭</button>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jweixin-1.2.0.js"></script>
<script type="text/javascript">
// 关闭
$('#close').click(function() {
	wx.closeWindow();
});
</script>
