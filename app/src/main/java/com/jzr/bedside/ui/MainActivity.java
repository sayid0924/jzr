package com.jzr.bedside.ui;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
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
import com.blankj.utilcode.utils.DeviceUtils;
import com.blankj.utilcode.utils.FileUtils;
import com.blankj.utilcode.utils.ThreadPoolUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.blankj.utilcode.utils.Utils;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.base.Constant;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.SettingEvenBus;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.MainContract;
import com.jzr.bedside.presenter.impl.activity.MainActivityPresenter;
import com.jzr.bedside.service.KeepLiveService;
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
import com.jzr.bedside.utils.listener.DemoBeautyCallback;
import com.jzr.bedside.utils.listener.XHChatManagerListener;
import com.jzr.bedside.utils.listener.XHGroupManagerListener;
import com.jzr.bedside.utils.listener.XHLoginManagerListener;
import com.jzr.bedside.utils.listener.XHVoipManagerListener;
import com.jzr.bedside.utils.listener.XHVoipP2PManagerListener;
import com.medxing.sdk.resolve.IrtResolve;
import com.medxing.sdk.resolve.ResolveManager;
import com.orhanobut.logger.Logger;
import com.starrtc.starrtcsdk.api.XHClient;
import com.starrtc.starrtcsdk.api.XHCustomConfig;
import com.starrtc.starrtcsdk.apiInterface.IXHErrorCallback;
import com.starrtc.starrtcsdk.apiInterface.IXHResultCallback;
import com.starrtc.starrtcsdk.core.beauty.XHBeautyManager;

import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements MainContract.View {


    private DoctorAdviceApadter doctorAdviceApadter;
    private List<BedInfoBean.DataBean.CareLabelListBean> doctorAdvicesData = new ArrayList<>();
    private MainActivityPresenter mPresenter = new MainActivityPresenter();
    private BedInfoBeanDbDao collectionInfoDao;
    public BedInfoBean data;
    private String sex, age, Name, BedNum, CureNo, AdmissionTime, DutyDoctor, DutyNurse, positionName;

    private ThreadPoolUtils timeTaskExecutor = new ThreadPoolUtils(ThreadPoolUtils.Type.FixedThread, 3);

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

    @SuppressLint("HandlerLeak")
    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    if (actionbarTitle != null) {
                        actionbarTitle.setText(TimeUtils.getNowTimeString("EEEE yyyy-MM-dd HH:mm:ss"));
                    }
                    break;
            }
        }
    };

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
        ivBack.setBackgroundResource(R.drawable.jzr_logo_n);
        leftTitle.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        leftTitle.setText("金之瑞科技有限公司");

        doctorAdviceApadter = new DoctorAdviceApadter(doctorAdvicesData, this);
        rvDoctorAdvice.setLayoutManager(new LinearLayoutManager(this));
        rvDoctorAdvice.setAdapter(doctorAdviceApadter);

        startService(new Intent().setComponent(new ComponentName("com.bben.bedside",
                "com.bben.bedside.service.StartCommandService")));

        startService(new Intent(this, NettyService.class));
//        startService(new Intent(this, RabbitMQService.class));
        bedcardGetbedinfo();

        timeTaskExecutor.scheduleWithFixedDelay(TimeTask(), 0, 1, TimeUnit.SECONDS);

        mainActivity = this;

        startService();

    }

    private void startService(){
        Intent intent = new Intent(this, KeepLiveService.class);
        startService(intent);
    }

    public Runnable TimeTask() {
        return new Runnable() {
            @Override
            public void run() {
                Message message = mHandler.obtainMessage();
                message.what = 1;
                mHandler.sendMessage(message);
            }
        };
    }

    public void bedcardGetbedinfo() {
        mPresenter.bedcardGetbedinfo("deviceNo", Build.SERIAL);
        showWaitingDialog(getString(R.string.loading));
    }

    public void  downApp(String url){
        mPresenter.downApp(this,url, Constant.path);
        showWaitingDialog("正在升级中....");
    }

    @SuppressLint("SetTextI18n")
    private void initData() {

        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            data = infoBeanDb.getBedInfoBean();
            if (EmptyUtils.isNotEmpty(data.getData())) {
//                if(EmptyUtils.isNotEmpty(data.getData().getTpatientVo().getDeptId())){
//                     String title = data.getData().getTpatientVo().getDeptId();
//                     leftTitle.setText(title);
//                 }
                // 姓名
                if (EmptyUtils.isNotEmpty(data.getData().getName())) {
                    Name = data.getData().getName();
                   String dd = CommonUtil.replaceString2Star(Name,1,1);
                    tvName.setText(dd);
                }
                // 性别
                if (EmptyUtils.isNotEmpty(data.getData().getSex())) {
                    if (data.getData().getSex() == 0) {
                        sex = "男性";
                    } else if (data.getData().getSex() == 1) {
                        sex = "女性";
                    } else {
                        sex = "未知";
                    }
                    tvSex.setText(data.getData().getSexText());
                }
                // 住院号
                if (EmptyUtils.isNotEmpty(data.getData().getCureNo())) {
                    CureNo = data.getData().getCureNo();
                    tvCureNo.setText(CureNo);
                }
                // 年龄
                if (EmptyUtils.isNotEmpty(data.getData().getAge())) {
//                    age = String.valueOf(CommonUtil.getAgeByBirth(TimeUtils.string2Date(TimeUtils.millis2String(TimeUtils.string2Millis(data.getData().getTpatientVo().getBirthday(), "yyyy-MM-dd"))),
//                           TimeUtils.string2Date(TimeUtils.millis2String(data.getTimestamp().getEpochSecond() * 1000L)))) + "岁";
                    age = data.getData().getAge() ;
                    tvAge.setText(age);
                }
                //入院时间
                if (EmptyUtils.isNotEmpty(data.getData().getInTime())) {
                    AdmissionTime = data.getData().getInTime();
                    tvAdmissionTime.setText(AdmissionTime);
                }
                // 医嘱
                if (EmptyUtils.isNotEmpty(data.getData().getCareLabelList())) {
                    doctorAdviceApadter.setNewData(data.getData().getCareLabelList());
                    doctorAdviceApadter.notifyDataSetChanged();
                }
                // 主治护士
                if (EmptyUtils.isNotEmpty(data.getData().getNurseName())) {
                    if (EmptyUtils.isNotEmpty(data.getData().getNurseName())) {
                        DutyNurse = data.getData().getNurseName();
                        tvDutyNurse.setText(DutyNurse);
                    }
                }
                // 主治医生
                if (EmptyUtils.isNotEmpty(data.getData().getDoctorName())) {
                    if (EmptyUtils.isNotEmpty(data.getData().getDoctorName()))
                        DutyDoctor = data.getData().getDoctorName();
                    tvDutydoctor.setText(DutyDoctor);
                }
                // 床号
                if (EmptyUtils.isNotEmpty(data.getData().getBedName())) {
                    BedNum = data.getData().getBedName();
                    tvBednum.setText(BedNum);
                }
            }else {
                tvName.setText("");
                tvSex.setText("");
                tvCureNo.setText("");
                tvAge.setText("");
                tvAdmissionTime.setText("");
                doctorAdviceApadter.setNewData(null);
                doctorAdviceApadter.notifyDataSetChanged();
                tvDutyNurse.setText("");
                tvDutydoctor.setText("");
                tvBednum.setText("");
            }

            // 科室信息
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
//            leftTitle.setText(positionName);
            // 二维码
            String contentQR = Name + "   " + sex + "   " + age + "\n" + "床号： " + BedNum + "\n" + "住院号: " + CureNo + "\n" +
                    "入院时间: " + AdmissionTime + "\n" + "主治医生: " + DutyDoctor + "\n" + "责任护士: " + DutyNurse;
            Bitmap b = QRCodeUtil.createQRCodeBitmap(contentQR, 300);
            ivQrcode.setImageBitmap(b);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void bedcardGetbedinfoSuccess(BedInfoBean data) {
        hideWaitingDialog();
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
    public void downAppSuccess() {
      hideWaitingDialog();
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
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
                startActivityIn(new Intent(this, ContentsActivity.class), this);
                break;
        }
    }

    @Subscribe
    public void getEventBus(SettingEvenBus settingEvenBus) {
        bedcardGetbedinfo();
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
