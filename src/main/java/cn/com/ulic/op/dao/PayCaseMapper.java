package cn.com.ulic.op.dao;

import cn.com.ulic.op.domain.PayCase;
import cn.com.ulic.op.domain.PayReceiver;
import cn.com.ulic.op.vo.PayQueryCondition;
import cn.com.ulic.op.vo.PayQueryResult;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by ruanhua on 2017/6/5.
 */
@Mapper
public interface PayCaseMapper {
    @Insert("INSERT INTO cs_op_payReceiver (payCaseNo,payType,provinceCode,cityCode,bankCode, accountType, validity, cvv2, accountNo, accountName,privateInd," +
            "idType,idNum,mobile,remark,valid,operateTS,operator )" +
            " VALUES(#{payReceiver.payCaseNo},#{payReceiver.payType},#{payReceiver.provinceCode},#{payReceiver.cityCode},#{payReceiver.bankCode}, #{payReceiver.accountType}, #{payReceiver.validity},#{payReceiver.cvv2},#{payReceiver.accountNo}," +
            " #{payReceiver.accountName}, #{payReceiver.privateInd}, #{payReceiver.idType},#{payReceiver.idNum},#{payReceiver.mobile},#{payReceiver.remark},#{payReceiver.valid}," +
            "#{payReceiver.operateTS},#{payReceiver.operator})")
    @Options(useGeneratedKeys=true, keyProperty="payReceiver.id",keyColumn = "id")
    void insert(@Param("payReceiver") PayReceiver payReceiver);

    @Update("UPDATE cs_op_payReceiver SET bankCode = #{payReceiver.bankCode}, accountType = #{payReceiver.accountType}, validity = #{payReceiver.validity}, " +
            "cvv2 = #{payReceiver.cvv2}, accountNo = #{payReceiver.accountNo}, accountName = #{payReceiver.accountName}, privateInd = #{payReceiver.privateInd}, " +
            "idType = #{payReceiver.idType}, idNum = #{payReceiver.idNum},mobile = #{payReceiver.mobile}, remark = #{payReceiver.remark}, valid = #{payReceiver.valid}, " +
            "operateTS = #{payReceiver.operateTS}, operator = #{payReceiver.operator}, payCaseNo = #{payReceiver.payCaseNo}, payType = #{payReceiver.payType}," +
            "provinceCode = #{payReceiver.provinceCode}, cityCode = #{payReceiver.cityCode} WHERE id = #{id}")
    void update(@Param("payReceiver") PayReceiver payReceiver, @Param("id") Long id);

    @Select("SELECT * FROM cs_op_payReceiver WHERE id = #{id}")
    PayReceiver getPayRecevier(@Param("id") Long id);

    @Select("SELECT * FROM cs_op_payReceiver WHERE payCaseNo = #{payCaseNo}")
    PayReceiver getPayRecevierByCaseNo(@Param("payCaseNo") String payCaseNo);


    @Insert("INSERT INTO cs_op_payCase (payCaseNo,policyNo,businessNo,holderName,productMetaNo, productMetaName, tradeAmount, operateTS, createTS,operator,riskCode,payStatus,payDate,channel,businessType,paymentCallbackURL,sendCallBackStatus)" +
            " VALUES(#{payCase.payCaseNo},#{payCase.policyNo},#{payCase.businessNo},#{payCase.holderName},#{payCase.productMetaNo},#{payCase.productMetaName}, " +
            "#{payCase.tradeAmount},#{payCase.operateTS},#{payCase.createTS},#{payCase.operator},#{payCase.riskCode},#{payCase.payStatus},#{payCase.payDate},#{payCase.channel},#{payCase.businessType},#{payCase.paymentCallbackURL},#{payCase.sendCallBackStatus})")
    void insertPayCase(@Param("payCase") PayCase payCase);

    @Update("UPDATE cs_op_payCase SET payCaseNo = #{payCase.payCaseNo}, businessNo = #{payCase.businessNo}, policyNo = #{payCase.policyNo}, holderName = #{payCase.holderName}, " +
            "productMetaNo = #{payCase.productMetaNo}, productMetaName = #{payCase.productMetaName}, tradeAmount = #{payCase.tradeAmount}, operateTS = #{payCase.operateTS}, " +
            "operator = #{payCase.operator},riskCode = #{payCase.riskCode},payDate = #{payCase.payDate},payStatus = #{payCase.payStatus},channel = #{payCase.channel},sendCallBackStatus = #{payCase.sendCallBackStatus} WHERE payCaseNo = #{payCaseNo}")
    void updatePayCase(@Param("payCase") PayCase payCase, @Param("payCaseNo") String payCaseNo);

    @Select("SELECT * FROM cs_op_payCase WHERE payCaseNo = #{payCaseNo}")
    PayCase getPayCase(@Param("payCaseNo") String payCaseNo);


    @SelectProvider(type = PayQueryProvider.class, method = "queryPayResult")
    List<PayQueryResult> queryPayResult(PayQueryCondition queryCondition);

    class PayQueryProvider {
        public String queryPayResult(PayQueryCondition queryCondition) {
            SQL sql = new SQL();
            sql.FROM("cs_op_payCase c");
            sql.SELECT("c.policyNo","c.payCaseNo","c.businessNo","c.productMetaName","c.holderName","c.payStatus",
                    "DATE_FORMAT(c.payDate,'%Y-%m-%d %H:%i:%S') payDate");

            sql.WHERE("1=1");
            //保单号
            if (queryCondition.getPolicyNo()!=null && !"".equals(queryCondition.getPolicyNo())) {
                sql.AND();
                sql.WHERE("c.policyNo = #{policyNo}");
            }
            //支付状态
            if (queryCondition.getPayStatus()!=null && !"".equals(queryCondition.getPayStatus())) {
                sql.AND();
                sql.WHERE("c.payStatus = #{payStatus}");
            }
            //渠道
            if (queryCondition.getChannel()!=null && !"".equals(queryCondition.getChannel())) {
                sql.AND();
                sql.WHERE("c.channel = #{channel}");
            }

            //业务类型
            if (queryCondition.getBusinessType()!=null && !"".equals(queryCondition.getBusinessType())) {
                sql.AND();
                sql.WHERE("c.businessType = #{businessType}");
            }

            //支付日期
            if (queryCondition.getStartDate()!=null && !"".equals(queryCondition.getStartDate())
                    && queryCondition.getEndDate()!=null && !"".equals(queryCondition.getEndDate())) {
                sql.AND();
                sql.WHERE("c.payDate is not null and date_format(c.payDate,'%Y-%m-%d') between #{startDate} and #{endDate}");
            }
            return sql.toString();
        }
    }

}
