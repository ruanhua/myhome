package cn.com.ulic.op.dao;


import cn.com.ulic.op.domain.PaymentDetail;
import cn.com.ulic.op.domain.PaymentMain;
import org.apache.ibatis.annotations.*;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by RUANHUA on 2017/7/16.
 */
@Mapper
public interface PaymentDetailMapper {
    @Select(" SELECT * FROM cs_op_payment_main where payment_no = #{payment_no}")
    PaymentMain getPaymentMain(@Param("payment_no") String payment_no);

    @Select(" SELECT * FROM cs_op_payment_main where batch_no = #{batch_no}")
    PaymentMain getPaymentMainByBatchNo(@Param("batch_no") String batch_no);

    @Select(" SELECT * FROM cs_op_payment_main where trade_no = #{trade_no} and business_user_id = #{business_user_id}")
    PaymentMain getPaymentMainByTradeNo(@Param("trade_no") String trade_no, @Param("business_user_id") String business_user_id);

    @Select(" SELECT * FROM cs_op_payment_main where send_pay_flag = #{send_pay_flag} and send_query_flag = #{send_query_flag} and trate_date <= #{trate_date} and payment_type = #{payment_type} order by trate_date limit 20 ")
    List<PaymentMain> getPaymentMainByTradeDate(@Param("send_pay_flag") String send_pay_flag, @Param("send_query_flag") String send_query_flag,
                                                @Param("trate_date") String trate_date, @Param("payment_type") String payment_type);

    @Select(" SELECT * FROM cs_op_payment_main where send_business_system_flag = #{send_business_system_flag} and send_query_flag = 'Y' order by trate_date limit 20 ")
    List<PaymentMain> getPaymentMainBySendFlag(@Param("send_business_system_flag") String send_business_system_flag);

    @Insert("INSERT INTO cs_op_payment_main(payment_no,payment_type,pay_type,trade_title,trade_detail,trade_amount,total_items,pay_channel,fee_code,business_user_id," +
            "business_order_no,batch_no,trade_no,trate_date,trade_mode,send_pay_flag,send_query_flag,trade_status,req_ip,server_notify_url,currency,req_time,operateTS,send_business_system_flag,channel) VALUES(" +
            "#{paymentMain.payment_no},#{paymentMain.payment_type}, #{paymentMain.pay_type},#{paymentMain.trade_title},#{paymentMain.trade_detail},#{paymentMain.trade_amount}," +
            "#{paymentMain.total_items},#{paymentMain.pay_channel},#{paymentMain.fee_code},#{paymentMain.business_user_id},#{paymentMain.business_order_no},#{paymentMain.batch_no},#{paymentMain.trade_no}," +
            "#{paymentMain.trate_date},#{paymentMain.trade_mode},#{paymentMain.send_pay_flag},#{paymentMain.send_query_flag},#{paymentMain.trade_status},#{paymentMain.req_ip},#{paymentMain.server_notify_url}," +
            "#{paymentMain.currency},#{paymentMain.req_time},#{paymentMain.operateTS},#{paymentMain.send_business_system_flag},#{paymentMain.pay_channel})")
    void insert(@Param("paymentMain") PaymentMain paymentMain);

    @Update("UPDATE  cs_op_payment_main set payment_type = #{paymentMain.payment_type},pay_type = #{paymentMain.pay_type},trade_title = #{paymentMain.trade_title},trade_detail = #{paymentMain.trade_detail}," +
            "trade_amount = #{paymentMain.trade_amount},total_items = #{paymentMain.total_items},pay_channel = #{paymentMain.pay_channel},fee_code = #{paymentMain.fee_code},business_user_id = #{paymentMain.business_user_id}," +
            "business_user_id = #{paymentMain.business_user_id} ,batch_no = #{paymentMain.batch_no} ,trade_no = #{paymentMain.trade_no} ,trate_date = #{paymentMain.trate_date}, " +
            "trade_mode = #{paymentMain.trade_mode} ,send_pay_flag = #{paymentMain.send_pay_flag} ,send_query_flag = #{paymentMain.send_query_flag} ,trade_status = #{paymentMain.trade_status}, " +
            "req_ip = #{paymentMain.req_ip} ,server_notify_url = #{paymentMain.server_notify_url} ,currency = #{paymentMain.currency} ,req_time = #{paymentMain.req_time} ,operateTS = #{paymentMain.operateTS},send_business_system_flag = #{paymentMain.send_business_system_flag} " +
            "WHERE payment_no = #{payment_no} ")
    void update(@Param("paymentMain") PaymentMain paymentMain, @Param("payment_no") String payment_no);

    @Select(" SELECT * FROM cs_op_payment_detail where payment_no = #{payment_no}")
    List<PaymentDetail> getPaymentDetailByPaymentNo(@Param("payment_no") String payment_no);

    @Select(" SELECT * FROM cs_op_payment_detail where payment_no = #{payment_no} and business_order_no = #{business_order_no}  ")
    PaymentDetail getPaymentDetailByBusinessOrderNo(@Param("payment_no") String payment_no, @Param("business_order_no") String business_order_no);

    @Update("UPDATE  cs_op_payment_detail set payment_no = #{paymentDetail.payment_no},business_order_no = #{paymentDetail.business_order_no},business_user_id = #{paymentDetail.business_user_id}," +
            "receiver_name = #{paymentDetail.receiver_name},receiver_bank_code = #{paymentDetail.receiver_bank_code},trade_amount = #{paymentDetail.trade_amount}," +
            "currency = #{paymentDetail.currency},receiver_id = #{paymentDetail.receiver_id},receiver_account = #{paymentDetail.receiver_account}," +
            "receiver_account_type = #{paymentDetail.receiver_account_type},trate_date = #{paymentDetail.trate_date}," +
            "account_date = #{paymentDetail.account_date},trade_status = #{paymentDetail.trade_status},operateTS = #{paymentDetail.operateTS} " +
            "WHERE id = #{id} ")
    void updatePaymentDetail(@Param("paymentDetail") PaymentDetail paymentDetail, @Param("id") Long id);

    @InsertProvider(type = PaymentDetailProvider.class, method = "inserAll")
    @Options(useGeneratedKeys=true, keyProperty="id",keyColumn = "id")
    int insertAll(List<PaymentDetail> list);

    public static class PaymentDetailProvider {
        public String inserAll(Map<String, List<PaymentDetail>> map) {
            List<PaymentDetail> list = map.get("list");
            StringBuilder stringBuilder = new StringBuilder(256);
            stringBuilder.append("insert into cs_op_payment_detail (payment_no, business_order_no, business_user_id,receiver_name,receiver_bank_code,trade_amount, " +
                    "currency,receiver_id,receiver_account,receiver_account_type,trate_date,account_date,trade_status,operateTS) values ");
            MessageFormat messageFormat = new MessageFormat("(#'{'list[{0}].payment_no},#'{'list[{0}].business_order_no},#'{'list[{0}].business_user_id}," +
                    "#'{'list[{0}].receiver_name},#'{'list[{0}].receiver_bank_code},#'{'list[{0}].trade_amount},#'{'list[{0}].currency},#'{'list[{0}].receiver_id},#'{'list[{0}].receiver_account},"+
                    "#'{'list[{0}].receiver_account_type},#'{'list[{0}].trate_date},#'{'list[{0}].account_date},#'{'list[{0}].trade_status},#'{'list[{0}].operateTS})");
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(messageFormat.format(new Integer[]{i}));
                stringBuilder.append(",");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }

    }

}
