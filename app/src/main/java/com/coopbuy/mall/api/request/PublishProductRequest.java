package com.coopbuy.mall.api.request;

import java.io.Serializable;
import java.util.List;

/**
 * Created by niu on 2017/11/8- 16:25
 */

public class PublishProductRequest implements Serializable {

    private List<Integer> skus;

    public List<Integer> getSkus() {
        return skus;
    }

    public void setSkus(List<Integer> skus) {
        this.skus = skus;
    }

}
