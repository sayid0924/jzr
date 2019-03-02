
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.VideoBean;
import com.jzr.bedside.presenter.contract.activity.PlayVideoContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PlayVideoPresenter extends BasePresenter<PlayVideoContract.View> implements PlayVideoContract.Presenter<PlayVideoContract.View> {



    public PlayVideoPresenter(BaseActivity context) {
        super(context);

    }


    @Override
    public void gettVideovoByCondition(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().gettVideovoByCondition(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<VideoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mContext.hideWaitingDialog();
                    }

                    @Override
                    public void onNext(VideoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.gettVideovoByConditionSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
