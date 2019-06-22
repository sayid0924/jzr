package com.jzr.bedside.appmanage;


import android.app.PackageInstallObserver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ashia on 2016/7/7.
 */
public class AppInstaller {

    private static final String TAG = AppInstaller.class.getSimpleName();

    // PackageManager.INSTALL_REPLACE_EXISTING
    public static final int INSTALL_REPLACE_EXISTING = 0x00000002;
    // PackageManager.INSTALL_FROM_ADB
    public static final int INSTALL_FROM_ADB = 0x00000020;

    public static void install(Uri packageUri, Context context, String packageName, PackageInstallObserver packageInstallObserver) {
        PackageManager pm = context.getPackageManager();
        Method[] methods = PackageManager.class.getMethods();
        Method installPackageMethod = null;
        for (Method method : methods) {
            if ("installPackage".equals(method.getName())) {
                Class<?>[] typeParameters = method.getParameterTypes();
                if ("PackageInstallObserver".equals(typeParameters[1].getSimpleName())) {
                    installPackageMethod = method;
                    Log.i(TAG, typeParameters[1].getSimpleName() + ":" + typeParameters.toString());
                }
            }
        }
        try {
            installPackageMethod.invoke(pm, packageUri, packageInstallObserver, INSTALL_REPLACE_EXISTING | INSTALL_FROM_ADB, packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
