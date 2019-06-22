package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class CancelVoiceRequest extends BaseMsg {

    private String CancelIp;
    private  String bedInfo;
    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }

    public String getCancelIp() {
        return CancelIp;
    }

    public void setCancelIp(String cancelIp) {
        CancelIp = cancelIp;
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }
}