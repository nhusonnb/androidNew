package com.example.helloword.recylerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.helloword.R;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rcHistory;
    ArrayList<History> data ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        prepareData();
        confix();
    }
    void init(){
        rcHistory = findViewById(R.id.rc_history);
    }
    void prepareData(){
        data = new ArrayList<>() ;
        for (int i = 0; i < 100; i++) {
            History history = new History("title "+ i,i);
            data.add(history);
        }
    }
    void confix(){
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this ,RecyclerView.VERTICAL,false) ;
     //   LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false) ;
        rcHistory.setLayoutManager(linearLayoutManager);
        rcHistory.setAdapter(historyAdapter);
    }

}
