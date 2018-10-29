package com.goudanbase.lib.http;


import android.support.annotation.NonNull;
import android.text.TextUtils;


import com.goudanbase.lib.utils.NetWorkUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.goudanbase.lib.BaseApplication.getAppContext;

/**
 * Created by BMW on 2016/11/8.
 */
public class Api {
    private Retrofit retrofit;
    private static HashMap<String,Api> apiMap = new HashMap<>();

    /*************************缓存设置*********************/
/*
   1. noCache 不使用缓存，全部走网络

    2. noStore 不使用缓存，也不存储缓存

    3. onlyIfCached 只使用缓存

    4. maxAge 设置最大失效时间，失效则不使用 需要服务器配合

    5. maxStale 设置最大失效时间，失效则不使用 需要服务器配合 感觉这两个类似 还没怎么弄清楚，清楚的同学欢迎留言

    6. minFresh 设置有效时间，依旧如上

    7. FORCE_NETWORK 只走网络

    8. FORCE_CACHE 只走缓存*/

    /**
     * 设缓存有效期为两天
     */
    private static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    /**
     * 查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
     * max-stale 指示客户机可以接收超出超时期间的响应消息。如果指定max-stale消息的值，那么客户机可接收超出超时期指定值之内的响应消息。
     */
    private static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    /**
     * 查询网络的Cache-Control设置，头部Cache-Control设为max-age=0
     * (假如请求了服务器并在a时刻返回响应结果，则在max-age规定的秒数内，浏览器将不会发送对应的请求到服务器，数据由缓存直接返回)时则不会使用缓存而请求服务器
     */
    private static final String CACHE_CONTROL_AGE = "max-age=0";

    /**
     * 云端响应头拦截器，用来配置缓存策略
     * Dangerous interceptor that rewrites the server's cache-control header.
     */
    private final Interceptor mRewriteCacheControlInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            String cacheControl = request.cacheControl().toString();
            if (!NetWorkUtils.isNetConnected(getAppContext())) {
                request = request.newBuilder()
                        .cacheControl(TextUtils.isEmpty(cacheControl) ? CacheControl.FORCE_NETWORK : CacheControl.FORCE_CACHE)
                        .build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtils.isNetConnected(getAppContext())) {
                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置

                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma")
                        .build();
            } else {
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_STALE_SEC)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    };

    /**
     * 创建Api
     * @param baseUrl
     */
    private Api(long readTimeOut, long connectTimeOut, final Map<String,String> headers, CookieJar cookieJar, String baseUrl) {
        //开启Log
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //增加头部信息
        Interceptor headerInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                //默认添加json请求头
                if (headers.size() <= 0) headers.put("Content-Type", "application/json");

                Request build = chain.request().newBuilder()
                        .headers(Headers.of(headers))
//                        .addHeader("Content-Type", "application/json")
                        .build();
                return chain.proceed(build);
            }
        };

        //缓存
        File cacheFile = new File(getAppContext().getCacheDir(), "cache");
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
                .connectTimeout(connectTimeOut, TimeUnit.MILLISECONDS)
                .addInterceptor(mRewriteCacheControlInterceptor)
                .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                .addInterceptor(headerInterceptor)
                .addInterceptor(logInterceptor)
                .cache(cache)
                .cookieJar(cookieJar)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    /**
     * 根据网络状况获取缓存的策略
     * 仅限于get请求有效
     */
    @NonNull
    public static String getCacheControl() {


//        new CookieJar() {
//            private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();
//
//            @Override
//            public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
//                cookieStore.put(url.host(), cookies);
//            }
//            @Override
//            public List<Cookie> loadForRequest(HttpUrl url) {
//                List<Cookie> cookies = cookieStore.get(url.host());
//                return cookies != null ? cookies : new ArrayList<Cookie>();
//            }
//        }

        return NetWorkUtils.isNetConnected(getAppContext()) ? CACHE_CONTROL_AGE : CACHE_CONTROL_CACHE;
    }


//    public static ApiManager getDefault(int hostType) {
//
//        Api api = apiMap.get(hostType);
//        if (api == null) {
//            api = new Api(ApiContents.INSTANCE.getHost(hostType));
//            apiMap.put(hostType, api);
//        }
//        return api.apiManage;
//    }
//
//    public static ApiManager getDefault() {
//
//        Api api = apiMap.get(HostType.BASE);
//        if (api == null) {
//            api = new Api(ApiContents.INSTANCE.getHost(HostType.TEST_1));
//            apiMap.put(HostType.BASE, api);
//        }
//        return api.apiManage;
//    }

    public static class Builder{

        //读超时长，单位：毫秒
        long readTimeOut = 7000;
        //连接时长，单位：毫秒
        long connectTimeOut = 7000;

        //请求头
        Map<String,String> headers = new HashMap<>();

        //cookie
        CookieJar cookieJar;

//        public Api.Builder hostCount(int count){
//            if (apiMap == null) apiMap = new HashMap<>(count);
//            return this;
//        }

        public Api.Builder readTimeOut(long readTimeOut){
            if (readTimeOut < this.readTimeOut) return this;
            this.readTimeOut = readTimeOut;
            return this;
        }

        public Api.Builder connectTimeOut(long connectTimeOut){
            if (connectTimeOut < this.connectTimeOut) return this;
            this.connectTimeOut = connectTimeOut;
            return this;
        }

        public Api.Builder addHeader(String name, String value){
            this.headers.put(name,value);
            return this;
        }

        public Api.Builder cookieJar(CookieJar cookieJar){
            this.cookieJar = cookieJar;
            return this;
        }

        public <T> T build(String baseUrl, Class<T> cls){
            if (apiMap != null){
                Api api = apiMap.get(baseUrl);
                if (api == null){
                    api = new Api(readTimeOut,connectTimeOut,headers,cookieJar,baseUrl);
                    apiMap.put(baseUrl,api);
                }
                return api.retrofit.create(cls);
            }

            return null;
        }
    }

}
