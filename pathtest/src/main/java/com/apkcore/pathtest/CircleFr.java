package com.apkcore.pathtest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 小球
 * Created by Apkcore on 2017/3/22.
 */

public class CircleFr extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.circle_path_fr, null);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(this.getClass().getSimpleName());
        return view;
    }
}