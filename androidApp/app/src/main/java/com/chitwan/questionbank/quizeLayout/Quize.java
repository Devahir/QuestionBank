package com.chitwan.questionbank.quizeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.chitwan.questionbank.Application.Coustumapp;
import com.chitwan.questionbank.R;
import com.chitwan.questionbank.getQuestion.QuestionServer;
import com.moengage.core.MoEngage;

import java.util.ArrayList;
import java.util.List;

public class Quize extends AppCompatActivity {
    RequestQueue mQueue;
    TextView textView;
    boolean checked=false;
    String work;
    String[] mcq;
    int[] option={0,0,0,0};

    AnswerBord answerBord;
    Button button;

    String Answer,Explainaton;
    ConstraintLayout ll;

    LinearLayout line1,line2,line3, line4;
    TextView opA,opB,opC,opD;
    TextView Explain;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);

      //  mQueue= Volley.newRequestQueue(this);

        opA=findViewById(R.id.opA);
        opB=findViewById(R.id.opB);
        opC=findViewById(R.id.opC);
        opD=findViewById(R.id.opD);

        line1=findViewById(R.id.line1);
        line2=findViewById(R.id.line2);
        line3=findViewById(R.id.line3);
        line4=findViewById(R.id.line4);

        button=findViewById(R.id.submit_area);
        Explain=findViewById(R.id.textView2);


        textView=findViewById(R.id.textview);
        //     option=findViewById(R.id.listOption);
        QuestionServer questionServer=new QuestionServer(this);
        questionServer.SetTExt(textView);
        work=questionServer.getQuestion();
        mcq=work.split("@");
        Explainaton="this is the Explainaton and done";


        List<String> list=new ArrayList<>();
        list.add("A: "+mcq[2]);
        list.add("B: "+mcq[3]);
        list.add("C: "+mcq[4]);
        list.add("D: "+mcq[5]);

        answerBord=new AnswerBord("1000");


        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        //    option.setAdapter(adapter);

        textView.setText(mcq[1]);
        opA.setText("A: "+mcq[2]);
        opB.setText("B: "+mcq[3]);
        opC.setText("C: "+mcq[4]);
        opD.setText("D: "+mcq[5]);

        opA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option[0]==0){
                    line1.setBackgroundResource(R.drawable.backgreen);
                    option[0]=1;
                    checkAnswer(0);
                }else{
                    line1.setBackgroundResource(R.drawable.custum_option);
                    option[0]=0;
                }
            }
        });
        opB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option[1]==0){
                    line2.setBackgroundResource(R.drawable.backgreen);
                    option[1]=1;
                    checkAnswer(1);
                }else{
                    line2.setBackgroundResource(R.drawable.custum_option);
                    option[1]=0;
                }
            }
        });
        opC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option[2]==0){
                    line3.setBackgroundResource(R.drawable.backgreen);
                    option[2]=1;
                    checkAnswer(2);
                }else{
                    line3.setBackgroundResource(R.drawable.custum_option);
                    option[2]=0;
                }
            }
        });
        opD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(option[3]==0){
                    line4.setBackgroundResource(R.drawable.backgreen);
                    option[3]=1;
                    checkAnswer(3);
                }else{
                    line4.setBackgroundResource(R.drawable.custum_option);
                    option[3]=0;
                }
            }
        });






//        String url = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=52772";
//        JsonObjectRequest jsonRequestoe = new JsonObjectRequest
//                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            JSONArray meals = response.getJSONArray("meals");
//                            JSONObject meal=meals.getJSONObject(0);
//
//                            textView.setText(meal.getString("strMeal"));
//
//
//
//                        }catch (JSONException e){
//                            textView.setText("Exception");
//                            e.printStackTrace();
//                        }
//                    }
//                }, new Response.ErrorListener() {
//
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        textView.setText("Error search");
//                    }
//                });
//        mQueue.add(jsonRequestoe);

    }
    private void checkAnswer(int x) {
        for(int i=0;i<4;i++){
            if(i!=x) {
                switch (i){
                    case 0:
                        line1.setBackgroundResource(R.drawable.custum_option);
                        option[0]=0;
                        break;
                    case 1:
                        line2.setBackgroundResource(R.drawable.custum_option);
                        option[1]=0;
                        break;
                    case 2:
                        line3.setBackgroundResource(R.drawable.custum_option);
                        option[2]=0;
                        break;
                    case 3:
                        line4.setBackgroundResource(R.drawable.custum_option);
                        option[3]=0;
                        break;
                }
            }
        }
    }
    public void doSubmit(View view) {
        boolean status=false;
        status=answerBord.check(String.valueOf(option[0])+String.valueOf(option[1])+String.valueOf(option[2])+String.valueOf(option[3]));
        if(status){
            Explain.setText("Correct: "+Explainaton);
        }else Explain.setText("Wrong: "+Explainaton);

        button.setVisibility(View.GONE);
        Intent work=new Intent(Quize.this, Coustumapp.class);
        startActivity(work) ;

    }
}