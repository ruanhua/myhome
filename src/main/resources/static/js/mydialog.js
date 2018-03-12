var str=""

str='<div class="mydialowrap mydialowrapHide" id="mydialowrap">'+
       '<div class="mydialogmark"></div>'+
	   '<div class="mydialogs">'+
		'<span class="mydialogs_close"> x </span>'+
		'<div class="mydialogs_cont">'+
	        '<div class="mydialogs_conts">退保尚未完成，确认删除？</div>'+
		'</div>'+
		'<div class="mydialogs_footer">'+
	         '<span class="mydialogs_btn">确定</span>'+
	         '<span class="mydialogs_btn">取消</span>'+
		'</div>'+
	'</div>'+
'</div>'
$('body').append(str)

$('.mydialogs_close').click(function(){

    $('.mydialowrap').addClass('mydialowrapHide')
})
$('.mydialogs_btn').eq(1).click(function(){

    $('.mydialowrap').addClass('mydialowrapHide')
})