package com.example.helloword.recylerView.places;

import com.google.gson.JsonObject;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListPlace")
        Call<ResponseBody> getListPlace (@Body JSONObject body);
}
