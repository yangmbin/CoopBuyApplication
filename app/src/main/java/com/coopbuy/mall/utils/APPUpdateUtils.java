package com.coopbuy.mall.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;

import com.coopbuy.mall.widget.APPUpdateDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * APP检查更新工具类
 * @author ymb
 * Create at 2017/8/21 14:46
 */
public class APPUpdateUtils {

    private Context mContext;
    private String url;
    private String apk_location;
    private DownloadTask mDownloadTask;
    private APPUpdateDialog mAppUpdateDialog;

    public APPUpdateUtils(Context mContext, String url) {
        this.mContext = mContext;
        this.url = url;
        apk_location = this.mContext.getCacheDir() + "/coopbuy.apk";
    }

    public void downloadAPK(APPUpdateDialog dialog) {
        mAppUpdateDialog = dialog;
        mDownloadTask = new DownloadTask(mContext);
        mDownloadTask.execute(url);
    }

    public void cancel() {
        if (mDownloadTask != null && !mDownloadTask.isCancelled())
            mDownloadTask.cancel(true);
    }

    class DownloadTask extends AsyncTask<String, Integer, String> {

        private Context mContext;
        private PowerManager.WakeLock mWakeLock;

        public DownloadTask(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PowerManager pm = (PowerManager) mContext.getSystemService(Context.POWER_SERVICE);
            mWakeLock = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
            mWakeLock.acquire();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mWakeLock.release();
            mAppUpdateDialog.dismiss();
            if (s != null)
                ToastUtils.toastShort("下载失败");
            else {
                installAPK();
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            if (mAppUpdateDialog != null)
                mAppUpdateDialog.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(String... params) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            File file;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK)
                    return "error";
                int fileLength = connection.getContentLength();
                file = new File(apk_location);
                input = connection.getInputStream();
                output = new FileOutputStream(file);
                byte data[] = new byte[2048];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    if (fileLength > 0)
                        publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
            } catch (Exception e) {
                return "error";
            } finally {
                try {
                    if (input != null)
                        input.close();
                    if (output != null)
                        output.close();
                } catch (Exception e) {
                    return "error";
                }
                if (connection != null)
                    connection.disconnect();
            }

            return null;
        }
    }

    private void installAPK() {
        Log.e("yangmbin", apk_location);
        File file = new File(apk_location);
        // 授权
        try {
            String[] command = {"chmod", "777", file.toString()};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.start();
        } catch (IOException ignored) {
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
