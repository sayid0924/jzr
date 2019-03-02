
package com.jzr.bedside.presenter.impl.fragment;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.presenter.contract.fragment.DoctorConditionContract;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class DoctorConditionPresenter extends BasePresenter<DoctorConditionContract.View> implements DoctorConditionContract.Presenter<DoctorConditionContract.View> {

    public DoctorConditionPresenter(BaseActivity context) {
        super(context);
    }


    @Override
    public void findDoctorByCondition(String... s) {
        addSubscrebe(Api.getInstance().findDoctorByCondition(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<DoctorByConditionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.toString());
                    }

                    @Override
                    public void onNext(DoctorByConditionBean data) {
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.findDoctorByConditionSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
