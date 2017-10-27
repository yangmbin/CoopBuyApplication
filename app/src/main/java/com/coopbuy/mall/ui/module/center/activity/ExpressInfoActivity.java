package com.coopbuy.mall.ui.module.center.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ExpressInfoResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ExpressInfoListAdapter;
import com.coopbuy.mall.ui.module.center.model.ExpressInfoModel;
import com.coopbuy.mall.ui.module.center.presenter.ExpressInfoPresenter;
import com.coopbuy.mall.ui.module.center.view.ExpressInfo_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ExpressInfoActivity extends BaseActivity<ExpressInfoPresenter, ExpressInfoModel> implements ExpressInfo_IView {

    @Bind(R.id.expressList)
    RecyclerView expressList;
    @Bind(R.id.productImage)
    SimpleDraweeView productImage;
    @Bind(R.id.statusName)
    TextView statusName;
    @Bind(R.id.shippingCompany)
    TextView shippingCompany;
    @Bind(R.id.waybillNo)
    TextView waybillNo;
    private ExpressInfoListAdapter mAdapter;
    private List<ExpressInfoResponse.NodesBean> mDatas = new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_express_info;
    }

    @Override
    public void initModel() {
        mModel = new ExpressInfoModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new ExpressInfoPresenter(mContext, mModel, this);
        mPresenter.getExpressInfo(getIntent().getStringExtra(IntentUtils.PARAM1));
    }

    @Override
    public void initView() {
        setTitle("物流详情");
        mAdapter = new ExpressInfoListAdapter(this, mDatas);
        expressList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        expressList.setAdapter(mAdapter);
        expressList.setFocusable(false);
    }

    @Override
    public void setExpressInfo(ExpressInfoResponse expressInfoResponse) {
        productImage.setImageURI(Uri.parse(expressInfoResponse.getProductImageUrl()));
        statusName.setText("物流状态：" + expressInfoResponse.getStatusName());
        shippingCompany.setText("承运来源：" + expressInfoResponse.getShippingCompany());
        waybillNo.setText("运单编号：" + expressInfoResponse.getWaybillNo());

        mDatas.clear();
        mDatas.addAll(expressInfoResponse.getNodes());
        mAdapter.notifyDataSetChanged();
    }

}
