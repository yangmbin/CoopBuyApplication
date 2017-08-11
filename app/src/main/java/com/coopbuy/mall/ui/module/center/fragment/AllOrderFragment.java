package com.coopbuy.mall.ui.module.center.fragment;

import android.support.v7.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.center.adapter.OrderAdapter;
import com.coopbuy.mall.ui.module.center.model.OrderModel;
import com.coopbuy.mall.ui.module.center.presenter.OrderPresenter;
import com.coopbuy.mall.ui.module.center.view.Order_IView;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 全部订单
 *
 * @author ymb
 *         Create at 2017/8/11 15:33
 */
public class AllOrderFragment extends ViewPagerBaseFragment<OrderPresenter, OrderModel> implements Order_IView {

    @Bind(R.id.rv_all_order)
    RecyclerView mRvAllOrder;

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private int currentPage = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_all;
    }

    @Override
    public void initModel() {
        mModel = new OrderModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderPresenter(mContext, mModel, this);
    }

    @Override
    protected void initView() {
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        manager.setAutoMeasureEnabled(true);
        mRvAllOrder.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvAllOrder.setAdapter(mDelegateAdapter);
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        mPresenter.getAllOrder(1);
    }

    @Override
    public void setAllOrderData(GetOrderListResponse orderListResponse) {
        if (orderListResponse == null)
            return;
        mAdapters.clear();
        for (int i = 0; i < orderListResponse.getItems().size(); i++) {
            List<GetOrderListResponse.ItemsBean> tmp = new LinkedList<>();
            tmp.add(orderListResponse.getItems().get(i));
            SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
            singleLayoutHelper.setMarginBottom(ScreenUtils.dip2px(mContext, 10));
            mAdapters.add(new OrderAdapter(mContext, tmp, singleLayoutHelper));
        }
        mDelegateAdapter.setAdapters(mAdapters);
    }
}
