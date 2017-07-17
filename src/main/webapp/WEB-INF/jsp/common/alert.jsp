<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<div id="msgBox">
</div>
<script type="text/javascript">
function _alert(html,type) {
	var msg = $('<div class="alert alert-info alert-dismissible fade in"role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>');
	msg.append(html);
	$('#msgBox').html(msg);
	msg.addClass('alert-'+type);
	setTimeout(function () {
		$('.alert').alert('close');
	}, 2000);
}
</script>
