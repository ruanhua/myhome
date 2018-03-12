/**
 * Created by admin on 2016/10/24.
 */
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
      if($(this).val()=="01"){
       $("#banknumber,#bank").addClass("ignore");

        $(".bankmessage").hide();
      }else if($(this).val()=="02"){
         $(".bankmessage").show();
      }
    })
   
})










    $(document).ready(function(){
        dropdownOpen();
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



