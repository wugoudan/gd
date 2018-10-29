package com.goudanbase.lib.base;

import android.content.Context;

import com.goudanbase.lib.rxbase.RxManager;


/**
 * @param <V> model
 * @param <M> view
 */
public abstract class BasePresenter<V, M> {
    public Context mContext;
    public M mModel;
    public V mView;
    public RxManager mRxManage = new RxManager();

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
        this.onStart();
    }

    public void onStart() {
    }

    ;

    public void onDestroy() {
        //  mRxManage.clear();
    }
}
