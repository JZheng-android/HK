package com.example.administrator.hk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.hk.R;
import com.example.administrator.hk.entity.TelNumberInfo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/14 0014.
 */
public class TelNumberAdapter extends BaseAdapter {

    private final ArrayList<TelNumberInfo> telNumberInfos;
    private final LayoutInflater inflater;

    public TelNumberAdapter(Context context, ArrayList<TelNumberInfo> telNumberInfos) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.telNumberInfos = telNumberInfos;
    }

    @Override
    public int getCount() {
        return telNumberInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return telNumberInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.item_main_tel_num, null);
        }
        TextView tv_num = (TextView) convertView.findViewById(R.id.tv_num);
        TextView tv_name = (TextView) convertView.findViewById(R.id.tv_name);
        tv_num.setText(telNumberInfos.get(position).getNumber());
        tv_name.setText(telNumberInfos.get(position).getName());
        return convertView;
    }
}
