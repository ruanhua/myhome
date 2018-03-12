package cn.com.ulic.op.service;

import cn.com.ulic.op.domain.PayCase;
import cn.com.ulic.op.domain.PayReceiver;
import cn.com.ulic.op.domain.PaymentMain;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.RtnResult;
import cn.com.ulic.op.vo.UnifiedOrderRtn;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Created by ruanhua on 2017/6/12.
 */
public interface PaymentService {

    /**
     * 聚合支付-统一下单-组装数据
     * @return
     */
    public Map<String,String> getUnifiedOrderByPaymentMain(String paymentNo) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 保存支付调用接口信息
     * @param paymentMain
     */
    public void savePaymentMain(PaymentMain paymentMain);

    /**
     * 保存统一下单接口
     */
    public RtnResult saveUnifiedOrderRth(UnifiedOrderRtn unifiedOrderRtn) throws Exception;

    /**
     * 聚合支付-单笔代付-组装数据
     * @return
     */
    public Map<String, String> getSignlePayByBusinessNo(String businessNo, String trade_no);

    /**
     * 聚合支付-单笔代付查询-组装数据
     * @return
     */
    public Map<String,String> getQuerySignleByBusinessNo(String businessNo, String trade_no) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 聚合支付-批量代付-组装数据
     * @return
     */
    public Map<String,String> getBatchPayByPaymentMain(PaymentMain paymentMain) throws MyException;

    /**
     * 聚合支付-批量代付查询-组装数据
     * @return
     */
    public Map<String,String> getQueryBatch(PaymentMain paymentMain) throws MyException;

    /**
     * 调用批量代付查询接口
     * @param date
     */
    public void sendQueryBatch(String date);

    public String querySignlePay(String usiness_user_id, String tradeNo) throws Exception;

    public String savePaymentMainByJsonData(String jsonData) throws MyException;


    void callbackBusinessSystem();

    /**
     * 根据赔案信息生成支付信息
     * @param payCase
     * @param payReceiver
     * @return
     */
    PaymentMain getPaymentMainByPayCase(PayCase payCase, PayReceiver payReceiver);

}
