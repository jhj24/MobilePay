package com.jhj.paylibrary.wxpay;

/**
 * 在微信支付服务后台生成预支付交易单，返回正确的预支付交易会话标识后再在APP里面调起支付
 * <p>
 * Created by jhj on 18-10-18.
 */

public class WXPayBean {

    /**
     * APP_ID
     * <p>
     * "wx2ac432ead8647e74"
     */
    private String appid;
    /**
     * 商户号
     * <p>
     * "1510364741"
     */
    private String mch_id;
    /**
     * 随机字符串
     * <p>
     * "62Uk4zBOSRMRiqcJ"
     */
    private String nonce_str;
    /**
     * 预支付交易会话ID
     * <p>
     * "wx17114625943161551ca2072f2938933951"
     */
    private String prepay_id;
    /**
     * 签名，支付时提交sign的不是该参数，而是对其他数据进行MD５加密，
     * <p>
     * "991B606B76BC20D40A3559F8C227D861"
     */
    private String sign;
    /**
     * 终端
     * <p>
     * "APP"
     */
    private String trade_type;

    /**
     * 业务结果
     * <p>
     * "SUCCESS","FAIL"
     */
    private String result_code;
    /**
     * 返回状态码
     * <p>
     * "SUCCESS",
     */
    private String return_code;
    /**
     * 返回状态信息
     * <p>
     * "OK","签名失败"
     */
    private String return_msg;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getPrepay_id() {
        return prepay_id;
    }

    public void setPrepay_id(String prepay_id) {
        this.prepay_id = prepay_id;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }
}
