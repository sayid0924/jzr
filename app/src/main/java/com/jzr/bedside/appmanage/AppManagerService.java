package com.jzr.bedside.appmanage;


import android.app.PackageInstallObserver;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

public class AppManagerService extends Service {

    private static final String TAG = AppManagerService.class.getSimpleName();

    private Handler mHandler;
    public static String DEFAULT_DOWNLOAD_PATH = Environment.getExternalStorageDirectory().getPath() + "/BBEN/";
    public static String INTENT_STRING_EXTRA_APK_URL = "INTENT_STRING_EXTRA_APK_URL";
    public static String INTENT_STRING_EXTRA_DOWNLOAD_PATH = "INTENT_STRING_EXTRA_DOWNLOAD_PATH";

    public static String INTENT_BOOLEAN_EXTRA_AUTO_START_UP = "INTENT_BOOLEAN_EXTRA_AUTO_START_UP";
    private boolean mAutoStartUp = true;

    public AppManagerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler(Looper.getMainLooper());
    }

    private void installApp(File app) {
        final PackageInfo info = getPackageManager().getPackageArchiveInfo(app.getAbsolutePath(), PackageManager.GET_ACTIVITIES);
        LogUtil.i("TAG", info.toString() + ", info.packageName = " + info.packageName);
            AppInstaller.install(Uri.fromFile(app), this, info.packageName, new PackageInstallObserver() {
                @Override
                public void onPackageInstalled(String basePackageName, int returnCode, String msg, Bundle extras) {
                    super.onPackageInstalled(basePackageName, returnCode, msg, extras);
                    LogUtil.i(TAG, "onPackageInstalled, returnCode = " + returnCode);
                    Log.e("TAG", "aa");
                    if (returnCode == 1) {
                        Log.e("TAG", "zz");
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "更新成功...", Toast.LENGTH_SHORT).show();
                                Log.e("TAG", "更新成功");
                            }
                        });
                        if (mAutoStartUp) {
                            Intent intent = new Intent();
                            intent.setClassName("com.bben.display.bedside", "com.bben.display.bedside.BedsideActivity");
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }
                    } else {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getApplicationContext(), "更新失败...", Toast.LENGTH_SHORT).show();
                                Log.e("TAG", "更新失败");
                            }
                        });
                    }
                }
            });
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent == null) {
            LogUtil.e(TAG, "onStartCommand, intent == null");
            return super.onStartCommand(intent, flags, startId);
        }
        String url = intent.getStringExtra(INTENT_STRING_EXTRA_APK_URL);
        if (url == null) {
            LogUtil.e(TAG, "invalid url");
            return super.onStartCommand(intent, flags, startId);
        }
        String path = intent.getStringExtra(INTENT_STRING_EXTRA_DOWNLOAD_PATH);
        mAutoStartUp = intent.getBooleanExtra(INTENT_BOOLEAN_EXTRA_AUTO_START_UP, true);
        if (path == null) {
            LogUtil.i(TAG, "use default path, path = " + DEFAULT_DOWNLOAD_PATH);
            path = DEFAULT_DOWNLOAD_PATH;
        }
//        OkHttpUtil.download(url, path, new DownloadFileListener() {
//            @Override
//            public void onDownloadSuccess(File file) {
//                LogUtil.i("TAG", "onDownloadSuccess, file = " + file.getName());
//                installApp(file);
//
//            }
//
//            @Override
//            public void onDownloading(int progress) {
//                LogUtil.i(TAG, "onDownloading, progress = " + progress);
//
//            }
//
//            @Override
//            public void onDownloadFailed(Exception e) {
//                LogUtil.i(TAG, "onDownloadFailed, e = " + e.getMessage(), e);
//            }
//        });
        return super.onStartCommand(intent, flags, startId);

    }

    public void downloadOkHttpFile() {
        String url = "http://vfx.mtime.cn/Video/2017/02/18/mp4/170218171317773949.mp4";
    }
}
