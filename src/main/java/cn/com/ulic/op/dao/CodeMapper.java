package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.Code;
import cn.com.ulic.op.vo.Condition;
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

    @SelectProvider(type = CodeProvider.class, method = "queryCode")
    List<Code> queryCode(Condition condition);

    class CodeProvider {
        public String queryCode(Condition condition) {
            SQL sql = new SQL();
            sql.FROM("cs_op_code a");
            sql.SELECT("a.unionCode","a.unionName");
            sql.WHERE("1=1");
            if (condition.getCodeType()!=null && !"".equals(condition.getCodeType())) {
                sql.AND();
                sql.WHERE("type =#{codeType}");
            }
            return sql.toString();
        }
    }
}
