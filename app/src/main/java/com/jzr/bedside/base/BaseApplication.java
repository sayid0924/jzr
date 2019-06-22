package com.jzr.bedside.base;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.multidex.MultiDex;

import com.jzr.bedside.utils.AEvent;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.CrashHandler;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.PreferUtil;
import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.blankj.utilcode.utils.Utils;
import com.jzr.bedside.utils.listener.DemoBeautyCallback;
import com.jzr.bedside.utils.listener.XHChatManagerListener;
import com.jzr.bedside.utils.listener.XHGroupManagerListener;
import com.jzr.bedside.utils.listener.XHLoginManagerListener;
import com.jzr.bedside.utils.listener.XHVoipManagerListener;
import com.jzr.bedside.utils.listener.XHVoipP2PManagerListener;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;

import java.util.Random;


public class BaseApplication extends Application {


    private static Context mContext;//上下文
    private static BaseApplication instance = null;

//    public static ThreadPoolUtils MAIN_EXECUTOR = new ThreadPoolUtils(ThreadPoolUtils.Type.FixedThread, 10);

    public static Context getContext() {
        return mContext;
    }


    private boolean isLogin = false;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initLogger();
        Utils.init(this);
        PreferUtil.getInstance().init(this);
        CrashHandler.getInstance(this).init();
        GreenDaoUtil.initDataBase(getApplicationContext());
        AEvent.setHandler(new Handler());

        instance = this;

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);


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
