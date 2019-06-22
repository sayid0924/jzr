/**
 * Copyright 2016 JustWayward Team
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jzr.bedside.base;

import android.os.Build;
import android.os.Environment;

public class Constant {


    public static boolean IS_RING = false; //是否正在呼叫护士
    public static boolean IS_VIDEO = false; //是否正在音视频呼叫护士
    public static final int RING_KEY = 601; //呼叫护士按键
    public static final int VIDEO_KEY = 602; //音视频按键
    public static final String ClientId = Build.SERIAL;   //设备序列号号码
    public static final String EquipmentType = "1";    //设备类型

    public static boolean canPickupVoip = true;

    public static String path = Environment.getExternalStorageDirectory().getPath() + "/BBEN/";

    /**
     * 文本消息端口
     */
    public static final int MESSAGE_PORT = 42836;
    /**
     * 语音消息端口
     */
    public static final int VOICE_PORT = 42837;
    /**
     * 文件消息端口
     */
    public static final int FILE_PORT = 42838;
    /**
     * 视屏流端口
     */
    public static final int VIDEO_PORT = 42839;
    /**
     * 局域网内所有ip
     */
    public static final String ALL_ADDRESS = "255.255.255.255";

    public static final String ACTION_ADD_USER = "com.ty.winchat.adduser";

    public static final String id = "d6228819a8cca82a";
    public static final String key = "bc72c19fc590f2bc";


    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;

    //生产环境
    public static final String API_BASE_URL = "http://172.20.1.5:82/";

    //测试连接
    public static final String TEST_LINK = "m.asmx/TestLink";

    //获取对应位置
    public static final String GETLOCATION = "m.asmx/GetLocaXX";

    // 根据设备编号获取床位及病人信息
    public static final String API_BEDCARD_GETBEDCARDINFO = "api/bedCard/getBedCardInfo";
//    public static final String BEDCARD_GETBEDINFO = "/HJ.ashx";

    // 查询医生详细信息接口
    public static final String DOCTOR_SELECTBYDOCTORID = "/bedcard-service/doctor/selectByDoctorId";

    // 查询医生详细信息接口
    public static final String NURSE_SELECTBYNURSEID = "/bedcard-service/nurse/selectByNurseId";

    // 根据id查询医院信息
    public static final String HOSPITAL_SELECTBYHOSPITALID = "/bedcard-service/hospital/selectByHospitalId";

    // 根据条件查询医生分页信息
    public static final String DOCTOR_FINDDOCTORBYCONDITION = "/bedcard-service/doctor/findDoctorByCondition";

    // 根据Id查询问卷调查信息
    public static final String QUESTION_GETTQUESTIONVOBYPAGE = "/question/getTQuestionVoByPage";

    // 提交用户调查问卷
    public static final String USERQUESTIONNAIRE_ADDTUSERQUESTIONNAIRE = "/bedcard-service/userQuestionnaire/addTUserQuestionnaire";

    // 根据条件查询视频信息
    public static final String VIDEO_GETTVIDEOVOBYCONDITION = "/bedcard-service/video/getTVideoVoByCondition";

    // 用药记录信息
    public static final String MEDICATIONRECORD_SELECTBYMEDICATIONRECORDID = "/medicationRecord/getTMedicationRecordVoByCondition";

    // 根据条件查询所有住院费用
    public static final String GETTHOSPITALIZATIONEXPENSESVOALLBYCONDITION = "/bedcard-service/hospitalizationExpenses/getTHospitalizationExpensesVoAllByCondition";

    // 根据条件查询所有住院费用及详情信息
    public static final String GETTHISANDDETAILALLBYCONDITION = "/hospitalizationExpenses/getThisAndDetailAllByCondition";

    // 绑定床头卡
    public static final String API_BEDCARD_BINDTOBED = "api/bedCard/bindToBed";

    // 获取科室列表
    public static final String API_DEPT_CODELIST = "api/dept/codeList";
    // 获取科室房间列表
    public static final String API_DEPT_ROOMLIST = "api/dept/roomList";
    // 获取科室房间床位列表
    public static final String API_DEPT_BEDLIST = "api/dept/bedList";

    // 获取食堂菜单列表
    public static final String  API_FOODMENU_SELECTALL = "/api/foodmenu/selectAll";


}
