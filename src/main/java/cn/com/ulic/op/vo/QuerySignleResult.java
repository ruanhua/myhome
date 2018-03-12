package cn.com.ulic.op.vo;

import java.io.Serializable;

/**
 * Created by ruanhua on 2017/8/31.
 */
public class QuerySignleResult implements Serializable {

    private String tradeNo;

    private String fee;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
