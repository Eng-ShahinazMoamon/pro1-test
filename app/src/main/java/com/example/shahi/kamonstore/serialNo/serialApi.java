package com.example.shahi.kamonstore.serialNo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shahi on 24/01/2019.
 */

public interface serialApi {
        @GET("invoice/getInvoice/{Id}")
        Call<serialModel> getNo(@Path("Id")int inId);
    }
