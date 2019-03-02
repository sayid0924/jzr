package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class CancelVoiceRequest extends BaseMsg {
    private  String bedInfo;
    private String CancelIp;

    public CancelVoiceRequest() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }

    public String getBedInfo() {
        return bedInfo;
    }

    public void setBedInfo(String bedInfo) {
        this.bedInfo = bedInfo;
    }

    public String getCancelIp() {
        return CancelIp;
    }

    public void setCancelIp(String cancelIp) {
        CancelIp = cancelIp;
    }
}