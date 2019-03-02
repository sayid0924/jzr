package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class VoiceRequest extends BaseMsg {
    private Object voice;

    private  String bedInfo;
    private  String nurseCeardIp;


    public VoiceRequest() {
        super();
        setType(MsgType.VOICE);
    }

    public Object getVoice() {
        return voice;
    }

    public void setVoice(Object voice) {
        this.voice = voice;
    }

    public String getNurseCeardIp() {
        return nurseCeardIp;
    }

    public void setNurseCeardIp(String nurseCeardIp) {
        this.nurseCeardIp = nurseCeardIp;
    }


    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}