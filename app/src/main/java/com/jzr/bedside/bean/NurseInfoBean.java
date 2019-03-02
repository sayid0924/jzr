package com.jzr.bedside.bean;

/**
 * Created by Bben on 2018/11/14.
 */

public class NurseInfoBean {


    /**
     * code : 0
     * message : 查询参数成功
     * timestamp : {"epochSecond":1542163346,"nano":698000000}
     * data : {"id":1,"code":"1","hospitalId":1,"hospitalDeptId":1,"userId":1,"name":"护士梅厄米","sex":1,"marriage":1,"birthday":"2018-11-12 00:00:00","pcaCode":1,"address":"1","postCode":"1","mobile":"11","intro":"11","specialty":null,"areaCode":null,"education":null,"title":null,"duties":null,"idType":null,"idNumber":null,"idUrl":"https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=f91f202c5b6034a83defb0d3aa7a2231/cefc1e178a82b9012aaa6a1e748da9773912ef9c.jpg","height":null,"weight":null,"description":null,"tdeptVo":{"id":1,"name":"第一科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商"}}
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
         * epochSecond : 1542163346
         * nano : 698000000
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
         * code : 1
         * hospitalId : 1
         * hospitalDeptId : 1
         * userId : 1
         * name : 护士梅厄米
         * sex : 1
         * marriage : 1
         * birthday : 2018-11-12 00:00:00
         * pcaCode : 1
         * address : 1
         * postCode : 1
         * mobile : 11
         * intro : 11
         * specialty : null
         * areaCode : null
         * education : null
         * title : null
         * duties : null
         * idType : null
         * idNumber : null
         * idUrl : https://gss0.bdstatic.com/94o3dSag_xI4khGkpoWK1HF6hhy/baike/c0%3Dbaike92%2C5%2C5%2C92%2C30/sign=f91f202c5b6034a83defb0d3aa7a2231/cefc1e178a82b9012aaa6a1e748da9773912ef9c.jpg
         * height : null
         * weight : null
         * description : null
         * tdeptVo : {"id":1,"name":"第一科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商"}
         */

        private int id;
        private String code;
        private int hospitalId;
        private int hospitalDeptId;
        private int userId;
        private String name;
        private int sex;
        private int marriage;
        private String birthday;
        private int pcaCode;
        private String address;
        private String postCode;
        private String mobile;
        private String intro;
        private String specialty;
        private Object areaCode;
        private Object education;
        private String title;
        private Object duties;
        private Object idType;
        private Object idNumber;
        private String idUrl;
        private Object height;
        private Object weight;
        private Object description;
        private TdeptVoBean tdeptVo;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getHospitalId() {
            return hospitalId;
        }

        public void setHospitalId(int hospitalId) {
            this.hospitalId = hospitalId;
        }

        public int getHospitalDeptId() {
            return hospitalDeptId;
        }

        public void setHospitalDeptId(int hospitalDeptId) {
            this.hospitalDeptId = hospitalDeptId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public int getMarriage() {
            return marriage;
        }

        public void setMarriage(int marriage) {
            this.marriage = marriage;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public int getPcaCode() {
            return pcaCode;
        }

        public void setPcaCode(int pcaCode) {
            this.pcaCode = pcaCode;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public Object getAreaCode() {
            return areaCode;
        }

        public void setAreaCode(Object areaCode) {
            this.areaCode = areaCode;
        }

        public Object getEducation() {
            return education;
        }

        public void setEducation(Object education) {
            this.education = education;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getDuties() {
            return duties;
        }

        public void setDuties(Object duties) {
            this.duties = duties;
        }

        public Object getIdType() {
            return idType;
        }

        public void setIdType(Object idType) {
            this.idType = idType;
        }

        public Object getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(Object idNumber) {
            this.idNumber = idNumber;
        }

        public String getIdUrl() {
            return idUrl;
        }

        public void setIdUrl(String idUrl) {
            this.idUrl = idUrl;
        }

        public Object getHeight() {
            return height;
        }

        public void setHeight(Object height) {
            this.height = height;
        }

        public Object getWeight() {
            return weight;
        }

        public void setWeight(Object weight) {
            this.weight = weight;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public TdeptVoBean getTdeptVo() {
            return tdeptVo;
        }

        public void setTdeptVo(TdeptVoBean tdeptVo) {
            this.tdeptVo = tdeptVo;
        }

        public static class TdeptVoBean {
            /**
             * id : 1
             * name : 第一科室
             * intro : 公司专注于医疗信息化产品的研发与生产，秉持“科技服务医疗”的宗旨和“以人为本，五心服务”的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商
             * description : 公司专注于医疗信息化产品的研发与生产，秉持“科技服务医疗”的宗旨和“以人为本，五心服务”的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商
             */

            private int id;
            private String name;
            private String intro;
            private String description;

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

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
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
