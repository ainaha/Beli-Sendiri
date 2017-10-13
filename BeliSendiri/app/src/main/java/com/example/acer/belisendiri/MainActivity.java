package com.example.acer.belisendiri;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton _cust,_shop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _cust = (ImageButton) findViewById(R.id.CustButton);
        _shop = (ImageButton) findViewById(R.id.ShopButton);

        _cust.setOnClickListener(new View.OnClickListener (){
            @Override

            public void onClick(View view) {
                Intent custintent = new Intent(MainActivity.this, Customer.class);
                startActivity(custintent);
            }
        });

        _shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent shopintent = new Intent(MainActivity.this, Shop.class);
                startActivity(shopintent);
            }
        });




    }


}
