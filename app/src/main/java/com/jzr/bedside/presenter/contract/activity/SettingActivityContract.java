
package com.jzr.bedside.presenter.contract.activity;


import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.BedInfoBean;

public interface SettingActivityContract {

    interface View extends BaseContract.BaseView {

        TextView getTvLocation();
        ImageView getIvServicePort();

        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfoSuccess(BedInfoBean data);
        void  connectTestSuccess(BedInfoBean data);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfo(String ...s);
        void connectTest(String ...s);

    }
}
