package com.example.acer.belisendiri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class CustomerDetail extends AppCompatActivity {

    public  static final String EXTRA_NAME = "EXTRA_NAME";
    public  static final String EXTRA_PHONE = "EXTRA_PHONE";
    public  static final String EXTRA_ADD = "EXTRA_ADD";
    TextView _detailname;
    TextView _detailphone;
    TextView _detailaddress;

    String name = "";
    String phone = "";
    String add = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_detail);

        _detailname = (TextView) findViewById(R.id.detailnama);
        _detailphone = (TextView) findViewById(R.id.detailphone);
        _detailaddress =(TextView) findViewById(R.id.detailaddress);

        if(getIntent() != null){
            if (getIntent().hasExtra(EXTRA_NAME)) {
                name = getIntent().getStringExtra(EXTRA_NAME);

                if (getIntent().hasExtra(EXTRA_PHONE)) {

                    phone = getIntent().getStringExtra(EXTRA_PHONE);

                    if (getIntent().hasExtra(EXTRA_ADD)) {

                        add = getIntent().getStringExtra(EXTRA_ADD);
                    }
                }
            }
        }

        if (!TextUtils.isEmpty(name)) {
            _detailname.setText ("Nama          : " + name);
            _detailphone.setText("Phone         : " + phone);
            _detailaddress.setText("Address     : " + add);
        }
    }
}
