package com.goudanbase.lib.expection;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Auther:goudan
 * Effect:基类
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";
    private static final String PATH = Environment.getExternalStorageDirectory()
            .getPath()+"/WOMP/crash/log";
    private static final String FILE_NAME = "/crash";
    private static final String FILE_NAME_SUFFIX = ".txt";
    private static CrashHandler sInstance = new CrashHandler();
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    private Context mContext;

    private CrashHandler(){

    }

    public static CrashHandler getInstance() {
        return sInstance;
    }

    public void init(Context context){
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
        mContext = context.getApplicationContext();
    }


    /**
     * 当程序中有未被捕获的异常，系统会自动调用此方法
     * @param t 出现未捕获异常的线程
     * @param e 未捕获的异常
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        try {
            //导出异常信息到SD卡中
            dumpExceptionToSDCard(e);
            //也可以上传异常到服务器
            //uploadExceptionToServer(e);
        }catch (IOException ex){
            ex.printStackTrace();
        }

        e.printStackTrace();
        //如果系统提供了默认的异常处理器，则交给系统处理，否则就自己结束
        if(defaultUncaughtExceptionHandler!=null){
            defaultUncaughtExceptionHandler.uncaughtException(t,e);
        }else{
            Process.killProcess(Process.myPid());
        }

    }

    private void dumpExceptionToSDCard(Throwable e) throws IOException{
        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                Log.e(TAG,"SDCard不能使用，跳过异常写入");
                return;
        }

        File dir = new File(PATH);
        if(!dir.exists()){
            dir.mkdirs();
        }
        long currentTimeMillis = System.currentTimeMillis();
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(currentTimeMillis));
        File file = new File(PATH+FILE_NAME+time+FILE_NAME_SUFFIX);

        try {
            PrintWriter pw = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(file)));
            pw.append(time);
            dumpPhoneInfo(pw);
            pw.println();
            e.printStackTrace(pw);
            pw.close();
        }catch (Exception ex){
            ex.printStackTrace();
            Log.e(TAG,"异常写入失败");
        }
    }

    /**
     * 写入手机信息
     * @param pw
     */
    private void dumpPhoneInfo(PrintWriter pw) throws PackageManager.NameNotFoundException {
        PackageManager pm = mContext.getPackageManager();
        PackageInfo packageInfo = pm.getPackageInfo(mContext.getPackageName(),
                PackageManager.GET_ACTIVITIES);
        pw.println("品牌家");
        pw.print("APP Version:");
        pw.print(packageInfo.versionName);
        pw.print("---");
        pw.println(packageInfo.versionCode);

        //Android版本
        pw.print("Android版本:");
        pw.print(Build.VERSION.RELEASE);
        pw.print("---");
        pw.println(Build.VERSION.SDK_INT);

        //手机制造商
        pw.print("手机制造商:");
        pw.println(Build.MANUFACTURER);

        //手机型号
        pw.print("手机型号:");
        pw.println(Build.MODEL);

        //CPU架构
        pw.print("CPU架构:");
        pw.println(Build.CPU_ABI);

    }
}
