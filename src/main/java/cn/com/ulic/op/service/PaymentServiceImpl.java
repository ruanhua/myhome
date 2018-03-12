package cn.com.ulic.op.service;


import cn.com.ulic.op.EnvConfig;
import cn.com.ulic.op.dao.PaymentDetailMapper;
import cn.com.ulic.op.domain.PayCase;
import cn.com.ulic.op.domain.PayReceiver;
import cn.com.ulic.op.domain.PaymentDetail;
import cn.com.ulic.op.domain.PaymentMain;
import cn.com.ulic.op.http.HttpAPIService;
import cn.com.ulic.op.http.HttpResult;
import cn.com.ulic.op.util.*;
import cn.com.ulic.op.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.beanutils.BeanMap;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by ruanhua on 2017/6/12.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaymentDetailMapper paymentDetailMapper;

    @Autowired
    private CommonService commonService;

    @Autowired
    private HttpAPIService httpAPIService;

    @Autowired
    private EnvConfig envConfig;

    @Autowired
    private PayLogService payLogService;

    /**
     * 聚合支付-单笔代付-组装数据
     * @return
     */
    @Override
    public Map<String, String> getSignlePayByBusinessNo(String businessNo,String trade_no){
        Map<String, String> resultMap = new HashMap<>(0);
        return resultMap;
    }

    /**
     * 聚合支付-批量代付-组装数据
     * @return
     */
    @Override
    public Map<String,String> getBatchPayByPaymentMain(PaymentMain paymentMain) throws MyException {
        BatchPay batchPay = new BatchPay();
        String salt =  UUID.randomUUID().toString().replace("-", "");//32位随机字符串
        batchPay.setSalt(salt);
        batchPay.setReq_time(DateUtil.dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));//请求发起日期时间
        batchPay.setTenant_id("10000");//租户ID
        batchPay.setPay_channel(paymentMain.getPay_channel());//支付方式
        batchPay.setBatch_no(paymentMain.getBatch_no());
        batchPay.setFee_code("00600");
        List<BatchTotalItem> batchTotalItemList = new ArrayList<>(0);
        List<PaymentDetail> paymentDetailList = paymentDetailMapper.getPaymentDetailByPaymentNo(paymentMain.getPayment_no());
        for(PaymentDetail paymentDetail : paymentDetailList){
            BatchTotalItem batchTotalItem = new BatchTotalItem();
            batchTotalItem.setReceiver_account(paymentDetail.getReceiver_account());
            batchTotalItem.setReceiver_bank_code(paymentDetail.getReceiver_bank_code());
            batchTotalItem.setReceiver_name(paymentDetail.getReceiver_name());
            batchTotalItem.setBusiness_order_no(paymentDetail.getBusiness_user_id());
            batchTotalItem.setBusiness_user_id(paymentDetail.getBusiness_order_no());
            batchTotalItem.setReceiver_account_prop("0");
            batchTotalItem.setTrade_amount(paymentDetail.getTrade_amount());
            batchTotalItem.setCurrency("CNY");
            //通联生产系统有问题，账户类型暂时写死00
            batchTotalItem.setReceiver_account_type(ConstantUtil.Receiver_account_type.DEBIT);
            batchTotalItemList.add(batchTotalItem);
        }
        batchPay.setTotal_items(String.valueOf(batchTotalItemList.size()));
        batchPay.setTotal_amount(paymentMain.getTrade_amount());
        batchPay.setDetail(batchTotalItemList);
        Map<String, String> resultMap = null;
        resultMap = JSON.parseObject(JSON.toJSONString(batchPay), new TypeReference<Map<String, String>>(){});
        resultMap = DataUtil.signData(resultMap, "hejinonline");
        return resultMap;
    }


    /**
     * 聚合支付-统一下单-组装数据
     * @return
     */
    @Override
    public Map<String,String> getUnifiedOrderByPaymentMain(String paymentNo) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        PaymentMain paymentMain = paymentDetailMapper.getPaymentMain(paymentNo);
        UnifiedOrder unifiedOrder = new UnifiedOrder();
        String salt =  UUID.randomUUID().toString().replace("-", "");//32位随机字符串
        unifiedOrder.setSalt(salt);
        unifiedOrder.setBusiness_user_id(paymentMain.getBusiness_order_no());
        unifiedOrder.setReq_time(DateUtil.dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));//请求发起日期时间
        unifiedOrder.setTenant_id("10000");//租户ID
        unifiedOrder.setReceiver_no("10003");//写死，支付平台定的
        unifiedOrder.setTrade_title(paymentMain.getTrade_title());
        unifiedOrder.setTrade_detail(paymentMain.getTrade_detail());
        unifiedOrder.setBusiness_order_no(paymentMain.getBusiness_order_no());
        unifiedOrder.setTrade_amount(paymentMain.getTrade_amount());
        unifiedOrder.setCurrency("CNY");
        unifiedOrder.setReq_ip(paymentMain.getReq_ip());
        unifiedOrder.setTrade_mode(paymentMain.getTrade_mode());
        unifiedOrder.setServer_notify_url("CLAIM");//回调地址代付不需要，默认为CLAIM
        unifiedOrder.setPay_type(paymentMain.getPay_type());
        unifiedOrder.setUser_type("1");//默认为1
        unifiedOrder.setBusiness_type("1");//默认为1
        unifiedOrder.setAttach("upic_claim");
        Map beanMap = new BeanMap(unifiedOrder);
        Map<String, String> resultMap = DataUtil.signData(beanMap, "hejinonline");
        return resultMap;
    }

    @Override
    public void savePaymentMain(PaymentMain paymentMain){
        paymentDetailMapper.insert(paymentMain);
    }

    @Override
    public RtnResult saveUnifiedOrderRth(UnifiedOrderRtn unifiedOrderRtn) throws Exception {
        String ret_code = "";
        String reqStr = "";
        String resStr = "";
        String errorMsg = "";
        RtnResult rtnResult;
        PaymentMain paymentMain = paymentDetailMapper.getPaymentMain(unifiedOrderRtn.getPayment_no());
        try{
            if(!ConstantUtil.PayDetailRetCode.SUCCESS.equals(unifiedOrderRtn.getRet_code())){
                throw new MyException("调用统一下单接口出错，请联系管理员");
            }
            paymentMain.setTrade_no(unifiedOrderRtn.getTrade_no());
            if(ConstantUtil.Pay_type.SIGNLE.equals(paymentMain.getPayment_type())){
                Map<String, String> resultMap = this.getSignlePayByBusinessNo(paymentMain.getBusiness_user_id(), paymentMain.getTrade_no());
                reqStr = JSON.toJSONString(resultMap);
                HttpResult result = httpAPIService.doPostString(envConfig.getPaymentURL() + "signlePay", reqStr, ContentType.APPLICATION_JSON.getMimeType());
                resStr = result.getBody();
                SignlePayRtn signlePayRtn = JSON.parseObject(resStr, SignlePayRtn.class);
                if(ConstantUtil.PayDetailRetCode.SUCCESS.equals(signlePayRtn.getRet_code())){
                    paymentMain.setSend_pay_flag(ConstantUtil.CTRIP_YES);
                }else{
                    paymentMain.setSend_pay_flag(ConstantUtil.CTRIP_NO);
                }
                paymentMain.setTrate_date(new Date());
                paymentMain.setSend_query_flag(ConstantUtil.CTRIP_DEFAULT);
                paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_DEFAULT);
                paymentMain.setOperateTS(new Date());
                paymentDetailMapper.update(paymentMain,paymentMain.getPayment_no());
            }else if(ConstantUtil.Pay_type.BATCH.equals(paymentMain.getPayment_type())){
                Map<String, String> resultMap = this.getBatchPayByPaymentMain(paymentMain);
                reqStr = JSON.toJSONString(resultMap);
                HttpResult result = httpAPIService.doPostString(envConfig.getPaymentURL() + "batchPay", reqStr, ContentType.APPLICATION_JSON.getMimeType());
                if(HttpStatus.SC_OK == result.getCode().intValue()){
                    resStr= result.getBody();
                    BatchPayRtn batchPayRtn = JSON.parseObject(resStr, BatchPayRtn.class);
                    if(ConstantUtil.PayDetailRetCode.SUCCESS.equals(batchPayRtn.getRet_code())){
                        paymentMain.setSend_pay_flag(ConstantUtil.CTRIP_YES);
                    }else{
                        paymentMain.setSend_pay_flag(ConstantUtil.CTRIP_NO);
                    }
                    String req_time = JSONObject.parseObject(resStr).getJSONObject("result").getString("req_time");
                    String batch_no = JSONObject.parseObject(resStr).getJSONObject("result").getString("batch_no");
                    paymentMain.setTrate_date(DateUtil.parseDate(req_time));
                    paymentMain.setSend_query_flag(ConstantUtil.CTRIP_DEFAULT);
                    paymentMain.setOperateTS(new Date());
                    paymentMain.setBatch_no(batch_no);
                    paymentMain.setPayment_type(ConstantUtil.Pay_type.BATCH);
                    paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_DEFAULT);
                    paymentDetailMapper.update(paymentMain,paymentMain.getPayment_no());
                    List<PaymentDetail> paymentDetailList = paymentDetailMapper.getPaymentDetailByPaymentNo(paymentMain.getPayment_no());
                    for(PaymentDetail paymentDetail : paymentDetailList){
                        paymentDetail.setTrate_date(DateUtil.parseDate(req_time));
                        paymentDetail.setOperateTS(new Date());
                        paymentDetailMapper.updatePaymentDetail(paymentDetail,paymentDetail.getId());
                    }
                }else{
                    throw new MyException(result.getBody());
                }
            }
            rtnResult = RtnResult.success(ConstantUtil.PayDetailRetCode.SUCCESS);
        }catch (Exception e){
            errorMsg = e.getLocalizedMessage();
            logger.error(errorMsg);
            rtnResult = RtnResult.error(ConstantUtil.PayDetailRetCode.SYSTEM_ERROR,errorMsg);
        }finally {
            payLogService.saveCtripLog("batchPay",paymentMain.getPayment_no(),reqStr,resStr,errorMsg);
        }
        return rtnResult;
    }

    @Override
    public Map<String,String> getQuerySignleByBusinessNo(String businessNo, String trade_no) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        QuerySignle querySignle = new QuerySignle();
        String salt =  UUID.randomUUID().toString().replace("-", "");//32位随机字符串
        querySignle.setSalt(salt);
        querySignle.setBusiness_user_id(businessNo);
        querySignle.setReq_time(DateUtil.dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));//请求发起日期时间
        querySignle.setTrade_date(DateUtil.dateFormat(new Date(),"yyyy-MM-dd"));//交易日期
        querySignle.setTenant_id("10000");//租户ID    ``
        querySignle.setTrade_no(trade_no);
        querySignle.setOp_type("1");
        Map beanMap = new BeanMap(querySignle);
        Map<String, String> resultMap = DataUtil.signData(beanMap, "hejinonline");
        return resultMap;
    }

    public String querySignlePay(String businessNo, String trade_no) throws Exception {
        Map<String, String> resultMap = this.getQuerySignleByBusinessNo(businessNo,trade_no);
        String jsonString = JSON.toJSONString(resultMap);
        HttpResult result = httpAPIService.doPostString(envConfig.getPaymentURL() +"querySignleOrder", jsonString, ContentType.APPLICATION_JSON.getMimeType());
        String rthBody = result.getBody();
        QuerySignleRtn querySignleRtn = JSON.parseObject(rthBody, QuerySignleRtn.class);
        return querySignleRtn.getTrade_status();
    }
    @Override
    public Map<String,String> getQueryBatch(PaymentMain paymentMain ) throws MyException {
        List<QueryBatchDetail> detailList = new ArrayList<>();
        QueryBatch queryBatch = new QueryBatch();
        queryBatch.setBusiness_user_id(paymentMain.getBusiness_user_id());
        String salt =  UUID.randomUUID().toString().replace("-", "");//32位随机字符串
        queryBatch.setSalt(salt);
        queryBatch.setBatch_no(paymentMain.getBatch_no());
        queryBatch.setReq_time(DateUtil.dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
        queryBatch.setTenant_id("10000");
        List<PaymentDetail> paymentDetailList = paymentDetailMapper.getPaymentDetailByPaymentNo(paymentMain.getPayment_no());
        if(paymentDetailList != null && paymentDetailList.size() > 0){
            for(PaymentDetail paymentDetail : paymentDetailList){
                QueryBatchDetail queryBatchDetail = new QueryBatchDetail();
                queryBatchDetail.setBusiness_order_no(paymentDetail.getBusiness_order_no());
                queryBatchDetail.setTrade_date(DateUtil.dateFormat(paymentDetail.getTrate_date(),"yyyy-MM-dd HH:mm:ss"));
                detailList.add(queryBatchDetail);
            }
            queryBatch.setDetail(detailList);
        }
        Map<String, String> resultMap = null;
        resultMap = JSON.parseObject(JSON.toJSONString(queryBatch), new TypeReference<Map<String, String>>(){});
        resultMap = DataUtil.signData(resultMap, "hejinonline");
        return resultMap;
    }

    @Override
    public void sendQueryBatch(String date){
        String rthBody = "";
        String errorMsg = "";
        String reqStr = "";
        List<PaymentMain> paymentMainList = paymentDetailMapper.getPaymentMainByTradeDate(ConstantUtil.CTRIP_YES, ConstantUtil.CTRIP_DEFAULT,date,"batch");
            if (paymentMainList != null && paymentMainList.size() > 0) {
                for (PaymentMain paymentMain : paymentMainList) {
                    try {
                        Map<String, String> reqtMap = this.getQueryBatch(paymentMain);
                        reqStr = JSON.toJSONString(reqtMap);
                        HttpResult result = httpAPIService.doPostString(envConfig.getPaymentURL() + "queryBatchOrder", reqStr, ContentType.APPLICATION_JSON.getMimeType());
                        if(result.getCode() == HttpStatus.SC_OK){
                            rthBody = result.getBody();
                            Map<String, String> responseMap = JSON.parseObject(rthBody, new TypeReference<Map<String, String>>() {
                            });
                            if ("GWP00000".equals(responseMap.get("ret_code"))) {
                                String resultStr = responseMap.get("result");
                                Map<String, String> resultMap = JSON.parseObject(resultStr, new TypeReference<Map<String, String>>() {
                                });
                                String detailsString = resultMap.get("details");
                                List<Map<String, String>> detailsMapList = JSON.parseObject(detailsString, new TypeReference<List<Map<String, String>>>() {
                                });
                                if (detailsMapList != null && detailsMapList.size() > 0) {
                                    for (Map<String, String> detailMap : detailsMapList) {
                                        String businessNo = detailMap.get("business_order_no");
                                        String trade_status = detailMap.get("trade_status");
                                        PaymentDetail paymentDetail = paymentDetailMapper.getPaymentDetailByBusinessOrderNo(paymentMain.getPayment_no(), businessNo);
                                        paymentDetail.setTrade_status(trade_status);
                                        paymentDetail.setOperateTS(new Date());
                                        paymentDetailMapper.updatePaymentDetail(paymentDetail, paymentDetail.getId());
                                    }
                                }
                                paymentMain.setSend_query_flag(ConstantUtil.CTRIP_YES);
                            }else{
                                paymentMain.setSend_query_flag(ConstantUtil.CTRIP_NO);
                            }
                        }else{
                            throw new MyException("调用queryBatchOrder失败");
                        }

                    }catch (Exception e){
                        errorMsg = e.getLocalizedMessage();
                        logger.error(errorMsg);
                        paymentMain.setSend_query_flag(ConstantUtil.CTRIP_NO);
                    }finally {
                        paymentMain.setOperateTS(new Date());
                        paymentDetailMapper.update(paymentMain, paymentMain.getPayment_no());
                        if (!"".equals(rthBody) || !"".equals(errorMsg)) {
                            payLogService.saveCtripLog("op_sendQueryBatchScheduler", paymentMain.getPayment_no(), reqStr, rthBody, errorMsg);
                        }
                    }
                }
            }
    }

    @Override
    public String savePaymentMainByJsonData(String jsonData) throws MyException {
        PaymentMain paymentMain = JSONObject.parseObject(jsonData,PaymentMain.class);
        paymentMain.setPayment_no(InsuredNumUtil.getPaymentNo("0000"));
        paymentMain.setSend_pay_flag(ConstantUtil.CTRIP_DEFAULT);
        paymentMain.setSend_query_flag(ConstantUtil.CTRIP_DEFAULT);
        paymentMain.setOperateTS(new Date());
        paymentMain.setCreateTS(new Date());
        paymentMain.setPayment_type(ConstantUtil.Pay_type.BATCH);
        paymentMain.setBusiness_user_id(paymentMain.getBusiness_order_no());
        paymentDetailMapper.insert(paymentMain);
        List<PaymentDetail> paymentDetailList = paymentMain.getPaymentDetailList();
        if(paymentDetailList != null && paymentDetailList.size() > 0){
            for(PaymentDetail paymentDetail : paymentDetailList){
                paymentDetail.setPayment_no(paymentMain.getPayment_no());
                paymentDetail.setBusiness_order_no(paymentMain.getBusiness_order_no());
                paymentDetail.setBusiness_user_id(paymentDetail.getReceiver_id());
                paymentDetail.setOperateTS(new Date());
            }
            paymentDetailMapper.insertAll(paymentDetailList);
        }
        return paymentMain.getPayment_no();
    }

    @Override
    public void callbackBusinessSystem() {
        List<PaymentMain> paymentMainList = paymentDetailMapper.getPaymentMainBySendFlag(ConstantUtil.CTRIP_DEFAULT);
        if (paymentMainList != null && paymentMainList.size() > 0) {
            for (PaymentMain paymentMain : paymentMainList) {
                String rthBody = "";
                String errorMsg = "";
                String requestStr = "";
                try {
                    PayStatus payStatus = this.getPayStatusByPayment(paymentMain);
                    requestStr = JSON.toJSONString(payStatus);
                    HttpResult result = httpAPIService.doPostString(paymentMain.getServer_notify_url(), requestStr, ContentType.APPLICATION_JSON.getMimeType());
                    rthBody = result.getBody();
                    if(HttpStatus.SC_OK == result.getCode().intValue()){
                        RtnResult rtnResult = JSON.parseObject(rthBody,RtnResult.class);
                        if (ConstantUtil.PayDetailRetCode.SUCCESS.equals(rtnResult.getRet_code())) {
                            paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_YES);
                        }else{
                            paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_NO);
                        }
                    }else{
                        paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_NO);
                        throw new MyException(result.getBody());
                    }
                }catch (Exception e){
                    errorMsg = e.getLocalizedMessage();
                    logger.error(errorMsg);
                    paymentMain.setSend_business_system_flag(ConstantUtil.CTRIP_NO);
                }finally {
                    paymentMain.setOperateTS(new Date());
                    paymentDetailMapper.update(paymentMain, paymentMain.getPayment_no());
                    if (!"".equals(rthBody) || !"".equals(errorMsg)) {
                        payLogService.saveCtripLog("callbackBusinessSystem", paymentMain.getPayment_no(), requestStr, rthBody, errorMsg);
                    }
                }
            }
        }

    }

    @Override
    public PaymentMain getPaymentMainByPayCase(PayCase payCase, PayReceiver payReceiver) {
        PaymentMain paymentMain = new PaymentMain();
        try {
            paymentMain.setTrade_mode("IMMEDIATEPAY");
            paymentMain.setBatch_no(commonService.getBatchNo());
            paymentMain.setBusiness_order_no(payCase.getPayCaseNo());
            paymentMain.setTrade_amount(payCase.getTradeAmount());
            paymentMain.setTotal_items("1");
            paymentMain.setPay_type("PC");
            paymentMain.setPayment_type("BATCH");
            paymentMain.setTrade_title("退保或批改支付");
            paymentMain.setTrade_detail(payCase.getBusinessNo()+"退保或批改支付");
            paymentMain.setCurrency("CNY");
            paymentMain.setReq_ip(commonService.getLocalIP());
            paymentMain.setServer_notify_url(envConfig.getPayStatusURL());
            paymentMain.setReq_time(DateUtil.dateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
            paymentMain.setFee_code("00600");
            paymentMain.setPay_channel("TLZF");
            List<PaymentDetail> paymentDetailList = new ArrayList<>(0);
            PaymentDetail paymentDetail = new PaymentDetail();
            paymentDetail.setReceiver_id(String.valueOf(payReceiver.getId()));
            paymentDetail.setReceiver_name(payReceiver.getAccountName());
            paymentDetail.setReceiver_account(payReceiver.getAccountNo());
            paymentDetail.setReceiver_account_type("DEBIT");
            paymentDetail.setReceiver_bank_code(payReceiver.getBankCode());
            paymentDetail.setTrade_amount(payCase.getTradeAmount());
            paymentDetailList.add(paymentDetail);
            paymentMain.setPaymentDetailList(paymentDetailList);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return paymentMain;
    }

    private PayStatus getPayStatusByPayment(PaymentMain paymentMain){
        PayStatus payStatus = new PayStatus();
        payStatus.setTrade_date(DateUtil.dateFormat(paymentMain.getTrate_date(),"yyyy-MM-dd HH:mm:ss"));
        payStatus.setBatch_no(paymentMain.getBatch_no());
        payStatus.setBusiness_order_no(paymentMain.getBusiness_user_id());
        payStatus.setRet_code(ConstantUtil.PayDetailRetCode.SUCCESS);
        List<PaymentDetail> paymentDetailList = paymentDetailMapper.getPaymentDetailByPaymentNo(paymentMain.getPayment_no());
        if(paymentDetailList != null && paymentDetailList.size() > 0){
            List<PayStatusDetail> payStatusDetailList = new ArrayList<>();
            for(PaymentDetail paymentDetail : paymentDetailList){
                PayStatusDetail payStatusDetail = new PayStatusDetail();
                payStatusDetail.setReceiver_id(paymentDetail.getReceiver_id());
                payStatusDetail.setTrade_amount(paymentDetail.getTrade_amount());
                payStatusDetail.setTrade_status(paymentDetail.getTrade_status());
                payStatusDetailList.add(payStatusDetail);
            }
            payStatus.setPayStatusDetailList(payStatusDetailList);
        }
        return payStatus;
    }

}
