package cn.com.ulic.op.service;

import cn.com.ulic.op.domain.PayCase;
import cn.com.ulic.op.domain.PayReceiver;
import cn.com.ulic.op.domain.PaymentMain;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.PayQueryCondition;
import cn.com.ulic.op.vo.PayQueryResult;
import cn.com.ulic.op.vo.RtnResult;
import cn.com.ulic.op.vo.UnifiedOrderRtn;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Created by ruanhua on 2017/6/12.
 */
public interface PayCaseService {

    /**保存业务基本信息*/
    public PayCase savePayCase(PayCase payCase);

    /**获取业务基本信息*/
    public PayCase getPayCase(String payCaseNo);

    /**保存账户信息*/
    public PayReceiver savePayReceiver(PayReceiver payReceiver);

    /**获取业务基本信息*/
    public PayReceiver getPayReceiver(String payCaseNo);

    public List<PayQueryResult> findPayQueryResults(PayQueryCondition payQueryCondition);

}
