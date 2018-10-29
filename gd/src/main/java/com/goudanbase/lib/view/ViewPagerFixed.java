package com.goudanbase.lib.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import com.goudanbase.lib.utils.Dp2Px;

import java.lang.reflect.Field;

/**
 * Auther:goudan
 * Date: 2016/1/26
 */
public class ViewPagerFixed extends android.support.v4.view.ViewPager {
    /*private ViewGroup parent;
    public ViewPagerFixed(Context context) {
        super(context);
    }

    public ViewPagerFixed(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setNestedpParent(ViewGroup parent) {
        this.parent = parent;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (parent != null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (parent != null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (parent != null){
            parent.requestDisallowInterceptTouchEvent(true);
        }
        return super.onTouchEvent(ev);
    }*/
    private Context mContext;
    public ViewPagerFixed(Context context) {
        super(context);
        this.mContext = context;
        fixTouchSlop();
    }
    public ViewPagerFixed(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        fixTouchSlop();
    }

    /**
     *这个方法是通过反射，修改viewpager的触发切换的最小滑动速度（还是距离？姑
     * 且是速度吧！滑了10dp就给它切换）
     **/
    private void fixTouchSlop() {
        Field field = null;
        try {
            field = ViewPager.class.getDeclaredField("mMinimumVelocity");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        field.setAccessible(true);
        try {
            field.setInt(this, Dp2Px.px2dip(mContext, 10));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /****
     * 滑动距离及坐标 归还父控件焦点
     ****/
    private float xDistance, yDistance, xLast, yLast;
    /**
     * 是否是左右滑动
     **/
    private boolean mIsBeingDragged = true;

    /**
     *重写这个方法纯属是为了告诉Recyclerview，什么时候不要拦截viewpager的滑动
     *事件
     **/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        getParent().requestDisallowInterceptTouchEvent(true);
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xDistance = yDistance = 0f;
                xLast = ev.getX();
                yLast = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                final float curX = ev.getX();
                final float curY = ev.getY();
                xDistance += Math.abs(curX - xLast);
                yDistance += Math.abs(curY - yLast);
                xLast = curX;
                yLast = curY;
                Log.e("tag", "dispatchTouchEvent:3 ");
                if (!mIsBeingDragged) {
                    Log.e("tag", "dispatchTouchEvent: ");
                    if (yDistance < xDistance * 0.5) {//小于30度都左右滑
                        mIsBeingDragged = true;
                        getParent().requestDisallowInterceptTouchEvent(true);
                        Log.e("tag", "dispatchTouchEvent:1");

                    } else {
                        mIsBeingDragged = false;
                        getParent().requestDisallowInterceptTouchEvent(false);
                        Log.e("tag", "dispatchTouchEvent:2 ");

                    }
                }else{
                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mIsBeingDragged = false;
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


}
