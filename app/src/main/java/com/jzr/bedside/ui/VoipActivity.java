package com.jzr.bedside.ui;

import android.content.Intent;
import android.graphics.Color;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.utils.AEvent;
import com.jzr.bedside.utils.ColorUtils;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.DensityUtils;
import com.jzr.bedside.utils.listener.DemoBeautyCallback;
import com.jzr.bedside.utils.listener.XHChatManagerListener;
import com.jzr.bedside.utils.listener.XHGroupManagerListener;
import com.jzr.bedside.utils.listener.XHLoginManagerListener;
import com.jzr.bedside.utils.listener.XHVoipManagerListener;
import com.jzr.bedside.utils.listener.XHVoipP2PManagerListener;
import com.jzr.bedside.view.CircularCoverView;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHConstants;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.api.XHVoipManager;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHVoipManagerListener;
import com.starrtc.starrtcsdk.core.StarRtcCore;
import com.starrtc.starrtcsdk.core.audio.StarRTCAudioManager;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;
import com.starrtc.starrtcsdk.core.player.StarPlayer;
import com.starrtc.starrtcsdk.core.pusher.ScreenRecorder;

import java.util.Set;

public class VoipActivity extends BaseActivity implements View.OnClickListener {

    public static String ACTION = "ACTION";
    public static String RING = "RING";
    public static String CALLING = "CALLING";


    private StarRTCAudioManager starRTCAudioManager;

    private XHVoipManager voipManager;

    private static final int REQUEST_CODE = 1;
    private MediaProjectionManager mMediaProjectionManager;
    private ScreenRecorder mRecorder;

    private StarPlayer targetPlayer;
    private StarPlayer selfPlayer;
    private Chronometer timer;

    private Boolean isTalking = false;

    private String action;
    private String targetId;


    @Override
    public int getLayoutId() {
        return R.layout.activity_voip;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        starRTCAudioManager = StarRTCAudioManager.create(this.getApplicationContext());
        starRTCAudioManager.start(new StarRTCAudioManager.AudioManagerEvents() {
            @Override
            public void onAudioDeviceChanged(StarRTCAudioManager.AudioDevice selectedAudioDevice, Set<StarRTCAudioManager.AudioDevice> availableAudioDevices) {
                Logger.e("onAudioDeviceChanged ", selectedAudioDevice.name());
            }
        });

        voipManager = XHClient.getInstance().getVoipManager();
        voipManager.setRtcMediaType(XHConstants.XHRtcMediaTypeEnum.STAR_RTC_MEDIA_TYPE_VIDEO_AND_AUDIO);

        targetId = getIntent().getStringExtra("targetId");
        action = getIntent().getStringExtra(ACTION);

        targetPlayer = (StarPlayer) findViewById(R.id.voip_surface_target);
        selfPlayer = (StarPlayer) findViewById(R.id.voip_surface_self);
        selfPlayer.setZOrderMediaOverlay(true);
        timer = (Chronometer) findViewById(R.id.timer);
        targetPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTalking) {
                    findViewById(R.id.talking_view).setVisibility(findViewById(R.id.talking_view).getVisibility() == View.VISIBLE ? View.INVISIBLE : View.VISIBLE);
                }
            }
        });

        addListener();

        ((TextView) findViewById(R.id.targetid_text)).setText(targetId);
        findViewById(R.id.head_bg).setBackgroundColor(ColorUtils.getColor(VoipActivity.this, targetId));
        ((CircularCoverView) findViewById(R.id.head_cover)).setCoverColor(Color.parseColor("#000000"));
        int cint = DensityUtils.dip2px(VoipActivity.this, 45);
        ((CircularCoverView) findViewById(R.id.head_cover)).setRadians(cint, cint, cint, cint, 0);

        findViewById(R.id.calling_hangup).setOnClickListener(this);
        findViewById(R.id.talking_hangup).setOnClickListener(this);
        findViewById(R.id.switch_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voipManager.switchCamera();
            }
        });
        findViewById(R.id.screen_btn).setOnClickListener(this);

        if(action.equals(CALLING)){

            showCallingView();
            Logger.e("newVoip","call");
            voipManager.call(this,targetId, new IXHResultCallback() {
                @Override
                public void success(Object data) {
                    Logger.e("newVoip","call success");
                }
                @Override
                public void failed(String errMsg) {
                    Logger.e("newVoip","call failed");
                    stopAndFinish();
                }
            });
        }else{
            Logger.e("newVoip","onPickup");
            onPickup();
        }
    }

    @Override
    public void onRestart(){
        super.onRestart();
        addListener();
    }

    @Override
    public void onDestroy(){
        removeListener();
        super.onDestroy();
    }

    public void addListener(){
        AEvent.addListener(AEvent.AEVENT_VOIP_INIT_COMPLETE,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_BUSY,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_REFUSED,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_HANGUP,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_CONNECT,this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_ERROR,this);
    }

    public void removeListener(){
        Constant.canPickupVoip = true;
        AEvent.removeListener(AEvent.AEVENT_VOIP_INIT_COMPLETE,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_BUSY,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_REFUSED,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_HANGUP,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_CONNECT,this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_ERROR,this);
    }

    @Override
    public void dispatchEvent(String aEventID, boolean success, final Object eventObj) {
        super.dispatchEvent(aEventID,success,eventObj);
        switch (aEventID){
            case AEvent.AEVENT_VOIP_REV_BUSY:
                ToastUtils.showLongToast("对方线路忙");
                stopAndFinish();
                break;
            case AEvent.AEVENT_VOIP_REV_REFUSED:
                ToastUtils.showLongToast("对方拒绝通话");
                stopAndFinish();
                break;
            case AEvent.AEVENT_VOIP_REV_HANGUP:
                ToastUtils.showLongToast("对方已挂断");
                timer.stop();
                stopAndFinish();
                break;
            case AEvent.AEVENT_VOIP_REV_CONNECT:
                ToastUtils.showLongToast("对方允许通话");
                showTalkingView();
                break;
            case AEvent.AEVENT_VOIP_REV_ERROR:
                ToastUtils.showLongToast((String) eventObj);
                stopAndFinish();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calling_hangup:
                voipManager.cancel(new IXHResultCallback() {
                    @Override
                    public void success(Object data) {
                        stopAndFinish();
                    }

                    @Override
                    public void failed(String errMsg) {
                        stopAndFinish();
                    }
                });
                break;
            case R.id.talking_hangup:
                voipManager.hangup(new IXHResultCallback() {
                    @Override
                    public void success(Object data) {
                        stopAndFinish();
                    }

                    @Override
                    public void failed(String errMsg) {
                        stopAndFinish();
                    }
                });
                break;
            case R.id.screen_btn:
                if (!XHCustomConfig.getInstance().getHardwareEnable()) {
                    ToastUtils.showLongToast("需要打开硬编模式");
                    return;
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (mMediaProjectionManager == null) {
                        mMediaProjectionManager = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
                    }
                    if (mRecorder != null) {
                        //                    ((TextView)findViewById(R.id.screen_btn)).setText("屏");
                        findViewById(R.id.screen_btn).setSelected(false);
                        mRecorder.quit();
                        mRecorder = null;
                        StarRtcCore.getInstance().voipShareCamera();
                    } else {
                        Intent captureIntent = mMediaProjectionManager.createScreenCaptureIntent();
                        startActivityForResult(captureIntent, REQUEST_CODE);
                    }
                } else {
                    ToastUtils.showLongToast("系统版本过低，无法使用录屏功能");
                }
                break;
        }
    }


    private void showTalkingView(){
        isTalking = true;
        findViewById(R.id.calling_view).setVisibility(View.INVISIBLE);
        findViewById(R.id.talking_view).setVisibility(View.VISIBLE);
        FrameLayout.LayoutParams flp = (FrameLayout.LayoutParams) findViewById(R.id.talking_view).getLayoutParams();
        flp.width = findViewById(R.id.calling_view).getWidth();
        findViewById(R.id.talking_view).setLayoutParams(flp);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
        setupViews();
    }

    private void onPickup(){
        voipManager.accept(this,targetId, new IXHResultCallback() {
            @Override
            public void success(Object data) {
               Logger.e("newVoip","onPickup OK ");
            }
            @Override
            public void failed(String errMsg) {
                Logger.e("newVoip","onPickup failed ");
                stopAndFinish();
            }
        });
        showTalkingView();
    }


    private void showCallingView(){
        findViewById(R.id.calling_view).setVisibility(View.VISIBLE);
        findViewById(R.id.talking_view).setVisibility(View.INVISIBLE);
    }

    private void setupViews(){
        voipManager.setupView(selfPlayer, targetPlayer, new IXHResultCallback() {
            //        voipManager.setupView(this,null, targetPlayer, new IXHResultCallback() {
            @Override
            public void success(Object data) {
                Logger.e("newVoip","setupView success");
            }

            @Override
            public void failed(String errMsg) {
                Logger.e("newVoip","setupView failed");
                stopAndFinish();
            }
        });
    }

    private void stopAndFinish() {
        if (starRTCAudioManager != null) {
            starRTCAudioManager.stop();
        }
        VoipActivity.this.finish();
    }

}
