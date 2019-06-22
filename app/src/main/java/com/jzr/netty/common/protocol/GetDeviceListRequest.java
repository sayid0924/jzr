package com.jzr.netty.common.protocol;

import com.jzr.netty.common.base.BaseMsg;
import com.jzr.netty.common.base.MsgType;

import java.util.List;

public class GetDeviceListRequest extends BaseMsg {

    private String deptCode;
    private List<String> deviceNoList;

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public List<String> getDeviceNoList() {
        return deviceNoList;
    }

    public void setDeviceNoList(List<String> deviceNoList) {
        this.deviceNoList = deviceNoList;
    }

    public GetDeviceListRequest(){
        super();
        this.setType(MsgType.GET_DEVICE_LIST);
        this.setDeviceNo("admin");
    }
}
