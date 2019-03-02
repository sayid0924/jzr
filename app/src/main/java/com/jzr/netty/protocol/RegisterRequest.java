package com.jzr.netty.protocol;


import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

public class RegisterRequest extends BaseMsg {

    public RegisterRequest() {
        super();
        setType(MsgType.REGISTER);
    }

}