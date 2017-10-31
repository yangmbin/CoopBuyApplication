package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.FootMarkResponse;
import com.coopbuy.mall.base.BaseView;

/**
 * Created by niu on 2017/10/31- 9:35
 */

public interface FootMark_IView extends BaseView {
        void getFootMarkData(FootMarkResponse response,String type);
}
