package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/14.
 */

public class HospitalBean {


    /**
     * code : 0
     * message : 查询数据成功
     * timestamp : {"epochSecond":1542177305,"nano":360000000}
     * data : {"id":1,"name":"深圳市人民医院","intro":"深圳市人民医院简介","license":"许可证","logoUrl":"Logo地址","address":null,"postCode":null,"phone":"0755-1000001","email":null,"imageUrl":null,"areaName":null,"masterName":null,"masterMobile":null,"longitude":null,"latitude":null,"orgType":null,"level":null,"path":null,"parentId":null,"isShowWeb":null,"description":null,"tparentDeptVoList":[{"id":1,"name":"第一科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","tsonDeptVoList":[{"id":3,"name":"第一科室1","intro":"BBEN","description":"BBEN","tsonDeptVoList":null},{"id":4,"name":"第一科室2","intro":"BBEN","description":"BBEN","tsonDeptVoList":null}]},{"id":2,"name":"第二科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","tsonDeptVoList":[{"id":5,"name":"第二课时1","intro":"BBEN","description":"BBEN","tsonDeptVoList":null},{"id":6,"name":"第二课时2","intro":"BBEN","description":"BBEN","tsonDeptVoList":null}]},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null}]}
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
         * epochSecond : 1542177305
         * nano : 360000000
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
         * name : 深圳市人民医院
         * intro : 深圳市人民医院简介
         * license : 许可证
         * logoUrl : Logo地址
         * address : null
         * postCode : null
         * phone : 0755-1000001
         * email : null
         * imageUrl : null
         * areaName : null
         * masterName : null
         * masterMobile : null
         * longitude : null
         * latitude : null
         * orgType : null
         * level : null
         * path : null
         * parentId : null
         * isShowWeb : null
         * description : null
         * tparentDeptVoList : [{"id":1,"name":"第一科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","tsonDeptVoList":[{"id":3,"name":"第一科室1","intro":"BBEN","description":"BBEN","tsonDeptVoList":null},{"id":4,"name":"第一科室2","intro":"BBEN","description":"BBEN","tsonDeptVoList":null}]},{"id":2,"name":"第二科室","intro":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","description":"公司专注于医疗信息化产品的研发与生产，秉持\u201c科技服务医疗\u201d的宗旨和\u201c以人为本，五心服务\u201d的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商","tsonDeptVoList":[{"id":5,"name":"第二课时1","intro":"BBEN","description":"BBEN","tsonDeptVoList":null},{"id":6,"name":"第二课时2","intro":"BBEN","description":"BBEN","tsonDeptVoList":null}]},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null},{"id":null,"name":null,"intro":null,"description":null,"tsonDeptVoList":null}]
         */

        private int id;
        private String name;
        private String intro;
        private String license;
        private String logoUrl;
        private Object address;
        private Object postCode;
        private String phone;
        private Object email;
        private Object imageUrl;
        private Object areaName;
        private Object masterName;
        private Object masterMobile;
        private Object longitude;
        private Object latitude;
        private Object orgType;
        private Object level;
        private Object path;
        private Object parentId;
        private Object isShowWeb;
        private Object description;
        private List<TparentDeptVoListBean> tparentDeptVoList;

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

        public String getLicense() {
            return license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getPostCode() {
            return postCode;
        }

        public void setPostCode(Object postCode) {
            this.postCode = postCode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public Object getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(Object imageUrl) {
            this.imageUrl = imageUrl;
        }

        public Object getAreaName() {
            return areaName;
        }

        public void setAreaName(Object areaName) {
            this.areaName = areaName;
        }

        public Object getMasterName() {
            return masterName;
        }

        public void setMasterName(Object masterName) {
            this.masterName = masterName;
        }

        public Object getMasterMobile() {
            return masterMobile;
        }

        public void setMasterMobile(Object masterMobile) {
            this.masterMobile = masterMobile;
        }

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public Object getOrgType() {
            return orgType;
        }

        public void setOrgType(Object orgType) {
            this.orgType = orgType;
        }

        public Object getLevel() {
            return level;
        }

        public void setLevel(Object level) {
            this.level = level;
        }

        public Object getPath() {
            return path;
        }

        public void setPath(Object path) {
            this.path = path;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public Object getIsShowWeb() {
            return isShowWeb;
        }

        public void setIsShowWeb(Object isShowWeb) {
            this.isShowWeb = isShowWeb;
        }

        public Object getDescription() {
            return description;
        }

        public void setDescription(Object description) {
            this.description = description;
        }

        public List<TparentDeptVoListBean> getTparentDeptVoList() {
            return tparentDeptVoList;
        }

        public void setTparentDeptVoList(List<TparentDeptVoListBean> tparentDeptVoList) {
            this.tparentDeptVoList = tparentDeptVoList;
        }

        public static class TparentDeptVoListBean {
            /**
             * id : 1
             * name : 第一科室
             * intro : 公司专注于医疗信息化产品的研发与生产，秉持“科技服务医疗”的宗旨和“以人为本，五心服务”的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商
             * description : 公司专注于医疗信息化产品的研发与生产，秉持“科技服务医疗”的宗旨和“以人为本，五心服务”的理念，数年来，博本医疗自主研发的信息化产品远销海外，成为海外医疗机构信息化服务的最佳供应商
             * tsonDeptVoList : [{"id":3,"name":"第一科室1","intro":"BBEN","description":"BBEN","tsonDeptVoList":null},{"id":4,"name":"第一科室2","intro":"BBEN","description":"BBEN","tsonDeptVoList":null}]
             */

            private int id;
            private String name;
            private String intro;
            private String description;
            private List<TsonDeptVoListBean> tsonDeptVoList;

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

            public List<TsonDeptVoListBean> getTsonDeptVoList() {
                return tsonDeptVoList;
            }

            public void setTsonDeptVoList(List<TsonDeptVoListBean> tsonDeptVoList) {
                this.tsonDeptVoList = tsonDeptVoList;
            }

            public static class TsonDeptVoListBean {
                /**
                 * id : 3
                 * name : 第一科室1
                 * intro : BBEN
                 * description : BBEN
                 * tsonDeptVoList : null
                 */

                private int id;
                private String name;
                private String intro;
                private String description;
                private Object tsonDeptVoList;

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

                public Object getTsonDeptVoList() {
                    return tsonDeptVoList;
                }

                public void setTsonDeptVoList(Object tsonDeptVoList) {
                    this.tsonDeptVoList = tsonDeptVoList;
                }
            }
        }
    }
}
