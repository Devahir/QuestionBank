package com.chitwan.questionbank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.chitwan.questionbank.quizeLayout.Quize;
import com.moengage.core.MoEngage;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MoEngage moEngage=new MoEngage.Builder(this,"1SVDWJ1HK8DCZU7MDXU6Q2WE").build();
//        MoEngage.initialise(moEngage);
    }

    public void makeLayout(View view) {
        Intent openQ=new Intent(MainActivity.this, Quize.class);
        startActivity(openQ);
    }
}