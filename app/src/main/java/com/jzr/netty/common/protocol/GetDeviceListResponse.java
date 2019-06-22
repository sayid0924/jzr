package com.jzr.netty.common.protocol;


import com.jzr.netty.common.base.DeviceLive;
import com.jzr.netty.common.base.MsgType;
import com.jzr.netty.common.base.ResponseMsg;

import java.util.List;

public class GetDeviceListResponse extends ResponseMsg {
     List<DeviceLive>  list;
    public GetDeviceListResponse(){
        super();
        this.setType(MsgType.GET_DEVICE_LIST);
    }

    public List<DeviceLive> getList() {
        return list;
    }

    public void setList(List<DeviceLive> list) {
        this.list = list;
    }

}
