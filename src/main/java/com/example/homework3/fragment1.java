package com.example.homework3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.fragment.app.Fragment;


public class fragment1 extends Fragment {
   // private RecyclerView recyclerView;
    SearchView searchView ;


    //List<Breeds> breeds1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.searchviewlayout, container, false);
        searchView = view.findViewById(R.id.Search);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
// do something on text submit
                Context context = getContext();
                CharSequence query1 = searchView.getQuery();
                Intent intent = new Intent(context, SearchResultIntent.class);
                intent.putExtra("query_name", query);
                //System.out.println(query1);
                startActivity(intent);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
// do something when text changes
                return false;
            }
        });

        return view;



    }






    }



