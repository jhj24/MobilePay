package com.jhj.pay.alipay;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;

import com.alipay.sdk.app.PayTask;

import java.util.Map;

/**
 * 支付宝支付
 * Created by jhj on 18-10-18.
 */

public class AliPay {

    private static final int ERROR_RESULT = 1;   //支付结果解析错误
    private static final int ERROR_PAY = 2;  //支付失败
    private static final int ERROR_NETWORK = 3;  //网络连接错误

    private static Handler handler = new Handler();


    public static void pay(final Activity activity, final String orderInfo, final AliPayResultCallback mCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                PayTask aliPay = new PayTask(activity);
                final Map<String, String> result = aliPay.payV2(orderInfo, true);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        if (mCallback == null) {
                            return;
                        }

                        if (result == null) {
                            mCallback.onError(ERROR_RESULT);
                            return;
                        }


                        AliPayResult payResult = new AliPayResult(result);
                        /*
                         对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                         */
                        String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                        String resultStatus = payResult.getResultStatus();

                        if (TextUtils.equals(resultStatus, "9000")) {    //支付成功
                            mCallback.onSuccess();
                        } else if (TextUtils.equals(resultStatus, "8000")) { //支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                            mCallback.onDealing();
                        } else if (TextUtils.equals(resultStatus, "6001")) {        //支付取消
                            mCallback.onCancel();
                        } else if (TextUtils.equals(resultStatus, "6002")) {     //网络连接出错
                            mCallback.onError(ERROR_NETWORK);
                        } else if (TextUtils.equals(resultStatus, "4000")) {        //支付错误
                            mCallback.onError(ERROR_PAY);
                        }


                    }
                });
            }
        }).start();


    }


}
