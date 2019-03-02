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
package com.jzr.bedside.api;


import com.jzr.bedside.base.Constant;
import com.jzr.bedside.base.ExpenseDetailBean;
import com.jzr.bedside.base.PayInfoBean;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.DoctorBean;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.jzr.bedside.bean.NurseInfoBean;
import com.jzr.bedside.bean.TQuestionBean;
import com.jzr.bedside.bean.VideoBean;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ApiService {


    /**
     * 根据设备编号获取床位及病人信息
     */
    @GET(Constant.BEDCARD_GETBEDINFO)
    Observable<BedInfoBean> bedcardGetbedinfo(@QueryMap Map<String, String> map);

    /**
     * 测试 连接
     */
    @POST(Constant.TEST_LINK)
    Observable<ResponseBody> TestLink(@QueryMap Map<String, String> map);

    /**
     * 获取对应位置
     */
    @GET(Constant.GETLOCATION)
    Observable<ResponseBody> GetLocation(@QueryMap Map<String, String> map);

    /**
     * 查询医生详细信息接口
     */
    @GET(Constant.DOCTOR_SELECTBYDOCTORID)
    Observable<DoctorBean> selectByDoctorId(@QueryMap Map<String, String> map);

    /**
     * 查询护士详细信息接口
     */
    @GET(Constant.NURSE_SELECTBYNURSEID)
    Observable<NurseInfoBean> selectByNurseId(@QueryMap Map<String, String> map);

    /**
     * 根据id查询医院信息
     */
    @GET(Constant.HOSPITAL_SELECTBYHOSPITALID)
    Observable<HospitalBean> selectByHospitalId(@QueryMap Map<String, String> map);

    /**
     * 根据条件查询医生分页信息
     */
    @POST(Constant.DOCTOR_FINDDOCTORBYCONDITION)
    Observable<DoctorByConditionBean> findDoctorByCondition(@QueryMap Map<String, String> map);

    /**
     * 根据Id查询问卷调查信息
     */
    @GET(Constant.QUESTION_GETTQUESTIONVOBYPAGE)
    Observable<TQuestionBean> questionGettQuestionvoBypage(@QueryMap Map<String, String> map);

    /**
     * 提交用户调查问卷
     */
    @POST(Constant.USERQUESTIONNAIRE_ADDTUSERQUESTIONNAIRE)
    Observable<TQuestionBean> addTUserQuestionnaire(@QueryMap Map<String, String> map);

    /**
     * 根据条件查询视频信息
     */
    @POST(Constant.VIDEO_GETTVIDEOVOBYCONDITION)
    Observable<VideoBean> gettVideovoByCondition(@QueryMap Map<String, String> map);

    /**
     * 用药记录信息
     */
    @POST(Constant.MEDICATIONRECORD_SELECTBYMEDICATIONRECORDID)
    Observable<MedicationRecordBean> selectByMedicationRecordid(@QueryMap Map<String, String> map);

    /**
     * 根据条件查询所有住院费用
     */
    @POST(Constant.GETTHOSPITALIZATIONEXPENSESVOALLBYCONDITION)
    Observable<PayInfoBean> getTHospitalizationExpensesVoAllByCondition(@QueryMap Map<String, String> map);

    /**
     * 根据条件查询所有住院费用及详情信息
     */
    @POST(Constant.GETTHISANDDETAILALLBYCONDITION)
    Observable<ExpenseDetailBean> getThisAndDetailAllByCondition(@QueryMap Map<String, String> map);

}