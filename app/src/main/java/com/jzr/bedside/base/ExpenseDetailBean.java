package com.jzr.bedside.base;

import java.util.List;

/**
 * Created by Bben on 2018/11/23.
 */

public class ExpenseDetailBean {


    /**
     * code : 0
     * message : 查询住院费用信息成功
     * timestamp : {"epochSecond":1542936923,"nano":562000000}
     * data : [{"id":1,"patientId":1,"alreadyPaid":10000,"balance":309,"alipayUrl":"https://www.alipay.com/","wechatUrl":"https://www.wechat.com/zh_TW/","description":null,"thospitalizationExpensesDayVoList":[{"id":1,"expensesId":1,"dateOfHospitalization":"2018-11-01","totalCostOfDay":8392,"description":null,"thospitalizationExpensesDetailVoList":[{"id":1,"expensesDayId":1,"expensesName":"住院费","unit":"元","unitPrice":560,"number":1,"amountOfMoney":560,"description":null},{"id":2,"expensesDayId":1,"expensesName":"西药费","unit":"元","unitPrice":35,"number":1,"amountOfMoney":35,"description":null},{"id":3,"expensesDayId":1,"expensesName":"手术费","unit":"元","unitPrice":6120,"number":1,"amountOfMoney":6120,"description":null},{"id":4,"expensesDayId":1,"expensesName":"血费","unit":"元","unitPrice":1200,"number":1,"amountOfMoney":1200,"description":null},{"id":5,"expensesDayId":1,"expensesName":"检验费","unit":"元","unitPrice":90,"number":1,"amountOfMoney":90,"description":null},{"id":6,"expensesDayId":1,"expensesName":"透视费","unit":"元","unitPrice":120,"number":1,"amountOfMoney":120,"description":null},{"id":7,"expensesDayId":1,"expensesName":"氧气","unit":"元","unitPrice":25,"number":1,"amountOfMoney":25,"description":null},{"id":8,"expensesDayId":1,"expensesName":"陪护","unit":"元","unitPrice":200,"number":1,"amountOfMoney":200,"description":null},{"id":9,"expensesDayId":1,"expensesName":"理疗","unit":"元","unitPrice":30,"number":1,"amountOfMoney":30,"description":null},{"id":10,"expensesDayId":1,"expensesName":"其它","unit":"元","unitPrice":12,"number":1,"amountOfMoney":12,"description":null}]}]}]
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
         * epochSecond : 1542936923
         * nano : 562000000
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
         * thospitalizationExpensesDayVoList : [{"id":1,"expensesId":1,"dateOfHospitalization":"2018-11-01","totalCostOfDay":8392,"description":null,"thospitalizationExpensesDetailVoList":[{"id":1,"expensesDayId":1,"expensesName":"住院费","unit":"元","unitPrice":560,"number":1,"amountOfMoney":560,"description":null},{"id":2,"expensesDayId":1,"expensesName":"西药费","unit":"元","unitPrice":35,"number":1,"amountOfMoney":35,"description":null},{"id":3,"expensesDayId":1,"expensesName":"手术费","unit":"元","unitPrice":6120,"number":1,"amountOfMoney":6120,"description":null},{"id":4,"expensesDayId":1,"expensesName":"血费","unit":"元","unitPrice":1200,"number":1,"amountOfMoney":1200,"description":null},{"id":5,"expensesDayId":1,"expensesName":"检验费","unit":"元","unitPrice":90,"number":1,"amountOfMoney":90,"description":null},{"id":6,"expensesDayId":1,"expensesName":"透视费","unit":"元","unitPrice":120,"number":1,"amountOfMoney":120,"description":null},{"id":7,"expensesDayId":1,"expensesName":"氧气","unit":"元","unitPrice":25,"number":1,"amountOfMoney":25,"description":null},{"id":8,"expensesDayId":1,"expensesName":"陪护","unit":"元","unitPrice":200,"number":1,"amountOfMoney":200,"description":null},{"id":9,"expensesDayId":1,"expensesName":"理疗","unit":"元","unitPrice":30,"number":1,"amountOfMoney":30,"description":null},{"id":10,"expensesDayId":1,"expensesName":"其它","unit":"元","unitPrice":12,"number":1,"amountOfMoney":12,"description":null}]}]
         */

        private int id;
        private int patientId;
        private int alreadyPaid;
        private int balance;
        private String alipayUrl;
        private String wechatUrl;
        private Object description;
        private List<ThospitalizationExpensesDayVoListBean> thospitalizationExpensesDayVoList;

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

        public List<ThospitalizationExpensesDayVoListBean> getThospitalizationExpensesDayVoList() {
            return thospitalizationExpensesDayVoList;
        }

        public void setThospitalizationExpensesDayVoList(List<ThospitalizationExpensesDayVoListBean> thospitalizationExpensesDayVoList) {
            this.thospitalizationExpensesDayVoList = thospitalizationExpensesDayVoList;
        }

        public static class ThospitalizationExpensesDayVoListBean {
            /**
             * id : 1
             * expensesId : 1
             * dateOfHospitalization : 2018-11-01
             * totalCostOfDay : 8392
             * description : null
             * thospitalizationExpensesDetailVoList : [{"id":1,"expensesDayId":1,"expensesName":"住院费","unit":"元","unitPrice":560,"number":1,"amountOfMoney":560,"description":null},{"id":2,"expensesDayId":1,"expensesName":"西药费","unit":"元","unitPrice":35,"number":1,"amountOfMoney":35,"description":null},{"id":3,"expensesDayId":1,"expensesName":"手术费","unit":"元","unitPrice":6120,"number":1,"amountOfMoney":6120,"description":null},{"id":4,"expensesDayId":1,"expensesName":"血费","unit":"元","unitPrice":1200,"number":1,"amountOfMoney":1200,"description":null},{"id":5,"expensesDayId":1,"expensesName":"检验费","unit":"元","unitPrice":90,"number":1,"amountOfMoney":90,"description":null},{"id":6,"expensesDayId":1,"expensesName":"透视费","unit":"元","unitPrice":120,"number":1,"amountOfMoney":120,"description":null},{"id":7,"expensesDayId":1,"expensesName":"氧气","unit":"元","unitPrice":25,"number":1,"amountOfMoney":25,"description":null},{"id":8,"expensesDayId":1,"expensesName":"陪护","unit":"元","unitPrice":200,"number":1,"amountOfMoney":200,"description":null},{"id":9,"expensesDayId":1,"expensesName":"理疗","unit":"元","unitPrice":30,"number":1,"amountOfMoney":30,"description":null},{"id":10,"expensesDayId":1,"expensesName":"其它","unit":"元","unitPrice":12,"number":1,"amountOfMoney":12,"description":null}]
             */

            private int id;
            private int expensesId;
            private String dateOfHospitalization;
            private int totalCostOfDay;
            private Object description;
            private List<ThospitalizationExpensesDetailVoListBean> thospitalizationExpensesDetailVoList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getExpensesId() {
                return expensesId;
            }

            public void setExpensesId(int expensesId) {
                this.expensesId = expensesId;
            }

            public String getDateOfHospitalization() {
                return dateOfHospitalization;
            }

            public void setDateOfHospitalization(String dateOfHospitalization) {
                this.dateOfHospitalization = dateOfHospitalization;
            }

            public int getTotalCostOfDay() {
                return totalCostOfDay;
            }

            public void setTotalCostOfDay(int totalCostOfDay) {
                this.totalCostOfDay = totalCostOfDay;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public List<ThospitalizationExpensesDetailVoListBean> getThospitalizationExpensesDetailVoList() {
                return thospitalizationExpensesDetailVoList;
            }

            public void setThospitalizationExpensesDetailVoList(List<ThospitalizationExpensesDetailVoListBean> thospitalizationExpensesDetailVoList) {
                this.thospitalizationExpensesDetailVoList = thospitalizationExpensesDetailVoList;
            }

            public static class ThospitalizationExpensesDetailVoListBean {
                public ThospitalizationExpensesDetailVoListBean(int id, int expensesDayId, String expensesName, String unit, int unitPrice, int number, int amountOfMoney, Object description) {
                    this.id = id;
                    this.expensesDayId = expensesDayId;
                    this.expensesName = expensesName;
                    this.unit = unit;
                    this.unitPrice = unitPrice;
                    this.number = number;
                    this.amountOfMoney = amountOfMoney;
                    this.description = description;
                }

                /**
                 * id : 1
                 * expensesDayId : 1
                 * expensesName : 住院费
                 * unit : 元
                 * unitPrice : 560
                 * number : 1
                 * amountOfMoney : 560
                 * description : null
                 */




                private int id;
                private int expensesDayId;
                private String expensesName;
                private String unit;
                private int unitPrice;
                private int number;
                private int amountOfMoney;
                private Object description;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getExpensesDayId() {
                    return expensesDayId;
                }

                public void setExpensesDayId(int expensesDayId) {
                    this.expensesDayId = expensesDayId;
                }

                public String getExpensesName() {
                    return expensesName;
                }

                public void setExpensesName(String expensesName) {
                    this.expensesName = expensesName;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public int getUnitPrice() {
                    return unitPrice;
                }

                public void setUnitPrice(int unitPrice) {
                    this.unitPrice = unitPrice;
                }

                public int getNumber() {
                    return number;
                }

                public void setNumber(int number) {
                    this.number = number;
                }

                public int getAmountOfMoney() {
                    return amountOfMoney;
                }

                public void setAmountOfMoney(int amountOfMoney) {
                    this.amountOfMoney = amountOfMoney;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }
            }
        }
    }
}
