package com.zaoqibu.viewstub;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {
    private ViewStub viewStub = null;
    private List<String> items = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapter = null;
    final int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItems(count);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(arrayAdapter);
    }

    private void addItems(int count) {
        int begin = items.size();
        int end = items.size() + count;

        for (int i=begin; i<end; ++i)
            items.add(0, String.format("item %d", i+1));
    }

    public void onClickLoadMore(View view) {

        new AsyncTask<Void, Void, Void>() {
            private Button btnLoadMore = null;

            @Override
            protected void onPreExecute() {
                btnLoadMore = (Button)findViewById(R.id.btnLoadMore);
                btnLoadMore.setEnabled(false);

                if (viewStub == null) {
                    viewStub = (ViewStub) findViewById(R.id.viewStubLoading);
                    viewStub.inflate();
//                    or
//                    viewStub = (ViewStub)findViewById(R.id.viewStubLoading);
//                    viewStub.setVisibility(View.VISIBLE);
                }
                else {
                    viewStub.setVisibility(View.VISIBLE);
                }
            }

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                addItems(count);
                arrayAdapter.notifyDataSetChanged();

                viewStub.setVisibility(View.GONE);
                btnLoadMore.setEnabled(true);
            }
        }.execute();
    }

}
