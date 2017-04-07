package com.example.fang.viewpagetest;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private View view1,view2,view3;

    private List<View> viewList=new ArrayList<>();
    private List<String> titleList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager= (ViewPager) findViewById(R.id.view_page);

        LayoutInflater layoutInflater=getLayoutInflater();
        view1=layoutInflater.inflate(R.layout.layout1,null);
        view2=layoutInflater.inflate(R.layout.layout2,null);
        view3=layoutInflater.inflate(R.layout.layout3,null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        titleList.add("方坤镇");
        titleList.add("张越");
        titleList.add("越子");
        titleList.add("...");



        PagerAdapter pagerAdapter=new PagerAdapter() {
            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == viewList.get((int)Integer.parseInt(arg1.toString()));
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return position;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titleList.get(position);

            }
        };

        viewPager.setAdapter(pagerAdapter);

    }
}
