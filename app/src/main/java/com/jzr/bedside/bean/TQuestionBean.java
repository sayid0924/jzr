package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/15.
 */

public class TQuestionBean {


    /**
     * code : 0
     * message : 查询问卷调查信息成功
     * timestamp : {"epochSecond":1542340081,"nano":52000000}
     * data : {"pageNum":1,"pageSize":2,"total":2,"pages":1,"list":[{"id":1,"name":"您是通过什么渠道了解到我们医院的？","questionTypeId":1,"controlType":"radio","defaultValue":null,"imageUrl":"http://www.newnet.cc/uploadfile/201702/7/DC113237323.jpg","questionStatus":1,"description":null,"tquestionTypeVo":{"id":1,"name":"调查问卷","deptOwner":"1","description":null},"tquestionAnswerVoList":[{"id":1,"answerName":"电视报道","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":2,"answerName":"路牌广告","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":3,"answerName":"杂志","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":4,"answerName":"网络媒体","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":5,"answerName":"湖人介绍","questionId":1,"imageUrl":"1","description":null,"ischoose":false}]},{"id":2,"name":"您对就诊过程中我院的总体满意程度？","questionTypeId":1,"controlType":"radio","defaultValue":"0","imageUrl":null,"questionStatus":1,"description":null,"tquestionTypeVo":{"id":1,"name":"调查问卷","deptOwner":"1","description":null},"tquestionAnswerVoList":[{"id":6,"answerName":"满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false},{"id":7,"answerName":"基本满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false},{"id":8,"answerName":"不满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false}]}],"isFirstPage":true,"isLastPage":true}
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
         * epochSecond : 1542340081
         * nano : 52000000
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
         * list : [{"id":1,"name":"您是通过什么渠道了解到我们医院的？","questionTypeId":1,"controlType":"radio","defaultValue":null,"imageUrl":"http://www.newnet.cc/uploadfile/201702/7/DC113237323.jpg","questionStatus":1,"description":null,"tquestionTypeVo":{"id":1,"name":"调查问卷","deptOwner":"1","description":null},"tquestionAnswerVoList":[{"id":1,"answerName":"电视报道","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":2,"answerName":"路牌广告","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":3,"answerName":"杂志","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":4,"answerName":"网络媒体","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":5,"answerName":"湖人介绍","questionId":1,"imageUrl":"1","description":null,"ischoose":false}]},{"id":2,"name":"您对就诊过程中我院的总体满意程度？","questionTypeId":1,"controlType":"radio","defaultValue":"0","imageUrl":null,"questionStatus":1,"description":null,"tquestionTypeVo":{"id":1,"name":"调查问卷","deptOwner":"1","description":null},"tquestionAnswerVoList":[{"id":6,"answerName":"满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false},{"id":7,"answerName":"基本满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false},{"id":8,"answerName":"不满意","questionId":2,"imageUrl":"1","description":null,"ischoose":false}]}]
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
             * name : 您是通过什么渠道了解到我们医院的？
             * questionTypeId : 1
             * controlType : radio
             * defaultValue : null
             * imageUrl : http://www.newnet.cc/uploadfile/201702/7/DC113237323.jpg
             * questionStatus : 1
             * description : null
             * tquestionTypeVo : {"id":1,"name":"调查问卷","deptOwner":"1","description":null}
             * tquestionAnswerVoList : [{"id":1,"answerName":"电视报道","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":2,"answerName":"路牌广告","questionId":1,"imageUrl":"1","description":null,"ischoose":true},{"id":3,"answerName":"杂志","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":4,"answerName":"网络媒体","questionId":1,"imageUrl":"1","description":null,"ischoose":false},{"id":5,"answerName":"湖人介绍","questionId":1,"imageUrl":"1","description":null,"ischoose":false}]
             */

            private int id;
            private String name;
            private int questionTypeId;
            private String controlType;
            private Object defaultValue;
            private String imageUrl;
            private int questionStatus;
            private Object description;
            private TquestionTypeVoBean tquestionTypeVo;
            private List<TquestionAnswerVoListBean> tquestionAnswerVoList;

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

            public int getQuestionTypeId() {
                return questionTypeId;
            }

            public void setQuestionTypeId(int questionTypeId) {
                this.questionTypeId = questionTypeId;
            }

            public String getControlType() {
                return controlType;
            }

            public void setControlType(String controlType) {
                this.controlType = controlType;
            }

            public Object getDefaultValue() {
                return defaultValue;
            }

            public void setDefaultValue(Object defaultValue) {
                this.defaultValue = defaultValue;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getQuestionStatus() {
                return questionStatus;
            }

            public void setQuestionStatus(int questionStatus) {
                this.questionStatus = questionStatus;
            }

            public Object getDescription() {
                return description;
            }

            public void setDescription(Object description) {
                this.description = description;
            }

            public TquestionTypeVoBean getTquestionTypeVo() {
                return tquestionTypeVo;
            }

            public void setTquestionTypeVo(TquestionTypeVoBean tquestionTypeVo) {
                this.tquestionTypeVo = tquestionTypeVo;
            }

            public List<TquestionAnswerVoListBean> getTquestionAnswerVoList() {
                return tquestionAnswerVoList;
            }

            public void setTquestionAnswerVoList(List<TquestionAnswerVoListBean> tquestionAnswerVoList) {
                this.tquestionAnswerVoList = tquestionAnswerVoList;
            }

            public static class TquestionTypeVoBean {
                /**
                 * id : 1
                 * name : 调查问卷
                 * deptOwner : 1
                 * description : null
                 */

                private int id;
                private String name;
                private String deptOwner;
                private Object description;

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

                public String getDeptOwner() {
                    return deptOwner;
                }

                public void setDeptOwner(String deptOwner) {
                    this.deptOwner = deptOwner;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }
            }

            public static class TquestionAnswerVoListBean {
                public TquestionAnswerVoListBean(int id, String answerName,boolean ischoose) {
                    this.id = id;
                    this.answerName = answerName;
                    this.ischoose = ischoose;
                }

                /**
                 * id : 1
                 * answerName : 电视报道
                 * questionId : 1
                 * imageUrl : 1
                 * description : null
                 * ischoose : true
                 */






                private int id;
                private String answerName;
                private int questionId;
                private String imageUrl;
                private Object description;
                private boolean ischoose;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getAnswerName() {
                    return answerName;
                }

                public void setAnswerName(String answerName) {
                    this.answerName = answerName;
                }

                public int getQuestionId() {
                    return questionId;
                }

                public void setQuestionId(int questionId) {
                    this.questionId = questionId;
                }

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public Object getDescription() {
                    return description;
                }

                public void setDescription(Object description) {
                    this.description = description;
                }

                public boolean isIschoose() {
                    return ischoose;
                }

                public void setIschoose(boolean ischoose) {
                    this.ischoose = ischoose;
                }
            }
        }
    }
}
