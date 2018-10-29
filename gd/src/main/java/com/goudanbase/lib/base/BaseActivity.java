package com.goudanbase.lib.base;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.goudanbase.lib.R;
import com.goudanbase.lib.rxbase.RxManager;
import com.goudanbase.lib.utils.TUtil;
import com.goudanbase.lib.view.BaseToolBar;
import com.jaeger.library.StatusBarUtil;

/**
 * Auther:goudan
 * Effect:基类
 */

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements View.OnClickListener {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    public RxManager mRxManager;

    protected boolean isRefresh = true;
    protected int start = 1;
    protected int limit = 20;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRxManager = new RxManager();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//禁止横屏
        setContentView(R.layout.activity_base);

        StatusBarUtil.setDarkMode(this);
        StatusBarUtil.setColor(this,getResources().getColor(R.color.c1A0C44),0);

        FrameLayout base_fl = (FrameLayout) findViewById(R.id.base_fl);
        base_fl.addView(getLayoutInflater().inflate(getLayoutId(),null));
        this.mContext = this;

        initView();
        initObject();
        initEvents();

//        StatusBarUtil.setTransparent(this);
    }

    /**
     * 初始化MVP
     */
    public void setMVP() {
        mContext = this;
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this;
        }
        mPresenter.setVM(this, mModel);
    }

    /**
     * 获取布局文件
     */
    public abstract int getLayoutId();


    /**
     * 初始化View
     */
    public abstract void initView();

    /**
     * 设置监听
     */
    public abstract void initEvents();

    /**
     * 处理监听事件
     */
    public abstract void onClickEvent(View v);

    @Override
    public void onClick(View v) {
        onClickEvent(v);
    }
    /*********************跳转相关**********************************/
    /**
     * 通过Class跳转界面
     **/
    public void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(cls, null, requestCode);
    }

    /**
     * 初始化事物
     */

    public abstract void initObject();

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
        }
        mRxManager.clear();
    }

//    @Override
//    protected void attachBaseContext(Context newBase) {
////        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }


}
