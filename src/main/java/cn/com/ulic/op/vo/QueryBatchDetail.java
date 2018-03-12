package cn.com.ulic.op.vo;

/**
 * Created by ruanhua on 2017/8/30.
 */
public class QueryBatchDetail {

    /**交易号*/
    private String business_order_no;

    /**交易号*/
    private String trade_date;

    public String getBusiness_order_no() {
        return business_order_no;
    }

    public void setBusiness_order_no(String business_order_no) {
        this.business_order_no = business_order_no;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }
}
