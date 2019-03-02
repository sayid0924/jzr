package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class PingMsg extends BaseMsg {

    private  String MacIp;
    private  String AppVersion;
    private  String NurseboardIp;


    public String getNurseboardIp() {
        return NurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        NurseboardIp = nurseboardIp;
    }

    public String getMacIp() {
        return MacIp;
    }

    public void setMacIp(String macIp) {
        MacIp = macIp;
    }

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String appVersion) {
        AppVersion = appVersion;
    }

    public PingMsg() {
        super();
        setType(MsgType.PING);
    }
}