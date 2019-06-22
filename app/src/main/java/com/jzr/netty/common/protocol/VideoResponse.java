package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class VideoResponse extends ResponseMsg {
    public VideoResponse() {
        super();
        setType(MsgType.VIDEO);
    }
}