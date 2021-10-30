package com.ahsansaleem.i170303_i170364;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.myViewHolder> {

    List<ChatProfile> list;
    Context cxt;

    public ChatAdapter(List<ChatProfile> list, Context cxt) {
        this.list = list;
        this.cxt = cxt;
    }

    @NonNull
    @Override
    public ChatAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cxt);

        View itemView = inflater.inflate(R.layout.chat_layout, parent, false);

        return new myViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatAdapter.myViewHolder holder, int position) {

        holder.messengerPhoto.setImageResource(list.get(position).getMessengerPhoto());
        holder.messengerName.setText(list.get(position).getMessengerName());

        if(list.get(position).isMessengerOnline()){ holder.onlineStatus.setVisibility(View.VISIBLE); } // if the messenger is online, online status icon will be visible,
        else {holder.onlineStatus.setVisibility(View.INVISIBLE);}                                       // otherwise invisible



        holder.timeStamp.setText(list.get(position).getTimestamp());

        if(list.get(position).isLastMessageSender()) { // if the last message was sent by a friend
            if(list.get(position).isMessageUnread()) { holder.unreadMsgIcon.setVisibility(View.VISIBLE); } // if the message is unread, the unread icon
            else {holder.unreadMsgIcon.setVisibility(View.INVISIBLE);}                                      // will be visible, otherwise invisible

            holder.lastMessage.setText(list.get(position).getLastMessage());
        }
        else { // if the last message was sent by you
            if (list.get(position).getLastMessageType() == "text") { // if the message was a simple text
                holder.lastMessage.setText("You: " + list.get(position).getLastMessage());
            }
            else if(list.get(position).getLastMessageType() == "emoji/sticker"){ // if the message as an emoji/sticker
                holder.lastMessage.setText("You sent a emoji/sticker");
            }
        }

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(cxt, ChatScreenActivity.class);
                cxt.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView messengerPhoto, onlineStatus, unreadMsgIcon;
        TextView messengerName, lastMessage, timeStamp;

        View mView;

        public myViewHolder(@NonNull View itemView) {


            super(itemView);


            messengerPhoto = (CircleImageView) itemView.findViewById(R.id.messenger_photo);
            onlineStatus = (CircleImageView) itemView.findViewById(R.id.online_status);
            unreadMsgIcon = (CircleImageView) itemView.findViewById(R.id.unread_msg_icon);

            messengerName = (TextView) itemView.findViewById(R.id.messenger_name);
            lastMessage = (TextView) itemView.findViewById(R.id.last_message);
            timeStamp = (TextView) itemView.findViewById(R.id.time_stamp);

            mView = itemView;



        }
    }
}
