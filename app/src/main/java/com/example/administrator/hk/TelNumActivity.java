package com.example.administrator.hk;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.hk.adapter.TelNumberAdapter;
import com.example.administrator.hk.db.DBReader;
import com.example.administrator.hk.entity.TelNumberInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/22.
 */
public class TelNumActivity extends BaseActivity {
    private ListView listView;
    private  DBReader dbReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_num);

        listView = (ListView) findViewById(R.id.list);
        //b.获取上个界面传递过来的intent对象，并取出里面的值。。。
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            final int idx = (int) bundle.get("idx");
            //c通过DB类读取数据,是一个耗时的操作，应该开辟子线程来做
            asyncLoadData(idx);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TelNumberInfo positionInfo = dbReader.readNumber(idx).get(position);
                    String name = positionInfo.getName();
                    String number = positionInfo.getNumber();
                    showCallDialog(name, number);
                }
            });
        }

    }

    private void showCallDialog( final String name,final String number) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("警告");
        builder.setMessage("是否开始拨打" + name + "电话？\n\nTEL:" + number);
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("拨号", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //电话拨打
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel://" + number));
                if (ActivityCompat.checkSelfPermission(TelNumActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        requestPermissions(new String[]{
                                Manifest.permission.CALL_PHONE
                        }, 1);
                    } else {
                        Toast.makeText(TelNumActivity.this, "请给我打电话权限-----------", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }
                startActivity(intent);

            }
        });
        builder.show();
    }

    private void asyncLoadData(final int idx) {
        new Thread(){
            @Override
            public void run() {
                super.run();
                ArrayList<TelNumberInfo> telNumberInfos = DBReader.readNumber(idx);
                //d把数据展示到listview中
                listView.setAdapter(new TelNumberAdapter(TelNumActivity.this,telNumberInfos));
            }
        }.start();

    }
}
