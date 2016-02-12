package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends Activity
{

    private List<View> viewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ViewPager viewPager = new ViewPager(this);
        setContentView(viewPager);

        viewList.add(new View1(this).listView);
        viewList.add(new View1(this).listView);
        viewList.add(new View1(this).listView);

        /**
         * 用来装载ListView的ViewPager
         */
        viewPager.setAdapter(new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object)
            {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(viewList.get(position));
            }
        });
    }
}
