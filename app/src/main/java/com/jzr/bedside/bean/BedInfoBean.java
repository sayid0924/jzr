package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/10.
 */

public class BedInfoBean {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 0
     * timestamp : 2019-04-23T09:30:45.748Z
     * data : {"deviceId":1493,"bedId":1,"bedCode":"L01","bedName":"L01床","bedName2":"L01床","patientId":1,"code":"3000854","cureNo":"098170","name":"刘四媛","sex":1,"sexText":"女","age":"20","inTime":"2018-09-27","diagnose":"诊断测试1","allergy":"过敏测试1","doctorCode":"00262","doctorName":"欧阳善聪","nurseCode":"00133","nurseName":"何苗","nurseLevelCode":"1","nurseLevelName":"Ⅰ级护理","nurseLevelBgColor":"#ae0502","nurseLevelFontColor":"#FFF","careLabelList":[{"id":1,"labelCode":null,"labelName":"防跌倒","bgColor":"#B22222","fontColor":"#FFFFFF"},{"id":2,"labelCode":null,"labelName":"静脉营养","bgColor":"#CD69C9","fontColor":"#FFFFFF"},{"id":3,"labelCode":null,"labelName":"多饮水","bgColor":"#CD6839","fontColor":"#FFFFFF"},{"id":4,"labelCode":null,"labelName":"低钠低脂","bgColor":"#C6E2FF","fontColor":"#FFFFFF"},{"id":5,"labelCode":null,"labelName":"特殊检查","bgColor":"#7171C6","fontColor":"#FFFFFF"},{"id":6,"labelCode":null,"labelName":"卧床","bgColor":"#8B1A1A","fontColor":"#FFFFFF"},{"id":7,"labelCode":null,"labelName":"流质","bgColor":"#CDCD00","fontColor":"#FFFFFF"},{"id":8,"labelCode":null,"labelName":"过敏体质","bgColor":"#708090","fontColor":"#FFFFFF"},{"id":9,"labelCode":"","labelName":"半流质影视","bgColor":"#f0f0f0","fontColor":"#001a9d"}]}
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * deviceId : 1493
         * bedId : 1
         * bedCode : L01
         * bedName : L01床
         * bedName2 : L01床
         * patientId : 1
         * code : 3000854
         * cureNo : 098170
         * name : 刘四媛
         * sex : 1
         * sexText : 女
         * age : 20
         * inTime : 2018-09-27
         * diagnose : 诊断测试1
         * allergy : 过敏测试1
         * doctorCode : 00262
         * doctorName : 欧阳善聪
         * nurseCode : 00133
         * nurseName : 何苗
         * nurseLevelCode : 1
         * nurseLevelName : Ⅰ级护理
         * nurseLevelBgColor : #ae0502
         * nurseLevelFontColor : #FFF
         * careLabelList : [{"id":1,"labelCode":null,"labelName":"防跌倒","bgColor":"#B22222","fontColor":"#FFFFFF"},{"id":2,"labelCode":null,"labelName":"静脉营养","bgColor":"#CD69C9","fontColor":"#FFFFFF"},{"id":3,"labelCode":null,"labelName":"多饮水","bgColor":"#CD6839","fontColor":"#FFFFFF"},{"id":4,"labelCode":null,"labelName":"低钠低脂","bgColor":"#C6E2FF","fontColor":"#FFFFFF"},{"id":5,"labelCode":null,"labelName":"特殊检查","bgColor":"#7171C6","fontColor":"#FFFFFF"},{"id":6,"labelCode":null,"labelName":"卧床","bgColor":"#8B1A1A","fontColor":"#FFFFFF"},{"id":7,"labelCode":null,"labelName":"流质","bgColor":"#CDCD00","fontColor":"#FFFFFF"},{"id":8,"labelCode":null,"labelName":"过敏体质","bgColor":"#708090","fontColor":"#FFFFFF"},{"id":9,"labelCode":"","labelName":"半流质影视","bgColor":"#f0f0f0","fontColor":"#001a9d"}]
         */

        private int deviceId;
        private int bedId;
        private String bedCode;
        private String bedName;
        private String bedName2;
        private int patientId;
        private String code;
        private String cureNo;
        private String name;
        private int sex;
        private String sexText;
        private String age;
        private String inTime;
        private String diagnose;
        private String allergy;
        private String doctorCode;
        private String doctorName;
        private String nurseCode;
        private String nurseName;
        private String nurseLevelCode;
        private String nurseLevelName;
        private String nurseLevelBgColor;
        private String nurseLevelFontColor;
        private List<CareLabelListBean> careLabelList;

        public int getDeviceId() {
            return deviceId;
        }

        public void setDeviceId(int deviceId) {
            this.deviceId = deviceId;
        }

        public int getBedId() {
            return bedId;
        }

        public void setBedId(int bedId) {
            this.bedId = bedId;
        }

        public String getBedCode() {
            return bedCode;
        }

        public void setBedCode(String bedCode) {
            this.bedCode = bedCode;
        }

        public String getBedName() {
            return bedName;
        }

        public void setBedName(String bedName) {
            this.bedName = bedName;
        }

        public String getBedName2() {
            return bedName2;
        }

        public void setBedName2(String bedName2) {
            this.bedName2 = bedName2;
        }

        public int getPatientId() {
            return patientId;
        }

        public void setPatientId(int patientId) {
            this.patientId = patientId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCureNo() {
            return cureNo;
        }

        public void setCureNo(String cureNo) {
            this.cureNo = cureNo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getSexText() {
            return sexText;
        }

        public void setSexText(String sexText) {
            this.sexText = sexText;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getInTime() {
            return inTime;
        }

        public void setInTime(String inTime) {
            this.inTime = inTime;
        }

        public String getDiagnose() {
            return diagnose;
        }

        public void setDiagnose(String diagnose) {
            this.diagnose = diagnose;
        }

        public String getAllergy() {
            return allergy;
        }

        public void setAllergy(String allergy) {
            this.allergy = allergy;
        }

        public String getDoctorCode() {
            return doctorCode;
        }

        public void setDoctorCode(String doctorCode) {
            this.doctorCode = doctorCode;
        }

        public String getDoctorName() {
            return doctorName;
        }

        public void setDoctorName(String doctorName) {
            this.doctorName = doctorName;
        }

        public String getNurseCode() {
            return nurseCode;
        }

        public void setNurseCode(String nurseCode) {
            this.nurseCode = nurseCode;
        }

        public String getNurseName() {
            return nurseName;
        }

        public void setNurseName(String nurseName) {
            this.nurseName = nurseName;
        }

        public String getNurseLevelCode() {
            return nurseLevelCode;
        }

        public void setNurseLevelCode(String nurseLevelCode) {
            this.nurseLevelCode = nurseLevelCode;
        }

        public String getNurseLevelName() {
            return nurseLevelName;
        }

        public void setNurseLevelName(String nurseLevelName) {
            this.nurseLevelName = nurseLevelName;
        }

        public String getNurseLevelBgColor() {
            return nurseLevelBgColor;
        }

        public void setNurseLevelBgColor(String nurseLevelBgColor) {
            this.nurseLevelBgColor = nurseLevelBgColor;
        }

        public String getNurseLevelFontColor() {
            return nurseLevelFontColor;
        }

        public void setNurseLevelFontColor(String nurseLevelFontColor) {
            this.nurseLevelFontColor = nurseLevelFontColor;
        }

        public List<CareLabelListBean> getCareLabelList() {
            return careLabelList;
        }

        public void setCareLabelList(List<CareLabelListBean> careLabelList) {
            this.careLabelList = careLabelList;
        }

        public static class CareLabelListBean {
            /**
             * id : 1
             * labelCode : null
             * labelName : 防跌倒
             * bgColor : #B22222
             * fontColor : #FFFFFF
             */

            private int id;
            private Object labelCode;
            private String labelName;
            private String bgColor;
            private String fontColor;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getLabelCode() {
                return labelCode;
            }

            public void setLabelCode(Object labelCode) {
                this.labelCode = labelCode;
            }

            public String getLabelName() {
                return labelName;
            }

            public void setLabelName(String labelName) {
                this.labelName = labelName;
            }

            public String getBgColor() {
                return bgColor;
            }

            public void setBgColor(String bgColor) {
                this.bgColor = bgColor;
            }

            public String getFontColor() {
                return fontColor;
            }

            public void setFontColor(String fontColor) {
                this.fontColor = fontColor;
            }
        }
    }
}
