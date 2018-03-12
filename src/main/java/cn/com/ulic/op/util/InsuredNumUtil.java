package cn.com.ulic.op.util;


import cn.com.ulic.op.id.BasicEntityIdGenerator;

/**
 * 报案号、立案号、理算号生成类
 */
public class InsuredNumUtil {
    private static final String _riskCode = "0000";
    private static final String _payCasePrefix = "P2";

    private static final String _paymentPrefix = "P1";

    public static String getPaymentNo(String riskCode) {
        return getInsuredNum(_paymentPrefix, riskCode);
    }

    public static String getPayCaseNo(String riskCode) {
        return getInsuredNum(_payCasePrefix, riskCode);
    }

    /**
     * 调用分布式ID生成器获取ID（18位，ex:851328149943631872），并截取后13位
     *
     * @return
     */
    private static String getBasicEntityId() {
        String id = BasicEntityIdGenerator.getInstance().generateLongIdString();
        return id;
    }


    /**
     * 按不同单号类型拼装单号结果
     * 拼装规则：单号前缀（1位）+险种代码（4位）+分布式ID（18位）
     *
     * @param Prefix
     * @param riskCode
     * @return
     */
    private static String getInsuredNum(String Prefix, String riskCode) {
        if(riskCode == null || "".equals(riskCode)){
            riskCode = _riskCode;
        }
        if(riskCode.length() > 4){
            riskCode = riskCode.substring(riskCode.length()-4,riskCode.length()-1);
        }
        return Prefix + riskCode.trim() + getBasicEntityId().substring(4);
    }

}
