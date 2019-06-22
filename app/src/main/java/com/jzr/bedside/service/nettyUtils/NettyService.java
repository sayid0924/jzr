package com.jzr.bedside.service.nettyUtils;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.DeviceUtils;
import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.protocol.CancelVoiceRequest;
import com.jzr.netty.common.protocol.GetDeviceListRequest;
import com.jzr.netty.common.protocol.PingMsg;
import com.jzr.netty.common.protocol.RegisterRequest;
import com.jzr.netty.common.protocol.UpgradeRequest;
import com.jzr.netty.common.protocol.VoiceRequest;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.security.PublicKey;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;


public class NettyService extends Service implements NettyListener {

    private NetworkReceiver receiver;

    private static NettySenMsgListener nettySenMsgListener;

    private ScheduledExecutorService mScheduledExecutorService;

    public  static MyThread thread  ;


    private void shutdown() {
        if (mScheduledExecutorService != null) {
            mScheduledExecutorService.shutdown();
            mScheduledExecutorService = null;
        }
    }

    public static void setNettySenMsgListener(NettySenMsgListener nettySenMsgListener) {
        NettyService.nettySenMsgListener = nettySenMsgListener;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);
        receiver = new NetworkReceiver();
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);

        // 自定义心跳，每隔10秒向服务器发送心跳包
//        mScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        mScheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                PingMsg auth = new PingMsg();
//                auth.setClientId(Constant.ClientId);
//                auth.setType(MsgType.PING);
//                auth.setIp(CommonUtil.getIP());
//                auth.setEquipmentType(Constant.EquipmentType);
//                auth.setMacIp(DeviceUtils.getMacAddress());
//                auth.setAppVersion(AppUtils.getAppVersionName(NettyService.this));
//                auth.setNurseboardIp(PreferUtil.getInstance().getLookIp());
//                NettyClient.getInstance().sendMsgToServer(auth, new ChannelFutureListener() {
//                    @Override
//                    public void operationComplete(ChannelFuture future) {
//                        if (future.isSuccess()) {
////                            Logger.e("Write heartbeat successful");
//                        } else {
////                            Logger.e("Write heartbeat error");
//                        }
//                    }
//                });
//            }
//        }, 0, 10, TimeUnit.SECONDS);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NettyClient.getInstance().setListener(this);
        connect();
        return START_NOT_STICKY;
    }

    @Override
    public void onServiceStatusConnectChanged(int statusCode) {        //连接状态监听
//        Logger.e("connect status:%d", statusCode);
//        EventBus.getDefault().post(new EvenBusConnectStatus(statusCode));

        if (statusCode == NettyListener.STATUS_CONNECT_SUCCESS) {
            authenticData();
        } else {
//            Logger.e("tcp connect error");
        }
    }

    public static void pingData() {

        PingMsg auth = new PingMsg();

        auth.setDeviceIp(CommonUtil.getIP());
        auth.setDeviceMac(DeviceUtils.getMacAddress());
        auth.setDeviceNo(Build.SERIAL);
        auth.setDeviceType(0);
        auth.setNurseboardIp(PreferUtil.getInstance().getLookIp());
        auth.setType(MsgType.PING);

        auth.setAppVersion(Float.parseFloat(AppUtils.getAppVersionName(BaseApplication.getContext())));

        NettyClient.getInstance().sendMsgToServer(auth, new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    if (nettySenMsgListener != null) {
                        nettySenMsgListener.senMegSuccess();
                    }
                } else {
                    if (nettySenMsgListener != null) {
                        nettySenMsgListener.senMegFail();
                    }
                }
            }
        });
    }


    /**
     *  获取在线设备列表
     */

    public  static  void  GetDeviceList(){

        GetDeviceListRequest getDeviceListRequest = new GetDeviceListRequest();
        getDeviceListRequest.setDeviceIp(CommonUtil.getIP());
        getDeviceListRequest.setDeviceNo(Build.SERIAL);
        getDeviceListRequest.setDeviceType(2);
        getDeviceListRequest.setType(MsgType.GET_DEVICE_LIST);
        getDeviceListRequest.setDeptCode(PreferUtil.getInstance().getDeptCode());

        Logger.e("CODE  >>>>  "+ PreferUtil.getInstance().getDeptCode());

        NettyClient.getInstance().sendMsgToServer(getDeviceListRequest, new ChannelFutureListener() {    //3
            @Override
            public void operationComplete(ChannelFuture future) {
//                if (future.isSuccess()) {
//                    if (nettySenMsgListener != null) {
//                        Logger.e("senMegSuccess");
//                    }
//                } else {
//                    if (nettySenMsgListener != null) {
//                        Logger.e("senMegFail");
//                    }
//                }
            }
        });

    }

    /**
     * 认证数据请求
     */
    public static void authenticData() {

        RegisterRequest auth = new RegisterRequest();
        auth.setDeviceIp(CommonUtil.getIP());
        auth.setDeviceMac(DeviceUtils.getMacAddress());
        auth.setDeviceNo(Build.SERIAL);
        auth.setDeviceType(0);
        auth.setNurseboardIp(PreferUtil.getInstance().getLookIp());
        auth.setType(MsgType.REGISTER);
        auth.setAppVersion(Float.parseFloat(AppUtils.getAppVersionName(BaseApplication.getContext())));
        auth.setDeptCode(PreferUtil.getInstance().getDeptCode());

        NettyClient.getInstance().sendMsgToServer(auth, new ChannelFutureListener() {    //3
            @Override
            public void operationComplete(ChannelFuture future) {
                if (future.isSuccess()) {
                    if (nettySenMsgListener != null) {
                        Logger.e("senMegSuccess");
                        nettySenMsgListener.senMegSuccess();
                    }
                } else {
                    if (nettySenMsgListener != null) {
                        Logger.e("senMegFail");
                        nettySenMsgListener.senMegFail();
                    }
                }
            }
        });
    }

    /**
     * 发送语音数据请求
     */
    public static void sendVoiceData() {

//        VoiceRequest voiceRequest = new VoiceRequest();
//        voiceRequest.setClientId(Constant.ClientId);
//        voiceRequest.setEquipmentType(Constant.EquipmentType);
//        voiceRequest.setNurseCeardIp(PreferUtil.getInstance().getLookIp());
//        voiceRequest.setIp(CommonUtil.getIP());
//        voiceRequest.setBedInfo("请注意10号床在呼叫");
//        NettyClient.getInstance().sendMsgToServer(voiceRequest, new ChannelFutureListener() {    //3
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                if (future.isSuccess()) {
//                } else {
//                    Logger.e("Write auth error");
//                }
//            }
//        });
    }

    /**
     * 发送取消语音数据请求
     */
    public static void sendCancelVoiceData() {
//        CancelVoiceRequest cancelVoiceRequest = new CancelVoiceRequest();
//        cancelVoiceRequest.setClientId(Constant.ClientId);
//        cancelVoiceRequest.setEquipmentType(Constant.EquipmentType);
//        cancelVoiceRequest.setCancelIp(PreferUtil.getInstance().getLookIp());
//        NettyClient.getInstance().sendMsgToServer(cancelVoiceRequest, new ChannelFutureListener() {
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                if (future.isSuccess()) {
//                } else {
//                    Logger.e("Write auth error");
//                }
//            }
//        });
    }


    /**
     * 升级数据请求
     */
    public void upgradeData() {

//        UpgradeRequest upgradeRequest = new UpgradeRequest();
//        upgradeRequest.setUpgradeMode(1);
//        upgradeRequest.setClientId(Constant.ClientId);
//        upgradeRequest.setEquipmentType(Constant.EquipmentType);
//
//        NettyClient.getInstance().sendMsgToServer(upgradeRequest, new ChannelFutureListener() {    //3
//            @Override
//            public void operationComplete(ChannelFuture future) {
//                if (future.isSuccess()) {
//                    //升级请求
//                    Logger.e("升级请求成功");
//                } else {
//                    Logger.e("Write auth error");
//                }
//            }
//        });
    }

    @Override
    public void onMessageResponse(BaseMsg baseMsg) {
        // 接收
        EventBus.getDefault().post(baseMsg);
    }

    @Subscribe
    public void getEventBus(BaseMsg baseMsg) {
        switch (baseMsg.getType()) {
            case UPGRADE:
                break;
        }
    }

    public static void connect() {
        NettyClient.getInstance().disconnect();
        thread = new MyThread();
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
        shutdown();
        NettyClient.getInstance().setReconnectNum(0);
        NettyClient.getInstance().disconnect();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public class NetworkReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI
                        || activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                    connect();
                }
            }
        }
    }

    static class MyThread extends Thread{
        @Override
        public void run() {
            super.run();
            try {
                NettyClient.getInstance().connect();//连接服务器
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void destroyThread() {
        try {
            if (null != thread && Thread.State.RUNNABLE == thread .getState()) {
                try {
                    Thread.sleep(500);
                    thread .interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            thread = null;
        }
    }
}
