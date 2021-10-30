package com.ahsansaleem.i170303_i170364;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.myViewHolder>

{

    List<ContactProfile> list;
    Context cxt;

    public ContactAdapter(List<ContactProfile> list, Context cxt) {
        this.list = list;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public ContactAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);

        View itemView = inflater.inflate(R.layout.contacts_layout, parent, false);

        return  new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.myViewHolder holder, int position) {
        holder.contactPhoto.setImageResource(list.get(position).getContactPhoto());
        holder.contactPhone.setText(list.get(position).getContactPhone());
        holder.contactName.setText(list.get(position).getContactName());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        CircleImageView contactPhoto;
        ImageView contactClickButton;
        TextView contactName, contactPhone;

        View mView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            contactPhoto = (CircleImageView) itemView.findViewById(R.id.contact_photo);
            contactClickButton = (ImageView) itemView.findViewById(R.id.contact_click_button);

            contactName = (TextView) itemView.findViewById(R.id.contact_name);
            contactPhone = (TextView) itemView.findViewById(R.id.contact_phone);

        }
    }
}

