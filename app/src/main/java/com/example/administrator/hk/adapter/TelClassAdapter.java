package com.example.administrator.hk.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.administrator.hk.R;
import com.example.administrator.hk.entity.TelClassInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/9/13 0013.
 */
public class TelClassAdapter extends BaseAdapter {
    private final ArrayList<TelClassInfo> telClassInfos;
    private final LayoutInflater inflater;

    public TelClassAdapter(Context context, ArrayList<TelClassInfo> telClassInfos) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.telClassInfos = telClassInfos;
    }

    @Override
    public int getCount() {
        return telClassInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return telClassInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) {
            convertView = inflater.inflate(R.layout.item_tel_class, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.tv);
        tv.setText(telClassInfos.get(position).getName());
        return convertView;
    }
}
