package com.jzr.bedside.bean;

/**
 * Created by Bben on 2018/11/17.
 */

public class EvenBusConnectStatus {
    int statusCode;


    public EvenBusConnectStatus(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
