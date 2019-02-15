package com.example.shahi.kamonstore.serialNo;

import com.example.shahi.kamonstore.adminLogin.loginApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shahi on 22/01/2019.
 */

public class RetrofitClientSer {
    public static final String Base_Url="http://developertools22-001-site1.etempurl.com/api/";
    public static RetrofitClientSer mInstance;
    private Retrofit retrofit;


    public RetrofitClientSer(){
         retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


public static synchronized RetrofitClientSer getInstance(){
    //if it null that mean there is no instance so please create it
    if(mInstance == null){

        mInstance=new RetrofitClientSer();
    }
    return mInstance;

    }

    //method to get Api
    public serialApi getloginApi(){
        return retrofit.create(serialApi.class);

    }
}
