package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/25.
 */
public class SignlePay {

    /**业务系统用户ID*/
    private String business_user_id;

    /**随机字符串*/
    private String salt;

    /**签名*/
    private String signature;

    /**请求发起日期时间*/
    private String req_time;

    /**租户ID*/
    private String tenant_id;

    /**交易号*/
    private String trade_no;

    /**支付通道*/
    private String pay_channel;

    /**业务代码*/
    private String business_code;

    /**收款人通道账号*/
    private String receiver_channel_account;

    /**收款人开户行所在省*/
    private String receiver_bank_province;

    /**收款人开户行所在市*/
    private String receiver_bank_city;

    /**收款人账号*/
    private String receiver_account;

    /**收款人名称*/
    private String receiver_name;

    private String trade_amount;

    /**付款人账号*/
    private String payer_account;

    /**付款人名称*/
    private String payer_name;

    /**收款人账号类型*/
    private String receiver_account_type;

    /**收款人账号属性*/
    private String receiver_account_prop;

    /**收款行行号*/
    private String receiver_bank_no;

    /**收款行代码*/
    private String receiver_bank_code;

    /**收款行名称*/
    private String receiver_bank_name;

    /**收款行简称*/
    private String receiver_bank_short_name;

    /**收款人证件类型*/
    private String receiver_cert_type;

    /**收款人证件号*/
    private String receiver_cert_no;

    /**收款人手机号*/
    private String receiver_phone;

    /**备注*/
    private String remark;

    /**用途*/
    private String purpose;

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

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getBusiness_code() {
        return business_code;
    }

    public void setBusiness_code(String business_code) {
        this.business_code = business_code;
    }

    public String getReceiver_channel_account() {
        return receiver_channel_account;
    }

    public void setReceiver_channel_account(String receiver_channel_account) {
        this.receiver_channel_account = receiver_channel_account;
    }

    public String getReceiver_bank_province() {
        return receiver_bank_province;
    }

    public void setReceiver_bank_province(String receiver_bank_province) {
        this.receiver_bank_province = receiver_bank_province;
    }

    public String getReceiver_bank_city() {
        return receiver_bank_city;
    }

    public void setReceiver_bank_city(String receiver_bank_city) {
        this.receiver_bank_city = receiver_bank_city;
    }

    public String getReceiver_account() {
        return receiver_account;
    }

    public void setReceiver_account(String receiver_account) {
        this.receiver_account = receiver_account;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getPayer_account() {
        return payer_account;
    }

    public void setPayer_account(String payer_account) {
        this.payer_account = payer_account;
    }

    public String getPayer_name() {
        return payer_name;
    }

    public void setPayer_name(String payer_name) {
        this.payer_name = payer_name;
    }

    public String getReceiver_account_type() {
        return receiver_account_type;
    }

    public void setReceiver_account_type(String receiver_account_type) {
        this.receiver_account_type = receiver_account_type;
    }

    public String getReceiver_account_prop() {
        return receiver_account_prop;
    }

    public void setReceiver_account_prop(String receiver_account_prop) {
        this.receiver_account_prop = receiver_account_prop;
    }

    public String getReceiver_bank_no() {
        return receiver_bank_no;
    }

    public void setReceiver_bank_no(String receiver_bank_no) {
        this.receiver_bank_no = receiver_bank_no;
    }

    public String getReceiver_bank_code() {
        return receiver_bank_code;
    }

    public void setReceiver_bank_code(String receiver_bank_code) {
        this.receiver_bank_code = receiver_bank_code;
    }

    public String getReceiver_bank_name() {
        return receiver_bank_name;
    }

    public void setReceiver_bank_name(String receiver_bank_name) {
        this.receiver_bank_name = receiver_bank_name;
    }

    public String getReceiver_bank_short_name() {
        return receiver_bank_short_name;
    }

    public void setReceiver_bank_short_name(String receiver_bank_short_name) {
        this.receiver_bank_short_name = receiver_bank_short_name;
    }

    public String getReceiver_cert_type() {
        return receiver_cert_type;
    }

    public void setReceiver_cert_type(String receiver_cert_type) {
        this.receiver_cert_type = receiver_cert_type;
    }

    public String getReceiver_cert_no() {
        return receiver_cert_no;
    }

    public void setReceiver_cert_no(String receiver_cert_no) {
        this.receiver_cert_no = receiver_cert_no;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
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

    public String getTrade_amount() {
        return trade_amount;
    }

    public void setTrade_amount(String trade_amount) {
        this.trade_amount = trade_amount;
    }
}
