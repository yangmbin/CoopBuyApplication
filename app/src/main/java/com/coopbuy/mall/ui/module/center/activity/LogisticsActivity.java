package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.LogisticsAdapter;
import com.coopbuy.mall.ui.module.center.model.LogisticsModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.LogisticsPresenter;
import com.coopbuy.mall.ui.module.center.view.Logistics_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class LogisticsActivity extends BaseActivity<LogisticsPresenter, LogisticsModel> implements Logistics_IView, FootMarkPort {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private LogisticsAdapter adapter;
    private List<MessageCenterResponse> data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_logistics;
    }

    @Override
    public void initModel() {
        mModel = new LogisticsModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new LogisticsPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        setTitle("物流信息");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        setData();
        adapter = new LogisticsAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    private void setData() {
        for (int i = 0; i < 4; i++) {
            MessageCenterResponse d = new MessageCenterResponse();
            d.setDetail("ssssdf" + i);
            if (i == 0)
                d.setName("悟空物流");
            if (i == 1)
                d.setName("八戒物流");
            if (i == 2)
                d.setName("沙僧物流");
            if (i > 2)
                d.setName("other物流" + i);
            d.setTime("2012." + i);
            d.setType(i);
            data.add(d);
        }
    }

    @Override
    public void openDetial(int postion) {
        ToastUtils.toastLong("差订单id");
        IntentUtils.gotoActivity(this, ExpressInfoActivity.class);
    }
}
