package com.example.acer.belisendiri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class Customer extends AppCompatActivity {

    public static final String KEY_NAME_VALUE = "NAME_VALUE";
    public static final String KEY_PHONE_VALUE = "PHONE_VALUE";
    public static final String KEY_ADD_VALUE = "ADD_VALUE";


    EditText _name;
    EditText _phone;
    EditText _add;
    Button _save;

    String name = "";
    String phone= "";
    String add = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        if(savedInstanceState != null){
            name = savedInstanceState.getString(KEY_NAME_VALUE, "");
            phone = savedInstanceState.getString(KEY_PHONE_VALUE, "");
            add = savedInstanceState.getString(KEY_ADD_VALUE, "");
        }

        _name = (EditText) findViewById(R.id.nama);
        _phone= (EditText) findViewById(R.id.phone);
        _add  = (EditText) findViewById(R.id.address);
        _save = (Button) findViewById(R.id.save);

        _save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){

                final String inputname = _name.getText().toString();
                final String inputphone = _phone.getText().toString();
                final String inputadd = _add.getText().toString();
                name = _name.getText().toString();
                phone = _phone.getText().toString();
                add = _add.getText().toString();

                if(TextUtils.isEmpty(inputname)){
                    showToastMessaage("Please Enter Your Name!");
                }
                else if(TextUtils.isEmpty(inputphone)){
                    showToastMessaage("Please Enter Your Phone Number!");
                }
                else if(TextUtils.isEmpty(inputadd)){
                    showToastMessaage("Please Enter Your Address!");
                }
                else {
                    Intent intent = new Intent(Customer.this, CustomerDetail.class);
                    intent.putExtra(CustomerDetail.EXTRA_NAME, name);
                    intent.putExtra(CustomerDetail.EXTRA_PHONE, phone);
                    intent.putExtra(CustomerDetail.EXTRA_ADD, add);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_NAME_VALUE, name);
        outState.putString(KEY_PHONE_VALUE, phone);
        outState.putString(KEY_ADD_VALUE, add);
        super.onSaveInstanceState(outState);
    }

    private void showToastMessaage(String message) {
        Toast.makeText(
                Customer.this,
                message,
                Toast.LENGTH_LONG).show();

    }}


