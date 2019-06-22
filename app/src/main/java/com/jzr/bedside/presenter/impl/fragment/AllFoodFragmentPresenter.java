
package com.jzr.bedside.presenter.impl.fragment;


import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.bedside.api.Api;
import com.jzr.bedside.base.BasePresenter;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.bean.FoodMenuBean;
import com.jzr.bedside.presenter.contract.fragment.AllFoodFragmentContract;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AllFoodFragmentPresenter extends BasePresenter<AllFoodFragmentContract.View> implements AllFoodFragmentContract.Presenter<AllFoodFragmentContract.View> {


    @Override
    public void getFoodMenuSelectAll(String... s) {
        addSubscrebe(Api.getInstance().getFoodMenuSelectAll(s)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<FoodMenuBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mView.showError(e.toString());
                    }

                    @Override
                    public void onNext(FoodMenuBean data) {
                        if (mView != null && data != null && data.getCode()==0) {
                            mView.getFoodMenuSelectAllSuccess(data);
                        }else
                            ToastUtils.showLongToast("请求错误  请重新请求........");
                    }
                }));
    }
}
