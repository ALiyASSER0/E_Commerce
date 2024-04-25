package com.example.recipefood.Activity.Adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.recipefood.Activity.Activity.ShowDetailsActivity;
import com.example.recipefood.Activity.Domain.FoodDomain;
import com.example.recipefood.R;

import java.util.ArrayList;

public class PoplurarAdapter extends RecyclerView.Adapter<Holder2> {
   ArrayList<FoodDomain> list;

    public PoplurarAdapter(ArrayList<FoodDomain> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_popular,parent,false);

        return new Holder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder2 holder, int position) {

        holder.title.setText(list.get(position).getTitle());
        holder.price.setText(list.get(position).getPrice()+"");

int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(list.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

     holder.addBtn.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {

             Intent intent=new Intent(holder.itemView.getContext(), ShowDetailsActivity.class);
         intent.putExtra("object",  list.get(holder.getAdapterPosition()));
         holder.itemView.getContext().startActivity(intent);
         }
     });


    }
    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
    class Holder2 extends RecyclerView.ViewHolder{
         TextView title,price,addBtn;
         ImageView pic;

    public Holder2(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title2);
        price=itemView.findViewById(R.id.price);
        addBtn=itemView.findViewById(R.id.AddBtn);
        pic=itemView.findViewById(R.id.pic);

    }
}