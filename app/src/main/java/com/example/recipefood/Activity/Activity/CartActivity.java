package com.example.recipefood.Activity.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.recipefood.Activity.Adapter.CartAdapter;
import com.example.recipefood.Activity.Helper.ManagementCart;
import com.example.recipefood.Activity.Interface.ChangeNumberItemsListener;
import com.example.recipefood.databinding.ActivityCartBinding;

public class CartActivity extends AppCompatActivity {
ActivityCartBinding binding;
private CartAdapter adapter;

private ManagementCart managementCart;


@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
     managementCart=new ManagementCart(this);
initRecycle();
    CalculatorCart();
    bottomNavigation();


    }

    private void bottomNavigation(){
    binding.cartBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(CartActivity.this,CartActivity.class));

        }
    });
binding.homeBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        startActivity(new Intent(CartActivity.this,MainActivity.class));
    }
});
    }
    private void initRecycle() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        binding.Rec3.setLayoutManager(linearLayoutManager);

        adapter=new CartAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
          @Override
          public void changed() {
              CalculatorCart();
          }
      });
        binding.Rec3.setAdapter(adapter);


        if(managementCart.getListCart().isEmpty()){
            binding.emptyTxt.setVisibility(View.VISIBLE);
            binding.scrollView2.setVisibility(View.GONE);

        }else{
            binding.emptyTxt.setVisibility(View.GONE);
            binding.scrollView2.setVisibility(View.VISIBLE);
        }

}

 private void CalculatorCart(){
    double percentTax=0.02;
    double delivery=10;
    double tax= Math.round(managementCart.getTotalPrice()*percentTax);
    double total=Math.round(managementCart.getTotalPrice()+tax+delivery);
    double itemTotal=Math.round(managementCart.getTotalPrice());
    binding.totalPriceTxt.setText("$"+itemTotal);
     binding.TotalNumber.setText("$"+total);
      binding.TaxNumber.setText("$"+tax);
      binding.TaxDeliveryNum.setText("$"+delivery);
      }
}