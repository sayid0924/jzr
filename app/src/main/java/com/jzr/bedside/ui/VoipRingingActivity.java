package com.jzr.bedside.ui;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.utils.AEvent;
import com.jzr.bedside.utils.ColorUtils;
import com.jzr.bedside.utils.DensityUtils;
import com.jzr.bedside.view.CircularCoverView;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;

public class VoipRingingActivity extends BaseActivity implements View.OnClickListener {


    private String targetId;

    @Override
    public int getLayoutId() {
        return R.layout.activity_voip_ringing;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {
        addListener();
        targetId = getIntent().getStringExtra("targetId");
        findViewById(R.id.ring_hangoff).setOnClickListener(this);
        findViewById(R.id.ring_pickup).setOnClickListener(this);
        findViewById(R.id.ring_pickup_audio).setOnClickListener(this);
        ((TextView) findViewById(R.id.targetid_text)).setText(targetId);
        findViewById(R.id.head_bg).setBackgroundColor(ColorUtils.getColor(VoipRingingActivity.this, targetId));
        ((CircularCoverView) findViewById(R.id.head_cover)).setCoverColor(Color.parseColor("#000000"));
        int cint = DensityUtils.dip2px(VoipRingingActivity.this, 45);
        ((CircularCoverView) findViewById(R.id.head_cover)).setRadians(cint, cint, cint, cint, 0);

    }

    public void addListener() {
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_HANGUP, this);
        AEvent.addListener(AEvent.AEVENT_VOIP_REV_ERROR, this);
    }

    public void removeListener() {
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_HANGUP, this);
        AEvent.removeListener(AEvent.AEVENT_VOIP_REV_ERROR, this);
    }

    @Override
    public void dispatchEvent(final String aEventID, boolean success, final Object eventObj) {
        super.dispatchEvent(aEventID, success, eventObj);
        switch (aEventID) {
            case AEvent.AEVENT_VOIP_REV_HANGUP:
                ToastUtils.showLongToast("对方已挂断");
                finish();
                break;
            case AEvent.AEVENT_VOIP_REV_ERROR:
                Logger.e((String) eventObj);
                finish();
                break;
        }
    }

    @Override
    public void onRestart() {
        super.onRestart();
        addListener();
    }

    @Override
    public void onStop() {
        super.onStop();
        removeListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ring_hangoff:
                XHClient.getInstance().getVoipManager().refuse(new IXHResultCallback() {
                    @Override
                    public void success(Object data) {
                        finish();
                   }

                    @Override
                    public void failed(String errMsg) {
                        finish();
                    }
                });
                break;
            case R.id.ring_pickup: {
                Intent intent = new Intent(VoipRingingActivity.this, VoipActivity.class);
                intent.putExtra("targetId", targetId);
                intent.putExtra(VoipActivity.ACTION, VoipActivity.RING);
                startActivity(intent);
                finish();
                break;
            }
            case R.id.ring_pickup_audio: {
//                Intent intent = new Intent(VoipRingingActivity.this, VoipAudioActivity.class);
//                intent.putExtra("targetId", targetId);
//                intent.putExtra(VoipAudioActivity.ACTION, VoipAudioActivity.RING);
//                startActivity(intent);
//                finish();
                break;
            }
        }
    }
}
