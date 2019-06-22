package com.jzr.netty.common.base;

public class ResponseMsg extends BaseMsg {
    private Integer status = 0;   //状态
    private String message;   //返回的


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
