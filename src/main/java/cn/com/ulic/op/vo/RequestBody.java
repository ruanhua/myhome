package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/11/8.
 */
public class RequestBody {

    private String salt;

    private String req_ip;

    private String req_time;

    private List<String> bigCompensateNoList;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getReq_ip() {
        return req_ip;
    }

    public void setReq_ip(String req_ip) {
        this.req_ip = req_ip;
    }

    public String getReq_time() {
        return req_time;
    }

    public void setReq_time(String req_time) {
        this.req_time = req_time;
    }

    public List<String> getBigCompensateNoList() {
        return bigCompensateNoList;
    }

    public void setBigCompensateNoList(List<String> bigCompensateNoList) {
        this.bigCompensateNoList = bigCompensateNoList;
    }
}
