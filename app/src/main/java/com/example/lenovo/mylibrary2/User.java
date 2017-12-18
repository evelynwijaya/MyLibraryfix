package com.example.lenovo.mylibrary2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lenovo on 17/12/2017.
 */

public class User implements Parcelable {
    private String email;
    private String password;
    private String namalengkap;
    private String telp;

    protected String[][] data = new String[][]{
            {"001","sofyan.thayf@kharisma.ac.id","111","Sofyan Thayf","082193149209"},
            {"002","saprianto_16@kharisma.ac.id","222","Aprianto","082193149209"},
            {"003","florenciairena_16@kharisma.ac.id","333","Florencia Irena","082193149209"},
            {"004","evelynwilbert_16@kharisma.ac.id","444","Evelyn Wijaya","082193149209"},
            {"005","winnyclaudia_16@kharisma.ac.id","555","Winny Claudia","082193149209"},
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNamalengkap() {
        return namalengkap;
    }

    public void setNamalengkap(String namalengkap) {
        this.namalengkap = namalengkap;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.password);
        dest.writeString(this.namalengkap);
        dest.writeString(this.telp);
    }

    public User() {
    }

    protected User(Parcel in) {
        this.email = in.readString();
        this.password = in.readString();
        this.namalengkap = in.readString();
        this.telp = in.readString();
    }

}
