package com.zaoqibu.fragmenttransaction;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity implements NewsTitleListFragment.OnNewsSelectedListener {
    private NewsContentFragment newsContentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnShowNewsContent).setEnabled(true);
        findViewById(R.id.btnRemoveNewsContent).setEnabled(false);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.news_title_list_container, new NewsTitleListFragment());
//        fragmentTransaction.add(R.id.news_content_container, new NewsContentFragment());
        fragmentTransaction.commit();
    }

    public void onShowNewsContentClick(View view) {
        if (newsContentFragment == null) {
            newsContentFragment = new NewsContentFragment();
        }

        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.news_content_container, newsContentFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
//        fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_bottom, R.anim.abc_slide_out_top);
        fragmentTransaction.commit();

        findViewById(R.id.news_content_container).setVisibility(View.VISIBLE);
        findViewById(R.id.btnShowNewsContent).setEnabled(false);
        findViewById(R.id.btnRemoveNewsContent).setEnabled(true);

    }

    public void onRemoveNewsContentClick(View view) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.remove(newsContentFragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
//        fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
        fragmentTransaction.commit();

        findViewById(R.id.btnRemoveNewsContent).setEnabled(false);
        findViewById(R.id.btnShowNewsContent).setEnabled(true);
        findViewById(R.id.news_content_container).setVisibility(View.GONE);
    }

    @Override
    public void onNewsSelected(News news) {
        if (newsContentFragment != null)
            newsContentFragment.setNewsContent(news.getContent());
    }
}
