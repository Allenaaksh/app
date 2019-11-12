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

public class searchresultintent extends AppCompatActivity {

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

//                AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database_name").allowMainThreadQueries().build();
//
//                //inserting each book object into the database if the db does not exist
//                if(db.bookDao().getCount() == 0) {
//                    for (int i = 0; i < objectList.size(); i++) {
//                        Breeds breeds = objectList.get(i);
//                        db.bookDao().insert(breeds);
//                    }
//                }
                // List<Breeds> list1= fragment1.objectList;

                //Breeds breeds = new Breeds();
                //Intent intent = getIntent();
                // List<Breeds> list1= fragment1.objectList;

                // Breeds breeds = new Breeds();
//
//                String name = intent.getStringExtra("query_name");
//                System.out.println(name+"this  is name");
//                System.out.println(objectList.get(1).getName());


                System.out.println(intent.getStringExtra("query_name"));

//                for (int i = 0; i < objectList.size(); i++) {
//
//                    if (intent.getStringExtra("query_name").equals(objectList.get(i).getName())) {
//                        System.out.println("did it");
//                        System.out.println(intent.getStringExtra("query_name"));
//
//                        list2.add(objectList.get(i));
//                    }
//                   // System.out.println(list2.get(0).getAlt_names());
//
//
//
//
//                }



                searchadapter searchadpater = new searchadapter();
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
