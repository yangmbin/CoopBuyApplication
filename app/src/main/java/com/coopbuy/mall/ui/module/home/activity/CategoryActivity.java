package com.coopbuy.mall.ui.module.home.activity;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.home.adapter.CategoryLeftAdapter;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_1;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_2;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_3;
import com.coopbuy.mall.ui.module.home.adapter.CategoryRightAdapter_4;
import com.coopbuy.mall.ui.module.home.model.CategoryModel;
import com.coopbuy.mall.ui.module.home.presenter.CategoryPresenter;
import com.coopbuy.mall.ui.module.home.view.Category_IView;
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
public class CategoryActivity extends BaseActivity<CategoryPresenter, CategoryModel> implements Category_IView {

    @Bind(R.id.left_list)
    ListView leftList;
    CategoryLeftAdapter mLeftAdapter;
    @Bind(R.id.right_list)
    RecyclerView rightList;
    private DelegateAdapter mDelegateAdapter;
    private List<DelegateAdapter.Adapter> mAdapters = new LinkedList<>();
    List<CategoryResponse> leftData = new ArrayList<>();
    private boolean mShouldScroll = false;

    @Override
    public int getLayoutId() {
        return R.layout.activity_category;
    }

    @Override
    public void initModel() {
        mModel = new CategoryModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new CategoryPresenter(mContext, mModel, this);
        mPresenter.getCategoryData();
    }

    @Override
    protected void networkRetry() {
        mPresenter.getCategoryData();
    }

    @Override
    public void initView() {
        // 左边列表
        mLeftAdapter = new CategoryLeftAdapter(mContext, leftData);
        leftList.setAdapter(mLeftAdapter);
        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean isChange = mLeftAdapter.changeSelected(leftList, position);
                if (isChange) {
                    // 点击后，右边列表做相应变化（思路：在左边列表的Item设置tag，也即是position，点击后右边跳转到该位置）
                    int jumpPos = (int) view.getTag(R.id.jumpPos);
                    Log.e("yangmbin", "jumpPos:" + jumpPos);
                    moveToPosition(jumpPos);
                }
            }
        });

        // 右边列表
        VirtualLayoutManager manager = new VirtualLayoutManager(mContext);
        rightList.setLayoutManager(manager);
        mDelegateAdapter = new DelegateAdapter(manager, false);
        rightList.setAdapter(mDelegateAdapter);

//        // test
//        //1
//        GridLayoutHelper helper_1 = new GridLayoutHelper(2);
//        helper_1.setAutoExpand(false);
//        helper_1.setGap(ScreenUtils.dip2px(mContext, 15));
//        List list_1 = new ArrayList();
//        for (int i = 0; i < 9; i++)
//            list_1.add(new Object());
//        mAdapters.add(new CategoryRightAdapter_1(mContext, list_1, helper_1));
//
//        //2
//        SingleLayoutHelper helper_2 = new SingleLayoutHelper();
//        List list_2 = new ArrayList();
//        list_2.add(new Object());
//        mAdapters.add(new CategoryRightAdapter_2(mContext, list_2, helper_2));
//
//        //3
//        SingleLayoutHelper helper_3 = new SingleLayoutHelper();
//        List list_3 = new ArrayList();
//        list_3.add(new Object());
//        mAdapters.add(new CategoryRightAdapter_3(mContext, list_3, helper_3));
//
//        //4
//        GridLayoutHelper helper_4 = new GridLayoutHelper(3);
//        helper_4.setAutoExpand(false);
//        helper_4.setMarginBottom(ScreenUtils.dip2px(mContext, 12));
//        List list_4 = new ArrayList();
//        for (int i = 0; i < 5; i++)
//            list_4.add(new Object());
//        mAdapters.add(new CategoryRightAdapter_4(mContext, list_4, helper_4));
//
//
//        mDelegateAdapter.setAdapters(mAdapters);
//        mDelegateAdapter.notifyDataSetChanged();
    }

    @Override
    public void setCategoryData(List<CategoryResponse> categoryResponses) {
        // 刷新左边列表
        leftData.addAll(categoryResponses);
        mLeftAdapter.notifyDataSetChanged();

        // 刷新右边列表
        for (int i = 0; i < categoryResponses.size(); i++) {
            if (categoryResponses.get(i).isIsRecommend()) {
                // 1
                GridLayoutHelper helper_1 = new GridLayoutHelper(2);
                helper_1.setAutoExpand(false);
                helper_1.setGap(ScreenUtils.dip2px(mContext, 15));
                List list_1 = new ArrayList();
                list_1.addAll(categoryResponses.get(i).getChildren());
                mAdapters.add(new CategoryRightAdapter_1(mContext, list_1, helper_1, i));
            } else {
                //2
                SingleLayoutHelper helper_2 = new SingleLayoutHelper();
                List list_2 = new ArrayList();
                list_2.add(categoryResponses.get(i));
                mAdapters.add(new CategoryRightAdapter_2(mContext, list_2, helper_2, i));

                for (int j = 0; j < categoryResponses.get(i).getChildren().size(); j++) {
                    //3
                    SingleLayoutHelper helper_3 = new SingleLayoutHelper();
                    List list_3 = new ArrayList();
                    list_3.add(categoryResponses.get(i).getChildren().get(j));
                    mAdapters.add(new CategoryRightAdapter_3(mContext, list_3, helper_3));

                    //4
                    GridLayoutHelper helper_4 = new GridLayoutHelper(3);
                    helper_4.setAutoExpand(false);
                    helper_4.setMarginBottom(ScreenUtils.dip2px(mContext, 12));
                    List list_4 = new ArrayList();
                    list_4.addAll(categoryResponses.get(i).getChildren().get(j).getChildren());
                    mAdapters.add(new CategoryRightAdapter_4(mContext, list_4, helper_4));
                }
            }
        }
        mDelegateAdapter.setAdapters(mAdapters);
        mDelegateAdapter.notifyDataSetChanged();
        moveToPosition(0);
    }

    /**
     * 使RecyclerView移动到指定的位置（点击左边列表，右边列表滚动）
     */
    private void moveToPosition(final int jumpPos) {
        // 先从RecyclerView的LayoutManager中获取第一项和最后一项的Position
        int firstItem = ((VirtualLayoutManager) rightList.getLayoutManager()).findFirstVisibleItemPosition();
        int lastItem = ((VirtualLayoutManager) rightList.getLayoutManager()).findLastVisibleItemPosition();
        mShouldScroll = false;
        rightList.addOnScrollListener(new RecyclerViewListener(jumpPos));
        // 然后区分情况
        if (jumpPos <= firstItem) {
            // 当要置顶的项在当前显示的第一个项的前面时
            rightList.scrollToPosition(jumpPos);
        } else if (jumpPos <= lastItem) {
            // 当要置顶的项已经在屏幕上显示时
            // int top = rightList.getChildAt(jumpPos - firstItem).getTop() - 50;
            int top = rightList.getChildAt(jumpPos - firstItem).getTop() - 50;
            rightList.scrollBy(0, top);
        } else {
            // 当要置顶的项在当前显示的最后一项的后面时,调用scrollToPosition只会将该项滑动到屏幕上。需要再次滑动到顶部
            rightList.scrollToPosition(jumpPos);
            // 这里这个变量是用在RecyclerView滚动监听里面的
            mShouldScroll = true;
        }
    }

    /**
     * 滚动监听
     */
    class RecyclerViewListener extends RecyclerView.OnScrollListener {
        private int jumpPos = 0;

        RecyclerViewListener(int jumpPos) {
            this.jumpPos = jumpPos;
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            // 在这里进行第二次滚动
            if (mShouldScroll) {
                mShouldScroll = false;
                moveToPosition(jumpPos);
            }

            // 在这里，监听手动滑动右边列表，然后联动左边列表的选择项（思路：在类型2的布局设置Tag、在类型1的第一项布局设置Tag，表示左边列表的下标）
            int firstItem = ((VirtualLayoutManager) rightList.getLayoutManager()).findFirstVisibleItemPosition();
            View v = rightList.getLayoutManager().findViewByPosition(firstItem);
            if (v.getTag() != null)
                mLeftAdapter.changeSelected(leftList, (int) v.getTag());
        }
    }

}
