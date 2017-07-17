<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">注册用户</h4>
			</div>
			<div class="modal-body">
				<form action="/rest/user/register" method="post">
					<input name="openid" id="openid" style="visibility: hidden;" value="${requestScope.openid}">
					<div class="form-group" id="tel">
						<label for="tel">电话：</label>
						<input type="text" name="tel" pattern="^\d{11}$" class="form-control" placeholder="请输入电话...">
						<span class="help-block">电话号码为11为数字！</span>
					</div>
					<div class="form-group" id="name">
						<label for="name">姓名：</label>
						<input type="text" name="name" class="form-control" placeholder="请输入姓名...">
					</div>
					<div class="form-group" id="pwd">
						<label for="pwd">密码：</label>
						<input type="password" name="pwd" class="form-control" placeholder="请输入密码...">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
						<button type="submit" class="btn btn-primary">确定</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery.md5.js"></script>
<script type="text/javascript">
	setCheck([ 'tel', 'name', 'pwd' ]);
	// 显示弹出层
	function showModel(update) {
		$('#registerModal form').attr('action', '/rest/user/' + (update ? 'bind' : 'register'));
		$('#registerModal .modal-title').text(update ? '绑定账号' : '注册用户');
		$('#registerModal').modal('show');
	}
	// 提交验证
	$('#registerModal form').submit(function() {
		if (check('tel') || check('name') || check('pwd')) {
			var data = serialize('#registerModal form');
			data.pwd = $.md5(data.pwd);
			ajax($('#registerModal form').attr('action'), data, function(data) {
				$('#registerModal').modal('hide');
				sucessMsg(data.msg);
			}, function(e) {
				$('#registerModal').modal('hide');
				errorMsg(e.msg || '服务器异常！请稍后重试...');
			});
		}
		return false;
	});
</script>
