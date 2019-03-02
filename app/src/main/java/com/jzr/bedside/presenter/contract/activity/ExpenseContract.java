
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.base.ExpenseDetailBean;

public interface ExpenseContract {

    interface View extends BaseContract.BaseView {
        /**
         * 根据条件查询所有住院费用及详情信息
         */
        void getThisAndDetailAllByConditionSuccess(ExpenseDetailBean expenseDetailBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 根据条件查询所有住院费用及详情信息
         */
        void getThisAndDetailAllByCondition(String... s);


    }
}
