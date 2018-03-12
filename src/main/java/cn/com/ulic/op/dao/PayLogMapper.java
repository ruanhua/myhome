package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.CtripLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ruanhua on 2017/6/5.
 */
@Mapper
public interface PayLogMapper {
    @Insert("INSERT INTO cs_ctripLog (nodeName, businessNo,resquestData, responseData,isError, errorMsg,operateTS,remark ) "+
            " VALUES(#{ctripLog.nodeName},#{ctripLog.businessNo}, #{ctripLog.resquestData}, #{ctripLog.responseData}, #{ctripLog.isError}," +
            "#{ctripLog.errorMsg},#{ctripLog.operateTS},#{ctripLog.remark})")
    @Options(useGeneratedKeys=true, keyProperty="ctripLog.id",keyColumn = "id")
    void insert(@Param("ctripLog") CtripLog ctripLog);

}
