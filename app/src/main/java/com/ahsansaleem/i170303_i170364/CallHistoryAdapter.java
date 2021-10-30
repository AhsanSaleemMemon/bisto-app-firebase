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

import de.hdodenhof.circleimageview.CircleImageView;

public class CallHistoryAdapter extends RecyclerView.Adapter<CallHistoryAdapter.myViewHolder> {

    List<CallHistoryProfile> list;
    Context cxt;

    public CallHistoryAdapter(List<CallHistoryProfile> list, Context cxt) {
        this.list = list;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public CallHistoryAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);

        View itemView = inflater.inflate(R.layout.callhistory_layout,parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CallHistoryAdapter.myViewHolder holder, int position) {

        holder.caller_photo.setImageResource(list.get(position).getUserPhoto());

        if(list.get(position).isOnlineStatus()) {
            holder.status_icon.setVisibility(View.VISIBLE);
        }
        else {
            holder.status_icon.setVisibility(View.INVISIBLE);
        }
        holder.call_type_icon.setImageResource(list.get(position).getCallTypeIcon());

        holder.caller_name.setText(list.get(position).getUsername());
        holder.call_type.setText(list.get(position).getCallType());
        holder.time_stamp.setText(list.get(position).getTimeStamp());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {

        CircleImageView caller_photo,  status_icon;
        ImageView call_type_icon;
        TextView caller_name, call_type, time_stamp;
        View mView;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            caller_photo = (CircleImageView) itemView.findViewById(R.id.caller_photo);
            call_type_icon = (ImageView) itemView.findViewById(R.id.call_type_icon);
            status_icon = (CircleImageView) itemView.findViewById(R.id.status_icon);

            caller_name = (TextView) itemView.findViewById(R.id.caller_name);
            call_type = (TextView) itemView.findViewById(R.id.call_type);
            time_stamp = (TextView) itemView.findViewById(R.id.time_stamp);

            mView = itemView;

        }
    }
}
