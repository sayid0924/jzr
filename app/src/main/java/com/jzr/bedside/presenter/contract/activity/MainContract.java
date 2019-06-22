
package com.jzr.bedside.presenter.contract.activity;


import android.content.Context;

import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.BedInfoBean;

public interface MainContract {

    interface View extends BaseContract.BaseView {

        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfoSuccess(BedInfoBean data);

        void  downAppSuccess();

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {


        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfo(String ...s);

        void  downApp(Context context , String url, String path);
    }
}
