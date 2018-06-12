package com.hy.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hy.app.maps.R;
import com.hy.features.location.LocationActivity;
import com.hy.features.map.MapActivity;


public class MainActivity extends AppCompatActivity{

    Button mlocation;
    Button mmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();  //初始化view
        initListener();  //初始化多个监听事件
    }

    private void initView(){

        mlocation = (Button) findViewById(R.id.mlocation);
        mmap = (Button) findViewById(R.id.mmap);
    }

    private void initListener(){

        mlocation.setOnClickListener(new MyListener());
        mmap.setOnClickListener(new MyListener());
    }
    private class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {  //同时监听多个事件
            switch (v.getId()) {
                case R.id.mlocation:
                    newLocationActivity();
                    break;
                case R.id.mmap:
                    newMapActivity();
                    break;
                default:
                    break;
            }
        }
    }


    private void newLocationActivity(){
        Intent i = new Intent(MainActivity.this,LocationActivity.class);
        startActivity(i);
    }

    private void newMapActivity(){
        Intent i = new Intent(MainActivity.this,MapActivity.class);
        startActivity(i);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }

}
