package com.example.homework3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class catdetail extends AppCompatActivity {


    public static ArrayList<Catimage> list1 = new ArrayList<>();
    public static ArrayList<Breeds> list2 = new ArrayList<>();
    //public static ArrayList<Catimage> objectList;
    //public  static HashMap<Catimage, Breeds> list2 = new HashMap<Catimage, Breeds>();

    public static ArrayList<Catimage> newlist = new ArrayList<>();
    private TextView catname;
    private TextView dec;
    private TextView tem;
    private TextView life;
    private TextView wikiurl;
    private TextView imperical;
    private TextView metric;
    private TextView friendless;
    private TextView origin;
    private ImageView catpic;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catdetail);
        catname = findViewById(R.id.catnamee);
        tem = findViewById(R.id.Temperament);
        life = findViewById(R.id.Life_span);
        origin = findViewById(R.id.origin);
        wikiurl = findViewById(R.id.Wikipedia_url);
        friendless = findViewById(R.id.friendliness);
        dec = findViewById(R.id.desc);
        catpic = findViewById(R.id.catpic);
        button = findViewById(R.id.add);
        imperical = findViewById(R.id.imperial);
        metric = findViewById(R.id.matrix);

        Intent intent = getIntent();
        final String breedsid = intent.getStringExtra("breedsid");
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url = "https://api.thecatapi.com/v1/images/search?breed_id=" + breedsid;
        String url2 = "https://api.thecatapi.com/v1/breeds/search?q=" + breedsid;
        try {
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    System.out.println(response);

                    Gson gson = new Gson();
                    Catimage[] enums = gson.fromJson(response, Catimage[].class);
                    final List<Catimage> objectList = Arrays.asList(enums);

                    String imageUrl = objectList.get(0).getUrl();
                    if (imageUrl != null) {
                        Glide.with(getApplicationContext()).load(imageUrl).into(catpic);
                    }

                    imperical.setText(objectList.get(0).getBreeds().get(0).getResult().getImperial());
////
                    metric.setText(objectList.get(0).getBreeds().get(0).getResult().getMetric());

                    catname.setText(objectList.get(0).getBreeds().get(0).getName());

                    tem.setText(objectList.get(0).getBreeds().get(0).getTemperament());

                    life.setText(objectList.get(0).getBreeds().get(0).getLife_span());

                    wikiurl.setText(objectList.get(0).getBreeds().get(0).getWikipedia_url());

                    dec.setText(objectList.get(0).getBreeds().get(0).getDescription());

                    origin.setText(objectList.get(0).getBreeds().get(0).getOrigin());

                    friendless.setText(String.valueOf(objectList.get(0).getBreeds().get(0).getDog_friendly()));

                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            list1.add((objectList.get(0)));
                            Toast.makeText(getApplicationContext(), "Thanks for like (:", Toast.LENGTH_SHORT).show();
                            System.out.println(list1.size());

                        }
                    });
//

                }

            };


            Response.ErrorListener errorListener = new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    requestQueue.stop();
                }
            };


            StringRequest stringRequest = new StringRequest(Request.Method.GET, url, responseListener,
                    errorListener);

            requestQueue.add(stringRequest);

        } catch (Exception e) {

            catpic.setImageResource(R.drawable.downloa1d);

//


        }

    }
}




