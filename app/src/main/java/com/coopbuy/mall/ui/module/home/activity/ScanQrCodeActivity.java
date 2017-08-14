package com.coopbuy.mall.ui.module.home.activity;

import android.Manifest;
import android.os.Vibrator;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.List;

import butterknife.Bind;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ScanQrCodeActivity extends BaseActivity implements QRCodeView.Delegate, EasyPermissions.PermissionCallbacks {

    private static final int REQUEST_CODE_QRCODE_PERMISSIONS = 1;

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
        requestCodeQRCodePermissions();
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

    // 权限管理
    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @AfterPermissionGranted(REQUEST_CODE_QRCODE_PERMISSIONS)
    private void requestCodeQRCodePermissions() {
        String[] perms = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!EasyPermissions.hasPermissions(this, perms)) {
            EasyPermissions.requestPermissions(this, "扫描二维码需要打开相机和散光灯的权限", REQUEST_CODE_QRCODE_PERMISSIONS, perms);
        }
    }
}
