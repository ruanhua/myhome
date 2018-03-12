package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/7/20.
 */
public class PayQueryCondition extends QueryCondition {

    /**业务类型*/
    private String businessType;

    /**业务号*/
    private String businessNo;

    /**渠道*/
    private String channel;

    /**保单号*/
    private String policyNo;

    /**支付状态*/
    private String payStatus;

    /**页面*/
    private String pageNo;

    public PayQueryCondition() {
        super();
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
