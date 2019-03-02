package com.jzr.bedside.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.appmanage.AppManagerService;
import com.jzr.bedside.bean.RabbitMqBean;
import com.jzr.bedside.service.nettyUtils.NettyClient;
import com.jzr.bedside.service.nettyUtils.NettyService;
import com.jzr.bedside.ui.MainActivity;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.bedside.view.SwipeBackActivity.SwipeBackActivity;
import com.jzr.bedside.view.SwipeBackActivity.SwipeBackLayout;
import com.jzr.bedside.view.dialog.CustomDialog;
import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.jaeger.library.StatusBarUtil;
import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.protocol.CancelVoiceResponse;
import com.jzr.netty.protocol.UpgradeResponse;
import com.jzr.netty.protocol.VoiceRequest;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;

import static com.jzr.bedside.appmanage.AppManagerService.INTENT_BOOLEAN_EXTRA_AUTO_START_UP;
import static com.jzr.bedside.appmanage.AppManagerService.INTENT_STRING_EXTRA_APK_URL;
import static com.jzr.bedside.base.BaseApplication.MAIN_EXECUTOR;

public abstract class BaseActivity extends SwipeBackActivity {

    public final static List<AppCompatActivity> mActivities = new LinkedList<>();
    private SwipeBackLayout mSwipeBackLayout;
    private Unbinder bind;
    private CustomDialog mDialogWaiting;
    private TextView tvToggle;
    private boolean istask = false;
    private boolean isToggleRing = false;

    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initTime(TimeUtils.getNowTimeString("EEEE yyyy-MM-dd HH:mm:ss"));
                    break;
                case 2:
                    if (MainActivity.mainActivity != null) {
                        MainActivity.mainActivity.bedcardGetbedinfo();
                    }
                    break;
                case 3:
                    hideWaitingDialog();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        bind = ButterKnife.bind(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        //沉浸式状态栏
        StatusBarUtil.setColor(this, getResources().getColor(R.color.colorPrimaryDark), 10);
        attachView();
        initView();

        synchronized (mActivities) {
            mActivities.add(this);
        }

        EventBus.getDefault().register(this);
        if (!istask) {
            BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(TimeTask(), 0, 1, TimeUnit.SECONDS);
        }

        BaseApplication.MAIN_EXECUTOR.scheduleWithFixedDelay(UpaddteDate(), 0, 5, TimeUnit.MINUTES);

    }


    public Runnable UpaddteDate() {
        return new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.what = 2;
                handler.sendMessage(message);
            }
        };
    }

    public Runnable TimeTask() {
        return new Runnable() {
            @Override
            public void run() {
                Message message = handler.obtainMessage();
                message.what = 1;
                handler.sendMessage(message);
            }
        };
    }


    public void killAll() {
        // 复制了一份mActivities 集合
        List<AppCompatActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<>(mActivities);
        }
        for (AppCompatActivity activity : copy) {
            activity.finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    public void onPause() {
        super.onPause();

    }

    @Subscribe
    public void getEventBus(BaseMsg baseMsg) {
        Message message = handler.obtainMessage();
        switch (baseMsg.getType()) {
            case UPGRADE:
                UpgradeResponse upgradeResponse = (UpgradeResponse) baseMsg;
                Logger.e("getEventBus>>>>>>>     " + upgradeResponse.getAppPath());
                Logger.e("getEventBus>>>>>>>     " + upgradeResponse.getStatus());
                Logger.e("getEventBus>>>>>>>     " + String.valueOf(upgradeResponse.getVersion()));
                if (upgradeResponse.getVersion() > AppUtils.getAppVersionCode(this)) {
                    // 升级
                    Logger.e("开始升级");
                    MAIN_EXECUTOR.execute(receiveUpdate(upgradeResponse.getAppPath()));
                }
                break;

            case CANCEL_VOICE:
                CancelVoiceResponse cancelVideoResponse = (CancelVoiceResponse) baseMsg;
                Logger.e("CANCEL_VOICE    ");
                message.what = 3;
                handler.sendMessage(message);

                break;
        }
    }

    @Subscribe
    public void getEventBus(RabbitMqBean rabbitMqBean) {
        switch (rabbitMqBean.getType()) {
            case RabbitMqBean.UPDDATEDATA:
//                MainActivity.mainActivity.bedcardGetbedinfo();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == Constant.RING_KEY) {
            if (event.getAction() != KeyEvent.ACTION_DOWN || event.getRepeatCount() > 0) {
                return true;
            }
            switch (keyCode) {
                case Constant.RING_KEY:
                    toggleRing();
                    break;
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void toggleRing() {
        showToggleRingDidlog("呼叫护士站中请稍等...");
        NettyService.sendVoiceData();
    }

    private void toggleVideo() {
    }


    /**
     * 呼叫护士对话框
     */
    public void showToggleRingDidlog(String text) {
        hideWaitingDialog();
        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_toggle_ring, null);

        tvToggle = view.findViewById(R.id.tv_toggle);
        tvToggle.setText(text);
        Button btnCancel = view.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideWaitingDialog();
                NettyService.sendCancelVoiceData();
            }
        });
        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
        mDialogWaiting.show();
        mDialogWaiting.setCancelable(false);
        mDialogWaiting.show();
        isToggleRing = true;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        return super.dispatchTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
        if (bind != null)
            bind.unbind();

        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            mDialogWaiting = null;
        }

        detachView();
        EventBus.getDefault().unregister(this);
//        BaseApplication.getRefWatcher().watch(this);

    }

    @SuppressWarnings("deprecation")
    public void initSwipeBackLayout() {
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }

    public void setEdgeTrackingEnabled(int size, int position) {
        if (size == 0) {
        }
        // 只有一个fragment  - 左右滑关闭
        else if (size == 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_ALL);
        }
        // 多个fragment  - 位于左侧尽头 - 只可左滑关闭
        else if (size != 1 && position == 0) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        }
        // 多个fragment  - 位于右侧尽头 - 只可右滑关闭
        else if (size != 1 && position == size - 1) {
            mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_RIGHT);
        }
        // 多个fragment  - 位于中间 - 屏蔽所有左右滑关闭事件
        else {
            mSwipeBackLayout.setEdgeTrackingEnabled(0);
        }
    }

    protected void finishActivity() {
        overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
    }

    public void startActivityIn(Intent intent, Activity curAct) {
        if (intent != null) {
            curAct.startActivity(intent);
            curAct.overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
        }
    }

    @Override
    public void finish() {
        super.finish();
        finishActivity();
    }

    /**
     * 显示等待提示框
     */
    public Dialog showWaitingDialog(String tip) {
        hideWaitingDialog();
//        View view = View.inflate(this, R.layout.dialog_waiting, null);
//        if (!TextUtils.isEmpty(tip))
//            ((TextView) view.findViewById(R.id.tvTip)).setText(tip);
//        mDialogWaiting = new CustomDialog(this, view, R.style.MyDialog);
//        mDialogWaiting.show();
//        mDialogWaiting.setCancelable(true);
//        return mDialogWaiting;
        return null;
    }

    /**
     * 隐藏等待提示框
     */
    public void hideWaitingDialog() {
        if (mDialogWaiting != null) {
            mDialogWaiting.dismiss();
            mDialogWaiting = null;
            isToggleRing = false;
        }
    }

    /**
     * 更新新版本
     *
     * @return
     */
    private Runnable receiveUpdate(final String path) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Intent appManager = new Intent(BaseActivity.this, AppManagerService.class);
                    appManager.setAction("com.bben.appmanager.PACKAGE_UPDATE");
                    appManager.setPackage("com.bben.appmanager");
                    appManager.putExtra(INTENT_STRING_EXTRA_APK_URL, path);
                    appManager.putExtra(INTENT_BOOLEAN_EXTRA_AUTO_START_UP, true);
                    BaseActivity.this.startService(appManager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

//    @Override
//    public void onReceive(UDPMessage message) {
//        Message mes = handler.obtainMessage();
//        mes.what = message.getType();
//        handler.sendMessage(mes);
//    }

//    @Override
//    public void sendFailure() {
//
//    }

    public abstract int getLayoutId();

    public abstract void attachView();

    public abstract void detachView();

    public abstract void initView();

    protected void initTime(String nowTime) {

    }

}
