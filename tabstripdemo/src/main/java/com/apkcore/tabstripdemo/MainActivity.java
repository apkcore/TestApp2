package com.apkcore.tabstripdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.apkcore.tabstripdemo.ndk.MessageJni;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MessageJni.getString();", MessageJni.getString());
    }
}
