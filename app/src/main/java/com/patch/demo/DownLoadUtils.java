package com.patch.demo;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Title: ${FILE_NAME}
 * @Package com.greendao.demo
 * @Description:
 * @author: lvzongning
 * @date: 2017/3/26 14:43
 * @Copyright:
 */
public class DownLoadUtils {

    public static File download(String url){
        File file = null;
        InputStream is = null;
        FileOutputStream os = null;
        try {
            file = new File(Environment.getExternalStorageDirectory(),Contants.PATCH_FILE);
            if (file.exists()) {
                file.delete();
            }
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            is = conn.getInputStream();
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1*1024];
            int len = 0;
            while((len = is.read(buffer)) != -1){
                Log.d("Tim", String.valueOf(len));
                os.write(buffer, 0, len);
            }
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }



}





































