package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月21日
 *  主要是消息推送用
 */
public class MsgNoticeRequest extends BaseMsg {
    private Object message_notice;

    public MsgNoticeRequest() {
        super();
        setType(MsgType.MSG_NOTICE);
    }

    public Object getMessage_notice() {
        return message_notice;
    }

    public void setMessage_notice(Object message_notice) {
        this.message_notice = message_notice;
    }
}