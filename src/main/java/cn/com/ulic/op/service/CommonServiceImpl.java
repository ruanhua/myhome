package cn.com.ulic.op.service;

import cn.com.ulic.op.dao.CodeMapper;
import cn.com.ulic.op.dao.ConfigMapper;
import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.domain.Config;
import cn.com.ulic.op.util.DateUtil;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by ruanhua on 2017/7/11.
 */
@Service
public class CommonServiceImpl implements CommonService {


    @Autowired
    private ConfigMapper configMapper;

    @Autowired
    private CodeMapper codeMapper;

    @Override
    public String getBatchNo() throws MyException {
        Config config = configMapper.getConfigByCode("BATCH_NO");
        if(config == null || config.getConfigValue() == null || "".equals(config.getConfigValue())){
            throw new MyException("Config表未配置'BATCH_NO' 数据！");
        }
        String batchNo = String.valueOf(Integer.parseInt(config.getConfigValue())+1);
        batchNo = this.formatStr(batchNo);
        config.setConfigValue(batchNo);
        configMapper.update(config,config.getConfigCode());
        return DateUtil.dateFormat(new Date(),"yyyyMMddHHmmss")+batchNo;
    }

    private String formatStr(String str){
        String defaultStr = "000000";
        if(str != null && !"".equals(str)){
            return defaultStr.substring(str.length(),defaultStr.length())+str;
        }
        return defaultStr;
    }

    @Override
    public String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Code> getCodes(Condition condition) {
        return codeMapper.queryCode(condition);
    }

}
