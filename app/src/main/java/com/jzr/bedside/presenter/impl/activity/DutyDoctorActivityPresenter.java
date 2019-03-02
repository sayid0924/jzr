
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.DoctorBean;
import com.jzr.bedside.bean.NurseInfoBean;
import com.jzr.bedside.presenter.contract.activity.DutyDoctorContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DutyDoctorActivityPresenter extends BasePresenter<DutyDoctorContract.View> implements DutyDoctorContract.Presenter<DutyDoctorContract.View> {

    public DutyDoctorActivityPresenter(BaseActivity context) {
        super(context);
    }


    @Override
    public void selectByDoctorId(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().selectByDoctorId(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DoctorBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mContext.hideWaitingDialog();
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(DoctorBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.selectByDoctorIdSuccess(data);
                        }
                    }
                }));
    }

    @Override
    public void selectByNurseId(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().selectByNurseId(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NurseInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mContext.hideWaitingDialog();
                        ToastUtils.showLongToast("请求错误  请重新请求........");
                    }

                    @Override
                    public void onNext(NurseInfoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.selectByNurseIdSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
