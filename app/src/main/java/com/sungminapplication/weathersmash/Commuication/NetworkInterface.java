package com.sungminapplication.weathersmash.Commuication;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("getData")
    Call<ArrayList<JsonObject>> getApiKey(@Query("type") String type, @Query("dataCd") String dataCd,
                                          @Query("dateCd") String dateCd, @Query("startDt") Integer startDt,
                                          @Query("startHh") String startHh, @Query("endDt") Integer endDt,
                                          @Query("endHh") String endHh, @Query("stnIds") Integer stnIds,
                                          @Query("schListCnt") Integer schListCnt, @Query("pageIndex") Integer pageIndex,
                                          @Query("apiKey") String key);
}