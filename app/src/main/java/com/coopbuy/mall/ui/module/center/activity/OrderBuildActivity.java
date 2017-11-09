package com.coopbuy.mall.ui.module.center.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.reponse.OrderBuildResponse;
import com.coopbuy.mall.api.request.OrderBuildRequest;
import com.coopbuy.mall.api.request.OrderSubmitRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.MainEvent;
import com.coopbuy.mall.ui.module.center.adapter.OrderBuildAdapter;
import com.coopbuy.mall.ui.module.center.model.OrderBuildModel;
import com.coopbuy.mall.ui.module.center.pay.NewPayWindowActivity;
import com.coopbuy.mall.ui.module.center.presenter.OrderBuildPresenter;
import com.coopbuy.mall.ui.module.center.view.OrderBuild_IView;
import com.coopbuy.mall.utils.IntentUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class OrderBuildActivity extends BaseActivity<OrderBuildPresenter, OrderBuildModel> implements OrderBuild_IView, View.OnClickListener {
    @Bind(R.id.l_pay)
    LinearLayout lPay;
    private OrderBuildRequest request;
    @Bind(R.id.swipe_target)
    RecyclerView mMainRecycleView;
    /**
     * 商品件数
     */
    @Bind(R.id.m_tv_counts)
    TextView mTvCounts;
    /**
     * 商品合计
     */
    @Bind(R.id.tv_shopcart_totalprice)
    TextView tvShopcartTotalprice;
    private OrderBuildResponse response;
    /**
     * 收货人
     */
    private TextView mConsignee;
    /**
     * 电话
     */
    private TextView mConsigneePhone;
    /**
     * 站长地址
     */
    private TextView mStationName;
    /**
     * 地址
     */
    private TextView mConsigneeAddress;
    /**
     * 添加的底部控件
     */
    private LinearLayout childRecy;
    /**
     * 有地址
     */
    private LinearLayout mHaveAddress;
    /**
     * 无地址
     */
    private LinearLayout mNoAddress;
    /**
     * 发票
     */
    private LinearLayout mReceipt;
    /**
     * 头部
     */
    private LinearLayout headRecy;
    private OrderBuildAdapter mAdapter;
    /**
     * 商品数量
     */
    private int mTotalNum = 0;
    /**
     * 合计
     */
    private double mTotalPrice = 0.00;
    DecimalFormat df = new DecimalFormat("0.00");
    /**
     * 商品订单  这里有购物车的来源 和商品详情来源
     */
    private List<OrderBuildResponse.ShopsBean.ProductsBean> mOrderData;
    private int mAddressId;
    private OrderSubmitRequest submitRequest;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_build;
    }

    @Override
    public void initModel() {
        mModel = new OrderBuildModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new OrderBuildPresenter(this, mModel, this);
        mPresenter.getOrderBuildData(request);
    }

    @Override
    public void initView() {
        EventBusInstance.getInstance().registerEvent(this);
        setTitle("订单确认");
        if (null != getIntent()) {
            request = (OrderBuildRequest) getIntent().getSerializableExtra(IntentUtils.DATA);
        }
        initData();
    }

    private void initData() {
        lPay.setVisibility(View.GONE);
        mOrderData = new ArrayList<>();
        LinearLayoutManager manager = new LinearLayoutManager(getParent(), LinearLayoutManager.VERTICAL, false);
        mMainRecycleView.setLayoutManager(manager);
        mAdapter = new OrderBuildAdapter(this, mOrderData);
        mMainRecycleView.setAdapter(mAdapter);
        addHeadView();
    }

    private void addHeadView() {
        LayoutInflater inflater = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.include_confirm_head, null);
        headRecy = layout.findViewById(R.id.ll_comfirm_head);
        mHaveAddress = layout.findViewById(R.id.m_ll_have_address);
        mNoAddress = layout.findViewById(R.id.m_rl_address_empty);
        mConsignee = layout.findViewById(R.id.m_tv_consignee);
        mStationName = layout.findViewById(R.id.tv_stattion_name);
        mConsigneePhone = layout.findViewById(R.id.m_tv_phone);
        mConsigneeAddress = layout.findViewById(R.id.m_tv_address_datail);
        headRecy.setVisibility(View.GONE);
        mAdapter.addHeaderView(headRecy);
        headRecy.setOnClickListener(this);
    }

    @Override
    public void getOrderBuildData(OrderBuildResponse response) {
        this.response = response;
        if (response != null) {
            if (!mOrderData.isEmpty()) {
                mOrderData.clear();
            }
            lPay.setVisibility(View.VISIBLE);
            setAddress(response);
            for (int i = 0; i < response.getShops().size(); i++) {
                //得到店铺 和对应的商品列表
                OrderBuildResponse.ShopsBean ordersBean = response.getShops().get(i);
                for (int j = 0; j < ordersBean.getProducts().size(); j++) {
                    OrderBuildResponse.ShopsBean.ProductsBean itemsBean = ordersBean.getProducts().get(j);
                    //设置产品是第一个商品
                    if (j == 0) {
                        itemsBean.setIsFirst(1);
                    } else {
                        itemsBean.setIsFirst(2);
                    }
                    itemsBean.setFreight(ordersBean.getFreightAmount());
                    itemsBean.setShopId(ordersBean.getShopId());
                    itemsBean.setShopName(ordersBean.getShopName());
                    itemsBean.setSupportInvoice(ordersBean.isHasInvoice());
                    itemsBean.setOrderTotalPayAmount(ordersBean.getTotoalAmount());
                    itemsBean.setReceipt(false);
                    if (ordersBean.getProducts().size() == 1) { //这里是设置商品的最后一个显示留言框
                        itemsBean.setIsend(1);
                    } else if (j == ordersBean.getProducts().size() - 1) {
                        itemsBean.setIsend(1);
                    } else {
                        itemsBean.setIsend(2);
                    }
                    mOrderData.add(itemsBean);
                }
            }
        }
        setAllCount();
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void fail() {
        headRecy.setVisibility(View.GONE);
        finish();
    }

    @Override
    public void orderSubmitSuccess(String orderid) {


    }

    /**
     * 设置地址
     *
     * @param response
     */
    private void setAddress(OrderBuildResponse response) {
        if (response.getAddress() != null) {
            headRecy.setVisibility(View.VISIBLE);
            OrderBuildResponse.AddressBean adress = response.getAddress();
            mHaveAddress.setVisibility(View.VISIBLE);
            mNoAddress.setVisibility(View.GONE);
            mAddressId = adress.getAddressId();
            mConsigneeAddress.setText(adress.getRegionFullName() != null ? adress.getRegionFullName() : "");
            mConsigneeAddress.append("," + adress.getAddress() != null ? adress.getAddress() : "");
            mConsigneePhone.setText(adress.getPhone() != null ? adress.getPhone() : "");
            mConsignee.setText(adress.getCustomerName() != null ? adress.getCustomerName() : "");
            if (!TextUtils.isEmpty(adress.getSiteName())) {
                mStationName.setText(adress.getSiteName() + "    还差站长名");
                mStationName.setVisibility(View.VISIBLE);
            } else {
                mStationName.setVisibility(View.GONE);
            }
        } else {
            mHaveAddress.setVisibility(View.GONE);
            mNoAddress.setVisibility(View.VISIBLE);
        }
    }

    private void setAllCount() {
        mTotalNum = 0;
        mTotalPrice = 0;
        for (int i = 0; i < mOrderData.size(); i++) {
            mTotalNum = mTotalNum + mOrderData.get(i).getQuantity();
            if (mOrderData.get(i).getIsend() == 1) {
                mTotalPrice = mTotalPrice + mOrderData.get(i).getOrderTotalPayAmount();
            }
        }
        mTvCounts.setText("共" + mTotalNum + "件");
        tvShopcartTotalprice.setText("￥" + df.format(mTotalPrice));
    }

    @Override
    public void onClick(View v) {
        IntentUtils.gotoActivity(this, AddressManageActivity.class);
    }

    @OnClick(R.id.tv_submit)
    public void onViewClicked() {
        creatOrder();
        if (submitRequest != null) {
            Intent intent = new Intent(this, NewPayWindowActivity.class);
            intent.putExtra(IntentUtils.DATA, submitRequest);
            intent.putExtra("type", "order");
            startActivity(intent);
            overridePendingTransition(R.anim.push_bottom_in, R.anim.push_bottom_out);
        }
    }

    /**
     * 订单提交
     */
    private void creatOrder() {
        submitRequest = new OrderSubmitRequest();
        List<OrderSubmitRequest.ShopsBean> shops = new ArrayList<>();
        for (int i = 0; i < response.getShops().size(); i++) {
            OrderBuildResponse.ShopsBean oredersb = response.getShops().get(i);
            OrderSubmitRequest.ShopsBean sb = new OrderSubmitRequest.ShopsBean();
            List<OrderSubmitRequest.ShopsBean.SkusBean> skus = new ArrayList<>();
            for (int j = 0; j < oredersb.getProducts().size(); j++) {
                OrderBuildResponse.ShopsBean.ProductsBean pb = oredersb.getProducts().get(j);
                if (j == oredersb.getProducts().size() - 1) {
                    if (TextUtils.isEmpty(pb.getMessgae())) {
                        sb.setInvoiceTitle("个人");
                    } else {
                        sb.setInvoiceTitle(pb.getReceipt());
                    }
                    sb.setRemark(pb.getMessgae());
                    sb.setHasInvoice(pb.isReceipt());
                }
                OrderSubmitRequest.ShopsBean.SkusBean skub = new OrderSubmitRequest.ShopsBean.SkusBean();
                skub.setSkuId(pb.getSkuId());
                skub.setQuantity(pb.getQuantity());
                skus.add(skub);
            }
            sb.setSkus(skus);
            shops.add(sb);
        }
        submitRequest.setAddressId(mAddressId);
        submitRequest.setShops(shops);
        submitRequest.setGoodsCounts(mTotalNum);
        submitRequest.setTotalPrice(df.format(mTotalPrice));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(AddressInfoResponse event) {
        if (event != null) {
            request.setAddressId(event.getAddressId());
            mPresenter.getOrderBuildData(request);
        }
    }
}
