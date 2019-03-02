package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/21.
 */

public class MedicationRecordBean {


    /**
     * code : 0
     * message : 查询用药记录信息成功
     * timestamp : {"epochSecond":1542771067,"nano":445000000}
     * data : {"pageNum":1,"pageSize":2,"total":2,"pages":1,"list":[{"id":2,"patientId":1,"cureNo":"123466799","drugDeliveryNurseId":2,"drugDeliveryNurseName":"小护士","dateOfHospitalization":"2018-11-02 00:00:00","description":null,"tdrugsDoseVoList":[{"id":5,"medicationRecordId":2,"drugName":"奥美拉唑肠溶颗粒","breakfastConsumption":"1#","lunchConsumption":"1#","dinnerConsumption":null,"beforeSleepConsumption":"1#","other":null,"description":null}]},{"id":1,"patientId":1,"cureNo":"123466799","drugDeliveryNurseId":1,"drugDeliveryNurseName":"护士梅厄米","dateOfHospitalization":"2018-11-01 00:00:00","description":null,"tdrugsDoseVoList":[{"id":1,"medicationRecordId":1,"drugName":"奥美拉唑肠融胶囊 20mg","breakfastConsumption":"1#","lunchConsumption":null,"dinnerConsumption":"1#","beforeSleepConsumption":null,"other":null,"description":null},{"id":2,"medicationRecordId":1,"drugName":"枸橼酸铋钾颗粒","breakfastConsumption":"1#","lunchConsumption":"1#","dinnerConsumption":"1#","beforeSleepConsumption":null,"other":null,"description":null},{"id":3,"medicationRecordId":1,"drugName":"硝苯地平缓释片 10mg","breakfastConsumption":"1#","lunchConsumption":null,"dinnerConsumption":null,"beforeSleepConsumption":null,"other":null,"description":null},{"id":4,"medicationRecordId":1,"drugName":"氟桂利嗪","breakfastConsumption":null,"lunchConsumption":null,"dinnerConsumption":null,"beforeSleepConsumption":"1#","other":null,"description":null}]}],"isFirstPage":true,"isLastPage":true}
     */

    private int code;
    private String message;
    private TimestampBean timestamp;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class TimestampBean {
        /**
         * epochSecond : 1542771067
         * nano : 445000000
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
         * pageNum : 1
         * pageSize : 2
         * total : 2
         * pages : 1
         * list : [{"id":2,"patientId":1,"cureNo":"123466799","drugDeliveryNurseId":2,"drugDeliveryNurseName":"小护士","dateOfHospitalization":"2018-11-02 00:00:00","description":null,"tdrugsDoseVoList":[{"id":5,"medicationRecordId":2,"drugName":"奥美拉唑肠溶颗粒","breakfastConsumption":"1#","lunchConsumption":"1#","dinnerConsumption":null,"beforeSleepConsumption":"1#","other":null,"description":null}]},{"id":1,"patientId":1,"cureNo":"123466799","drugDeliveryNurseId":1,"drugDeliveryNurseName":"护士梅厄米","dateOfHospitalization":"2018-11-01 00:00:00","description":null,"tdrugsDoseVoList":[{"id":1,"medicationRecordId":1,"drugName":"奥美拉唑肠融胶囊 20mg","breakfastConsumption":"1#","lunchConsumption":null,"dinnerConsumption":"1#","beforeSleepConsumption":null,"other":null,"description":null},{"id":2,"medicationRecordId":1,"drugName":"枸橼酸铋钾颗粒","breakfastConsumption":"1#","lunchConsumption":"1#","dinnerConsumption":"1#","beforeSleepConsumption":null,"other":null,"description":null},{"id":3,"medicationRecordId":1,"drugName":"硝苯地平缓释片 10mg","breakfastConsumption":"1#","lunchConsumption":null,"dinnerConsumption":null,"beforeSleepConsumption":null,"other":null,"description":null},{"id":4,"medicationRecordId":1,"drugName":"氟桂利嗪","breakfastConsumption":null,"lunchConsumption":null,"dinnerConsumption":null,"beforeSleepConsumption":"1#","other":null,"description":null}]}]
         * isFirstPage : true
         * isLastPage : true
         */

        private int pageNum;
        private int pageSize;
        private int total;
        private int pages;
        private boolean isFirstPage;
        private boolean isLastPage;
        private List<ListBean> list;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * patientId : 1
             * cureNo : 123466799
             * drugDeliveryNurseId : 2
             * drugDeliveryNurseName : 小护士
             * dateOfHospitalization : 2018-11-02 00:00:00
             * description : null
             * tdrugsDoseVoList : [{"id":5,"medicationRecordId":2,"drugName":"奥美拉唑肠溶颗粒","breakfastConsumption":"1#","lunchConsumption":"1#","dinnerConsumption":null,"beforeSleepConsumption":"1#","other":null,"description":null}]
             */

            private int id;
            private int patientId;
            private String cureNo;
            private int drugDeliveryNurseId;
            private String drugDeliveryNurseName;
            private String dateOfHospitalization;
            private String description;
            private List<TdrugsDoseVoListBean> tdrugsDoseVoList;

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

            public String getCureNo() {
                return cureNo;
            }

            public void setCureNo(String cureNo) {
                this.cureNo = cureNo;
            }

            public int getDrugDeliveryNurseId() {
                return drugDeliveryNurseId;
            }

            public void setDrugDeliveryNurseId(int drugDeliveryNurseId) {
                this.drugDeliveryNurseId = drugDeliveryNurseId;
            }

            public String getDrugDeliveryNurseName() {
                return drugDeliveryNurseName;
            }

            public void setDrugDeliveryNurseName(String drugDeliveryNurseName) {
                this.drugDeliveryNurseName = drugDeliveryNurseName;
            }

            public String getDateOfHospitalization() {
                return dateOfHospitalization;
            }

            public void setDateOfHospitalization(String dateOfHospitalization) {
                this.dateOfHospitalization = dateOfHospitalization;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public List<TdrugsDoseVoListBean> getTdrugsDoseVoList() {
                return tdrugsDoseVoList;
            }

            public void setTdrugsDoseVoList(List<TdrugsDoseVoListBean> tdrugsDoseVoList) {
                this.tdrugsDoseVoList = tdrugsDoseVoList;
            }

            public static class TdrugsDoseVoListBean {
                /**
                 * id : 5
                 * medicationRecordId : 2
                 * drugName : 奥美拉唑肠溶颗粒
                 * breakfastConsumption : 1#
                 * lunchConsumption : 1#
                 * dinnerConsumption : null
                 * beforeSleepConsumption : 1#
                 * other : null
                 * description : null
                 */

                private int id;
                private int medicationRecordId;
                private String drugName;
                private String breakfastConsumption;
                private String lunchConsumption;
                private String dinnerConsumption;
                private String beforeSleepConsumption;
                private String other;
                private String description;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMedicationRecordId() {
                    return medicationRecordId;
                }

                public void setMedicationRecordId(int medicationRecordId) {
                    this.medicationRecordId = medicationRecordId;
                }

                public String getDrugName() {
                    return drugName;
                }

                public void setDrugName(String drugName) {
                    this.drugName = drugName;
                }

                public String getBreakfastConsumption() {
                    return breakfastConsumption;
                }

                public void setBreakfastConsumption(String breakfastConsumption) {
                    this.breakfastConsumption = breakfastConsumption;
                }

                public String getLunchConsumption() {
                    return lunchConsumption;
                }

                public void setLunchConsumption(String lunchConsumption) {
                    this.lunchConsumption = lunchConsumption;
                }

                public String getDinnerConsumption() {
                    return dinnerConsumption;
                }

                public void setDinnerConsumption(String dinnerConsumption) {
                    this.dinnerConsumption = dinnerConsumption;
                }

                public String getBeforeSleepConsumption() {
                    return beforeSleepConsumption;
                }

                public void setBeforeSleepConsumption(String beforeSleepConsumption) {
                    this.beforeSleepConsumption = beforeSleepConsumption;
                }

                public String getOther() {
                    return other;
                }

                public void setOther(String other) {
                    this.other = other;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }
            }
        }
    }
}
