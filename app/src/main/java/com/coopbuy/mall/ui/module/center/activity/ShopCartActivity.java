package com.coopbuy.mall.ui.module.center.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopCartReponse;
import com.coopbuy.mall.api.reponse.StationRecommendResponse;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.ShopCartAdapter;
import com.coopbuy.mall.ui.module.center.adapter.StationRecAdapter;
import com.coopbuy.mall.ui.module.center.model.ShopCartModel;
import com.coopbuy.mall.ui.module.center.port.ShopCartPort;
import com.coopbuy.mall.ui.module.center.presenter.ShopCartPresenter;
import com.coopbuy.mall.ui.module.center.view.ShopCart_IView;
import com.coopbuy.mall.widget.NormalDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class ShopCartActivity extends BaseActivity<ShopCartPresenter, ShopCartModel> implements ShopCart_IView, ShopCartPort {
    @Bind(R.id.recView)
    RecyclerView recView;
    private List<ShopCartReponse.ShopsBean.ProductsBean> mData;
    private List<ShopCartReponse.ShopsBean.ProductsBean> mNewData;
    private ShopCartAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_shop_cart;
    }

    @Override
    public void initModel() {
        mModel = new ShopCartModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new ShopCartPresenter(this, mModel, this);
        mPresenter.getShopCartDatga("init");
    }

    @Override
    public void initView() {
        setTitle("购物车");
        setRightText("编辑全部");
        init();
    }

    private void init() {
        mData = new ArrayList<>();
        adapter = new ShopCartAdapter(mData, this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recView.setLayoutManager(manager);
        recView.setAdapter(adapter);

    }


    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();

    }

    @Override
    public void getShopCartData(ShopCartReponse data) {
        mNewData = new ArrayList<>();
        for (int i = 0; i < data.getShops().size(); i++) {
            ShopCartReponse.ShopsBean shop = data.getShops().get(i);
            for (int j = 0; j < shop.getProducts().size(); j++) {
                ShopCartReponse.ShopsBean.ProductsBean bean = shop.getProducts().get(j);
                bean.setShopId(shop.getShopId());
                bean.setShopName(shop.getShopName());
                mNewData.add(bean);
            }
        }
        setData();
    }

    //设置数据
    private void setData() {
        final NormalDecoration decoration = new NormalDecoration() {
            @Override
            public String getHeaderName(int pos) {
                return mNewData.get(pos).getShopName();
            }
        };
        decoration.setOnDecorationHeadDraw(new NormalDecoration.OnDecorationHeadDraw() {
            @Override
            public View getHeaderView(final int pos) {
                final View headView = LayoutInflater.from(ShopCartActivity.this).inflate(R.layout.item_head_shopcart_view, null,true);
                final TextView tiem = (TextView) headView.findViewById(R.id.tv_shop_name);
                final TextView t = (TextView) headView.findViewById(R.id.t);
                final TextView edit = (TextView) headView.findViewById(R.id.tv_edit);
                final ImageView select = (ImageView) headView.findViewById(R.id.iv_shop_select);

                tiem.setText(mNewData.get(pos).getShopName());
                return headView;
            }
        });
        recView.addItemDecoration(decoration);
        adapter.update(mNewData);
    }
}
