package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/11/15.
 */
public class ResponseBody {

    private String retCode;
    private String retMsg;
    private List<BigCompensate> bigCompensateList;

    public List<BigCompensate> getBigCompensateList() {
        return bigCompensateList;
    }

    public void setBigCompensateList(List<BigCompensate> bigCompensateList) {
        this.bigCompensateList = bigCompensateList;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}
