package com.patch.demo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/**
 * @Title: ${FILE_NAME}
 * @Package com.greendao.demo
 * @Description:
 * @author: lvzongning
 * @date: 2017/3/26 14:43
 * @Copyright:
 */
public class ApkUtils {

    //获取APK版本号 在公司实际开发中 是根据 key uuid判断（渠道 版本）
    public static int getVersionCode(Context context,String packageName){
        PackageManager pm=context.getPackageManager();
        try{
            PackageInfo info=pm.getPackageInfo(packageName,0);
            Log.i("PakageInfo","getVersion="+info.versionCode);
            return info.versionCode;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取已安装Apk文件的源Apk文件
     * 如：/data/app/my.apk
     * @return
     */
    public static String getSourceApkPath(Context context,String packageName){
        if(TextUtils.isEmpty(packageName))
            return null;

        try {
            ApplicationInfo appInfo=context.getPackageManager().getApplicationInfo(packageName,0);
            return appInfo.sourceDir;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void installApk(Context context,String apkPath){
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("file://"+apkPath),
                "applicaion/vnd.android.package-archive");
    }


}
























