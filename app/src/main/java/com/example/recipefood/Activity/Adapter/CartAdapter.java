package com.example.recipefood.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.recipefood.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipefood.Activity.Domain.FoodDomain;
import com.example.recipefood.Activity.Helper.ManagementCart;
import com.example.recipefood.Activity.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<Holder3> {
private ArrayList<FoodDomain>list;
private ManagementCart managementCart;
private ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<FoodDomain> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        this.managementCart =new ManagementCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override



    public Holder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_cart,parent,false);
        return new Holder3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder3 holder, int position) {
       holder.title.setText(list.get(position).getTitle());
       holder.priceEachItem.setText(list.get(position).getPrice()+"");
       holder.totalEachItem.setText(String.valueOf(Math.round((list.get(position).getNumberInCart()*list.get(position).getPrice()))));
     holder.num.setText(list.get(position).getNumberInCart()+"");
     int drawableResourceInt=holder.itemView.getResources().getIdentifier(list.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceInt).into(holder.pic);

      holder.plusItem.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
managementCart.plusNumberFood(list, holder.getAdapterPosition(), new ChangeNumberItemsListener() {
    @Override
    public void changed() {
        notifyDataSetChanged();
        changeNumberItemsListener.changed();
    }
});
          }
      });
holder.minusItem.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        managementCart.minusNumberFood(list, holder.getAdapterPosition(), new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                notifyDataSetChanged();
                changeNumberItemsListener.changed();
            }
        });
    }
});
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
}
class Holder3 extends RecyclerView.ViewHolder{
TextView title,priceEachItem;
ImageView pic,plusItem,minusItem;
TextView totalEachItem,num;
    public Holder3(@NonNull View itemView) {
        super(itemView);
        title=itemView.findViewById(R.id.title5);
        priceEachItem=itemView.findViewById(R.id.num1);
        totalEachItem=itemView.findViewById(R.id.num2);
        pic=itemView.findViewById(R.id.pic2);
        plusItem=itemView.findViewById(R.id.plusCart);
        minusItem=itemView.findViewById(R.id.minusCart);
        num=itemView.findViewById(R.id.numTxt);
    }
}