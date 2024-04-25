package com.example.recipefood.Activity.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recipefood.Activity.Adapter.CategoryAdapter;
import com.example.recipefood.Activity.Adapter.PoplurarAdapter;
import com.example.recipefood.Activity.Domain.CategoryDomain;
import com.example.recipefood.Activity.Domain.FoodDomain;
import com.example.recipefood.R;
import com.example.recipefood.databinding.ActivityMainBinding;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewCategoryList,recyclerViewPoplurarList;
    private CategoryAdapter categoryAdapter;
    private PoplurarAdapter PoplurarAdapter;
    ActivityMainBinding binding;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        recyclerViewCategor();
        recyclerViewPoplurar();
        bottomNavigation();

    }


    private void recyclerViewCategor() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.Rec);

        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> list = new ArrayList<>();
        list.add(new CategoryDomain("Pizza", "cat_1"));
        list.add(new CategoryDomain("Burger", "cat_2"));
        list.add(new CategoryDomain("Hotdog", "cat_3"));
        list.add(new CategoryDomain("Drink", "cat_4"));
        list.add(new CategoryDomain("Dount", "cat_5"));
        categoryAdapter = new CategoryAdapter(list);
        recyclerViewCategoryList.setAdapter(categoryAdapter);

    }
    private void bottomNavigation(){
        binding.cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
        binding.homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));

            }
        });
    }

    private void recyclerViewPoplurar() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPoplurarList=findViewById(R.id.Rec2);
        recyclerViewPoplurarList.setLayoutManager(linearLayoutManager);
        ArrayList<FoodDomain> list = new ArrayList<>();
    list.add(new FoodDomain("Pepperoni pizza","pizza1","slice pepperoni,mozzerella cheese,fresh oregan,ground black pepper,pizza sauce",10.85));
    list.add(new FoodDomain("Cheese Burger","burger","beef,Gouda Chesse,special Sauce,Lettuce,tomato",8.74));
    list.add(new FoodDomain("Vegetable pizza","pizza3","olive oil,Vegetable oil,pitted kalamata,cherry tomatoes,fresh oregano,basil",5.5));
        PoplurarAdapter=new PoplurarAdapter(list);
        recyclerViewPoplurarList.setAdapter(PoplurarAdapter);


    }
}







