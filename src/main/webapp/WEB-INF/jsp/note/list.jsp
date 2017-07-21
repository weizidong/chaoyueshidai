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
				  <a href="/rest/note/dyh/1/1/${sessionScope.user.openid}" class="btn btn-${requestScope.type==1?'info':'default'}">旅行日志</a>
				  <a href="/rest/note/dyh/2/1/${sessionScope.user.openid}" class="btn btn-${requestScope.type==2?'info':'default'}">灵感速记</a>
				  <a href="/rest/note/dyh/3/1/${sessionScope.user.openid}" class="btn btn-${requestScope.type==3?'info':'default'}">学习累积</a>
				</div>
			</div>
			<div class="panel-body">
				<div class="list-group" style="margin:0">
					<c:forEach items="${requestScope.data.list}" var="item">
					<a href="/rest/note/dyh/${item.id}" class="list-group-item my-data ${fn:length(requestScope.data.list)==1?'one':''}">
						<div class="point"></div>
						<img src="${fn:contains(item.pic,'/userfiles/')?item.pic:'/static/img/none.png'}" class="img-thumbnail" style="width: 48px;height: 48px">
						<div>${item.title }</div>
						<div><fmt:formatDate value="${item.created }" pattern="yyyy-MM-dd HH:mm"/></div>
					</a>
				</c:forEach>
				</div>
				<c:if test="${fn:length(requestScope.data.list) == 0}">
					<%@include file="../common/nodata.jsp"%>
				</c:if>
				<c:if test="${requestScope.data.end < requestScope.data.all}">
					<div class="text-center" style="padding:10px;" id="loadMore">
						<div type="button" class="btn btn-default" data-loading-text="努力加载中...">加载更多...</div>
					</div>
				</c:if>
			</div>
		</div>
		<style type="text/css">
			.panel{margin:0;padding:0;border:none;}
			.panel-body{padding:0;position:absolute;width:100%;top:53px;bottom:0;ovoverflow-y:scroll;overflow-x:hidden;}
			.my-data{display:flex;padding:16px;border:none;}
			.my-data>div{line-height:48px;}
			.my-data>div:NTH-CHILD(3){flex:1;padding:0 5px;}
			.my-data>div:NTH-CHILD(4){width:130px;padding:0 5px;}
			.point{width:1px;height:100%;position:absolute;left:8px;top:0;background-color:#337ab7;box-shadow: 0 0 4px 0 #5bc0de;}
			.point:after,.point:before{content:'';position:absolute;top:50%;left:50%;width:8px;height:8px;
			background-color:#5bc0de;border-radius:50%;transform: translate(-50%,-50%);box-shadow: 0 0 4px 0 #5bc0de;}
			.point:after{background-color:#FFF;width:4px;height:4px;}
			.my-data:FIRST-CHILD .point{height:50%;top:50%;}
			.my-data:FIRST-CHILD .point:after,.my-data:FIRST-CHILD .point:before{top:0;}
			.my-data:LAST-CHILD .point{height:50%;top:0;}
			.my-data:LAST-CHILD .point:after,.my-data:LAST-CHILD .point:before{top:100%;}
			.my-data.one .point{height:0;top:50%;}
			.my-data.one .point:after,.my-data.one .point:before{top:0;}
			#loadMore>.btn-default{border:none;}
		</style>
	</div>
	<%@include file="../common/user.jsp"%>
</body>
<script type="text/javascript">
	setTitle(['旅行日志','灵感速记','学习累积'][${requestScope.type}-1]);
	var page = {page:${requestScope.data.page},pageSize:${requestScope.data.pageSize }};
	$('#loadMore>.btn-default').click(function() {
		var $btn = $('#loadMore>.btn-default').button('loading');
		page.page+=1;
		ajax('/rest/note/find/${requestScope.type}/${sessionScope.user.id}', page, function(data) {
			var html = '';
			data.list.forEach(function(item) {
				html+='<a href="/rest/note/dyh/'+item.id+'" class="list-group-item my-data"><div class="point"></div><img src="'
				+(item.pic.indexOf('/userfiles/')>-1?item.pic:'/static/img/none.png')+'" class="img-thumbnail" style="width: 48px;height: 48px"><div>'+item.title+'</div><div>'
				+new Date(item.created).format("yyyy-MM-dd hh:mm")+'</div></a>';
			});
			$('.panel-body .list-group').append(html);
			if(data.end < data.all){
				$btn.button('reset');
			}else{
				$('#loadMore').html('全部加载完成！');
			}
		}, function(e) {
			_alert(e.msg || '服务器异常！请稍后重试...','danger');
			$btn.button('reset');
		});
	});
</script>
</html>
