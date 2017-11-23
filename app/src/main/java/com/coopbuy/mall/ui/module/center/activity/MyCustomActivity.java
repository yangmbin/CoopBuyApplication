package com.coopbuy.mall.ui.module.center.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.MyCustomReponse;
import com.coopbuy.mall.api.request.MyCustomRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyCustomAdapter;
import com.coopbuy.mall.ui.module.center.model.MyCustomModel;
import com.coopbuy.mall.ui.module.center.port.FootMarkPort;
import com.coopbuy.mall.ui.module.center.presenter.MyCustomPresenter;
import com.coopbuy.mall.ui.module.center.view.MyCustom_IView;
import com.coopbuy.mall.utils.IntentUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class MyCustomActivity extends BaseActivity<MyCustomPresenter, MyCustomModel> implements FootMarkPort, MyCustom_IView, OnRefreshListener, OnLoadmoreListener {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    /**
     * 点击软键盘外 关闭键盘
     */
    @Bind(R.id.ll_close_keyboard)
    LinearLayout mColseKeyboard;
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.v_focus)
    View mFocus;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.edt_search)
    EditText edtSearch;
    private MyCustomAdapter adapter;
    private List<MyCustomReponse.ItemsBean> data;
    private MyCustomRequest request;
    private int mPagerIndex = 1;
    /**
     * 搜索关键字
     */
    private String keyWord = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_custom;
    }

    @Override
    public void initModel() {
        mModel = new MyCustomModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MyCustomPresenter(this, mModel, this);

    }

    @Override
    public void initView() {
        setTitle(getString(R.string.title_custom));
        setRightText(getString(R.string.lab_custom_add));
        initRey();
    }

    private void initRey() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new MyCustomAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    keyWord = editable.toString();
                    request.setKeyword(keyWord);
                    mPresenter.getData(request, "search");
                } else {
                    keyWord = "";
                    request.setKeyword(keyWord);
                    mPresenter.getData(request, "search");
                }
            }
        });

    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();
        IntentUtils.gotoActivity(this, AddCustomActivity.class, "add");
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(this, AddCustomActivity.class, data.get(postion), "edit");
    }

    @Override
    protected void onResume() {
        super.onResume();
        request = new MyCustomRequest();
        request.setCurrentPage(mPagerIndex);
        request.setKeyword(keyWord);
        mPresenter.getData(request, "init");
    }

    @Override
    public void getData(MyCustomReponse bean, String type) {
        if (type.equals("more")) {
            adapter.addMore(bean.getItems());
        } else {
            adapter.refresh(bean.getItems());
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        ++mPagerIndex;
        request.setKeyword(keyWord);
        request.setCurrentPage(mPagerIndex);
        mPresenter.getData(request, "more");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        mPagerIndex = 1;
        request.setKeyword(keyWord);
        request.setCurrentPage(mPagerIndex);
        mPresenter.getData(request, "fresh");
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
    public void onBackPressed() {
        super.onBackPressed();
        hideSoftKeyboard();
    }
}
