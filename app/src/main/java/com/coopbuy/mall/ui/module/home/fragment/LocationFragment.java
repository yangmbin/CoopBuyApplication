package com.coopbuy.mall.ui.module.home.fragment;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.module.home.adapter.LocationAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.LocationAdapter_2;
import com.coopbuy.mall.utils.ScreenUtils;
import com.coopbuy.mall.widget.WaveSideBar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

public class LocationFragment extends ViewPagerBaseFragment {
    @Bind(R.id.side_bar)
    WaveSideBar sideBar;
    @Bind(R.id.indexBgView)
    TextView indexBgView;
    @Bind(R.id.locationList)
    RecyclerView locationList;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_location;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        initQuickIndex();

        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        locationList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        locationList.setAdapter(mDelegateAdapter);


        //test
        //1
        List list_1 = new ArrayList();
        list_1.add(new Object());
        mAdapters.add(new LocationAdapter_1(mContext, list_1, new SingleLayoutHelper()));

        //2
        GridLayoutHelper helper_2 = new GridLayoutHelper(3);
        helper_2.setAutoExpand(false);
        helper_2.setHGap(ScreenUtils.dip2px(mContext, 20));
        helper_2.setVGap(ScreenUtils.dip2px(mContext, 12));
        helper_2.setPadding(ScreenUtils.dip2px(mContext, 15), ScreenUtils.dip2px(mContext, 10), ScreenUtils.dip2px(mContext, 36), ScreenUtils.dip2px(mContext, 10));
        helper_2.setBgColor(ContextCompat.getColor(mContext, R.color.white));
        List list_2 = new ArrayList();
        for (int i = 0; i < 14; i++)
            list_2.add(new Object());
        mAdapters.add(new LocationAdapter_2(mContext, list_2, helper_2));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }

    /**
     * 初始化快速索引栏
     */
    private void initQuickIndex() {
        sideBar.setIndexItems("热", "门", "", "A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        setBgViewHeight();
        sideBar.setOnSelectIndexItemListener(new WaveSideBar.OnSelectIndexItemListener() {
            @Override
            public void onSelectIndexItem(String index) {
                // ToastUtils.toastShort(index);
            }
        });
    }

    /**
     * 获取SideBar高度
     */
    private int getSideBarHeight() {
        int measureWidth = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        int measureHeight = View.MeasureSpec.makeMeasureSpec((1 << 30) - 1, View.MeasureSpec.AT_MOST);
        sideBar.measure(measureWidth, measureHeight);
        int height = sideBar.getMeasuredHeight();

        return height;
    }

    /**
     * 设置索引背景高度
     */
    private void setBgViewHeight() {
        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) indexBgView.getLayoutParams();
        int height = getSideBarHeight();
        if (height != -1) {
            params.height = getSideBarHeight();
            indexBgView.setLayoutParams(params);
        }
    }

}
