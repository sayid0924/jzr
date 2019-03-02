
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.DoctorBean;
import com.jzr.bedside.bean.NurseInfoBean;

public interface DutyDoctorContract {

    interface View extends BaseContract.BaseView {

        // 查询医生详细信息接口
        void  selectByDoctorIdSuccess(DoctorBean doctorBean);


        // 查询护士详细信息接口
        void  selectByNurseIdSuccess(NurseInfoBean nurseInfoBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 查询医生详细信息接口
        void  selectByDoctorId(String... s);

        // 查询护士详细信息接口
        void  selectByNurseId(String... s);

    }
}
