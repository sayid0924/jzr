package com.jzr.bedside.base;

import java.util.List;

/**
 * Created by Bben on 2018/11/23.
 */

public class PayInfoBean {


    /**
     * code : 0
     * message : 查询住院费用信息成功
     * timestamp : {"epochSecond":1542940768,"nano":13000000}
     * data : [{"id":1,"patientId":1,"alreadyPaid":10000,"balance":309,"alipayUrl":"https://www.alipay.com/","wechatUrl":"https://www.wechat.com/zh_TW/","description":null,"thospitalizationExpensesDayVoList":null}]
     */

    private int code;
    private String message;
    private TimestampBean timestamp;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TimestampBean getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(TimestampBean timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TimestampBean {
        /**
         * epochSecond : 1542940768
         * nano : 13000000
         */

        private int epochSecond;
        private int nano;

        public int getEpochSecond() {
            return epochSecond;
        }

        public void setEpochSecond(int epochSecond) {
            this.epochSecond = epochSecond;
        }

        public int getNano() {
            return nano;
        }

        public void setNano(int nano) {
            this.nano = nano;
        }
    }

    public static class DataBean {
        /**
         * id : 1
         * patientId : 1
         * alreadyPaid : 10000
         * balance : 309
         * alipayUrl : https://www.alipay.com/
         * wechatUrl : https://www.wechat.com/zh_TW/
         * description : null
         * thospitalizationExpensesDayVoList : null
         */

        private int id;
        private int patientId;
        private int alreadyPaid;
        private int balance;
        private String alipayUrl;
        private String wechatUrl;
        private Object description;
        private Object thospitalizationExpensesDayVoList;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public int getAlreadyPaid() {
            return alreadyPaid;
        }

        public void setAlreadyPaid(int alreadyPaid) {
            this.alreadyPaid = alreadyPaid;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public String getAlipayUrl() {
            return alipayUrl;
        }

        public void setAlipayUrl(String alipayUrl) {
            this.alipayUrl = alipayUrl;
        }

        public String getWechatUrl() {
            return wechatUrl;
        }

        public void setWechatUrl(String wechatUrl) {
            this.wechatUrl = wechatUrl;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public Object getThospitalizationExpensesDayVoList() {
            return thospitalizationExpensesDayVoList;
        }

        public void setThospitalizationExpensesDayVoList(Object thospitalizationExpensesDayVoList) {
            this.thospitalizationExpensesDayVoList = thospitalizationExpensesDayVoList;
        }
    }
}
