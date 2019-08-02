package com.example.helloword.recylerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HistoryAdapter extends  RecyclerView.Adapter<HistoryAdapter.HistoryViewHoder>{

    Context context ;
    ArrayList<History> data;

    public HistoryAdapter(Context context, ArrayList<History> data) {
        this.context = context;
        this.data = data;
    }

    public HistoryAdapter() {
    }

    @NonNull
    @Override
    public HistoryViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_item_layout_json,parent,false);
        HistoryViewHoder historyViewHoder = new HistoryViewHoder(view);
        return historyViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHoder holder, int position) {
        History history = data.get(position);
        holder.tvTitle.setText(history.getTitle());
        holder.tvPoint.setText(history.getPoint() + "");
        if(history.point > 10){
            holder.tvPoint.setVisibility(View.INVISIBLE);
        }else{
            holder.tvPoint.setVisibility(View.VISIBLE);
        }
        Picasso.get().load(history.thamChieuAnh).into(holder.ivThamChieuAnh);
        holder.tvSoDu.setText(history.getSoDu() +"");
        holder.tvThoiGian.setText(history.getThoiGian());
        holder.tvMaGiaoDich.setText(history.getMaGiaoDich());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class HistoryViewHoder extends RecyclerView.ViewHolder {
        TextView tvTitle,tvPoint,tvMaGiaoDich,tvThoiGian,tvSoDu ;
        CircleImageView ivThamChieuAnh;

        public HistoryViewHoder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_cong_diem);
            tvPoint = itemView.findViewById(R.id.tv_diem_cong) ;
            tvMaGiaoDich = itemView.findViewById(R.id.tv_ma_giao_dichh);
            tvThoiGian = itemView.findViewById(R.id.tv_thoi_gian);
            tvSoDu = itemView.findViewById(R.id.tv_so_du_tk);
            ivThamChieuAnh = itemView.findViewById(R.id.cirl_profile_image);

        }
    }
}
