
package com.jzr.bedside.presenter.contract.activity;


import android.widget.ImageView;
import android.widget.TextView;

import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.CheckDeptBean;
import com.jzr.bedside.bean.DeviceBean;
import com.jzr.bedside.bean.boby.DeviceBoby;

public interface SettingActivityContract {

    interface View extends BaseContract.BaseView {

        TextView getTvLocation();
        ImageView getIvServicePort();

        // 根据设备编号获取床位及病人信息
//        void  bedcardGetbedinfoSuccess(BedInfoBean data);
        void  connectTestSuccess(CheckDeptBean data);
        // 绑定床头卡
        void  getBedcardBindtobedSuccess(DeviceBean deviceBean);
        // 获取科室列表
        void  getDeptCodelistSuccess(CheckDeptBean  checkDeptBean);
        // 获取科室房间列表
        void getDeptRoomListSuccess(CheckDeptBean checkDeptBean);
        // 获取科室房间床位列表
        void getDeptBedListSuccess(CheckDeptBean checkDeptBean);


    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        // 根据设备编号获取床位及病人信息
//        void  bedcardGetbedinfo(String ...s);
        void connectTest(String ...s);
        // 绑定床头卡
        void  getBedcardBindtobed(DeviceBoby deviceBoby);

        // 获取科室列表
        void  getDeptCodelist(String ...s);

        // 获取科室房间列表
        void  getDeptRoomlist(String ...s);

        // 获取科室房间床位列表
        void  getDeptBealist(String ...s);

    }
}
