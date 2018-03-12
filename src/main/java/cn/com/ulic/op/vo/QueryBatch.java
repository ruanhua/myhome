package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/8/30.
 */
public class QueryBatch {

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

    /**批次号*/
    private String batch_no;

    private List<QueryBatchDetail> detail;

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

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public List<QueryBatchDetail> getDetail() {
        return detail;
    }

    public void setDetail(List<QueryBatchDetail> detail) {
        this.detail = detail;
    }
}
