package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

import java.util.Date;

public class PingMsg extends BaseMsg {
    private String deviceNo;
    private String deviceIp;
    private Integer deviceType;
    private String nurseboardIp;
    private Float appVersion;
    private String deviceMac;
    private String registerBed;
    private Date lastUpTime;

    private String deptCode;

    public PingMsg() {
        super();
        setType(MsgType.PING);
    }


    @Override
    public String getDeviceNo() {
        return deviceNo;
    }

    @Override
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    @Override
    public String getDeviceIp() {
        return deviceIp;
    }

    @Override
    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    @Override
    public Integer getDeviceType() {
        return deviceType;
    }

    @Override
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getNurseboardIp() {
        return nurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        this.nurseboardIp = nurseboardIp;
    }

    public Float getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Float appVersion) {
        this.appVersion = appVersion;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getRegisterBed() {
        return registerBed;
    }

    public void setRegisterBed(String registerBed) {
        this.registerBed = registerBed;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }
}