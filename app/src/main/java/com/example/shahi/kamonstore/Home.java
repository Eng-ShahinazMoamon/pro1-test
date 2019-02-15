package com.example.shahi.kamonstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shahi.kamonstore.adminLogin.loginPage;
import com.example.shahi.kamonstore.serialNo.serialPage;

public class Home extends AppCompatActivity implements View.OnClickListener{
    Button B_sc_re , B_sc_go , B_admin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        B_admin=(Button)findViewById(R.id.h_admin);
        B_sc_re=(Button)findViewById(R.id.Sc_Re);
        B_sc_go=(Button)findViewById(R.id.Sc_Go);
        B_admin.setOnClickListener(this);
        B_sc_re.setOnClickListener(this);
        B_sc_go.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

           case R.id.Sc_Re:
                Intent scan1 = new Intent (Home.this ,serialPage.class);
                startActivity(scan1);
                break;
      /*      case R.id.Sc_Go:
                Intent scan2 = new Intent (Home.this ,Add_pro_meth.class);
                startActivity(scan2);
                break;*/
            case R.id.h_admin:
                Intent admin = new Intent (Home.this ,loginPage.class);
                startActivity(admin);
                break;





        }
    }
}
