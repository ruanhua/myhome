package cn.com.ulic.op;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
public class EnvConfig {

    @Value("${op.sendPaymentURL}")
    private String sendPaymentURL;

    @Value("${op.payStatusURL}")
    private String payStatusURL;

    @Value("${union.paymentURL}")
    private String paymentURL;

    @Value("${timing.flag}")
    private String timingFlag;

    public String getPaymentURL() {
        return paymentURL;
    }

    public void setPaymentURL(String paymentURL) {
        this.paymentURL = paymentURL;
    }

    public String getTimingFlag() {
        return timingFlag;
    }

    public void setTimingFlag(String timingFlag) {
        this.timingFlag = timingFlag;
    }

    public String getSendPaymentURL() {
        return sendPaymentURL;
    }

    public void setSendPaymentURL(String sendPaymentURL) {
        this.sendPaymentURL = sendPaymentURL;
    }

    public String getPayStatusURL() {
        return payStatusURL;
    }

    public void setPayStatusURL(String payStatusURL) {
        this.payStatusURL = payStatusURL;
    }

}
