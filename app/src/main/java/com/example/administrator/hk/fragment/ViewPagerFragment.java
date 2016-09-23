package com.example.administrator.hk.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.administrator.hk.R;

/**
 * Created by Administrator on 2016/9/22.
 */
public class ViewPagerFragment extends Fragment {
    private int pic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pager_view, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        iv.setImageResource(pic);
        return view;
    }
    public void intData(int pic){
        this.pic = pic;
    }
}
