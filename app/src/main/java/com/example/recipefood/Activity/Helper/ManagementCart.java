package com.example.recipefood.Activity.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.recipefood.Activity.Domain.FoodDomain;
import com.example.recipefood.Activity.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB=new TinyDB(context);
    }

public void insertFood(FoodDomain item){
    ArrayList<FoodDomain>list=getListCart();
    boolean existAlready=false;
   int n=0;
    for (int i = 0; i < list.size() ; i++) {
        if(list.get(i).getTitle().equals(item.getTitle())){
            existAlready=true;
            n=i;
            break;
        }
    }
if(existAlready){
    list.get(n).setNumberInCart(item.getNumberInCart());
}else{
    list.add(item);
}
    tinyDB.putListObject("CartList",list);
    Toast.makeText(context, "Added To Your Cart", Toast.LENGTH_SHORT).show();
    }
public ArrayList<FoodDomain> getListCart(){
        return tinyDB.getListObject("CartList");
}

public void plusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
         listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()+1);
         tinyDB.putListObject("CartList",listFood);
changeNumberItemsListener.changed();
    }
public void minusNumberFood(ArrayList<FoodDomain> listFood, int position, ChangeNumberItemsListener changeNumberItemsListener){
        if(listFood.get(position).getNumberInCart()==1){
            listFood.remove(position);
        }else{
            listFood.get(position).setNumberInCart(listFood.get(position).getNumberInCart()-1);
        }

        tinyDB.putListObject("CartList",listFood);
        changeNumberItemsListener.changed();
    }
public Double getTotalPrice(){
        ArrayList<FoodDomain>listFood=getListCart();
        double TotalPrice=0;
    for (int i = 0; i < listFood.size(); i++) {
        TotalPrice+=(listFood.get(i).getPrice()*listFood.get(i).getNumberInCart());
    }
return TotalPrice;
}

}
