package com.coopbuy.mall.ui.module.center.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.center.port.ShopCartListener;
import com.coopbuy.mall.utils.ToastUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author csn
 * @date 2017/9/4 0004 14:45
 * @content
 */
public class MyExpanListViwAdapter extends BaseExpandableListAdapter {
    private List<ShopCartResponse.ShopsBean> mdata;
    private ShopCartListener mPort;
    private Context mContext;


    private boolean isMove = false;

    public MyExpanListViwAdapter(Context context, List<ShopCartResponse.ShopsBean> mdata, ShopCartListener port) {
        this.mdata = mdata;
        this.mContext = context;
        this.mPort = port;
    }

    @Override
    public int getGroupCount() {
        return mdata == null ? 0 : mdata.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return mdata.get(i).getProducts() == null ? 0 : mdata.get(i).getProducts().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupPosition;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mdata.get(groupPosition).getProducts().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return getCombinedGroupId(groupPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getCombinedChildId(groupPosition, childPosition);
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderParent viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolderParent();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_head_shopcart_view, parent, false);
            viewHolder.mShopName = convertView.findViewById(R.id.tv_shop_name);
            viewHolder.mEnterShop = convertView.findViewById(R.id.ll_enter_shop);
            viewHolder.mEdit = convertView.findViewById(R.id.tv_edit);
            viewHolder.mShopSelect = convertView.findViewById(R.id.iv_shop_select);
            viewHolder.mShopLlSelect = convertView.findViewById(R.id.ll_shop_select);
            viewHolder.mRlAgainBuy = convertView.findViewById(R.id.rl_preferential);
            viewHolder.mLineBig = convertView.findViewById(R.id.v_shopcart_line);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderParent) convertView.getTag();
        }
        //16px分割线 在第一行是需要隐藏 其他需要显示
        if (groupPosition == 0) {
            viewHolder.mLineBig.setVisibility(View.GONE);
        } else {
            viewHolder.mLineBig.setVisibility(View.VISIBLE);
        }
        viewHolder.mShopName.setText(mdata.get(groupPosition).getShopName());
        viewHolder.mEdit.setOnClickListener(new ShopMyPort(groupPosition));
        viewHolder.mEnterShop.setOnClickListener(new ShopMyPort(groupPosition));
        viewHolder.mShopLlSelect.setOnClickListener(new ShopMyPort(groupPosition));
        viewHolder.mRlAgainBuy.setOnClickListener(new ShopMyPort(groupPosition));
        setEditShow(groupPosition, viewHolder);
        setShopSelectStutas(groupPosition, viewHolder);
        //setLoseGoods(groupPosition, viewHolder);
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolderChlid viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolderChlid();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_shopcart_content_view, parent, false);
            viewHolder.mPrice = convertView.findViewById(R.id.tv_sale_price);
            viewHolder.mGoodsSelect = convertView.findViewById(R.id.iv_goods_select);
            viewHolder.imags = convertView.findViewById(R.id.adFaceImage);
            viewHolder.mGoodsName = convertView.findViewById(R.id.tv_goods_name);
            viewHolder.mCount = convertView.findViewById(R.id.tv_goods_counts);
            viewHolder.mViersion = convertView.findViewById(R.id.tv_goods_version);
            viewHolder.tvEditViersion = convertView.findViewById(R.id.tv_edit_version);
            viewHolder.mLlGoodsSelect = convertView.findViewById(R.id.ll_iamge_check);
            viewHolder.tvGoodsSub = convertView.findViewById(R.id.iv_goods_sub);
            viewHolder.ll_noClick = convertView.findViewById(R.id.ll_noClick);
            viewHolder.tvGoodsAdd = convertView.findViewById(R.id.iv_goods_add);
            viewHolder.edtGoodsNum = convertView.findViewById(R.id.et_item_shopcart_cloth_num);
            viewHolder.llNoEditContent = convertView.findViewById(R.id.ll_shopcart_content);
            viewHolder.rlEditContent = convertView.findViewById(R.id.ll_shopcart_edit);
            viewHolder.llEditVersion = convertView.findViewById(R.id.ll_edit_version);
         /*   viewHolder.tvEditViersion = convertView.findViewById(R.id.tv_goods_version_edit);
            viewHolder.llImageEditDeletShow = convertView.findViewById(R.id.ll_goods_eidt_show);
            viewHolder.llEditShow = convertView.findViewById(R.id.ll_content);
            viewHolder.llEditDelet = convertView.findViewById(R.id.ll_goods_edit_delete);

            viewHolder.flGoodsContent = convertView.findViewById(R.id.fl_goods_content);
            viewHolder.llShopTitleContent = convertView.findViewById(R.id.ll_shop_title);
            viewHolder.llTopLine = convertView.findViewById(R.id.ll_top_line);
            viewHolder.llEndLine = convertView.findViewById(R.id.ll_end_line);*/
            viewHolder.delete = convertView.findViewById(R.id.tv_delete);
            viewHolder.main = convertView.findViewById(R.id.main);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderChlid) convertView.getTag();
        }
        ShopCartResponse.ShopsBean.ProductsBean bean = mdata.get(groupPosition).getProducts().get(childPosition);
        viewHolder.mGoodsName.setText(bean.getShopName());
        viewHolder.mGoodsName.setText(bean.getProductName());
        viewHolder.mCount.setText(bean.getQuantity() != 0 ? "x" + bean.getQuantity() : "");
        viewHolder.mPrice.setText("￥" + bean.getUnitPrice() + "");
        String skuinfo = ((bean.getSpecifications() != null && !TextUtils.isEmpty(bean.getSpecifications())) ? bean.getSpecifications() : "") + ((bean.getProperties() != null && !TextUtils.isEmpty(bean.getProperties())) ? bean.getProperties() : "");
        if (TextUtils.isEmpty(skuinfo)) {
            skuinfo = "默认";
        }
        viewHolder.mViersion.setText(skuinfo);
        viewHolder.tvEditViersion.setText(skuinfo);
        viewHolder.edtGoodsNum.setText(bean.getQuantity() + "");
        viewHolder.imags.setImageURI(bean.getImageUrl());
        viewHolder.tvGoodsAdd.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        viewHolder.tvGoodsSub.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        viewHolder.ll_noClick.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        viewHolder.llEditVersion.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        // viewHolder.llEditShow.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
//        viewHolder.llEditDelet.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        //String url = sectionEntity.getImagePath() + CommonUtils.getImageNetSize(154);
        viewHolder.mLlGoodsSelect.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        viewHolder.main.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
       /* viewHolder.main.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                showLine(groupPosition, childPosition);
                return false;
            }
        });*/
        viewHolder.delete.setOnClickListener(new GoodsMyPort(groupPosition, childPosition));
        setEditStateShow(groupPosition, childPosition, viewHolder);
        setGoodsSelectStutas(groupPosition, childPosition, viewHolder);
        setSelectAll();
        //   setTopLine(groupPosition, childPosition, viewHolder);
        //  setLine(viewHolder);
        return convertView;
    }


    /**
     * 编辑显示还是完成显示
     */

    private void setEditShow(int parent, ViewHolderParent viewHolder) {
        if (mdata.get(parent).isLoseGoods()) {
            viewHolder.mEdit.setText("清空失效商品");
            viewHolder.mEdit.setTextColor(mContext.getResources().getColor(R.color.theme_text_title_orange));
            viewHolder.mEdit.setVisibility(View.VISIBLE);
        } else {
            viewHolder.mEdit.setTextColor(mContext.getResources().getColor(R.color.auxiliary_text_blue_gray));
        }
        if (ShopCartActivity.isAllEdit) {
            viewHolder.mEdit.setText("");
            viewHolder.mEdit.setVisibility(View.GONE);
        } else {
            viewHolder.mEdit.setVisibility(View.VISIBLE);
        }
        if (mdata.get(parent).isEdit()) {
            viewHolder.mEdit.setText("完成");
        } else {
            viewHolder.mEdit.setText("编辑");
        }
    }

    /**
     * 是否显示 失效商品
     *
     * @param position
     * @param headerViewHolder
     */
    private void setLoseGoods(int position, ViewHolderParent headerViewHolder) {
        if (mdata.get(position).isFristLoseGoods()) {
            headerViewHolder.mLlLoseGoods.setVisibility(View.VISIBLE);
        } else {
            headerViewHolder.mLlLoseGoods.setVisibility(View.GONE);
        }
    }

    private void setShopSelectStutas(int position, ViewHolderParent headerViewHolder) {
        //店铺是否选中
        if (!mdata.get(position).isLoseGoods() || ShopCartActivity.isAllEdit) {
            if (mdata.get(position).isShopSelect()) {
                headerViewHolder.mShopSelect.setImageResource(R.mipmap.icon_address_checked);
            } else {
                headerViewHolder.mShopSelect.setImageResource(R.mipmap.icon_address_unchecked);
            }
        } else { //失效重新处理
            //  headerViewHolder.mShopSelect.setImageResource(R.mipmap.icon_lose);
        }
    }

    private void setGoodsSelectStutas(int parent, int child, ViewHolderChlid itemViewHolder) {
        //店铺的商品是否被选中
        if (!mdata.get(parent).getProducts().get(child).isLoseGoods() || ShopCartActivity.isAllEdit) {
            if (mdata.get(parent).getProducts().get(child).isGoodsSelect()) {
                itemViewHolder.mGoodsSelect.setImageResource(R.mipmap.icon_address_checked);
            } else {
                itemViewHolder.mGoodsSelect.setImageResource(R.mipmap.icon_address_unchecked);
            }
        } else {
            // itemViewHolder.mGoodsSelect.setImageResource(R.mipmap.icon_lose);
        }
    }

    private void shopSelectAllOrNo(int parent) {
        ///设置店铺的相反选中状态
        if (!mdata.get(parent).isLoseGoods() || ShopCartActivity.isAllEdit) {//失效商品 不加入购物车
            Boolean isShopse = mdata.get(parent).isShopSelect();
            mdata.get(parent).setShopSelect(!mdata.get(parent).isShopSelect());
            for (int i = 0; i < mdata.get(parent).getProducts().size(); i++) {
                mdata.get(parent).getProducts().get(i).setGoodsSelect(!isShopse);
            }
        }
    }

    /**
     * 得到当前位置的商品 如果是选中的（isselect=true） 那么设置它为不选中 isSelect=false
     *
     * @param
     */
    private void goodsSelectAndShopSelectAll(int parent, int child) {
        if (!mdata.get(parent).getProducts().get(child).isLoseGoods() || ShopCartActivity.isAllEdit) {
            mdata.get(parent).getProducts().get(child).setGoodsSelect(!mdata.get(parent).getProducts().get(child).isGoodsSelect());
            //通过循环找出不同商铺的第一个商品的位置
            boolean isShop = true;
            for (int i = 0; i < mdata.get(parent).getProducts().size(); i++) {
                if (!mdata.get(parent).getProducts().get(i).isGoodsSelect()) {
                    isShop = false;
                    break;
                }
            }
            mdata.get(parent).setShopSelect(isShop);
        }
    }

    /**
     * 设置默认进来是全选
     */
    private void setSelectAll() {
        boolean isSelect = false;
        for (int i = 0; i < mdata.size(); i++) {
            if (mdata.get(i).isShopSelect()) {
                isSelect = true;
            } else {
                isSelect = false;
                break;
            }
        }
        mPort.selectFresh(isSelect);
    }

    /**
     * 根据店铺的编辑状态显示 内容是否是编辑的状态
     *
     * @param parent
     */
    private void setEditStateShow(int parent, int child, ViewHolderChlid viewHolder) {
        if (mdata.get(parent).isLoseGoods()) {
            viewHolder.llNoEditContent.setVisibility(View.VISIBLE);
            viewHolder.rlEditContent.setVisibility(View.GONE);
            return;
        }
        if (mdata.get(parent).getProducts().get(child).isEdit()) {
            viewHolder.llNoEditContent.setVisibility(View.GONE);
            viewHolder.rlEditContent.setVisibility(View.VISIBLE);
        } else {
            viewHolder.llNoEditContent.setVisibility(View.VISIBLE);
            viewHolder.rlEditContent.setVisibility(View.GONE);
        }
    }

   /* public void setTopLine(int parent, int child, ViewHolderChlid topLine) {
        LineToEnd lte = new LineToEnd(topLine.llTopLine, topLine.llEndLine);
        mMapTopLine.put(parent * 100 + child, lte);
    }*/

    class ShopMyPort implements View.OnClickListener {
        private int parent;

        public ShopMyPort(int parent) {
            this.parent = parent;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_enter_shop:
                    mPort.openShop(parent);
                    break;
                case R.id.rl_preferential:
                    ToastUtils.toastLong("凑单");
                    break;
                case R.id.tv_edit:
                    if (!mdata.get(parent).isEdit()) {
                        mdata.get(parent).setEdit(true);
                        for (int i = 0; i < mdata.get(parent).getProducts().size(); i++) {
                            mdata.get(parent).getProducts().get(i).setEdit(true);
                        }
                        mPort.swipEdit(true);
                    } else {
                        mdata.get(parent).setEdit(false);
                        for (int i = 0; i < mdata.get(parent).getProducts().size(); i++) {
                            mdata.get(parent).getProducts().get(i).setEdit(false);
                        }
                        mPort.swipEdit(false);
                    }
                    break;
                case R.id.ll_shop_select:
                    shopSelectAllOrNo(parent);
                    break;
            }
            notifyDataSetChanged();
        }
    }

    class GoodsMyPort implements View.OnClickListener {
        private int chlid;
        private int parent;

        public GoodsMyPort(int parent, int chlid) {
            this.chlid = chlid;
            this.parent = parent;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ll_iamge_check:
                    goodsSelectAndShopSelectAll(parent, chlid);
                    break;
             /*   case R.id.ll_content:
                    if (mdata.get(parent).getItems().get(chlid).getSkuInfo().equals("默认")) {
                        ToastUtil.TextToast(mContext, "没有可选规格了");
                        return;
                    }
                    mPort.openSelectSkuinfo(parent, chlid);
                    break;*/
                case R.id.iv_goods_add:
                    mPort.addSubGoods(parent, chlid, 0);
                    break;
                case R.id.ll_noClick:

                    break;
                case R.id.iv_goods_sub:
                    if (mdata.get(parent).getProducts().get(chlid).getQuantity() == 1) {
                        ToastUtils.toastShort("数量不能再少了");
                    } else {
                        mPort.addSubGoods(parent, chlid, 1);
                    }
                    break;
                case R.id.tv_delete:
                    mPort.delete(parent, chlid);
                    break;
                case R.id.ll_edit_version:
                    mPort.openVersionSelect(parent, chlid);
                    break;
                case R.id.main:
                    mPort.openGoodsDetial(parent, chlid);
                    break;
            }
            notifyDataSetChanged();
        }
    }

    public class ViewHolderParent {
        public TextView mShopName;
        public TextView mEdit;
        public ImageView mShopSelect;

        public LinearLayout mShopLlSelect;
        public LinearLayout mEnterShop;
        /**
         * 凑单
         */
        public RelativeLayout mRlAgainBuy;
        /**
         * 分割线 16px
         */
        public View mLineBig;
        /**
         * 失效商品
         */
        public LinearLayout mLlLoseGoods;
    }

    public class ViewHolderChlid {
        /**
         * 商品图片
         */
        public SimpleDraweeView imags;
        /**
         * 商品价格
         */
        public TextView mPrice;
        /**
         * 商品名称
         */
        public TextView mGoodsName;
        /**
         * 商品数量
         */
        public TextView mCount;
        /**
         * 商品规格 颜色 尺寸
         */
        public TextView mViersion;
        /**
         * 加载图片动画
         */
        // public SpinKitView mSpinKitView;
        /**
         * 商品选中的
         */
        public ImageView mGoodsSelect;
        /**
         * 增加点击选中图片的区域
         */
        public LinearLayout mLlGoodsSelect;
        /**
         * 如果是店铺的最后一个商品需要显示
         */
        public View vShowEnd;
        /**
         * 商品处于编辑状态 默认不显示
         */
        public LinearLayout rlEditContent;
        /**
         * 商品不处于编辑状态 默认显示
         */
        public LinearLayout llNoEditContent;
        /**
         * 商品可删除 点击图片 默认不显示
         */
        public LinearLayout llEditDelet;
        /**
         * 控制删除图片显示和不显示
         */
        public LinearLayout llImageEditDeletShow;
        public LinearLayout llEditShow;
        /**
         * 规格选择
         */
        public LinearLayout llEditVersion;
        public LinearLayout ll_noClick;
        /**
         * 编辑状态下的商品名称
         */
        public TextView tvEditViersion;
        /**
         * 商品数量的加减  和商品的数量
         */
        public LinearLayout tvGoodsAdd;
        public LinearLayout tvGoodsSub;
        public EditText edtGoodsNum;
        /**
         * 商品内容
         */
        public LinearLayout flGoodsContent;
        /**
         * 店铺内容
         */
        public LinearLayout llShopTitleContent;
        /**
         * 顶部和底部的线 实现 滑动时同时
         */
        public LinearLayout llTopLine;
        public LinearLayout llEndLine;
        public RelativeLayout main;
        /**
         * 图片删除
         */
        public TextView delete;
    }
}
