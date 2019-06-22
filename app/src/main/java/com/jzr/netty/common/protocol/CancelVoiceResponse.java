package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class CancelVoiceResponse extends ResponseMsg {
    public CancelVoiceResponse() {
        super();
        setType(MsgType.CANCEL_VOICE);
    }
}