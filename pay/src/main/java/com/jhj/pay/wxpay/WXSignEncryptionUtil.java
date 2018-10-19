package com.jhj.pay.wxpay;

import com.tencent.mm.opensdk.modelpay.PayReq;

import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信 Sign 二次加密
 * Created by jhj on 18-10-18.
 */

public class WXSignEncryptionUtil {

    private static String createSign(String characterEncoding, SortedMap<String, String> parameters, String merchantKey) {

        StringBuilder sb = new StringBuilder();
        Set es = parameters.entrySet();// 所有参与传参的参数按照accsii排序（升序）
        for (Object e : es) {
            Map.Entry entry = (Map.Entry) e;
            String k = (String) entry.getKey();
            Object v = entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k)
                    && !"key".equals(k)) {
                sb.append(k).append("=").append(v).append("&");
            }
        }
        sb.append("key=").append(merchantKey); //KEY是商户key
        return MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
    }

    /**
     * 微信支付二次签名算法sign
     *
     * @return
     */
    public static String genPayReq(PayReq request, String merchantKey) {

        SortedMap<String, String> parameters = new TreeMap<>();

        parameters.put("appid", request.appId);
        parameters.put("noncestr", request.nonceStr);
        parameters.put("package", request.packageValue);
        parameters.put("partnerid", request.partnerId);
        parameters.put("prepayid", request.prepayId);
        parameters.put("timestamp", request.timeStamp);

        String characterEncoding = "UTF-8";
        return createSign(characterEncoding, parameters, merchantKey);
    }
}
