package com.example.homework3;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.favouriteadapterViewHolder> {
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
    public void onBindViewHolder(@NonNull favouriteadapterViewHolder holder, final int position) {
        if (breedsList1.isEmpty() == true) {
            holder.textView.setText("You don't have any favourite cat yet! go to add some!!");

        } else {
            holder.textView.setText(breedsList1.get(position).getBreeds().get(0).getName());
        }
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();

                Intent intent = new Intent(context, Catdetail.class);
                intent.putExtra("breedsid", breedsList1.get(position).getBreeds().get(0).getId());
                context.startActivity(intent);

            }
        });

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
        public ConstraintLayout constraintLayout;


        public favouriteadapterViewHolder(@NonNull View v) {
            super(v);
            view = v;
            textView = view.findViewById(R.id.catnamee);
            constraintLayout = v.findViewById(R.id.layout);


        }
    }
}
