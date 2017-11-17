package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.InComeReponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 14:32
 */

public interface Income_IView extends BaseView {
    void getData(InComeReponse bean,String type);
}
