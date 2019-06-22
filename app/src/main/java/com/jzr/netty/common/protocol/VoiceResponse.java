package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class VoiceResponse extends ResponseMsg {
    private String bedInfo;
    public VoiceResponse() {
        super();
        setType(MsgType.VOICE);
    }

}