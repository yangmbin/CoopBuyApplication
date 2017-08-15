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
        mData = new String[]{"登录", "获取图形验证码", "获取短信验证码", "注册用户", "忘记密码获取短信", "退出登录", "修改密码", "首页", "获取站长推荐商品", "首页banner图点击进入", "首页点击（圆形图标）数据", "获取默认收货地址", "获取用户收货地址列表", "获取行政区数", "根据区域id获取名称", "通过行政区域id获取站长列表信息", "新建收货地址", "删除收货地址", "修改收货地址", "设置默认收货地址",
                "代付款 待处理 付款数量", "获取各订单数量", "商品详情添加商品到购物车", "购物车列表", "购物车商品数量更新", "购物车商品删除",
                "购物车提交订单 订单确认", "购物车订单确认 商品运费 同时也是修改数量的接口", "购物车订单提交  创建新订单", "商品详情描述", "用户商品详情获取商品信息",
                "获取店铺信息", "得到最新评论", "单个商品运费", "App更新", "创建话费订单", "电话 充值  的列表", "话费充值", "支付通道申请", "电话订单确认", "获取各订单数量", "订单列表",
                "代付款订单", "待发货", "待收货", "待评价", "订单详情", "帮助中心", "退货流程", "网站订单", "获取用户信息", "修改用户昵称", "修改性别",
                "意见反馈", "分类", "搜索", "获取活动页面N", "获取sku库N", "设置用户头像N", "添加商品评论N", "通过商品id得到评论列表N",
                "追加评论N", "银行卡列表N", "银行卡绑定申请N", "银行卡绑定N", "支付应用申请N", "协议支付N", "充值查询N", "订单删除N", "订单取消N", "签收订单N", "延迟收货N",
                "获取订单物流信息N", "新售后申请N",
                "更改售后申请N", "添加退货信息N", "退款售后列表N", "退款售后明细N", "退款申请确定N", "获取分类中首条文本内容信息", "站长代付申请N", "拒绝代付N",
                "代付款得到申请列表N", "获取申请详细信息N", "待处理代付数量获取N", "用户收货相关信息，若存在记录则进行收货信息更新N", "站点用户获取我的站点信息N", "获取当前站长用户所在站点的客户列表N",
                "获取站点客户信息N", "获取站点客户信息N", "更新站点客户信息N", "添加商品至站长推荐N", "得到站点信息和站点联系人信息N", "站长客户订单列表N"};
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
