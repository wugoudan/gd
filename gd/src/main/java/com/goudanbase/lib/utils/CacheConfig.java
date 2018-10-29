package com.goudanbase.lib.utils;

import android.text.TextUtils;


import com.goudanbase.lib.cache.ACache;

import java.io.Serializable;

import static com.goudanbase.lib.BaseApplication.getAppContext;

/**
 * Auther:wulog
 * Date: 2017/9/21
 * Effect: 单例模式缓存数据
 */
public class CacheConfig {
    public static CacheConfig inst = null;
    private ACache mACache;
    private boolean isLogin;

    public static CacheConfig getInst() {
        if (inst == null) {
            inst = new CacheConfig();
        }
        return inst;
    }

    public CacheConfig() {
        mACache = ACache.get(getAppContext());
    }

    /**
     * 保存账号
     *
     * @param account
     */
    public void saveAccount(String account) {
        mACache.put("account", account);
    }

    public void save(String key, Object value){
        mACache.put(key, (Serializable) value);
    }

    /**
     * 获取String数据
     * @param key
     * @return
     */
    public String getString(String key){
        try {
            return mACache.getAsObject(key).toString();
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取Int数据
     * @param key
     * @return
     */
    public int getInt(String key){
        try {
            return Integer.valueOf(mACache.getAsObject(key).toString());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * 获取Boolean数据
     * @param key
     * @return
     */
    public boolean getBoolean(String key){
        try {
            return Boolean.valueOf(mACache.getAsObject(key).toString());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取Object数据
     * @param key
     * @return
     */
    public Object getObject(String key){
        try {
            return mACache.getAsObject(key);
        } catch (Exception e) {
            return false;
        }
    }
}
