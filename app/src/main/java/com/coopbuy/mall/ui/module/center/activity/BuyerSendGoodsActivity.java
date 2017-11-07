package com.coopbuy.mall.ui.module.center.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShippingCompanyResponse;
import com.coopbuy.mall.api.request.BuyerSendGoodsRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.BuyerSendGoodsModel;
import com.coopbuy.mall.ui.module.center.presenter.BuyerSendGoodsPresenter;
import com.coopbuy.mall.ui.module.center.view.BuyerSendGoods_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.BottomListDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class BuyerSendGoodsActivity extends BaseActivity<BuyerSendGoodsPresenter, BuyerSendGoodsModel> implements BuyerSendGoods_IView {

    @Bind(R.id.company_name)
    TextView companyName;
    @Bind(R.id.return_remark)
    EditText returnRemark;
    @Bind(R.id.waybill_no)
    EditText waybillNo;
    private String mApplyNo;
    private BottomListDialog mBottomListDialog;
    private List<ShippingCompanyResponse> mShippingCompanyResponseList;
    private List<String> mShippingCompanyList = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_buyer_send_goods;
    }

    @Override
    public void initModel() {
        mModel = new BuyerSendGoodsModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new BuyerSendGoodsPresenter(mContext, mModel, this);
        mPresenter.getShippingCampanyList();
    }

    @Override
    protected void networkRetry() {
        mPresenter.getShippingCampanyList();
    }

    @Override
    public void initView() {
        setTitle("退货信息");
        mApplyNo = getIntent().getStringExtra(IntentUtils.PARAM1);
    }

    @OnClick({R.id.selectExpressBtn, R.id.submit})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            // 选择物流公司
            case R.id.selectExpressBtn:
                showExpressDialog();
                break;
            // 提交
            case R.id.submit:
                submit();
                break;
        }
    }

    /**
     * 提交
     */
    private void submit() {
        if (mBottomListDialog.getCurrentIndex() == -1) {
            ToastUtils.toastShort("请选择物流公司");
            return;
        }
        if (TextUtils.isEmpty(waybillNo.getText().toString().trim())) {
            ToastUtils.toastShort("请填写物流单号");
            return;
        }
        BuyerSendGoodsRequest request = new BuyerSendGoodsRequest();
        request.setWaybillNo(waybillNo.getText().toString().trim());
        request.setShippingCompany(mShippingCompanyResponseList.get(mBottomListDialog.getCurrentIndex()).getName());
        request.setCompanyCode(mShippingCompanyResponseList.get(mBottomListDialog.getCurrentIndex()).getCode());
        request.setReturnRemark(returnRemark.getText().toString().trim());
        request.setApplyNo(mApplyNo);
        mPresenter.sendGoods(request);
    }

    /**
     * 显示物流公司列表
     */
    private void showExpressDialog() {
        mBottomListDialog = new BottomListDialog(mContext, mShippingCompanyList, companyName);
        mBottomListDialog.showAtBottom();
    }

    /**
     * 设置物流公司列表
     *
     * @param shippingCompanyResponseList
     */
    @Override
    public void setShippingCompanyList(List<ShippingCompanyResponse> shippingCompanyResponseList) {
        mShippingCompanyResponseList = shippingCompanyResponseList;
        for (int i = 0; i < shippingCompanyResponseList.size(); i++) {
            mShippingCompanyList.add(shippingCompanyResponseList.get(i).getName());
        }
    }

    /**
     * 买家寄货成功回调
     */
    @Override
    public void sendGoodsSuccess() {
        IntentUtils.gotoActivityWithClearTop(mContext, AfterSalesDetailActivity.class);
    }
}
