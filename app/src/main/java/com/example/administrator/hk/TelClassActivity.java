package com.example.administrator.hk;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.hk.adapter.TelClassAdapter;
import com.example.administrator.hk.db.AssetsDBManager;
import com.example.administrator.hk.db.DBReader;
import com.example.administrator.hk.entity.TelClassInfo;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/9/22.
 */
public class TelClassActivity extends BaseActivity{
/*    private ListView listView;
    private TelNumberAdapter adapter;
    private int idx = 0;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tel_list);
        if (DBReader.isExistsTelGBFile()){
            AssetsDBManager assetsDBManager = new AssetsDBManager();
            String path = assetsDBManager.copyDBFileToGB(this);
        }
        final ArrayList<TelClassInfo> telClassInfos = DBReader.readList();

        ListView listView = (ListView) findViewById(R.id.list_item);

        TelClassAdapter adapter = new TelClassAdapter(this,telClassInfos);

        listView.setAdapter(adapter);

        //给listview设置点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> parent,//parent引用的指向是listview对象
                    View view,
                    int position,//就是条目所在的位置 从0开始
                    long id//是条目的id值，是adapter 的getItemId（position）方法设置的
            ) {
                //当条目被点击，松开的时候，触发该方法
                Toast.makeText(TelClassActivity.this, id+"=="+position, Toast.LENGTH_SHORT).show();
                //a.跳转到TelClassActivity界面，并传递idx值
                Bundle bundle = new Bundle();
                bundle.putInt("idx",telClassInfos.get(position).getIdx());
                startActivityWithBundle(TelNumActivity.class,bundle);
            }
        });
    }




       /* //获取数据用来判断是显示哪一种分类的电话号码
        idx = getIntent().getIntExtra("idx", 1);

        listView = (ListView) findViewById(R.id.list_item);
        assert listView != null;
        listView.setOnItemClickListener((AdapterView.OnItemClickListener) this);
        adapter = new TelNumberAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //添加数据
        try {
            adapter.addDataToAdapter(DBReader.readTeldbTable(idx));
        } catch (Exception e) {
            e.printStackTrace();
        }//db库内的电话分类
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = adapter.getItem(position).name;
        String number = adapter.getItem(position).number;
        showCallDialog(name, number);
    }

    private void showCallDialog(final String name, final String number) {
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
                if (ActivityCompat.checkSelfPermission(TelClassActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);

            }
        });
        builder.show();

    }*/
}
