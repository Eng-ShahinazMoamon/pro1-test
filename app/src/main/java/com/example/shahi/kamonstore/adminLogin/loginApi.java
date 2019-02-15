package com.example.shahi.kamonstore.adminLogin;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by shahi on 26/01/2019.
 */

public interface loginApi {
  //  String Base_Url="http://developertools22-001-site1.etempurl.com";

      /*  @POST ("user/Login")
        Call<loginModel> dologin (@Body String user);*/



        @FormUrlEncoded
        @POST("user/Login")
        Call<loginModel> dologin(
                @Field("Username") String userApi,
                @Field("Password") String passApi
        );
}
