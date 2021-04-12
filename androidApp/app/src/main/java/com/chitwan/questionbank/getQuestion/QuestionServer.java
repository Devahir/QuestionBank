package com.chitwan.questionbank.getQuestion;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.chitwan.questionbank.quizeLayout.Quize;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.google.android.material.internal.ContextUtils.getActivity;


public class QuestionServer{
    RequestQueue mQueue;
    String work="0000@Name the bill that was passed in the Parliament that seeks to clarify that allottees under a real estate project should be treated as financial creditors.@insolvency and Bankruptcy Code (Second Amendment) Bill, 2018@Recovery of Non-Performing Assets Bill, 2017@Insolvency and Bankruptcy Code (First Amendment) Bill, 2017@Recovery of Non-Performing Assets (Amendment) Bill, 2018";

    public String getQuestion(){
        return work;
    }
    public QuestionServer(Context context){
        mQueue= Volley.newRequestQueue(context);
    }
    String url;
    public void SetTExt(TextView textView){
        textView.setText("working and you can procide");
    }
    public String serveQ(TextView textView){
        String result;
        JsonObjectRequest jsonR = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray meals = response.getJSONArray("meals");
                            JSONObject meal=meals.getJSONObject(0);
                            String ss=meal.getString("strMeal");
                            textView.setText(ss);
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //  textView.setText("Error search");
                    }
                });
        mQueue.add(jsonR);
        return "I got";
    }
}
