package com.coopbuy.mall.ui.module.home.activity;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.home.adapter.CategoryLeftAdapter;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_3;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_4;
import com.coopbuy.mall.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;

/**
 * 分类页
 *
 * @author ymb
 *         Create at 2017/8/10 13:59
 */
public class CategoryActivity extends BaseActivity {

    @Bind(R.id.left_list)
    ListView leftList;
    CategoryLeftAdapter mLeftAdapter;
    @Bind(R.id.right_list)
    RecyclerView rightList;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();

    @Override
    public int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        // 左边列表
        List<Object> leftData = new ArrayList<>();
        for (int i = 0; i < 8; i++)
            leftData.add(new Object());
        mLeftAdapter = new CategoryLeftAdapter(mContext, leftData);
        leftList.setAdapter(mLeftAdapter);
        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean isChange = mLeftAdapter.changeSelected(position);
                if (isChange) {
                    // 点击后，右边列表做相应变化（思路：在左边列表的Item设置tag，也即是position，点击后右边跳转到该位置）
                }
            }
        });

        // 右边列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        rightList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        rightList.setAdapter(mDelegateAdapter);

        // test
        //1
        GridLayoutHelper helper_1 = new GridLayoutHelper(2);
        helper_1.setAutoExpand(false);
        helper_1.setGap(ScreenUtils.dip2px(mContext, 15));
        List list_1 = new ArrayList();
        for (int i = 0; i < 9; i++)
            list_1.add(new Object());
        mAdapters.add(new CategoryRightAdapter_1(mContext, list_1, helper_1));

        //2
        SingleLayoutHelper helper_2 = new SingleLayoutHelper();
        List list_2 = new ArrayList();
        list_2.add(new Object());
        mAdapters.add(new CategoryRightAdapter_2(mContext, list_2, helper_2));

        //3
        SingleLayoutHelper helper_3 = new SingleLayoutHelper();
        List list_3 = new ArrayList();
        list_3.add(new Object());
        mAdapters.add(new CategoryRightAdapter_3(mContext, list_3, helper_3));

        //4
        GridLayoutHelper helper_4 = new GridLayoutHelper(3);
        helper_4.setAutoExpand(false);
        helper_4.setMarginBottom(ScreenUtils.dip2px(mContext, 12));
        List list_4 = new ArrayList();
        for (int i = 0; i < 5; i++)
            list_4.add(new Object());
        mAdapters.add(new CategoryRightAdapter_4(mContext, list_4, helper_4));


        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
    }
}
