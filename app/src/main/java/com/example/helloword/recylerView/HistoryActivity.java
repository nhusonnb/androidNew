package com.example.helloword.recylerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.location.Address;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helloword.R;
import com.example.helloword.recylerView.util.Util;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rcHistory;
    ArrayList<History> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        prepareData();
        confix();
    }

    void init() {

        rcHistory = findViewById(R.id.rc_history);
    }

    void prepareData() {
        data = new ArrayList<>();
        JSONObject jsonHistory = Util.fileToJSon(R.raw.history, this);
        try {
            JSONArray jsonArray = jsonHistory.getJSONArray("result");
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int point = jsonObject.getInt("point");
                String maCode = jsonObject.getString("addpointCode");
                String ngayThang = jsonObject.getString("createDate");
                String title = jsonObject.getString("title");
                int soDuTk = jsonObject.getInt("balance");
                String icon = jsonObject.getString("icon");
                History history = new History(point, maCode, ngayThang, title, soDuTk, icon);
                data.add(history);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void confix() {
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcHistory.setLayoutManager(linearLayoutManager);
        rcHistory.setAdapter(historyAdapter);
    }

    JSONObject stringToJson(String strData) {
        JSONObject historyJson;
        try {
            historyJson = new JSONObject(strData);
            return historyJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
