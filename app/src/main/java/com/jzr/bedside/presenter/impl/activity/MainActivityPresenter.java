
package com.jzr.bedside.presenter.impl.activity;


import android.app.PackageInstallObserver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

import com.blankj.utilcode.utils.AppUtils;
import com.jzr.bedside.api.Api;
import com.jzr.bedside.appmanage.AppInstaller;
import com.jzr.bedside.appmanage.DownloadFileListener;
import com.jzr.bedside.appmanage.LogUtil;
import com.jzr.bedside.appmanage.OkHttpUtil;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.presenter.contract.activity.MainContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.orhanobut.logger.Logger;

import java.io.File;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static org.greenrobot.eventbus.EventBus.TAG;

public class MainActivityPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {

    @Override
    public void bedcardGetbedinfo(String... s) {
        addSubscrebe(Api.getInstance().bedcardGetbedinfo(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<BedInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        if (mView != null)
                            mView.showError(e.toString());
                    }

                    @Override
                    public void onNext(BedInfoBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.bedcardGetbedinfoSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }

    @Override
    public void downApp(final Context context, String url, String path) {
        OkHttpUtil.download(url, path, new DownloadFileListener() {
            @Override
            public void onDownloadSuccess(File file) {
                installApp(context, file);
            }

            @Override
            public void onDownloading(int progress) {
            }

            @Override
            public void onDownloadFailed(Exception e) {

            }
        });
    }

    private void installApp( Context context,File app) {
        final PackageInfo info  =context.getPackageManager().getPackageArchiveInfo(app.getAbsolutePath(), PackageManager.GET_ACTIVITIES);
        AppInstaller.install(Uri.fromFile(app), context, info.packageName, new PackageInstallObserver() {
            @Override
            public void onPackageInstalled(String basePackageName, int returnCode, String msg, Bundle extras) {
                super.onPackageInstalled(basePackageName, returnCode, msg, extras);
            }
        });
    }
}
