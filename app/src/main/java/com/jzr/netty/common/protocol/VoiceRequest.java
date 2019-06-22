package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class VoiceRequest extends BaseMsg {
    private Object voice;
    private String nurseboardIp;
    private  String bedInfo;

    public VoiceRequest() {
        super();
        setType(MsgType.VOICE);
    }

}