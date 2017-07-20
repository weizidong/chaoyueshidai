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