package com.coopbuy.mall.ui.module.center.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.GoodsDeleteRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;
import com.coopbuy.mall.base.BaseActivity;
import com.coopbuy.mall.ui.module.center.adapter.MyExpanListViwAdapter;
import com.coopbuy.mall.ui.module.center.model.ShopCartModel;
import com.coopbuy.mall.ui.module.center.port.ShopCartListener;
import com.coopbuy.mall.ui.module.center.presenter.ShopCartPresenter;
import com.coopbuy.mall.ui.module.center.view.ShopCart_IView;
import com.coopbuy.mall.ui.module.home.activity.GoodsDetailActivity;
import com.coopbuy.mall.utils.IntentUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.dialog.GoodsAttrsDialog;
import com.coopbuy.mall.widget.dialog.ShopCartGoodsAttrsDialog;
import com.coopbuy.mall.widget.swipeitem.SwipeExpandableListView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;

public class ShopCartActivity extends BaseActivity<ShopCartPresenter, ShopCartModel> implements ShopCart_IView, ShopCartListener {

    @Bind(R.id.swipe_target)
    SwipeExpandableListView mListView;
    /**
     * 支付栏   没有数据是不显示
     */
    @Bind(R.id.l_pay)
    LinearLayout lPay;
    @Bind(R.id.ll_shopcart_submit)
    LinearLayout llShopcartSubmit;
    @Bind(R.id.tv_shopcart_addselect)
    ImageView mAllSelect;
    @Bind(R.id.tv_shopcart_totalprice)
    TextView mTvShopCartTotalPrice;
    /**
     * 结算数量
     */
    @Bind(R.id.tv_goods_submit_count)
    TextView mGoodsSubmitCount;
    /**
     * 全部编辑
     */
    @Bind(R.id.txt_titlebar_right)
    TextView mEditAll;
    /**
     * 结算编辑 隐藏
     */
    @Bind(R.id.ll_shopcart_count_price)
    LinearLayout llShopcartContPrice;
    /**
     * 移入收藏
     */
    @Bind(R.id.tv_goods_delete)
    TextView mDeleteGoodsAll;
    /**
     * 全选状态记录
     */
    private boolean mSelect;
    /**
     * 商品
     */
    private List<ShopCartResponse.ShopsBean> mData;
    private MyExpanListViwAdapter mAdapter;
    /**
     * 是否处于编辑状态 编辑状态失效商品是可以编辑的
     */
    public static boolean isAllEdit = false;
    /**
     * 在商品规格skuid发生改变时  数据更新时只更新对应的商品
     */
    private boolean isChangeGoodsSkuinfo = false;
    private Boolean isUse = false;//是否使用记录的信息 比如店铺选中状态
    /**
     * 是否是失效商品 在购物车都是失效商品 点击全选 提示为 失效不能结算
     */
    private boolean isLoseData = false;
    /**
     * 待购买的商品列表
     */
    private List<ShopCartResponse.ShopsBean.ProductsBean> mGoPayList;
    /**
     * 数量 和 位置  加减数量时
     */
    private int mCount, mPosition;
    private Double mTotalPrice1;
    // 属性弹框
    private ShopCartGoodsAttrsDialog goodsAttrsDialog = null;
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
        mPresenter.getShopCartDate("init");
    }

    @Override
    public void initView() {
        setTitle("购物车");
        setRightText("编辑全部");
        init();
    }

    private void init() {
        mData = new ArrayList<>();
        mGoPayList = new ArrayList<>();
        mListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                return true;
            }
        });
        initAdapter();
    }

    //店铺选中
    private Map<Integer, Boolean> shop = new HashMap<>();
    //商品选中
    private Map<String, Boolean> goods = new HashMap<>();
    //店铺失效图片
    private Map<Integer, Boolean> shopLose = new HashMap<>();
    //失效商品
    private Map<String, Boolean> goodsLose = new HashMap<>();
    //控制失效标题的
    private Map<Integer, Boolean> fristshopLose = new HashMap<>();
    //商品对应的编辑
    private Map<String, Boolean> goodsEdit = new HashMap<>();
    private boolean isDataChange = false;
    /**
     * 店铺的编辑状态
     */
    private Map<Integer, Boolean> shopEdit = new HashMap<>();

    /**
     * 得到选中的各种状态 包括 店铺 商店选中 是否显示的选中使用集合来保存 在刷新是重新给定数据
     */
    private void getSelectState() {
        for (int i = 0; i < mData.size(); i++) {
            ShopCartResponse.ShopsBean bena = mData.get(i);
            for (int j = 0; j < bena.getProducts().size(); j++) {
                ShopCartResponse.ShopsBean.ProductsBean item = bena.getProducts().get(j);
                shop.put(bena.getShopId(), bena.isShopSelect());
                shopEdit.put(bena.getShopId(), bena.isEdit());
                shopLose.put(bena.getShopId(), bena.isLoseGoods());
                fristshopLose.put(bena.getShopId(), bena.isFristLoseGoods());
                goods.put(item.getSkuId() + "", item.isGoodsSelect());
                goodsLose.put(item.getSkuId() + "", item.isLoseGoods());
                goodsEdit.put(item.getSkuId() + "", item.isEdit());
                isUse = true;
            }
        }
    }

    /**
     * 购物车数据数量变换 使用新数据
     *
     * @param datas
     * @return
     */
    private void numberChange(ShopCartResponse datas) {
        int count = 0;
        int mcount = 0;
        if (null != datas.getShops())
            for (int i = 0; i < datas.getShops().size(); i++) {
                count += datas.getShops().get(i).getProducts().size();
            }
        if (null != datas.getInvalidProducts())
            for (int i = 0; i < datas.getInvalidProducts().size(); i++) {
                count += datas.getInvalidProducts().get(i).getProducts().size();
            }
        for (int i = 0; i < mData.size(); i++) {
            mcount += mData.get(i).getProducts().size();
        }
        if (count == mcount) {
            isDataChange = true;
        } else {
            isDataChange = false;
        }
    }

    @Override
    public void clickTitleBarRight() {
        super.clickTitleBarRight();

    }

    @Override
    public void getShopCartData(ShopCartResponse datas) {

       /* if (!isChangeGoodsSkuinfo) {
            if (!mData.isEmpty()) {
                getSelectState();
                numberChange(datas);
                mData.clear();
            } else {
                isUse = false;
            }*/
        if (!this.mData.isEmpty()) {
            this.mData.clear();
        }
        if (datas != null && !datas.getShops().isEmpty()) {
            for (int i = 0; i < datas.getShops().size(); i++) {
                ShopCartResponse.ShopsBean shopBean = datas.getShops().get(i);
                for (int j = 0; j < shopBean.getProducts().size(); j++) {
                    ShopCartResponse.ShopsBean.ProductsBean itemsBean = shopBean.getProducts().get(j);
                    itemsBean.setGoodsSelect(false);
                    itemsBean.setShopSelect(false);
                    itemsBean.setDeleteImageShow(false);
                    itemsBean.setLoseGoods(false);
                    itemsBean.setShopId(shopBean.getShopId());
                    itemsBean.setShopName(shopBean.getShopName());
                    if (j == shopBean.getProducts().size() - 1) {//记录最后一个 来显示10px的控件
                        itemsBean.setEnd(true);
                    } else {
                        itemsBean.setEnd(false);
                    }
                }
                mData.add(shopBean);
            }
        }
          /*  if (datas != null && !datas.getInvalidProducts().isEmpty()) {
                for (int i = 0; i < datas.getInvalidProducts().size(); i++) {
                    ShopCartResponse.InvalidProductsBean inv = datas.getInvalidProducts().get(i);
                    ShopCartResponse.ShopsBean shopBean = new ShopCartResponse.ShopsBean();
                    shopBean.setProducts(inv.getProducts());
                    shopBean.setShopName(inv.getShopName());
                    shopBean.setShopId(inv.getShopId());
                    shopBean.setLoseGoods(true);
                    if (i == 0) {
                        shopBean.setFristLoseGoods(true);
                    } else {
                        shopBean.setFristLoseGoods(false);
                    }
                    for (int j = 0; j < shopBean.getItems().size(); j++) {
                        ShopCartResponse.ShopsBean.ItemsBean itemsBean = shopBean.getItems().get(j);
                        itemsBean.setGoodsSelect(false);
                        itemsBean.setShopSelect(false);
                        itemsBean.setDeleteImageShow(false);
                        itemsBean.setLoseGoods(false);
                        itemsBean.setLoseGoods(true);
                        itemsBean.setShopId(shopBean.getShopId());
                        itemsBean.setShopName(shopBean.getShopName());
                        itemsBean.setShopLogoPath(shopBean.getShopLogoPath());
                        if (j == shopBean.getItems().size() - 1) {//记录最后一个 来显示10px的控件
                            itemsBean.setEnd(true);
                        } else {
                            itemsBean.setEnd(false);
                        }
                    }
                    mData.add(shopBean);
                }
            }*/
           /* if (isUse && isDataChange) {
                setSelectState();
                mAdapter.notifyDataSetChanged();
            } else {*/
        setView();
        //  }
    /*    } else {*/
           /* ShopCartResponse.ShopsBean.ItemsBean newItemsBean = new ShopCartResponse.ShopsBean.ItemsBean();
            ShopCartResponse.ShopsBean.ItemsBean oldItemsBean = new ShopCartResponse.ShopsBean.ItemsBean();
            if (datas != null && !datas.getShops().isEmpty()) {//只更新修改规格的商品数据 有效商品
                for (int i = 0; i < datas.getShops().size(); i++) {
                    ShopCartResponse.ShopsBean shopBean = datas.getShops().get(i);
                    for (int j = 0; j < shopBean.getItems().size(); j++) {
                        if (null != shopBean.getItems().get(j).getSkuId())
                            if (mNewSkuinfo.equals(shopBean.getItems().get(j).getSkuId())) {//
                                newItemsBean = shopBean.getItems().get(j);
                                break;
                            }
                    }
                }
                for (int i = 0; i < mData.size(); i++) {
                    for (int j = 0; j < mData.get(i).getItems().size(); j++) {
                        if (null != mData.get(i).getItems().get(j).getSkuId())
                            if (mOldSkuinfo.equals(mData.get(i).getItems().get(j).getSkuId())) {
                                oldItemsBean = mData.get(i).getItems().get(j);
                                break;
                            }
                    }
                }
            }
            if (datas != null && !datas.getInvalidShops().isEmpty()) {//失效商品
                for (int i = 0; i < datas.getInvalidShops().size(); i++) {
                    ShopCartResponse.InvalidShopsBean shopBean = datas.getInvalidShops().get(i);
                    for (int j = 0; j < shopBean.getItems().size(); j++) {
                        if (null != shopBean.getItems().get(j).getSkuId())
                            if (mNewSkuinfo.equals(shopBean.getItems().get(j).getSkuId())) {//
                                newItemsBean = shopBean.getItems().get(j);
                                break;
                            }
                    }
                }
                for (int i = 0; i < mData.size(); i++) {
                    for (int j = 0; j < mData.get(i).getItems().size(); j++) {
                        if (null != mData.get(i).getItems().get(j).getSkuId())
                            if (mOldSkuinfo.equals(mData.get(i).getItems().get(j).getSkuId())) {
                                oldItemsBean = mData.get(i).getItems().get(j);
                                break;
                            }
                    }
                }
            }
            oldItemsBean.setSkuId(newItemsBean.getSkuId());
            oldItemsBean.setImagePath(newItemsBean.getImagePath());
            oldItemsBean.setId(newItemsBean.getId());
            oldItemsBean.setSkuInfo(newItemsBean.getSkuInfo());
            oldItemsBean.setSuggestPrice(newItemsBean.getSuggestPrice());
            oldItemsBean.setSalePrice(newItemsBean.getSalePrice());
            oldItemsBean.setProductName(newItemsBean.getProductName());
            oldItemsBean.setProductId(newItemsBean.getProductId());
            mAdapter.notifyDataSetChanged();
            isChangeGoodsSkuinfo = false;
        }*/
    }

    private void initAdapter() {
        mAdapter = new MyExpanListViwAdapter(this, mData, this);
        mListView.setAdapter(mAdapter);
        mListView.setDividerHeight(0);
    }

    private void noExpand() {
        int size = mListView.getCount();
        for (int i = 0; i < size; i++) {
            mListView.expandGroup(i);
        }
    }

    private void setView() {
        initAdapter();
        noExpand();
        lPay.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();
        mEditAll.setText("全部编辑");
        setSubmitCollect(false);
        mEditAll.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.ll_all_select, R.id.ll_shopcart_submit, R.id.txt_titlebar_right, R.id.tv_goods_delete})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_goods_delete:
                if (!mGoPayList.isEmpty()) {
                    mPresenter.deleteGoods(deleteGoodsSkuinfos());
                } else {
                    ToastUtils.toastShort("请选择输出的商品");
                }
                break;
            case R.id.ll_all_select:
                setAllSelect();
                break;
            case R.id.ll_shopcart_submit: //这里用mGoPayList 判断有问题  因为
                if (!mGoPayList.isEmpty()) {
                    IntentUtils.gotoActivity(this, OrderBuildActivity.class);
                } else {
                    if (isLoseData) {
                        ToastUtils.toastShort("失效商品不能结算");
                    } else {
                        ToastUtils.toastShort("请选择商品");
                    }
                }
                break;
            case R.id.txt_titlebar_right:
                if (mEditAll.getText().toString().trim().equals("全部编辑")) {
                    isAllEdit = true;
                    mEditAll.setText("完成");
                    setSubmitCollect(true);
                    setEditAll(true);
                    llShopcartSubmit.setBackgroundResource(R.color.auxiliary_text_red);
                } else {
                    isAllEdit = false;
                    mEditAll.setText("全部编辑");
                    setSubmitCollect(false);
                    setEditAll(false);
                    llShopcartSubmit.setBackgroundResource(R.color.theme_text_title_orange);
                }
                break; //全部编辑
        }
    }

    /**
     * 点击全部编辑  本身需要变为完成 对应的店铺是编辑状态
     */
    private void setEditAll(boolean isEditall) {
        for (int i = 0; i < mData.size(); i++) {
            mData.get(i).setEdit(isEditall);
            for (int j = 0; j < mData.get(i).getProducts().size(); j++) {
                mData.get(i).getProducts().get(j).setEdit(isEditall);
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 全选监听处理
     */
    private void setAllSelect() {
        mSelect = !mSelect;
        if (mSelect) {
            mAllSelect.setBackgroundResource(R.mipmap.icon_address_checked);
            for (int i = 0; i < mData.size(); i++) {
                mData.get(i).setShopSelect(true);
                for (int j = 0; j < mData.get(i).getProducts().size(); j++) {
                    mData.get(i).getProducts().get(j).setGoodsSelect(true);
                }
                if (!mData.get(i).isLoseGoods()) {
                    isLoseData = false;
                } else {
                    isLoseData = true;
                }
            }
        } else {
            mAllSelect.setBackgroundResource(R.mipmap.iocn_bind_uncheck);
            for (int i = 0; i < mData.size(); i++) {
                mData.get(i).setShopSelect(false);
                for (int j = 0; j < mData.get(i).getProducts().size(); j++) {
                    mData.get(i).getProducts().get(j).setGoodsSelect(false);
                }
            }
            isLoseData = false;
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 删除是 隐藏价格
     *
     * @param isShow
     */
    private void setSubmitCollect(boolean isShow) {
        if (isShow) {
            llShopcartContPrice.setVisibility(View.INVISIBLE);
            mGoodsSubmitCount.setVisibility(View.GONE);
            mDeleteGoodsAll.setVisibility(View.VISIBLE);
        } else {
            llShopcartContPrice.setVisibility(View.VISIBLE);
            mGoodsSubmitCount.setVisibility(View.VISIBLE);
            mDeleteGoodsAll.setVisibility(View.GONE);
        }
    }

    @Override
    public void selectFresh(boolean isSelect) {
        mSelect = isSelect;
        if (isSelect) {
            mAllSelect.setBackgroundResource(R.mipmap.icon_address_checked);
        } else {
            mAllSelect.setBackgroundResource(R.mipmap.icon_address_unchecked);
        }
        Double mTotalPrice = 0.00;
        int mTotalNum = 0;
        mTotalPrice1 = 0.00;
        mGoPayList.clear();
        for (int i = 0; i < mData.size(); i++)
            if (!mData.get(i).isLoseGoods())//失效商品不能计算价格，
                for (int j = 0; j < mData.get(i).getProducts().size(); j++) {
                    if (mData.get(i).getProducts().get(j).isGoodsSelect()) {
                        mTotalPrice += mData.get(i).getProducts().get(j).getUnitPrice() * mData.get(i).getProducts().get(j).getQuantity();
                        mTotalNum += mData.get(i).getProducts().get(j).getQuantity();
                        mGoPayList.add(mData.get(i).getProducts().get(j));
                    }
                }
        DecimalFormat df = new DecimalFormat("0.00");
        mTotalPrice1 = mTotalPrice;
        if (mTotalPrice == 0) {
            mTvShopCartTotalPrice.setText("￥" + "0.00");
        } else {
            mTvShopCartTotalPrice.setText("￥" + df.format(mTotalPrice));
        }
        mGoodsSubmitCount.setText("结算(" + mTotalNum + ")");
    }

    @Override
    public void swipEdit(boolean isSwip) {

    }

    /**
     * 获得多个删除的skuinfo数据
     */
    private GoodsDeleteRequest deleteGoodsSkuinfos() {
        GoodsDeleteRequest request = new GoodsDeleteRequest();
        List<Integer> skuinfos = new ArrayList<>();
        for (int i = 0; i < mGoPayList.size(); i++) {
            skuinfos.add(mGoPayList.get(i).getSkuId());
        }
        request.setSkuIds(skuinfos);
        return request;
    }

    @Override
    public void addSubGoods(int postion, int child, int type) {
        GoodsUpdateRequest request = new GoodsUpdateRequest();
        List<GoodsUpdateRequest.SkuIdsBean> updates = new ArrayList<>();
        GoodsUpdateRequest.SkuIdsBean bean = new GoodsUpdateRequest.SkuIdsBean();
        bean.setSkuId(mData.get(postion).getProducts().get(child).getSkuId());
        int quantity = mData.get(postion).getProducts().get(child).getQuantity();
        if (type == 0) {
            quantity++;
        } else {
            quantity--;
        }
        bean.setQuantity(quantity);
        updates.add(bean);
        request.setSkuIds(updates);
        mPresenter.goodsUpdateCounts(request, postion, child, type);
    }

    @Override
    public void addSubSuccess(int postion, int child, int type) {
        int addsub = mData.get(postion).getProducts().get(child).getQuantity();
        if (type == 0) {
            addsub++;
        } else {
            addsub--;
            if (addsub == 0) {
                addsub = 1;
            }
        }
        mData.get(postion).getProducts().get(child).setQuantity(addsub);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void delete(int postion, int child) {
        GoodsDeleteRequest request = new GoodsDeleteRequest();
        List<Integer> skuinfns = new ArrayList<>();
        skuinfns.add(mData.get(postion).getProducts().get(child).getSkuId());
        request.setSkuIds(skuinfns);
        mPresenter.deleteGoods(request, postion, child);
    }

    @Override
    public void deleteItemSuccess(int parent, int child) {
        mData.get(parent).getProducts().remove(child);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void setSkuInfoListData(List<SkuInfoResponse> skuInfoResponses,int prant,int child) {
     /*   if (skuInfoResponses != null && skuInfoResponses.size() > 0) {
            goodsAttrsDialog = new ShopCartGoodsAttrsDialog(mContext,  skuInfoResponses, mData.get(prant).getProducts().get(child));
            goodsAttrsDialog.showAtBottom();
        }*/
    }

    @Override
    public void openGoodsDetial(int parent, int child) {
        IntentUtils.gotoActivity(this, GoodsDetailActivity.class, mData.get(parent).getProducts().get(child).getProductId(), mData.get(parent).getProducts().get(child).getSkuId());
    }

    @Override
    public void openSelectSkuinfo(int prarent, int child) {

    }

    @Override
    public void openShop(int prarent) {

    }

    @Override
    public void updateGoodsSkuinfoSuccess() {

    }

    @Override
    public void deleteMoreSuccess() {
        mPresenter.getShopCartDate("again");
      /*  for (int i = 0; i < mData.size(); i++) {
            for (int j = 0; j < mData.get(i).getProducts().size(); j++) {
                if (mData.get(i).isShopSelect()) {
                    mData.remove(i);
                    break;
                } else {
                    mData.get(i).getProducts().remove(j);
                }
            }
        }*/
       /* if (!mGoPayList.isEmpty())
            mGoPayList.clear();
        mAdapter.notifyDataSetChanged();*/
    }
}
