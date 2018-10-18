package com.jhj.paydemo.wxapi;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.jhj.paylibrary.R;
import com.jhj.paylibrary.WXPayUtil;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {


    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_result);

        api = WXAPIFactory.createWXAPI(this, WXPayUtil.WX_APP_ID);
        api.handleIntent(getIntent(), this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
    }

    @Override
    public void onResp(BaseResp resp) {

        if (resp.getType() == ConstantsAPI.COMMAND_PAY_BY_WX) {
           /* AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("微信支付结果：" + resp.errCode);
            builder.show();*/
            if (resp.errCode == 0) {
                //TODO 此时的成功并不是真正的成功，需要网络服务器请求判断
                Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
            } else if (resp.errCode == -2) {
                Toast.makeText(this, "取消支付", Toast.LENGTH_SHORT).show();
            }
        }
        finish();

    }
}