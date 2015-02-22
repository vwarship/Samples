package com.zaoqibu.fragmentlifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BlankFragment extends Fragment {
    private static final String TAG = "BlankFragment";

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, "onAttach Enter");
        super.onAttach(activity);
        Log.i(TAG, "onAttach Leave");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate Enter");
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate Leave");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView Enter");
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Log.i(TAG, "onCreateView Leave");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated Enter");
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated Leave");
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart Enter");
        super.onStart();
        Log.i(TAG, "onStart Leave");
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume Enter");
        super.onResume();
        Log.i(TAG, "onResume Leave");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause Enter");
        super.onPause();
        Log.i(TAG, "onPause Leave");
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop Enter");
        super.onStop();
        Log.i(TAG, "onStop Leave");
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView Enter");
        super.onDestroyView();
        Log.i(TAG, "onDestroyView Leave");
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy Enter");
        super.onDestroy();
        Log.i(TAG, "onDestroy Leave");
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach Enter");
        super.onDetach();
        Log.i(TAG, "onDetach Leave");
    }

}
