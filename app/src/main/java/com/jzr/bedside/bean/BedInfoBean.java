package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/10.
 */

public class BedInfoBean {
    /**
     * code : 0
     * message : 查询床位信息成功
     * timestamp : {"epochSecond":1548844037,"nano":608000000}
     * data : {"id":34,"bedCardId":34,"sickroomId":1,"bedType":"0","bedNum":"34","useStatus":1,"description":null,"tpatientVo":{"id":34,"code":"P-COE-35","name":"测试人26","hospitalId":"1","districtId":"1","deptId":"1","wardId":"1","sickroomNo":"12","cureNo":"CURE-NO-35","bedNo":"34","nurseLevel":"1","sex":1,"marriage":1,"birthday":"2018-11-09","pcaCode":1,"address":"深圳市南山区东方科技大厦","mobile":"18214589835","idType":1,"idNumber":"425874589658745835","height":162,"weight":49.5,"admissionTime":null,"tcareLableVoList":[{"id":1,"lableName":"防跌倒","viewColor":"#B22222","detailContent":null,"status":1,"description":null},{"id":2,"lableName":"静脉营养","viewColor":"#CD69C9","detailContent":null,"status":1,"description":null},{"id":3,"lableName":"多饮水","viewColor":"#CD6839","detailContent":null,"status":1,"description":null},{"id":4,"lableName":"低钠低脂","viewColor":"#C6E2FF","detailContent":null,"status":1,"description":null},{"id":5,"lableName":"特殊检查","viewColor":"#7171C6","detailContent":null,"status":1,"description":null}],"tnurseBrieflyVoList":[{"id":4,"name":"徐丽","sex":2}],"tdoctorBrieflyVoList":[{"id":17,"doctorName":"崔洪涛","sex":2}],"tallergyTypeVoList":null},"tsickroomVo":{"id":1,"sickroomName":"病房1","wardId":1,"bedCount":2,"position":"东南角1","dutyDoctor":"艾小强","dutyNurse":"钱星星","description":null},"twardVo":{"id":1,"name":"妇科病区","position":"深圳市坪山区萨米医疗中心5楼","dutyBy":"赵立奇","hisId":"1","description":"历史发展"}}
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
         * epochSecond : 1548844037
         * nano : 608000000
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
         * id : 34
         * bedCardId : 34
         * sickroomId : 1
         * bedType : 0
         * bedNum : 34
         * useStatus : 1
         * description : null
         * tpatientVo : {"id":34,"code":"P-COE-35","name":"测试人26","hospitalId":"1","districtId":"1","deptId":"1","wardId":"1","sickroomNo":"12","cureNo":"CURE-NO-35","bedNo":"34","nurseLevel":"1","sex":1,"marriage":1,"birthday":"2018-11-09","pcaCode":1,"address":"深圳市南山区东方科技大厦","mobile":"18214589835","idType":1,"idNumber":"425874589658745835","height":162,"weight":49.5,"admissionTime":null,"tcareLableVoList":[{"id":1,"lableName":"防跌倒","viewColor":"#B22222","detailContent":null,"status":1,"description":null},{"id":2,"lableName":"静脉营养","viewColor":"#CD69C9","detailContent":null,"status":1,"description":null},{"id":3,"lableName":"多饮水","viewColor":"#CD6839","detailContent":null,"status":1,"description":null},{"id":4,"lableName":"低钠低脂","viewColor":"#C6E2FF","detailContent":null,"status":1,"description":null},{"id":5,"lableName":"特殊检查","viewColor":"#7171C6","detailContent":null,"status":1,"description":null}],"tnurseBrieflyVoList":[{"id":4,"name":"徐丽","sex":2}],"tdoctorBrieflyVoList":[{"id":17,"doctorName":"崔洪涛","sex":2}],"tallergyTypeVoList":null}
         * tsickroomVo : {"id":1,"sickroomName":"病房1","wardId":1,"bedCount":2,"position":"东南角1","dutyDoctor":"艾小强","dutyNurse":"钱星星","description":null}
         * twardVo : {"id":1,"name":"妇科病区","position":"深圳市坪山区萨米医疗中心5楼","dutyBy":"赵立奇","hisId":"1","description":"历史发展"}
         */

        private int id;
        private int bedCardId;
        private int sickroomId;
        private String bedType;
        private String bedNum;
        private int useStatus;
        private Object description;
        private TpatientVoBean tpatientVo;
        private TsickroomVoBean tsickroomVo;
        private TwardVoBean twardVo;
        private TnurseBrieflyVoListBean tnurseBrieflyVoList;

        public TnurseBrieflyVoListBean getTnurseBrieflyVoList() {
            return tnurseBrieflyVoList;
        }

        public void setTnurseBrieflyVoList(TnurseBrieflyVoListBean tnurseBrieflyVoList) {
            this.tnurseBrieflyVoList = tnurseBrieflyVoList;
        }

        public  class  TnurseBrieflyVoListBean{

            int id ;
            String name;
            int sex;

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

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getBedCardId() {
            return bedCardId;
        }

        public void setBedCardId(int bedCardId) {
            this.bedCardId = bedCardId;
        }

        public int getSickroomId() {
            return sickroomId;
        }

        public void setSickroomId(int sickroomId) {
            this.sickroomId = sickroomId;
        }

        public String getBedType() {
            return bedType;
        }

        public void setBedType(String bedType) {
            this.bedType = bedType;
        }

        public String getBedNum() {
            return bedNum;
        }

        public void setBedNum(String bedNum) {
            this.bedNum = bedNum;
        }

        public int getUseStatus() {
            return useStatus;
        }

        public void setUseStatus(int useStatus) {
            this.useStatus = useStatus;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public TpatientVoBean getTpatientVo() {
            return tpatientVo;
        }

        public void setTpatientVo(TpatientVoBean tpatientVo) {
            this.tpatientVo = tpatientVo;
        }

        public TsickroomVoBean getTsickroomVo() {
            return tsickroomVo;
        }

        public void setTsickroomVo(TsickroomVoBean tsickroomVo) {
            this.tsickroomVo = tsickroomVo;
        }

        public TwardVoBean getTwardVo() {
            return twardVo;
        }

        public void setTwardVo(TwardVoBean twardVo) {
            this.twardVo = twardVo;
        }

        public static class TpatientVoBean {
            /**
             * id : 34
             * code : P-COE-35
             * name : 测试人26
             * hospitalId : 1
             * districtId : 1
             * deptId : 1
             * wardId : 1
             * sickroomNo : 12
             * cureNo : CURE-NO-35
             * bedNo : 34
             * nurseLevel : 1
             * sex : 1
             * marriage : 1
             * birthday : 2018-11-09
             * pcaCode : 1
             * address : 深圳市南山区东方科技大厦
             * mobile : 18214589835
             * idType : 1
             * idNumber : 425874589658745835
             * height : 162
             * weight : 49.5
             * admissionTime : null
             * tcareLableVoList : [{"id":1,"lableName":"防跌倒","viewColor":"#B22222","detailContent":null,"status":1,"description":null},{"id":2,"lableName":"静脉营养","viewColor":"#CD69C9","detailContent":null,"status":1,"description":null},{"id":3,"lableName":"多饮水","viewColor":"#CD6839","detailContent":null,"status":1,"description":null},{"id":4,"lableName":"低钠低脂","viewColor":"#C6E2FF","detailContent":null,"status":1,"description":null},{"id":5,"lableName":"特殊检查","viewColor":"#7171C6","detailContent":null,"status":1,"description":null}]
             * tnurseBrieflyVoList : [{"id":4,"name":"徐丽","sex":2}]
             * tdoctorBrieflyVoList : [{"id":17,"doctorName":"崔洪涛","sex":2}]
             * tallergyTypeVoList : null
             */

            private int id;
            private String code;
            private String name;
            private String hospitalId;
            private String districtId;
            private String deptId;
            private String wardId;
            private String sickroomNo;
            private String cureNo;
            private String bedNo;
            private String nurseLevel;
            private int sex;
            private int marriage;
            private String birthday;
            private int pcaCode;
            private String address;
            private String mobile;
            private int idType;
            private String idNumber;
            private int height;
            private double weight;
            private String admissionTime;
            private Object tallergyTypeVoList;
            private List<TcareLableVoListBean> tcareLableVoList;
            private List<TnurseBrieflyVoListBean> tnurseBrieflyVoList;
            private List<TdoctorBrieflyVoListBean> tdoctorBrieflyVoList;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHospitalId() {
                return hospitalId;
            }

            public void setHospitalId(String hospitalId) {
                this.hospitalId = hospitalId;
            }

            public String getDistrictId() {
                return districtId;
            }

            public void setDistrictId(String districtId) {
                this.districtId = districtId;
            }

            public String getDeptId() {
                return deptId;
            }

            public void setDeptId(String deptId) {
                this.deptId = deptId;
            }

            public String getWardId() {
                return wardId;
            }

            public void setWardId(String wardId) {
                this.wardId = wardId;
            }

            public String getSickroomNo() {
                return sickroomNo;
            }

            public void setSickroomNo(String sickroomNo) {
                this.sickroomNo = sickroomNo;
            }

            public String getCureNo() {
                return cureNo;
            }

            public void setCureNo(String cureNo) {
                this.cureNo = cureNo;
            }

            public String getBedNo() {
                return bedNo;
            }

            public void setBedNo(String bedNo) {
                this.bedNo = bedNo;
            }

            public String getNurseLevel() {
                return nurseLevel;
            }

            public void setNurseLevel(String nurseLevel) {
                this.nurseLevel = nurseLevel;
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

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
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

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public double getWeight() {
                return weight;
            }

            public void setWeight(double weight) {
                this.weight = weight;
            }

            public String getAdmissionTime() {
                return admissionTime;
            }

            public void setAdmissionTime(String admissionTime) {
                this.admissionTime = admissionTime;
            }

            public Object getTallergyTypeVoList() {
                return tallergyTypeVoList;
            }

            public void setTallergyTypeVoList(Object tallergyTypeVoList) {
                this.tallergyTypeVoList = tallergyTypeVoList;
            }

            public List<TcareLableVoListBean> getTcareLableVoList() {
                return tcareLableVoList;
            }

            public void setTcareLableVoList(List<TcareLableVoListBean> tcareLableVoList) {
                this.tcareLableVoList = tcareLableVoList;
            }

            public List<TnurseBrieflyVoListBean> getTnurseBrieflyVoList() {
                return tnurseBrieflyVoList;
            }

            public void setTnurseBrieflyVoList(List<TnurseBrieflyVoListBean> tnurseBrieflyVoList) {
                this.tnurseBrieflyVoList = tnurseBrieflyVoList;
            }

            public List<TdoctorBrieflyVoListBean> getTdoctorBrieflyVoList() {
                return tdoctorBrieflyVoList;
            }

            public void setTdoctorBrieflyVoList(List<TdoctorBrieflyVoListBean> tdoctorBrieflyVoList) {
                this.tdoctorBrieflyVoList = tdoctorBrieflyVoList;
            }

            public static class TcareLableVoListBean {

                public TcareLableVoListBean(int id, String lableName, String viewColor, Object detailContent, int status, Object description) {
                    this.id = id;
                    this.lableName = lableName;
                    this.viewColor = viewColor;
                    this.detailContent = detailContent;
                    this.status = status;
                    this.description = description;
                }

                /**
                 * id : 1
                 * lableName : 防跌倒
                 * viewColor : #B22222
                 * detailContent : null
                 * status : 1
                 * description : null
                 */

                private int id;
                private String lableName;
                private String viewColor;
                private Object detailContent;
                private int status;
                private Object description;

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

                public Object getDetailContent() {
                    return detailContent;
                }

                public void setDetailContent(Object detailContent) {
                    this.detailContent = detailContent;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }
            }

            public static class TnurseBrieflyVoListBean {
                public TnurseBrieflyVoListBean(int id, String name, int sex) {
                    this.id = id;
                    this.name = name;
                    this.sex = sex;
                }

                /**
                 * id : 4
                 * name : 徐丽
                 * sex : 2
                 */



                private int id;
                private String name;
                private int sex;

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

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }
            }

            public static class TdoctorBrieflyVoListBean {
                public TdoctorBrieflyVoListBean(int id, String doctorName, int sex) {
                    this.id = id;
                    this.doctorName = doctorName;
                    this.sex = sex;
                }

                /**
                 * id : 17
                 * doctorName : 崔洪涛
                 * sex : 2
                 */




                private int id;
                private String doctorName;
                private int sex;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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
            }
        }

        public static class TsickroomVoBean {
            /**
             * id : 1
             * sickroomName : 病房1
             * wardId : 1
             * bedCount : 2
             * position : 东南角1
             * dutyDoctor : 艾小强
             * dutyNurse : 钱星星
             * description : null
             */

            private int id;
            private String sickroomName;
            private int wardId;
            private int bedCount;
            private String position;
            private String dutyDoctor;
            private String dutyNurse;
            private Object description;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSickroomName() {
                return sickroomName;
            }

            public void setSickroomName(String sickroomName) {
                this.sickroomName = sickroomName;
            }

            public int getWardId() {
                return wardId;
            }

            public void setWardId(int wardId) {
                this.wardId = wardId;
            }

            public int getBedCount() {
                return bedCount;
            }

            public void setBedCount(int bedCount) {
                this.bedCount = bedCount;
            }

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getDutyDoctor() {
                return dutyDoctor;
            }

            public void setDutyDoctor(String dutyDoctor) {
                this.dutyDoctor = dutyDoctor;
            }

            public String getDutyNurse() {
                return dutyNurse;
            }

            public void setDutyNurse(String dutyNurse) {
                this.dutyNurse = dutyNurse;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }
        }

        public static class TwardVoBean {
            /**
             * id : 1
             * name : 妇科病区
             * position : 深圳市坪山区萨米医疗中心5楼
             * dutyBy : 赵立奇
             * hisId : 1
             * description : 历史发展
             */

            private int id;
            private String name;
            private String position;
            private String dutyBy;
            private String hisId;
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

            public String getPosition() {
                return position;
            }

            public void setPosition(String position) {
                this.position = position;
            }

            public String getDutyBy() {
                return dutyBy;
            }

            public void setDutyBy(String dutyBy) {
                this.dutyBy = dutyBy;
            }

            public String getHisId() {
                return hisId;
            }

            public void setHisId(String hisId) {
                this.hisId = hisId;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }

//
//    /**
//     * code : 0
//     * message : 查询床位信息成功
//     * timestamp : {"nano":989000000,"epochSecond":1548027170}
//     * data : {"id":1,"bedCardId":13,"sickroomId":1,"bedType":null,"bedNum":null,"useStatus":null,"description":null,"tsickroomVo":{"id":1,"sickroomName":"A506房","wardId":1,"bedCount":3,"position":null,"dutyDoctor":"熊琪","dutyNurse":"余婵","description":null},"tpatientVo":{"id":85,"code":"0000000001","name":"李","hospitalId":"1","districtId":"1","deptId":"1521","wardId":"1","sickroomNo":"1","cureNo":"CURE-NO-1","bedNo":"01","nurseLevel":"1","sex":0,"marriage":1,"birthday":"1993-01-08","pcaCode":null,"address":"","mobile":null,"idType":1,"idNumber":"","height":null,"weight":null,"admissionTime":"2018-12-25 02:16:00","tnurseBrieflyVoList":[{"id":98,"name":"余婵","sex":0}],"tallergyTypeVoList":null,"tcareLableVoList":[{"id":12,"lableName":"按内科一般常规护理","viewColor":null,"detailContent":null,"status":1,"description":null}],"tdoctorBrieflyVoList":[{"id":253,"doctorName":"熊琪","sex":0}]},"twardVo":{"id":1,"name":"外科病区","position":"深圳市坪山新区金牛路萨米国际医疗中心五楼","dutyBy":"","hisId":null,"description":null}}
//     */
//
//    private int code;
//    private String message;
//    private TimestampBean timestamp;
//    private DataBean data;
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public TimestampBean getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(TimestampBean timestamp) {
//        this.timestamp = timestamp;
//    }
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public static class TimestampBean {
//        /**
//         * nano : 989000000
//         * epochSecond : 1548027170
//         */
//
//        private int nano;
//        private int epochSecond;
//
//        public int getNano() {
//            return nano;
//        }
//
//        public void setNano(int nano) {
//            this.nano = nano;
//        }
//
//        public int getEpochSecond() {
//            return epochSecond;
//        }
//
//        public void setEpochSecond(int epochSecond) {
//            this.epochSecond = epochSecond;
//        }
//    }
//
//    public static class DataBean {
//        /**
//         * id : 1
//         * bedCardId : 13
//         * sickroomId : 1
//         * bedType : null
//         * bedNum : null
//         * useStatus : null
//         * description : null
//         * tsickroomVo : {"id":1,"sickroomName":"A506房","wardId":1,"bedCount":3,"position":null,"dutyDoctor":"熊琪","dutyNurse":"余婵","description":null}
//         * tpatientVo : {"id":85,"code":"0000000001","name":"李","hospitalId":"1","districtId":"1","deptId":"1521","wardId":"1","sickroomNo":"1","cureNo":"CURE-NO-1","bedNo":"01","nurseLevel":"1","sex":0,"marriage":1,"birthday":"1993-01-08","pcaCode":null,"address":"","mobile":null,"idType":1,"idNumber":"","height":null,"weight":null,"admissionTime":"2018-12-25 02:16:00","tnurseBrieflyVoList":[{"id":98,"name":"余婵","sex":0}],"tallergyTypeVoList":null,"tcareLableVoList":[{"id":12,"lableName":"按内科一般常规护理","viewColor":null,"detailContent":null,"status":1,"description":null}],"tdoctorBrieflyVoList":[{"id":253,"doctorName":"熊琪","sex":0}]}
//         * twardVo : {"id":1,"name":"外科病区","position":"深圳市坪山新区金牛路萨米国际医疗中心五楼","dutyBy":"","hisId":null,"description":null}
//         */
//
//        private int id;
//        private int bedCardId;
//        private int sickroomId;
//        private Object bedType;
//        private String bedNum;
//        private Object useStatus;
//        private Object description;
//        private TsickroomVoBean TsickroomVo;
//        private TpatientVoBean TpatientVo;
//        private TwardVoBean TwardVo;
//        private TpatientVoBean.TnurseBrieflyVoListBean TnurseBrieflyVoList;
//        private TpatientVoBean.TdoctorBrieflyVoListBean TdoctorBrieflyVoList;
//
//        public TpatientVoBean.TdoctorBrieflyVoListBean getTdoctorBrieflyVoList() {
//            return TdoctorBrieflyVoList;
//        }
//
//        public void setTdoctorBrieflyVoList(TpatientVoBean.TdoctorBrieflyVoListBean tdoctorBrieflyVoList) {
//            TdoctorBrieflyVoList = tdoctorBrieflyVoList;
//        }
//
//        public TpatientVoBean.TnurseBrieflyVoListBean getTnurseBrieflyVoList() {
//            return TnurseBrieflyVoList;
//        }
//
//        public void setTnurseBrieflyVoList(TpatientVoBean.TnurseBrieflyVoListBean tnurseBrieflyVoList) {
//            this.TnurseBrieflyVoList = tnurseBrieflyVoList;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public int getBedCardId() {
//            return bedCardId;
//        }
//
//        public void setBedCardId(int bedCardId) {
//            this.bedCardId = bedCardId;
//        }
//
//        public int getSickroomId() {
//            return sickroomId;
//        }
//
//        public void setSickroomId(int sickroomId) {
//            this.sickroomId = sickroomId;
//        }
//
//        public Object getBedType() {
//            return bedType;
//        }
//
//        public void setBedType(Object bedType) {
//            this.bedType = bedType;
//        }
//
//        public String getBedNum() {
//            return bedNum;
//        }
//
//        public void setBedNum(String bedNum) {
//            this.bedNum = bedNum;
//        }
//
//        public Object getUseStatus() {
//            return useStatus;
//        }
//
//        public void setUseStatus(Object useStatus) {
//            this.useStatus = useStatus;
//        }
//
//        public Object getDescription() {
//            return description;
//        }
//
//        public void setDescription(Object description) {
//            this.description = description;
//        }
//
//        public TsickroomVoBean getTsickroomVo() {
//            return TsickroomVo;
//        }
//
//        public void setTsickroomVo(TsickroomVoBean tsickroomVo) {
//            this.TsickroomVo = tsickroomVo;
//        }
//
//        public TpatientVoBean getTpatientVo() {
//            return TpatientVo;
//        }
//
//        public void setTpatientVo(TpatientVoBean TpatientVo) {
//            this.TpatientVo = TpatientVo;
//        }
//
//        public TwardVoBean getTwardVo() {
//            return TwardVo;
//        }
//
//        public void setTwardVo(TwardVoBean twardVo) {
//            this.TwardVo = twardVo;
//        }
//
//        public static class TsickroomVoBean {
//            /**
//             * id : 1
//             * sickroomName : A506房
//             * wardId : 1
//             * bedCount : 3
//             * position : null
//             * dutyDoctor : 熊琪
//             * dutyNurse : 余婵
//             * description : null
//             */
//
//            private int id;
//            private String sickroomName;
//            private int wardId;
//            private int bedCount;
//            private Object position;
//            private String dutyDoctor;
//            private String dutyNurse;
//            private Object description;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getSickroomName() {
//                return sickroomName;
//            }
//
//            public void setSickroomName(String sickroomName) {
//                this.sickroomName = sickroomName;
//            }
//
//            public int getWardId() {
//                return wardId;
//            }
//
//            public void setWardId(int wardId) {
//                this.wardId = wardId;
//            }
//
//            public int getBedCount() {
//                return bedCount;
//            }
//
//            public void setBedCount(int bedCount) {
//                this.bedCount = bedCount;
//            }
//
//            public Object getPosition() {
//                return position;
//            }
//
//            public void setPosition(Object position) {
//                this.position = position;
//            }
//
//            public String getDutyDoctor() {
//                return dutyDoctor;
//            }
//
//            public void setDutyDoctor(String dutyDoctor) {
//                this.dutyDoctor = dutyDoctor;
//            }
//
//            public String getDutyNurse() {
//                return dutyNurse;
//            }
//
//            public void setDutyNurse(String dutyNurse) {
//                this.dutyNurse = dutyNurse;
//            }
//
//            public Object getDescription() {
//                return description;
//            }
//
//            public void setDescription(Object description) {
//                this.description = description;
//            }
//        }
//
//        public static class TpatientVoBean {
//            /**
//             * id : 85
//             * code : 0000000001
//             * name : 李
//             * hospitalId : 1
//             * districtId : 1
//             * deptId : 1521
//             * wardId : 1
//             * sickroomNo : 1
//             * cureNo : CURE-NO-1
//             * bedNo : 01
//             * nurseLevel : 1
//             * sex : 0
//             * marriage : 1
//             * birthday : 1993-01-08
//             * pcaCode : null
//             * address :
//             * mobile : null
//             * idType : 1
//             * idNumber :
//             * height : null
//             * weight : null
//             * admissionTime : 2018-12-25 02:16:00
//             * tnurseBrieflyVoList : [{"id":98,"name":"余婵","sex":0}]
//             * tallergyTypeVoList : null
//             * tcareLableVoList : [{"id":12,"lableName":"按内科一般常规护理","viewColor":null,"detailContent":null,"status":1,"description":null}]
//             * tdoctorBrieflyVoList : [{"id":253,"doctorName":"熊琪","sex":0}]
//             */
//
//            private int id;
//            private String code;
//            private String name;
//            private String hospitalId;
//            private String districtId;
//            private String deptId;
//            private String wardId;
//            private String sickroomNo;
//            private String cureNo;
//            private String bedNo;
//            private String nurseLevel;
//            private int sex;
//            private int marriage;
//            private String birthday;
//            private Object pcaCode;
//            private String address;
//            private Object mobile;
//            private int idType;
//            private String idNumber;
//            private Object height;
//            private Object weight;
//            private String admissionTime;
//            private Object tallergyTypeVoList;
//            private List<TnurseBrieflyVoListBean> tnurseBrieflyVoList;
//            private List<TcareLableVoListBean> tcareLableVoList;
//            private List<TdoctorBrieflyVoListBean> tdoctorBrieflyVoList;
//            private  String age;
//
//            public String getAge() {
//                return age;
//            }
//
//            public void setAge(String age) {
//                this.age = age;
//            }
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getCode() {
//                return code;
//            }
//
//            public void setCode(String code) {
//                this.code = code;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getHospitalId() {
//                return hospitalId;
//            }
//
//            public void setHospitalId(String hospitalId) {
//                this.hospitalId = hospitalId;
//            }
//
//            public String getDistrictId() {
//                return districtId;
//            }
//
//            public void setDistrictId(String districtId) {
//                this.districtId = districtId;
//            }
//
//            public String getDeptId() {
//                return deptId;
//            }
//
//            public void setDeptId(String deptId) {
//                this.deptId = deptId;
//            }
//
//            public String getWardId() {
//                return wardId;
//            }
//
//            public void setWardId(String wardId) {
//                this.wardId = wardId;
//            }
//
//            public String getSickroomNo() {
//                return sickroomNo;
//            }
//
//            public void setSickroomNo(String sickroomNo) {
//                this.sickroomNo = sickroomNo;
//            }
//
//            public String getCureNo() {
//                return cureNo;
//            }
//
//            public void setCureNo(String cureNo) {
//                this.cureNo = cureNo;
//            }
//
//            public String getBedNo() {
//                return bedNo;
//            }
//
//            public void setBedNo(String bedNo) {
//                this.bedNo = bedNo;
//            }
//
//            public String getNurseLevel() {
//                return nurseLevel;
//            }
//
//            public void setNurseLevel(String nurseLevel) {
//                this.nurseLevel = nurseLevel;
//            }
//
//            public int getSex() {
//                return sex;
//            }
//
//            public void setSex(int sex) {
//                this.sex = sex;
//            }
//
//            public int getMarriage() {
//                return marriage;
//            }
//
//            public void setMarriage(int marriage) {
//                this.marriage = marriage;
//            }
//
//            public String getBirthday() {
//                return birthday;
//            }
//
//            public void setBirthday(String birthday) {
//                this.birthday = birthday;
//            }
//
//            public Object getPcaCode() {
//                return pcaCode;
//            }
//
//            public void setPcaCode(Object pcaCode) {
//                this.pcaCode = pcaCode;
//            }
//
//            public String getAddress() {
//                return address;
//            }
//
//            public void setAddress(String address) {
//                this.address = address;
//            }
//
//            public Object getMobile() {
//                return mobile;
//            }
//
//            public void setMobile(Object mobile) {
//                this.mobile = mobile;
//            }
//
//            public int getIdType() {
//                return idType;
//            }
//
//            public void setIdType(int idType) {
//                this.idType = idType;
//            }
//
//            public String getIdNumber() {
//                return idNumber;
//            }
//
//            public void setIdNumber(String idNumber) {
//                this.idNumber = idNumber;
//            }
//
//            public Object getHeight() {
//                return height;
//            }
//
//            public void setHeight(Object height) {
//                this.height = height;
//            }
//
//            public Object getWeight() {
//                return weight;
//            }
//
//            public void setWeight(Object weight) {
//                this.weight = weight;
//            }
//
//            public String getAdmissionTime() {
//                return admissionTime;
//            }
//
//            public void setAdmissionTime(String admissionTime) {
//                this.admissionTime = admissionTime;
//            }
//
//            public Object getTallergyTypeVoList() {
//                return tallergyTypeVoList;
//            }
//
//            public void setTallergyTypeVoList(Object tallergyTypeVoList) {
//                this.tallergyTypeVoList = tallergyTypeVoList;
//            }
//
//            public List<TnurseBrieflyVoListBean> getTnurseBrieflyVoList() {
//                return tnurseBrieflyVoList;
//            }
//
//            public void setTnurseBrieflyVoList(List<TnurseBrieflyVoListBean> tnurseBrieflyVoList) {
//                this.tnurseBrieflyVoList = tnurseBrieflyVoList;
//            }
//
//            public List<TcareLableVoListBean> getTcareLableVoList() {
//                return tcareLableVoList;
//            }
//
//            public void setTcareLableVoList(List<TcareLableVoListBean> tcareLableVoList) {
//                this.tcareLableVoList = tcareLableVoList;
//            }
//
//            public List<TdoctorBrieflyVoListBean> getTdoctorBrieflyVoList() {
//                return tdoctorBrieflyVoList;
//            }
//
//            public void setTdoctorBrieflyVoList(List<TdoctorBrieflyVoListBean> tdoctorBrieflyVoList) {
//                this.tdoctorBrieflyVoList = tdoctorBrieflyVoList;
//            }
//
//            public static class TnurseBrieflyVoListBean {
//                /**
//                 * id : 98
//                 * name : 余婵
//                 * sex : 0
//                 */
//
//                private int id;
//                private String name;
//                private int sex;
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public int getSex() {
//                    return sex;
//                }
//
//                public void setSex(int sex) {
//                    this.sex = sex;
//                }
//            }
//
//            public static class TcareLableVoListBean {
//                /**
//                 * id : 12
//                 * lableName : 按内科一般常规护理
//                 * viewColor : null
//                 * detailContent : null
//                 * status : 1
//                 * description : null
//                 */
//
//                private int id;
//                private String lableName;
//                private String viewColor;
//                private Object detailContent;
//                private int status;
//                private Object description;
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getLableName() {
//                    return lableName;
//                }
//
//                public void setLableName(String lableName) {
//                    this.lableName = lableName;
//                }
//
//                public String getViewColor() {
//                    return viewColor;
//                }
//
//                public void setViewColor(String viewColor) {
//                    this.viewColor = viewColor;
//                }
//
//                public Object getDetailContent() {
//                    return detailContent;
//                }
//
//                public void setDetailContent(Object detailContent) {
//                    this.detailContent = detailContent;
//                }
//
//                public int getStatus() {
//                    return status;
//                }
//
//                public void setStatus(int status) {
//                    this.status = status;
//                }
//
//                public Object getDescription() {
//                    return description;
//                }
//
//                public void setDescription(Object description) {
//                    this.description = description;
//                }
//            }
//
//            public static class TdoctorBrieflyVoListBean {
//                /**
//                 * id : 253
//                 * doctorName : 熊琪
//                 * sex : 0
//                 */
//
//                private int id;
//                private String doctorName;
//                private int sex;
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getDoctorName() {
//                    return doctorName;
//                }
//
//                public void setDoctorName(String doctorName) {
//                    this.doctorName = doctorName;
//                }
//
//                public int getSex() {
//                    return sex;
//                }
//
//                public void setSex(int sex) {
//                    this.sex = sex;
//                }
//            }
//        }
//
//        public static class TwardVoBean {
//            /**
//             * id : 1
//             * name : 外科病区
//             * position : 深圳市坪山新区金牛路萨米国际医疗中心五楼
//             * dutyBy :
//             * hisId : null
//             * description : null
//             */
//
//            private int id;
//            private String name;
//            private String position;
//            private String dutyBy;
//            private Object hisId;
//            private Object description;
//
//            public int getId() {
//                return id;
//            }
//
//            public void setId(int id) {
//                this.id = id;
//            }
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getPosition() {
//                return position;
//            }
//
//            public void setPosition(String position) {
//                this.position = position;
//            }
//
//            public String getDutyBy() {
//                return dutyBy;
//            }
//
//            public void setDutyBy(String dutyBy) {
//                this.dutyBy = dutyBy;
//            }
//
//            public Object getHisId() {
//                return hisId;
//            }
//
//            public void setHisId(Object hisId) {
//                this.hisId = hisId;
//            }
//
//            public Object getDescription() {
//                return description;
//            }
//
//            public void setDescription(Object description) {
//                this.description = description;
//            }
//        }
//    }




}
