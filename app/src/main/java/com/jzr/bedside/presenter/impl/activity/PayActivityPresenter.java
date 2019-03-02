
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.base.PayInfoBean;
import com.jzr.bedside.presenter.contract.activity.PayContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PayActivityPresenter extends BasePresenter<PayContract.View> implements PayContract.Presenter<PayContract.View> {



    public PayActivityPresenter(BaseActivity context) {
        super(context);

    }


    @Override
    public void getTHospitalizationExpensesVoAllByCondition(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().getTHospitalizationExpensesVoAllByCondition(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<PayInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mContext.hideWaitingDialog();
                    }

                    @Override
                    public void onNext(PayInfoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.getTHospitalizationExpensesVoAllByConditionSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
