
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.presenter.contract.activity.HospitalActivityContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class HospitalActivityPresenter extends BasePresenter<HospitalActivityContract.View> implements HospitalActivityContract.Presenter<HospitalActivityContract.View> {

    public HospitalActivityPresenter(BaseActivity context) {
        super(context);
    }


    @Override
    public void selectByHospitalId(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().selectByHospitalId(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HospitalBean>() {
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
                    public void onNext(HospitalBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.selectByHospitalIdSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
