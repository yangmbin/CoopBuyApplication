package com.coopbuy.mall.wxapi;

import android.content.Intent;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseFragmentActivity;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.WeiXinEvent;
import com.coopbuy.mall.utils.Constants;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;
import com.guinong.net.utils.LogUtil;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXPayEntryActivity extends BaseFragmentActivity implements IWXAPIEventHandler {

    private static final String TAG = "MicroMsg.SDKSample.WXPayEntryActivity";

    private IWXAPI api;

    @Override
    protected void setThisActivityName() {
        thisActivityName = "WXPayEntryActivity";
    }

    @Override
    public int getLayoutId() {
        return R.layout.pay_result;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {
        //mPresenter.sendWinxinMsg();
    }

    @Override
    public void initView() {
        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);
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
        final int code = resp.errCode;

        if (code == 0) {
            // Toast.makeText(this, "支付成功", Toast.LENGTH_SHORT).show();
            //显示充值成功的页面和需要的操作
            LogUtil.error("微信支付结果", "支付成功");
            DialogUtils.showOneKeyDialog(mContext, new CommonDialog.ClickCallBack() {
                @Override
                public void onConfirm() {
                    //进行跳转
                    wex(code);
                    finish();
                }
            }, "支付成功", "确认", false);
        }

        if (code == -1) {
            //错误
            // Toast.makeText(this, "支付错误", Toast.LENGTH_SHORT).show();
            LogUtil.error("微信支付结果", "支付错误");
            DialogUtils.showOneKeyDialog(mContext, new CommonDialog.ClickCallBack() {
                @Override
                public void onConfirm() {
                    //进行跳转
                    wex(code);
                    finish();
                }
            }, "支付失败", "确认", false);
        }

        if (code == -2) {
            //  Toast.makeText(this, "支付取消", Toast.LENGTH_SHORT).show();
            LogUtil.error("微信支付结果", "支付取消");
            //用户取消
            DialogUtils.showOneKeyDialog(mContext, new CommonDialog.ClickCallBack() {
                @Override
                public void onConfirm() {
                    //进行跳转
                    wex(code);
                    finish();
                }
            }, "支付失败", "确认", false);
        }

    }

    private void wex(int code) {
        WeiXinEvent event = new WeiXinEvent();
        event.setCode(code);
        EventBusInstance.getInstance().post(event);
    }

    @Override
    public void onBackPressed() {

    }
}