
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.MedicationRecordBean;

public interface RecordContract {

    interface View extends BaseContract.BaseView {


        // 用药记录信息
        void  selectByMedicationRecordidSuccess(MedicationRecordBean medicationRecordBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 用药记录信息
        void  selectByMedicationRecordid(String... s);

    }
}
