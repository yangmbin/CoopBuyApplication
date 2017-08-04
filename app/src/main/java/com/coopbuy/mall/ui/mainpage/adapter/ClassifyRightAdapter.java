package com.coopbuy.mall.ui.mainpage.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import com.coopbuy.mall.R;
import com.coopbuy.mall.api.Constant;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * 分类左边列表适配器
 * @author ymb
 * Create at 2017/8/3 11:44
 */
public class ClassifyRightAdapter extends BaseRecyclerAdapter<Object> {

    private List<Object> list;
    private View.OnClickListener mListener;

    public ClassifyRightAdapter(Context ctx, List<Object> list, View.OnClickListener listener) {
        super(ctx, list);
        this.list = list;
        this.mListener = listener;
    }

    @Override
    protected int getItemLayoutId(int viewType) {
        if (viewType == 0)
            return R.layout.item_1_classify_right_list;
        else
            return R.layout.item_2_classify_right_list;
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof String)
            return 0;
        else
            return 1;
    }

    @Override
    protected void bindData(final BaseRecyclerHolder holder, int position, Object item) {
        if (item instanceof String) {
            TextView categoryName = holder.getTextView(R.id.tv_category_name);
            categoryName.setText((String) item);
        } else {
            List<ClassifyRightAdapter.GoodsCategoryItem> horizontalList = (List<ClassifyRightAdapter.GoodsCategoryItem>) item;
            holder.getView(R.id.ll_category_item_1).setTag(-1);
            holder.getView(R.id.ll_category_item_2).setTag(-1);
            holder.getView(R.id.ll_category_item_3).setTag(-1);
            // 避免视图复用导致空数据的位置显示之前的数据
            holder.getView(R.id.ll_category_item_1).setVisibility(View.INVISIBLE);
            holder.getView(R.id.ll_category_item_2).setVisibility(View.INVISIBLE);
            holder.getView(R.id.ll_category_item_3).setVisibility(View.INVISIBLE);

            for (int i = 0; i < horizontalList.size(); i++) {
                if (i == 0) {
                    holder.getTextView(R.id.tv_category_name_1).setText((horizontalList.get(i)).getCategoryName());
                    ((SimpleDraweeView) holder.getView(R.id.sdv_category_img_1)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                    holder.getView(R.id.ll_category_item_1).setTag((horizontalList.get(i)).getId());
                    holder.getView(R.id.ll_category_item_1).setVisibility(View.VISIBLE);
                } else if (i == 1) {
                    holder.getTextView(R.id.tv_category_name_2).setText((horizontalList.get(i)).getCategoryName());
                    ((SimpleDraweeView) holder.getView(R.id.sdv_category_img_2)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                    holder.getView(R.id.ll_category_item_2).setTag((horizontalList.get(i)).getId());
                    holder.getView(R.id.ll_category_item_2).setVisibility(View.VISIBLE);
                } else {
                    holder.getTextView(R.id.tv_category_name_3).setText((horizontalList.get(i)).getCategoryName());
                    ((SimpleDraweeView) holder.getView(R.id.sdv_category_img_3)).setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                    holder.getView(R.id.ll_category_item_3).setTag((horizontalList.get(i)).getId());
                    holder.getView(R.id.ll_category_item_3).setVisibility(View.VISIBLE);
                }
            }

            holder.getView(R.id.ll_category_item_1).setOnClickListener(mListener);
            holder.getView(R.id.ll_category_item_2).setOnClickListener(mListener);
            holder.getView(R.id.ll_category_item_3).setOnClickListener(mListener);
        }
    }

    public static class GoodsCategoryItem {
        private String imageUrl;
        private String categoryName;
        private int id;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "GoodsCategoryItem{" +
                    "imageUrl='" + imageUrl + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    ", id=" + id +
                    '}';
        }
    }
}
