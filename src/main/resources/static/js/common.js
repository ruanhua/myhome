/**
 * Created by harvey on 2017/06/14.
 * 公共方法文件
 * 尽量不要修改
 */

/*$(document).ready(function() {
    $("#startDate").datepicker({
        language: 'zh-CN',
        dateFormat: 'yy-mm-dd',"setDate": (new Date() - 1)});
    $("#endDate").datepicker({
        language: 'zh-CN',
        dateFormat: 'yy-mm-dd',"setDate": (new Date() - 1) });
});*/

 /**获取当前时间 格式：yyyy-MM-dd HH:ss**/
 function getNowFormatDate(){
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
 }


 /**获取当前时区的方法**/
 function getTimeZone(){
    var d = new Date();
    var gmtHours = d.getTimezoneOffset()/60;
    return "GMT "+gmtHours;
 }
 
 /**生成reqMsgId**/
 function generateReqMsgId(){
    var timestamp = new Date().getTime();
    var reqMsgId = "req" + timestamp + "0001";
    return reqMsgId;
 }

/**获取地址栏后面的参数**/
function getUrlParam(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r!=null) return unescape(r[2]); return null; //返回参数值
}

/**
 * 获取本地缓存信息
 */
function getLocalData (key){
    return JSON.parse(localStorage.getItem(key));
}
/**
 * 设置本地缓存信息
 */
function setLocalData (key,data){
    localStorage.removeItem(key);
    localStorage.setItem(key,JSON.stringify(data));
}
/**
 * 清除本地缓存信息
 */
function removeLocalData (key){
    localStorage.removeItem(key);
}
/**
 * 清空本地缓存信息
 */
function removeAllLocalData(){
    localStorage.clear();
}

function removeClass(obj, sClass) {
    var aClass = obj.className.split(' ');
    if (!obj.className) return;
    for (var i = 0; i < aClass.length; i++) {
        if (aClass[i] === sClass) {
            aClass.splice(i, 1);
            obj.className = aClass.join(' ');
            break;
        }
    }
}
function hasClass(obj, sClass) {
      if (!obj.className) return;
    var aClass = obj.className.split(' ');
    for (var i = 0; i < aClass.length; i++) {
        if (aClass[i] === sClass) {
            return false;
        }else
        {
            return true;
        }
    }
}
//姓名校验
function nameValid(name){
    var reg = /^[a-zA-Z\u4e00-\u9fa5]+$/;
    return reg.test(name);
}
//身份证长度验证
function isCardNo(card){
    var reg = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/;
    if(reg.test(card) == false) {
        return false;
    }
    return true;
};
//军官证长度格式验证
function isOfficer(num){
    var reg=/[\u4e00-\u9fa5](子第){1}(\d{4-8})(号?)$/;
    if(reg.test(num)==false){
        return false
    }
    return true;
}
//护照格式长度验证
function ispassport(card){
    var re1 = /^[a-zA-Z]{5,17}$/;
    var re2 = /^[a-zA-Z0-9]{5,17}$/;
    if(re1.test(card)==false || re2.test(card)==false){
        return false
    }
    return true;
}
//手机格式验证
function isMobile(tel){
    var reg = /^1[3|4|5|7|8]\d{9}$/;
    if(reg.test(tel) == false) {
        return false;
    }
    return true;
}
//图片格式验证
function isImage(img){
 var reg=rFilter = /^(?:image\/bmp|image\/cis\-cod|image\/gif|image\/ief|image\/jpeg|image\/jpeg|image\/jpeg|image\/pipeg|image\/png|image\/svg\+xml|image\/tiff|image\/x\-cmu\-raster|image\/x\-cmx|image\/x\-icon|image\/x\-portable\-anymap|image\/x\-portable\-bitmap|image\/x\-portable\-graymap|image\/x\-portable\-pixmap|image\/x\-rgb|image\/x\-xbitmap|image\/x\-xpixmap|image\/x\-xwindowdump)$/i;
 if(reg.test(img)==false){
    return false;
 }
 return true;
}
//下拉框点选，对应的提示
function selectType(textVal,pointer,isvalidate){
        textVal.value="";
        textVal.addEventListener('input',function(){
          sameChange(isvalidate,pointer,textVal.value,textVal)
        })
}
//验证错误提示
function sameChange(change,TagEl,val,el){

    if(!change(val)){
        TagEl.style.opacity=1;
        TagEl.style.display="block";
        el.style.border='1px solid red';
    }else{
        TagEl.style.opacity=0;
        el.style.border='';
        TagEl.style.display="none";
    }
}
//公共部分ajax
function submitRequest(urlRequest,resultSuccess,resultError){
    $.ajax({
        url:urlRequest,
        type:"GET",
        dataType: "json",
        contentType:"application/json",
        //data:jsonRequest,
        success: function(result){
            resultSuccess(result);
        },
        error:function(){
            resultError();
        }
    });
}
var letClick=function(){

    var liA=$(".nav-two").find("li a");
    liA.each(function(index,item){
        var _this=$(this);
        var aHtml=$(this).html();
        var titleHtml=$(".heading").html();
        if(aHtml==titleHtml){
            _this.parent("li").parent(".nav-two").css("display","block");
            _this.parent("li").addClass("selectedColor").css("color","#fff")
        }

    })
}
