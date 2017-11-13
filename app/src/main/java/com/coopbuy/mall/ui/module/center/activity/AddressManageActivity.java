package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.AddressInfoResponse;
import com.coopbuy.mall.api.request.SetDefaultOrDeleteOrFindAddressRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.eventbus.AddSuccessEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.ui.module.center.adapter.AddressMangeAdapter;
import com.coopbuy.mall.ui.module.center.model.AddressManageModel;
import com.coopbuy.mall.ui.module.center.port.AddressPort;
import com.coopbuy.mall.ui.module.center.presenter.AddressManagePresenter;
import com.coopbuy.mall.ui.module.center.view.AddressManage_IView;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/11 0011 14:43
 * @content 地址管理
 */
public class AddressManageActivity extends BaseActivity<AddressManagePresenter, AddressManageModel> implements AddressManage_IView, AddressPort {

    @Bind(R.id.rv_banner_detail)
    RecyclerView mRecycleView;

    private DelegateAdapter delegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters;
    private List<AddressInfoResponse> mData;
    private LinearLayoutHelper bannerSlider1Helper;
    private AddressMangeAdapter adapter;
    private String type = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_address_manage;
    }

    @Override
    public void initModel() {
        mModel = new AddressManageModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new AddressManagePresenter(this, mModel, this);
        mPresenter.getAddressData("init");
    }

    @Override
    public void initView() {
        if (null != getIntent()) {
            type = (String) getIntent().getSerializableExtra(IntentUtils.DATA);
        }
        EventBusInstance.getInstance().registerEvent(this);
        setTitle("地址管理");
        initRecycleView();
    }

    private void initRecycleView() {
        mAdapters = new LinkedList<>();
        mData = new ArrayList<>();
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        mRecycleView.setRecycledViewPool(viewPool);
        viewPool.setMaxRecycledViews(0, 10);
        delegateAdapter = new DelegateAdapter(layoutManager, false);
        mRecycleView.setAdapter(delegateAdapter);
    }

    @OnClick(R.id.tv_add_address)
    public void onViewClicked() {
        IntentUtils.gotoActivity(this, AddresssAddUserActivity.class, "add");
    }

    @Override
    public void getAddressMangeData(List<AddressInfoResponse> data, String type) {
        if (type.equals("init")) {
            delegateAdapter.clear();
            mAdapters.clear();
            bannerSlider1Helper = new LinearLayoutHelper();
            adapter = new AddressMangeAdapter(this, data, bannerSlider1Helper, this);
            mAdapters.add(adapter);
            delegateAdapter.setAdapters(mAdapters);
        } else {
            adapter.flesh(data);
        }
    }

    @Override
    public void setDefaultSuccess() {
        mPresenter.getAddressData("revise");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(AddSuccessEvent event) {
        if (event != null) {
            mPresenter.getAddressData("revise");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }

    @Override
    public void setDefault(AddressInfoResponse bean) {
        SetDefaultOrDeleteOrFindAddressRequest request = new SetDefaultOrDeleteOrFindAddressRequest();
        request.setAddressId(bean.getAddressId());
        mPresenter.setDefault(request);
    }

    @Override
    public void editAddress(AddressInfoResponse bean) {
        IntentUtils.gotoActivity(this, AddresssAddUserActivity.class, bean, "edit");
    }

    @Override
    public void delete(final AddressInfoResponse bean) {
        DialogUtils.showTwoKeyDialog(mContext, new CommonDialog.ClickCallBack() {
            @Override
            public void onConfirm() {
                SetDefaultOrDeleteOrFindAddressRequest request = new SetDefaultOrDeleteOrFindAddressRequest();
                request.setAddressId(bean.getAddressId());
                mPresenter.deleteAddress(request);
            }
        }, "确认删除改地址！", "取消", "确定");
    }

    /**
     * 设置购买商品的收货地址
     *
     * @param bean
     */
    @Override
    public void setReceivedAddress(AddressInfoResponse bean) {
//        ToastUtils.toastShort("设置收货地址");
        EventBusInstance.getInstance().post(bean);
        //如果从个人中心进来的不需要点击结束
        if (TextUtils.isEmpty(type))
            finish();
    }
}
