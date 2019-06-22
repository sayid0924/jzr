
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.TQuestionBean;
import com.jzr.bedside.presenter.contract.activity.EvaluateActivityContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class EvaluateActivityPresenter extends BasePresenter<EvaluateActivityContract.View> implements EvaluateActivityContract.Presenter<EvaluateActivityContract.View> {


    @Override
    public void questionGettQuestionvoBypage(String... s) {

        addSubscrebe(Api.getInstance().questionGettQuestionvoBypage(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<TQuestionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                    }

                    @Override
                    public void onNext(TQuestionBean data) {
                        if (mView != null && data != null && data.getCode()==0) {
                           mView.questionGettQuestionvoBypageSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }

    @Override
    public void addTUserQuestionnaire(String... s) {
        addSubscrebe(Api.getInstance().addTUserQuestionnaire(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<TQuestionBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                    }

                    @Override
                    public void onNext(TQuestionBean data) {
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.addTUserQuestionnaireSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
