package cn.com.ulic.op.domain;

import java.util.Date;
import java.util.List;

/**
 * Created by ruanhua on 2017/9/7.
 */
public class PaymentMain {

    /**主键*/
    private String payment_no;

    /**single-单笔  batch-批量*/
    private String payment_type;

    /**支付类型*/
    private String pay_type;

    /**商品标题*/
    private String trade_title;

    /**商品详情*/
    private String trade_detail;

    /**总金额*/
    private String trade_amount;

    /**总条数*/
    private String total_items;

    /**支付通道*/
    private String pay_channel;

    /**业务代码*/
    private String fee_code;

    /**业务系统用户ID*/
    private String business_user_id;

    /**业务订单号*/
    private String business_order_no;

    /**批次号*/
    private String batch_no;

    /**交易号*/
    private String trade_no;

    /**交易日期*/
    private Date trate_date;

    /**交易方式*/
    private String trade_mode;

    /**调用代付接口 0初始值  Y-调用成功  N-调用失败*/
    private String send_pay_flag;

    /**调用代付查询接口标志 0初始值  Y-调用成功  N-调用失败*/
    private String send_query_flag;

    /**回调业务系统标志位 0初始值  Y-调用成功  N-调用失败*/
    private String send_business_system_flag;

    /**支付成功标志 WAITPAY-等待付款 SUCCESS-交易成功 FAIL-交易失败 CLOSE-交易关闭*/
    private String trade_status;

    /**终端IP*/
    private String req_ip;

    /**服务端通知地址*/
    private String server_notify_url;

    /**货币类型*/
    private String currency;

    /**请求时间*/
    private String req_time;

    /**操作时间*/
    private Date operateTS;

    private Date createTS;

    private List<PaymentDetail> paymentDetailList;

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public String getBusiness_user_id() {
        return business_user_id;
    }

    public void setBusiness_user_id(String business_user_id) {
        this.business_user_id = business_user_id;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public Date getTrate_date() {
        return trate_date;
    }

    public void setTrate_date(Date trate_date) {
        this.trate_date = trate_date;
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

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getSend_pay_flag() {
        return send_pay_flag;
    }

    public void setSend_pay_flag(String send_pay_flag) {
        this.send_pay_flag = send_pay_flag;
    }

    public String getSend_query_flag() {
        return send_query_flag;
    }

    public void setSend_query_flag(String send_query_flag) {
        this.send_query_flag = send_query_flag;
    }

    public String getPayment_no() {
        return payment_no;
    }

    public void setPayment_no(String payment_no) {
        this.payment_no = payment_no;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getFee_code() {
        return fee_code;
    }

    public void setFee_code(String fee_code) {
        this.fee_code = fee_code;
    }

    public String getReq_ip() {
        return req_ip;
    }

    public void setReq_ip(String req_ip) {
        this.req_ip = req_ip;
    }

    public String getServer_notify_url() {
        return server_notify_url;
    }

    public void setServer_notify_url(String server_notify_url) {
        this.server_notify_url = server_notify_url;
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

    public String getTotal_items() {
        return total_items;
    }

    public void setTotal_items(String total_items) {
        this.total_items = total_items;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public Date getCreateTS() {
        return createTS;
    }

    public void setCreateTS(Date createTS) {
        this.createTS = createTS;
    }

    public String getTrade_mode() {
        return trade_mode;
    }

    public void setTrade_mode(String trade_mode) {
        this.trade_mode = trade_mode;
    }

    public List<PaymentDetail> getPaymentDetailList() {
        return paymentDetailList;
    }

    public void setPaymentDetailList(List<PaymentDetail> paymentDetailList) {
        this.paymentDetailList = paymentDetailList;
    }

    public String getSend_business_system_flag() {
        return send_business_system_flag;
    }

    public void setSend_business_system_flag(String send_business_system_flag) {
        this.send_business_system_flag = send_business_system_flag;
    }
}
