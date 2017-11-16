package com.coopbuy.mall.ui.module.home.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.navigation.SearchTopBar;
import com.coopbuy.mall.widget.tag.TagGroup;

import butterknife.Bind;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {

    @Bind(R.id.tag_group)
    TagGroup tagGroup;
    @Bind(R.id.search_top_bar)
    SearchTopBar searchTopBar;
    @Bind(R.id.exception_wrapper)
    LinearLayout exceptionWrapper;

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    @Override
    public void initModel() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        initTagGroup();
        initSearchListener();
        initEmptyDisplay();
    }

    /**
     * 初始化tagGroup
     */
    private void initTagGroup() {
        tagGroup.setTags(sharedPreferencesUtils.getSearchWordList());
        tagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
            @Override
            public void onTagClick(String tag) {
                IntentUtils.gotoActivity(mContext, SearchResultActivity.class, tag);
                finish();
            }
        });
    }

    /**
     * 初始化搜索按钮
     */
    private void initSearchListener() {
        searchTopBar.setOnSearchListener(new SearchTopBar.SearchListener() {
            @Override
            public void search() {
                String searchText = searchTopBar.getSearchText();
                if (TextUtils.isEmpty(searchText)) {
                    ToastUtils.toastShort("请输入搜索内容");
                    return;
                }
                sharedPreferencesUtils.putSearchWord(searchText);
                IntentUtils.gotoActivity(mContext, SearchResultActivity.class, searchText);
                finish();
            }
        });
    }

    /**
     * 初始化无搜索历史的显示
     */
    private void initEmptyDisplay() {
        if (sharedPreferencesUtils.getSearchWordList().size() == 0) {
            tagGroup.setVisibility(View.GONE);
            exceptionWrapper.setVisibility(View.VISIBLE);
        } else {
            tagGroup.setVisibility(View.VISIBLE);
            exceptionWrapper.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.clear_search_history})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clear_search_history:
                sharedPreferencesUtils.clearSearchWordList();
                initEmptyDisplay();
                break;
        }
    }
}
