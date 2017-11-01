package com.coopbuy.mall.ui.module.center.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ApplyRefundGoodsListAdapter;
import com.coopbuy.mall.ui.module.center.model.ApplyRefundModel;
import com.coopbuy.mall.ui.module.center.presenter.ApplyRefundPresenter;
import com.coopbuy.mall.ui.module.center.view.ApplyRefund_IView;
import com.coopbuy.mall.widget.ApplyRefundUploadView;
import com.coopbuy.mall.widget.dialog.BottomListDialog;
import com.coopbuy.mall.widget.dialog.SelectImageDialog;
import com.jph.takephoto.app.TakePhoto;
import com.jph.takephoto.app.TakePhotoActivity;
import com.jph.takephoto.app.TakePhotoImpl;
import com.jph.takephoto.compress.CompressConfig;
import com.jph.takephoto.model.InvokeParam;
import com.jph.takephoto.model.TContextWrap;
import com.jph.takephoto.model.TResult;
import com.jph.takephoto.permission.InvokeListener;
import com.jph.takephoto.permission.PermissionManager;
import com.jph.takephoto.permission.TakePhotoInvocationHandler;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class ApplyRefundActivity extends BaseActivity<ApplyRefundPresenter, ApplyRefundModel> implements ApplyRefund_IView, TakePhoto.TakeResultListener, InvokeListener {

    @Bind(R.id.goodsList)
    RecyclerView goodsList;
    @Bind(R.id.radioBtnRefund)
    LinearLayout radioBtnRefund;
    @Bind(R.id.radioBtnReturnGoods)
    LinearLayout radioBtnReturnGoods;
    @Bind(R.id.radioRefundSelected)
    ImageView radioRefundSelected;
    @Bind(R.id.radioReturnGoodsSelected)
    ImageView radioReturnGoodsSelected;
    @Bind(R.id.uploadView)
    ApplyRefundUploadView uploadView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_apply_refund;
    }

    @Override
    public void initModel() {
        mModel = new ApplyRefundModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new ApplyRefundPresenter(mContext, mModel, this);
    }

    @Override
    public void initView() {
        setTitle("申请退款");
        List list = new ArrayList();
        list.add(new Object());
        list.add(new Object());
        list.add(new Object());
        ApplyRefundGoodsListAdapter mAdapter = new ApplyRefundGoodsListAdapter(this, list);
        goodsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        goodsList.setAdapter(mAdapter);
        goodsList.setFocusable(false);

        // 初始化上传图片视图监听
        initUploadView();
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @OnClick({R.id.radioBtnRefund, R.id.radioBtnReturnGoods, R.id.selectRefundReasonBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radioBtnRefund:
                clickRefundBtn();
                break;
            case R.id.radioBtnReturnGoods:
                clickReturnGoodsBtn();
                break;
            case R.id.selectRefundReasonBtn:
                showReasonDialog();
                break;
        }
    }

    /**
     * 点击退款单选按钮
     */
    private void clickRefundBtn() {
        radioBtnRefund.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        radioBtnReturnGoods.setBackgroundResource(R.drawable.shape_gray_3_no_solid_bg);
        radioRefundSelected.setVisibility(View.VISIBLE);
        radioReturnGoodsSelected.setVisibility(View.INVISIBLE);
    }

    /**
     * 点击退款退货单选按钮
     */
    private void clickReturnGoodsBtn() {
        radioBtnRefund.setBackgroundResource(R.drawable.shape_gray_3_no_solid_bg);
        radioBtnReturnGoods.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        radioRefundSelected.setVisibility(View.INVISIBLE);
        radioReturnGoodsSelected.setVisibility(View.VISIBLE);
    }

    /**
     * 显示原因对话框
     */
    private void showReasonDialog() {
        List<String> list = new ArrayList();
        list.add("原因");
        list.add("原因");
        list.add("原因");
        list.add("原因");
        list.add("原因");
        BottomListDialog dialog = new BottomListDialog(mContext, list, new TextView(mContext));
        dialog.showAtBottom();
    }

    /**
     * 初始化图片上传视图
     */
    private void initUploadView() {
        uploadView.setSelectListener(new ApplyRefundUploadView.SelectListener() {
            @Override
            public void onSelect() {
                setCompressConfig(takePhoto);
                SelectImageDialog dialog = new SelectImageDialog(mContext, new SelectImageDialog.ClickCallBack() {
                    @Override
                    public void onTake() {
                        File file = new File(Environment.getExternalStorageDirectory(), "/temp/" + "upload_pic" + ".jpg");
                        if (!file.getParentFile().exists())
                            file.getParentFile().mkdirs();
                        Uri imageUri = Uri.fromFile(file);
                        takePhoto.onPickFromCapture(imageUri); // 拍照，不裁剪
                    }

                    @Override
                    public void onPick() {
                        takePhoto.onPickFromGallery(); // 单张选择图片，不裁剪
                    }
                });
                dialog.showBottomWindow();
            }
        });
    }


    /**
     * 上传图片成功
     * @param uploadImageResponse
     */
    @Override
    public void uploadImageSuccess(UploadImageResponse uploadImageResponse) {
        Log.e("yangmbin", "upload server path:" + uploadImageResponse.getFilePath());
    }

    /**
     * ===================================拍照/选择图片 功能相关接口重写方法===================================
     */
    private static final String TAG = TakePhotoActivity.class.getName();
    private TakePhoto takePhoto;
    private InvokeParam invokeParam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        getTakePhoto().onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        getTakePhoto().onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        getTakePhoto().onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.TPermissionType type = PermissionManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionManager.handlePermissionsResult(this, type, invokeParam, this);
    }

    public TakePhoto getTakePhoto() {
        if (takePhoto == null) {
            takePhoto = (TakePhoto) TakePhotoInvocationHandler.of(this).bind(new TakePhotoImpl(this, this));
        }
        return takePhoto;
    }

    @Override
    public PermissionManager.TPermissionType invoke(InvokeParam invokeParam) {
        PermissionManager.TPermissionType type = PermissionManager.checkPermission(TContextWrap.of(this), invokeParam.getMethod());
        if (PermissionManager.TPermissionType.WAIT.equals(type)) {
            this.invokeParam = invokeParam;
        }
        return type;
    }

    @Override
    public void takeSuccess(TResult result) {
        Log.e(TAG, "takeSuccess：" + result.getImage().getOriginalPath());
        Log.e(TAG, "takeSuccess：" + result.getImage().getCompressPath());
        //String imgPath = result.getImage().getOriginalPath(); // 原图路径
        String imgPath = result.getImage().getCompressPath(); // 压缩后路径
        // 上传图片
        UploadImageRequest request = new UploadImageRequest();
        request.setType(2);
        request.setImage(imgPath);
        mPresenter.uploadImage(request);
    }

    @Override
    public void takeFail(TResult result, String msg) {
        Log.e(TAG, "takeFail:" + msg);
    }

    @Override
    public void takeCancel() {
        Log.e(TAG, "取消");
    }

    private void setCompressConfig(TakePhoto takePhoto) {
        CompressConfig compressConfig = new CompressConfig.Builder().setMaxSize(480 * 480).setMaxPixel(360).create();
        takePhoto.onEnableCompress(compressConfig, false);
    }
    /** ===================================拍照/选择图片 功能相关接口重写方法=================================== */
}
