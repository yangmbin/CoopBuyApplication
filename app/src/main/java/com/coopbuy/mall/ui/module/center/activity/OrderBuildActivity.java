package com.coopbuy.mall.ui.module.center.activity;


import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.model.OrderBuildModel;
import com.coopbuy.mall.ui.module.center.presenter.OrderBuildPresenter;
import com.coopbuy.mall.ui.module.center.view.OrderBuild_IView;
import com.coopbuy.mall.utils.IntentUtils;

public class OrderBuildActivity extends BaseActivity<OrderBuildPresenter, OrderBuildModel> implements OrderBuild_IView {
    private OrderBuildRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_build;
    }

    @Override
    public void initModel() {
        mModel = new OrderBuildModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderBuildPresenter(this, mModel, this);
        mPresenter.getOrderBuildData(request);
    }

    @Override
    public void initView() {
        setTitle("订单确认");
        if (null != getIntent()) {
            request = (OrderBuildRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
        }
    }

    @Override
    public void getOrderBuildData(OrderBuildResponse data) {

    }
}
