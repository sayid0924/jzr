package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/14.
 */

public class DoctorByConditionBean {


    /**
     * code : 0
     * message : 查询数据成功
     * timestamp : {"epochSecond":1542183714,"nano":662000000}
     * data : {"pageNum":1,"pageSize":1,"total":1,"pages":1,"list":[{"id":1,"code":"DO000001","hospitalId":1,"hospitalDeptId":1,"userId":1,"doctorName":"王健林","sex":1,"marriage":1,"birthday":"2018-11-01 00:00:00","pcaCode":1,"address":"1","postCode":"1","mobile":"1","intro":"1","isExpert":true,"specialty":"1","areaCode":"1","education":"1","title":"1","duties":"1","orgCode":"1","idType":1,"idNumber":"1","certificateNo":"1","idUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542020930370&di=9283e64f9bb03e7b3a540499688d5288&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161206%2Fb1ab407e1d75468d9e8e836ab62c75c9_th.jpeg","certificateUrl":"1","imageUrl":"1","openId":"1","height":1,"weight":1,"bpm":"1","guoHaoMoney":1,"description":"1","tdeptVo":null}],"isFirstPage":true,"isLastPage":true}
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
         * epochSecond : 1542183714
         * nano : 662000000
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
         * pageSize : 1
         * total : 1
         * pages : 1
         * list : [{"id":1,"code":"DO000001","hospitalId":1,"hospitalDeptId":1,"userId":1,"doctorName":"王健林","sex":1,"marriage":1,"birthday":"2018-11-01 00:00:00","pcaCode":1,"address":"1","postCode":"1","mobile":"1","intro":"1","isExpert":true,"specialty":"1","areaCode":"1","education":"1","title":"1","duties":"1","orgCode":"1","idType":1,"idNumber":"1","certificateNo":"1","idUrl":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542020930370&di=9283e64f9bb03e7b3a540499688d5288&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161206%2Fb1ab407e1d75468d9e8e836ab62c75c9_th.jpeg","certificateUrl":"1","imageUrl":"1","openId":"1","height":1,"weight":1,"bpm":"1","guoHaoMoney":1,"description":"1","tdeptVo":null}]
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
             * id : 1
             * code : DO000001
             * hospitalId : 1
             * hospitalDeptId : 1
             * userId : 1
             * doctorName : 王健林
             * sex : 1
             * marriage : 1
             * birthday : 2018-11-01 00:00:00
             * pcaCode : 1
             * address : 1
             * postCode : 1
             * mobile : 1
             * intro : 1
             * isExpert : true
             * specialty : 1
             * areaCode : 1
             * education : 1
             * title : 1
             * duties : 1
             * orgCode : 1
             * idType : 1
             * idNumber : 1
             * certificateNo : 1
             * idUrl : https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1542020930370&di=9283e64f9bb03e7b3a540499688d5288&imgtype=0&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20161206%2Fb1ab407e1d75468d9e8e836ab62c75c9_th.jpeg
             * certificateUrl : 1
             * imageUrl : 1
             * openId : 1
             * height : 1
             * weight : 1
             * bpm : 1
             * guoHaoMoney : 1
             * description : 1
             * tdeptVo : null
             */

            private int id;
            private String code;
            private int hospitalId;
            private int hospitalDeptId;
            private int userId;
            private String doctorName;
            private int sex;
            private int marriage;
            private String birthday;
            private int pcaCode;
            private String address;
            private String postCode;
            private String mobile;
            private String intro;
            private boolean isExpert;
            private String specialty;
            private String areaCode;
            private String education;
            private String title;
            private String duties;
            private String orgCode;
            private int idType;
            private String idNumber;
            private String certificateNo;
            private String idUrl;
            private String certificateUrl;
            private String imageUrl;
            private String openId;
            private int height;
            private int weight;
            private String bpm;
            private int guoHaoMoney;
            private String description;
            private Object tdeptVo;

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

            public String getDoctorName() {
                return doctorName;
            }

            public void setDoctorName(String doctorName) {
                this.doctorName = doctorName;
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

            public boolean isIsExpert() {
                return isExpert;
            }

            public void setIsExpert(boolean isExpert) {
                this.isExpert = isExpert;
            }

            public String getSpecialty() {
                return specialty;
            }

            public void setSpecialty(String specialty) {
                this.specialty = specialty;
            }

            public String getAreaCode() {
                return areaCode;
            }

            public void setAreaCode(String areaCode) {
                this.areaCode = areaCode;
            }

            public String getEducation() {
                return education;
            }

            public void setEducation(String education) {
                this.education = education;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDuties() {
                return duties;
            }

            public void setDuties(String duties) {
                this.duties = duties;
            }

            public String getOrgCode() {
                return orgCode;
            }

            public void setOrgCode(String orgCode) {
                this.orgCode = orgCode;
            }

            public int getIdType() {
                return idType;
            }

            public void setIdType(int idType) {
                this.idType = idType;
            }

            public String getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
            }

            public String getCertificateNo() {
                return certificateNo;
            }

            public void setCertificateNo(String certificateNo) {
                this.certificateNo = certificateNo;
            }

            public String getIdUrl() {
                return idUrl;
            }

            public void setIdUrl(String idUrl) {
                this.idUrl = idUrl;
            }

            public String getCertificateUrl() {
                return certificateUrl;
            }

            public void setCertificateUrl(String certificateUrl) {
                this.certificateUrl = certificateUrl;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getOpenId() {
                return openId;
            }

            public void setOpenId(String openId) {
                this.openId = openId;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWeight() {
                return weight;
            }

            public void setWeight(int weight) {
                this.weight = weight;
            }

            public String getBpm() {
                return bpm;
            }

            public void setBpm(String bpm) {
                this.bpm = bpm;
            }

            public int getGuoHaoMoney() {
                return guoHaoMoney;
            }

            public void setGuoHaoMoney(int guoHaoMoney) {
                this.guoHaoMoney = guoHaoMoney;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public Object getTdeptVo() {
                return tdeptVo;
            }

            public void setTdeptVo(Object tdeptVo) {
                this.tdeptVo = tdeptVo;
            }
        }
    }
}
