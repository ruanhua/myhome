package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/25.
 */
public class SignlePayRtn {

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
    private String result;

    /**交易号*/
    private String trade_no;

    /**手续费*/
    private String fee;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
