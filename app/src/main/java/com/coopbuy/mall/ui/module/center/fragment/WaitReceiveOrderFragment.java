package com.coopbuy.mall.ui.module.center.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.login.GetOrderListResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.center.activity.OrderDetailActivity;
import com.coopbuy.mall.ui.module.center.adapter.OrderAdapter_1;
import com.coopbuy.mall.ui.module.center.adapter.OrderAdapter_2;
import com.coopbuy.mall.ui.module.center.adapter.OrderAdapter_3;
import com.coopbuy.mall.ui.module.center.model.OrderModel;
import com.coopbuy.mall.ui.module.center.presenter.OrderPresenter;
import com.coopbuy.mall.ui.module.center.view.Order_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 待收货订单
 * @author ymb
 * Create at 2017/8/11 15:34
 */
public class WaitReceiveOrderFragment extends ViewPagerBaseFragment<OrderPresenter, OrderModel> implements Order_IView, OnRefreshLoadmoreListener {

    @Bind(R.id.rv_order)
    RecyclerView mRvOrder;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private int currentPage = 1;
    private int firstPage = 1;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order_wait_receive;
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
        mRvOrder.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvOrder.setAdapter(mDelegateAdapter);

        // 刷新监听
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        mPresenter.getWaitReceiveOrder(firstPage, OrderPresenter.LOAD_TYPE_1);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPresenter.getWaitReceiveOrder(currentPage + 1, OrderPresenter.LOAD_TYPE_3);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPresenter.getWaitReceiveOrder(firstPage, OrderPresenter.LOAD_TYPE_2);
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        mPresenter.getWaitReceiveOrder(firstPage, OrderPresenter.LOAD_TYPE_1);
    }

    @Override
    public void stopRefreshLayoutLoading() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    private View.OnClickListener getOrderItemClickListener(final String orderId) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentUtils.gotoActivity(mContext, OrderDetailActivity.class, orderId);
            }
        };
    }

    @Override
    public void setOrderData(GetOrderListResponse orderListResponse, int loadType) {
        if (orderListResponse == null)
            return;
        if (loadType == OrderPresenter.LOAD_TYPE_1 || loadType == OrderPresenter.LOAD_TYPE_2) {
            mAdapters.clear();
            currentPage = 1;
        } else {
            if (currentPage < orderListResponse.getPageCount())
                currentPage++;
        }
        for (int i = 0; i < orderListResponse.getItems().size(); i++) {
            // 订单项类型1
            List<GetOrderListResponse.ItemsBean> tmp_1 = new LinkedList<>();
            tmp_1.add(orderListResponse.getItems().get(i));
            SingleLayoutHelper helper_1 = new SingleLayoutHelper();
            mAdapters.add(new OrderAdapter_1(mContext, tmp_1, helper_1, getOrderItemClickListener(orderListResponse.getItems().get(i).getOrderId())));

            // 订单项类型2
            LinearLayoutHelper helper_2 = new LinearLayoutHelper();
            helper_2.setDividerHeight(ScreenUtils.dp2px(mContext, 2));
            mAdapters.add(new OrderAdapter_2(mContext, orderListResponse.getItems().get(i).getOrderItem(), helper_2, getOrderItemClickListener(orderListResponse.getItems().get(i).getOrderId())));

            // 订单项类型3
            List<GetOrderListResponse.ItemsBean> tmp_3 = new LinkedList<>();
            tmp_3.add(orderListResponse.getItems().get(i));
            SingleLayoutHelper helper_3 = new SingleLayoutHelper();
            helper_3.setMarginBottom(ScreenUtils.dip2px(mContext, 10));
            mAdapters.add(new OrderAdapter_3(mContext, tmp_3, helper_3, getOrderItemClickListener(orderListResponse.getItems().get(i).getOrderId())));
        }
        mDelegateAdapter.setAdapters(mAdapters);
    }
}
