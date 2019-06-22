package com.jzr.bedside.bean;

import java.util.List;

public class CheckDeptBean {


    /**
     * code : 0
     * status : 0
     * message : 成功
     * msg : 成功
     * count : 0
     * timestamp : 2019-04-28T03:19:25.933Z
     * data : [{"code":"2400","name":"CT"},{"code":"2300","name":"MRI"},{"code":"2000","name":"中医科"},{"code":"7031","name":"中医科分诊台"},{"code":"2001","name":"中医科门诊"},{"code":"6003","name":"中成药库"},{"code":"6001","name":"中药库"},{"code":"6030","name":"中药房"},{"code":"1303","name":"产科"},{"code":"1304","name":"产科门诊"},{"code":"9301","name":"人力资源科"},{"code":"3504","name":"介入神经放射科（"},{"code":"9403","name":"会计与财务"},{"code":"8020","name":"住院收费处"},{"code":"6040","name":"住院药房"},{"code":"2205","name":"体检科"},{"code":"2017","name":"作业疗法"},{"code":"9204","name":"信息资讯科"},{"code":"8500","name":"信息资讯部"},{"code":"1401","name":"儿科"},{"code":"1400","name":"儿科(大)"},{"code":"1407","name":"儿科住院"},{"code":"7023","name":"儿科分诊台"},{"code":"7116","name":"儿科病区"},{"code":"6050","name":"儿科药房"},{"code":"1402","name":"儿科门诊"},{"code":"1109","name":"内分泌科"},{"code":"1110","name":"内分泌科门诊"},{"code":"1100","name":"内科"},{"code":"1116","name":"内科住院"},{"code":"7026","name":"内科分诊台"},{"code":"7115","name":"内科病区"},{"code":"1115","name":"内科门诊"},{"code":"2600","name":"内镜中心"},{"code":"1207","name":"创伤外科"},{"code":"1208","name":"创伤外科门诊"},{"code":"3528","name":"功能神经外科"},{"code":"3529","name":"功能神经外科门诊"},{"code":"9500","name":"劳务派遣"},{"code":"9402","name":"医保物价"},{"code":"2206","name":"医务科"},{"code":"9100","name":"医疗部"},{"code":"9104","name":"医疗部办公室"},{"code":"9000","name":"医院管理团队"},{"code":"1701","name":"口腔内科"},{"code":"1702","name":"口腔内科门诊"},{"code":"1703","name":"口腔正畸"},{"code":"1704","name":"口腔正畸门诊"},{"code":"1700","name":"口腔科"},{"code":"7029","name":"口腔科分诊台"},{"code":"1107","name":"呼吸内科"},{"code":"1108","name":"呼吸内科门诊"},{"code":"7014","name":"呼吸科分诊台"},{"code":"3530","name":"外周神经外科"},{"code":"3531","name":"外周神经外科门诊"},{"code":"1200","name":"外科"},{"code":"1217","name":"外科住院"},{"code":"7114","name":"外科病区"},{"code":"1216","name":"外科门诊"},{"code":"1300","name":"妇产科"},{"code":"7022","name":"妇产科分诊台"},{"code":"7027","name":"妇科"},{"code":"1301","name":"妇科1"},{"code":"1305","name":"妇科住院"},{"code":"7028","name":"妇科分诊台"},{"code":"7113","name":"妇科病区"},{"code":"1302","name":"妇科门诊"},{"code":"3532","name":"小儿神经外科"},{"code":"3533","name":"小儿神经外科门诊"},{"code":"2100","name":"康复科"},{"code":"2101","name":"康复科门诊"},{"code":"2700","name":"心电图"},{"code":"1101","name":"心血管内科"},{"code":"1102","name":"心血管内科门诊"},{"code":"7016","name":"心血管科分诊台"},{"code":"8030","name":"急诊收费处"},{"code":"2208","name":"急诊科"},{"code":"7030","name":"急诊科分诊台"},{"code":"3000","name":"急诊科门诊"},{"code":"6060","name":"急诊药房"},{"code":"9212","name":"感染控制科"},{"code":"1500","name":"感染科"},{"code":"7025","name":"感染科分诊台"},{"code":"1501","name":"感染科门诊"},{"code":"1000","name":"手术室"},{"code":"2900","name":"手术室麻醉科"},{"code":"9103","name":"护理中心"},{"code":"9207","name":"护理部"},{"code":"9401","name":"挂号与收费"},{"code":"2200","name":"放射科"},{"code":"1403","name":"新生儿科"},{"code":"1404","name":"新生儿科门诊"},{"code":"1405","name":"新生儿重症科"},{"code":"1406","name":"新生儿重症科门诊"},{"code":"1201","name":"普通外科"},{"code":"1202","name":"普通外科门诊"},{"code":"3700","name":"杂交手术室"},{"code":"3200","name":"检验科"},{"code":"1211","name":"泌尿外科"},{"code":"1212","name":"泌尿外科门诊"},{"code":"7020","name":"消化内科分诊台"},{"code":"1104","name":"消化内科门诊"},{"code":"9208","name":"消毒供应室"},{"code":"2103","name":"物理疗法"},{"code":"2104","name":"理疗科门诊"},{"code":"1214","name":"疼痛科"},{"code":"1215","name":"疼痛科门诊"},{"code":"9214","name":"病案科"},{"code":"3100","name":"病理科"},{"code":"1900","name":"皮肤病与性病科"},{"code":"1901","name":"皮肤病与性病科门诊"},{"code":"1600","name":"眼科"},{"code":"1602","name":"眼科住院"},{"code":"7013","name":"眼科分诊台"},{"code":"7117","name":"眼科病区"},{"code":"1601","name":"眼科门诊"},{"code":"9102","name":"神经专科中心"},{"code":"3604","name":"神经内分泌科"},{"code":"3605","name":"神经内分泌科门诊"},{"code":"3601","name":"神经内科"},{"code":"3600","name":"神经内科（大）"},{"code":"7017","name":"神经内科分诊台"},{"code":"3602","name":"神经内科门诊"},{"code":"3501","name":"神经外科"},{"code":"3500","name":"神经外科（大）"},{"code":"3503","name":"神经外科住院"},{"code":"7012","name":"神经外科分诊台"},{"code":"7111","name":"神经外科病区"},{"code":"3502","name":"神经外科门诊"},{"code":"3519","name":"神经康复科"},{"code":"7015","name":"神经康复科分诊台"},{"code":"3520","name":"神经康复科门诊"},{"code":"3507","name":"神经影像科"},{"code":"3508","name":"神经放射科门诊"},{"code":"3607","name":"神经生理科"},{"code":"3608","name":"神经生理科门诊"},{"code":"3516","name":"神经病理科"},{"code":"3517","name":"神经病理科门诊"},{"code":"3513","name":"神经眼科"},{"code":"3515","name":"神经眼科住院"},{"code":"7112","name":"神经眼科病区"},{"code":"3514","name":"神经眼科门诊"},{"code":"3510","name":"神经肿瘤科"},{"code":"3511","name":"神经肿瘤科门诊"},{"code":"3526","name":"神经血管外科"},{"code":"3527","name":"神经血管外科门诊"},{"code":"3522","name":"神经重症科"},{"code":"3523","name":"神经重症科门诊"},{"code":"9211","name":"科教科"},{"code":"9101","name":"综合医疗中心"},{"code":"2207","name":"综合处置区"},{"code":"2102","name":"综合性康复科门诊"},{"code":"9300","name":"综合部"},{"code":"1800","name":"耳鼻咽喉科"},{"code":"1802","name":"耳鼻咽喉科住院"},{"code":"7118","name":"耳鼻咽喉科病区"},{"code":"7024","name":"耳鼻喉科分诊台"},{"code":"1801","name":"耳鼻喉科门诊"},{"code":"2108","name":"职业疗法科门诊"},{"code":"3400","name":"肌电图"},{"code":"1205","name":"肝胆外科"},{"code":"1206","name":"肝胆外科门诊"},{"code":"3221","name":"肺功能室"},{"code":"1105","name":"肾内科"},{"code":"1106","name":"肾内科门诊"},{"code":"7019","name":"肿瘤科分诊台"},{"code":"1103","name":"胃肠科"},{"code":"1203","name":"胸外科"},{"code":"1204","name":"胸外科门诊"},{"code":"3524","name":"脊髓神经外科"},{"code":"3525","name":"脊髓神经外科门诊"},{"code":"2800","name":"脑电图"},{"code":"6002","name":"药剂科"},{"code":"6000","name":"药库"},{"code":"6010","name":"药房"},{"code":"7018","name":"血液内科分诊台"},{"code":"1113","name":"血液科"},{"code":"1114","name":"血液科门诊"},{"code":"9201","name":"行政支持科"},{"code":"2018","name":"言语疗法"},{"code":"9202","name":"设施管理科"},{"code":"8000","name":"财务部"},{"code":"9205","name":"质量控制与投诉管"},{"code":"2500","name":"超声科"},{"code":"3300","name":"输血科"},{"code":"2105","name":"运动疗法"},{"code":"2106","name":"运动疗法科门诊"},{"code":"9206","name":"运营办公室"},{"code":"9200","name":"运营部"},{"code":"9023","name":"采购与库存科"},{"code":"8010","name":"门诊收费处"},{"code":"6020","name":"门诊药房"},{"code":"2201","name":"门诊部"},{"code":"9302","name":"院办"},{"code":"6070","name":"静脉配置中心"},{"code":"9213","name":"预防保健科"},{"code":"1111","name":"风湿科"},{"code":"1112","name":"风湿科门诊"},{"code":"1209","name":"骨科"},{"code":"7021","name":"骨科分诊台"},{"code":"1210","name":"骨科门诊"},{"code":"6004","name":"麻精库"},{"code":"6080","name":"麻醉科药房"}]
     */

    private int code;
    private int status;
    private String message;
    private String msg;
    private int count;
    private String timestamp;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * code : 2400
         * name : CT
         */

        private String code;
        private String name;
        private  int id;

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
    }
}
