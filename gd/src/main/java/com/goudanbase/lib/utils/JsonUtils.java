package com.goudanbase.lib.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.goudanbase.lib.baseBean.BaseRespose;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect:
 */

public class JsonUtils<T> {
    private static final String TAG = "JsonUtils";

    public static BaseRespose parseJsonToAes(String s) {
        JSONObject jsonObject = null;
//        String code = "";
//        String data = "";
//        String message = "";
        try {
            jsonObject = new JSONObject(s);
//            LogUtil.showLog("TAG","jsonObjectjsonObject-->"+jsonObject.toString());
//            BaseJsonRespose jsonRespose = new Gson().fromJson(new JSONObject(s).toString(), BaseJsonRespose.class);
//            LogUtil.showLog("TAG","jsonRespose-->"+jsonRespose.toString());
            String code = jsonObject.get("code").toString();
            String data = "null".equals(jsonObject.get("data").toString())?"":jsonObject.get("data").toString();
            String message = "null".equals(jsonObject.get("msg").toString())?"":jsonObject.get("msg").toString();
            Log.d(TAG, "parseJsonToAes: \n| code == >" + code + " \n| data == >" + data + " \n| msg == >" + message);
            return new BaseRespose(code, message, data);
        } catch (JSONException e) {
            Log.e(TAG,"parseJsonToAes:服务器返回空字符串");
            e.printStackTrace();

        }
        return null;
//        try {
//            JSONObject jsonObject = new JSONObject(s);
//            try {
//                String code = AesUtil.desEncrypt(jsonObject.getString(AesUtil.encrypt("code").trim()));
//                String data = AesUtil.desEncrypt(jsonObject.getString(AesUtil.encrypt("data").trim()));
//                String message = AesUtil.desEncrypt(jsonObject.getString(AesUtil.encrypt("message").trim()));
//                Log.d(TAG, "parseJsonToAes: \n| code == >" + code + " \n| data == >" + data + " \n| message == >" + message);
//                return new BaseRespose(code, message, data);
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return null;
    }


    public static Object body(String str, Type mListType) {
        List<String> mList = new ArrayList<>();
        Object o = null;
        try {
            List<String> mlist = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(str);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                //获取key值
                String key = keys.next().toString();
                //获取value值
                String value = null;
                value = jsonObject.getString(key);
                mlist.add(value);
            }
            o = new Gson().fromJson(mlist.toString(), mListType);

        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return o;
    }



}
