package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by ruanhua on 2017/9/7.
 */
@Mapper
public interface ConfigMapper {

    @Select("select * from  cs_config where configCode = #{configCode} and validFlag = '1' ")
    Config getConfigByCode(@Param("configCode") String configCode);

    @Update("UPDATE  cs_config set configValue = #{config.configValue},configDesc = #{config.configDesc},productCode = #{config.productCode},operateTS = #{config.operateTS} " +
            "WHERE configCode = #{configCode} and validFlag = '1' ")
    void update(@Param("config") Config config, @Param("configCode") String configCode);
}
