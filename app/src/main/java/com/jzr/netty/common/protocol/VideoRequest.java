package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class VideoRequest extends BaseMsg {
    private Object video;

    public VideoRequest() {
        super();
        setType(MsgType.VIDEO);
    }

    public Object getVideo() {
        return video;
    }

    public void setVideo(Object video) {
        this.video = video;
    }
}