package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/29.
 */
public class UnifiedOrder {

    /**业务系统用户ID*/
    private String  business_user_id;

    /**随机字符串*/
    private String  salt;

    /**签名*/
    private String  signature;

    /**请求发起日期时间*/
    private String  req_time;

    /**租户ID*/
    private String  tenant_id;

    /**商品标题*/
    private String  trade_title;

    /**商品详情*/
    private String  trade_detail;

    /**附加数据*/
    private String  attach;

    /**业务订单号*/
    private String  business_order_no;

    /**交易金额*/
    private String  trade_amount;

    /**货币类型*/
    private String  currency;

    /**终端IP*/
    private String  req_ip;

    /**订单失效时间*/
    private String  expire_time;

    /**收款方*/
    private String  receiver_no;

    /**交易方式*/
    private String  trade_mode;

    /**客户端通知地址*/
    private String  client_notify_url;

    /**服务端通知地址*/
    private String  server_notify_url;

    /**支付类型*/
    private String  pay_type;

    /**优惠金额*/
    private String  discount_amount;

    /**手续费*/
    private String  poundage_amount;

    /**业务用户类型*/
    private String  user_type;

    /**业务类型*/
    private String  business_type;

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

    public String getTrade_title() {
        return trade_title;
    }

    public void setTrade_title(String trade_title) {
        this.trade_title = trade_title;
    }

    public String getTrade_detail() {
        return trade_detail;
    }

    public void setTrade_detail(String trade_detail) {
        this.trade_detail = trade_detail;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
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

    public String getReq_ip() {
        return req_ip;
    }

    public void setReq_ip(String req_ip) {
        this.req_ip = req_ip;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getReceiver_no() {
        return receiver_no;
    }

    public void setReceiver_no(String receiver_no) {
        this.receiver_no = receiver_no;
    }

    public String getTrade_mode() {
        return trade_mode;
    }

    public void setTrade_mode(String trade_mode) {
        this.trade_mode = trade_mode;
    }

    public String getClient_notify_url() {
        return client_notify_url;
    }

    public void setClient_notify_url(String client_notify_url) {
        this.client_notify_url = client_notify_url;
    }

    public String getServer_notify_url() {
        return server_notify_url;
    }

    public void setServer_notify_url(String server_notify_url) {
        this.server_notify_url = server_notify_url;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getPoundage_amount() {
        return poundage_amount;
    }

    public void setPoundage_amount(String poundage_amount) {
        this.poundage_amount = poundage_amount;
    }
}
