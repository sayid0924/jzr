package com.jzr.bedside.bean;

import java.util.List;

/**
 * Created by Bben on 2018/11/17.
 */

public class VideoBean {


    /**
     * code : 0
     * message : 查询视频信息成功
     * timestamp : {"epochSecond":1542444566,"nano":812000000}
     * data : {"pageNum":1,"pageSize":3,"total":3,"pages":1,"list":[{"id":1,"videoType":1,"videoUrl":"http://172.30.1.251/video1.mp4","description":"测试"},{"id":2,"videoType":1,"videoUrl":"http://172.30.1.251/video2.mp4","description":"测试"},{"id":3,"videoType":1,"videoUrl":"http://172.30.1.251/video3.mp4","description":"测试"}],"isFirstPage":true,"isLastPage":true}
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
         * epochSecond : 1542444566
         * nano : 812000000
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
         * pageSize : 3
         * total : 3
         * pages : 1
         * list : [{"id":1,"videoType":1,"videoUrl":"http://172.30.1.251/video1.mp4","description":"测试"},{"id":2,"videoType":1,"videoUrl":"http://172.30.1.251/video2.mp4","description":"测试"},{"id":3,"videoType":1,"videoUrl":"http://172.30.1.251/video3.mp4","description":"测试"}]
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
             * videoType : 1
             * videoUrl : http://172.30.1.251/video1.mp4
             * description : 测试
             */

            private int id;
            private int videoType;
            private String videoUrl;
            private String description;
            private  String imageUrl;

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getVideoType() {
                return videoType;
            }

            public void setVideoType(int videoType) {
                this.videoType = videoType;
            }

            public String getVideoUrl() {
                return videoUrl;
            }

            public void setVideoUrl(String videoUrl) {
                this.videoUrl = videoUrl;
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
