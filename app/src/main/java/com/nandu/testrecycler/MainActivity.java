package com.nandu.testrecycler;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rcView=(RecyclerView)findViewById(R.id.view);
        ArrayList<String> list=new ArrayList<>();
        for (int i=0;i<10;i++){
            list.add(""+i);
        }
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setItemAnimator(new DefaultItemAnimator());
        rcView.setAdapter(new MyAdapter(this, list));
        rcView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                FloatingActionButton btn=(FloatingActionButton)findViewById(R.id.flt_btn);
                Toast.makeText(MainActivity.this, "Scrolling", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
