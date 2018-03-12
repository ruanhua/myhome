package cn.com.ulic.op.vo;

import java.util.Date;

/**
 * Created by ruanhua on 2017/7/20.
 */
public class PayQueryResult {

    /**赔案号*/
    private String payCaseNo;

    /**保单号*/
    private String policyNo;

    /**业务号*/
    private String businessNo;

    /**投保人*/
    private String holderName;

    /**产品简称*/
    private String productMetaName;

    /**支付状态*/
    private String payStatus;

    /**赔款支付时间*/
    private String payDate;

    /**控制页面显示效果*/
    private String operateStyle;

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getPayCaseNo() {
        return payCaseNo;
    }

    public void setPayCaseNo(String payCaseNo) {
        this.payCaseNo = payCaseNo;
    }

    public String getOperateStyle() {
        return operateStyle;
    }

    public void setOperateStyle(String operateStyle) {
        this.operateStyle = operateStyle;
    }

    public String getProductMetaName() {
        return productMetaName;
    }

    public void setProductMetaName(String productMetaName) {
        this.productMetaName = productMetaName;
    }
}
