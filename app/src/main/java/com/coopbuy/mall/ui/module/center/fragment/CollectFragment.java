package com.coopbuy.mall.ui.module.center.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.api.request.CollectRequest;
import com.coopbuy.mall.api.request.PublishProductRequest;
import com.coopbuy.mall.api.request.SkuDetailRequest;
import com.coopbuy.mall.base.BaseFragment;
import com.coopbuy.mall.eventbus.CollectEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.ui.module.center.adapter.CollectAdapter;
import com.coopbuy.mall.ui.module.center.adapter.ShopStoreAdapter;
import com.coopbuy.mall.ui.module.center.model.CollectModel;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.ui.module.center.presenter.CollectPresenter;
import com.coopbuy.mall.ui.module.center.view.Collect_IView;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.time.CountDown;
import com.coopbuy.mall.widget.time.TimeTools;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author niu
 * @time 2017/11/6 16:51
 * @content 收藏商品
 */
public class CollectFragment extends BaseFragment<CollectPresenter, CollectModel> implements CollectPort, OnRefreshListener, OnLoadmoreListener, Collect_IView {
    @Bind(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;
    @Bind(R.id.tv_relase_count)
    TextView tvReleaseCounts;
    @Bind(R.id.tv_release_time)
    TextView tvFreshenTime;
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.tv_release)
    TextView tvRelease;
    private int mPagerIndex = 1;
    /**
     * 倒计时计时器
     */
    private CountDown mCountDownTimer;
    private CollectRequest request;
    private List<CollectResponse.ItemsBean> data;
    private CollectAdapter adapter;
    private int count;
    /**
     * 发布商品请求
     */
    private PublishProductRequest ppRequest;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
    }

    @Override
    public void initModel() {
        mModel = new CollectModel();
    }

    @Override
    public void initPresenter() {
        request = new CollectRequest();
        request.setCurrentPage(mPagerIndex);
        request.setPublishStatus(1);
        mPresenter = new CollectPresenter(mContext, mModel, this);
        mPresenter.getUserInfoData(request, "init");
    }

    @Override
    protected void initView() {
        EventBusInstance.getInstance().registerEvent(this);
        setReleaseClickable(false);
        initRecy();


    }

    public void initCountDownTimer(double times) {
        mCountDownTimer = new CountDown();
        mCountDownTimer.setMillisInFuture((long) (times));
        mCountDownTimer.setCountdownInterval(1000);
        mCountDownTimer.setCountDownListener(new CountDown.CountDownListener() {
            @Override
            public void onStart() {
            }

            @Override
            public void onFinish() {
                setReleaseClickable(true);
            }

            @Override
            public void onTick(long millisUntilFinished) {
                tvFreshenTime.setText(TimeTools.getCountTimeByLong(millisUntilFinished));
            }
        });
        mCountDownTimer.start();
    }

    private void initRecy() {
        data = new ArrayList<>();
        mRefreshLayout.setEnableLoadmoreWhenContentNotFull(true);
        mRefreshLayout.setOnRefreshListener(this);
        mRefreshLayout.setOnLoadmoreListener(this);
        mRefreshLayout.setEnableLoadmore(true);
        mRefreshLayout.setEnableRefresh(true);
        adapter = new CollectAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    @Override
    public void openDetial(int postion) {
        IntentUtils.gotoActivity(getActivity(), GoodsDetailActivity.class, data.get(postion).getSkuId());
    }

    private void setPublishCount() {
        tvReleaseCounts.setText("您当前的可推荐商品数量为：" + count);
    }

    @Override
    public void quantityClick(int count) {
        SkuDetailRequest request = new SkuDetailRequest();
        request.setSkuId(data.get(count).getSkuId());
        mPresenter.updateStatus(request, count);
    }

    @Override
    public void remove(int postion) {

    }

    @Override
    public void updateSuccess(int postion) {
        //这里不用服务器数据 使用为存在多页数据 处理很麻烦
        boolean select = !data.get(postion).isSelected();
        data.get(postion).setSelected(select);
        if (select) {
            --count;
        } else {
            ++count;
        }
        int selectCount = data.get(0).getCurrentMaxPublishCount() - count;
        for (int i = 0; i < data.size(); i++) {
            data.get(i).setCurrentSelectedProductCount(selectCount);
        }
        setPublishCount();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void publishSuccess() {
        fresh();
    }

    @Override
    public void removeSuccess() {

    }

    private void setReleaseClickable(boolean click) {
        if (click) {
            tvRelease.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
            tvRelease.setClickable(true);
            tvRelease.setText("发布");
        } else {
            tvRelease.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
            tvRelease.setClickable(false);
        }
    }

    @OnClick(R.id.tv_release)
    public void onViewClicked() {
        if (checkok()) {
            mPresenter.publishProduct(ppRequest);
        }
    }

    private boolean checkok() {
        ppRequest = new PublishProductRequest();
        List<Integer> skus = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).isSelected()) {
                skus.add(data.get(i).getSkuId());
            }
        }
        ppRequest.setSkus(skus);
        if (skus.isEmpty()) {
            ToastUtils.toastLong("请选择发布的商品");
            return false;
        } else {
            return true;
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(CollectEvent event) {
        if (event != null) {

        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusInstance.getInstance().unRegisterEvent(this);
        stopTimer();
    }

    private void stopTimer() {
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }
    }

    @Override
    public void onLoadmore(RefreshLayout refreshlayout) {
        ++mPagerIndex;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getUserInfoData(request, "load");
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        fresh();
    }

    private void fresh() {
        mPagerIndex = 1;
        request.setCurrentPage(mPagerIndex);
        mPresenter.getUserInfoData(request, "fresh");
    }

    @Override
    public void getCollectData(CollectResponse data, String type) {
        if (0 == data.getNextPublishSurplusTime()) {
            tvFreshenTime.setText("");
            stopTimer();
        } else {
            stopTimer();
            initCountDownTimer(data.getNextPublishSurplusTime());
        }
        //可不可以发布
        setReleaseClickable(data.isCanPublish());
        for (int i = 0; i < data.getItems().size(); i++) {
            data.getItems().get(i).setCurrentMaxPublishCount(data.getCurrentMaxPublishCount());
            data.getItems().get(i).setCanPublish(data.isCanPublish());
            data.getItems().get(i).setCurrentSelectedProductCount(data.getCurrentSelectedProductCount());
        }
        count = data.getCurrentMaxPublishCount() - data.getCurrentSelectedProductCount();
        if (type.equals("load")) {
            adapter.addMore(data.getItems());
        } else {
            adapter.refresh(data.getItems());
        }
        setPublishCount();
    }

    @Override
    public void stopRefresh() {
        if (mRefreshLayout != null) {
            mRefreshLayout.finishRefresh();
            mRefreshLayout.finishLoadmore();
        }
    }
}
