package com.coopbuy.mall.mypay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.coopbuy.mall.api.reponse.WeixinEntity;
import com.coopbuy.mall.mypay.alipay.AuthResult;
import com.coopbuy.mall.mypay.alipay.PayResult;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


import java.util.Map;

/**
 * @author csn
 * @date 2017/5/18 0018 10:41
 * @content 这是一个支付类工具
 */
public class PayUtils {
    private PayListener mListener;
    private Activity mContext;
    private IWXAPI api;
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_AUTH_FLAG = 2;

    public PayUtils(PayListener mListener, Activity mContext) {
        this.mListener = mListener;
        this.mContext = mContext;
        api = WXAPIFactory.createWXAPI(mContext, Constants.APP_ID);
        api.registerApp(Constants.APP_ID);
    }

    /**
     * 微信支付
     */
    public void payWeChat(WeixinEntity bean) {
        if (api.isWXAppInstalled()) {
            if (bean == null) {
                return;
            }
            PayReq req = new PayReq();
            req.appId = bean.getAppid();
            req.partnerId = bean.getPartnerid();
            req.prepayId = bean.getPrepayid();
            req.nonceStr = bean.getNoncestr();
            req.timeStamp = bean.getTimestamp();
            req.packageValue = "Sign=WXPay";
            req.sign = bean.getSign();
            api.sendReq(req);
        } else {
            ToastUtils.toastLong("检测到您未安装微信客户端或者版本较低");
        }
    }

    /**
     * 支付宝支付业务
     */
    public void aliPay(final String orderInfo) {
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                PayTask alipay = new PayTask(mContext);
                Map<String, String> result = alipay.payV2(orderInfo, true);
                Log.i("msp", result.toString());
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @SuppressWarnings("unused")
        public void handleMessage(final Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    String resultInfo = payResult.getResult();// 同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    final String message = payResult.getMemo();
                    // 判断resultStatus 为9000则代表支付成功
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        DialogUtils.showOneKeyDialog(mContext, new CommonDialog.ClickCallBack() {
                            @Override
                            public void onConfirm() {
                                if (mListener != null) {
                                    mListener.aliPaySuccess();
                                }
                            }
                        }, "支付成功", "确认", false);
                        //返回购物车
                        //   MobclickAgent.onEvent(mContext, Constant.ALIPAY_OK);    //购买
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        DialogUtils.showOneKeyDialog(mContext, new CommonDialog.ClickCallBack() {
                            @Override
                            public void onConfirm() {
                                if (mListener != null) {
                                    //      MobclickAgent.onEvent(mContext, Constant.ALIPAY_CANCLE);    //购买
                                    ToastUtils.toastLong(message);
                                    mListener.aliPayFail();
                                }
                            }
                        }, "支付失败", "确认", false);
                    }
                    break;
                }
                case SDK_AUTH_FLAG: {
                    @SuppressWarnings("unchecked")
                    AuthResult authResult = new AuthResult((Map<String, String>) msg.obj, true);
                    String resultStatus = authResult.getResultStatus();
                    // 判断resultStatus 为“9000”且result_code
                    // 为“200”则代表授权成功，具体状态码代表含义可参考授权接口文档
                    if (TextUtils.equals(resultStatus, "9000") && TextUtils.equals(authResult.getResultCode(), "200")) {
                        // 获取alipay_open_id，调支付时作为参数extern_token 的value
                        // 传入，则支付账户为该授权账户
                        //   ToastUtil.TextToast(mContext, "授权成功\n" + String.format("authCode:%s", authResult.getAuthCode()));
                        if (mListener != null) {
                            mListener.aliAuthSuccess();
                        }
                    } else {
                        // 其他状态值则为授权失败
                        //   ToastUtil.TextToast(mContext, "授权失败" + String.format("authCode:%s", authResult.getAuthCode()));
                        // if (mListener!=null){
                        //    MobclickAgent.onEvent(mContext, Constant.ALIPAY_CANCLE);    //购买
                        mListener.aliAuthFail();
                    }
                }
                break;
                default:
                    break;
            }
        }
    };

}
