package com.goudanbase.lib.utils;

import android.util.Log;

import com.goudanbase.lib.BuildConfig;


/**
 * Auther:goudan
 * Date: 2016/1/26
 * Effect: 日志类
 */

public class LogUtil {
    //可以全局控制是否打印log日志
    private static boolean isPrintLog = BuildConfig.ENABLE_LOG;

    private static int LOG_MAXLENGTH = 2000;

    public static void showLog(String msg) {
        if (isPrintLog) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.e("logUtil--->", msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e("logUtil--->", msg.substring(start, strLength));
                    break;
                }
            }
        }
    }

    public static void showLog(String type, String msg) {

        if (isPrintLog) {
            int strLength = msg.length();
            int start = 0;
            int end = LOG_MAXLENGTH;
            for (int i = 0; i < 100; i++) {
                if (strLength > end) {
                    Log.e(type + "___" + i, msg.substring(start, end));
                    start = end;
                    end = end + LOG_MAXLENGTH;
                } else {
                    Log.e(type + "___" + i, msg.substring(start, strLength));
                    break;
                }
            }
        }
    }
}
