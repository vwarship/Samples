package com.zaoqibu.customarrayadapter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {
    private List<News> newses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newses = new ArrayList<News>();

        newses.add(new News("揭秘！“柳传志”女儿在滴滴打车公司的真实情况", "2015-02-23 10:01:39"));
        newses.add(new News("联想“插件门”的幕后真凶原来是它", "2015-02-23 10:59:00"));
        newses.add(new News("冒死揭露​互联网​BAT三巨头名字的由来", "2015-02-23 10:06:00"));
        newses.add(new News("YouTube发布十年精选热门视频，这些镜头你一定都记得", "2015-02-23 09:50:11"));
        newses.add(new News("易信借免费电话突围移动社交市场", "2015-02-23 08:54:00"));
        newses.add(new News("“一带一路”激发云计算万亿产业潜力", "2015-02-23 07:51:48"));
        newses.add(new News("想成功，腾讯OS就别做成微信OS", "2015-02-23 00:00:00"));
        newses.add(new News("沈国军说马云：受委屈", "2015-02-23 13:59:00"));
        newses.add(new News("9点1氪：多项法规将于3月施行，涉及网购", "2015-02-23 09:29:10"));
        newses.add(new News("5款鲜为人知的App让你的数字生活更轻松", "2015-02-23 08:00:00"));

        ListView lvNewses = (ListView)findViewById(R.id.lvNewses);
        lvNewses.setAdapter(new NewsArrayAdapter(this, R.layout.news, newses));
    }

}
