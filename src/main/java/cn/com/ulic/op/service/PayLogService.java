package cn.com.ulic.op.service;

/**
 * Created by RUANHUA on 2017/7/16.
 */
public interface PayLogService {

    public void saveCtripLog(String nodeName, String businessNo, String resquestData, String responseData, String errorMsg);
}
