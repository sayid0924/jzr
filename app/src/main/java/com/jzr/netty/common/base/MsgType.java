package com.jzr.netty.common.base;

public enum MsgType {
    PING,          //测试网络请求

    REGISTER,      //注册设备
    UPGRADE,       //升级APP软件

    VOICE,         //语音通话
    CANCEL_VOICE,  //取消语音通话

    VIDEO,         //视频
    CANCEL_VIDEO,  //取消视频

    MSG_NOTICE,     //消息通知
    LOCK_SCREEN,     //锁屏

    GET_DEVICE_LIST,  //获取在线设备清单

    RELOAD_DATA,            //重新加载数据

    RESTART_APP,       //重启APP

    RESTART_DEVICE,     //重启设备

    CAPTURE_SCREEN     //抓屏

}