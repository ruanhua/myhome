package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.vo.UserCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by wangyinlong on 2017/6/6.
 */
@Mapper
public interface CodeMapper {

    @Select("SELECT id,type,unionCode,unionName FROM cs_op_code where type = #{type} and unionCode = #{unionCode}")
    Code getCode(@Param("type") String type,@Param("unionCode") String unionCode);
}
