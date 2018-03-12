package cn.com.ulic.op.vo;

/**
 * Created by zhangzhihao on 2017/7/20.
 */
public class QueryCondition {
    private String startDate;
    private String endDate;

    public QueryCondition() {
        super();
    }

    public QueryCondition(String startDate, String endDate, String claimDataSources) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
