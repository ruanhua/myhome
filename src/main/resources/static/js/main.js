/**
 * Created by admin on 2017/08/14.
 */
var ctripUrl ="" ;
var elongUrl ="" ;
var imageUrl ="" ;
$(function(){
    //返回顶部
    $(window).scroll(function() {
        t = $(window).scrollTop();
        if( t >=$(window).height()/2) {
            $("#gotop").show(1000);
        }else{
            $("#gotop").hide();
        }
    });
    $("#gotop").click(function() {
        $("html,body").animate({
            scrollTop: 0
        }, 1000);
    });

    $("li.dropdown").hover(function(){
        $("li.dropdown a.navli").removeClass("cur");
        $(this).children("a.navli").addClass("cur");
    },function(){
        $("li.dropdown a.navli").removeClass("cur");
    });

    $(".dropdown").hover(function(){

        $(this).find(".dropdown-menu").css('left',$(this).position().left);
        $(this).find(".dropdown-menu").css('width',$(this).width);
    });

    $("#nav li a").each(function(){
        $(this).click(function(){
            $(this).attr("class","active");
            $(this).parent().siblings().children("a").removeClass("active");
        })
    });
    var headH=$(".header").height();
    // console.log(headH);
    var navH=$(".snavbar").height();
    var topH=headH+navH+15;

    $(".fold").css("top","topH");
    $(".fold").click(function(){
        $(this).toggleClass("openpic").next().toggle();
        if($(this).hasClass("openpic")==true){


            //  $(this).css("top","topH");
            $(".rightbox").css({"width":"98%"});
        }else{
            // $(this).css("top","50%");
            $(".rightbox").css("width","81%");
        }
    })
    $(".nav_left>li a.nav_one").click(function(){
        if($(this).children().find("ul")){
            $(this).next("ul").toggle();
            $(this).toggleClass("arrow_bottom");
        }
    });
    $(".nav_left>li>ul>li>a").click(function(){
        if($(this).children().find("ul")){
            $(this).next("ul").toggle();
            // $(this).toggleClass("arrow_bottom");
        }

    });

    /* $(".nav_left>li>ul>li a").each(function(){
     $(this).click(function(){
     $(this).next("ul").toggle();
     console.log(222);
     })
     });
     $(".nav_left li a.arrow_right").click(function(){
     $(this).toggleClass("arrow_bottom").next().toggle();

     });*/
    /* $(".nav_left li a.arrow_right").click(function(){
     $(this).toggleClass("arrow_bottom").next().toggle();
     })*/
    //获取左侧导航的高度
    var winHeight=$(window).height();
    var headHeight=$(".header").height();
    var leftHeight=winHeight-headHeight;
    //console.log(leftHeight);
    $(".main .leftbox").height(leftHeight);
    $(".main .rightbox").height(leftHeight);
    var titHeight=$(".rightbox .heading").height();
    var rigR=leftHeight-titHeight;
    $(".rightbox .query").height(rigR);

    //这里是支付方式
    $("#payment select").on("change",function(){
        if($(this).val()=="1"){
            $("#banknumber,#bank").addClass("ignore");

            $(".bankmessage").hide();
        }else if($(this).val()=="2"){
            $(".bankmessage").show();
        }
    })



})



// $(function(){
//     //第三方插件表单验证
//     $(".form-validate").each(function(){
//         var myform = $(this);
//         var error = $('.alert-danger', myform);
//         var success = $('.alert-success', myform);
//         var myValidate = myform.validate({
//             errorElement: 'span', //default input error message container
//             errorClass: 'msg-error', // default input error message class
//             focusInvalid: false, // do not focus the last invalid input
//             // onfocusout:true,调试时参数中加上debug:true则只用于调试表单不会提交到服务器
//             ignore: ".ignore", // validate all fields including form hidden input
//             rules: {
//                 username: {
//                     required: true,
//                     rangelength: [2, 20],
//                     user: true
//                 },
//                 bdcode:{
//                     required: true,
//
//                 },
//                 claimMsg:{
//                     required: true,
//                 },
//                 mobile:{
//                     required: true,
//                     mobile:true,
//                 },
//                 payee:{
//                     required:true,
//                 },
//                 amount:{
//                     required:true,
//                     number:true,
//                 },
//                 banknumber:{
//                     required: true,
//                     number:true,
//                     minlength:15,
//                     maxlength:19
//                 },
//                 sendMsg:{
//                     required:true,
//                 },
//                 option:{
//                     required:true,
//                 },
//                 example:{
//                     required:true,
//                 },
//                 bank:{
//                     required:true,
//
//                 },
//                 bankCode:{
//                     required:true,
//                 },
//                 chulimsg:{
//                     required:true,
//                 },
//                 idcard:{
//                     required:true,
//                     idcard:true
//                 },
//                 isidcard:{
//                     required:true,
//                     isidcard:true
//                 },
//                 passport:{
//                     required:true,
//                     passport:true
//                 },
//                 issoliders:{
//                     required:true,
//                     issoliders:true
//                 },
//                 cxplace:{
//                     required:true,
//                 },
//                 other:{
//                     required:true,
//                 }
//
//
//             },
//             messages: {
//
//                 username: {
//                     required: "请输入收款人姓名",
//                     user: "用户名输入格式不正确",
//                     rangelength: "用户名长度为2-20位字符串",
//                 },
//                 bdcode:{
//                     required:"不能为空",
//                 },
//                 sendMsg:{
//                     required:"不能为空",
//                 },
//                 claimMsg:{
//                     required: "不能为空",
//                 },
//                 mobile:{
//                     required: "不能为空",
//                 },
//                 payee:{
//                     required:"不能为空",
//                 },
//                 amount:{
//                     required:"不能为空",
//                 },
//                 bankCode:{
//                     required:"不能为空",
//                 },
//                 chulimsg:{
//                     required:"不能为空",
//                 },
//                 option:{
//                     required:"不能为空",
//                 },
//                 example:{
//                     required:"不能为空",
//                 },
//                 bank:{
//                     required:"不能为空",
//                 },
//                 banknumber: {
//                     required: "请输入银行卡号",
//                     number: "银行卡号为数字类型",
//                     minlength: "银行卡号长度不小于15位",
//                     maxlength: "银行卡号长度不超过19位"
//                 },
//                 isidcard:{
//                     required: "请输入身份证号码",
//
//                 },
//                 cxplace:{
//                     required:"请输入出险地点",
//                 },
//                 other:{
//                     required:"请输入证件号码",
//                 }
//
//             },
//             errorPlacement: function (error, element) { // render error placement for each input type
//                 var msg = $(element).closest('.form-group').find(".help-block").text(error.text());
//                 // for other inputs, just perform default behavio
//                 $(element).closest('.preview-box').find(".help-block").text(error.text());
//
//             },
//
//             invalidHandler: function (event, validator) { //display error alert on form submit
//                 // success.hide();
//                 error.show();
//                 myform.data("validate",false);
//                 console.log("error")
//             },
//             highlight: function (element) {
//                 $(element).closest('.form-group').removeClass("has-success").addClass('has-error');
//                 $(element).closest('.upload-box .preview-box').removeClass("has-success").addClass('has-error');
//             },
//             unhighlight: function (element) { // revert the change done by hightlight
//                 $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
//             },
//             success: function (label, element) {
//                 $(element).closest('.form-group').removeClass('has-error').addClass("has-success");
//                 $(element).closest('.upload-box .preview-box').removeClass('has-error').addClass("has-success");
//                 $(element).closest('.form-group').find("[type='text']").removeClass('has-error').addClass("has-success");
//                 $(element).closest('form-group').find("[type='text']").removeClass('has-error').css("border","1px solid transparent");
//                 var icon = $(element).closest('.wps-form-group').find(".help-block");
//
//                 icon.text("");
//                 if($(element).attr("id")=="mobile"){
//                     $("#getcode").prop("disabled",false);
//                 }
//
//             },
//
//             submitHandler: function (form) {
//
//             }
//         })
//     })
//
// });


$(document).ready(function(){
    dropdownOpen();
    // loadingConfig();

});
function dropdownOpen() {
    if($(window).width()>768){
        var $dropdownLi = $('.dropdown');
        $dropdownLi.mouseover(function() {
            $(".nav-bg").show();
            $(this).children(".dropdown-menu").show();
        }).mouseout(function() {
            $(this).children(".dropdown-menu").hide();
            $(".nav-bg").hide();
        });
    }
}
function config(channel) {
    var url;
    if(channel =="110"){
        url = ctripUrl ;
    }
    if(channel =="102"){
        url = elongUrl;
    }
    if(channel =="image"){
        url = imageUrl;
    }

    return url ;
}
// function loadingConfig() {
//     $.ajax({
//         type: "POST",
//         url: "/hotelCancel/claim/loadingConfig",
//         contentType: "application/json",
//         data:"",
//         success: function (res) {
//             console.log(res);
//              ctripUrl =res.ctripUrl;
//              elongUrl =res.elongUrl;
//              imageUrl =res.imageUrl;
//         }
//     })
// }




