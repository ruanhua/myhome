package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/11/15.
 */
public class BigCompensate {
    private String bigPolicyNo;
    private String bigCompensateNo;
    private String sumPaid;
    private List<PayDetail> payDetailList;

    public String getBigPolicyNo() {
        return bigPolicyNo;
    }

    public void setBigPolicyNo(String bigPolicyNo) {
        this.bigPolicyNo = bigPolicyNo;
    }

    public String getBigCompensateNo() {
        return bigCompensateNo;
    }

    public void setBigCompensateNo(String bigCompensateNo) {
        this.bigCompensateNo = bigCompensateNo;
    }

    public String getSumPaid() {
        return sumPaid;
    }

    public void setSumPaid(String sumPaid) {
        this.sumPaid = sumPaid;
    }

    public List<PayDetail> getPayDetailList() {
        return payDetailList;
    }

    public void setPayDetailList(List<PayDetail> payDetailList) {
        this.payDetailList = payDetailList;
    }

}
