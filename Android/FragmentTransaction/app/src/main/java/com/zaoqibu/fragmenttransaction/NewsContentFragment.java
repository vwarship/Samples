package com.zaoqibu.fragmenttransaction;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by vwarship on 2015/2/23.
 */
public class NewsContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news_content, container, false);
    }

    public void setNewsContent(String newsContent) {
        if (getView() != null) {
            TextView tvNewsContent = (TextView) getView().findViewById(R.id.tvNewsContent);
            tvNewsContent.setText(newsContent);
        }
    }

}
