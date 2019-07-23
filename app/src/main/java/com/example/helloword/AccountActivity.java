package com.example.helloword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class AccountActivity extends AppCompatActivity {
    TextView tvName;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        init();

    }

    void init() {
        tvName = findViewById(R.id.tv_xin_chao);
        getData();
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(AccountActivity.this, UserInformation.class);
                intent.putExtra("user", user);

                SharedPreferences sharedPreferences = getSharedPreferences("dekho" , MODE_PRIVATE) ;
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLogin" , true);

                user = (User) intent.getSerializableExtra("user");
             //   editor.putString("xinchao","Xin Chào , " + user.getName() + "(" + user.getPhoneNumber() + ")");
                editor.apply();
                startActivity(intent) ;

            }
        });

    }

    /*void getData() {
        Intent intent = getIntent() ;
        user = (User) intent.getSerializableExtra("user");

        tvName = findViewById(R.id.tv_xin_chao);
       // tvName.setText("Xin Chào , " + user.getName() + "(" + user.getPhoneNumber() + ")");
        SharedPreferences sharedPreferences = getSharedPreferences("dekho", MODE_PRIVATE);
        tvName.setText(sharedPreferences.getString("xinchao",""));
    }*/
    void getData(){
        TextView tvFirstTitle;
        tvFirstTitle = findViewById(R.id.tv_first_title) ;
        try {

            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            JSONObject homeJSON = stringToJson(strData) ;
            JSONObject resultJSON = homeJSON.getJSONObject("result");
            JSONObject customerDetail = resultJSON.getJSONObject("customerDetail");

            String phone = customerDetail.getString("phone") ;
            String name = customerDetail.getString("customerName") ;
            tvName.setText(name + " ( " + phone + " ) ");

            JSONArray listNewJSON = resultJSON.getJSONArray("listNews") ;
            JSONObject fistNewsJSON = listNewJSON.getJSONObject(0) ;
            String urlImage = fistNewsJSON.getString("urlImage");
            tvFirstTitle.setText(fistNewsJSON.getString("title")) ;
            Picasso.get().load(urlImage).into((Target) fistNewsJSON);


        } catch (Exception e) {
             e.printStackTrace();

        }
    }
    JSONObject stringToJson(String strData){
        JSONObject homeJson;
        try {
            homeJson = new JSONObject(strData);
            return homeJson;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
