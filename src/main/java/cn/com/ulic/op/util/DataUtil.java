package cn.com.ulic.op.util;

import java.util.Map;


public class DataUtil {
	/**
	 * 对Map数据进行MD5签名
	 *
	 * @param data
	 *            欲签名的数据
	 * @return 如果key为null则返回元数据；否则，返回 Map<String, String>类型的签名后的数据
	 */
	public static Map<String, String> signData(Map<String, String> data,String salt) {

		return MD5SignAndValidate.signData(data, salt);
	}


}
