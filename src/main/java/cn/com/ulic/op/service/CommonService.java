package cn.com.ulic.op.service;

import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.util.MyException;
import cn.com.ulic.op.vo.Condition;

import java.util.List;

/**
 * Created by ruanhua on 2017/7/11.
 */
public interface CommonService {

    public String getBatchNo() throws MyException;

    public String getLocalIP();

    public List<Code> getCodes(Condition condition);

}
