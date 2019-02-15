package com.example.shahi.kamonstore.serialNo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.shahi.kamonstore.R;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class receiptDet extends AppCompatActivity {
    TextView receipt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt_det);
        receipt = (TextView) findViewById(R.id.receiptDet);
//simply used to Log Requests and Responses.
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //okHttpClint to establish the connection
        OkHttpClient client = new OkHttpClient().newBuilder()
                .addInterceptor(loggingInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://developertools22-001-site1.etempurl.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        serialApi sss = retrofit.create(serialApi.class);
        Call<serialModel> cc = sss.getNo(1291731); //nottttttt

        cc.enqueue(new Callback<serialModel>() {
            @Override
            public void onResponse(Call<serialModel> call, Response<serialModel> response) {
                if (!response.isSuccessful()) {
                    receipt.setText("code:" + response.code());
                    return;
                }

                serialModel dd = response.body();
               // for (serialModel dd : pp) {
                    String content = "";
                    content += "Invoice No: " + dd.getInvoiceNo() + "\n";
                    content += "Date : " + dd.getInvoiceDate() + "\n";
                    content += "Customer : " + dd.getCustName() + "\n";
                    content += "Pay Method : " + dd.getPayMethod() + "\n";
                    content += "Discount : " + dd.getInvoiceDiscount() + "\n";
                    content += "Residual : " + dd.getResidual() + "\n";
                    content += "Payment : " + dd.getPayments() + "\n";
                    content += "Invoice Net : " + dd.getInvoiceNet() + "\n";
                    content += "Description : " + dd.getDesciption() + "\n";
                    content += "Type : " + dd.getType() + "\n";
                    content += "Delivered : " + dd.isDelivered() + "\n\n";
                    content += "InvoiceDetails: " + dd.getInvoiceDetails() + "\n";

                receipt.append(content);

               // }
            }

            @Override
            public void onFailure (Call  < serialModel > call, Throwable t){
                receipt.setText(t.getMessage());

            }
        });

    }
}
