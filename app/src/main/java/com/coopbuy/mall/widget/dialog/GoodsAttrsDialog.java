package com.coopbuy.mall.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.coopbuy.mall.R;
import com.coopbuy.mall.base.BaseRecyclerAdapter;
import com.coopbuy.mall.base.BaseRecyclerHolder;
import com.coopbuy.mall.utils.ToastUtils;
import com.coopbuy.mall.widget.tag.TagGroup;

import java.util.ArrayList;
import java.util.List;


public class GoodsAttrsDialog implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private View mView, mClose;
    private Dialog dialog;

    public GoodsAttrsDialog(final Context context, final List<String> list) {
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_goods_attrs, null);
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
        mClose.setOnClickListener(this);

        // 设置风格
        setPopWindowStyle();
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
                if(event.getAction() == MotionEvent.ACTION_UP){
                    if(y < height){
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
    class ListAdapter extends BaseRecyclerAdapter<String> {

        Context context;

        public ListAdapter(Context ctx, List<String> list) {
            super(ctx, list);
            context = ctx;
        }

        @Override
        protected int getItemLayoutId(int viewType) {
            return R.layout.item_goods_attrs_dialog;
        }

        @Override
        protected void bindData(final BaseRecyclerHolder holder, final int position, String item) {
            List<String> tags = new ArrayList<>();
            tags.add("飞机快圣诞节疯狂的");
            tags.add("飞节疯狂的");
            tags.add("疯狂的");
            tags.add("飞狂的");
            tags.add("飞机节疯狂的");
            tags.add("飞机快圣诞节疯狂的");
            tags.add("飞机快疯狂的");
            tags.add("飞机狂的");
            tags.add("飞机快节疯狂的");
            tags.add("飞机快圣诞疯狂的");
            tags.add("飞机快疯狂的");
            tags.add("飞机快圣诞节疯狂的");
            tags.add("飞机的");
            tags.add("飞机快圣的");
            tags.add("飞机快圣诞节疯狂的");

            TagGroup tagGroup = (TagGroup) holder.getView(R.id.tag_group);
            tagGroup.setTags(tags);

            tagGroup.setOnTagClickListener(new TagGroup.OnTagClickListener() {
                @Override
                public void onTagClick(String tag) {
                    ToastUtils.toastShort("haha");
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.close:
                dialog.dismiss();
                break;
        }
    }
}