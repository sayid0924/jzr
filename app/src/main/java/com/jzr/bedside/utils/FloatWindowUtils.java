package com.jzr.bedside.utils;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseApplication;
import com.yhao.floatwindow.FloatWindow;

/**
 * Created by Bben on 2018/12/27.
 */

public class FloatWindowUtils implements LogUtils.OnLogistener {

    public static FloatWindowUtils INSTANCE;
    public static boolean isShow = false;
    private TextView tvLog;
    private StringBuffer sb = new StringBuffer();

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    if (isShow && tvLog != null) {
                        sb.append((String) msg.obj+"\n");
                        tvLog.setText(sb.toString());
                    }
                    break;
            }
        }
    };

    private FloatWindowUtils() {
        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_floatview, null);
        tvLog = view.findViewById(R.id.tv_log);
        tvLog.setMovementMethod(ScrollingMovementMethod.getInstance());
        FloatWindow
                .with(BaseApplication.getContext())
                .setView(view)
                .setWidth(800)                               //设置控件宽高
                .setHeight(800)
                .setDesktopShow(true)   //桌面显示
                .setTag("FloatWindow")
                .build();
        LogUtils.getInstance().OnLogistener(this);
    }

    public static FloatWindowUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FloatWindowUtils();
            return INSTANCE;
        }
        return INSTANCE;
    }

    public  boolean   isShow(){
         return  isShow;
    }

    public void show() {
        FloatWindow.get("FloatWindow").show();
        isShow = true;
    }

    public void destroy() {
        FloatWindow.destroy("FloatWindow");
        isShow = false;
        INSTANCE = null;
    }

    @Override
    public void OnLogistener(String tag) {
        Message message = handler.obtainMessage();
        message.what = 1;
        message.obj = tag;
        handler.sendMessage(message);
    }
}
