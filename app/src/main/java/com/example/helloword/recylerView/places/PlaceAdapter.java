package com.example.helloword.recylerView.places;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHoder> {
    Context context;
    ArrayList<Places> placesArrayList;
    @NonNull
    @Override
    public PlaceViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.places_layout_json , parent,false) ;
        PlaceViewHoder placeViewHoder = new PlaceViewHoder(view) ;
        return placeViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHoder holder, int position) {
        Places places = placesArrayList.get(position) ;
        holder.tvNamePlaces.setText(places.getPlaceName());
        holder.tvIsMoreDetail.setText(places.getIsMoreDetail()+"");
        holder.tvIsPromotion.setText(places.getIsPromotion()+"");
        if(places.isMoreDetail == 0){
            holder.tvIsMoreDetail.setVisibility(View.INVISIBLE);

        }else if( places.isMoreDetail == 0 && places.isPromotion == 0){
            holder.rlHinhNen.setBackgroundColor(context.getResources().getColor(R.color.colorIsmoreDetail));
        }
        else{
            holder.tvIsMoreDetail.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public int getItemCount() {
        return placesArrayList.size();
    }

    class PlaceViewHoder extends RecyclerView.ViewHolder {
        TextView tvNamePlaces ;
        TextView tvIsMoreDetail , tvIsPromotion;
        RelativeLayout rlHinhNen;

        public PlaceViewHoder(@NonNull View itemView) {
            super(itemView);

            tvNamePlaces = itemView.findViewById(R.id.tv_name_places);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_is_mode_detail) ;
            tvIsPromotion = itemView.findViewById(R.id.tv_is_promotion) ;
            rlHinhNen = itemView.findViewById(R.id.rl_hinh_nen) ;



        }
    }
}
