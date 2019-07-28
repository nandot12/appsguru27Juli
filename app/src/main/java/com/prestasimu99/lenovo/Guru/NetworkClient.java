package com.prestasimu99.lenovo.Guru;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {


    public static HttpLoggingInterceptor logging = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);

    public static OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(logging)
            .build();


    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://apiguru.prestasimu.com/server_guru/index.php/NewApi/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build();

    public static ApiService service = retrofit.create(ApiService.class);
}