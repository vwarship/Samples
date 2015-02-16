package com.zaoqibu.listfragmentexample;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by vwarship on 2015/2/16.
 */
public class MyListFragment extends ListFragment {
    String [] as = {"wjj", "gxl"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_listfragment, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, as));
    }
}
