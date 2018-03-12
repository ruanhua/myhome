package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/25.
 */
public class BatchTotalItem {

    /**业务系统用户ID*/
    private String business_user_id;

    /**业务系统订单号*/
    private String business_order_no;

    /**收款人通道账号*/
    private String receiver_channel_account;

    /**收款人开户行所在省*/
    private String receiver_bank_province;

    /**收款人开户行所在市*/
    private String receiver_bank_city;

    /**付款人账号*/
    private String payer_account;

    /**付款人名称*/
    private String payer_name;

    /**收款人账号*/
    private String receiver_account;

    /**收款人账号类型*/
    private String receiver_account_type;

    /**收款人账号属性*/
    private String receiver_account_prop;

    /**收款人名称*/
    private String receiver_name;

    /**收款行行号*/
    private String receiver_bank_no;

    /**收款行代码*/
    private String receiver_bank_code;

    /**收款行名称*/
    private String receiver_bank_name;

    /**收款行简称*/
    private String receiver_bank_short_name;

    /**金额 单位为元*/
    private String trade_amount;

    /**货币类型*/
    private String currency;

    public String getBusiness_user_id() {
        return business_user_id;
    }

    public void setBusiness_user_id(String business_user_id) {
        this.business_user_id = business_user_id;
    }

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
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

    public String getReceiver_account() {
        return receiver_account;
    }

    public void setReceiver_account(String receiver_account) {
        this.receiver_account = receiver_account;
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

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
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
}
