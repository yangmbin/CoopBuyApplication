package com.coopbuy.mall.ui.module.center.view;

import com.coopbuy.mall.api.reponse.AddressTownResponse;
import com.coopbuy.mall.api.reponse.AreaDataResponse;
import com.coopbuy.mall.api.reponse.GetBindStationReponse;
import com.coopbuy.mall.api.reponse.GetProviencesReponse;
import com.coopbuy.mall.base.BaseView;

import java.util.List;

/**
 * @author csn
 * @date 2017/10/18 0018 10:12
 * @content
 */
public interface AddUserAddress_IView extends BaseView {
    void getProviencesReponse(List<AreaDataResponse> data,String type);

    void getChileProiencesData(List<AddressTownResponse> data, String type,String again);

    /**
     * 获取站长的数据信息
     *
     * @param data
     */
    void getBindStationData(List<GetBindStationReponse> data);

    /**
     * 获取街道 失败
     */
    void getStreetFail();

    /**
     * 获取村 社区 失败
     */
    void getConmmunityFail();

    void addSuccess();
}
