package com.patch.demo;

/**
 * @Title: ${FILE_NAME}
 * @Package com.greendao.demo
 * @Description:
 * @author: lvzongning
 * @date: 2017/3/26 14:43
 * @Copyright:
 */
public class BsPatch {
    public native  static int patch(String oldfile,String newFile,String patchFile);
    static{
        System.loadLibrary("BisPatch");
    }

}
