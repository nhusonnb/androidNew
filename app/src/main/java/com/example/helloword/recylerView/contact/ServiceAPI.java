package com.example.helloword.recylerView.contact;

import org.json.JSONObject;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceAPI {
    @POST("Service/GetListContact")
    Call<ListContactResponse> getListContact (@Body JSONObject body) ;
}
