package com.arkarzaw.asartaline.datas.models;

import android.content.Context;

import com.arkarzaw.asartaline.ASarTaLineAPI;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class BaseModel {
    protected ASarTaLineAPI theApi;

//    protected AppDataBase dataBaseInstance;

    protected BaseModel(Context context){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-2/asartaline/api/v1/")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        theApi=retrofit.create(ASarTaLineAPI.class);
    }
}
