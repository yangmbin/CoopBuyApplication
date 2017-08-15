package com.coopbuy.mall.ui.module.home.activity;

import android.os.Vibrator;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import butterknife.Bind;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class ScanQrCodeActivity extends BaseActivity implements QRCodeView.Delegate {

    @Bind(R.id.zxingview)
    ZXingView mZxingView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_scan_qr_code;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("扫一扫");
        mZxingView.setDelegate(this);
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        vibrate();
        IntentUtils.gotoActivity(mContext, QrqWbActivity.class, result);
        finish();
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        ToastUtils.toastShort("打开相机出错");
        finish();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mZxingView.startCamera();
        mZxingView.showScanRect();
        mZxingView.startSpot();
    }

    @Override
    protected void onStop() {
        mZxingView.stopCamera();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mZxingView.onDestroy();
        super.onDestroy();
    }
}
