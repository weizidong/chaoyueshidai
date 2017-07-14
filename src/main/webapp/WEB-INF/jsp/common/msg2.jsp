<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<div id="msg" class="alert alert-info alert-dismissible fade in hidden" role="alert">
  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
  <div></div>
</div>
<script type="text/javascript">
function hiddenMsg() {
	$("#msg").removeClass("show");
	$("#msg").addClass("hidden");
}
function sucessMsg(msg) {
	$("#msg>div").html(msg);
	$("#msg").addClass("show alert-success");
	$("#msg").removeClass("hidden");
}
function errorMsg(msg) {
	$("#msg>div").html(msg);
	$("#msg").addClass("show alert-danger");
	$("#msg").removeClass("hidden");
}
</script>
