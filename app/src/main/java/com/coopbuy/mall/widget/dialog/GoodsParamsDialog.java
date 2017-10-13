package com.coopbuy.mall.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v4.content.ContextCompat;
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

import java.util.List;

public class GoodsParamsDialog {

    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;
    private View mView, mBtnConfirm;
    private Dialog dialog;
    private int mSelect = 0;

    public GoodsParamsDialog(final Context context, final List<String> list) {
        dialog = new Dialog(context, R.style.BottomPopDialogStyle);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mView = inflater.inflate(R.layout.dialog_goods_params, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.params_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        mAdapter = new ListAdapter(context, list);
        mRecyclerView.setAdapter(mAdapter);

        mBtnConfirm = mView.findViewById(R.id.btn_confirm);
        mBtnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

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
            return R.layout.item_goods_params_dialog;
        }

        @Override
        protected void bindData(final BaseRecyclerHolder holder, final int position, String item) {
            if (mSelect == position) {
                holder.getView(R.id.itemLayout).setBackgroundColor(ContextCompat.getColor(mContext, R.color.theme_back_white));
            } else {
                holder.getView(R.id.itemLayout).setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
            }

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeSelect(position);
                }
            });
        }
    }

    private void changeSelect(int position) {
        if (mSelect != position) {
            mSelect = position;
            mAdapter.notifyDataSetChanged();
        }
    }
}