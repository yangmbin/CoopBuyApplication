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
import com.coopbuy.mall.base.BaseFragment;
import com.coopbuy.mall.eventbus.CollectEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.eventbus.ReleaseEvent;
import com.coopbuy.mall.ui.module.center.adapter.CollectAdapter;
import com.coopbuy.mall.ui.module.center.adapter.ReleaseAdapter;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.time.OnTimeoutListener;
import com.coopbuy.mall.widget.time.TimeViewComm;

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
public class ReleasesFragment extends BaseFragment implements CollectPort {
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.tv_release)
    TextView tvRelease;
    @Bind(R.id.timeout)
    TimeViewComm mTimeOut;

    public ReleasesFragment() {
        // Required empty public constructor
    }

    private List<CollectResponse> data;
    private ReleaseAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_releases;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        EventBusInstance.getInstance().registerEvent(this);
        initRecy();
        //根据时间去判断
        setReleaseClickable(false);
        mTimeOut.startTime(0, 0, 10);

    }

    private void initRecy() {
        data = new ArrayList<>();
        setData();
        adapter = new ReleaseAdapter(getContext(), data, this);
        recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }


    private void setData() {
        for (int i = 0; i < 5; i++) {
            CollectResponse re = new CollectResponse();
            re.setCountAvailable(5);
            re.setName("青青爱吃大榴莲" + i);
            re.setOldPrice("1" + i);
            re.setPrice(2 * i + "");
            re.setSaleCounts(2 * i + "");
            re.setVersion("1" + i + "*" + i * 3);
            re.setSelect(true);
            data.add(re);
        }
    }

    @Override
    public void openDetial(int postion) {

    }

    @Override
    public void quantityClick(int postion) {

    }

    private void setReleaseClickable(boolean click) {
        if (click) {
            tvRelease.setBackgroundResource(R.drawable.black_rectangle_btn_press_black);
            tvRelease.setTextColor(getResources().getColor(R.color.edit_text_back_white));
            tvRelease.setClickable(true);
        } else {
            tvRelease.setBackgroundResource(R.drawable.black_rectangle_btn_unpress_gray);
            tvRelease.setClickable(false);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(ReleaseEvent event) {
        if (event != null) {
            ToastUtils.toastShort("刷新发布");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }


}
