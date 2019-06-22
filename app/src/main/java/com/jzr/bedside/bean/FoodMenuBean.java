package com.jzr.bedside.bean;

import java.util.List;

public class FoodMenuBean {


    /**
     * code : 0
     * status : 0
     * message : 查询数据成功
     * msg : 查询数据成功
     * count : 0
     * timestamp : 2019-06-01T03:47:16.798Z
     * data : [{"id":1,"name":"鸡蛋小炒肉饭","price":"36","type":1,"introduce":"这道鸡蛋小炒肉，绝对是下饭神器","imgUrl":"https://5b0988e595225.cdn.sohucs.com/images/20180724/94707c1373ce40658f2d1a8b759281d4.jpg"},{"id":2,"name":"糖醋排骨","price":"5","type":2,"introduce":null,"imgUrl":"http://i1.chuimg.com/10818d90873611e6a9a10242ac110002_620w_472h.jpg@2o_50sh_1pr_1l_660w_90q_1wh"},{"id":3,"name":"完美早餐韩式鸡蛋蛋糕","price":"4","type":3,"introduce":"可以根据自己口味调味，因为这个没有什么特殊的味道，可以放点黑胡椒啥的，或者挤点番茄酱吃","imgUrl":"http://i2.chuimg.com/0b44f25916094935bc93804b84e217e8_1080w_864h.jpg?imageView2/2/w/660/interlace/1/q/90"},{"id":4,"name":"家乡麻团","price":"54","type":4,"introduce":"关于馅料，一般用红豆馅、绿豆馅、紫薯馅的我也试过、或者直接做空心的，都可以。","imgUrl":"http://i2.chuimg.com/e4eeb8238a9c4b45b93c0978170122ef_1284w_1920h.jpg?imageView2/2/w/660/interlace/1/q/90"}]
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * name : 鸡蛋小炒肉饭
         * price : 36
         * type : 1
         * introduce : 这道鸡蛋小炒肉，绝对是下饭神器
         * imgUrl : https://5b0988e595225.cdn.sohucs.com/images/20180724/94707c1373ce40658f2d1a8b759281d4.jpg
         */

        private int id;
        private String name;
        private String price;
        private int type;
        private String introduce;
        private String imgUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
    }
}
