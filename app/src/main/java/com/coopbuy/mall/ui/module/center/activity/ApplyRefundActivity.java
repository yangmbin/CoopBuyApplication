package com.coopbuy.mall.ui.module.center.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.BeforeApplyRefundResponse;
import com.coopbuy.mall.api.reponse.UploadImageResponse;
import com.coopbuy.mall.api.request.ApplyRefundRequest;
import com.coopbuy.mall.api.request.BeforeApplyRefundRequest;
import com.coopbuy.mall.api.request.UploadImageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.module.center.adapter.ApplyRefundGoodsListAdapter;
import com.coopbuy.mall.ui.module.center.model.ApplyRefundModel;
import com.coopbuy.mall.ui.module.center.presenter.ApplyRefundPresenter;
import com.coopbuy.mall.ui.module.center.view.ApplyRefund_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.utils.ToastUtils;
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
    @Bind(R.id.refund_amount)
    TextView refundAmount;
    @Bind(R.id.max_refund_amount)
    TextView maxRefundAmount;
    @Bind(R.id.refund_amount_bottom)
    TextView refundAmountBottom;
    @Bind(R.id.explain)
    EditText explain;
    @Bind(R.id.current_words)
    TextView currentWords;
    @Bind(R.id.apply_reason)
    TextView applyReason;

    private ApplyRefundGoodsListAdapter mAdapter;
    private List<BeforeApplyRefundResponse.ProductsBean> mProductList = new ArrayList<>();
    private List<String> mReasonList = new ArrayList<>();
    private List<String> mImageList = new ArrayList<>();
    private boolean isNeedReturnGoods; // 是否需要退货
    private String mOrderId;
    private int mSkuId = -1;

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
        BeforeApplyRefundRequest request = (BeforeApplyRefundRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
        mOrderId = request.getOrderId();
        mSkuId = request.getSkuId();
        mPresenter.beforeApplyRefund(request);
    }

    @Override
    public void initView() {
        setTitle("申请退款");
        mAdapter = new ApplyRefundGoodsListAdapter(this, mProductList);
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
        // 问题说明编辑框监听
        addTextChangedListener();
    }

    /**
     * 点击事件
     *
     * @param view
     */
    @OnClick({R.id.radioBtnRefund, R.id.radioBtnReturnGoods, R.id.selectRefundReasonBtn, R.id.submit_apply_refund})
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
            // 提交申请
            case R.id.submit_apply_refund:
                submitApplyRefund();
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
        isNeedReturnGoods = false;
    }

    /**
     * 点击退款退货单选按钮
     */
    private void clickReturnGoodsBtn() {
        radioBtnRefund.setBackgroundResource(R.drawable.shape_gray_3_no_solid_bg);
        radioBtnReturnGoods.setBackgroundResource(R.drawable.shape_orange_1_no_solid_bg);
        radioRefundSelected.setVisibility(View.INVISIBLE);
        radioReturnGoodsSelected.setVisibility(View.VISIBLE);
        isNeedReturnGoods = true;
    }

    /**
     * 显示原因对话框
     */
    private void showReasonDialog() {
        BottomListDialog dialog = new BottomListDialog(mContext, mReasonList, applyReason);
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
     * 设置问题说明监听
     */
    private void addTextChangedListener() {
        explain.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 0)
                    currentWords.setText("0字");
                else
                    currentWords.setText("-" + editable.length() + "字");
            }
        });
    }


    /**
     * 提交申请
     */
    private void submitApplyRefund() {
        if ("请选择".equals(applyReason.getText().toString().trim())) {
            ToastUtils.toastShort("请选择退款原因");
            return;
        }
        ApplyRefundRequest request = new ApplyRefundRequest();
        request.setIsNeedReturnGoods(isNeedReturnGoods);
        request.setReason(applyReason.getText().toString().trim());
        request.setExplain(explain.getText().toString().trim());
        request.setVoucherImageUrls(mImageList);
        request.setSkuId(mSkuId);
        request.setOrderId(mOrderId);
        mPresenter.submitApplyRefund(request);
    }


    /**
     * 初次进入页面，设置数据
     *
     * @param beforeApplyRefundResponse
     */
    @Override
    public void setBeforeApplyRefundData(BeforeApplyRefundResponse beforeApplyRefundResponse) {
        // 申请售后商品列表
        mProductList.clear();
        mProductList.addAll(beforeApplyRefundResponse.getProducts());
        mAdapter.notifyDataSetChanged();

        // 是否可退货
        clickRefundBtn();
        if (!beforeApplyRefundResponse.isCanReturnProduct()) {
            radioBtnReturnGoods.setVisibility(View.GONE);
        }

        // 退款原因
        mReasonList.add("haha");
        mReasonList.add("heihei");

        // 退款金额
        refundAmount.setText("¥" + StringUtils.keepTwoDecimalPoint(beforeApplyRefundResponse.getRefundAmount()));
        maxRefundAmount.setText("最多¥" + StringUtils.keepTwoDecimalPoint(beforeApplyRefundResponse.getRefundAmount()));
        refundAmountBottom.setText("¥" + StringUtils.keepTwoDecimalPoint(beforeApplyRefundResponse.getRefundAmount()));
    }

    /**
     * 上传图片成功
     *
     * @param uploadImageResponse
     */
    @Override
    public void uploadImageSuccess(UploadImageResponse uploadImageResponse) {
        Log.e("yangmbin", "upload server path:" + uploadImageResponse.getFilePath());
    }

    /**
     * 提交申请成功
     */
    @Override
    public void submitApplyRefundSuccess() {
        IntentUtils.gotoMainActivity(mContext, MainActivity.class, MainActivity.CENTER_FRAGMENT_INDEX);
        IntentUtils.gotoActivity(mContext, AfterSalesActivity.class);
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
