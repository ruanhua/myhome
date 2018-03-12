package cn.com.ulic.op.domain;

/**
 * Created by ruanhua on 2017/9/7.
 */
public class Config {

    /**配置项代码*/
    private String configCode;

    /**配置项名称*/
    private String configValue;

    /**配置项说明*/
    private String configDesc;

    /**产品代码*/
    private String productCode;

    /**操作时间*/
    private String operateTS;

    /**用途：配置表*/
    private String validFlag;

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getConfigDesc() {
        return configDesc;
    }

    public void setConfigDesc(String configDesc) {
        this.configDesc = configDesc;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getOperateTS() {
        return operateTS;
    }

    public void setOperateTS(String operateTS) {
        this.operateTS = operateTS;
    }

    public String getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(String validFlag) {
        this.validFlag = validFlag;
    }

    public String getConfigCode() {
        return configCode;
    }

    public void setConfigCode(String configCode) {
        this.configCode = configCode;
    }
}
