package com.coopbuy.mall.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author wangyu
 * @time 2017/7/7 0007 on 上午 10:40
 * @desc 协议Adapter
 */
public abstract class BaseDelegateAdapter <T> extends DelegateAdapter.Adapter<BaseRecyclerHolder>{

    protected List<T> mItems;
    protected Context mContext;
    protected LayoutInflater mInflater;
    private LayoutHelper mLayoutHelper;
    protected OnItemClickListener mClickListener;
    protected OnItemLongClickListener mLongClickListener;
    protected DecimalFormat mFormat;
    protected int mScreeWidth = 0;
    private WindowManager mWindowManager;

    public BaseDelegateAdapter(Context ctx, List<T> list,LayoutHelper mLayoutHelper) {
        this.mItems = (list != null) ? list : new ArrayList<T>();
        this.mContext = ctx;
        this.mLayoutHelper = mLayoutHelper;
        this.mInflater = LayoutInflater.from(ctx);
        this.mFormat = new DecimalFormat("0.00");
        mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        mScreeWidth = mWindowManager.getDefaultDisplay().getWidth();
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final BaseRecyclerHolder holder = new BaseRecyclerHolder
                (mInflater.inflate(getItemLayoutId(viewType), parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        bindData(holder, position, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mItems.size();
    }

    public List<T> getmItems(){
        if(mItems != null){
            return mItems;
        }
        return null;
    }

    public void add(int pos, T item) {
        mItems.add(pos, item);
        notifyItemInserted(pos);
    }

    public void setData(List<T> list){
        mItems = (list != null) ? list : new ArrayList<T>();
        notifyDataSetChanged();
    }

    public void delete(int pos) {
        mItems.remove(pos);
        notifyItemRemoved(pos);
    }

    public void swap(int fromPosition, int toPosition) {
        Collections.swap(mItems, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
    }

    final public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    final public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    /**
     * 重写该方法，根据viewType设置item的layout
     *
     * @param viewType 通过重写getItemViewType（）设置，默认item是0
     * @return
     */
    abstract protected int getItemLayoutId(int viewType);

    /**
     * 重写该方法进行item数据项视图的数据绑定
     *
     * @param holder   通过holder获得item中的子View，进行数据绑定
     * @param position 该item的position
     * @param item     映射到该item的数据
     */
    abstract protected void bindData(BaseRecyclerHolder holder, int position, T item);

    public interface OnItemClickListener<T> {
        void onItemClick(int position, T item);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View itemView, int pos);
    }
}
