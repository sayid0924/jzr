package com.jzr.bedside.service.bluetooth;

import android.content.Context;

import com.inuker.bluetooth.library.BluetoothClient;
import com.inuker.bluetooth.library.model.BleGattProfile;
import com.inuker.bluetooth.library.model.BleGattService;

import java.util.UUID;

public class BluetoothUtils {

    private static String TAG = "cjw_BluetoothUtils";
    private static BluetoothClient mClient = null;
    private static int bleUUIDIndex = -1;//是用芯片的类型
    private static final String[] SERVICE_UUID_ARRAY = {"0000FFB0-0000-1000-8000-00805f9b34fb",
            "45531234-6565-7370-6f54-676e6f6c7553", "000018f0-0000-1000-8000-00805f9b34fb",
            "0000f808-0000-1000-8000-00805f9b34fb", "0000ffe0-0000-1000-8000-00805f9b34fb",
            "c14d2c0a-401f-b7a9-841f-e2e93b80f631"};
    private static final String[] WRITE_UUID_ARRAY = {"0000FFB2-0000-1000-8000-00805f9b34fb",
            "45531235-6565-7370-6f54-676e6f6c7553", "00002af1-0000-1000-8000-00805f9b34fb",
            "0000fa18-0000-1000-8000-00805f9b34fb", "0000ffe1-0000-1000-8000-00805f9b34fb",
            "6c1cef07-3377-410e-b231-47f76c5a39e1"};
    private static final String[] NOTIFICATION_UUID_ARRAY = {"0000FFB2-0000-1000-8000-00805f9b34fb",
            "45531236-6565-7370-6f54-676e6f6c7553", "00002af0-0000-1000-8000-00805f9b34fb",
            "0000fa52-0000-1000-8000-00805f9b34fb", "0000ffe1-0000-1000-8000-00805f9b34fb",
            "81eb77bd-89b8-4494-8a09-7f83d986ddc7"};
    private static final String[] CLIENT_CONFIG_UUID_ARRAY = {"00002902-0000-1000-8000-00805f9b34fb",
            "00002902-0000-1000-8000-00805f9b34fb", "00002902-0000-1000-8000-00805f9b34fb",
            "00002902-0000-1000-8000-00805f9b34fb", "00002902-0000-1000-8000-00805f9b34fb",
            "00002902-0000-1000-8000-00805f9b34fb"};

    private BluetoothUtils(Context context){
        mClient = new BluetoothClient(null);
    }

    public static BluetoothUtils getInstance(Context context) {
        return new BluetoothUtils(context);
    }

    /**
     * 检测芯片类型
     * @param searchResult
     * @return
     */
    public static int checkChipType(BleGattProfile searchResult){
        BleGattService service = null;
        for (int i = 0; i < SERVICE_UUID_ARRAY.length; i++) {
            service = searchResult.getService(UUID.fromString(SERVICE_UUID_ARRAY[i]));
            if (service != null) {
                bleUUIDIndex = i;
                break;
            }
        }
        if (service == null) {
            return -1;
        }
        return bleUUIDIndex;
    }

    /**
     * 将芯片类型赋值
     * @param bluetoothChipType
     */
    public static void setBluetoothChipType(BluetoothChipType bluetoothChipType){
        if (bluetoothChipType != null){
            if (bleUUIDIndex > -1){
                bluetoothChipType.setServiceUUID(UUID.fromString(SERVICE_UUID_ARRAY[bleUUIDIndex]));
                bluetoothChipType.setWriteUUID(UUID.fromString(WRITE_UUID_ARRAY[bleUUIDIndex]));
                bluetoothChipType.setNotificationUUID(UUID.fromString(NOTIFICATION_UUID_ARRAY[bleUUIDIndex]));
                bluetoothChipType.setClientUUID(UUID.fromString(CLIENT_CONFIG_UUID_ARRAY[bleUUIDIndex]));
            }else {
                throw new IndexOutOfBoundsException();
            }
        }else {
            throw new NullPointerException();
        }
    }



}
