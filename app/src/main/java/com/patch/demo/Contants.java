package com.patch.demo;

import android.os.Environment;

import java.io.File;

/**
 * @Title: ${FILE_NAME}
 * @Package com.greendao.demo
 * @Description:
 * @author: lvzongning
 * @date: 2017/3/26 14:43
 * @Copyright:
 */
public class Contants {
    public static final String PATCH_FILE           ="apk.patch";
    public static final String URL_PATCH_DOWNLOAD   = "http://119.23.236.161:8080/"+PATCH_FILE;
    //linux remote
    //public static final String URL_PATCH_DOWNLOAD = "http://www.dongnaoedu.com/"+PATCH_FILE;

    public static final String SD_CARD          = Environment.getExternalStorageDirectory()+ File.separator;
    //新版本apk的目录
    public static final String NEW_APK_PATH     =SD_CARD + "dn_apk_new.apk";

    public static final String PATCH_FILE_PATH  =SD_CARD+PATCH_FILE;














}
