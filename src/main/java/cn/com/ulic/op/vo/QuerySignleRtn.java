package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/30.
 */
public class QuerySignleRtn {

    /**信息码*/
    private String ret_code;

    /**信息码描述*/
    private String ret_msg;

    /**业务系统用户ID*/
    private String business_user_id;

    /**随机字符串*/
    private String salt;

    /**签名*/
    private String signature;

    /**返回结果*/
    private QuerySignleResult result;

    /**支付渠道*/
    private String pay_channel;

    /**交易金额*/
    private String trade_amount;

    /**货币类型*/
    private String currency;

    /**交易号*/
    private String trade_no;

    /**商户订单号*/
    private String business_order_no;

    /**会计日期*/
    private String account_date;

    /**交易状态*/
    private String trade_status;

    /**手续费*/
    private String fee;

    /**备注*/
    private String remark;

    /**用途*/
    private String purpose;

    /**错误信息*/
    private String error_msg;

    /**完成时间*/
    private String finish_time;

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }

    public String getRet_msg() {
        return ret_msg;
    }

    public void setRet_msg(String ret_msg) {
        this.ret_msg = ret_msg;
    }

    public String getBusiness_user_id() {
        return business_user_id;
    }

    public void setBusiness_user_id(String business_user_id) {
        this.business_user_id = business_user_id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
    }

    public String getAccount_date() {
        return account_date;
    }

    public void setAccount_date(String account_date) {
        this.account_date = account_date;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public QuerySignleResult getResult() {
        return result;
    }

    public void setResult(QuerySignleResult result) {
        this.result = result;
    }
}
