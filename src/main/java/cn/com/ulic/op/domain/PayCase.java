package cn.com.ulic.op.domain;

import java.util.Date;

/**
 * @author ruanhua
 * @date 2017/11/30
 */
public class PayCase {

    /**主键*/
    private String payCaseNo;

    /**保单号*/
    private String policyNo;

    /**险种代码*/
    private String riskCode;

    /**业务号*/
    private String businessNo;

    /**业务类型*/
    private String businessType;

    /**投保人名称*/
    private String holderName;

    /**产品号码*/
    private String productMetaNo;

    /**产品简称*/
    private String productMetaName;

    /**实付金额*/
    private String tradeAmount;

    /**支付状态*/
    private String payStatus;

    /**支付时间*/
    private Date payDate;

    /**渠道*/
    private String channel;

    /**回调地址*/
    private String paymentCallbackURL;

    /**回调状态*/
    private String sendCallBackStatus;

    private Date operateTS;

    private Date createTS;

    private String operator;


    public PayCase(String policyNo, String businessNo, String holderName, String productMetaNo, String productMetaName, String tradeAmount,String channel,String paymentCallbackURL) {
        this.policyNo = policyNo;
        this.businessNo = businessNo;
        this.holderName = holderName;
        this.productMetaNo = productMetaNo;
        this.productMetaName = productMetaName;
        this.tradeAmount = tradeAmount;
        this.channel = channel;
        this.paymentCallbackURL = paymentCallbackURL;
    }

    public PayCase() {
    }

    public String getPayCaseNo() {
        return payCaseNo;
    }

    public void setPayCaseNo(String payCaseNo) {
        this.payCaseNo = payCaseNo;
    }

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

    public String getProductMetaName() {
        return productMetaName;
    }

    public void setProductMetaName(String productMetaName) {
        this.productMetaName = productMetaName;
    }

    public String getTradeAmount() {
        return tradeAmount;
    }

    public void setTradeAmount(String tradeAmount) {
        this.tradeAmount = tradeAmount;
    }

    public Date getOperateTS() {
        return operateTS;
    }

    public void setOperateTS(Date operateTS) {
        this.operateTS = operateTS;
    }

    public Date getCreateTS() {
        return createTS;
    }

    public void setCreateTS(Date createTS) {
        this.createTS = createTS;
    }

    public String getProductMetaNo() {
        return productMetaNo;
    }

    public void setProductMetaNo(String productMetaNo) {
        this.productMetaNo = productMetaNo;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getPaymentCallbackURL() {
        return paymentCallbackURL;
    }

    public void setPaymentCallbackURL(String paymentCallbackURL) {
        this.paymentCallbackURL = paymentCallbackURL;
    }

    public String getSendCallBackStatus() {
        return sendCallBackStatus;
    }

    public void setSendCallBackStatus(String sendCallBackStatus) {
        this.sendCallBackStatus = sendCallBackStatus;
    }
}
