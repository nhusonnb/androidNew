package com.example.helloword.recylerView.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloword.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHoder> {
    Context context ;
    ArrayList<Contact> data ;
    @NonNull
    @Override
    public ContactViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.contact_layout_json,parent,false) ;
        ContactViewHoder contactViewHoder = new ContactViewHoder(view) ;
        return contactViewHoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHoder holder, int position) {
        Contact contact = data.get(position);
        holder.tvContactName.setText(contact.getName());
        holder.tvContactSdt.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHoder extends RecyclerView.ViewHolder{
        TextView tvContactName,tvContactSdt;
        public ContactViewHoder(@NonNull View itemView) {
            super(itemView);
            tvContactName = itemView.findViewById(R.id.tv_contact_name);
            tvContactSdt = itemView.findViewById(R.id.tv_sdt_contact) ;
        }
    }
}
