
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.R;
import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.presenter.contract.activity.SettingActivityContract;
import com.jzr.bedside.utils.LogUtils;
import com.blankj.utilcode.utils.ToastUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SettingActivityPresenter extends BasePresenter<SettingActivityContract.View> implements SettingActivityContract.Presenter<SettingActivityContract.View> {

    public SettingActivityPresenter(BaseActivity context) {
        super(context);
    }

    @Override
    public void bedcardGetbedinfo(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().bedcardGetbedinfo(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BedInfoBean>() {
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
                    public void onNext(BedInfoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.bedcardGetbedinfoSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }

    @Override
    public void connectTest(String... s) {
        mContext.showWaitingDialog("加载中...");
        addSubscrebe(Api.getInstance().bedcardGetbedinfo(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BedInfoBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
                        mContext.hideWaitingDialog();
                        mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        ToastUtils.showLongToast("测试连接失败");
                    }

                    @Override
                    public void onNext(BedInfoBean data) {
                        mContext.hideWaitingDialog();
                        if (mView != null && data != null) {
                            mView.connectTestSuccess(data);
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_sucess);
                        } else {
                            mView.getIvServicePort().setBackgroundResource(R.drawable.test_result_fail);
                        }
                    }
                }));
    }
}
