package com.zyh.listview_viewpager;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Button;

public class ItemViewPager
{

    protected ViewPager listItemViewPager;
    private List<View> buttonList = new ArrayList<>();

    public void init(Context context)
    {
        /**
         * 添加所有要展示在ListView里面的ViewPager项的控件
         */
        for (int i = 0; i < 5; i++)
        {
            //添加5个button按钮到ViewPager中
            Button button = new Button(context);
            button.setText("ViewPager中的TextView：" + i);
            buttonList.add(button);
        }

        listItemViewPager = new ViewPager(context);
        /**
         * 必须设置LayoutParams,否则无法显示
         */
        listItemViewPager.setLayoutParams(new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 150));
        listItemViewPager.setAdapter(new PagerAdapter()
        {
            @Override
            public int getCount()
            {
                return buttonList.size();
            }

            @Override
            public boolean isViewFromObject(View arg0, Object arg1)
            {
                return arg0 == arg1;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position)
            {
                container.addView(buttonList.get(position));
                return buttonList.get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object)
            {
                container.removeView(buttonList.get(position));
            }
        });
    }
}
