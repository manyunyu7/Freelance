package com.tugas.pustaka.util;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    public static final String REAL_URL = "http://ebook-hostinger.feylabs.my.id/";
    private static final String BASE_URL = "http://ebook-hostinger.feylabs.my.id/api/";
    private static Retrofit retrofit = null;

    BookServiceInterface bookServiceInterface;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
