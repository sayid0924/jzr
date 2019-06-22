package com.jzr.bedside.bean.boby;

public class DeviceBoby {

    /**
     * 设备号
     */
    private String deviceNo;

    /**
     * 设备mac地址
     */
    private String deviceMac;

    /**
     * 设备ip地址
     */
    private String deviceIp;

    /**
     * 设备类型 0:床头卡 1:护理看板 2:移动PDA
     */
    private Integer deviceType;

    /**
     * 绑定的床位号
     */
    private String registerBed;

    /**
     * 绑定的状态 0:未绑定 1:绑定中
     */
    private Integer registerState;

    /**
     * 床头卡app版本号
     */
    private String appVersion;

    /**
     * 护理看板ip地址
     */
    private String nurseboardIp;

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

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getNurseboardIp() {
        return nurseboardIp;
    }

    public void setNurseboardIp(String nurseboardIp) {
        this.nurseboardIp = nurseboardIp;
    }
}
