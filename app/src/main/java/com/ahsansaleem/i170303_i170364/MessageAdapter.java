package com.ahsansaleem.i170303_i170364;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context cxt;
    ArrayList<MessageModel> list;

    public static final int MESSENGER_TYPE_INCOMING = 0; // sent by friend
    public   static  final int MESSENGER_TYPE_OUTGOING = 1; // sent by me

    public static final int MESSAGE_TYPE_IMG = 0; // image message
    public static  final int MESSAGE_TYPE_TEXT = 1; // text message

    public  MessageAdapter(Context cxt, ArrayList<MessageModel> list) {
        this.cxt = cxt;
        this.list = list;
    }


    private class MessageIncomingViewHolder extends RecyclerView.ViewHolder {

        TextView friendTextMsg, friendDate;
        ImageView friendImgMsg;
        CircleImageView friendProfileImg;
        MessageIncomingViewHolder(final View itemView) {
            super(itemView);
            friendTextMsg = (TextView) itemView.findViewById(R.id.friend_text_message);
            friendImgMsg = (ImageView) itemView.findViewById(R.id.friend_image_message);
            friendDate = (TextView) itemView.findViewById(R.id.friend_time_stamp);

            friendProfileImg = (CircleImageView) itemView.findViewById(R.id.friend_profile_image);

        }
        void bind(int position) {
            MessageModel messageModel = list.get(position);
            friendDate.setText(messageModel.getMessageDate());
            friendProfileImg.setImageResource(messageModel.getFriendImage());

            if(list.get(position).getMessageType() == MESSAGE_TYPE_IMG) {
                friendTextMsg.setVisibility(View.GONE);
                friendImgMsg.setVisibility(View.VISIBLE);
                friendImgMsg.setImageResource(messageModel.getImageMessage());

            }
            else {
                friendImgMsg.setVisibility(View.GONE);
                friendTextMsg.setVisibility(View.VISIBLE);
                friendTextMsg.setText(messageModel.getTextMessage());

            }
        }
    }


    private class MessageOutgoingViewHolder extends RecyclerView.ViewHolder {

        TextView myTextMsg, myMsgDate;
        ImageView myImgMsg;


        MessageOutgoingViewHolder(final View itemView) {
            super(itemView);
            myTextMsg = (TextView) itemView.findViewById(R.id.my_text_message);
            myImgMsg = (ImageView) itemView.findViewById(R.id.my_image_message);
            myMsgDate = (TextView) itemView.findViewById(R.id.my_time_stamp);



        }
        void bind(int position) {
            MessageModel messageModel = list.get(position);
            myMsgDate.setText(messageModel.getMessageDate());


            if(list.get(position).getMessageType() == MESSAGE_TYPE_IMG) {
                myTextMsg.setVisibility(View.GONE);
                myImgMsg.setVisibility(View.VISIBLE);
                myImgMsg.setImageResource(messageModel.getImageMessage());

            }
            else {
                myImgMsg.setVisibility(View.GONE);
                myTextMsg.setVisibility(View.VISIBLE);
                myTextMsg.setText(messageModel.getTextMessage());

            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MESSENGER_TYPE_INCOMING) {
            return new MessageIncomingViewHolder(LayoutInflater.from(cxt).inflate(R.layout.friend_message, parent, false));
        }
        return new MessageOutgoingViewHolder(LayoutInflater.from(cxt).inflate(R.layout.my_message, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (list.get(position).getMessengerType() == MESSENGER_TYPE_INCOMING) {
            ((MessageIncomingViewHolder) holder).bind(position);
        } else {
            ((MessageOutgoingViewHolder) holder).bind(position);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getMessengerType();
    }
};

