package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/6/9.
 * 携程接收及返回结果类
 */
public class RtnResult {

    /**SUCCESS-接收数据成功，其他表示失败*/
    private String ret_code;

    /**失败时返回的错误信息*/
    private String ret_msg;

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

    public RtnResult(){

    }


    public RtnResult(String ret_code, String ret_msg) {
        this.ret_code = ret_code;
        this.ret_msg = ret_msg;
    }

    /**
     *  返回携程错误信息
     * @param error 错误提示信息
     * @return
     */
    public static RtnResult error(String ret_code, String error) {
        return new RtnResult(ret_code, error);
    }

    /**
     *  返回携程成功信息
     * @return
     */
    public static RtnResult success(String ret_code) {
        return new RtnResult(ret_code,"");
    }

    @Override
    public String toString() {
        return "RtnResult{" +
                "ret_code='" + ret_code + '\'' +
                ", ret_msg='" + ret_msg + '\'' +
                '}';
    }
}
