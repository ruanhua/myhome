package cn.com.ulic.op.service;


import cn.com.ulic.op.dao.PayLogMapper;
import cn.com.ulic.op.domain.CtripLog;
import cn.com.ulic.op.util.ConstantUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by RUANHUA on 2017/7/16.
 */
@Service
public class PayLogServiceImpl implements PayLogService {

    @Autowired
    private PayLogMapper payLogMapper;

    @Override
    public void saveCtripLog(String nodeName, String businessNo,String resquestData, String responseData ,String errorMsg) {
        String isError = ConstantUtil.CTRIP_NO;
        if(errorMsg != null && !"".equals(errorMsg)){
            isError = ConstantUtil.CTRIP_YES;
        }
        CtripLog ctripLog = new CtripLog(nodeName,businessNo,resquestData,
                responseData,isError,errorMsg,new Date(),new Date(),"");
        payLogMapper.insert(ctripLog);
    }
}
