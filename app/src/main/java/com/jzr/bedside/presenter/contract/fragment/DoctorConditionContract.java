
package com.jzr.bedside.presenter.contract.fragment;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.DoctorByConditionBean;

public interface DoctorConditionContract {

    interface View extends BaseContract.BaseView {

        // 根据条件查询医生分页信息
        void  findDoctorByConditionSuccess(DoctorByConditionBean doctorByConditionBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 根据条件查询医生分页信息
        void  findDoctorByCondition(String... s);


    }
}
