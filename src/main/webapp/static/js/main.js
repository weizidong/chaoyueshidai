function setTitle(title) {
	document.title = title || '电子送达系统';
}
function check(id){
	var pattern = $('#'+id+' input').attr('pattern');
	if(!$('#'+id+' input').val() || (pattern && !new RegExp(pattern).test($('#'+id+' input').val()))){
		$('#'+id).addClass('has-error');
		return false;
	}else{
		$('#'+id).removeClass('has-error');
		return true;
	}
}
function setCheck(ids){
	ids.map(function(id){
		$('#'+id+' input').blur(function(){
			check(id);
		});
	});
}
function ajax(url,data,success,error) {
	loading && loading(true);
	$.ajax({
	   url: url,
	   type:'POST',
	   contentType:'application/json;charset=UTF-8',
	   processData:false,
	   data: JSON.stringify(data),
	   success: function(data){
		   loading && loading(false);
		   if(data.code == 500){
			   error && error(data);
		   }else{
			   success && success(data.data || data); 
		   }
       },
       error: function (e) {
    	   loading && loading(false);
    	   error && error(e);
       }
	 });
}
function serialize(form) {
	var list= $(form).serializeArray();
	var data = {};
	list.map(function(item){
		data[item.name] = item.value
	})
	return data;
}
Date.prototype.format = function (fmt) { //author: meizz 
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};