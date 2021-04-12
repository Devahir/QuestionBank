package com.chitwan.questionbank.Application;

import android.app.Application;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.chitwan.questionbank.R;
import com.chitwan.questionbank.getQuestion.QuestionServer;

public class Coustumapp extends AppCompatActivity {
    LinearLayout line1;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalwork);

        textView=findViewById(R.id.textView12);

        textView.setText("devdatta");
        QuestionServer questionServer=new QuestionServer(this);
        questionServer.SetTExt(textView);
    }
//    @Override
//    public void onCreate() {
//        super.onCreate();
//        Toast.makeText(Coustumapp.this,"Hello Javatpoint",Toast.LENGTH_SHORT).show();
//    }
}
