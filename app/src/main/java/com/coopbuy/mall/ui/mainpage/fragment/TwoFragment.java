package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.ClassifyLeftAdapter;
import com.coopbuy.mall.ui.mainpage.adapter.ClassifyRightAdapter;
import com.coopbuy.mall.ui.mainpage.model.CategoryModel;
import com.coopbuy.mall.ui.mainpage.presenter.CategoryPresenter;
import com.coopbuy.mall.ui.mainpage.view.Category_IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 分类Fragment
 * @author ymb
 * Create at 2017/7/25 10:23
 */
public class TwoFragment extends ViewPagerBaseFragment<CategoryPresenter, CategoryModel> implements Category_IView {

    @Bind(R.id.left_list)
    ListView leftList;
    ClassifyLeftAdapter mLeftAdapter;
    @Bind(R.id.right_list)
    RecyclerView rightList;
    ClassifyRightAdapter mRightAdapter;

    private List<Object> mLeftData = new ArrayList<>();
    private List<List<Object>> mRightData = new ArrayList<>();
    private List<Object> mRightSingleData = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void initModel() {
        mModel = new CategoryModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new CategoryPresenter(mContext, mModel, this);
    }

    @Override
    protected void initView() {
        mLeftAdapter = new ClassifyLeftAdapter(mContext, mLeftData);
        leftList.setAdapter(mLeftAdapter);
        leftList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                boolean isChange = mLeftAdapter.changeSelected(position);
                if (isChange) {
                    mRightSingleData.clear();
                    mRightSingleData.addAll(mRightData.get(position));
                    mRightAdapter.notifyDataSetChanged();
                }
            }
        });

        mRightAdapter = new ClassifyRightAdapter(mContext, mRightSingleData);
        rightList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
        rightList.setAdapter(mRightAdapter);
    }

    @Override
    protected void onFragmentVisible(boolean isVisible) {
        super.onFragmentVisible(isVisible);
        if (isVisible) {
        } else {
        }
    }

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        mPresenter.getCategory();
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        mPresenter.getCategory();
    }

    /**
     * 显示网络返回的分类数据
     * @param responses
     */
    @Override
    public void showCategoryData(List<CategorysResponse> responses) {
        mLeftData.clear();
        for (int i = 0; i < responses.size(); i++) {
            mLeftData.add(responses.get(i).getCategoryName());
            List<Object> tmpList = new ArrayList<>();
            for (int j = 0; j < responses.get(i).getChildren().size(); j++) {
                tmpList.add(responses.get(i).getChildren().get(j).getCategoryName());
                List<ClassifyRightAdapter.GoodsCategoryItem> itemList = new ArrayList<>();
                for (int k = 0; k < responses.get(i).getChildren().get(j).getChildren().size(); k++) {
                    ClassifyRightAdapter.GoodsCategoryItem item = new ClassifyRightAdapter.GoodsCategoryItem();
                    item.setCategoryName(responses.get(i).getChildren().get(j).getChildren().get(k).getCategoryName());
                    item.setImageUrl(responses.get(i).getChildren().get(j).getChildren().get(k).getImageUrl());
                    itemList.add(item);
                    if (itemList.size() == 3) {
                        tmpList.add(itemList);
                        itemList = new ArrayList<>();
                    }
                }
                if (itemList.size() != 0)
                    tmpList.add(itemList);
            }
            mRightData.add(tmpList);
        }
        if (mRightData.size() > 0) {
            mRightSingleData.clear();
            mRightSingleData.addAll(mRightData.get(0));
        }
        Log.e("yangmbin", mRightSingleData.size() + "," + mRightSingleData.toString());
        mLeftAdapter.notifyDataSetChanged();
        mRightAdapter.notifyDataSetChanged();
    }
}
