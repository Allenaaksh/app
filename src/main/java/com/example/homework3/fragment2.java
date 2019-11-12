package com.example.homework3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment2 extends Fragment {
    private RecyclerView recyclerView;
    ArrayList<Catimage> objectList1=catdetail.list1;
    //public static List<Breeds> objectList;

    //List<Breeds> breeds1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.favourite, container, false);
        recyclerView = view.findViewById(R.id.recycle2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        favouriteadapter favouriteadapter = new favouriteadapter();
        favouriteadapter.setData(objectList1);
        recyclerView.setAdapter(favouriteadapter);


        return view;
    }
    }
