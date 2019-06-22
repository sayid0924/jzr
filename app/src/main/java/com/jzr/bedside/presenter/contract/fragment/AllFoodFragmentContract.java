
package com.jzr.bedside.presenter.contract.fragment;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.FoodMenuBean;

import rx.Observable;

public interface AllFoodFragmentContract {

    interface View extends BaseContract.BaseView {

     void   getFoodMenuSelectAllSuccess(FoodMenuBean foodMenuBean);

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void   getFoodMenuSelectAll(String ...s);



    }


}
