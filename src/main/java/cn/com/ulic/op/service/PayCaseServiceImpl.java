package cn.com.ulic.op.service;


import cn.com.ulic.op.EnvConfig;
import cn.com.ulic.op.dao.PayCaseMapper;
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
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by ruanhua on 2017/6/12.
 */
@Service
public class PayCaseServiceImpl implements PayCaseService {

    @Autowired
    private PayCaseMapper payCaseMapper;

    @Autowired
    private CommonService commonService;

    @Override
    public PayCase savePayCase(PayCase payCase) {
        PayCase payCaseOld = payCaseMapper.getPayCase(payCase.getPayCaseNo());
        if(payCaseOld == null){
            payCase.setOperateTS(new Date());
            payCase.setCreateTS(new Date());
            payCase.setPayStatus(ConstantUtil.CTRIP_DEFAULT);
            payCase.setBusinessType("surrender");
            payCase.setSendCallBackStatus(ConstantUtil.CTRIP_DEFAULT);
            payCaseMapper.insertPayCase(payCase);
            return payCase;
        }else{
            BeanUtils.copyProperties(payCase,payCaseOld);
            payCaseOld.setOperateTS(new Date());
            payCaseMapper.updatePayCase(payCaseOld,payCaseOld.getPayCaseNo());
            return payCaseOld;
        }
    }

    @Override
    public PayCase getPayCase(String payCaseNo) {
        return payCaseMapper.getPayCase(payCaseNo);
    }

    @Override
    public PayReceiver savePayReceiver(PayReceiver payReceiver) {
        PayReceiver payReceiverOld = payCaseMapper.getPayRecevier(payReceiver.getId());
        if(payReceiverOld == null){
            payReceiver.setOperateTS(new Date());
            payReceiver.setCreateTS(new Date());
            payCaseMapper.insert(payReceiver);
            return payReceiver;
        }else{
            BeanUtils.copyProperties(payReceiver,payReceiverOld);
            payReceiverOld.setOperateTS(new Date());
            payCaseMapper.update(payReceiverOld,payReceiverOld.getId());
            return payReceiverOld;
        }
    }

    @Override
    public PayReceiver getPayReceiver(String payCaseNo) {
        PayReceiver payReceiver = payCaseMapper.getPayRecevierByCaseNo(payCaseNo);
        if(payReceiver != null){
            if(payReceiver.getBankCode() != null && !"".equals(payReceiver.getBankCode())){
                payReceiver.setBankName(commonService.getCodeName("bankCode",payReceiver.getBankCode()));
            }
            if(payReceiver.getProvinceCode() != null && !"".equals(payReceiver.getProvinceCode())){
                payReceiver.setProvinceName(commonService.getAreaName(Integer.parseInt(payReceiver.getProvinceCode())));
            }
            if(payReceiver.getCityCode() != null && !"".equals(payReceiver.getCityCode())){
                payReceiver.setCityName(commonService.getAreaName(Integer.parseInt(payReceiver.getCityCode())));
            }
            if(payReceiver.getPayType() != null && !"".equals(payReceiver.getPayType())){
                payReceiver.setPayTypeName("实时");
                if("1".equals(payReceiver.getPayType())){
                    payReceiver.setPayTypeName("非实时");
                }

            }
        }
        return payReceiver;
    }

    @Override
    public List<PayQueryResult> findPayQueryResults(PayQueryCondition payQueryCondition) {
        List<PayQueryResult> payQueryResultList = payCaseMapper.queryPayResult(payQueryCondition);
        if(payQueryResultList != null && payQueryResultList.size() > 0){
            for(PayQueryResult payQueryResult : payQueryResultList){
                payQueryResult.setOperateStyle("goBack");
                if("SUCCESS".equals(payQueryResult.getPayStatus())){
                    payQueryResult.setOperateStyle("query");
                }
            }
        }
        return payQueryResultList;
    }
}
