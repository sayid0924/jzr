package com.jzr.bedside.appmanage;

import java.io.File;

public interface DownloadFileListener {
    /**
     * @param file 下载成功后的文件
     */
    void onDownloadSuccess(File file);

    /**
     * @param progress 下载进度
     */
    void onDownloading(int progress);

    /**
     * @param e 下载异常信息
     */
    void onDownloadFailed(Exception e);
}
