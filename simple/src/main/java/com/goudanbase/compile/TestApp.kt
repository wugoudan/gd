package com.goudanbase.compile

import android.app.Application
import com.goudanbase.lib.BaseApplication

/**
 *Conpany:
 *Auth:goudan
 *Date:18-10-29 下午5:25
 *Mail:wulog@outlook.com
 *Effect:
 */
class TestApp:Application(){
    override fun onCreate() {
        super.onCreate()
        BaseApplication.init(this)
    }
}