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
import com.jzr.bedside.bean.CheckDeptBean;
import com.jzr.bedside.bean.DeviceBean;
import com.jzr.bedside.bean.DoctorBean;
import com.jzr.bedside.bean.DoctorByConditionBean;
import com.jzr.bedside.bean.FoodMenuBean;
import com.jzr.bedside.bean.HospitalBean;
import com.jzr.bedside.bean.MedicationRecordBean;
import com.jzr.bedside.bean.NurseInfoBean;
import com.jzr.bedside.bean.TQuestionBean;
import com.jzr.bedside.bean.VideoBean;
import com.google.gson.Gson;
import com.jzr.bedside.bean.boby.DeviceBoby;

import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public class Api {

    private static Api instance;
    private ApiService service;

    private Api(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constant.API_BASE_URL)
                .build();
        service = retrofit.create(ApiService.class);
    }

    public static Api getInstance() {
        synchronized (Api.class) {
            if (instance == null)
                instance = new Api(Okhttp.provideOkHttpClient());
            return instance;
        }
    }

     private static Map<String, String> getMap(String... s) {
        Map<String, String> map = new HashMap<>();
        if (s.length % 2 != 0) {
            return null;
        } else {
            for (int i = 0; i < s.length; i++) {
                map.put(s[i], s[++i]);
            }
        }
        return map;
    }

    // 测试连接
    public Observable<ResponseBody> TestLink(String... s) {
        return service.TestLink(getMap(s));
    }

    // 下载app
    public Observable<ResponseBody> downApp(String s) {
        return service.downApp(s);
    }

    // 获取本对应位置
    public Observable<ResponseBody> GetLocation(String... s) {
        return service.GetLocation(getMap(s));
    }

    // 根据设备编号获取床位及病人信息
    public Observable<BedInfoBean> bedcardGetbedinfo(String... s) {
        return service.bedcardGetbedinfo(getMap(s));
    }

    // 查询医生详细信息接口
    public Observable<DoctorBean> selectByDoctorId(String... s) {
        return service.selectByDoctorId(getMap(s));
    }
    // 查询护士详细信息接口
    public Observable<NurseInfoBean> selectByNurseId(String... s) {
        return service.selectByNurseId(getMap(s));
    }

    // 根据id查询医院信息
    public Observable<HospitalBean> selectByHospitalId(String... s) {
        return service.selectByHospitalId(getMap(s));
    }

    // 根据条件查询医生分页信息
    public Observable<DoctorByConditionBean> findDoctorByCondition(String... s) {
        return service.findDoctorByCondition(getMap(s));
    }


    // 根据Id查询问卷调查信息
    public Observable<TQuestionBean> questionGettQuestionvoBypage(String... s) {
        return service.questionGettQuestionvoBypage(getMap(s));
    }

    // 提交用户调查问卷
    public Observable<TQuestionBean> addTUserQuestionnaire(String... s) {
        return service.addTUserQuestionnaire(getMap(s));
    }

    // 根据条件查询视频信息
    public Observable<VideoBean> gettVideovoByCondition(String... s) {
        return service.gettVideovoByCondition(getMap(s));
    }
    // 用药记录信息
    public Observable<MedicationRecordBean> selectByMedicationRecordid(String... s) {
        return service.selectByMedicationRecordid(getMap(s));
    }


    // 根据条件查询所有住院费用
    public Observable<PayInfoBean> getTHospitalizationExpensesVoAllByCondition(String... s) {
        return service.getTHospitalizationExpensesVoAllByCondition(getMap(s));
    }

    // 根据条件查询所有住院费用及详情信息
    public Observable<ExpenseDetailBean> getThisAndDetailAllByCondition(String... s) {
        return service.getThisAndDetailAllByCondition(getMap(s));
    }

    // 绑定床头卡
    public Observable<DeviceBean> getBedcardBindtobed(DeviceBoby deviceBoby) {
        return service.getBedcardBindtobed(deviceBoby);
    }

    // 获取科室列表
    public Observable<CheckDeptBean> getDeptCodelist(String... s) {
        return service.getDeptCodelist(getMap(s));
    }

    // 获取科室房间列表
    public Observable<CheckDeptBean> getDeptRoomList(String... s) {
        return service.getDeptRoomList(getMap(s));
    }

    // 获取科室房间床位列表
    public Observable<CheckDeptBean> getDeptBedList(String... s) {
        return service.getDeptBedList(getMap(s));
    }



    // 获取食堂菜单列表
    public Observable<FoodMenuBean> getFoodMenuSelectAll(String... s) {
        return service.getFoodMenuSelectAll(getMap(s));
    }



}
