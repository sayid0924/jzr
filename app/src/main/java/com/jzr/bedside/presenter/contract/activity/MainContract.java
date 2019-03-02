
package com.jzr.bedside.presenter.contract.activity;


import com.jzr.bedside.base.BaseContract;
import com.jzr.bedside.bean.BedInfoBean;

public interface MainContract {

    interface View extends BaseContract.BaseView {
        /**
         * 建立与融云服务器的连接成功
         */
        void connectSuccess();

        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfoSuccess(BedInfoBean data);
        void  bedcardGetbedinfoFail( );

    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        /**
         * 建立与融云服务器的连接
         */
        void connect(String ...s);

        // 根据设备编号获取床位及病人信息// 根据设备编号获取床位及病人信息
        void  bedcardGetbedinfo(boolean tag,String ...s);

    }
}
