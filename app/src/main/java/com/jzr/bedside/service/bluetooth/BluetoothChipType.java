package com.jzr.bedside.service.bluetooth;

import java.util.UUID;

/**
 * Created by user on 2018/6/19.
 */

public class BluetoothChipType {

    private String MAC;
    private UUID ServiceUUID;
    private UUID NotificationUUID;
    private UUID ClientUUID;
    private UUID WriteUUID;

    public boolean isAvailable(){
        if (MAC != null && ServiceUUID != null && NotificationUUID!= null && WriteUUID != null )
            return true;
        else
            return false;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public UUID getServiceUUID() {
        return ServiceUUID;
    }

    public void setServiceUUID(UUID serviceUUID) {
        ServiceUUID = serviceUUID;
    }

    public UUID getNotificationUUID() {
        return NotificationUUID;
    }

    public void setNotificationUUID(UUID notificationUUID) {
        NotificationUUID = notificationUUID;
    }

    public UUID getClientUUID() {
        return ClientUUID;
    }

    public void setClientUUID(UUID clientUUID) {
        ClientUUID = clientUUID;
    }

    public UUID getWriteUUID() {
        return WriteUUID;
    }

    public void setWriteUUID(UUID writeUUID) {
        WriteUUID = writeUUID;
    }
}
