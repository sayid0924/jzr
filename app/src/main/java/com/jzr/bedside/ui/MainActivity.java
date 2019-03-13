package com.jzr.bedside.ui;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.FileUtils;
import com.blankj.utilcode.utils.Utils;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.SettingEvenBus;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.MainContract;
import com.jzr.bedside.presenter.impl.activity.MainActivityPresenter;
import com.jzr.bedside.ui.apadter.DoctorAdviceApadter;
import com.jzr.bedside.utils.AreaClickListener;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.Permission;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.bedside.utils.QRCodeUtil;
import com.jzr.bedside.service.nettyUtils.NettyService;
import com.blankj.utilcode.utils.EmptyUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.medxing.sdk.resolve.IrtResolve;
import com.medxing.sdk.resolve.ResolveManager;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {


    private DoctorAdviceApadter doctorAdviceApadter;
    private List<BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean> doctorAdvicesData = new ArrayList<>();
    MainActivityPresenter mPresenter = new MainActivityPresenter(this);
    private BedInfoBeanDbDao collectionInfoDao;
    public BedInfoBean data;
    private String sex, age, Name, BedNum, CureNo, AdmissionTime, DutyDoctor, DutyNurse, positionName;

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.settings_area)
    View settingsArea;
    @BindView(R.id.rv_doctor_advice)
    RecyclerView rvDoctorAdvice;

    @BindView(R.id.tv_bednum)
    TextView tvBednum;
    @BindView(R.id.tv_cureno)
    TextView tvCureNo;
    //    @BindView(R.id.tv_nurseLevel)
//    TextView tvNurseLevel;
    @BindView(R.id.tv_admissionTime)
    TextView tvAdmissionTime;
    @BindView(R.id.tv_dutydoctor)
    TextView tvDutydoctor;
    @BindView(R.id.tv_dutyNurse)
    TextView tvDutyNurse;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_age)
    TextView tvAge;
    //    @BindView(R.id.tv_allergyContent)
//    TextView tvAllergyContent;
    @BindView(R.id.rl_dutydoctor)
    RelativeLayout rlDutydoctor;
    @BindView(R.id.rl_dutyNurse)
    RelativeLayout rlDutyNurse;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.iv_qrcode)
    ImageView ivQrcode;
    private PopupWindow p;
    public static MainActivity mainActivity = null;
    private ResolveManager resolveManager;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void attachView() {
        mPresenter.attachView(this);
    }

    @Override
    public void detachView() {
        mPresenter.detachView();
    }

    @Override
    public void initView() {
        setSwipeBackEnable(false);
        Permission.requestPermission(this);
        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        if (!PreferUtil.getInstance().getIsFirst()) {
            startActivityIn(new Intent(this, SettingActivity.class), this);
        }

        settingsArea.setOnClickListener(new AreaClickListener(5, 500, new AreaClickListener.ClickEvent() {
            @Override
            public void onEvent() {
                startActivityIn(new Intent(MainActivity.this, SettingActivity.class), MainActivity.this);
            }
        }));

        ivBack.setVisibility(View.VISIBLE);
        ivBack.setBackgroundResource(R.drawable.logo);
        leftTitle.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
//        leftTitle.setText(PreferUtil.getInstance().getLocationInfo());

        doctorAdviceApadter = new DoctorAdviceApadter(doctorAdvicesData, this);
        rvDoctorAdvice.setLayoutManager(new LinearLayoutManager(this));
        rvDoctorAdvice.setAdapter(doctorAdviceApadter);

        startService(new Intent().setComponent(new ComponentName("com.bben.bedside",
                "com.bben.bedside.service.StartCommandService")));

        startService(new Intent(this, NettyService.class));
//        startService(new Intent(this, RabbitMQService.class));

//        mPresenter.bedcardGetbedinfo(true, "code", Build.SERIAL);
//        mPresenter.bedbeabinfo("code", Build.SERIAL);
        initData();
        mainActivity = this;


//        FileUtils.createOrExistsFile(Utils.getContext().getExternalCacheDir()+"app");


//        resolveManager = ResolveManager.getInstance(this);
//        resolveManager.setOnIrtResolveListener(new ResolveManager.OnIrtResolveListener() {
//            @Override
//            public void onIrtResolve(IrtResolve irtResolve) {
//                Logger.e("==================================================");
//                Logger.e(irtResolve.toString());
//
//            }
//        });
//        createFile("app");
      boolean d =  AppUtils.installAppSilent(Environment.getExternalStorageDirectory() + "/" +"app"+"/"+"app-release.apk");
      Logger.e(String.valueOf(d));
    }


    public void createFile(String fileName) {
        File file = new File(Environment.getExternalStorageDirectory() + "/" + fileName);
        if (fileName.indexOf(".") != -1) {
            // 说明包含，即使创建文件, 返回值为-1就说明不包含.,即使文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Logger.e("App");
        } else {
            // 创建文件夹
            file.mkdir();
        }
    }


    public void bedcardGetbedinfo() {
        mPresenter.bedcardGetbedinfo(false, "code", Build.SERIAL);
    }

//    @SuppressLint("SetTextI18n")
//    private void initData() {
//
//        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
//                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
//        if (infoBeanDb != null) {
//            data = infoBeanDb.getBedInfoBean();
//
//            if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo())){
//
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getDeptId())){
//                     String title = data.getData().getTpatientVo().getDeptId();
//                     leftTitle.setText(title);
//                 }
//                // 姓名
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getName())){
//                    Name = data.getData().getTpatientVo().getName();
//                    tvName.setText(Name);
//                }
//                // 性别
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getSex())){
//
//                    if (data.getData().getTpatientVo().getSex() == 0) {
//                        sex = "男性";
//                    } else if (data.getData().getTpatientVo().getSex() == 1) {
//                        sex = "女性";
//                    } else {
//                        sex = "未知";
//                    }
//                    tvSex.setText(sex);
//                }
//                // 住院号
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getCureNo())){
//                    CureNo = data.getData().getTpatientVo().getCureNo();
//                    tvCureNo.setText(CureNo);
//                }
//                // 年龄
//               if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getBirthday())){
//                    age = String.valueOf(CommonUtil.getAgeByBirth(TimeUtils.string2Date(TimeUtils.millis2String(TimeUtils.string2Millis(data.getData().getTpatientVo().getBirthday(), "yyyy-MM-dd"))),
//                           TimeUtils.string2Date(TimeUtils.millis2String(data.getTimestamp().getEpochSecond() * 1000L)))) + "岁";
////                   age = data.getData().getTpatientVo().getBirthday();
//                   tvAge.setText(age);
//               }
//                //入院时间
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getAdmissionTime())){
//                    AdmissionTime= data.getData().getTpatientVo().getAdmissionTime();
//                    tvAdmissionTime.setText(AdmissionTime);
//                }
//                // 医嘱
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTcareLableVoList())){
//                    doctorAdviceApadter.setNewData(data.getData().getTpatientVo().getTcareLableVoList());
//                }
//            }
//
//            // 主治护士
//            if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTnurseBrieflyVoList())){
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTnurseBrieflyVoList().get(0).getName())){
//                    DutyNurse = data.getData().getTpatientVo().getTnurseBrieflyVoList().get(0).getName();
//                    tvDutyNurse.setText(DutyNurse);
//                }
//            }
//
//            // 主治医生
//            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTdoctorBrieflyVoList())) {
//                if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTdoctorBrieflyVoList().get(0).getDoctorName()))
//                DutyDoctor = data.getData().getTpatientVo().getTdoctorBrieflyVoList().get(0).getDoctorName();
//                tvDutydoctor.setText(DutyDoctor);
//            }
//            // 床号
//            if(EmptyUtils.isNotEmpty(data.getData().getBedNum())){
//                BedNum = data.getData().getBedNum();
//                tvBednum.setText(BedNum);
//            }
//            // 科室信息
//            positionName = "";
//            if(EmptyUtils.isNotEmpty(data.getData().getTwardVo())){
//                if(EmptyUtils.isNotEmpty(data.getData().getTwardVo().getName())){
//                    positionName = positionName+data.getData().getTwardVo().getName();
//                }
//            }
//            // 房间号
//            if(EmptyUtils.isNotEmpty(data.getData().getTsickroomVo())){
//                if(EmptyUtils.isNotEmpty(data.getData().getTsickroomVo().getSickroomName())){
//                    positionName = positionName+"  " + data.getData().getTsickroomVo().getSickroomName()+"房";
//                }
//            }
//
//            leftTitle.setText(positionName);
//            // 二维码
//            String contentQR = Name + "   " + sex + "   " + age + "\n" + "床号： " + BedNum + "\n" + "住院号: " + CureNo + "\n" +
//                    "入院时间: " + AdmissionTime + "\n" + "主治医生: " + DutyDoctor+ "\n" + "责任护士: " +DutyNurse;
//            Bitmap b = QRCodeUtil.createQRCodeBitmap(contentQR, 300);
//            ivQrcode.setImageBitmap(b);
//
//        }
//    }

    private BedInfoBean initBeanDb() {

        BedInfoBean bedInfoBean = new BedInfoBean();

        BedInfoBean.DataBean dataBean = new BedInfoBean.DataBean();
        dataBean.setId(1);
        dataBean.setBedCardId(10);
        dataBean.setSickroomId(1);
        dataBean.setBedType("0");
        dataBean.setBedNum("10");
        dataBean.setUseStatus(1);
        dataBean.setDescription(null);

        BedInfoBean.DataBean.TpatientVoBean tpatientVoBean = new BedInfoBean.DataBean.TpatientVoBean();

        tpatientVoBean.setId(10);
        tpatientVoBean.setName("陈胜军");
        tpatientVoBean.setSex(0);
        tpatientVoBean.setCureNo("CURE-NO-35");
        tpatientVoBean.setBirthday("54");
        tpatientVoBean.setAdmissionTime("2019-02-28");

        List<BedInfoBean.DataBean.TpatientVoBean.TdoctorBrieflyVoListBean> voListBeans = new ArrayList<>();
        voListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TdoctorBrieflyVoListBean(17, "崔洪涛", 0));
        tpatientVoBean.setTdoctorBrieflyVoList(voListBeans);

        List<BedInfoBean.DataBean.TpatientVoBean.TnurseBrieflyVoListBean> tnurseBrieflyVoList = new ArrayList<>();
        tnurseBrieflyVoList.add(new BedInfoBean.DataBean.TpatientVoBean.TnurseBrieflyVoListBean(1, "徐丽", 2));
        tpatientVoBean.setTnurseBrieflyVoList(tnurseBrieflyVoList);

        List<BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean> tcareLableVoListBeans = new ArrayList<>();
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "防跌倒", "#B22222", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "靜脉营养", "#FE5CD5", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "禁饮水", "#FD7B09", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "低钠低脂", "#459187", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "特殊检查", "#0092DF", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "卧床", "#DD127B", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "流质", "#FFC900", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "过敏体质", "#459187", null, 1, null));
        tcareLableVoListBeans.add(new BedInfoBean.DataBean.TpatientVoBean.TcareLableVoListBean(1, "危重", "#DA251C", null, 1, null));

        tpatientVoBean.setTcareLableVoList(tcareLableVoListBeans);
        dataBean.setTpatientVo(tpatientVoBean);

        bedInfoBean.setData(dataBean);


        return bedInfoBean;


    }


    // 单机版数据
    @SuppressLint("SetTextI18n")
    private void initData() {

        data = initBeanDb();

        if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo())) {

            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getDeptId())) {
                String title = data.getData().getTpatientVo().getDeptId();
                leftTitle.setText(title);
            }
            // 姓名
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getName())) {
                Name = data.getData().getTpatientVo().getName();
                tvName.setText(Name);
            }
            // 性别
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getSex())) {

                if (data.getData().getTpatientVo().getSex() == 0) {
                    sex = "男性";
                } else if (data.getData().getTpatientVo().getSex() == 1) {
                    sex = "女性";
                } else {
                    sex = "未知";
                }
                tvSex.setText(sex);
            }
            // 住院号
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getCureNo())) {
                CureNo = data.getData().getTpatientVo().getCureNo();
                tvCureNo.setText(CureNo);
            }
            // 年龄
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getBirthday())) {
//                age = String.valueOf(CommonUtil.getAgeByBirth(TimeUtils.string2Date(TimeUtils.millis2String(TimeUtils.string2Millis(data.getData().getTpatientVo().getBirthday(), "yyyy-MM-dd"))),
//                        TimeUtils.string2Date(TimeUtils.millis2String(data.getTimestamp().getEpochSecond() * 1000L)))) + "岁";
                age = data.getData().getTpatientVo().getBirthday() + "岁";
                tvAge.setText(age);
            }
            //入院时间
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getAdmissionTime())) {
                AdmissionTime = data.getData().getTpatientVo().getAdmissionTime();
                tvAdmissionTime.setText(AdmissionTime);
            }
            // 医嘱
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTcareLableVoList())) {
                doctorAdviceApadter.setNewData(data.getData().getTpatientVo().getTcareLableVoList());
            }
        }

        // 主治护士
        if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTnurseBrieflyVoList())) {
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTnurseBrieflyVoList().get(0).getName())) {
                DutyNurse = data.getData().getTpatientVo().getTnurseBrieflyVoList().get(0).getName();
                tvDutyNurse.setText(DutyNurse);
            }
        }

        // 主治医生
        if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTdoctorBrieflyVoList())) {
            if (EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getTdoctorBrieflyVoList().get(0).getDoctorName()))
                DutyDoctor = data.getData().getTpatientVo().getTdoctorBrieflyVoList().get(0).getDoctorName();
            tvDutydoctor.setText(DutyDoctor);
        }
        // 床号
        if (EmptyUtils.isNotEmpty(data.getData().getBedNum())) {
            BedNum = data.getData().getBedNum();
            tvBednum.setText(BedNum);
        }
        // 科室信息
        positionName = "";
        if (EmptyUtils.isNotEmpty(data.getData().getTwardVo())) {
            if (EmptyUtils.isNotEmpty(data.getData().getTwardVo().getName())) {
                positionName = positionName + data.getData().getTwardVo().getName();
            }
        }
        // 房间号
        if (EmptyUtils.isNotEmpty(data.getData().getTsickroomVo())) {
            if (EmptyUtils.isNotEmpty(data.getData().getTsickroomVo().getSickroomName())) {
                positionName = positionName + "  " + data.getData().getTsickroomVo().getSickroomName() + "房";
            }
        }

        leftTitle.setText(positionName);
        // 二维码
        String contentQR = Name + "   " + sex + "   " + age + "\n" + "床号： " + BedNum + "\n" + "住院号: " + CureNo + "\n" +
                "入院时间: " + AdmissionTime + "\n" + "主治医生: " + DutyDoctor + "\n" + "责任护士: " + DutyNurse;
        Bitmap b = QRCodeUtil.createQRCodeBitmap(contentQR, 300);
        ivQrcode.setImageBitmap(b);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void connectSuccess() {

    }

    @Override
    public void bedcardGetbedinfoSuccess(BedInfoBean data) {

        BedInfoBeanDb b = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        BedInfoBeanDb bedInfoBeanDb = new BedInfoBeanDb();
        if (b != null) {
            bedInfoBeanDb.setId(b.getId());
            bedInfoBeanDb.setBedInfoBean(data);
            collectionInfoDao.update(bedInfoBeanDb);
        } else {
            bedInfoBeanDb.setId(0L);
            bedInfoBeanDb.setBedInfoBean(data);
            collectionInfoDao.insert(bedInfoBeanDb);
        }
        initData();
    }

    @Override
    public void bedcardGetbedinfoFail() {
//        showFailDialog();
        initData();
    }

    @Override
    public void downAppSuccess() {

    }


    @Override
    public void showError(String message) {

    }

    @OnClick({R.id.iv_right, R.id.rl_dutydoctor, R.id.rl_dutyNurse})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_dutydoctor:  // 主治医生
                if (data != null) {
                    Intent intent = new Intent(this, DutyDoctorActivity.class);
                    intent.putExtra("TYPE", 0);
                    startActivityIn(intent, this);
                }
                break;
            case R.id.rl_dutyNurse:  // 主治护士
                if (data != null) {
                    Intent i = new Intent(this, DutyDoctorActivity.class);
                    i.putExtra("TYPE", 1);
                    startActivityIn(i, this);
                }
                break;
            case R.id.iv_right:
//                toggleRing();
                startActivityIn(new Intent(this, ContentsActivity.class), this);
                break;
        }
    }

    @Override
    protected void initTime(String nowTime) {
        if (actionbarTitle != null) {
            actionbarTitle.setText(nowTime);
        }
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {
        mPresenter.bedcardGetbedinfo(true, "code", Build.SERIAL);
    }

    public void showFailDialog() {
        if (p != null && p.isShowing()) {
            p.dismiss();
        }
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        View inflate = View.inflate(this, R.layout.dialog_connect_fail, null);
        Button btPost = inflate.findViewById(R.id.bt_post);
        Button btClecn = inflate.findViewById(R.id.bt_clecn);
        p = new PopupWindow(inflate, width, height);
        p.showAtLocation(inflate, Gravity.CENTER, 0, 0);
        p.showAsDropDown(inflate, 100, 100);
        btClecn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.dismiss();
            }
        });

        btPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.dismiss();
                startActivityIn(new Intent(MainActivity.this, SettingActivity.class), MainActivity.this);
            }
        });
    }


}
