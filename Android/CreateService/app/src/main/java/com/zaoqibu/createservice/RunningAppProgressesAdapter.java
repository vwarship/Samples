package com.zaoqibu.createservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vwarship on 2015/2/11.
 */
public class RunningAppProgressesAdapter extends BaseAdapter {
    private Context context;
    private List<RunningAppProgress> runningAppProgresses;

    public RunningAppProgressesAdapter(Context context, List<RunningAppProgress> runningAppProgresses) {
        this.context = context;
        this.runningAppProgresses = runningAppProgresses;
    }

    @Override
    public int getCount() {
        return runningAppProgresses.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item_running_app_process, parent, false);
        }
        else {
            view = convertView;
        }

        ImageView ivAppIcon = (ImageView)view.findViewById(R.id.iv_app_icon);
        ivAppIcon.setImageResource(runningAppProgresses.get(position).getIcon());

        TextView tvAppName = (TextView)view.findViewById(R.id.tv_app_name);
        tvAppName.setText(runningAppProgresses.get(position).getName());

        return view;
    }
}
