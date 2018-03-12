package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.Area;
import cn.com.ulic.op.vo.Condition;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * Created by ruanhua on 2017/9/7.
 */
@Mapper
public interface AreaMapper {

    @Select("SELECT id, name FROM cs_op_area where id = #{id} ")
    Area getArea(@Param("id") Integer id);

    @SelectProvider(type = AreaProvider.class, method = "queryArea")
    List<Area> getAreas(Condition condition);

    class AreaProvider {
        public String queryArea(Condition condition) {
            SQL sql = new SQL();
            sql.FROM("cs_op_area a");
            sql.SELECT("a.id","a.name","a.parentId","a.levelType");

            sql.WHERE("1=1");
            //地址级别
            if (condition.getLevelType()!=null && !"".equals(condition.getLevelType())) {
                sql.AND();
                sql.WHERE("a.LevelType = #{levelType}");
            }
            //父级ID
            if (condition.getParentId()!=null && !"".equals(condition.getParentId())) {
                sql.AND();
                sql.WHERE("a.ParentId = #{parentId}");
            }
            return sql.toString();
        }
    }

}
