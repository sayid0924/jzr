
package com.jzr.bedside.presenter.impl.activity;


import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.jzr.bedside.presenter.contract.activity.RecordContract;
import com.jzr.bedside.utils.LogUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RecordActivityPresenter extends BasePresenter<RecordContract.View> implements RecordContract.Presenter<RecordContract.View> {


    @Override
    public void selectByMedicationRecordid(String... s) {

        addSubscrebe(Api.getInstance().selectByMedicationRecordid(s).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MedicationRecordBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e(e.toString());
//                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(MedicationRecordBean data) {

                        if (mView != null && data != null && data.getCode()==0) {
                            mView.selectByMedicationRecordidSuccess(data);
                        }
                    }
                }));
    }
}
