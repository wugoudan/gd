package com.goudanbase.compile

import android.view.View
import com.goudanbase.lib.base.BaseActivity
import com.goudanbase.lib.base.BaseModel
import com.goudanbase.lib.base.BasePresenter

class MainActivity : BaseActivity<BasePresenter<*,*>,BaseModel>() {

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
    }

    override fun initEvents() {
    }

    override fun onClickEvent(v: View?) {
    }

    override fun initObject() {
    }
}
