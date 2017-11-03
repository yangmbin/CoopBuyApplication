package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AfterSalesResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesAdapter_1;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesAdapter_2;
import com.coopbuy.mall.ui.module.center.adapter.AfterSalesAdapter_3;
import com.coopbuy.mall.ui.module.center.model.AfterSalesModel;
import com.coopbuy.mall.ui.module.center.presenter.AfterSalesPresenter;
import com.coopbuy.mall.ui.module.center.view.AfterSales_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ScreenUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 售后列表
 *
 * @author ymb
 *         Create at 2017/10/18 15:36
 */
public class AfterSalesActivity extends BaseActivity<AfterSalesPresenter, AfterSalesModel> implements AfterSales_IView, OnRefreshLoadmoreListener {

    @Bind(R.id.rv_order)
    RecyclerView mRvOrder;
    @Bind(R.id.refresh_layout)
    SmartRefreshLayout mRefreshLayout;

    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    private int currentPage = 1;

    @Override
    public int getLayoutId() {
        return R.layout.activity_after_sales;
    }

    @Override
    public void initModel() {
        mModel = new AfterSalesModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AfterSalesPresenter(mContext, mModel, this);
        getAfterSalesList(AfterSalesPresenter.LOAD_TYPE_1);
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        getAfterSalesList(AfterSalesPresenter.LOAD_TYPE_3);
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        getAfterSalesList(AfterSalesPresenter.LOAD_TYPE_2);
    }

    @Override
    protected void networkRetry() {
        getAfterSalesList(AfterSalesPresenter.LOAD_TYPE_1);
    }

    /**
     * 获取数据
     *
     * @param loadType
     */
    private void getAfterSalesList(int loadType) {
        int tempPage;
        if (loadType == AfterSalesPresenter.LOAD_TYPE_1 || loadType == AfterSalesPresenter.LOAD_TYPE_2) {
            currentPage = 1;
            tempPage = currentPage;
        } else {
            tempPage = currentPage + 1;
        }
        mPresenter.getAfterSalesList(tempPage, loadType);
    }

    @Override
    public void initView() {
        setTitle("售后");

        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        manager.setAutoMeasureEnabled(true);
        mRvOrder.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        mRvOrder.setAdapter(mDelegateAdapter);

        // 刷新监听
        mRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void stopRefreshLayoutLoading() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    /**
     * 列表条目点击监听
     */
    private View.OnClickListener getItemClickListener(final String applyNo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentUtils.gotoActivity(mContext, AfterSalesDetailActivity.class, applyNo);
            }
        };
    }

    /**
     * 网络数据返回回显
     *
     * @param afterSalesResponse
     */
    @Override
    public void setAfterSalesList(AfterSalesResponse afterSalesResponse) {
        if (currentPage == 1) {
            mAdapters.clear();
        } else {
            if (afterSalesResponse.getItems().size() != 0)
                currentPage++;
        }

        for (int i = 0; i < afterSalesResponse.getItems().size(); i++) {
            //1
            List list1 = new ArrayList();
            list1.add(afterSalesResponse.getItems().get(i));
            mAdapters.add(new AfterSalesAdapter_1(mContext, list1, new SingleLayoutHelper(), getItemClickListener(afterSalesResponse.getItems().get(i).getApplyNo())));

            //2
            LinearLayoutHelper helper2 = new LinearLayoutHelper();
            helper2.setDividerHeight(ScreenUtils.dip2px(mContext, 2));
            mAdapters.add(new AfterSalesAdapter_2(mContext, afterSalesResponse.getItems().get(i).getProducts(), new LinearLayoutHelper(), getItemClickListener(afterSalesResponse.getItems().get(i).getApplyNo())));

            //3
            SingleLayoutHelper helper3 = new SingleLayoutHelper();
            helper3.setMarginBottom(ScreenUtils.dip2px(mContext, 8));
            List list3 = new ArrayList();
            list3.add(afterSalesResponse.getItems().get(i));
            mAdapters.add(new AfterSalesAdapter_3(mContext, list3, helper3, getItemClickListener(afterSalesResponse.getItems().get(i).getApplyNo())));
        }

        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }
}
