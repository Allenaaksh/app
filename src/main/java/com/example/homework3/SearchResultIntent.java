package com.example.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchResultIntent extends AppCompatActivity {

    private TextView textView;
    private RecyclerView recyclerView;
    public static String result;

    //static List<Breeds> list2;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchresult);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        Intent intent = getIntent();
         result = intent.getStringExtra("query_name");
        String url = " https://api.thecatapi.com/v1/breeds/search?q="+result;
        recyclerView = findViewById(R.id.recyleview1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final ArrayList<Breeds> list2 = new ArrayList<>();

        //System.out.println(name);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                Gson gson = new Gson();
                Breeds[] enums = gson.fromJson(response, Breeds[].class);
                List<Breeds> objectList = Arrays.asList(enums);
                Intent intent = getIntent();

//
                SearchResultAdapter searchadpater = new SearchResultAdapter();
                recyclerView.setAdapter(searchadpater);
                searchadpater.setData(objectList);


            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText("The request failed: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                requestQueue.stop();
            }
        };

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                errorListener);

        requestQueue.add(stringRequest);

    }


}
