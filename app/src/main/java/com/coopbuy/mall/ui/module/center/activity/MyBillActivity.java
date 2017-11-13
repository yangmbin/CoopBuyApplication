package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MessageCenterResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.LogisticsAdapter;
import com.coopbuy.mall.ui.module.center.adapter.MyBillAdapter;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.popwindow.CustomPopWindow;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MyBillActivity extends BaseActivity implements FootMarkPort, View.OnClickListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.recView)
    RecyclerView recView;
    private CustomPopWindow popWindow;
    private MyBillAdapter adapter;
    private List<MessageCenterResponse> data;

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_bill;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void clickTitleBarRight(View v) {
        super.clickTitleBarRight(v);
        showPopBottom(v);
    }

    @Override
    public void initView() {
        setTitle(R.string.title_bill);
        setRightText(R.string.lab_bill_filter);
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        setData();
        adapter = new MyBillAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }


    private void showPopBottom(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.popuwindow_dialog_bill, null);
        view.findViewById(R.id.tv_all).setOnClickListener(this);
        view.findViewById(R.id.tv_pended).setOnClickListener(this);
        view.findViewById(R.id.tv_pending).setOnClickListener(this);
        view.findViewById(R.id.tv_sended).setOnClickListener(this);
        view.findViewById(R.id.tv_sending).setOnClickListener(this);
        popWindow = new CustomPopWindow.PopupWindowBuilder(this)
                .setView(view)
                .setFocusable(true)
                 .create();
        popWindow.showAsDropDown(v, 0, -25);
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                ToastUtils.toastShort("全部");
                break;
            case R.id.tv_pending:
                ToastUtils.toastShort("待审核");
                break;
            case R.id.tv_pended:
                ToastUtils.toastShort("已审核");
                break;
            case R.id.tv_sended:
                ToastUtils.toastShort("已发送");
                break;
            case R.id.tv_sending:
                ToastUtils.toastShort("待发送");
                break;
        }
        popWindow.dissmiss();
    }
}
