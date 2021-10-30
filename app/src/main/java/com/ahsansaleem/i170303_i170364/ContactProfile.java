package com.ahsansaleem.i170303_i170364;


public class ContactProfile {
    private String contactName;
    private String contactPhone;

    private int contactPhoto;

    public ContactProfile(String contactName, String contactPhone, int contactPhoto) {
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.contactPhoto = contactPhoto;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public int getContactPhoto() {
        return contactPhoto;
    }

    public void setContactPhoto(int contactPhoto) {
        this.contactPhoto = contactPhoto;
    }
}
