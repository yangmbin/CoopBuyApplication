package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.DataAnalyseResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/11/17- 13:52
 */

public interface DataAnalyse_IView extends BaseView {

    void getData(DataAnalyseResponse bean);
}
