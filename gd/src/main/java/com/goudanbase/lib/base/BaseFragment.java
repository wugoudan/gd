package com.goudanbase.lib.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goudanbase.lib.utils.TUtil;
import com.goudanbase.lib.view.BaseToolBar;


/**
 * Effect:BaseFragment
 * 基类
 */

public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends Fragment implements View.OnClickListener {
    public P mPresenter;
    public M mModel;
    public Context mContext;
    protected View mView;
    protected BaseToolBar toolBar;
    protected int start = 0;
    protected int limit = 10;
    protected boolean isRefresh = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getLayoutResource(), container, false);
        }
        this.mContext = getActivity();

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initEvents();

        initObject();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    /**
     * 初始化MVP
     */
    public void setMVP() {
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (mPresenter != null) {
            mPresenter.mContext = this.getActivity();
        }
        mPresenter.setVM(this, mModel);
    }


    /**
     * 获取布局文件
     */

    protected abstract int getLayoutResource();

    /**
     * 初始化view
     */
    protected abstract void initView(View v);

    /**
     * 事件监听
     */
    public abstract void initEvents();

    /**
     * 处理监听
     *
     * @param v
     */
    public abstract void OnClickEvents(View v);

    /**
     * 初始化事物
     */
    public abstract void initObject();

    @Override
    public void onClick(View v) {
        OnClickEvents(v);
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
     * 含有Bundle通过Class跳转界面
     **/
    public void startActivityForResult(Class<?> cls, Bundle bundle,
                                       int requestCode) {
        Intent intent = new Intent();
        intent.setClass(mContext, cls);
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
        intent.setClass(mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null)
            mPresenter.onDestroy();
    }

   /* @Override
    public void onAttach(Context context) {
        super.onAttach(CalligraphyContextWrapper.wrap(context));
    }*/
}
