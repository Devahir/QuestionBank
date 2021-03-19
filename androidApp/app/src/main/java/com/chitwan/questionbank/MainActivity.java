package com.chitwan.questionbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    ListView option;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQueue= Volley.newRequestQueue(this);

        textView=findViewById(R.id.textview);
   //     option=findViewById(R.id.listOption);

        String work="0000@Name the bill that was passed in the Parliament that seeks to clarify that allottees under a real estate project should be treated as financial creditors.@insolvency and Bankruptcy Code (Second Amendment) Bill, 2018@Recovery of Non-Performing Assets Bill, 2017@Insolvency and Bankruptcy Code (First Amendment) Bill, 2017@Recovery of Non-Performing Assets (Amendment) Bill, 2018";
        String[] mcq=work.split("@");
        List<String> list=new ArrayList<>();
        list.add("A: "+mcq[2]);
        list.add("B: "+mcq[3]);
        list.add("C: "+mcq[4]);
        list.add("D: "+mcq[5]);




        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
    //    option.setAdapter(adapter);

        textView.setText(mcq[1]);


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
    }
}