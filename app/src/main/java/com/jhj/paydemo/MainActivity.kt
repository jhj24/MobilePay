package com.jhj.paydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /**
         * 微信支付之前应该先对本地服务器进行一次网络请求，用于生成订单，将订单信息(APPID,商户号、随机字符串等)返回给APP,
         * APP再根据订单信息(APPID,商户号、随机字符串等)进行二次签名，然后进行支付。
         *
         * 支付成功后进行回调，在回调的Activity中再次对本地服务器进行网络请求，看是否真的支付成功
         */

    }
}
