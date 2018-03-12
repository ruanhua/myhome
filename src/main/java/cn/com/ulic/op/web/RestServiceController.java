package cn.com.ulic.op.web;

import cn.com.ulic.op.EnvConfig;
import cn.com.ulic.op.domain.Area;
import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.domain.PayCase;
import cn.com.ulic.op.domain.PayReceiver;
import cn.com.ulic.op.http.HttpAPIService;
import cn.com.ulic.op.http.HttpResult;
import cn.com.ulic.op.service.CommonService;
import cn.com.ulic.op.service.PayCaseService;
import cn.com.ulic.op.service.PayLogService;
import cn.com.ulic.op.service.PaymentService;
import cn.com.ulic.op.util.ConstantUtil;
import cn.com.ulic.op.util.DateUtil;
import cn.com.ulic.op.util.InsuredNumUtil;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ruanhua on 2017/6/6.
 */
@RestController
public class RestServiceController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EnvConfig envConfig;

    @Autowired
    private HttpAPIService httpAPIService;

    @Autowired
    private PayLogService payLogService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PayCaseService payCaseService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 接收支付信息
     * @param
     * @return
     */
    @RequestMapping(value="/getPayment",method = RequestMethod.POST)
    public RtnResult getPayment(@RequestBody String data) {
        String errorMsg = "";
        HttpResult result;
        String paramStr = "";
        String rthStr = "";
        String paymentNo = "";
        RtnResult rtnResult;
        try{
            paymentNo = paymentService.savePaymentMainByJsonData(data);
            Map<String,String> resultMap = paymentService.getUnifiedOrderByPaymentMain(paymentNo);
            paramStr = JSON.toJSONString(resultMap);
            result = httpAPIService.doPostString(envConfig.getPaymentURL()+"unifiedOrder",paramStr, ContentType.APPLICATION_JSON.getMimeType());
            rthStr = result.getBody();
            UnifiedOrderRtn unifiedOrderRtn = JSON.parseObject(rthStr, UnifiedOrderRtn.class);
            if(!ConstantUtil.PayDetailRetCode.SUCCESS.equals(unifiedOrderRtn.getRet_code())){
                throw new MyException(unifiedOrderRtn.getRet_msg());
            }
            String tradeNo = JSONObject.parseObject(rthStr).getJSONObject("result").getString("tradeNo");
            unifiedOrderRtn.setTrade_no(tradeNo);
            unifiedOrderRtn.setPayment_no(paymentNo);
            rtnResult = paymentService.saveUnifiedOrderRth(unifiedOrderRtn);
        }catch (Exception e){
            errorMsg = e.getLocalizedMessage();
            logger.error(errorMsg);
            rtnResult = RtnResult.error(ConstantUtil.PayDetailRetCode.SYSTEM_ERROR,e.getMessage());
        }finally {
            payLogService.saveCtripLog("unifiedOrder",paymentNo,data,rthStr,errorMsg);
        }
        return rtnResult;
    }

    @RequestMapping(value = "/getAreaByUpper", method = RequestMethod.POST)
    public List<Area> getAreaByUpper(@RequestBody Condition condition) {
            List<Area> areaList = commonService.getAreas(condition);
            return areaList;
    }

    @RequestMapping(value = "/queryCode", method = RequestMethod.POST)
    public List<Code> queryCode(@RequestBody Condition condition) {
        List<Code> codes = commonService.getCodes(condition);
        return codes;
    }

    @RequestMapping(value = "/getSurrender", method = RequestMethod.POST)
    public Map<String, String>  getSurrender(@RequestBody Surrender surrender) {
        String errorStr = "";
        Map<String,String> resultMap = new HashMap<>(0);
        try{
            PayCase payCase = new PayCase(surrender.getPolicyNo(),
                    surrender.getEndorNo(),
                    surrender.getHolderName(),
                    surrender.getProductCode(),
                    surrender.getProductName(),
                    surrender.getAmount(),
                    surrender.getChannel(),
                    surrender.getPaymentCallbackURL()
            );
            payCase.setPayCaseNo(InsuredNumUtil.getPayCaseNo(payCase.getRiskCode()));
            payCaseService.savePayCase(payCase);
            resultMap.put("ret_code",ConstantUtil.PayDetailRetCode.SUCCESS);
            resultMap.put("ret_msg","");
        }catch (Exception e){
            resultMap.put("ret_code",ConstantUtil.PayDetailRetCode.SYSTEM_ERROR);
            resultMap.put("ret_msg",e.getLocalizedMessage());
            errorStr = e.getLocalizedMessage();
        }finally {
            payLogService.saveCtripLog("getSurrender",surrender.getEndorNo(),surrender.toString(),resultMap.toString(),errorStr);
        }
        return resultMap;
    }

    @RequestMapping(value = "/getPayStatus", method = RequestMethod.POST)
    public Map<String, String> getPayStatus(@RequestBody PayStatus payStatus) {
        if(payStatus != null){
            PayCase payCase = payCaseService.getPayCase(payStatus.getBusiness_order_no());
            List<PayStatusDetail> payStatusDetailList = payStatus.getPayStatusDetailList();
            if(payStatusDetailList != null && payStatusDetailList.size() > 0){
                PayStatusDetail payStatusDetail = payStatusDetailList.get(0);
                payCase.setPayStatus(payStatusDetail.getTrade_status());
                payCase.setPayDate(DateUtil.parseDate(payStatus.getTrade_date()));
                if(payCase.getPaymentCallbackURL() != null && !"".endsWith(payCase.getPaymentCallbackURL())){
                    try {
                        HttpResult result = httpAPIService.doPostString(payCase.getPaymentCallbackURL(),JSON.toJSONString(payStatus),ContentType.APPLICATION_JSON.getMimeType());
                        if(result.getCode().intValue() != HttpStatus.SC_OK){
                            throw  new MyException("调用支付接口异常");
                        }
                        payCase.setSendCallBackStatus(ConstantUtil.CTRIP_YES);
                    }catch (Exception e){
                        logger.error(e.getLocalizedMessage());
                        payCase.setSendCallBackStatus(ConstantUtil.CTRIP_NO);
                    }
                }
                payCaseService.savePayCase(payCase);
            }
        }
        Map<String,String> resultMap = new HashMap<>(0);
        resultMap.put("ret_code",ConstantUtil.PayDetailRetCode.SUCCESS);
        resultMap.put("ret_msg","");
        return resultMap;
    }

    /**
     * 查询支付状态
     */
    @RequestMapping(value = "/getQueryBatch", method = RequestMethod.POST)
    public void getQueryBatch(){
        paymentService.sendQueryBatch(DateUtil.getMinuteDate(-10));
    }

    /**
     * 回调业务系统
     */
    @RequestMapping(value = "/getCallbackBus", method = RequestMethod.POST)
    public void getCallbackBus(){
        paymentService.callbackBusinessSystem();
    }

}
