package com.example.recipefood.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.recipefood.Activity.Domain.FoodDomain;
import com.example.recipefood.Activity.Helper.ManagementCart;
import com.example.recipefood.databinding.ActivityShowDetailsBinding;

public class ShowDetailsActivity extends AppCompatActivity {
ActivityShowDetailsBinding binding;
private FoodDomain object;
int numberOrder=1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding=ActivityShowDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        managementCart=new ManagementCart(this);
          getBundle();

    }

    private void getBundle() {

       object= (FoodDomain) getIntent().getSerializableExtra("object");
int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(binding.imageView);
binding.titleText.setText(object.getTitle());
binding.description.setText(object.getDescription());
binding.priceText.setText("$"+object.getPrice());
binding.number.setText(numberOrder+"");

binding.plus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        numberOrder+=1;
        binding.number.setText(numberOrder+"");
    }
});
binding.minus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       if(numberOrder>1){
           numberOrder-=1;
           binding.number.setText(numberOrder+"");
       }else{
           binding.number.setText(numberOrder+"");
       }

    }
});
binding.addToCartBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        object.setNumberInCart(numberOrder);
        managementCart.insertFood(object);
    }
});

    }





}