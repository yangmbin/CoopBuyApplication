package com.coopbuy.mall.ui.module.center.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.api.request.ShopCurrentPageRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.FootMarkAdapter;
import com.coopbuy.mall.ui.module.center.model.FootMarkModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.FootMarkPresenter;
import com.coopbuy.mall.ui.module.center.view.FootMark_IView;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.NormalDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FootMarkActivity extends BaseActivity<FootMarkPresenter, FootMarkModel> implements FootMark_IView, OnRefreshListener, OnLoadmoreListener, FootMarkPort {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.txt_titlebar_right)
    TextView tvRight;
    @Bind(R.id.tv_select_all)
    TextView ivSelectAll;
    @Bind(R.id.rl_select_delete)
    RelativeLayout rlSelectDelete;
    @Bind(R.id.box)
    LinearLayout box;

    private List<FootMarkResponse.ItemsBean.ProductsBean> data;
    private FootMarkAdapter adapter;
    private ShopCurrentPageRequest request;
    private int mPagerIndex = 1;
    /**
     * 是否全选
     */
    private boolean mSelect = false;
    /**
     * 是否处于编辑状态
     */
    public static boolean isEdit = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_foot_mark;
    }

    @Override
    public void initModel() {
        mModel = new FootMarkModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new FootMarkPresenter(this, mModel, this);
        request = new ShopCurrentPageRequest();
        request.setCurrentPage(1);
        mPresenter.getOrderBuildData(request, "init");
    }

    @Override
    public void initView() {
        rlSelectDelete.setVisibility(View.GONE);
        setTitle("足迹");
        setRightText("编辑");
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        data = new ArrayList<>();
        adapter = new FootMarkAdapter(data, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return data.get(pos).getTime();
            }
        };

        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int pos) {
                final View headView = LayoutInflater.from(FootMarkActivity.this).inflate(R.layout.decoration_station_head_view, null);
                final TextView tiem = (TextView) headView.findViewById(R.id.tv_time);
                if (!data.isEmpty())
                    tiem.setText(data.get(pos).getTime());
                return headView;
            }
        });
        recView.addItemDecoration(decoration);
        recView.setLayoutManager(manager);
        recView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();
        String right = tvRight.getText().toString().trim();
        if (right.equals("编辑")) {
            setRightText("完成");
            isEdit = true;
            box.setPadding(0, 0, 0, (int) this.getResources().getDimension(R.dimen.dimen_px96));
            rlSelectDelete.setVisibility(View.VISIBLE);
        } else {
            isEdit = false;
            rlSelectDelete.setVisibility(View.GONE);
            setRightText("编辑");
            box.setPadding(0, 0, 0, 0);
        }
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getFootMarkData(FootMarkResponse response, String type) {
        List<FootMarkResponse.ItemsBean.ProductsBean> netData = new ArrayList<>();
        for (int i = 0; i < response.getItems().size(); i++) {
            for (int j = 0; j < response.getItems().get(i).getProducts().size(); j++) {
                FootMarkResponse.ItemsBean.ProductsBean bean = response.getItems().get(i).getProducts().get(j);
                bean.setTime(response.getItems().get(i).getDate());
                if (mSelect) {
                    bean.setSelect(true);
                } else {
                    bean.setSelect(false);
                }
                netData.add(bean);
            }
        }

        if (!type.equals("add")) {
            adapter.flesh(netData);
        } else {
            adapter.addData(netData);
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        mPagerIndex++;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getOrderBuildData(request, "add");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getOrderBuildData(request, "flesh");
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

    @OnClick({R.id.ll_select_all, R.id.tv_delete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_select_all:
                setAllSelect();
                break;
            case R.id.tv_delete:

                break;
        }
    }

    /**
     * 全选监听处理
     */
    private void setAllSelect() {
        mSelect = !mSelect;
        if (mSelect) {
            ivSelectAll.setBackgroundResource(R.mipmap.icon_address_checked);
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setSelect(true);
            }
        } else {
            ivSelectAll.setBackgroundResource(R.mipmap.icon_address_unchecked);
            for (int i = 0; i < data.size(); i++) {
                data.get(i).setSelect(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(this, GoodsDetailActivity.class, data.get(postion).getSkuId());
    }
}
