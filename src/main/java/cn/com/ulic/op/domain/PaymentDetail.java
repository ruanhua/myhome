package cn.com.ulic.op.domain;

import java.util.Date;

/**
 * Created by ruanhua on 2017/8/30.
 */
public class PaymentDetail {

    private Long id;

    private String payment_no;

    /**业务系统交易号*/
    private String business_order_no;

    /**业务系统用户ID*/
    private String business_user_id;

    /**收款人名称*/
    private String receiver_name;

    /**银行代码*/
    private String receiver_bank_code;

    /**赔付金额*/
    private String trade_amount;

    /**货币类型*/
    private String currency;

    /**业务系统收款人唯一ID*/
    private String receiver_id;

    /**收款人账号*/
    private String receiver_account;

    /**收款人账户类型*/
    private String receiver_account_type;

    /**交易日期*/
    private Date trate_date;

    /**会计日期*/
    private Date account_date;

    /**支付成功标志 WAITPAY-等待付款 SUCCESS-交易成功 FAIL-交易失败 CLOSE-交易关闭*/
    private String trade_status;

    /**操作时间*/
    private Date operateTS;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
    }

    public String getBusiness_user_id() {
        return business_user_id;
    }

    public void setBusiness_user_id(String business_user_id) {
        this.business_user_id = business_user_id;
    }

    public Date getTrate_date() {
        return trate_date;
    }

    public void setTrate_date(Date trate_date) {
        this.trate_date = trate_date;
    }

    public Date getAccount_date() {
        return account_date;
    }

    public void setAccount_date(Date account_date) {
        this.account_date = account_date;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public Date getOperateTS() {
        return operateTS;
    }

    public void setOperateTS(Date operateTS) {
        this.operateTS = operateTS;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_bank_code() {
        return receiver_bank_code;
    }

    public void setReceiver_bank_code(String receiver_bank_code) {
        this.receiver_bank_code = receiver_bank_code;
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

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }
}
