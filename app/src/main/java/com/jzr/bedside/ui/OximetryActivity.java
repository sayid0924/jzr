package com.jzr.bedside.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andy.ecgviewlib.EcgViewInterface;
import com.andy.ecgviewlib.EcgWaveView;
import com.blankj.utilcode.utils.ToastUtils;
import com.inuker.bluetooth.library.BluetoothClient;
import com.inuker.bluetooth.library.beacon.Beacon;
import com.inuker.bluetooth.library.connect.response.BleConnectResponse;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.response.SearchResponse;
import com.inuker.bluetooth.library.utils.BluetoothLog;
import com.jzr.bedside.R;
import com.jzr.bedside.base.BaseActivity;
import com.jzr.bedside.base.BaseApplication;
import com.jzr.bedside.bean.EvenBusColos;
import com.jzr.bedside.service.bluetooth.BluetoothLEService;
import com.jzr.bedside.ui.apadter.BlueDeviceApadter;
import com.jzr.bedside.view.DialProgress;
import com.jzr.bedside.view.RoundIndicatorView;
import com.jzr.bedside.view.dialog.CustomDialog;
import com.medxing.sdk.resolve.BluetoothCMD;
import com.medxing.sdk.resolve.IrtResolve;
import com.medxing.sdk.resolve.ResolveManager;
import com.medxing.sdk.resolve.Spo2PackageData;
import com.medxing.sdk.resolve.Spo2PackageHRV;
import com.medxing.sdk.resolve.Spo2PackageWave;
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
 * 红外体温计
 */
public class OximetryActivity extends BaseActivity {


    private ResolveManager resolveManager;
    private BluetoothLEService bluetoothLEService;
    private BlueDeviceApadter apadter;
    private List<SearchResult> bleDevices = new ArrayList<>();
    private CustomDialog mDialog;
    private boolean Start=false;

    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.iv_right_back)
    ImageView ivRightBack;
    @BindView(R.id.left_title)
    TextView leftTitle;
    @BindView(R.id.actionbar_title)
    TextView actionbarTitle;
    @BindView(R.id.tv_serach_device)
    TextView tvSerachDevice;

    @BindView(R.id.ll_device)
    LinearLayout llDevice;
    @BindView(R.id.ll_bar)
    LinearLayout llBar;

    @BindView(R.id.rv_device)
    RecyclerView rvDevice;

    @BindView(R.id.rl_pd)
    RelativeLayout rlPd;
    @BindView(R.id.but_start)
    Button butStart;
    @BindView(R.id.circle_progress_bar)
    DialProgress progressBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_oximetry;
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
        actionbarTitle.setText("红外体温计");

        llDevice.setVisibility(View.VISIBLE);
        llBar.setVisibility(View.GONE);
        apadter = new BlueDeviceApadter(bleDevices, this);
        rvDevice.setLayoutManager(new LinearLayoutManager(this));
        rvDevice.setAdapter(apadter);

        apadter.onItemClick(new BlueDeviceApadter.onItemClick() {
            @Override
            public void onItemClick(SearchResult bleDevices) {
                if(bleDevices.getName().equals(getString(R.string.string_device_irt))){
                    showDidlog("正在配对中 请稍等......");
                    bluetoothLEService.connectBleForMac(bleDevices.getAddress(), new BleConnectResponse() {
                        @Override
                        public void onResponse(int code, BleGattProfile data) {
                            switch (code) {
                                case REQUEST_SUCCESS:
                                    showDidlog("配对成功.....");
                                    if (bluetoothLEService.checkChipType(data) > -1) {
                                        llDevice.setVisibility(View.GONE);
                                        llBar.setVisibility(View.VISIBLE);
                                        bluetoothLEService.writeCharacter(BluetoothCMD.IRT_BLE_START_ARRAY);
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
        resolveManager.setOnIrtResolveListener(new ResolveManager.OnIrtResolveListener() {
            @Override
            public void onIrtResolve(IrtResolve irtResolve) {
                Logger.e(irtResolve.toString());
                if(irtResolve.getType().equals(IrtResolve.IRT_TYPE_MEASURED)){
                    //测量完成
                    Start = false;
                    butStart.setText("重新测量");
                }
                if (irtResolve.getType().equals(IrtResolve.IRT_TYPE_MEASURE)){
                    Start = true;
                    progressBar.setValue(irtResolve.getTemperature());
                }
            }
        });
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

    @OnClick({R.id.iv_right_back, R.id.iv_right,R.id.but_start})
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
                if(!Start){
                    progressBar.setValue(0);
                    bluetoothLEService.writeCharacter(BluetoothCMD.IRT_BLE_START_ARRAY);
                }else {
                    ToastUtils.showLongToast("正在测量中 ..... ");
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
            if (i == 0) {
                //  Toast.makeText(getApplication(),"时间：" + t + "ms/格",Toast.LENGTH_SHORT).show();
            } else if (i == 1) {
                //   Toast.makeText(getApplication(),"电压："+t+"mv/格",Toast.LENGTH_SHORT).show();
            }
        }
    };
}
