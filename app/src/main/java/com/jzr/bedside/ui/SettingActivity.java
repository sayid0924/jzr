package com.jzr.bedside.ui;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.bean.CheckDeptBean;
import com.jzr.bedside.bean.DeviceBean;
import com.jzr.bedside.bean.SettingEvenBus;
import com.jzr.bedside.bean.boby.DeviceBoby;
import com.jzr.bedside.broadcastReceiver.NetworkConnectChangedReceiver;
import com.jzr.bedside.broadcastReceiver.NetworkLinten;
import com.jzr.bedside.db.database.BedInfoBeanDbDao;
import com.jzr.bedside.presenter.contract.activity.SettingActivityContract;
import com.jzr.bedside.presenter.impl.activity.SettingActivityPresenter;
import com.jzr.bedside.service.nettyUtils.NettySenMsgListener;
import com.jzr.bedside.ui.apadter.CheckDeptApadter;
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
import com.blankj.utilcode.utils.ToastUtils;
import com.jzr.bedside.view.dialog.CustomDialog;

import org.greenrobot.eventbus.EventBus;

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
    @BindView(R.id.tv_check_dept)
    TextView tvCheckDept;
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
    @BindView(R.id.tv_binding_bedno)
    TextView tvBindingBedno;
    @BindView(R.id.bt_check_dept)
    Button btCheckDept;

    @BindView(R.id.iv_socket_ip)
    ImageView ivSocketIp;

    private WifiManager mWifiManager;
    private SettingActivityPresenter mPresenter = new SettingActivityPresenter();
    private NetworkConnectChangedReceiver networkConnectChangedReceiver;
    private CheckDeptApadter apadter;
    private CustomDialog dialogDeptList;

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
        actionbarTitle.setText(R.string.system_setting);
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


        tvBindingBedno.setText( PreferUtil.getInstance().getDeptName() + " - "+ PreferUtil.getInstance().getRoomName()+ " - "+
                PreferUtil.getInstance().getBedName());

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

        mPresenter.connectTest("deviceNo", Build.SERIAL);
        showWaitingDialog(getString(R.string.connect_test));

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
                if (isChecked) {
                    FloatWindowUtils.getInstance().show();
                } else {
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
        mPresenter.connectTest("deviceNo", Build.SERIAL);
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
        hideWaitingDialog();
        ivServicePort.setBackgroundResource(R.drawable.test_result_fail);
        ivWifiLevel.setVisibility(View.GONE);
        tvWifiInfo.setText("");
    }

    @OnClick({R.id.iv_right, R.id.tv_connecttest, R.id.tv_socket_connecttest,
            R.id.tv_check_dept, R.id.bt_check_dept, R.id.tv_binding_bedno})
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

            case R.id.tv_binding_bedno:
                mPresenter.getDeptCodelist();
//                mPresenter.getBedcardBindtobed();
//                showWaitingDialog(getString(R.string.loading));
                break;
            case R.id.tv_check_dept:
                //  选择科室列表
                mPresenter.getDeptCodelist();
                showWaitingDialog(getString(R.string.loading));
                break;
            case R.id.bt_check_dept:
                //  绑定科室
                String checkDept = tvCheckDept.getText().toString();
                if (checkDept.equals("")) {
                    ToastUtils.showLongToast(R.string.check_dept);
                    break;
                }
                showWaitingDialog(getString(R.string.binding));
                NettyService.setNettySenMsgListener(new NettySenMsgListener() {
                    @Override
                    public void senMegSuccess() {
                        hideWaitingDialog();
                        ToastUtils.showLongToast(R.string.binding_sucess);
                    }

                    @Override
                    public void senMegFail() {
                        hideWaitingDialog();
                        ToastUtils.showLongToast(R.string.binding_fail);
                    }
                });

                NettyService.authenticData();

                break;
            case R.id.tv_connecttest:
                // 网络连接测试
                PreferUtil.getInstance().setBaseUrl(edServiceIp.getText().toString());
                PreferUtil.getInstance().setServerPort(edServicePort.getText().toString());
                mPresenter.connectTest("deviceNo", Build.SERIAL);
                showWaitingDialog(getString(R.string.connect_test));
                break;
            case R.id.tv_socket_connecttest:
                // socket连接测试
                showWaitingDialog(getString(R.string.socker_connecting));
                PreferUtil.getInstance().setSocketPort(edSocketPort.getText().toString());
                PreferUtil.getInstance().setSocketIp(edSocketIp.getText().toString());
                NettyService.connect();
                NettyService.authenticData();

                NettyService.setNettySenMsgListener(new NettySenMsgListener() {
                    @Override
                    public void senMegSuccess() {
                        hideWaitingDialog();
                        ivSocketPort.setBackgroundResource(R.drawable.test_result_sucess);
                        ToastUtils.showLongToast(R.string.socker_connect_sucess);
                    }

                    @Override
                    public void senMegFail() {
                        hideWaitingDialog();
                        ToastUtils.showLongToast(R.string.socker_connect_fail);
                        ivSocketPort.setBackgroundResource(R.drawable.test_result_fail);
                    }
                });

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
    public void connectTestSuccess(CheckDeptBean data) {
        hideWaitingDialog();
        ToastUtils.showLongToast(R.string.connect_sucess);
//        Date nowTime = TimeUtils.string2Date(data.getTimestamp());
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(nowTime);
//        CommonUtil.setAutoDateTime(0, this);
//        CommonUtil.setSysDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.HOUR_OF_DAY),
//                calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND), this);
    }

    @Override
    public void getBedcardBindtobedSuccess(DeviceBean data) {
        hideWaitingDialog();
        ToastUtils.showLongToast(data.getMessage());
         tvBindingBedno.setText( PreferUtil.getInstance().getDeptName() + " - "+ PreferUtil.getInstance().getRoomName()+ " - "+
                 PreferUtil.getInstance().getBedName());
         if (dialogDeptList!=null && dialogDeptList.isShowing())dialogDeptList.dismiss();
    }

    @Override
    public void getDeptCodelistSuccess(CheckDeptBean checkDeptBean) {
        hideWaitingDialog();
        showDeptListDialog(checkDeptBean);
    }

    @Override
    public void getDeptRoomListSuccess(CheckDeptBean checkDeptBean) {
        hideWaitingDialog();
        apadter.setNewData(checkDeptBean.getData());
        apadter.notifyDataSetChanged();

        apadter.onItemClick(new CheckDeptApadter.onItemClick() {
            @Override
            public void onItemClick(CheckDeptBean.DataBean c) {
                PreferUtil.getInstance().setRoomCode(c.getCode());
                PreferUtil.getInstance().setRoomName(c.getName());
                mPresenter.getDeptBealist("deptCode", PreferUtil.getInstance().getDeptCode(),
                        "roomCode", c.getCode());
                showWaitingDialog(getString(R.string.loading));
            }
        });

    }

    @Override
    public void getDeptBedListSuccess(CheckDeptBean checkDeptBean) {
        hideWaitingDialog();
        apadter.setNewData(checkDeptBean.getData());
        apadter.notifyDataSetChanged();
        apadter.onItemClick(new CheckDeptApadter.onItemClick() {
            @Override
            public void onItemClick(CheckDeptBean.DataBean c) {

                DeviceBoby deviceBoby = new DeviceBoby();
                deviceBoby.setDeviceMac(DeviceUtils.getMacAddress());
                deviceBoby.setAppVersion(AppUtils.getAppVersionName(SettingActivity.this));
                deviceBoby.setDeviceIp(CommonUtil.getIP());
                deviceBoby.setDeviceNo(Build.SERIAL);
                deviceBoby.setDeviceType(0);
                deviceBoby.setRegisterBed(String.valueOf(c.getId()));
                deviceBoby.setNurseboardIp(edLookIp.getText().toString().trim());
                mPresenter.getBedcardBindtobed(deviceBoby);
                PreferUtil.getInstance().setBedcode(String.valueOf(c.getId()));
                PreferUtil.getInstance().setBedName(c.getName());
                showWaitingDialog(getString(R.string.binding));

            }
        });
    }

    @Override
    public void showError(String message) {
        hideWaitingDialog();
        ToastUtils.showLongToast(message);
    }


    public void showDeptListDialog(CheckDeptBean checkDeptBean) {
        hideWaitingDialog();

        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_dept_list, null);
        RecyclerView rvDeptList = view.findViewById(R.id.rv_dept_list);

        apadter = new CheckDeptApadter(checkDeptBean.getData(), this);
        rvDeptList.setLayoutManager(new LinearLayoutManager(this));
        rvDeptList.setAdapter(apadter);
         dialogDeptList = new CustomDialog(this, view, R.style.MyDialog);
        dialogDeptList.setCancelable(true);
        dialogDeptList.show();
        apadter.onItemClick(new CheckDeptApadter.onItemClick() {
            @Override
            public void onItemClick(CheckDeptBean.DataBean item) {
                PreferUtil.getInstance().setDeptCode(item.getCode());
                PreferUtil.getInstance().setDeptName(item.getName());
                mPresenter.getDeptRoomlist("deptCode", item.getCode());
                showWaitingDialog(getString(R.string.loading));
            }
        });
    }
}
