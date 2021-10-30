package com.ahsansaleem.i170303_i170364;

public class CallHistoryProfile {
    private String username;
    private String callType;
    private String timeStamp;
    private boolean onlineStatus;
    private int userPhoto;

    private int callTypeIcon;


    public CallHistoryProfile(String username, String callType, String timeStamp, boolean onlineStatus, int userPhoto, int callTypeIcon) {
        this.username = username;
        this.callType = callType;
        this.timeStamp = timeStamp;
        this.onlineStatus = onlineStatus;
        this.userPhoto = userPhoto;
        this.callTypeIcon = callTypeIcon;
    }


    public boolean isOnlineStatus() {
        return onlineStatus;
    }

    public int getCallTypeIcon() {
        return callTypeIcon;
    }

    public void setCallTypeIcon(int callTypeIcon) {
        this.callTypeIcon = callTypeIcon;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }



    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }



    public void setOnlineStatus(boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(int userPhoto) {
        this.userPhoto = userPhoto;
    }


}
