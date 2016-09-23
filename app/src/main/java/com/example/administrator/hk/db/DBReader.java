package com.example.administrator.hk.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.administrator.hk.entity.TelClassInfo;
import com.example.administrator.hk.entity.TelNumberInfo;
import com.example.administrator.hk.utils.LogUtil;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class DBReader {
    public static File telFile;
    static {
        String GBFiel = "data/data/com.example.administrator.hk/files/";
        File fileDir = new File(GBFiel);
        fileDir.mkdirs();
        telFile = new File(GBFiel,"commonnum.db");
        LogUtil.d("DBRead","telFile dir path:  "+GBFiel);
    }
    public static boolean isExistsTelGBFile(){
        return telFile.exists() && telFile.length() > 0;
    }
    public static ArrayList<TelClassInfo> readList(){
        ArrayList<TelClassInfo> telClassInfos = new ArrayList<TelClassInfo>();
        SQLiteDatabase db = null;
        Cursor cursor = null;
        db = SQLiteDatabase.openOrCreateDatabase(telFile,null);
        cursor = db.rawQuery("select * from classlist", null);
        LogUtil.d("DBRead", "read teldb classlist size: " + cursor.getCount());
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            int idx = cursor.getInt(cursor.getColumnIndex("idx"));
            TelClassInfo telClassInfo = new TelClassInfo(name,idx);
            telClassInfos.add(telClassInfo);

        }
        return telClassInfos;
    }
    public static ArrayList<TelNumberInfo> readNumber(int idx) {
        ArrayList<TelNumberInfo> numberInfos = new ArrayList<>();
        //idx为classlist表中电话的 ID，根据 idx值进行指定页面的跳转
        String sql = "select * from table" + idx;
        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            // 打开 DB文件
            db = SQLiteDatabase
                    .openOrCreateDatabase(telFile, null);
            // 执行查询的 SQL语句 select * from table +idx
            cursor = db.rawQuery(sql, null);
            LogUtil.d("DBRead", "read teldb number table size: "
                    + cursor.getCount());
            if (cursor.moveToFirst()) {
                do {
                    String name = cursor
                            .getString(cursor
                                    .getColumnIndex("name"));
                    String number = cursor
                            .getString(cursor
                                    .getColumnIndex("number"));
                    TelNumberInfo numberInfo = new TelNumberInfo(
                            name, number);
                    numberInfos.add(numberInfo);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            LogUtil.d("DBRead", "read teldb classlist failed");
        } finally {
            try {
                //关闭游标
                cursor.close();
                //关闭数据库，释放资源
                db.close();
            } catch (Exception e2) {
                throw e2;
            }
        }
        return numberInfos;
    }

    /*public static File file = new File("data/data/com.example.administrator.hk/files/");
    //打开DB文件
    private static SQLiteDatabase db = null;
    //执行查询的SQL语句select * from classlist
    private static Cursor cursor = null;

    *//*public static File telFile;
    static {
        String dbFileDir = "data/data/commonnum.db";

        File fileDir = new File(dbFileDir);
        fileDir.mkdirs();
        telFile = new File(dbFileDir, "commonnum.db");
        LogUtil.d("DBReader", "telFile Dir path:" + dbFileDir);
    }*//*
    public static boolean isExistsTeldbFile() {
        if (file.exists() && file.length() > 0) {
            return true;
        }
        return false;
    }
    *//*public static boolean isExistsTeldbFile() {
        File toFile = DBReader.file;
        if (!toFile.exists() || toFile.length() <= 0) {
            return false;
        }
        return true;
    }*//*
    public static ArrayList<TelClassInfo> readTeldbClasslist() throws Exception {
        ArrayList<TelClassInfo> classlistInfos = new ArrayList<TelClassInfo>();
        if (isExistsTeldbFile()) {
            db = SQLiteDatabase.openOrCreateDatabase(file, null);
            cursor = db.rawQuery("select * from classlist", null);
            LogUtil.d("DBRead", "read teldb classlist size:" + cursor.getCount());
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int idx = cursor.getInt(cursor.getColumnIndex("idx"));
                TelClassInfo classlistInfo = new TelClassInfo(name, idx);
                classlistInfos.add(classlistInfo);
            }
            cursor.close();
            db.close();
            return classlistInfos;
        } else {
            LogUtil.d("DBRead", "数据库文件没有找到...");
            return null;
        }
    }
    public static ArrayList<TelNumberInfo> readTeldbTable(int idx) {
        ArrayList<TelNumberInfo> numberInfos = new ArrayList<TelNumberInfo>();
        String sql = "select * from table" + idx;
        if (isExistsTeldbFile()) {
            //打开db文件
            db = SQLiteDatabase.openOrCreateDatabase(file, null);
            cursor = db.rawQuery(sql, null);
            LogUtil.d("DBRead", "read teldb number table size:" + cursor.getCount());
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String number = cursor.getString(cursor.getColumnIndex("number"));
                TelNumberInfo numberInfo = new TelNumberInfo(name, number);
                numberInfos.add(numberInfo);
            }
            cursor.close();
            db.close();
            return numberInfos;
        } else {
            LogUtil.d("DBRead", "read teldb number table end [list size]" + numberInfos.size());
            return null;
        }
    }*/
}