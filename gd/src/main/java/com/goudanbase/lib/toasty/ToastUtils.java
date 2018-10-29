package com.goudanbase.lib.toasty;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.goudanbase.lib.toasty.Toasty;


/**
 * Auther:goudan
 * Date: 2016/1/26
 */

public class ToastUtils {

    public static final int ERROR = 0;
    public static final int SUCCESS = 1;
    public static final int WARANING = 2;
    public static final int NORMAL = 3;
    public static final int INFO = 4;

    public static void show(@NonNull Context mContext, @NonNull CharSequence message,
                            int duration){
        Toasty.normal(mContext,message,duration).show();
    }

    public static void show(@NonNull Context mContext, @NonNull CharSequence message,
                            int duration,@DrawableRes int resId){
        Toasty.normal(mContext,message,duration,getDrawable(mContext,resId)).show();
    }

    public static void show(@NonNull Context mContext,int type,
                            @NonNull CharSequence message,int duration){
        show(mContext,type,message,duration,true,null);
    }

    public static void show(@NonNull Context mContext,int type,
                            @NonNull CharSequence message,int duration,
                            boolean withIcon,Drawable icon){
        switch (type){
            case ERROR:
                Toasty.error(mContext,message,duration,withIcon).show();
                break;
            case SUCCESS:
                Toasty.success(mContext,message,duration,withIcon).show();
                break;
            case WARANING:
                Toasty.warning(mContext,message,duration,withIcon).show();
                break;
            case NORMAL:
                if(icon == null) {
                    Toasty.normal(mContext, message, duration).show();
                }else{
                    Toasty.normal(mContext, message, duration, icon).show();
                }
                break;
            case INFO:
                Toasty.info(mContext,message,duration,withIcon).show();
                break;
        }
    }

    static Drawable getDrawable(@NonNull Context context, @DrawableRes int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            return context.getDrawable(id);
        else
            return context.getResources().getDrawable(id);
    }
}
