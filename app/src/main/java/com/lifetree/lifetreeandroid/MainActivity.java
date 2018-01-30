package com.lifetree.lifetreeandroid;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CustomViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        pager = (ViewPager)findViewById(R.id.pager);
        pager = (CustomViewPager) findViewById(R.id.myViewPager);
        Button btn_1 = (Button) findViewById(R.id.btn_1);
        Button btn_2 = (Button) findViewById(R.id.btn_2);
        Button btn_3 = (Button) findViewById(R.id.btn_3);
        Button btn_4 = (Button) findViewById(R.id.btn_4);
        Button btn_5 = (Button) findViewById(R.id.btn_5);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);
        pager.setPagingDisabled();

        View.OnClickListener movePageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tag = (int) view.getTag();
                pager.setCurrentItem(tag);
            }
        };

        btn_1.setOnClickListener(movePageListener);
        btn_1.setTag(0);
        btn_2.setOnClickListener(movePageListener);
        btn_2.setTag(1);
        btn_3.setOnClickListener(movePageListener);
        btn_3.setTag(2);
        btn_4.setOnClickListener(movePageListener);
        btn_4.setTag(3);
        btn_5.setOnClickListener(movePageListener);
        btn_5.setTag(4);
    }

    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new Fragment1();
                case 1:
                    return new Fragment2();
                case 2:
                    return new Fragment3();
                case 3:
                    return new Fragment4();
                case 4:
                    return new Fragment5();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // total page count
            return 5;
        }
    }
}
