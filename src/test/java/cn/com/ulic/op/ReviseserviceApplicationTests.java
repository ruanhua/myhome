package cn.com.ulic.op;

import cn.com.ulic.op.domain.PaymentDetail;
import cn.com.ulic.op.domain.PaymentMain;
import cn.com.ulic.op.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviseserviceApplicationTests {
	@Autowired
	StringEncryptor stringEncryptor;

	@Test
	public void contextLoads() {

		PaymentMain paymentMain = new PaymentMain();
		paymentMain.setBusiness_order_no("E289001231123213");
		paymentMain.setTrade_amount("1000.00");
		paymentMain.setTotal_items("2");
		paymentMain.setPayment_type("BATCH");
		paymentMain.setPay_type("PC");
		paymentMain.setTrade_title("理赔赔款");
		paymentMain.setTrade_detail("携程航延险理赔赔款");
		paymentMain.setCurrency("CNY");
		paymentMain.setReq_ip("10.129.2.113");
		paymentMain.setFee_code("00600");
		paymentMain.setPay_channel("TLZF");

		PaymentDetail paymentDetail_1 = new PaymentDetail();
		paymentDetail_1.setReceiver_id("6783213");
		paymentDetail_1.setReceiver_name("阮华");
		paymentDetail_1.setReceiver_account("6214830102307633");
		paymentDetail_1.setReceiver_account_type("DEBIT");
		paymentDetail_1.setReceiver_bank_code("103");
		paymentDetail_1.setTrade_amount("400");

		PaymentDetail paymentDetail_2 = new PaymentDetail();
		paymentDetail_2.setReceiver_id("6783214");
		paymentDetail_2.setReceiver_name("张三");
		paymentDetail_2.setReceiver_account("62148301023076312");
		paymentDetail_2.setReceiver_account_type("DEBIT");
		paymentDetail_2.setReceiver_bank_code("103");
		paymentDetail_2.setTrade_amount("600");
		List<PaymentDetail> paymentDetailList = new ArrayList<>(0);
		paymentDetailList.add(paymentDetail_1);
		paymentDetailList.add(paymentDetail_2);
		paymentMain.setServer_notify_url("http://10.129.2.113:9004/ctripflight/getFlight");
		paymentMain.setPaymentDetailList(paymentDetailList);
		String jsonString = JSON.toJSONString(paymentMain);
//		System.out.print("paymentMain===="+jsonString);

		RtnResult rtnResult = new RtnResult();
		rtnResult.setRet_code("GWP00000");
		rtnResult.setRet_msg("");
		jsonString = JSON.toJSONString(rtnResult);
//		System.out.print("rtnResult===="+jsonString);

		PayStatus payStatus = new PayStatus();
		payStatus.setBusiness_order_no("E289001231123213");
		payStatus.setTrade_date("2017-11-08 13:59:59");
		PayStatusDetail payStatusDetail_1 = new PayStatusDetail();
		payStatusDetail_1.setReceiver_id("6783213");
		payStatusDetail_1.setTrade_amount("400");
		payStatusDetail_1.setTrade_status("SUCCESS");
		payStatusDetail_1.setError_msg("");

		PayStatusDetail payStatusDetail_2 = new PayStatusDetail();
		payStatusDetail_2.setReceiver_id("6783214");
		payStatusDetail_2.setTrade_amount("600");
		payStatusDetail_2.setTrade_status("FAIL");
		payStatusDetail_2.setError_msg("账号信息有误！");

		List<PayStatusDetail> payStatusDetailList = new ArrayList<>(0);
		payStatusDetailList.add(payStatusDetail_1);
		payStatusDetailList.add(payStatusDetail_2);
		payStatus.setPayStatusDetailList(payStatusDetailList);
		jsonString = JSON.toJSONString(payStatus);

		RequestBody requestBody  =new RequestBody();
		requestBody.setSalt(UUID.randomUUID().toString().replaceAll("-", ""));
		requestBody.setReq_time("2017-11-15 10:05:30");
		List<String> bigCompensateList = new ArrayList<>();
        bigCompensateList.add("E4171408380127670272");
        bigCompensateList.add("E4171408380127670273");
        requestBody.setBigCompensateNoList(bigCompensateList);
        jsonString = JSON.toJSONString(requestBody);

//		System.out.print("requestBody===="+jsonString);

        ResponseBody responseBody = new ResponseBody();
        PayDetail payDetail_1 = new PayDetail();
        payDetail_1.setCompensateNo("E2171486209895628800");
        payDetail_1.setPolicyNo("61714895209293253545984");
        payDetail_1.setReceiverID("1001");
        payDetail_1.setTradeAmount("200");

        PayDetail payDetail_2 = new PayDetail();
        payDetail_2.setCompensateNo("E2171486209895628801");
        payDetail_2.setPolicyNo("61714895209293253545982");
        payDetail_2.setReceiverID("1002");
        payDetail_2.setTradeAmount("300");
        List<PayDetail> payDetailList = new ArrayList<>();
        payDetailList.add(payDetail_1);
        payDetailList.add(payDetail_2);
        BigCompensate bigCompensate = new BigCompensate();
        bigCompensate.setBigPolicyNo("61714907634962386284544");
        bigCompensate.setBigCompensateNo("E4171408380127670272");
        bigCompensate.setSumPaid("500");
        bigCompensate.setPayDetailList(payDetailList);
        List<BigCompensate> bigCompensates = new ArrayList<>();
        bigCompensates.add(bigCompensate);
        responseBody.setBigCompensateList(bigCompensates);
        responseBody.setRetCode("GWP00000");
        responseBody.setRetMsg("成功");
        jsonString = JSON.toJSONString(responseBody);
        System.out.print("responseBody===="+jsonString);
	}

	/**数据库密码加密*/
	@Test
	public void encryptPwd() {
		String result = stringEncryptor.encrypt("35njygshIHjmdbbs");
		System.out.println(result);
	}
}
