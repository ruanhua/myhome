package cn.com.ulic.op.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ruanhua on 2017/5/15.
 */
public class ConstantUtil {

    /**成功**/
    public static final String SUCCESS_CODE = "1";

    /**失败**/
    public static final String ERROR_CODE = "0";

    /**是**/
    public static final String CTRIP_YES = "Y";

    /**否**/
    public static final String CTRIP_NO = "N";

    /**否**/
    public static final String CTRIP_DEFAULT = "0";

    public static final String MERCHANT_NO = "CTRIP";

    /**携程响应代码*/
    public static final class ResultCode{
        /**成功**/
        public static final String CTRIP_SUCCESS_CODE = "0";

        /**失败**/
        public static final String CTRIP_ERROR_CODE = "1";

        /**航班级别判赔失败**/
        public static final String FLIGHT_ERROR = "1001";

        /**乘机状态级别判赔失败*/
        public static final String TAKE_ERROR = "1002";

        /**已有赔案*/
        public static final String EXIST_ERROR = "1003";

        /**系统异常*/
        public static final String SYSTEM_ERROR = "1004";

        /**保单已退保*/
        public static final String SURRENDER_ERROR = "1005";

        /**需携程重试*/
        public static final String RETRY_ERROR = "2000";
    }

    /**请求类型*/
    public static final class RequestType{
        /**保单进核心*/
        public static final String SEND_BIG_POLICY = "PolicyToCore";

        /**退保进核心*/
        public static final String CANCEL_TO_CORE = "CancleToCore";

        /**支付进核心*/
        public static final String PAYMENT_TO_CORE = "P001";

        /**理赔进核心*/
        public static final String CLAIM_TO_CORE = "ClaimToCore";

        /**支付信息查询*/
        public static final String LOSS_TO_PAYMENT = "lossToPayment";
    }

    /**规则名称*/
    public static final class RuleName{

        /**理算*/
        public static final String COMPENSATE = "compensate";
    }

    /**出险状态*/
    public static final class ClaimType{
        /**延误**/
        public static final String DELAY = "d";

        /**返航*/
        public static final String RETURN = "r";

        /**备降*/
        public static final String FALL = "f";

        /**取消*/
        public static final String CANCEL = "c";

        /**退票*/
        public static final String REFUND = "Refund";

        /**改签*/
        public static final String REBOOK = "ReBook";
    }

    /**航班状态*/
    public static final class FlightStatus{
        /**备降*/
        public static final String FALL = "Fall";

        /**返航*/
        public static final String RETURNED = "Returned";

        /**取消*/
        public static final String CANCELED = "Canceled";

        /**落地*/
        public static  final String LANDED = "Landed";
    }


    /**携程退保状态*/
    public static final class ResultStatus{
        /**成功**/
        public static final String SUCCESS = "00";

        /**失败*/
        public static final String FAILURE = "81";

        /**异常*/
        public static final String ERROR = "80";
    }

    /**审核状态*/
    public static final class UnderWriteFlag{
        /**未审核**/
        public static final String WAIT = "0";

        /**审核中*/
        public static final String DOING = "2";

        /**审核通过*/
        public static final String DONE = "1";

        /**审核退回*/
        public static final String BACK = "3";

    }

    /**线上线下标志*/
    public static final class ClaimFlag{
        /**线下 -携程理赔*/
        public static final String OFFLINE = "offLine";

        /**Website-官网*/
        public static final String WEBSITE = "Website";

        /**微信*/
        public static final String WECHART = "Wechart";

    }

    /**理赔方式*/
    public static final class ClaimMode{
        /**携程推送*/
        public static final String CTRIP = "0";

        /**批量导入*/
        public static final String Batch = "1";

        /**异常件录入*/
        public static final String Unusual = "2";

    }

    /**案件状态*/
    public static final class CaseStatus{
        /**待处理*/
        public static final String WAIT = "0";

        /**处理成功*/
        public static final String SUCCESS = "1";

        /**处理失败*/
        public static final String FAIL = "2";

    }

    public static ConcurrentHashMap<String, String> FlightStatusMap = new ConcurrentHashMap<String, String>();

    static {
        FlightStatusMap.put("Fall", "备降");
        FlightStatusMap.put("Returned", "返航");
        FlightStatusMap.put("Canceled", "取消");
        FlightStatusMap.put("Landed", "落地");
    };

    public static ConcurrentHashMap<String, String> ClaimTypeMap = new ConcurrentHashMap<String, String>();

    static {
        ClaimTypeMap.put("Fall", "f");
        ClaimTypeMap.put("Returned", "r");
        ClaimTypeMap.put("Canceled", "c");
        ClaimTypeMap.put("Landed", "d");
    };

    /**渠道*/
    public static final class Channel{

        /**携程航延*/
        public static final String CTRIP_FLY = "ctrip_fly";

        /**携程酒店取消*/
        public static final String CTRIP_HOTEL = "ctrip_hotel";

        /**艺龙酒店取消*/
        public static final String YILONG_HOTEL = "yilong_hotel";

    }

    /**案件所处阶段节点*/
    public static final class NodeID{

        /**报案处理*/
        public static final String REPORT = "0";

        /**审核*/
        public static final String VERIFY = "1";

        /**支付*/
        public static final String PAYMENT = "2";

    }

    /**支付方式*/
    public static final class Pay_channel{
        public static final String WX = "WX";//微信
        public static final String ZFB = "ZFB";//支付宝
        public static final String HZZF = "HZZF";//合众支付
        public static final String TLZF = "TLZF";//通联支付
        public static final String JLWJ = "JLWJ";//金联万家
    }

    /**业务代码*/
    public static final class Business_code{
        public static final String CLAIM  = "1";//理赔
        public static final String DIVIDEND = "2";//分红
        public static final String REIMBURSE = "3";//退款
        public static final String OTHER = "4";//其他
    }

    /**收款人账号类型*/
    public static final class Receiver_account_type{
        public static final String DEBIT  = "00";//借记卡
        public static final String CREDIT = "CREDIT";//信用卡
        public static final String PASSBOOK = "PASSBOOK";//存折
        public static final String UNION = "UNION";//合众易宝
    }

    /**业务代码*/
    public static final class Fee_code{
        public static final String HZZF  = "04900";//合众支付
        public static final String JLWJ = "00600";//通联万家
    }


    /**支付方式*/
    public static final class Pay_type{
        public static final String SIGNLE  = "signle";//单笔
        public static final String BATCH = "batch";//批量
    }

    /**支付接口状态码*/
    public static final class PayDetailRetCode{
        public static final String SUCCESS  = "GWP00000";//调用成功
        public static final String SYSTEM_ERROR = "GWP99999";//系统错误
        public static final String BUILD_ERROR = "GWP99984";//组织报文内容错误
        public static final String PARSE_ERROR = "GWP99983";//解析报文错误
    }
}
