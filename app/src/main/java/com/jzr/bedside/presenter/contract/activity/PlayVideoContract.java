
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.VideoBean;

public interface PlayVideoContract {

    interface View extends BaseContract.BaseView {
        /**
         * 根据条件查询视频信息
         */
        void gettVideovoByConditionSuccess(VideoBean data);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 根据条件查询视频信息
         */
        void gettVideovoByCondition(String... s);



    }
}
