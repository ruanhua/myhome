var payInput = {
    submit: function () {
        var payStatus = $("#payStatus").val();
        if(payStatus != null && payStatus == 'WAIT'){
            alert("该案件正在支付中，不允许重复支付!");
            return;
        }
        $("#paymentFrom").attr("action", "/payService/submitPayCase");
        $("#paymentFrom").submit();
    },
    submitNextStep: function () {
        $("#operateStyle").val("nextStep");
        $("#paymentFrom").attr("action", "/payService/addPayCase");
        $("#paymentFrom").submit();
    },
    goBack: function () {
        $("#operateStyle").val("goBack");
        $("#paymentFrom").attr("action", "/payService/addPayCase");
        $("#paymentFrom").submit();
    },
    getCode: function (codeCondition, fileID, url,defaultVal) {
        $(fileID).empty();
        $(fileID).append($("<option/>").text("--请选择--").attr("value", ""));
        $.ajax({
            type: "POST",
            url: url,
            contentType: "application/json",
            data: JSON.stringify(codeCondition),
            success: function (data) {
                $(data).each(function () {
                    if(defaultVal === this.id+""){
                        $(fileID).append($("<option/>").text(this.name).attr("selected","selected").attr("value",this.id));
                    }else{
                        $(fileID).append($("<option/>").text(this.name).attr("value",this.id));
                    }
                });
            }
        })
    }
}


$(function () {
    var operateStyle = $("#operateStyle").val();
    if(operateStyle == '' || operateStyle == null){
        $(".gobackBtn").hide();
    }
    if(operateStyle == 'nextStep'){
        $(".nextSubmit").hide();
    }else{
        $(".gobackBtn").hide();
    }

    if(operateStyle == 'query'){
        $(".gobackBtn").hide();
        $(".nextSubmit").hide();
    }
    if(operateStyle != 'nextStep') {
        var provinceCode_1 = $("#provinceCode_1").val();
        var cityCode_1 = $("#cityCode_1").val();
        var codeCondition = new Object();
        codeCondition.levelType = 1;
        payInput.getCode(codeCondition, "#provinceCode", "/payService/getAreaByUpper",provinceCode_1);
        if(provinceCode_1 != null && provinceCode_1 != ''){
            var codeCondition = new Object();
            codeCondition.parentId = provinceCode_1;
            payInput.getCode(codeCondition, "#cityCode", "/payService/getAreaByUpper",cityCode_1);
        }

        $("#provinceCode").change(function () {
            var codeCondition = new Object();
            codeCondition.parentId = $(this).val();
            payInput.getCode(codeCondition, "#cityCode", "/payService/getAreaByUpper",cityCode_1);
        });
        var condition = new Object();
        condition.codeType = "bankCode";
        var sel = document.getElementById("bankCode");
        $(".banks-type .bootstrap-select:not([class*=col-]):not([class*=form-control]):not(.input-group-btn)").css("width", "500px");

        $.ajax({
            type: "POST",
            url: "/payService/queryCode",
            contentType: "application/json",
            data: JSON.stringify(condition),
            async: false,
            success: function (res) {
                console.log(res);
                var a = "1";
                $.each(res, function (index, item) {
                    sel.options.add(new Option(item.unionname, item.unioncode));
                });
                $(".banks-type .bootstrap-select").css("margin-top", "0");
                $(".banks-type .bootstrap-select button").css("width", "100%");
            }
        });

        $('.selectpicker').selectpicker({
            'selectedText': 'cat'
        });
        var bank_Code = $("#bank_Code").val();
        $.each($("#bankCode option"), function (index, item) {
            if (($(item).val()) == bank_Code) {
                $(item).attr("selected", "selected");
                var textselect = $(item).text();
                $(".filter-option").text(textselect);
            }
        });
    }
    if(operateStyle == 'nextStep') {
        $("input").attr("readonly",true);
    }
})

