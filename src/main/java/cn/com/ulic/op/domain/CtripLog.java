package cn.com.ulic.op.domain;

import java.util.Date;

/**
 * Created by ruanhua on 2017/7/7.
 */
public class CtripLog {

    private Long id;

    /**环节*/
    private String nodeName;

    /**业务号*/
    private String businessNo;

    /**请求报文*/
    private String resquestData;

    /**返回报文*/
    private String responseData;

    /**是否异常*/
    private String isError;

    /**异常信息*/
    private String errorMsg;

    /**操作日期*/
    private Date operateTS;

    private Date createTS;

    /**备注*/
    private String remark;

    public Long getId() {
        return id;
    }
    public CtripLog() {

    }

    public CtripLog(String nodeName, String businessNo, String resquestData, String responseData, String isError, String errorMsg, Date operateTS, Date createTS, String remark) {
        this.nodeName = nodeName;
        this.businessNo = businessNo;
        this.resquestData = resquestData;
        this.responseData = responseData;
        this.isError = isError;
        this.errorMsg = errorMsg;
        this.operateTS = operateTS;
        this.createTS = createTS;
        this.remark = remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResquestData() {
        return resquestData;
    }

    public void setResquestData(String resquestData) {
        this.resquestData = resquestData;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public String getBusinessNo() {
        return businessNo;
    }

    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
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
}
