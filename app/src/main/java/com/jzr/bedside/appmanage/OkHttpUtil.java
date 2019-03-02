package com.jzr.bedside.appmanage;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpUtil {

    private static final String TAG = OkHttpUtil.class.getSimpleName();


    public static void download(String url, String path, DownloadFileListener listener) {
        final Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new DownloadFileCallback(path, listener));
    }
}
