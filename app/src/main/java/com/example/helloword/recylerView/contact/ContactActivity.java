package com.example.helloword.recylerView.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.helloword.R;

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

public class ContactActivity extends AppCompatActivity {
    RecyclerView rcContact;
    ArrayList<Contact> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        init();
        prepareData();
    }

    void init() {
        rcContact = findViewById(R.id.rc_contact);
    }

    void prepareData() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("contactID", 0);
            jsonObject.put("searchKey", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://150.95.115.192/api/")
                .build();
        retrofit.create(ServiceAPI.class).getListContact(jsonObject)
                .enqueue(new Callback<ListContactResponse>() {
                    @Override
                    public void onResponse(Call<ListContactResponse> call, Response<ListContactResponse> response) {
                        data.addAll(response.body().result);
                        config();
                    }

                    @Override
                    public void onFailure(Call<ListContactResponse> call, Throwable t) {

                    }
                });
        /*retrofit.create(ServiceAPI.class).getListContact(jsonObject).
                enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                        try {
                            String res = response.body().string();
                            JSONObject jsonRespon = new JSONObject(res);
                            JSONArray jsonArray = jsonRespon.getJSONArray("result");
                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String contactName = jsonObject.getString("name");
                                String contacePhone = jsonObject.getString("phone");
                                Contact contact = new Contact(contactName, contacePhone);
                                data.add(contact);
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
                });*/
    }

    void config() {

        ContactAdapter contactAdapter = new ContactAdapter();
        contactAdapter.data = data;
        contactAdapter.context = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcContact.setLayoutManager(linearLayoutManager);
        rcContact.setAdapter(contactAdapter);
    }

}
