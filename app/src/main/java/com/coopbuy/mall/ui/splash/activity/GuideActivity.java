package com.coopbuy.mall.ui.splash.activity;

import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.mainpage.activity.MainActivity;
import com.coopbuy.mall.ui.splash.adapter.GuideViewPagerAdapter;
import com.coopbuy.mall.utils.IntentUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * @author csn
 * @time 2017/10/12 0012 14:11
 * @content 引导页
 */
public class GuideActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.vp_guide)
    ViewPager vpGuide;
    @Bind(R.id.tv)
    TextView tv;
    private List<View> views;
    // 引导页图片资源
    private GuideViewPagerAdapter adapter;
    private static final int[] pics = {R.layout.guid_view1,
            R.layout.guid_view2, R.layout.guid_view3};

    @Override
    public int getLayoutId() {
        return R.layout.activity_guide;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        tv.setVisibility(View.GONE);
        // 初始化引导页视图列表
        views = new ArrayList<>();
        for (int i = 0; i < pics.length; i++) {
            View view = LayoutInflater.from(this).inflate(pics[i], null);
            views.add(view);
        }
        // 初始化adapter
        adapter = new GuideViewPagerAdapter(views);
        vpGuide.setAdapter(adapter);
        vpGuide.setOnPageChangeListener(new PageChangeListener());
    }


    @Override
    public void onClick(View v) {
        if (v.getTag().equals("enter")) {
            IntentUtils.gotoActivity(this, MainActivity.class);
            finish();
            return;
        }
        int position = (Integer) v.getTag();
        setCurView(position);
    }

    /**
     * 设置当前view
     *
     * @param position
     */
    private void setCurView(int position) {
        if (position < 0 || position >= pics.length) {
            return;
        }
        vpGuide.setCurrentItem(position);
    }


    @OnClick(R.id.tv)
    public void onViewClicked() {
        IntentUtils.gotoActivity(this, MainActivity.class);
        this.finish();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int position) {
            // arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。
        }

        // 当前页面被滑动时调用
        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {
            // arg0 :当前页面，及你点击滑动的页面
            // arg1:当前页面偏移的百分比
            // arg2:当前页面偏移的像素位置

        }

        // 当新的页面被选中时调用
        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
            if (position == 2) {
                tv.setVisibility(View.VISIBLE);
            }
        }
    }
}
