package com.zaoqibu.customarrayadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vwarship on 2015/2/23.
 */
public class NewsArrayAdapter extends ArrayAdapter<News> {
    private int resource;
    private List<News> newses;

    public NewsArrayAdapter(Context context, int resource, List<News> objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.newses = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        // 方法1
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(resource, parent, false);
        }

        // 方法2
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(resource, parent, false);
//        }

        // 方法3
//        if (view == null) {
//            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(resource, new LinearLayout(getContext()), true);
//        }

        News news = newses.get(position);

        TextView newsTitle = (TextView)view.findViewById(R.id.tvNewsTitle);
        newsTitle.setText(news.getTitle());

        TextView newsDate = (TextView)view.findViewById(R.id.tvNewsDate);
        newsDate.setText(news.getDate());

        return view;
    }
}
