package com.example.helloword.recylerView.places;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.helloword.R;
import com.example.helloword.recylerView.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceActivity extends AppCompatActivity {

    RecyclerView rcPlaces ;
    ArrayList<Place> data = new ArrayList<>() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        init();
        prepareData();

    }
    void init(){
        rcPlaces = findViewById(R.id.rc_places) ;
    }
    void prepareData(){
        // lay du lieu tu file json co san
        data = new ArrayList<>();
        JSONObject jsonPlaces = Util.fileToJSonPlaces(R.raw.places,this);

        // len server va lay du lieu

        JSONObject jsonObject = new JSONObject() ;
        try {
            jsonObject.put("cateID",0);
            jsonObject.put("placeID",0);
            jsonObject.put("searchKey",0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build() ;
        retrofit.create(ServiceAPI.class).getListPlace(jsonObject)
                .enqueue(new Callback<ListPlaceResponse>() {
                    @Override
                    public void onResponse(Call<ListPlaceResponse> call, Response<ListPlaceResponse> response) {
                        data.addAll(response.body().result) ;
                        config();
                    }

                    @Override
                    public void onFailure(Call<ListPlaceResponse> call, Throwable t) {

                    }
                });


        /*retrofit.create(ServiceAPI.class).getListPlace(jsonObject).
                enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    String res = response.body().string() ;
                    JSONObject jsonRespon = new JSONObject(res) ;
                    JSONArray jsonArray = jsonRespon.getJSONArray("result");
                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String placename = jsonObject.getString("placeName");
                        int isMoreDetail = jsonObject.getInt("isMoreDetail");
                        int isPromotion = jsonObject.getInt("isPromotion");
                        Places places = new Places(placename, isMoreDetail, isPromotion);
                        data.add(places);
                    }
                        config();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("", "onResponse: ");

            }
        });
*/







        /*try {
            JSONArray jsonArray = jsonPlaces.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String placename = jsonObject.getString("placeName") ;
                int isMoreDetail = jsonObject.getInt("isMoreDetail") ;
                int isPromotion = jsonObject.getInt("isPromotion") ;
                Places places = new Places(placename,isMoreDetail,isPromotion);
                data.add(places);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
    void config(){
        PlaceAdapter placeAdapter = new PlaceAdapter() ;
        placeAdapter.placesArrayList = data ;
        placeAdapter.context = this ;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false) ;
        rcPlaces.setLayoutManager(linearLayoutManager);
        rcPlaces.setAdapter(placeAdapter);
    }


}
