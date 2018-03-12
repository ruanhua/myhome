package cn.com.ulic.op.vo;

import java.util.List;

/**
 * Created by ruanhua on 2017/11/8.
 */
public class PayStatus {

    private String business_order_no;

    private String trade_date;

    private String batch_no;

    private String ret_code;

    private List<PayStatusDetail> payStatusDetailList;

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public List<PayStatusDetail> getPayStatusDetailList() {
        return payStatusDetailList;
    }

    public void setPayStatusDetailList(List<PayStatusDetail> payStatusDetailList) {
        this.payStatusDetailList = payStatusDetailList;
    }

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
    }

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getRet_code() {
        return ret_code;
    }

    public void setRet_code(String ret_code) {
        this.ret_code = ret_code;
    }
}
