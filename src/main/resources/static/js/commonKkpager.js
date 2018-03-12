/**
 * Created by ablert on 2017/10/16.
 */
$(function(){
    $('#dataPink,#endDataPink').datetimepicker({
        minView:"month",
        autoclose:true,
        language:"zh-CN",
        format:"yyyy-mm-dd"
    });

    $("#dataPink").on('change',function(){
        //13天的时间戳
        var stasNum=24*60*60*1000*13
        //开始时间
        var startTime=$("#dataPink").val();
        //结束时间
        var endTime=$("#endDataPink").val();
        //开始时间时间戳
        var stastartTime=Date.parse(startTime)
        //结束时间时间戳
        var staendTime=Date.parse(endTime)
        //开始时间戳和结束时间戳之间的差值
        var stasnum=staendTime-stastartTime

        if(stasnum>stasNum){

            alert("开始时间和结束时间的时间差不能大于14天");

            $("#dataPink").val('');

        }else if(staendTime<stastartTime){

            alert("开始不能大于结束时间");

            $("#dataPink").val('');
        }


    })

    $("#endDataPink").on('change',function(){
        //13天的时间戳
        var stasNum=24*60*60*1000*13
        //开始时间
        var startTime=$("#dataPink").val();
        //结束时间
        var endTime=$("#endDataPink").val();
        //开始时间时间戳
        var stastartTime=Date.parse(startTime)
        //结束时间时间戳
        var staendTime=Date.parse(endTime)
        //开始时间戳和结束时间戳之间的差值
        var stasnum=staendTime-stastartTime

        if(stasnum>stasNum){

            alert("结束时间和开始时间的时间差不能大于14天");

            $("#endDataPink").val('');

        }else if(staendTime<stastartTime){

            alert("结束时间不能小于开始时间");

            $("#endDataPink").val('');
        }


    })


})