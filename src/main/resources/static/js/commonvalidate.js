
$(function(){
    //第三方插件表单验证
    $(".form-validate").each(function(){
        var myform = $(this);
        var error = $('.alert-danger', myform);
        var success = $('.alert-success', myform);
        var myValidate = myform.validate({
            errorElement: 'span', //default input error message container
            errorClass: 'msg-error', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            // onfocusout:true,调试时参数中加上debug:true则只用于调试表单不会提交到服务器
            ignore: ".ignore", // validate all fields including form hidden input
            rules: {
                // PC退保录入 选择日期
                selectdate:{
                    required:true
                },
                endselectdate:{
                    required:true
                },
                //投保人电话
                mobile:{
                    required:true,
                    mobile:true
                },
                //投保人姓名
                policyname:{
                    required:true
                },
                //投保人证件号
                idNumber:{
                    required:true,
                    idNumber:true
                },
                //被保人姓名
                insuredname:{
                    required:true
                },
                //航班号
                flightnumber:{
                    required:true
                },

                // //实付金额
                // tradeCost:{
                //     required:true
                // },
                // //调整金额
                // remark:{
                //     required:true
                // },
                // //金额调整说明
                // adjustOpinion:{
                //     required:true
                // },
                //保单号
                policyNo:{
                    required:true,
                    policyNo:true
                },
                //PC结束
                //标的信息
                all_message:{
                    required:true
                },
                //投保人联系电话
                insure_tel:{
                    required:true,
                    agent_mobile:true
                },
                //被保人联系电话
                by_tel:{
                    required:true,
                    agent_mobile:true
                },
                //投保人证件号
                insure_sectype:{
                    required:true,
                    agent_card_no:true
                },
                //被保人证件号
                by_sectype:{
                    required:true,
                    agent_card_no:true
                },
                //投保人证件类型
                insure_section:{
                    required:true
                },
                //被保人证件类型
                by_section:{
                    required:true
                },
                //投保人姓名
                insure_name:{
                    required:true,
                    user:true
                },
                //被保人姓名
                by_name:{
                    required:true,
                    user:true
                },
                //投保人地址
                insure_address:{
                    required:true
                },
                //被保险人地址
                by_address:{
                    required:true
                },
                /*//投保人证件正面
                policy_positive_card:{
                    required: true
                },
                //投保人证件反面
                policy_reserve_card:{
                    required: true
                },
                //代办人证件正面
                agent_positive_card:{
                    required: true
                },
                //代办人证件反面
                agent_reserve_card:{
                    required: true
                },
                account_number:{
                    required: true,
                    number:true,
                    minlength:15,
                    maxlength:19
                },*/
                change_info: {
                    required: true,
                    number:true
                },
                passport:{
                    required:true,
                    passport:true
                },

                issoliders: {
                    required: true,
                    issoliders: true,
                },

                isregister: {
                    required: true,
                    isregister: true
                },
                isTaiwan: {
                    required: true,
                    isTaiwan: true
                },
                isHKMacao: {
                    required: true,
                    isHKMacao: true
                },
                other: {
                    required: true,
                },
                sscode:{
                    required:true,
                    sscode:true
                },
                agent_name:{
                    required:true
                },
                change_reason:{
                    required:true
                },
                agent_mobile:{
                    required:true,
                    agent_mobile:true
                },
                email:{
                    required: true,
                    email:true
                },
                code:{
                    required: true
                },
                accept:{
                    required: true
                },
                phone: {
                    required: true,
                    phone: true
                },
                clientname:{
                    required: true
                },

                identity_card:{
                    required:true,
                    identity_card:true
                },
                // 验证身份证
                agent_card_no:{
                    required:true,
                    agent_card_no:true
                },
                cctel: {
                    required:true,
                    pattern: /^[0-9]+$/
                },

                maintenance_item:{
                    required:true,
                    minlength:1

                },
                insureinfo:{
                    required:true,
                    minlength:1,
                },
                account_number:{
                    required:true,
                    number:true,
                    minlength:"15",
                    maxlength:"19"
                },
                premiumrefund: {
                    required: true,
                    number:true,
                    minlength: "15",
                    maxlength: "19"
                },
                insurance_coverage: {
                    required: true
                },
                insured_against: {
                    required: true
                },
                /*bank_card: {
                    required: true
                },*/
                agency_covera: {
                    required: true
                },
                agency_back: {
                    required: true
                },
                user_name: {
                    required: true,
                    user:true,
                    rangelength: [2,20]
                },
                luckymanname:{
                    required: true,
                    user:true,
                    rangelength: [2,20]
                },
                lnsurername:{
                    required: true,
                    user:true,
                    rangelength: [2,20]
                },
                policyholdername:{
                    required: true,
                    user:true,
                    rangelength: [2,20]
                },
                placename:{
                    required: true
                },
                deliveryaddress:{
                    required:true
                },
                streetaddress:{
                    required:true
                },
                premium_refund:{
                    required: true,
                    number:true,
                },
                account: {
                    required: true,
                    number:true,
                    minlength:15,
                    maxlength:19
                },
                ococ:{
                    required: true,
                    ococ:true
                },
                residence:{
                    required: true,
                    residence:true
                },
                optionList:{
                    required: true
                }

            },
            messages: {
                // PC退保录入 选择日期
                selectdate:{
                    required:"请选择日期"
                },
                endselectdate:{
                    required:"请选择日期"
                },
                //投保人电话
                mobile:{
                    required:"请输入投保人电话"
                },
                //投保人姓名
                policyname:{
                    required:"请输入姓名"
                },
                //投保人证件号
                idNumber:{
                    required:"请输入证件号"
                },
                //被保人姓名
                insuredname:{
                    required:"请输入被保人姓名"
                },
                //航班号
                flightnumber:{
                    required:"请输入航班号"
                },

                // //实付金额
                // tradeCost:{
                //     required:"请输入实付金额"
                // },
                // //调整金额
                // remark:{
                //     required:"请输入调整金额"
                // },
                // //金额调整说明
                // adjustOpinion:{
                //     required:"请输入调整金额"
                // },
                //保单号
                policyNo:{
                    required:"请输入保单号"
                },
                optionList:{
                    required: "请选择变更选项"
                },
                //PC结束
                //标的信息
                all_message:{
                    required:"标的信息不能为空"
                },
                //投保人联系电话
                insure_tel:{
                    required:"请输入投保人联系电话",
                    agent_mobile:"请输入正确的手机号码"
                },
                //被保人联系电话
                by_tel:{
                    required:"请输入被保人联系电话",
                    agent_mobile:"请输入正确的手机号码"
                },
                //投保人证件号
                insure_sectype:{
                    required:"请输入投保人证件号",
                    agent_card_no:"身份证格式不对"
                },
                //被保人证件号
                by_sectype:{
                    required:"请输入被保人证件号",
                    agent_card_no:"身份证格式不对"
                },
                //投保人证件类型
                insure_section:{
                    required: "请输入投保人证件类型",
                },
                //被保人证件类型
                by_section:{
                    required: "请输入被保人证件类型",
                },
                //投保人姓名
                insure_name:{
                    required: "请输入投保人姓名",
                    user:"投保人名称输入格式不正确",
                    rangelength: [2, 20]
                },
                //被保人姓名
                by_name:{
                    required: "请输入被保人姓名",
                    user:"投保人名称输入格式不正确",
                    rangelength: [2, 20],
                },
                //投保人地址
                insure_address:{
                    required: "请输入投保人地址",
                },
                //被保险人地址
                by_address:{
                    required: "请输入被保人地址",
                },
                /*//投保人证件正面
                policy_positive_card:{
                    required:"请上传资料"
                },
                //投保人证件反面
                policy_reserve_card:{
                    required:"请上传资料"
                },
                //代办人证件正面
                agent_positive_card:{
                    required:"请上传资料"
                },
                //代办人证件反面
                agent_reserve_card:{
                    required: "请上传资料"
                },

                change_reason:{
                    required:"请填选变更原因"
                },
                agent_name:{
                    required:"请输入代办人姓名",
                    rangelength: [2, 20],
                    user: true
                },*/
                user_name: {
                    required: "请输入姓名",
                    //rangelength: "用户名长度不正确",
                },
                change_info: {
                    required: "金额不能为空",
                    number:"金额为数字类型"
                },

                clientname:{
                    required:"用户名不能为空"
                },
                email:{
                    required: "请输入邮箱"
                },
                mobile:{
                    required: "请输入手机号"
                },
                code:{
                    required: "请输入验证码"
                },
                phone: {
                    required: "请输入手机号"
                },
                sscode:{
                    required:"请填写邮政编码"
                },
                passport:{
                    required:"请填写护照号"
                },
                issoliders:{
                    required:"请填写军官证号"
                },
                identity_card:{
                    required:"请填写身份证号"
                },
                agent_card_no:{
                    required:"请填写身份证号"
                },
                identifyNumber: {
                    required: "请输入证件号码"
                },
                issoliders: {
                    required: "请输入军官证号",

                },
                isregister: {
                    required: "请输入居民证",

                },
                isTaiwan: {
                    required: "请输入台湾证件号",

                },
                isHKMacao: {
                    required: "请输入港澳通行证",

                },
                other: {
                    required: "请输入证件号码",
                },
                cctel: {
                    required:'tel required',
                    pattern: "regex error"
                },
                agent_mobile:{
                    required:"请输入手机号码",
                    agent_mobile:"请输入正确的手机号码"
                },
                maintenance_item:{
                    required:"该项目至少要选一项",
                },
                insureinfo:{
                    required:"该选项是必填项",
                },
                account_number:{
                    required: "请输入银行卡号",
                    number:"金额为数字类型",
                    minlength: "银行卡号长度不小于15位",
                    maxlength: "银行卡号长度不超过19位"
                },
                premiumrefund: {
                    required: "金额不能为空",
                    number:"金额为数字类型",
                    minlength: "银行卡号长度不小于15位",
                    maxlength: "银行卡号长度不超过19位"
                },
                /*insurance_coverage: {
                    required: "请上传资料"
                },
                insured_against: {
                    required: "请上传资料"
                },
                bank_card: {
                    required: "请上传资料"
                },
                agency_covera: {
                    required: "请上传资料"
                },
                agency_back: {
                    required: "请上传资料"
                },*/

                user_name: {

                    required: "请输入用户名",
                    user: "用户名输入格式不正确",
                    rangelength: "用户名长度为2-20位字符串",
                },
                luckymanname:{
                    required: "请输入乘机人名称",
                    user:"乘机人名称输入格式不正确",
                    rangelength: "乘机人长度为2-20位字符串"
                },
                lnsurername:{
                    required: "请输入保险人名称",
                    user:"保险人名称输入格式不正确",
                    rangelength: "保险人长度为2-20位字符串"
                },
                policyholdername:{
                    required: "请输入投保人名称",
                    user:"投保人名称输入格式不正确",
                    rangelength: "投保人长度为2-20位字符串"
                },
                placename:{
                    required: "请选择出险地点"
                },
                deliveryaddress:{
                    required: "请选择配送地址"
                },
                streetaddress:{
                    required: "请输入街道地址"
                },
                account: {
                    required: "请输入银行卡号",
                    number: "银行卡号为数字类型",
                    minlength: "银行卡号长度不小于15位",
                    maxlength: "银行卡号长度不超过19位"
                },
                premium_refund:{
                    required: "金额不能为空",
                    number:"金额为数字类型"
                },
                /*account_number:{
                    required: "请输入银行卡号",
                    number: "银行卡号为数字类型",
                    minlength: "银行卡号长度不小于15位",
                    maxlength: "银行卡号长度不超过19位"
                },*/
                ococ:{
                    required: "请输入组织机构代码证"
                },
                residence:{
                    required: "请输入外国人永久居留证号"
                }

            },
            errorPlacement: function (error, element) { // render error placement for each input type
                //$(element).closest('.input-text').find(".help-block").text(error.text());
                //$(element).closest('.select-control').find(".help-block").text(error.text());
                //$(element).closest('.radio-box').find(".help-block").text(error.text());
                //$(element).closest('.check-box').find(".help-block").text(error.text());
                //$(element).closest('.preview-box').find(".help-block").text(error.text());
                $(element).parents('.form-group').find(".help-block").text(error.text());
            },

            invalidHandler: function (event, validator) { //display error alert on form submit
                // success.hide();
                error.show();
                myform.data("validate",false);
                console.log("error")
            },
            highlight: function (element) {
                $(element).closest('.form-group').removeClass("has-success").addClass('has-error');
                $(element).closest('.upload-box .preview-box').removeClass("has-success").addClass('has-error');

            },
            unhighlight: function (element) { // revert the change done by hightlight
                $(element).closest('.form-group').removeClass('has-error'); // set error class to the control group
            },
            success: function (label, element) {

                $(element).closest('.form-group').removeClass('has-error').addClass("has-success");
                $(element).closest('.upload-box .preview-box').removeClass('has-error').addClass("has-success");
                $(element).closest('.form-group').find("[type='text']").removeClass('has-error').addClass("has-success");
                $(element).closest('form-group').find("[type='text']").removeClass('has-error').css("border","1px solid transparent");

                var icon = $(element).closest('.wps-form-group').find(".help-block");

                icon.text("");
                if($(element).attr("id")=="mobile"){
                    $("#getcode").prop("disabled",false);
                }

            },
           /* submitHandler: function (form) {
                 success.show();
                 error.hide();
                 myform.data("validate",true);
                 if(!myform.data("ajax")){
                     form[0].submit(); // submit the form
                 }
            }*/

        })
    })

});

