
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.base.ExpenseDetailBean;
import com.jzr.bedside.presenter.contract.activity.ExpenseContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ExpenseActivityPresenter extends BasePresenter<ExpenseContract.View> implements ExpenseContract.Presenter<ExpenseContract.View> {

    @Override
    public void getThisAndDetailAllByCondition(String... s) {

        addSubscrebe(Api.getInstance().getThisAndDetailAllByCondition(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<ExpenseDetailBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());

                    }

                    @Override
                    public void onNext(ExpenseDetailBean data) {

                        if (mView != null && data != null && data.getCode()==0) {
                            mView.getThisAndDetailAllByConditionSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
