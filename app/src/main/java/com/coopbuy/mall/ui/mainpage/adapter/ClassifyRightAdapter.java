package com.coopbuy.mall.ui.mainpage.adapter;

import android.content.Context;
import android.net.Uri;
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

    public ClassifyRightAdapter(Context ctx, List<Object> list) {
        super(ctx, list);
        this.list = list;
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
    protected void bindData(BaseRecyclerHolder holder, int position, Object item) {
        if (item instanceof String) {
            TextView categoryName = holder.getTextView(R.id.tv_category_name);
            categoryName.setText((String) item);
        } else {
            List<ClassifyRightAdapter.GoodsCategoryItem> horizontalList = (List<ClassifyRightAdapter.GoodsCategoryItem>) item;
            for (int i = 0; i < horizontalList.size(); i++) {
                if (i == 0) {
                    TextView categoryName = holder.getTextView(R.id.tv_category_name_1);
                    categoryName.setText((horizontalList.get(i)).getCategoryName());
                    SimpleDraweeView categoryImage = (SimpleDraweeView) holder.getView(R.id.sdv_category_img_1);
                    categoryImage.setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                } else if (i == 1) {
                    TextView categoryName = holder.getTextView(R.id.tv_category_name_2);
                    categoryName.setText((horizontalList.get(i)).getCategoryName());
                    SimpleDraweeView categoryImage = (SimpleDraweeView) holder.getView(R.id.sdv_category_img_2);
                    categoryImage.setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                } else {
                    TextView categoryName = holder.getTextView(R.id.tv_category_name_3);
                    categoryName.setText((horizontalList.get(i)).getCategoryName());
                    SimpleDraweeView categoryImage = (SimpleDraweeView) holder.getView(R.id.sdv_category_img_3);
                    categoryImage.setImageURI(Uri.parse(Constant.IMAGE_SERVER_URL + (horizontalList.get(i)).getImageUrl()));
                }
            }
        }
    }

    public static class GoodsCategoryItem {
        private String imageUrl;
        private String categoryName;

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

        @Override
        public String toString() {
            return "GoodsCategoryItem{" +
                    "imageUrl='" + imageUrl + '\'' +
                    ", categoryName='" + categoryName + '\'' +
                    '}';
        }
    }
}
