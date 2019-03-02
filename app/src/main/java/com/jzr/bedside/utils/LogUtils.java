package com.jzr.bedside.utils;

import com.orhanobut.logger.Logger;

/**
 * Created by Bben on 2018/12/27.
 */

public class LogUtils {

    public static LogUtils INSTANCE;

    public static LogUtils getInstance() {

        if (INSTANCE == null) {
            return new LogUtils();
        }
        return INSTANCE;

    }

    private static OnLogistener onLogistener;

    public static void e(String tag) {
        Logger.e(tag);
        if (onLogistener != null) {
            onLogistener.OnLogistener(tag);
        }
    }

    public void i(String tag) {
        Logger.i(tag);
        if (onLogistener != null) {
            onLogistener.OnLogistener(tag);
        }
    }

    public interface OnLogistener {
        void OnLogistener(String tag);
    }

    public void OnLogistener(OnLogistener onLogistener) {
        this.onLogistener = onLogistener;
    }

}
