package com.jzr.netty.common.base;


import java.io.Serializable;
import java.util.Date;


public class DeviceLive implements Serializable {
    private static final long serialVersionUID = 1L;

    private String deviceNo;

    private String deviceMac;

    private String deviceIp;

    private Integer deviceType;

    private String registerBed;

    private Integer registerState;

    private Float appVersion;

    private String nurseboardIp;

    private Date lastUpTime;

    private String lastAppVersion;

    private String deptCode;

    private String nurseName;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }

    public String getDeviceMac() {
        return deviceMac;
    }

    public void setDeviceMac(String deviceMac) {
        this.deviceMac = deviceMac;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public String getRegisterBed() {
        return registerBed;
    }

    public void setRegisterBed(String registerBed) {
        this.registerBed = registerBed;
    }

    public Integer getRegisterState() {
        return registerState;
    }

    public void setRegisterState(Integer registerState) {
        this.registerState = registerState;
    }

    public Float getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Float appVersion) {
        this.appVersion = appVersion;
    }

    public String getNurseboardIp() {
        return nurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        this.nurseboardIp = nurseboardIp;
    }

    public Date getLastUpTime() {
        return lastUpTime;
    }

    public void setLastUpTime(Date lastUpTime) {
        this.lastUpTime = lastUpTime;
    }

    public String getLastAppVersion() {
        return lastAppVersion;
    }

    public void setLastAppVersion(String lastAppVersion) {
        this.lastAppVersion = lastAppVersion;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getNurseName() {
        return nurseName;
    }

    public void setNurseName(String nurseName) {
        this.nurseName = nurseName;
    }
}
