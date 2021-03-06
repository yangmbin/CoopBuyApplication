package com.coopbuy.mall.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.reponse.ShopCartResponse;
import com.coopbuy.mall.api.reponse.SkuDetailResponse;
import com.coopbuy.mall.api.reponse.SkuInfoResponse;
import com.coopbuy.mall.api.request.FindSkuInfoRequest;
import com.coopbuy.mall.api.request.GoodsUpdateRequest;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.ui.module.center.activity.ShopCartActivity;
import com.coopbuy.mall.ui.module.center.port.ShopCartListener;
import com.coopbuy.mall.ui.module.home.fragment.GoodsDetailFragment_1;
import com.coopbuy.mall.utils.StringUtils;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.tag.TagGroup;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;


public class ShopCartGoodsAttrsDialog implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private View mView, mClose;
    private Dialog dialog;
    private SimpleDraweeView mGoodsImage;
    private TextView mSellingPrice, mStock, mHaveSelected;
    private ImageView mDeleteCountBtn, mAddCountBtn;
    private TextView mCountTxt;
    private TextView mComplete;
    // 默认的购买数量
    private int mCount = 1;
    // 保存Sku信息
    private SkuDetailResponse.SkuInfoBean mSkuInfoBean;

    // 商品Id
    private int mProductId;
    private ShopCartListener port;
    private int mStockCount;
    //老skuid
    private int oldSkukid;
    private int oldCounts;
    private int newCounts;
    private int newSkuid;

    public ShopCartGoodsAttrsDialog(final Context context, List<SkuInfoResponse> list, SkuDetailResponse.SkuInfoBean bean, int productId, ShopCartListener port) {
        this.port = port;
        mSkuInfoBean = bean;
        mProductId = productId;
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_goods_attrs_shopcart, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.attrs_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        mAdapter = new ListAdapter(context, list);
        mRecyclerView.setAdapter(mAdapter);

        mClose = mView.findViewById(R.id.close);
        mGoodsImage = (SimpleDraweeView) mView.findViewById(R.id.goods_image);
        mSellingPrice = (TextView) mView.findViewById(R.id.sellingPrice);
        mStock = (TextView) mView.findViewById(R.id.stock);
        mHaveSelected = (TextView) mView.findViewById(R.id.have_selected);
        mDeleteCountBtn = (ImageView) mView.findViewById(R.id.delete_count);
        mAddCountBtn = (ImageView) mView.findViewById(R.id.add_count);
        mCountTxt = (TextView) mView.findViewById(R.id.count);
        mComplete = (TextView) mView.findViewById(R.id.tv_complete);
        mClose.setOnClickListener(this);
        mDeleteCountBtn.setOnClickListener(this);
        mAddCountBtn.setOnClickListener(this);
        mComplete.setOnClickListener(this);
        mCountTxt.setText(ShopCartActivity.skuinfoStockCount + "");
        mCount = ShopCartActivity.skuinfoStockCount;
        oldCounts = mCount;
        // 设置风格
        setPopWindowStyle();
        // 设置Sku信息显示
        setSkuInfoData(mSkuInfoBean, "old");
        // 设置购买数量
        setCount();
    }

    public void showAtBottom() {
        dialog.show();
    }

    private void setPopWindowStyle() {
        dialog.setContentView(mView);
        Window dialogWindow = dialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        dialogWindow.setAttributes(lp);
        // mView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = mView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dialog.dismiss();
                    }
                }
                return true;
            }
        });
    }

    /**
     * 适配器
     */
    class ListAdapter extends BaseRecyclerAdapter<SkuInfoResponse> {

        Context context;

        public ListAdapter(Context ctx, List<SkuInfoResponse> list) {
            super(ctx, list);
            context = ctx;
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_goods_attrs_dialog_shopcart;
        }

        @Override
        protected void bindData(final BaseRecyclerHolder holder, final int position, SkuInfoResponse item) {
            holder.getTextView(R.id.name).setText(item.getName());
            TagGroup tagGroup = (TagGroup) holder.getView(R.id.tag_group);
            tagGroup.setTags(item.getValues());

            tagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
                @Override
                public void onTagClick(String tag) {
                    Log.e("yangmbin", "tag:" + tag);
                    FindSkuInfoRequest request = new FindSkuInfoRequest();
                    request.setProductId(mProductId);
                    if (position == 0) {
                        request.setPropertyValue(tag);
                        request.setSpecificationValue(mSkuInfoBean.getPriceSpecificationsValue());
                        mSkuInfoBean.setPricePropertyValue(tag);
                    } else {
                        request.setPropertyValue(mSkuInfoBean.getPricePropertyValue());
                        request.setSpecificationValue(tag);
                        mSkuInfoBean.setPriceSpecificationsValue(tag);
                    }
                    //  mFragment.findSkuInfoData(request);
                    if (port != null) {
                        port.findSkuinfo(request);
                    }
                }
            });

            // 设置默认的选中状态
            if (position == 0)
                tagGroup.setSelected(mSkuInfoBean.getPricePropertyValue());
            else if (position == 1)
                tagGroup.setSelected(mSkuInfoBean.getPriceSpecificationsValue());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                dialog.dismiss();
                break;
            case R.id.delete_count:
                if (mCount > 1) {
                    --mCount;
                    setCount();
                } else {
                    ToastUtils.toastShort("数量不能再少了！");
                }
                newCounts = mCount;
                break;
            case R.id.add_count:
                ++mCount;
                if (mStockCount < mCount) {
                    ToastUtils.toastShort("库存不足");
                    --mCount;
                    return;
                }
                setCount();
                newCounts = mCount;
                break;
            case R.id.tv_complete:
                if (oldSkukid != newSkuid || newCounts != oldCounts) {
                    GoodsUpdateRequest request = new GoodsUpdateRequest();
                    GoodsUpdateRequest.SkuIdsBean bean = new GoodsUpdateRequest.SkuIdsBean();
                    List<GoodsUpdateRequest.SkuIdsBean> data = new ArrayList<>();
                    bean.setQuantity(mCount);
                    bean.setSkuId(oldSkukid);
                    bean.setNewSkuId(newSkuid);
                    data.add(bean);
                    request.setSkuIds(data);
                    if (port != null) {
                        port.getNewSkuinfo(request);
                    }
                }
                dialog.dismiss();
                break;
        }

    }

    /**
     * 设置Sku信息
     *
     * @param skuInfoBean
     */
    public void setSkuInfoData(SkuDetailResponse.SkuInfoBean skuInfoBean, String type) {
        if (type.equals("old")) {
            oldSkukid = skuInfoBean.getSkuId();
        } else {
            newSkuid = skuInfoBean.getSkuId();

        }
        mGoodsImage.setImageURI(Uri.parse(skuInfoBean.getImageUrl()));
        mSellingPrice.setText("￥" + StringUtils.keepTwoDecimalPoint(skuInfoBean.getSellingPrice()));
        mStockCount = skuInfoBean.getStock();
        mStock.setText("库存" + mStockCount + "件");
        mHaveSelected.setText("已选：");
        mHaveSelected.append(!TextUtils.isEmpty(skuInfoBean.getPricePropertyValue()) ? "“" + skuInfoBean.getPricePropertyValue() + "” " : "");
        mHaveSelected.append(!TextUtils.isEmpty(skuInfoBean.getPriceSpecificationsValue()) ? "“" + skuInfoBean.getPriceSpecificationsValue() + "” " : "");
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 设置购买数量
     */
    private void setCount() {
        mCountTxt.setText("" + mCount);
    }
}