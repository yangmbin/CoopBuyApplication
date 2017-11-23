package com.coopbuy.mall.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * @author lw
 * @time 2017/9/20.
 * @desc
 */
public class MeCenScollView extends ScrollView {

    // 拖动的距离 size = 4 的意思 只允许拖动屏幕的1/4
    private static final int size = 2;
    private static final int offsetHeight = 10;//手指滑动的距离
    private View inner;
    private float y;
    private Rect normal = new Rect();

    public MeCenScollView(Context context) {
        super(context);
    }

    public MeCenScollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            inner = getChildAt(0);
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            y = ev.getY();
            return false;
        } else if (action == MotionEvent.ACTION_UP) {
            float currrY = ev.getY();
            if (Math.abs(currrY - y) < offsetHeight) {
                //不想要父视图拦截触摸事件
                return false;
            } else {
                return true;
            }
        } else if (action == MotionEvent.ACTION_MOVE) {
            float currrY = ev.getY();

            if (Math.abs(currrY - y) < offsetHeight) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }


    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (inner == null) {
            return super.onTouchEvent(ev);
        } else {
            commOnTouchEvent(ev);

        }
        return super.onTouchEvent(ev);
    }

    public void commOnTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                y = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (isNeedAnimation()) {
                    animation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                final float preY = y;
                float nowY = ev.getY();
                /**
                 * size=4 表示 拖动的距离为屏幕的高度的1/4
                 */
                int deltaY = (int) (preY - nowY) / size;
                y = nowY;
                // 当滚动到最上或者最下时就不会再滚动，这时移动布局
                if (isNeedMove()) {
                    if (normal.isEmpty()) {
                        // 保存正常的布局位置
                        normal.set(inner.getLeft(), inner.getTop(),
                                inner.getRight(), inner.getBottom());
                        return;
                    }
                    int yy = inner.getTop() - deltaY;

                    // 移动布局
                    inner.layout(inner.getLeft(), yy, inner.getRight(),
                            inner.getBottom() - deltaY);
                    if (Math.abs(yy) > offsetHeight) {
                        mListener.OnOffsetMove(yy * 2, 1);
                    }
                }
                break;
            default:
                break;
        }
    }

    private OnOffsetMoveListener mListener = null;

    public void setOnOffsetMoveListener(OnOffsetMoveListener listener) {
        this.mListener = listener;
    }

    public interface OnOffsetMoveListener {
        void OnOffsetMove(float offset, int type);
    }

    // 开启动画移动

    public void animation() {
        // 开启移动动画
        TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop(),
                normal.top);
        ta.setDuration(200);
        final float mViewTop = inner.getTop();
        if (mViewTop > offsetHeight) {
            mListener.OnOffsetMove(0, 2);
        } else if (mViewTop < -offsetHeight) {
            mListener.OnOffsetMove(0, 3);
        }

        inner.startAnimation(ta);
        // 设置回到正常的布局位置
        inner.layout(normal.left, normal.top, normal.right, normal.bottom);
        normal.setEmpty();
    }

    // 是否需要开启动画
    public boolean isNeedAnimation() {
        return !normal.isEmpty();
    }

    // 是否需要移动布局
    public boolean isNeedMove() {
        int offset = inner.getMeasuredHeight() - getHeight();
        int scrollY = getScrollY();
        if (scrollY == 0 || scrollY == offset) {
            return true;
        }
        return false;
    }

}