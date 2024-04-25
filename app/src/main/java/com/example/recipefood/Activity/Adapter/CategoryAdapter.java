package com.example.recipefood.Activity.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipefood.Activity.Domain.CategoryDomain;
import com.example.recipefood.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<Holder> {
   ArrayList<CategoryDomain> list;

    public CategoryAdapter(ArrayList<CategoryDomain> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.categoryName.setText(list.get(position).getTitle());
        String PicUrl="";
        switch (position){
            case 0:{
                PicUrl="cat_1";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
                    break;
            }
            case 1:{
                PicUrl="cat_2";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
                break;
             }
            case 2:{
                PicUrl="cat_3";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
                break;
            }
            case 3:{
                PicUrl="cat_4";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
                break;
            }
            case 4:{
                PicUrl="cat_5";
                holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
                break;
            }
        }
int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(PicUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
class Holder extends RecyclerView.ViewHolder{
     TextView categoryName;
     ImageView categoryPic;
     ConstraintLayout mainLayout;
    public Holder(@NonNull View itemView) {
        super(itemView);
        categoryName=itemView.findViewById(R.id.CategoryName);
        categoryPic=itemView.findViewById(R.id.CategoryPic);
        mainLayout=itemView.findViewById(R.id.MainLayoutt);

    }
}