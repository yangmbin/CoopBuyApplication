package com.coopbuy.mall.ui.module.test.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.ui.module.test.adapter.TestAdapter;
import com.coopbuy.mall.ui.module.test.model.NiuTestModel;
import com.coopbuy.mall.ui.module.test.port.ClickPort;
import com.coopbuy.mall.ui.module.test.presenter.NiuTestPresenter;
import com.coopbuy.mall.ui.module.test.view.NiuTest_IView;
import com.coopbuy.mall.utils.ToastUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class NiuTestActivity extends BaseActivity<NiuTestPresenter, NiuTestModel> implements BaseRecyclerAdapter.OnItemClickListener, ClickPort, NiuTest_IView {
    @Bind(R.id.refresh_layout)
    TwinklingRefreshLayout mRefreshLayout;
    @Bind(R.id.rv_test)
    RecyclerView mRvTest;
    @Bind(R.id.tv_result)
    TextView mTvResult;

    private TestAdapter mAdapter;

    private String[] mData;
    private List<String> mListData;
    private String mTemp = "";


    @Override
    public int getLayoutId() {
        return R.layout.activity_test2;
    }

    @Override
    public void initModel() {
        mModel = new NiuTestModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new NiuTestPresenter(this, mModel, this);
    }

    @Override
    public void initView() {

        mData = new String[]{"登录", "注册", "忘记密码", "修改密码", "图形验证", "首页", "分类", "搜索"};
        mListData = new ArrayList<>();
        mRefreshLayout.setEnableLoadmore(false);
        mRefreshLayout.setEnableRefresh(false);
        setData();
        mAdapter = new TestAdapter(this, mListData, this);
        mAdapter.setOnItemClickListener(this);
        mRvTest.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRvTest.setAdapter(mAdapter);
    }

    private void setData() {
        for (int i = 0; i < mData.length; i++) {
            mListData.add(mData[i]);
        }
    }

    @Override
    public void onItemClick(View itemView, int pos) {
        mPresenter.sendRequest(mListData.get(pos));
    }

    @Override
    public void getPosition(int position) {
        ToastUtils.toastShort(mListData.get(position) + "查看");
    }

    @Override
    public void showData(Object object) {
        mTvResult.setText((String) object);
    }
}
