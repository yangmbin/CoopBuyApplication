package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.OrderDetailResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.OrderDetailAdapter;
import com.coopbuy.mall.ui.module.center.model.OrderDetailModel;
import com.coopbuy.mall.ui.module.center.presenter.OrderDetailPresenter;
import com.coopbuy.mall.ui.module.center.view.OrderDetail_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;

import butterknife.Bind;

public class OrderDetailActivity extends BaseActivity<OrderDetailPresenter, OrderDetailModel> implements OrderDetail_IView {
    @Bind(R.id.rv_goods_list)
    RecyclerView mRvGoodsList;
    private DelegateAdapter mDelegateAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_detail;
    }

    @Override
    public void initModel() {
        mModel = new OrderDetailModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderDetailPresenter(mContext, mModel, this);
        if (getIntent().getStringExtra(IntentUtils.PARAM1) == null)
            return;
        String orderId = getIntent().getStringExtra(IntentUtils.PARAM1);
        mPresenter.getOrderDetail(orderId);
    }

    @Override
    public void initView() {
        setTitle("订单详情");
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        manager.setAutoMeasureEnabled(true);
        manager.setNoScrolling(true);
        mRvGoodsList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvGoodsList.setAdapter(mDelegateAdapter);
    }

    @Override
    public void setOrderDetailData(OrderDetailResponse orderDetailResponse) {
        LinearLayoutHelper helper = new LinearLayoutHelper();
        helper.setDividerHeight(ScreenUtils.dp2px(mContext, 2));
        mDelegateAdapter.addAdapter(new OrderDetailAdapter(mContext, orderDetailResponse.getOrderItem(), helper));
    }
}
