package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/25.
 */
public class BatchPayRtn {

    /**信息码*/
    private String ret_code;

    /**信息码描述*/
    private String ret_msg;

    /**随机字符串*/
    private String salt;

    /**签名*/
    private String signature;

    /**返回结果*/
    private String result;

    /**请求发起日期时间*/
    private String req_time;

    /**批次号*/
    private String batch_no;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }
}
