package com.jhj.paylibrary.alipay;

/**
 * Created by jhj on 18-10-18.
 */

public interface AliPayResultCallback {

    /**
     * 支付成功
     */
    void onSuccess();

    /**
     * 正在处理中 小概率事件 此时以验证服务端异步通知结果为准
     */
    void onDealing();

    /**
     * 支付失败
     *
     * @param errorCode 错误码
     */
    void onError(int errorCode);

    /**
     * 支付取消
     */
    void onCancel();
}
