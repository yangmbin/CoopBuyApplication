package com.coopbuy.mall.ui.module.test.activity;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.ui.module.test.adapter.TestAdapter;
import com.coopbuy.mall.ui.module.test.adapter.TestParamsAdapter;
import com.coopbuy.mall.ui.module.test.model.NiuTestModel;
import com.coopbuy.mall.ui.module.test.port.ClickPort;
import com.coopbuy.mall.ui.module.test.presenter.NiuTestPresenter;
import com.coopbuy.mall.ui.module.test.view.NiuTest_IView;
import com.coopbuy.mall.utils.PicCodeUtil;
import com.coopbuy.mall.utils.ToastUtils;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class NiuTestActivity extends BaseActivity<NiuTestPresenter, NiuTestModel> implements BaseRecyclerAdapter.OnItemClickListener, ClickPort, NiuTest_IView {
    //是否是添加参数
    public static Boolean isAddParams = false;

    @Bind(R.id.refresh_layout)
    TwinklingRefreshLayout mRefreshLayout;
    @Bind(R.id.rv_test)
    RecyclerView mRvTest;
    @Bind(R.id.tv_result)
    TextView mTvResult;
    @Bind(R.id.tv_hint)
    TextView mTvHint;
    @Bind(R.id.iv_code)
    ImageView mIvCode;
    @Bind(R.id.rv_parms)
    RecyclerView mRvParms;

    private TestAdapter mAdapter;
    private TestParamsAdapter mParamsAdapter;

    private String[] mData;
    private List<String> mListData;
    private String mTemp = "";
    private String mTempParams = "";
    private List<Object> mParamObject;


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
        mParamObject = new ArrayList<>();
        mData = new String[]{"登录", "获取图形验证码", "获取短信验证码", "注册用户", "忘记密码获取短信", "退出登录", "修改密码", "首页", "分类", "搜索"};
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

    private void getObjectParams(Object object, List<String> params) {
        Class modelclass = object.getClass();
        Field[] fields = modelclass.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                params.add(f.getName());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onItemClick(View itemView, int pos) {
        mTemp = mListData.get(pos);
        if (!mTemp.equals(mTempParams)) {
            if (!mParamObject.isEmpty())
                mParamObject.clear();
        }
        mPresenter.sendRequest(mTemp, mParamObject);

    }

    @Override
    public void getPosition(int position, String portName) {
        mTempParams = portName;
        List<String> mParams = new ArrayList<>();
        if (mParamObject.isEmpty()) {
            mTvHint.setVisibility(View.VISIBLE);
            mTvHint.setText("请访问对应的接口生成参数再试");
            mRvParms.setVisibility(View.GONE);
            mTvResult.setVisibility(View.GONE);
            mIvCode.setVisibility(View.GONE);
            return;
        }
        if (!mTemp.equals(portName)) { //不是同一个接口
            if (!mParamObject.isEmpty()) {
                mParamObject.clear();
                mTvHint.setText("请访问对应的接口生成参数再试");
                mRvParms.setVisibility(View.GONE);
                mTvResult.setVisibility(View.GONE);
                mIvCode.setVisibility(View.GONE);
                mTvHint.setVisibility(View.VISIBLE);
                return;
            }
        } else {
            mRvParms.setVisibility(View.VISIBLE);
            mTvHint.setVisibility(View.GONE);
        }
        isAddParams = true;
        getObjectParams(mParamObject.get(0), mParams);
        mParamsAdapter = new TestParamsAdapter(this, mParams, this, mParamObject.get(0));
        mRvParms.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        mRvParms.setAdapter(mParamsAdapter);
        //查看参数隐藏
        mTvResult.setVisibility(View.GONE);
        mIvCode.setVisibility(View.GONE);
    }

    @Override
    public void showData(Object object) {
        if (object != null) {
            mTvResult.setText((String) object);
            mTvResult.setVisibility(View.VISIBLE);
            mTvHint.setVisibility(View.GONE);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void showImageCode(String code) {
        mIvCode.setVisibility(View.VISIBLE);
        mTvHint.setVisibility(View.GONE);
        mIvCode.setBackground(PicCodeUtil.byteToDrawable(code));
    }
}
