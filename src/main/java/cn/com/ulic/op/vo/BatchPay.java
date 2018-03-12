package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/8/25.
 */
public class BatchPay {

    /**随机字符串*/
    private String salt;

    /**签名*/
    private String signature;

    /**请求发起日期时间 yyyy-MM-dd HH:mm:ss*/
    private String req_time;

    /**业务代码*/
    private String fee_code;

    /**总条数*/
    private String total_items;

    /**总价格*/
    private String total_amount;

    /**批次号*/
    private String batch_no;

    /**支付通道*/
    private String pay_channel;

    /**租户ID*/
    private String tenant_id;

    /**订单失效时间*/
    private String expire_time;

    /**收款人详细信息*/
    private List<BatchTotalItem> detail;

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

    public String getTotal_items() {
        return total_items;
    }

    public void setTotal_items(String total_items) {
        this.total_items = total_items;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    public String getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(String expire_time) {
        this.expire_time = expire_time;
    }

    public String getFee_code() {
        return fee_code;
    }

    public void setFee_code(String fee_code) {
        this.fee_code = fee_code;
    }

    public List<BatchTotalItem> getDetail() {
        return detail;
    }

    public void setDetail(List<BatchTotalItem> detail) {
        this.detail = detail;
    }
}
