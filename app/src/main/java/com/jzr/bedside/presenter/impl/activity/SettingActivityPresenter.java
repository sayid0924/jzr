
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.R;
import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.CheckDeptBean;
import com.jzr.bedside.bean.DeviceBean;
import com.jzr.bedside.bean.boby.DeviceBoby;
import com.jzr.bedside.presenter.contract.activity.SettingActivityContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SettingActivityPresenter extends BasePresenter<SettingActivityContract.View> implements SettingActivityContract.Presenter<SettingActivityContract.View> {


    @Override
    public void connectTest(String... s) {
        addSubscrebe(Api.getInstance().getDeptCodelist(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckDeptBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        ToastUtils.showLongToast("测试连接失败");
                    }

                    @Override
                    public void onNext(CheckDeptBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.connectTestSuccess(data);
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_sucess);
                        } else {
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        }
                    }
                }));
    }

    @Override
    public void getBedcardBindtobed(DeviceBoby deviceBoby) {
        addSubscrebe(Api.getInstance().getBedcardBindtobed(deviceBoby).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DeviceBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        if(mView!=null){
                            mView.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(DeviceBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.getBedcardBindtobedSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }

    @Override
    public void getDeptCodelist(String... s) {
        addSubscrebe(Api.getInstance().getDeptCodelist(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckDeptBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        if(mView!=null){
                            mView.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(CheckDeptBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.getDeptCodelistSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }

    @Override
    public void getDeptRoomlist(String... s) {
        addSubscrebe(Api.getInstance().getDeptRoomList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckDeptBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        if(mView!=null){
                            mView.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(CheckDeptBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.getDeptRoomListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }

    @Override
    public void getDeptBealist(String... s) {
        addSubscrebe(Api.getInstance().getDeptBedList(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckDeptBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        if(mView!=null){
                            mView.showError(e.getMessage());
                        }
                    }

                    @Override
                    public void onNext(CheckDeptBean data) {
                        if (mView != null && data != null && (data.getCode() == 0 || data.getCode() == 200)) {
                            mView.getDeptBedListSuccess(data);
                        } else {
                            if (mView != null && data != null)
                                mView.showError(data.getMessage());
                        }
                    }
                }));
    }
}
