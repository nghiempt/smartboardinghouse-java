package com.sbh.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sbh.models.Account;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    APIService apiService = new Retrofit.Builder()
            .baseUrl("https://b534-115-75-181-133.ngrok-free.app/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);

    @GET("users")
    Call<List<Account>> getAllAccount();

    @POST("login")
    Call<Map<String, Object>> login(@Body Map<String, String> map);

}
