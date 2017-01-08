package com.msaeed.mobile.cleanapplication.networking.retrofit;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akhalaf on 10/24/2016.
 */
public class RetrofitApi {

    private static RetrofitApi sInstance;
    private final String BASE_URL = "https://api.github.com/";
    private RetrofitAPIService service;

    private RetrofitApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitAPIService.class);

    }

    public static synchronized RetrofitApi getsInstance() {
        if (sInstance == null) {
            sInstance = new RetrofitApi();
        }
        return sInstance;
    }

    public RetrofitAPIService getService() {
        return service;
    }


}


