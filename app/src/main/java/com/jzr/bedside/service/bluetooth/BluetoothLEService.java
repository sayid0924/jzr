package com.jzr.bedside.service.bluetooth;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.inuker.bluetooth.library.BluetoothClient;
import com.inuker.bluetooth.library.connect.listener.BleConnectStatusListener;
import com.inuker.bluetooth.library.connect.options.BleConnectOptions;
import com.inuker.bluetooth.library.connect.response.BleConnectResponse;
import com.inuker.bluetooth.library.connect.response.BleNotifyResponse;
import com.inuker.bluetooth.library.connect.response.BleUnnotifyResponse;
import com.inuker.bluetooth.library.connect.response.BleWriteResponse;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.search.SearchRequest;
import com.inuker.bluetooth.library.search.SearchResult;
import com.inuker.bluetooth.library.search.response.SearchResponse;
import com.medxing.sdk.resolve.TypeCastUtil;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Logger;

import static com.inuker.bluetooth.library.Constants.REQUEST_SUCCESS;
import static com.inuker.bluetooth.library.Constants.STATUS_CONNECTED;
import static com.inuker.bluetooth.library.Constants.STATUS_DEVICE_CONNECTING;
import static com.inuker.bluetooth.library.Constants.STATUS_DEVICE_DISCONNECTING;
import static com.inuker.bluetooth.library.Constants.STATUS_DISCONNECTED;
import static com.inuker.bluetooth.library.Constants.STATUS_UNKNOWN;

public class BluetoothLEService extends Service {

    private BluetoothClient mClient;
    private SearchRequest request;
    private onFindDeviceListener onFindDeviceListener = null;
    private  onSearchStoppedDeviceListener onSearchStoppedDeviceListener = null;
    private  onNotify onNotify =null;
    private Set<SearchResult> deviceList = null;//搜索到的蓝牙设备
    private final IBinder binder = new LocalBinder(); // 服务绑定器
    private BluetoothChipType bluetoothChipType = new BluetoothChipType();


    /**
     * 配置服务连接监听器类
     */
    public class LocalBinder extends Binder {
        public BluetoothLEService getService() {
            return BluetoothLEService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    @Override
    public void onCreate() {
        if (mClient == null) {
            mClient = new BluetoothClient(this);
        }
        if (request == null) {
            request = new SearchRequest.Builder()
                    .searchBluetoothLeDevice(3000, 3)   // 先扫BLE设备3次，每次3s
                    .build();
        }

        mClient.search(request, new SearchResponse() {

            @Override
            public void onSearchStarted() {//开始搜素
                deviceList = new HashSet<>();
            }

            @Override
            public void onDeviceFounded(SearchResult device) {//找到设备 可通过manufacture过滤

                if (device.getName().toUpperCase().contains("MEDXING")) {
                    deviceList.add(device);
                    if (onFindDeviceListener != null) {
                        onFindDeviceListener.onFindDeviceListener(getDeviceList());
                    }
                }
            }

            @Override
            public void onSearchStopped() {//搜索停止

            }

            @Override
            public void onSearchCanceled() {//搜索取消

            }
        });


    }

    /**
     * 获取搜索到的蓝牙设备
     */
    public List<SearchResult> getDeviceList() {

        List<SearchResult> list = new ArrayList<>();
        list.addAll(deviceList);
        return list;
    }

    /**
     * 设备配对
     */
    public void connectBleForMac(String mac, BleConnectResponse bleConnectResponse){
        BleConnectOptions options = new BleConnectOptions.Builder()
                .setConnectRetry(3)
                .setConnectTimeout(30000)
                .setServiceDiscoverRetry(3)
                .setServiceDiscoverTimeout(20000)
                .build();
        bluetoothChipType.setMAC(mac);
        mClient.connect(mac,options,bleConnectResponse);
        mClient.registerConnectStatusListener(mac, mBleConnectStatusListener);
    }

    /**
     * 蓝牙配对状态监听
     * 连接或者断开连接
     */
    private final BleConnectStatusListener mBleConnectStatusListener = new BleConnectStatusListener() {
        @Override
        public void onConnectStatusChanged(String mac, int status) {
            if (status == STATUS_CONNECTED){

            }else if (status == STATUS_DEVICE_CONNECTING){

            }else if (status == STATUS_DEVICE_DISCONNECTING){
//                Intent intent1 = new Intent(BLUETOOTH_DEVICES_DISCONNECTED);
//                sendBroadcast(intent1);
            }else if (status == STATUS_DISCONNECTED){
                bluetoothChipType = new BluetoothChipType();
//                Intent intent1 = new Intent(BLUETOOTH_DEVICES_DISCONNECTED);
//                sendBroadcast(intent1);
            }else if (status == STATUS_UNKNOWN){

            }

        }
    };

    @Override
    public void onDestroy() {
        closeNotify();
        mClient = null;
        request = null;

    }

    /**
     * 搜索设备的接口
     */
    public  interface onFindDeviceListener {
        void onFindDeviceListener(List<SearchResult> bleDevices);

    }
    public  void  onFindDeviceListener(onFindDeviceListener onFindDeviceListener){
        this.onFindDeviceListener = onFindDeviceListener;
    }

    public  interface onSearchStoppedDeviceListener {
        void onSearchStoppedDeviceListener();

    }
    public  void  onSearchStoppedDeviceListener(onSearchStoppedDeviceListener onSearchStoppedDeviceListener){
        this.onSearchStoppedDeviceListener = onSearchStoppedDeviceListener;
    }


    /**
     * 确定芯片类型
     * 获取读写的UUID
     */
    public int checkChipType(BleGattProfile bleGattProfile){
        int chipType = BluetoothUtils.checkChipType(bleGattProfile);
        if (chipType > -1){
            BluetoothUtils.setBluetoothChipType(bluetoothChipType);
            startNotify();
        }else {
            return -1;
        }
        return chipType;
    }

    /**
     * 打开Notify
     */
    public void startNotify(){
        if (bluetoothChipType.isAvailable()){
            mClient.notify(bluetoothChipType.getMAC(), bluetoothChipType.getServiceUUID(), bluetoothChipType.getNotificationUUID(), new BleNotifyResponse() {
                @Override
                public void onNotify(UUID service, UUID character, byte[] value) {
//                    com.orhanobut.logger.Logger.e("run: " + TypeCastUtil.bytesToHexString(value));
                    if(onNotify!=null){
                        onNotify.onNotify(value);
                    }
                }

                @Override
                public void onResponse(int code) {
                }
            });
        }else {
//            sendBroadcast(new Intent(BLUETOOTH_DEVICES_NOT_CONNECTED));
        }
    }

    /**
     * 关掉Notify
     */
    public void closeNotify(){
        if (bluetoothChipType.isAvailable()){
            if(mClient!=null){
                mClient.unnotify(bluetoothChipType.getMAC(), bluetoothChipType.getServiceUUID(), bluetoothChipType.getNotificationUUID(), new BleUnnotifyResponse() {
                    @Override
                    public void onResponse(int code) {
                        if(code==REQUEST_SUCCESS){

                        }
                    }
                });
            }
        }else {
//            sendBroadcast(new Intent(BLUETOOTH_DEVICES_NOT_CONNECTED));
        }
    }


    /**
     * 搜索设备的接口
     */
    public  interface onNotify {
        void onNotify(byte[] value);

    }
    public  void  onNotify(onNotify onNotify){
        this.onNotify = onNotify;
    }



    /**
     * 写Characteristic
     * 写入数据
     */
    public void writeCharacter(final byte[] cmd){
        if (bluetoothChipType.isAvailable())
            mClient.write(bluetoothChipType.getMAC(), bluetoothChipType.getServiceUUID(), bluetoothChipType.getWriteUUID(), cmd, new BleWriteResponse() {
                @Override
                public void onResponse(int code) {
                    if (code == REQUEST_SUCCESS){
                        com.orhanobut.logger.Logger.e( "run: " + "数据写入成功" + TypeCastUtil.bytesToHexString(cmd));
                    }
                }
            });
        else {
//            sendBroadcast(new Intent(BLUETOOTH_DEVICES_NOT_CONNECTED));
        }
    }
}
