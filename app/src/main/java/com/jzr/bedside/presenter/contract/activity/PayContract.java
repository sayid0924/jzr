
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.base.PayInfoBean;

public interface PayContract {

    interface View extends BaseContract.BaseView {
        /**
         * 根据条件查询所有住院费用
         */
        void  getTHospitalizationExpensesVoAllByConditionSuccess(PayInfoBean payInfoBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 根据条件查询所有住院费用
         */
        void  getTHospitalizationExpensesVoAllByCondition(String... s);


    }
}
