package com.coopbuy.mall.ui.module.home.view;

import com.coopbuy.mall.api.reponse.CategoryResponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

public interface Category_IView extends BaseView {
    void setCategoryData(List<CategoryResponse> categoryResponses);
}
