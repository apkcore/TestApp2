package com.apkcore.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * demo fo recyclerview
 * 实现加载不同item
 * 实现分割线
 * 实现分割线头部悬留
 * http://www.jianshu.com/p/b46a4ff7c10a
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
       final List<String> strs = new ArrayList<>();
        strs.add("aewwwwwwww");
        strs.add("aewwwwwwww");
        strs.add("aewwwwwwww");
        strs.add("aewwwwwwww");
        strs.add("aewwwwwwww");

        strs.add("cewwwccwwwww");
        strs.add("cewwwwwwww");
        strs.add("cewwwwwwww");
        strs.add("cewwwwwwww");

        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");
        strs.add("dsgfhdfshsh");


        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        strs.add("zzzzzzzzzzzzzzzzz");
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.addItemDecoration(new SimplePaddingDecoration(this));
        rv.addItemDecoration(new LeftAndRightTagDecoration(this));
        rv.addItemDecoration(new SectionDecoration(this, new SectionDecoration.DecorationCallback() {
            @Override
            public long getGroupId(int position) {
                return Character.toUpperCase(strs.get(position).charAt(0));
            }

            @Override
            public String getGroupFirstLine(int position) {
                return strs.get(position).substring(0, 1).toUpperCase();
            }
        }));

        RvAdapter adapter = new RvAdapter(this, strs);
        rv.setAdapter(adapter);
    }
}
