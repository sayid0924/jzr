
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.HospitalBean;

public interface HospitalActivityContract {

    interface View extends BaseContract.BaseView {

        // 根据id查询医院信息
        void  selectByHospitalIdSuccess(HospitalBean hospitalBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 根据id查询医院信息
        void  selectByHospitalId(String... s);

    }
}
