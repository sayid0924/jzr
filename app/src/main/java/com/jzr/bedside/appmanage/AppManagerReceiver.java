package com.jzr.bedside.appmanage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AppManagerReceiver extends BroadcastReceiver {

    private static final String TAG = AppManagerReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        LogUtil.i(TAG, "onReceive " + intent.getAction());
    }
}
