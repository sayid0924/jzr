package com.jzr.bedside.ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.bean.BedInfoBean;
import com.jzr.bedside.bean.SettingEvenBus;
import com.jzr.bedside.broadcastReceiver.NetworkConnectChangedReceiver;
import com.jzr.bedside.broadcastReceiver.NetworkLinten;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.db.entity.BedInfoBeanDb;
import com.jzr.bedside.presenter.contract.activity.SettingActivityContract;
import com.jzr.bedside.presenter.impl.activity.SettingActivityPresenter;
import com.jzr.bedside.utils.AreaClickListener;
import com.jzr.bedside.utils.CommonUtil;
import com.jzr.bedside.utils.FloatWindowUtils;
import com.jzr.bedside.utils.GreenDaoUtil;
import com.jzr.bedside.utils.Permission;
import com.jzr.bedside.utils.PreferUtil;
import com.jzr.bedside.service.nettyUtils.NettyClient;
import com.jzr.bedside.service.nettyUtils.NettyService;
import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.DeviceUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.TimeUtils;
import com.blankj.utilcode.utils.ToastUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingActivity extends BaseActivity implements SettingActivityContract.View, NetworkLinten {

    private BedInfoBeanDbDao collectionInfoDao;

    @BindView(R.id.tv_connecttest)
    TextView tvConnecttest;
    @BindView(R.id.tv_socket_connecttest)
    TextView tvSocketConnecttest;

    @BindView(R.id.iv_service_port)
    ImageView ivServicePort;
    @BindView(R.id.iv_socket_port)
    ImageView ivSocketPort;
    @BindView(R.id.tv_wifi_info)
    TextView tvWifiInfo;
    @BindView(R.id.iv_wifi_level)
    ImageView ivWifiLevel;

    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.rl_info)
    RelativeLayout rlInfo;
    @BindView(R.id.iv_right)
    ImageView ivRight;

    @BindView(R.id.switch_wifi)
    Switch switchWifi;


    @BindView(R.id.switch_logcat)
    Switch switchLogcat;

    @BindView(R.id.tv_version)
    TextView tvVersion;
    @BindView(R.id.tv_sn_info)
    TextView tvSnInfo;
    @BindView(R.id.tv_ip_info)
    TextView tvIpInfo;
    @BindView(R.id.tv_location_info)
    TextView tvLocationInfo;
    @BindView(R.id.tv_version_info)
    TextView tvVersionInfo;
    @BindView(R.id.tv_mac_info)
    TextView tvMacInfo;
    @BindView(R.id.ed_service_ip)
    EditText edServiceIp;
    @BindView(R.id.ed_service_port)
    EditText edServicePort;
    @BindView(R.id.ed_socket_port)
    EditText edSocketPort;
    @BindView(R.id.ed_socket_ip)
    EditText edSocketIp;
    @BindView(R.id.ed_look_ip)
    EditText edLookIp;

    @BindView(R.id.iv_socket_ip)
    ImageView ivSocketIp;

    private WifiManager mWifiManager;
    private SettingActivityPresenter mPresenter = new SettingActivityPresenter(this);
    private NetworkConnectChangedReceiver networkConnectChangedReceiver;
    private BedInfoBean data;
    private InputStream is;

    @Override
    public int getLayoutId() {
        return R.layout.activity_setting;
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

        collectionInfoDao = GreenDaoUtil.getDaoSession().getBedInfoBeanDbDao();
        mWifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        actionbarTitle.setText("系统设置");
        tvSnInfo.setText(Build.SERIAL);
        tvIpInfo.setText(CommonUtil.getIP());
        tvMacInfo.setText(DeviceUtils.getMacAddress());
        tvVersionInfo.setText(AppUtils.getAppVersionName(this));

        edSocketPort.setText(PreferUtil.getInstance().getSoketPort());
        edServicePort.setText(PreferUtil.getInstance().getServerPort());
        edServiceIp.setText(PreferUtil.getInstance().getBaseUrl());
        edSocketIp.setText(PreferUtil.getInstance().getSoketIp());
        edLookIp.setText(PreferUtil.getInstance().getLookIp());
        switchLogcat.setChecked(FloatWindowUtils.isShow);
        rlInfo.setOnClickListener(new AreaClickListener(5, 500, new AreaClickListener.ClickEvent() {
            @Override
            public void onEvent() {
                startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        }));

        ivBack.setVisibility(View.GONE);
        ivRight.setVisibility(View.VISIBLE);
        if (NettyClient.getInstance().getConnectStatus()) {
            ivSocketPort.setBackgroundResource(R.drawable.test_result_sucess);
        } else {
            ivSocketPort.setBackgroundResource(R.drawable.test_result_fail);
        }

        mPresenter.connectTest("code", Build.SERIAL);

        mPresenter.bedcardGetbedinfo("code", Build.SERIAL);

        if (NetworkUtils.isWifiConnected()) {
            switchWifi.setChecked(true);
            tvWifiInfo.setText(CommonUtil.getWifiInfo(this));
            switch (CommonUtil.getWifiLevel(this)) {
                case 0:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_3);
                    break;
                case 1:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_2);
                    break;
                case 2:
                    ivWifiLevel.setBackgroundResource(R.drawable.wifi_1);
                    break;
            }
        } else {
            switchWifi.setChecked(false);
        }

        switchWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mWifiManager.setWifiEnabled(isChecked);
            }
        });

        switchLogcat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    FloatWindowUtils.getInstance().show();
                }else {
                   FloatWindowUtils.getInstance().destroy();
                }
            }
        });

        IntentFilter filter = new IntentFilter();
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION);
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION);
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);

        networkConnectChangedReceiver = new NetworkConnectChangedReceiver();
        networkConnectChangedReceiver.setNetworkLinten(this);
        registerReceiver(networkConnectChangedReceiver, filter);
        Permission.requestPermission(this);

    }




    @Override
    protected void onDestroy() {
        super.onDestroy();

        PreferUtil.getInstance().setIsFirst(true);
        EventBus.getDefault().post(new SettingEvenBus());
        unregisterReceiver(networkConnectChangedReceiver);
    }

    /**
     * 网络连接成功
     */
    @Override
    public void ConnectedSuccess() {
        mPresenter.connectTest("code", Build.SERIAL);
        ivWifiLevel.setVisibility(View.VISIBLE);
        tvWifiInfo.setText(CommonUtil.getWifiInfo(this));
        tvIpInfo.setText(CommonUtil.getIP());
        switch (CommonUtil.getWifiLevel(this)) {
            case 0:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_3);
                break;
            case 1:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_2);
                break;
            case 2:
                ivWifiLevel.setBackgroundResource(R.drawable.wifi_1);
                break;
        }
    }

    /**
     * 网络连接失败
     */
    @Override
    public void ConnectedFail() {
        ivServicePort.setBackgroundResource(R.drawable.test_result_fail);
        ivWifiLevel.setVisibility(View.GONE);
        tvWifiInfo.setText("");
    }

    @OnClick({R.id.iv_right, R.id.tv_connecttest, R.id.tv_socket_connecttest})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right:
                PreferUtil.getInstance().setBaseUrl(edServiceIp.getText().toString());
                PreferUtil.getInstance().setServerPort(edServicePort.getText().toString());

                PreferUtil.getInstance().setSocketPort(edSocketPort.getText().toString());
                PreferUtil.getInstance().setSocketIp(edSocketIp.getText().toString());

                PreferUtil.getInstance().setLookIp(edLookIp.getText().toString());

                finish();
                break;
            case R.id.tv_connecttest:
                // 网络连接测试
                PreferUtil.getInstance().setBaseUrl(edServiceIp.getText().toString());
                PreferUtil.getInstance().setServerPort(edServicePort.getText().toString());
                mPresenter.connectTest("code", Build.SERIAL);

                break;
            case R.id.tv_socket_connecttest:
                // socket连接测试
                showWaitingDialog("Socket连接....");
                PreferUtil.getInstance().setSocketPort(edSocketPort.getText().toString());
                PreferUtil.getInstance().setSocketIp(edSocketIp.getText().toString());
                NettyService.connect();
                BaseApplication.MAIN_EXECUTOR.schedule(new Runnable() {
                    @Override
                    public void run() {
                        hideWaitingDialog();
                        if (NettyClient.getInstance().getConnectStatus()) {
                            ivSocketPort.setBackgroundResource(R.drawable.test_result_sucess);
                            ToastUtils.showLongToast("Socket连接测试成功");
                        } else {
                            ToastUtils.showLongToast("Socket连接测试失败");
                            ivSocketPort.setBackgroundResource(R.drawable.test_result_fail);
                        }
                    }
                }, 10, TimeUnit.SECONDS);

                break;
        }
    }

    @Override
    public TextView getTvLocation() {
        return tvLocationInfo;
    }

    @Override
    public ImageView getIvServicePort() {
        return ivServicePort;
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
            bedInfoBeanDb.setId(Long.valueOf(0));
            bedInfoBeanDb.setBedInfoBean(data);
            collectionInfoDao.insert(bedInfoBeanDb);
        }
        initData();
    }

    private void initData() {

        BedInfoBeanDb infoBeanDb = collectionInfoDao.queryBuilder().where(
                BedInfoBeanDbDao.Properties.Id.eq(0)).unique();
        if (infoBeanDb != null) {
            data = infoBeanDb.getBedInfoBean();

            String title = data.getData().getTwardVo().getName() + "  " +
                    data.getData().getTpatientVo().getDeptId() + "  " +
                    data.getData().getTsickroomVo().getSickroomName();

            tvLocationInfo.setText(title);

        }
    }

    @Override
    public void connectTestSuccess(BedInfoBean data) {
        Date nowTime = TimeUtils.string2Date(TimeUtils.millis2String(data.getTimestamp().getEpochSecond() * 1000L));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowTime);
        CommonUtil.setAutoDateTime(0, this);
        CommonUtil.setSysDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), this);
    }

    @Override
    public void showError(String message) {

    }

}
