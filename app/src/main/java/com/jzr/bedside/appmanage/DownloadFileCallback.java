package com.jzr.bedside.appmanage;

import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class DownloadFileCallback implements Callback {

    private static final String TAG = DownloadFileCallback.class.getSimpleName();

    private String mPath;
    private DownloadFileListener mDownloadFileListener;

    public DownloadFileCallback(String path, DownloadFileListener listener) {
        mPath = path;
        mDownloadFileListener = listener;
    }

    @Override
    public void onFailure(Call call, IOException e) {
        LogUtil.i(TAG, "onFailure, e = " + e.getMessage(), e);
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        LogUtil.d(TAG, "onResponse, code = " + response.code());
        if (response.code() == 200) {
            String url = response.request().url().toString();
            String filename = url.substring(url.lastIndexOf('/') + 1);
            LogUtil.v(TAG, filename);


            InputStream is = null;
            byte[] buf = new byte[2048];
            int len = 0;
            FileOutputStream fos = null;
            // 储存下载文件的目录
            File dir = new File(mPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, filename);
            if (file.exists()) {
                LogUtil.i(TAG, file.getAbsolutePath() + " exist, delete");
                file.delete();
            }
            try {
                is = response.body().byteStream();
                long total = response.body().contentLength();
                fos = new FileOutputStream(file);
                long sum = 0;
                while ((len = is.read(buf)) != -1) {
                    fos.write(buf, 0, len);
                    sum += len;
                    int progress = (int) (sum * 1.0f / total * 100);
                    // 下载中更新进度条
                    mDownloadFileListener.onDownloading(progress);
                    Log.e("TAG", String.valueOf(progress));
                }
                fos.flush();
                // 下载完成
                Log.e("TAG","下载完成");
                mDownloadFileListener.onDownloadSuccess(file);
            } catch (Exception e) {
                LogUtil.e(TAG, e.getMessage(), e);
                mDownloadFileListener.onDownloadFailed(e);
            } finally {
                try {
                    if (is != null) {
                        is.close();
                    }
                } catch (IOException e) {
                    LogUtil.e(TAG, e.getMessage(), e);
                }
                try {
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e) {
                    LogUtil.e(TAG, e.getMessage(), e);
                }
            }
        }
    }
}
