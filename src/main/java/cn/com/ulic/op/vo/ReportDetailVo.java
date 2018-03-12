package cn.com.ulic.op.vo;

import java.math.BigDecimal;
import java.util.Date;

public class ReportDetailVo {
    public Integer id;
    public String policyNo;
    public String channel;
    public String status;
    public String claimStatus;
    public Long putTS;
    public Date reportTS;
    public Date endCaseTS;
    public String chulimsg;
    public String claimMsg;
    public String insuredName;
    public String sobilePhone;
    public String sendMsg;
    public String statusType;

    /**报案号码*/
    private String reportNo;

    /**险种代码*/
    private String riskCode;

    /**产品代码*/
    private String productCode;

    /**收款人*/
    private String payee;

    /**金额*/
    private BigDecimal amount;


    /**支付方式*/
    private String payfalg;

    /**银行类型*/
    private String bankCode;

    /**银行账号*/
    private String bankNo;

    private String isSave;
    /**审核状态
     *
     */

    private String auditingStatus;
    /**审核意见*/
    private String auditing;
    /**审核人*/
    private String auditingName;
    /**备注*/
    private String remarks;

    private String endDate;
    private String starDate;
    private String claimType;
    private String hotelReservation;
    private BigDecimal roomChange;
    private String claimAddress;

    private String isAperDocuments;

    private String channelIfCheckIn;

    private String occupation;

    private String relation;

    private String zeroClosingReason;
    //身份证号
    private String identityNumber;
    //报案人
    private String reportName;
    //报案人电话
    private String reportPhone;
    //酒店地址
    private  String hotelName;
    //出险描述
    private String claimdigest;

    public String getClaimdigest() {
        return claimdigest;
    }

    public void setClaimdigest(String claimdigest) {
        this.claimdigest = claimdigest;
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public BigDecimal getRoomChange() {
        return roomChange;
    }

    public void setRoomChange(BigDecimal roomChange) {
        this.roomChange = roomChange;
    }

    public String getHotelReservation() {
        return hotelReservation;
    }

    public void setHotelReservation(String hotelReservation) {
        this.hotelReservation = hotelReservation;
    }

    public String getClaimAddress() {
        return claimAddress;
    }

    public void setClaimAddress(String claimAddress) {
        this.claimAddress = claimAddress;
    }

    public String getIsAperDocuments() {
        return isAperDocuments;
    }

    public void setIsAperDocuments(String isAperDocuments) {
        this.isAperDocuments = isAperDocuments;
    }

    public String getChannelIfCheckIn() {
        return channelIfCheckIn;
    }

    public void setChannelIfCheckIn(String channelIfCheckIn) {
        this.channelIfCheckIn = channelIfCheckIn;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getZeroClosingReason() {
        return zeroClosingReason;
    }

    public void setZeroClosingReason(String zeroClosingReason) {
        this.zeroClosingReason = zeroClosingReason;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getAuditingStatus() {
        return auditingStatus;
    }

    public void setAuditingStatus(String auditingStatus) {
        this.auditingStatus = auditingStatus;
    }

    public String getAuditing() {
        return auditing;
    }

    public void setAuditing(String auditing) {
        this.auditing = auditing;
    }

    public String getAuditingName() {
        return auditingName;
    }

    public void setAuditingName(String auditingName) {
        this.auditingName = auditingName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getIsSave() {
        return isSave;
    }

    public void setIsSave(String isSave) {
        this.isSave = isSave;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPayfalg() {
        return payfalg;
    }

    public void setPayfalg(String payfalg) {
        this.payfalg = payfalg;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Long getPutTS() {
        return putTS;
    }

    public void setPutTS(Long putTS) {
        this.putTS = putTS;
    }

    public Date getReportTS() {
        return reportTS;
    }

    public void setReportTS(Date reportTS) {
        this.reportTS = reportTS;
    }


    public Date getEndCaseTS() {
        return endCaseTS;
    }

    public void setEndCaseTS(Date endCaseTS) {
        this.endCaseTS = endCaseTS;
    }

    public String getChulimsg() {
        return chulimsg;
    }

    public void setChulimsg(String chulimsg) {
        this.chulimsg = chulimsg;
    }

    public String getClaimMsg() {
        return claimMsg;
    }

    public void setClaimMsg(String claimMsg) {
        this.claimMsg = claimMsg;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getSobilePhone() {
        return sobilePhone;
    }

    public void setSobilePhone(String sobilePhone) {
        this.sobilePhone = sobilePhone;
    }

    public String getSendMsg() {
        return sendMsg;
    }

    public void setSendMsg(String sendMsg) {
        this.sendMsg = sendMsg;
    }


}