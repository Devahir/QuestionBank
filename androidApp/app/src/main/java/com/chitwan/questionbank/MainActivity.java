package com.chitwan.questionbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RequestQueue mQueue;
    TextView textView;
    String work;
    String[] mcq;
    ListView option;

    Button button;

    String Answer,Explainaton;

    ConstraintLayout ll;

    LinearLayout line1,line2,line3, line4;

    TextView opA,opB,opC,opD;

    TextView Explain;

    @Override
    public void onBackPressed() {
        line1.setVisibility(View.VISIBLE);
        line2.setVisibility(View.VISIBLE);
        line3.setVisibility(View.VISIBLE);
        line4.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue= Volley.newRequestQueue(this);

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

        work="0000@Name the bill that was passed in the Parliament that seeks to clarify that allottees under a real estate project should be treated as financial creditors.@insolvency and Bankruptcy Code (Second Amendment) Bill, 2018@Recovery of Non-Performing Assets Bill, 2017@Insolvency and Bankruptcy Code (First Amendment) Bill, 2017@Recovery of Non-Performing Assets (Amendment) Bill, 2018";
        mcq=work.split("@");
        Explainaton="this is the Explainaton";
        List<String> list=new ArrayList<>();
        list.add("A: "+mcq[2]);
        list.add("B: "+mcq[3]);
        list.add("C: "+mcq[4]);
        list.add("D: "+mcq[5]);




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
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                line4.setVisibility(View.GONE);
            }
        });
        opB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line1.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                line4.setVisibility(View.GONE);
            }
        });
        opC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line2.setVisibility(View.GONE);
                line1.setVisibility(View.GONE);
                line4.setVisibility(View.GONE);
            }
        });
        opD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line2.setVisibility(View.GONE);
                line3.setVisibility(View.GONE);
                line1.setVisibility(View.GONE);
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

    public void doSubmit(View view) {
        Explain.setText(Explainaton);
        button.setVisibility(View.INVISIBLE);
    }
}