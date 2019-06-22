package com.jzr.bedside.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andy.ecgviewlib.EcgViewInterface;
import com.blankj.utilcode.utils.ToastUtils;
import com.inuker.bluetooth.library.connect.response.BleConnectResponse;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.search.SearchResult;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.service.bluetooth.BluetoothLEService;
import com.jzr.bedside.ui.apadter.BlueDeviceApadter;
import com.jzr.bedside.view.WaveProgress;
import com.jzr.bedside.view.dialog.CustomDialog;
import com.jzr.bedside.view.tv.RiseNumberTextView;
import com.medxing.sdk.resolve.BluetoothCMD;
import com.medxing.sdk.resolve.NibpResolve;
import com.medxing.sdk.resolve.ResolveManager;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.inuker.bluetooth.library.Constants.REQUEST_FAILED;
import static com.inuker.bluetooth.library.Constants.REQUEST_SUCCESS;
import static com.inuker.bluetooth.library.Constants.REQUEST_TIMEDOUT;

/**
 * 测量血压仪
 */
public class BloodPressureActivity extends BaseActivity {

    private ResolveManager resolveManager;
    private BluetoothLEService bluetoothLEService;
    private BlueDeviceApadter apadter;
    private List<SearchResult> bleDevices = new ArrayList<>();
    private CustomDialog mDialog;
    private boolean Start = false;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;

    @BindView(R.id.ll_device)
    LinearLayout llDevice;
    @BindView(R.id.ll_dash)
    FrameLayout llDash;
    @BindView(R.id.cv_bot)
    CardView cvBot;
    @BindView(R.id.wave_progress_bar)
    WaveProgress waveBar;
    @BindView(R.id.but_start)
    Button butStart;
    @BindView(R.id.rv_device)
    RecyclerView rvDevice;

    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_pulse)
    TextView tvPulse;
    @BindView(R.id.tv_dbp)
    TextView tvDbp;
    @BindView(R.id.tv_sbp)
    TextView tvSbp;

    @BindView(R.id.tv_pressure)
    RiseNumberTextView tvPressure;

    @BindView(R.id.tv_serach_device)
    TextView tvSerachDevice;
    @BindView(R.id.rl_pd)
    RelativeLayout rlPd;

    @Override
    public int getLayoutId() {
        return R.layout.activity_blood_pressure;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void detachView() {

    }

    @Override
    public void initView() {

        leftTitle.setVisibility(View.GONE);
        ivRightBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        actionbarTitle.setText("測量血压仪");

        llDevice.setVisibility(View.VISIBLE);
        llDash.setVisibility(View.GONE);
        cvBot.setVisibility(View.GONE);
        tvPressure.withNumber(0);
        apadter = new BlueDeviceApadter(bleDevices, this);
        rvDevice.setLayoutManager(new LinearLayoutManager(this));
        rvDevice.setAdapter(apadter);

        apadter.onItemClick(new BlueDeviceApadter.onItemClick() {
            @Override
            public void onItemClick(SearchResult bleDevices) {
                if(bleDevices.getName().equals(getString(R.string.string_device_nibp))){
                    showDidlog("正在配对中 请稍等......");
                    bluetoothLEService.connectBleForMac(bleDevices.getAddress(), new BleConnectResponse() {
                        @Override
                        public void onResponse(int code, BleGattProfile data) {
                            switch (code) {
                                case REQUEST_SUCCESS:
                                    showDidlog("配对成功.....");
                                    if (bluetoothLEService.checkChipType(data) > -1) {
                                        llDevice.setVisibility(View.GONE);
                                        llDash.setVisibility(View.VISIBLE);
                                        cvBot.setVisibility(View.VISIBLE);
                                        waveBar.setMaxValue(300);
                                        waveBar.setValue(0);
                                        hideDialog();

                                    } else {
//                                    Toast.makeText(DeviceActivity.this,"蓝牙芯片类型读取失败",Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case REQUEST_FAILED:
                                    break;
                                case REQUEST_TIMEDOUT:
                                    break;
                            }
                        }
                    });
                }else {
                    ToastUtils.showLongToast("设备不匹配");
                }
            }
        });

        if (bluetoothLEService == null) {
            Intent bluetoothIntent = new Intent(this, BluetoothLEService.class);
            bindService(bluetoothIntent, bluetoothServiceConnection, BIND_AUTO_CREATE);
        }

        resolveManager = ResolveManager.getInstance(this);
        resolveManager.setOnNibpResolveListener(new ResolveManager.OnNibpResolveListener() {
            @Override
            public void onNibpResolve(NibpResolve nibpResolve) {
//                Logger.e("nibpResolve:   >>>>     " + nibpResolve.toString());
                if (nibpResolve.getType().equals(NibpResolve.NIBP_TYPE_MEASURE)) {
                    //测量中
                    waveBar.setValue(nibpResolve.getPressure());
                    tvPressure.withNumber(nibpResolve.getPressure()).start();
                    butStart.setText("测量中...");
                    Start = true;

                }
                if (nibpResolve.getType().equals(NibpResolve.NIBP_TYPE_MEASURED)) {
                    //测量完成
                    tvDate.setText(com.blankj.utilcode.utils.TimeUtils.getNowTimeString());
                    tvDbp.setText(String.valueOf(nibpResolve.getDbp()));
                    tvPulse.setText(String.valueOf(nibpResolve.getPulse()));
                    tvSbp.setText(String.valueOf(nibpResolve.getSbp()));
                    butStart.setText("重新测量...");
                    Start = false;
                    tvPressure.withNumber(nibpResolve.getPressure()).start();
                }
//                id_nibp_test.setText(nibpResolve.toString());
            }
        });

        waveBar.setValue(50);

    }

    /**
     * 打开蓝牙服务
     */
    private ServiceConnection bluetoothServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName arg0, IBinder service) {
            bluetoothLEService = ((BluetoothLEService.LocalBinder) service).getService();
            bluetoothLEService.onFindDeviceListener(new BluetoothLEService.onFindDeviceListener() {
                @Override
                public void onFindDeviceListener(List<SearchResult> bleDevices) {
                    rlPd.setVisibility(View.GONE);
                    tvSerachDevice.setText("扫描结束");
                    apadter.setNewData(bleDevices);
                    apadter.notifyDataSetChanged();
                }
            });

            bluetoothLEService.onNotify(new BluetoothLEService.onNotify() {
                @Override
                public void onNotify(byte[] value) {
                    resolveManager.pushData(value);
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
//            bluetoothService = null;
//            id_device_not_find.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeService();
        if (resolveManager != null)
            resolveManager.close();
    }

    private void closeService() {
        if (bluetoothLEService != null) {
            unbindService(bluetoothServiceConnection);
            // mBluetoothLEService.Disconnect();
            bluetoothLEService = null;
        }
    }

    @OnClick({R.id.iv_right_back, R.id.iv_right, R.id.but_start})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_right_back:
                finish();
                break;
            case R.id.iv_right:
                EventBus.getDefault().post(new EvenBusColos());
                finish();
                break;
            case R.id.but_start:
                if (Start) {
                    ToastUtils.showLongToast("正在测量中  ");
                } else {
                    bluetoothLEService.writeCharacter(BluetoothCMD.NIBP_BLE_START_ARRAY);
                }
                break;
        }
    }

    /**
     *
     */
    public void showDidlog(String text) {
        hideDialog();
        View view = View.inflate(BaseApplication.getContext(), R.layout.dialog_blue_connect, null);
        TextView tvState = view.findViewById(R.id.tv_state);
        tvState.setText(text);
        mDialog = new CustomDialog(this, view, R.style.MyDialog);
        mDialog.show();
        mDialog.setCancelable(false);
        mDialog.show();
    }

    /**
     * 隐藏等待提示框
     */
    public void hideDialog() {
        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    private EcgViewInterface ecgViewListener = new EcgViewInterface() {
        @Override
        public void onError(Exception e) {

        }

        @Override
        public void onShowMessage(String t, int i) {
//            Log.i("tag", "心电接口回调--》" + t);
            if (i == 0) {
                //  Toast.makeText(getApplication(),"时间：" + t + "ms/格",Toast.LENGTH_SHORT).show();
            } else if (i == 1) {
                //   Toast.makeText(getApplication(),"电压："+t+"mv/格",Toast.LENGTH_SHORT).show();
            }
        }
    };
}
