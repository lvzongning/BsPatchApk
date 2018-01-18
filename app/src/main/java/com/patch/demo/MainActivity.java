package com.patch.demo;

import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    private static String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ApkUtils.getVersionCode(this, getPackageName()) < 2.0) {
            Log.d(TAG,"不是最新的版本号 开始更新 ");
            new ApkUpdateTask().execute();
        } else {
            Log.d(TAG ," 最新版本号 无需更新");
        }

    }

    class ApkUpdateTask extends AsyncTask<Void,Void,Boolean>{

        @Override
        protected Boolean doInBackground(Void... params) {
            Log.d(TAG,"开始下载 。。。");
            File patchifle=DownLoadUtils.download(Contants.URL_PATCH_DOWNLOAD);
            Log.i(TAG,"下载完成");
            String oldfile=ApkUtils.getSourceApkPath(MainActivity.this,getPackageName());
            String newFile=Contants.NEW_APK_PATH;
            String patchFileString=patchifle.getAbsolutePath();
            Log.d(TAG,"开始合并");
            int ret=BsPatch.patch(oldfile,newFile,patchFileString);
            Log.i(TAG,"合并完成");
            if (ret == 0) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if(aBoolean){
                Log.d(TAG,"合并成功 开始安装新apk");
                ApkUtils.installApk(MainActivity.this,Contants.NEW_APK_PATH);
            }

        }
    }




}




















