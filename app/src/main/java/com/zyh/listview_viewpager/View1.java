package com.zyh.listview_viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class View1
{
    public static final int VIEWTYPE_VIEWPAGER = 0;
    public static final int VIEWTYPE_TEXTVIEW = 1;
    protected ListView listView;
    private Context mContext;

    public View1(Context context)
    {
        mContext = context;
        listView = new ListView(context);
        listView.setAdapter(new MyListViewAdapter());
    }

    class MyListViewAdapter extends BaseAdapter
    {
        @Override
        public int getCount()
        {
            return 100;
        }

        @Override
        public Object getItem(int position)
        {
            return null;
        }

        @Override
        public long getItemId(int position)
        {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (position % 3 == 0)
            {
                //listview_container_viewpager
                if (convertView == null)
                {
                    ItemViewPager child = new ItemViewPager();
                    child.init(mContext);
                    convertView = child.listItemViewPager;
                }
            } else
            {
//				textview
                if (convertView == null)
                {
                    convertView = new TextView(mContext);
                }
                ((TextView) convertView).setText("测试数据：" + position);
            }
            return convertView;
        }

        @Override
        public int getViewTypeCount()
        {
            return 2;
        }

        @Override
        public int getItemViewType(int position)
        {
            if (position % 3 == 0)
            {
                // listview_container_viewpager
                return VIEWTYPE_VIEWPAGER;
            } else
            {
                // textview
                return VIEWTYPE_TEXTVIEW;
            }
        }

    }
}
