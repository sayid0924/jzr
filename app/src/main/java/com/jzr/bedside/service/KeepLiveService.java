package com.jzr.bedside.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import com.jzr.bedside.ui.VoipRingingActivity;
import com.jzr.bedside.utils.AEvent;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.IEventListener;
import com.jzr.bedside.utils.listener.DemoBeautyCallback;
import com.jzr.bedside.utils.listener.XHChatManagerListener;
import com.jzr.bedside.utils.listener.XHGroupManagerListener;
import com.jzr.bedside.utils.listener.XHLoginManagerListener;
import com.jzr.bedside.utils.listener.XHVoipManagerListener;
import com.jzr.bedside.utils.listener.XHVoipP2PManagerListener;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;

/**
 * Created by zhangjt on 2017/8/6.
 */
public class KeepLiveService extends Service implements IEventListener {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        initSDK();
        return super.onStartCommand(intent, flags, startId);
    }

    private void initSDK(){
            initFree();
    }

    private boolean isLogin = false;
    private final boolean checkNetState = false;
    //开放版SDK初始化
    private void initFree(){
        isLogin = XHClient.getInstance().getIsOnline();
        if(!isLogin){
            addListener();
            //初始化 开放版 无调度 直接指定Server地址

            XHCustomConfig customConfig =  XHCustomConfig.getInstance();
            customConfig.setAppId(CommonUtil.getIP());
            customConfig.setChatroomServerUrl("192.168.1.15:19906");
            customConfig.setLiveSrcServerUrl("192.168.1.15:19931");
            customConfig.setLiveVdnServerUrl("192.168.1.15:19925");
            customConfig.setImServereUrl("192.168.1.15:19903");
            customConfig.setVoipServerUrl("192.168.1.15:10086");

            customConfig.initSDKForFree(this, CommonUtil.getIP(), new IXHErrorCallback() {
                @Override
                public void error(final String errMsg, Object data) {
                    Logger.e(errMsg);
                }
            },new Handler());

//        customConfig.setLogDirPath(Environment.getExternalStorageDirectory().getPath()+"/starrtcLog");
            customConfig.setDefConfigOpenGLESEnable(false);
            customConfig.setDefConfigCamera2Enable(false);
            XHClient.getInstance().getChatManager().addListener(new XHChatManagerListener());
            XHClient.getInstance().getGroupManager().addListener(new XHGroupManagerListener());
            XHClient.getInstance().getVoipManager().addListener(new XHVoipManagerListener());
            XHClient.getInstance().getVoipP2PManager().addListener(new XHVoipP2PManagerListener());
            XHClient.getInstance().getLoginManager().addListener(new XHLoginManagerListener());
            XHBeautyManager.getInstance().setBeautyDataCallback(new DemoBeautyCallback());

            //登录SDK 不需要验证用户权限
            XHClient.getInstance().getLoginManager().loginFree(new IXHResultCallback() {
                @Override
                public void success(Object data) {
                    Logger.e("AAAA");
                }
                @Override
                public void failed(final String errMsg) {
                    Logger.e("BBBB");
                }
            });
        }
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, final Object eventObj) {
        switch (aEventID) {
            case AEvent.AEVENT_VOIP_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_REV_CALLING);

                Intent intent = new Intent(this, VoipRingingActivity.class);
                intent.putExtra("targetId", eventObj.toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
                startActivity(intent);

                break;
            case AEvent.AEVENT_VOIP_P2P_REV_CALLING:
                Logger.e(AEvent.AEVENT_VOIP_P2P_REV_CALLING);
                break;
            case AEvent.AEVENT_C2C_REV_MSG:
                Logger.e(AEvent.AEVENT_C2C_REV_MSG);
                break;
            case AEvent.AEVENT_GROUP_REV_MSG:
                Logger.e(AEvent.AEVENT_GROUP_REV_MSG);
                break;
            case AEvent.AEVENT_USER_OFFLINE:
                Logger.e(AEvent.AEVENT_USER_OFFLINE);
                break;
            case AEvent.AEVENT_USER_ONLINE:
                Logger.e(AEvent.AEVENT_USER_ONLINE);
                break;
        }
    }

    private void addListener(){

        AEvent.addListener(AEvent.AEVENT_LOGIN,this);
//    AEvent.addListener(AEvent.AEVENT_LOGOUT,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
//    AEvent.addListener(AEvent.AEVENT_VOIP_REV_CALLING_AUDIO,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.addListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.addListener(AEvent.AEVENT_GROUP_REV_MSG,this);

    }

    private void removeListener(){

        AEvent.removeListener(AEvent.AEVENT_LOGIN,this);
//        AEvent.removeListener(AEvent.AEVENT_LOGOUT,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_CALLING,this);
//        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_CALLING_AUDIO,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_P2P_REV_CALLING,this);
        AEvent.removeListener(AEvent.AEVENT_C2C_REV_MSG,this);
        AEvent.removeListener(AEvent.AEVENT_GROUP_REV_MSG,this);

    }

}
