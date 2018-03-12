package cn.com.ulic.op.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by ruanhua on 2017/8/30.
 */
public class QueryBatchRth {

    private String ret_code;
    private String ret_msg;
    private String business_user_id;
    private String salt;
    private String signature;
    private List<Map<String,String>> result;
    private String batch_no;

    private List<QueryBatchRthDetail> details;

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

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public List<QueryBatchRthDetail> getDetails() {
        return details;
    }

    public void setDetails(List<QueryBatchRthDetail> details) {
        this.details = details;
    }

    public List<Map<String, String>> getResult() {
        return result;
    }

    public void setResult(List<Map<String, String>> result) {
        this.result = result;
    }
}
