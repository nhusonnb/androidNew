package com.example.helloword.recylerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;

import java.util.ArrayList;

public class HistoryAdapter extends  RecyclerView.Adapter<HistoryAdapter.HistoryViewHoder>{

    Context context ;
    ArrayList<History> data;
    @NonNull
    @Override
    public HistoryViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout,parent,false);
        HistoryViewHoder historyViewHoder = new HistoryViewHoder(view);
        return historyViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHoder holder, int position) {
        History history = data.get(position);
        holder.tvTitle.setText(history.getTitle());
        holder.tvPoint.setText(history.getPoint() + "");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HistoryViewHoder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvPoint;

        public HistoryViewHoder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPoint = itemView.findViewById(R.id.tv_point) ;

        }
    }
}
