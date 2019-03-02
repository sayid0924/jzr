package com.jzr.netty.protocol;

import com.jzr.netty.base.BaseMsg;
import com.jzr.netty.base.MsgType;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public class UpgradeRequest extends BaseMsg {
    private String version;
    private Integer upgradeMode;   //1 = 代表自己，2=代表其他端来升级系统

    public UpgradeRequest() {
        super();
        setType(MsgType.UPGRADE);
    }

    public Integer getUpgradeMode() {
        return upgradeMode;
    }

    public void setUpgradeMode(Integer upgradeMode) {
        this.upgradeMode = upgradeMode;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
