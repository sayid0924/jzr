package com.jzr.bedside.bean;

/**
 * Created by Bben on 2018/11/6.
 */

public class DoctorAdvice {

    int  id;
    String lableName;
    String viewColor;
    String detailContent;
    String status;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLableName() {
        return lableName;
    }

    public void setLableName(String lableName) {
        this.lableName = lableName;
    }

    public String getViewColor() {
        return viewColor;
    }

    public void setViewColor(String viewColor) {
        this.viewColor = viewColor;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
