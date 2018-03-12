package cn.com.ulic.op.vo;

/**
 * @author ruanhua
 * @date 2017/12/4
 */
public class Surrender {

    private String endorNo;

    private String channel;

    private String productName;

    private String productCode;

    private String policyNo;

    private String amount;

    private String holderName;

    private String paymentCallbackURL;

    public String getEndorNo() {
        return endorNo;
    }

    public void setEndorNo(String endorNo) {
        this.endorNo = endorNo;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getPaymentCallbackURL() {
        return paymentCallbackURL;
    }

    public void setPaymentCallbackURL(String paymentCallbackURL) {
        this.paymentCallbackURL = paymentCallbackURL;
    }

    @Override
    public String toString() {
        return "Surrender{" +
                "endorNo='" + endorNo + '\'' +
                ", channel='" + channel + '\'' +
                ", productName='" + productName + '\'' +
                ", productCode='" + productCode + '\'' +
                ", policyNo='" + policyNo + '\'' +
                ", amount='" + amount + '\'' +
                ", holderName='" + holderName + '\'' +
                '}';
    }
}
