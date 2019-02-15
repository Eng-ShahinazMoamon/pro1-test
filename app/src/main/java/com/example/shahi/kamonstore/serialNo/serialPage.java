package com.example.shahi.kamonstore.serialNo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shahi.kamonstore.R;

public class serialPage extends AppCompatActivity implements View.OnClickListener {

    Button se_no1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial_no);
        se_no1 = (Button) findViewById(R.id.Se_no1);
        se_no1.setOnClickListener(this);
    }

            @Override
    public void onClick(View view) {
       Intent serial = new Intent(serialPage.this,receiptDet.class);
        startActivity(serial);
    }
    }

