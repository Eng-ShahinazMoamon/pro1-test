package com.example.shahi.kamonstore.adminLogin;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shahi on 22/01/2019.
 */

public class RetrofitClientLog {
    public static final String Base_Url="http://developertools22-001-site1.etempurl.com/api/";
    public static RetrofitClientLog mInstance;
    private Retrofit retrofit;


    public RetrofitClientLog(){
        //simply used to Log Requests and Responses.
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //okHttpClint to establish the connection
        OkHttpClient client = new OkHttpClient().newBuilder()
                .connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor).build();

        retrofit=new Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }


public static synchronized RetrofitClientLog getInstance(){
    //if it null that mean there is no instance so please create it
    if(mInstance == null){

        mInstance=new RetrofitClientLog();
    }
    return mInstance;

    }

    //method to get Api
    public loginApi getloginApi(){
        return retrofit.create(loginApi.class);

    }
}
