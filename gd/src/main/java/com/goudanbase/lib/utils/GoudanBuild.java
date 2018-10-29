package com.goudanbase.lib.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Conpany:null
 * Auth:goudan
 * Date:{2018/10/8}
 * Mail:wulog@outlook.com
 * Effect:
 */
public class GoudanBuild {
    private static GoudanBuild instance;

    public static GoudanBuild getInstance(){
        if (instance == null){
            instance = new GoudanBuild();
        }

        return instance;
    }
    /*********************  设置网络请求 *********************/
    public static String BASE_URL = "";
    public GoudanBuild setBaseUrl(String url){
        BASE_URL = url;
        return instance;
    }

    /*********************  设置EmptyView *********************/

    //EmptyView
    public int EMPTY_VIEW_NO_DEFAULT = -1;
    public int EMPTY_VIEW_NO_DATA = -1;
    public int EMPTY_VIEW_NO_NETWORK = -1;

    public GoudanBuild setEmptyView(int defaultResId, int noDataResId, int noNetworkResId){
        EMPTY_VIEW_NO_DEFAULT = defaultResId;
        EMPTY_VIEW_NO_DATA = noDataResId;
        EMPTY_VIEW_NO_NETWORK = noNetworkResId;
        return instance;
    }

    /*********************  设置网络请求 *********************/

}
