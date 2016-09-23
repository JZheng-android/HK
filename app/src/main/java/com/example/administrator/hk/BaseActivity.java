package com.example.administrator.hk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;


import com.example.administrator.hk.utils.LogUtil;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class BaseActivity extends AppCompatActivity {
    public void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * 带参数跳转
     *
     * @param clazz 被跳转的界面
     * @param bundle 传递的数据包裹
     */
    public void startActivityWithBundle(Class clazz, Bundle bundle) {
        Intent intent = new Intent(this, clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
   /* private static final String TAG = "BaseActivity";
    private static ArrayList<BaseActivity> onLineActivityList = new ArrayList<BaseActivity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, getClass().getSimpleName() + "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, getClass().getSimpleName() + "onResume()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG, getClass().getSimpleName() + "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, getClass().getSimpleName() + "onDestroy()");
        //清空Activity
        if (onLineActivityList.contains(this)){
            onLineActivityList.remove(this);
        }
    }

    //依次退出当前存在的所有Activity
    public static void finishAll(){
        Iterator<BaseActivity> iterator = onLineActivityList.iterator();
        while (iterator.hasNext()){
            iterator.next().finish();
        }
    }

    //普通跳转
    protected void startActivity(Class<?> targetClass){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
    }
    //传递参数的跳转
    protected void startActivity(Class<?> targetClass, Bundle bundle){
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    //带动画的跳转
    protected void startActivity(Class<?> targetClass, int inAnimID, int outAnimID){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }
    //带动画跳转，并传递参数
    protected void startActivity(Class<?> targetClass, int inAnimID, int outAnimID, Bundle bundle){
        Intent intent = new Intent(this, targetClass);
        intent.putExtras(bundle);
        startActivity(intent);
        overridePendingTransition(inAnimID, outAnimID);
    }


    public abstract void onItemClick(AdapterView<?> parent, View view, int position, long id);
}*/
