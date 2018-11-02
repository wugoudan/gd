package com.goudanbase.lib;

import android.content.Context;

/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect: APPLICATION
 */

public class BaseApplication {
    public static Context baseApplication;



    public static void init(Context context){
        if (context != null){
            baseApplication = context;
        }
    }

//    @Override
//    public void onCreate() {
//        super.onCreate();
//        baseApplication = this;
//        initFont();
//        setFresco();
//    }

    public static Context getAppContext() {
        return baseApplication;
    }

//    public static Resources getAppResources() {
//        return baseApplication.getResources();
//    }
//
//    @Override
//    public void onTerminate() {
//        super.onTerminate();
//    }
//
//    /**
//     * 分包
//     *
//     * @param base
//     */
//    @Override
//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(base);
//    }
//
//    private void initFont() {
////        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
////                .setDefaultFontPath("fonts/pingfang.ttf")
////                .setFontAttrId(com.lingcloud.lcommon.R.attr.fontPath).build());
//    }
//
//    private void setFresco() {
////        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this).setDownsampleEnabled(true).build();
////        Fresco.initialize(getApplicationContext(), config);
//    }
}
