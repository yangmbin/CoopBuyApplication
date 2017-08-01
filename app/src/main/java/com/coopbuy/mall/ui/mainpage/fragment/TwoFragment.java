package com.coopbuy.mall.ui.mainpage.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.ViewPagerBaseFragment;
import com.coopbuy.mall.ui.mainpage.adapter.ClassifyLeftAdapter;
import com.coopbuy.mall.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 分类Fragment
 * @author ymb
 * Create at 2017/7/25 10:23
 */
public class TwoFragment extends ViewPagerBaseFragment {

    @Bind(R.id.left_list)
    ListView leftList;
    ClassifyLeftAdapter mLeftAdapter;
    @Bind(R.id.right_list)
    RecyclerView rightList;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_two;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        mLeftAdapter = new ClassifyLeftAdapter(mContext, getLeftData());
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
    }

    @Override
    protected void networkRetry() {
        super.networkRetry();
        ToastUtils.textToast(mContext, "reload");
    }

    private List<Object> getLeftData() {
        List<Object> list = new ArrayList<>();
        list.add("附加费");
        list.add("放假");
        list.add("按时");
        list.add("很贵");
        list.add("不发");
        list.add("可见");
        list.add("请问");
        return list;
    }
}
