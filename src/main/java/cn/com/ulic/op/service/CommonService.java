package cn.com.ulic.op.service;

import cn.com.ulic.op.domain.Area;
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

    public List<Area> getAreas(Condition condition);

    Area getArea(Integer id);

    String getAreaName(Integer id);

    public List<Code> getCodes(Condition condition);

    Code getCode(String type,String unionCode);

    String getCodeName(String type,String unionCode);

}
