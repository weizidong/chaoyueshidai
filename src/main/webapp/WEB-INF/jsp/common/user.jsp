<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Modal -->
<c:if test="${sessionScope.user == null}">
	<div class="modal fade" id="userModel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">提示</h4>
	      </div>
	      <div class="modal-body">
	      	<p>您的资料不存在，请绑定账号或注册新用户！</p>
	      </div>
	      <div class="modal-footer" style="text-align: center">
	        <button type="button" class="btn btn-info" id="bindBtn">绑定</button>
	        <button type="button" class="btn btn-info" id="registBtn">注册</button>
	      </div>
	    </div>
	  </div>
	</div>
	<%@include file="./register.jsp"%>
	<script type="text/javascript">
		$('#userModel').modal({keyboard:false,show:true,backdrop:'static'});
		// 绑定
		$('#bindBtn').click(function() {
			showModel(true);
		});
		// 注册
		$('#registBtn').click(function() {
			showModel(false);
		});
	</script>
</c:if>
