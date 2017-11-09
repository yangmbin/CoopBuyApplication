package com.coopbuy.mall.ui.module.center.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BaseFragment;
import com.coopbuy.mall.eventbus.CollectEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.ReleaseEvent;
import com.coopbuy.mall.ui.module.center.adapter.CollectAdapter;
import com.coopbuy.mall.ui.module.center.adapter.ReleaseAdapter;
import com.coopbuy.mall.ui.module.center.model.CollectModel;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.ui.module.center.presenter.CollectPresenter;
import com.coopbuy.mall.ui.module.center.view.Collect_IView;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.DataCleanManager;
import com.coopbuy.mall.utils.DialogUtils;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.CommonDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */

/**
 * @author niu
 * @time 2017/11/6 16:50
 * @content 站长推荐 发布商品
 */
public class ReleasesFragment extends BaseFragment<CollectPresenter, CollectModel> implements CollectPort, Collect_IView {
    private int mPagerIndex = 1;
    @Bind(R.id.recView)
    RecyclerView recView;
    private CollectRequest request;
    private List<CollectResponse.ItemsBean> data;
    private ReleaseAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_releases;
    }

    @Override
    public void initModel() {
        mModel = new CollectModel();
    }

    @Override
    public void initPresenter() {
        request = new CollectRequest();
        request.setCurrentPage(mPagerIndex);
        request.setPublishStatus(2);
        mPresenter = new CollectPresenter(mContext, mModel, this);
        mPresenter.getUserInfoData(request, "init");
        mPresenter = new CollectPresenter(mContext, mModel, this);
    }

    @Override
    protected void initView() {
        EventBusInstance.getInstance().registerEvent(this);
        initRecy();
    }

    private void initRecy() {
        data = new ArrayList<>();
        adapter = new ReleaseAdapter(getContext(), data, this);
        recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(getActivity(), GoodsDetailActivity.class, data.get(postion).getSkuId());
    }

    @Override
    public void quantityClick(int postion) {

    }

    @Override
    public void remove(final int postion) {

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(ReleaseEvent event) {
        if (event != null) {
            initPresenter();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }


    @Override
    public void getCollectData(CollectResponse data, String type) {
        if (!this.data.isEmpty()) {
            this.data.clear();
        }
        this.data.addAll(data.getItems());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void updateSuccess(int postion) {

    }

    @Override
    public void publishSuccess() {

    }

    @Override
    public void removeSuccess() {

    }


}
