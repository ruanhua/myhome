$(function () {
    var thisPageHeading=$(".rightbox .heading").text();
    $(".nav_one").removeClass("arrow_bottom");
    // $(".nav-two").css("display","none");
    $(".leftText").parent(".main .nav-two li").removeClass("leftstyle");
    $.each($(".leftText"),function (inde,item) {
        var leftText=$(this).text();
        var _this=$(this);
        if(leftText==thisPageHeading){
            _this.parents(".nav-two").siblings(".nav_one").addClass("arrow_bottom");
            _this.parents(".nav-two").css("display","block");
            _this.parent(".main .nav-two li").addClass("leftstyle");
        }
    })
});