package com.sbh.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sbh.response.ListHouseResponse;
import com.sbh.response.ListRoomResponse;
import com.sbh.response.ResponseObject;
import com.sbh.models.Account;
import com.sbh.models.Room;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    APIService apiService = new Retrofit.Builder()
            .baseUrl("http://smartboardinghouse.me:82/api/v1/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(APIService.class);

    @POST("sign_in")
    Call<ResponseObject> _signIn(@Body Map<String, String> map);

    @GET("house/?account_ID=9")
    Call<ListHouseResponse> _getHouseByAccountID();

    @GET("room/?house_ID=1")
    Call<ListRoomResponse> _getRoomByHouseID();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _getRoomByID();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _createRoomEmpty();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _createRoomInfo();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _createTransaction();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _getContractByRoomID();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _getTransactionByID();

    @GET("room/filter?house_id=1")
    Call<ListHouseResponse> _getTransactionByAccountID();

    @GET("Room")
    Call<List<Room>> getAllRoom();

    @GET("Room")
    Call<List<Room>> getAllRoom();

}
