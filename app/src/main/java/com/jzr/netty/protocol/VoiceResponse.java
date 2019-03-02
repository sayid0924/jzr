package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class VoiceResponse extends BaseMsg {
    private Integer status;

    public VoiceResponse() {
        super();
        setType(MsgType.VOICE);
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}