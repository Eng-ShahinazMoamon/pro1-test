package com.example.shahi.kamonstore.adminLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shahi.kamonstore.R;
import com.example.shahi.kamonstore.Totals;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class loginPage extends AppCompatActivity implements View.OnClickListener {
    Button lo_admin;
    EditText user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        user = (EditText) findViewById(R.id.user_name);
        password = (EditText) findViewById(R.id.password);
        lo_admin = (Button) findViewById(R.id.login_admin);
        lo_admin.setOnClickListener(this);
    }


    private void loginAd() {
        final String username = user.getText().toString().trim();

        final String pass = password.getText().toString().trim();
        if (username.isEmpty()) {
            user.setError("User is required");
            user.requestFocus();
            return;

        }

        if (pass.isEmpty()) {
            password.setError("pass is required ");
            password.requestFocus();
            return;
        }
        if (password.length() < 6) {
            password.setError("length is short ");
            password.requestFocus();
            return;
        }else {

            //Okhttp
//        OkHttpClient.Builder client = new OkHttpClient.Builder();
//        client.connectTimeout(60, TimeUnit.SECONDS);
//        client.readTimeout(60, TimeUnit.SECONDS);
//        client.writeTimeout(60, TimeUnit.SECONDS);
            //Object for  Library that we need to  call (Retrofit)

            Call<loginModel> call = RetrofitClientLog
                    .getInstance().getloginApi().dologin(username, pass);
            call.enqueue(new Callback<loginModel>() {
                @Override
                public void onResponse(Call<loginModel> call, Response<loginModel> response) {
                    if (response.isSuccessful()) {
                        Intent intent = new Intent(loginPage.this, Totals.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(getApplicationContext(), "Not Correct", Toast.LENGTH_SHORT);

//                loginModel loginMod = response.body();
//                if (!loginMod.isError()) {
//
//                } else {
//                    Toast.makeText(getApplicationContext(),"Not Correct",Toast.LENGTH_SHORT);
//                    Intent intent = new Intent(loginPage.this, Totals.class);
//                    startActivity(intent);
//                }
                }

                @Override
                public void onFailure(Call<loginModel> call, Throwable t) {

                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.login_admin:
                loginAd();
                break;
        }

    }
}
     /*   Retrofit retrofit=new Retrofit.Builder()
                //builder needs base url
                .baseUrl(loginApi.Base_Url )
                //to convert from Json string into object
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Create object from login mpodel that's contain our info
         loginApi loginApi=retrofit.create(loginApi.class);
        //call this method
*/