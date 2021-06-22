package com.example.appretrofit;

import android.content.Context;
import com.example.appretrofit.cookies.ReceivedCookiesInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  {
    Retrofit getRetrofit(Context context){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new ReceivedCookiesInterceptor(context)).build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://digitalisi.tn:8080/bonita/")
                .client(okHttpClient)
                .build();

        return retrofit;
    }





}
