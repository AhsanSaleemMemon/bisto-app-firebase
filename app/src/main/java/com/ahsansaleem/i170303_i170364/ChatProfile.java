package com.ahsansaleem.i170303_i170364;

public class ChatProfile {
    private String messengerName, lastMessage, timestamp, lastMessageType; // messageType refers to a text message or Emoji / stickers
    private boolean lastMessageSender, messengerOnline, messageUnread;
    private int messengerPhoto;


    public ChatProfile(String messengerName, String lastMessage, String timestamp, String lastMessageType, boolean lastMessageSender, boolean messengerOnline, boolean messageUnread, int messengerPhoto) {
        this.messengerName = messengerName;
        this.lastMessage = lastMessage;
        this.timestamp = timestamp;
        this.lastMessageType = lastMessageType;
        this.lastMessageSender = lastMessageSender;
        this.messengerOnline = messengerOnline;
        this.messageUnread = messageUnread;
        this.messengerPhoto = messengerPhoto;
    }

    public String getMessengerName() {
        return messengerName;
    }

    public void setMessengerName(String messengerName) {
        this.messengerName = messengerName;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getLastMessageType() {
        return lastMessageType;
    }

    public void setLastMessageType(String lastMessageType) {
        this.lastMessageType = lastMessageType;
    }

    public boolean isLastMessageSender() {
        return lastMessageSender;
    }

    public void setLastMessageSender(boolean lastMessageSender) {
        this.lastMessageSender = lastMessageSender;
    }

    public boolean isMessengerOnline() {
        return messengerOnline;
    }

    public void setMessengerOnline(boolean messengerOnline) {
        this.messengerOnline = messengerOnline;
    }

    public boolean isMessageUnread() {
        return messageUnread;
    }

    public void setMessageUnread(boolean messageUnread) {
        this.messageUnread = messageUnread;
    }

    public int getMessengerPhoto() {
        return messengerPhoto;
    }

    public void setMessengerPhoto(int messengerPhoto) {
        this.messengerPhoto = messengerPhoto;
    }
}
