package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.IncomeAdapter;
import com.coopbuy.mall.ui.module.center.adapter.PayAntherAdapter;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * @author niu
 * @time 2017/11/13 15:33
 * @content 代付
 */
public class PayAnotherActivity extends BaseActivity implements FootMarkPort {
    @Bind(R.id.recView)
    RecyclerView recView;
    private PayAntherAdapter adapter;
    private List<MessageCenterResponse> data;


    @Override
    public int getLayoutId() {
        return R.layout.activity_pay_another;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        setTitle("代付申请");
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        adapter = new PayAntherAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    @Override
    public void openDetial(int postion) {

    }
}
