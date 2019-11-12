package com.example.homework3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class favouriteadapter extends RecyclerView.Adapter<favouriteadapter.favouriteadapterViewHolder> {
    private  static ArrayList<Catimage> breedsList1= new ArrayList<>();
    //private  static ArrayList<Breeds> breedsList2= new ArrayList<>();




    public void setData(ArrayList<Catimage> breedsList) {
        this.breedsList1 = breedsList;

    }

    @NonNull
    @Override
    public favouriteadapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        System.out.println(breedsList1.size());
        View view =
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cat, parent, false);

        // Then create an instance of your custom ViewHolder with the View you got from inflating
        // the layout.
        favouriteadapterViewHolder favouriteadapterViewHolder = new favouriteadapterViewHolder(view);
        return favouriteadapterViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull favouriteadapterViewHolder holder, int position) {
        if (breedsList1.isEmpty() == true) {
            holder.textView.setText("You don't have any favourite cat yet! go to add some!!");

        } else {
            holder.textView.setText(breedsList1.get(position).getBreeds().get(0).getName());
        }

    }

    @Override
    public int getItemCount() {
        if (breedsList1.isEmpty() == false) {
            return breedsList1.size();

       } else {
            return 1;
        }

    }


    public class favouriteadapterViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView textView;

        public favouriteadapterViewHolder(@NonNull View v) {
            super(v);
            view = v;
            textView = view.findViewById(R.id.catnamee);


        }
    }
}
