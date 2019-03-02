package com.jzr.bedside.bean;

/**
 * Created by Bben on 2019/2/11.
 */

public class FoodBean {
    String name;
    String imgurl;
    String doe;
    String price;

    public FoodBean(String name, String imgurl, String doe,String price) {
        this.name = name;
        this.imgurl = imgurl;
        this.doe = doe;
        this.price =price;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDoe() {
        return doe;
    }

    public void setDoe(String doe) {
        this.doe = doe;
    }
}
