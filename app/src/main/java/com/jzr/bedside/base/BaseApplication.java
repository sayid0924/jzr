package com.jzr.bedside.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.jzr.bedside.utils.CrashHandler;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.PreferUtil;
import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.blankj.utilcode.utils.Utils;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


public class BaseApplication extends Application {


    private static Context mContext;//上下文
    private static BaseApplication instance = null;

    public static ThreadPoolUtils MAIN_EXECUTOR = new ThreadPoolUtils(ThreadPoolUtils.Type.FixedThread, 10);

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initLogger();
        Utils.init(this);
        PreferUtil.getInstance().init(this);
//        CrashHandler.getInstance(this).init();
        GreenDaoUtil.initDataBase(getApplicationContext());
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    private void initLogger() {
        Logger.init("ART").methodCount(2).methodOffset(0).logLevel(LogLevel.FULL).hideThreadInfo();
    }

}
