package com.goudanbase.lib.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.goudanbase.lib.R;
import com.goudanbase.lib.utils.GoudanBuild;


/**
 * Conpany:lhxy
 * Auther:goudan
 * Date: 2017/8/30
 * Effect:
 */
public class EmptyView extends LinearLayout implements View.OnClickListener {

    public static final int HIDE_LAYOUT = 1; //正常情况下
    public static final int NO_DATA = 2;      //没有数据时
    public static final int NETWORK_ERROR = 3; //没有网络时
    public static final int LOADING_ = 4; //正在加载中
    private int mErrorState;  //状态码
    public static final int DEFAULT = 5;//默认

    public static final int BRAND_SEARCH = 9;

    private int type;
    private String tip;
    private Context context;
    private RelativeLayout empty_layout;
    private LinearLayout error_layout;
    private ImageView error_iv;
    private TextView error_tv;
    private ProgressBar progress_bar;

    public EmptyView(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public EmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }


    private void init() {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_empty_view, null);
        error_layout = (LinearLayout) v.findViewById(R.id.error_layout);
        empty_layout = (RelativeLayout) v.findViewById(R.id.empty_layout);
        error_iv = (ImageView) v.findViewById(R.id.error_iv);
        error_tv = (TextView) v.findViewById(R.id.error_tv);
        progress_bar = (ProgressBar) v.findViewById(R.id.progress_bar);
        setBackgroundColor(Color.TRANSPARENT);
        v.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(v);

    }

    public void setLayoutBackground(int color) {
        empty_layout.setBackgroundColor(color);
    }

    //隐藏
    public void dismiss() {
        mErrorState = HIDE_LAYOUT;
        setVisibility(View.GONE);
    }

    private boolean isHide;

    public void setHide(boolean hide) {
        isHide = hide;
    }

    public void setHideBackground(boolean isHide) {
        this.isHide = isHide;
    }

    public void setNoDataTip(int type, String tip) {
        this.type = type;
        this.tip = tip;
    }

    public void setErrorType(int status) {
        setVisibility(View.VISIBLE);
        error_tv.setVisibility(View.VISIBLE);
        switch (status) {
            case HIDE_LAYOUT:
                setVisibility(View.GONE);
                progress_bar.setVisibility(View.GONE);
                break;
            case NO_DATA:
                if (isHide) {
                    //正在加载状态...
                    setBackgroundColor(Color.TRANSPARENT);
                } else {
                    setBackgroundColor(-1);
                }
                progress_bar.setVisibility(View.GONE);
                error_layout.setVisibility(View.VISIBLE);
                error_iv.setImageResource(GoudanBuild.getInstance().EMPTY_VIEW_NO_DATA);

                if (type == DEFAULT) {
                    error_iv.setImageResource(GoudanBuild.getInstance().EMPTY_VIEW_NO_DEFAULT);
                    error_tv.setText(tip);
                }

                empty_layout.setOnClickListener(this);
                break;
            case NETWORK_ERROR:
                progress_bar.setVisibility(View.GONE);
                error_iv.setImageResource(GoudanBuild.getInstance().EMPTY_VIEW_NO_NETWORK);
                error_layout.setVisibility(View.VISIBLE);
                error_tv.setText("亲，网络走神儿了。");

                empty_layout.setOnClickListener(this);
                break;
            case LOADING_:
                if (isHide) {
                    //正在加载状态...
                    setBackgroundColor(Color.TRANSPARENT);
                } else {
                    setBackgroundColor(-1);
                }
                error_layout.setVisibility(View.GONE);
                progress_bar.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        if (v == empty_layout){
            if (onEmptyClick != null){
                onEmptyClick.onClick();
            }
        }
    }

    public OnEmptyClick onEmptyClick;

    public void setOnEmptyClick(OnEmptyClick onEmptyClick) {
        this.onEmptyClick = onEmptyClick;
    }

    public interface OnEmptyClick{
        void onClick();
    }
}
