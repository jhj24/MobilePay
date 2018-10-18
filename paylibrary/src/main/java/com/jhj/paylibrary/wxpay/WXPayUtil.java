package com.jhj.paylibrary.wxpay;

import android.content.Context;
import android.widget.Toast;

import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/**
 * Created by jhj on 18-10-18.
 */

public class WXPayUtil {

    public static String WX_APP_ID;

    public static void pay(Context mContext, WXPayBean bean, String merchantKey) {
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        WX_APP_ID = bean.getAppid();
        IWXAPI wxApi = WXAPIFactory.createWXAPI(mContext, bean.getAppid());
        wxApi.registerApp(bean.getAppid());
        if (wxApi.getWXAppSupportAPI() < Build.PAY_SUPPORTED_SDK_INT) {
            Toast.makeText(mContext, "您未安装最新版本微信，不支持微信支付，请安装或升级微信版本", Toast.LENGTH_SHORT).show();
        }
        PayReq request = new PayReq();
        request.appId = bean.getAppid();
        request.partnerId = bean.getMch_id();
        request.prepayId = bean.getPrepay_id();
        request.packageValue = "Sign=WXPay";
        request.nonceStr = bean.getNonce_str();
        request.timeStamp = time;
        request.sign = WXSignEncryptionUtil.genPayReq(request, merchantKey);
        wxApi.sendReq(request);
    }


}
