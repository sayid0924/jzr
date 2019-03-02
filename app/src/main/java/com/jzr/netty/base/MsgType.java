package com.jzr.netty.base;

/**
 * @author 陈旭东
 * @version 1.0
 * @date 2018年11月10日
 */
public enum MsgType {
    PING,          //测试网络请求

    REGISTER,      //注册设备
    UPGRADE,       //升级APP软件

    VOICE,         //语音通话
    CANCEL_VOICE,  //取消语音通话

    VIDEO,         //视频
    CANCEL_VIDEO,  //取消视频

    MSG_NOTICE,     //消息通知
    LOCK_SCREEN     //锁屏

}