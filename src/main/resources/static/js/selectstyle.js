$(function(){
	// $(".form-group").addClass("selectthree")
	// if(styletype=="01"){
		// $(".input-text").parents(".form-group").addClass("selectone");
		// $(".select-control").parents(".form-group").addClass("selectone");
	// }
	// if(styletype=="02"){
		$(".input-text").parents(".form-group").addClass("selecttwo");
		$(".select-control").parents(".form-group").addClass("selecttwo");
		$(".file-text").parents(".form-group").addClass("file-groups");
		$(".radio-box").parents(".form-group").find(".label-control").css("width","17.5%");
		$(".check-box").parents(".form-group").find(".label-control").css("width","17.5%");
	// }
	// if(styletype=="03"){
	//	 $(".input-text").parents(".form-group").addClass("selectthree");
	//	 $(".select-control").parents(".form-group").addClass("selectthree");
	//	 $(".radio-box").parents(".form-group").find(".label-control").css("width","13%");
	//	 $(".check-box").parents(".form-group").find(".label-control").css("width","13%");
	// }
    //        上传开始
    var cc=$(".preview-box .ipp");
    $.each(cc,function(index,item){
        $(this).on("change",function(){
            previewImage(index)
        })
    });

    function previewImage(index){
        var file = document.getElementsByClassName("ipp")[index];
        var div = document.getElementsByClassName("preview")[index];
        var fileSize =file.files[0].size;  //文件大小
        var helpBlock = document.getElementsByClassName("img-group")[index];
        var maxSize = 1*1024*1024;
        if(fileSize>maxSize){
            file.value="";
            helpBlock.style.opacity=1;
            helpBlock.innerHTML="图片大小不超过1M";
            return false;
        }else{
            helpBlock.innerHTML="";
            if(file.files&&file.files[0]){
                div.innerHTML = '<img class="imghead"/>';
                var img = document.getElementsByClassName("imghead");
                var reader = new FileReader();
                reader.onload = function(evt){
                    img[index].src=evt.target.result;
                };
                reader.readAsDataURL(file.files[0]);
                helpBlock.style.opacity=0
            }
        }
    }
//        上传结束
	
});