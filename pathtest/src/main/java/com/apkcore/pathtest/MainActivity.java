package com.apkcore.pathtest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import static com.apkcore.pathtest.R.id.c;

public class MainActivity extends AppCompatActivity {

    private Fragment fr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        if (fr != null) {
            tran.remove(fr);
        }
        fr = new FristFr();
        tran.add(R.id.frame, fr).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction tran = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {
            case R.id.a:
                if (fr != null) {
                    tran.remove(fr);
                }
                fr = new FristFr();
                tran.add(R.id.frame, fr).commit();
                break;
            case R.id.b:
                if (fr != null) {
                    tran.remove(fr);
                }
                fr = new WaveFr();
                tran.add(R.id.frame, fr).commit();
                break;
            case c:
                if (fr != null) {
                    tran.remove(fr);
                }
                fr = new CircleFr();
                tran.add(R.id.frame, fr).commit();
                break;
            default:
                break;
        }
        return true;
    }
}
