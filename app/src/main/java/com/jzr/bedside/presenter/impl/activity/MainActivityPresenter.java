
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.presenter.contract.activity.MainContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import okhttp3.ResponseBody;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivityPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter<MainContract.View> {


    public MainActivityPresenter(BaseActivity context) {
        super(context);

    }

    @Override
    public void connect(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().TestLink(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
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
                    public void onNext(ResponseBody data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null) {

                        }
                    }
                }));
    }

    @Override
    public void bedcardGetbedinfo(boolean tag, String... s) {
//        if (tag) {
//            mContext.showWaitingDialog("加载中...");
//        }
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
                        mContext.hideWaitingDialog();
                        mView.bedcardGetbedinfoFail();
                    }

                    @Override
                    public void onNext(BedInfoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode() == 0) {
                            mView.bedcardGetbedinfoSuccess(data);
                        } else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
