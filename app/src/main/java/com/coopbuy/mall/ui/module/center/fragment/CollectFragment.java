package com.coopbuy.mall.ui.module.center.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CollectResponse;
import com.coopbuy.mall.base.BaseFragment;
import com.coopbuy.mall.eventbus.CollectEvent;
import com.coopbuy.mall.eventbus.EventBusInstance;
import com.coopbuy.mall.ui.module.center.adapter.CollectAdapter;
import com.coopbuy.mall.ui.module.center.port.CollectPort;
import com.coopbuy.mall.utils.ToastUtils;

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
public class CollectFragment extends BaseFragment implements CollectPort {


    @Bind(R.id.tv_release_counts)
    TextView tvReleaseCounts;
    @Bind(R.id.tv_freshen_time)
    TextView tvFreshenTime;
    @Bind(R.id.recView)
    RecyclerView recView;
    @Bind(R.id.tv_release)
    TextView tvRelease;

    private List<CollectResponse> data;
    private CollectAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_collect;
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
        setReleaseClickable(false);
        initRecy();
    }

    private void initRecy() {
        data = new ArrayList<>();
        setData();
        adapter = new CollectAdapter(data, this);
        recView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recView.setAdapter(adapter);
    }

    private void setData() {
        for (int i = 0; i < 10; i++) {
            CollectResponse re = new CollectResponse();
            re.setCountAvailable(5);
            re.setName("青青爱吃大榴莲" + i);
            re.setOldPrice("1" + i);
            re.setPrice(2 * i + "");
            re.setSaleCounts(2 * i + "");
            re.setVersion("1" + i + "*" + i * 3);
            re.setSelect(false);
            data.add(re);
        }
    }


    @Override
    public void openDetial(int postion) {

    }

    @Override
    public void quantityClick(int count) {
        tvReleaseCounts.setText("可选择" + count + "件商品加入发布");
        if (count == 5) {
            setReleaseClickable(false);
        } else {
            setReleaseClickable(true);
        }
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

    @OnClick(R.id.tv_release)
    public void onViewClicked() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThreadrep(CollectEvent event) {
        if (event != null) {
            ToastUtils.toastShort("刷新收藏");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBusInstance.getInstance().unRegisterEvent(this);
    }
}
