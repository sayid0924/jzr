package com.jzr.bedside.utils;

public interface IEventListener {
    abstract public void dispatchEvent(String aEventID, boolean success, Object eventObj);
}
