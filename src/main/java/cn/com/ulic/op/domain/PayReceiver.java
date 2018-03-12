package cn.com.ulic.op.domain;

import java.util.Date;

/**
 * Created by ruanhua on 2017/7/25.
 */
public class PayReceiver {

    /**收款人ID*/
    private Long id;

    private String payCaseNo;

    /**支付类型*/
    private String payType;

    /**支付类型名称*/
    private String payTypeName;

    /**所在省代码*/
    private String provinceCode;

    /**所在省名称*/
    private String provinceName;

    /**所在市代码*/
    private String cityCode;

    /**所在市名称*/
    private String cityName;

    /**手机*/
    private String mobile;

    /**银行代码*/
    private String bankCode;

    /**银行名称*/
    private String bankName;

    /**账户类型：0银行卡，1存折，2信用卡*/
    private String accountType;

    /**信用卡有效期YYYYMM*/
    private String validity;

    /**信用卡的CVV2码*/
    private String cvv2;

    /**银行卡或存折编号*/
    private String accountNo;

    /**银行卡或存折的所有人姓名*/
    private String accountName;

    /**0对私，1对公。不填默认对私0*/
    private String privateInd;

    /**0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件*/
    private String idType;

    /**证件号码*/
    private String idNum;

    /**备注信息*/
    private String remark;

    /**是否有效*/
    private String valid;

    private Date createTS;

    private Date operateTS;

    private String operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPrivateInd() {
        return privateInd;
    }

    public void setPrivateInd(String privateInd) {
        this.privateInd = privateInd;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public Date getCreateTS() {
        return createTS;
    }

    public void setCreateTS(Date createTS) {
        this.createTS = createTS;
    }

    public Date getOperateTS() {
        return operateTS;
    }

    public void setOperateTS(Date operateTS) {
        this.operateTS = operateTS;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPayCaseNo() {
        return payCaseNo;
    }

    public void setPayCaseNo(String payCaseNo) {
        this.payCaseNo = payCaseNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }


    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPayTypeName() {
        return payTypeName;
    }

    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }
}
