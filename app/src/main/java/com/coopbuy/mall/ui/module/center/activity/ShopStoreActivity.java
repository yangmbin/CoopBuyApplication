package com.coopbuy.mall.ui.module.center.activity;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopStoreReponse;
import com.coopbuy.mall.api.request.ShopSotreCancelRequest;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ShopStoreAdapter;
import com.coopbuy.mall.ui.module.center.model.ShopStoreModel;
import com.coopbuy.mall.ui.module.center.presenter.ShopStorePresenter;
import com.coopbuy.mall.ui.module.center.view.ShopStore_IView;
import com.coopbuy.mall.ui.module.home.activity.ShopDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.yanzhenjie.recyclerview.swipe.SwipeItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.widget.DefaultItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ShopStoreActivity extends BaseActivity<ShopStorePresenter, ShopStoreModel> implements ShopStore_IView, SwipeItemClickListener, OnRefreshListener, OnLoadmoreListener {
    private List<ShopStoreReponse.ItemsBean> mData;
    @Bind(R.id.swip_recy)
    SwipeMenuRecyclerView mRecyclerView;
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    private ShopStoreAdapter mAdapter;
    private int mPagerIndex = 1;
    private ShopCurrentPageRequest request;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_store;
    }

    @Override
    public void initModel() {
        mModel = new ShopStoreModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new ShopStorePresenter(this, mModel, this);
        request = new ShopCurrentPageRequest();
        request.setCurrentPage(mPagerIndex);
        mPresenter.getOrderBuildData(request, "init");
    }

    @Override
    public void initView() {
        setTitle("店铺收藏");
        init();
    }

    private void init() {
        mData = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.addItemDecoration(new DefaultItemDecoration(ContextCompat.getColor(this, R.color.divider_color)));
        mAdapter = new ShopStoreAdapter(mData);
        mRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
        mRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
        // RecyclerView的Item的点击事件。
        mRecyclerView.setSwipeItemClickListener(this);

        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * 菜单创建器，在Item要创建菜单的时候调用。
     */
    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
        @Override
        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
            int width = getResources().getDimensionPixelSize(R.dimen.dimen_px160);
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            {
                SwipeMenuItem deleteItem = new SwipeMenuItem(ShopStoreActivity.this)
                        .setBackground(R.color.auxiliary_text_red)
                        .setText("取消收藏")
                        .setTextColor(Color.WHITE)
                        .setWidth(width)
                        .setHeight(height);
                swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。
            }
        }
    };

    /**
     * RecyclerView的Item的Menu点击监听。
     */
    private SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
        @Override
        public void onItemClick(SwipeMenuBridge menuBridge) {
            menuBridge.closeMenu();
            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
            int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
                ShopSotreCancelRequest request = new ShopSotreCancelRequest();
                request.setShopId(mData.get(adapterPosition).getShopId());
                mPresenter.shopStoreCancle(request, adapterPosition);
            }
        }
    };

    @Override
    public void onItemClick(View itemView, int position) {
        IntentUtils.gotoActivity(this, ShopDetailActivity.class, mData.get(position).getShopId());
    }

    @Override
    public void getShopStoreList(ShopStoreReponse reponse, String type) {
        stopRefresh();
        if (type.equals("more")) {
            mAdapter.addMore(reponse.getItems());
        } else {
            mAdapter.flesh(reponse.getItems());
        }
    }

    @Override
    public void shopStoreCancelSuccess(int postion) {
        mData.remove(postion);
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 停止刷新
     */
    @Override
    public void stopRefresh() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        ++mPagerIndex;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getOrderBuildData(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getOrderBuildData(request, "fresh");
    }
}
