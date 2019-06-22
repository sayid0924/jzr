package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

public class UpgradeRequest extends BaseMsg {
    private Integer deviceType;
    private Float   appVersion;
    private String   appUrl;
    private Integer upgradeMode;   //1 = 代表自己，2=代表其他端来升级系统

    public UpgradeRequest() {
        super();
        setType(MsgType.UPGRADE);
    }

    @Override
    public Integer getDeviceType() {
        return deviceType;
    }

    @Override
    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Float getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Float appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }

    public Integer getUpgradeMode() {
        return upgradeMode;
    }

    public void setUpgradeMode(Integer upgradeMode) {
        this.upgradeMode = upgradeMode;
    }
}
