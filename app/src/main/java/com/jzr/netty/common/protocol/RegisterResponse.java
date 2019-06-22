package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

public class RegisterResponse extends ResponseMsg {
    public RegisterResponse() {
        super();
        setType(MsgType.REGISTER);
    }

}