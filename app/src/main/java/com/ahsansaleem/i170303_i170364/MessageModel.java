package com.ahsansaleem.i170303_i170364;


import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MessageModel {

    private int messengerType, messageType; // messageType refers to a image message (0) or text msg (1)
    private int friendImage, imageMessage; // if the message came from a friend
    private String textMessage;
    private String messageDate;

    public MessageModel(int messengerType, int messageType, int friendImage, String textMessage, int imageMessage, String messageDate) {
        this.messengerType = messengerType;
        this.messageType = messageType;
        this.friendImage = friendImage;
        this.textMessage = textMessage;
        this.imageMessage = imageMessage;
        this.messageDate = messageDate;
    }

    public int getImageMessage() {
        return imageMessage;
    }

    public void setImageMessage(int imageMessage) {
        this.imageMessage = imageMessage;
    }

    public int getMessengerType() {
        return messengerType;
    }

    public void setMessengerType(int messengerType) {
        this.messengerType = messengerType;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public int getFriendImage() {
        return friendImage;
    }

    public void setFriendImage(int friendImage) {
        this.friendImage = friendImage;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }



}
