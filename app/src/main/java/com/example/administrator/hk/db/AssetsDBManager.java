package com.example.administrator.hk.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class AssetsDBManager {
    private static final String TAG = "AssetsDBManager";
    public String copyDBFileToGB(Context context){
        AssetManager assetManager = context.getAssets();
        String path = "db/commonnum.db";
        try {
            InputStream inputStream = assetManager.open(path);
            //把数据库文件保存到内置存储 file目录下
            File fileDir = context.getFilesDir();
            File file = new File(fileDir,"commonnum.db");
            FileOutputStream outputStream = context.openFileOutput(file.getName(),Context.MODE_PRIVATE);
            BufferedInputStream bufi = new BufferedInputStream(inputStream);
            BufferedOutputStream bufo = new BufferedOutputStream(outputStream);
            byte[] buf = new byte[1024];
            int eof = 0;
            while ((eof = bufi.read(buf)) !=-1){
                bufo.write(buf,0,eof);
                bufo.flush();
            }
            bufo.close();
            bufi.close();
            Log.d(TAG,"save data success");
            return file.getName();
        } catch (IOException e) {
            Log.d(TAG, "copyDBFileToGB: 路径错误");
            e.printStackTrace();
        }
        return null;
    }

   /* public static void copyAssetsFileToFile(Context context,String from,String to) throws IOException {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        AssetManager am = context.getAssets();

        try {
            InputStream is = am.open(from);
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(new FileOutputStream(to));

            int x;
            byte[] b = new byte[1024 * 2];
            while((x = bis.read(b)) != -1){
                bos.write(b, 0, x);
            }
            bos.flush();

        } catch (IOException e) {
            throw e;
        }finally{
            bis.close();
            bos.close();
        }*/


        /*LogUtil.d("AssetDBManager", "copyAssetsFileToFile start");
        LogUtil.d("AssetDBManager", "File path:" + path);
        LogUtil.d("AssetDBManager", "toFile path:" + toFile.getAbsolutePath());

        InputStream inputStream = null;
        //输入流
        BufferedInputStream bufferedInputStream = null;
        //输出流
        BufferedOutputStream bufferedOutputStream = null;

        try {
            inputStream = context.getAssets().open(path);
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(toFile, false));

            int length = 0;
            byte[] buff = new byte[2 * 1024];
            while ((length = bufferedInputStream.read(buff)) != -1){
                bufferedOutputStream.write(buff, 0, length);
            }
            bufferedOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            bufferedOutputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            LogUtil.d("AssetDBManager", "copyAssetsFileToFile end");
        }*/

 /*   }*/
}
