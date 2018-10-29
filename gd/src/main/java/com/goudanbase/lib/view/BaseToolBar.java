package com.goudanbase.lib.view;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.goudanbase.lib.R;
import com.goudanbase.lib.base.BaseActivity;


/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect: 标题栏
 */

public class BaseToolBar extends LinearLayout {
    private Context mContext;

    //bar
    private RelativeLayout rl_bar;

    //left
    private RelativeLayout btn_left;
    private ImageView btn_iv_left;
    private TextView btn_tv_left;

    //title
    private TextView title_name;
    private View title_line;

    //right
    private RelativeLayout btn_right;
    private ImageView btn_iv_right;


    public BaseToolBar(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public BaseToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();
    }

    public BaseToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView();
    }


    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.base_tool_bar, this);
        rl_bar = findViewById(R.id.rl_bar);

        btn_left = findViewById(R.id.btn_left);
        btn_iv_left = findViewById(R.id.btn_iv_left);
        btn_tv_left = findViewById(R.id.btn_tv_left);

        title_name = findViewById(R.id.title_name);
        title_line = findViewById(R.id.title_line);

        btn_right = findViewById(R.id.btn_right);
        btn_iv_right = findViewById(R.id.btn_iv_right);

        btn_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                BaseActivity activity = (BaseActivity) mContext;
                activity.finish();
            }
        });
    }

    public void setLineHidden(){
        title_line.setVisibility(INVISIBLE);
    }

    public void setLeftHidden(){
        btn_left.setVisibility(GONE);
    }

    public void setToobarBackgroundColor(int resId){
        rl_bar.setBackgroundColor(mContext.getResources().getColor(resId));
    }

    //设置左边按钮图标
    public void setLeftButtonIcon(int resId){
        btn_iv_left.setBackgroundResource(resId);
    }

    //设置左边按钮点击事件
    public void setLeftButtonListener(OnClickListener clickListener){
        btn_left.setOnClickListener(clickListener);
    }

    //设置标题
    public void setTitle(String title){
        title_name.setVisibility(VISIBLE);
        title_name.setText(title);
    }

    //设置右边按钮图标
    public void setRightButtonIcon(int resId){
        btn_iv_right.setBackgroundResource(resId);
    }

    //设置右边按钮点击事件
    public void setRightButtonListener(OnClickListener clickListener){
        btn_right.setVisibility(VISIBLE);
        btn_right.setOnClickListener(clickListener);
    }

}
