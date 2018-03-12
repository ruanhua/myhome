var payQuery = {
    search : function (){
        $("#payQueryForm").attr("action", "/payService/payQuery");
        $("#payQueryForm").submit();
    },
    getCode : function (codeCondition,fileID,url,defvalue) {
        $(fileID).empty();
        $(fileID).append($("<option/>").text("--请选择--").attr("value",""));
        $.ajax({
            type: "POST",
            url: url,
            contentType: "application/json",
            data: JSON.stringify(codeCondition),
            success: function (data) {
                $(data).each(function () {
                    if(defvalue === this.unioncode){
                        $(fileID).append($("<option/>").text(this.unionname).attr("selected","selected").attr("value",this.unioncode));
                    }else{
                        $(fileID).append($("<option/>").text(this.unionname).attr("value",this.unioncode));
                    }
                });
            }
        })
    }
}

$(document).ready(function() {
    $("#startDate").datepicker({
        language: 'zh-CN',
        changeMonth: true,
        dateFormat: 'yy-mm-dd',"setDate": (new Date() - 1)});
    $("#endDate").datepicker({
        language: 'zh-CN',
        changeMonth: true,
        dateFormat: 'yy-mm-dd',"setDate": (new Date() - 1) });
    $(function(){
        var condition = new Object();
        condition.codeType = 'channel';
        var channel_1 = $("#channel_1").val();
        payQuery.getCode(condition,"#channel","/payService/queryCode",channel_1)
    });
});