package com.example.administrator.hk;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.hk.adapter.ViewPagerAdapter;


public class PagerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_view);

        ViewPager vp = (ViewPager) findViewById(R.id.vp);
        int[] pic = new int[]{R.mipmap.adware_style_applist,
        R.mipmap.adware_style_banner,
        R.mipmap.adware_style_creditswall};
        final ImageView[] imageViews = new ImageView[3];
        imageViews[0] = (ImageView) findViewById(R.id.tv1);
        imageViews[1] = (ImageView) findViewById(R.id.tv2);
        imageViews[2] = (ImageView) findViewById(R.id.tv3);
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),pic);
        assert vp != null;
        vp.setAdapter(viewPagerAdapter);
        final TextView tv_jump = (TextView) findViewById(R.id.tv_jump);
        assert tv_jump != null;
        tv_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PagerViewActivity.this,AnimationActivity.class);
                startActivity(intent);
                finish();
            }
        });
        vp.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Toast.makeText(PagerViewActivity.this, position+"", Toast.LENGTH_SHORT).show();
                if (position == imageViews.length-1){
                  tv_jump.setVisibility(View.VISIBLE);
                }
                for (int i = 0; i < imageViews.length; i++) {
                    imageViews[i].setBackgroundResource(R.drawable.indicator_unselected);

                }
                imageViews[position].setBackgroundResource(R.drawable.indicator_selected);
            }
        });

    }
}
