package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.classify.CategorysResponse;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.ClassifyLeftAdapter;
import com.coopbuy.mall.ui.mainpage.model.CategoryModel;
import com.coopbuy.mall.ui.mainpage.presenter.CategoryPresenter;
import com.coopbuy.mall.ui.mainpage.view.Category_IView;
import com.coopbuy.mall.utils.ToastUtils;

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

    private List<Object> mLeftData = new ArrayList<>();
    private List<List<Object>> mRightData = new ArrayList<>();

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
                mLeftAdapter.changeSelected(position);
            }
        });
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
        ToastUtils.toastShort("reload");
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
//                for (int k = )
            }
        }


        mLeftAdapter.notifyDataSetChanged();
    }
}
