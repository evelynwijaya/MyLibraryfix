package com.example.lenovo.mylibrary2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.SimpleTimeZone;

/**
 * Created by Lenovo on 17/12/2017.
 */

public class Buku implements Parcelable {

    private String idbuku;
    private String judul;
    private String author;
    private String tahun;
    private String publisher;

    private String[][] data= new String[][] {
            {"B000111","The Busy Coders Guide to Android Develipment","Mark L.Murphy","2008","CommonWare"},
            {"B000553","Tech your Self Visually Web Design","Rob Huddleston","2011","Wiley"},
            {"B000931","Learning Android Application Testing","Paul Blundell,D.T Milano","2015","Packt Publishing"},
            {"B001211","Begiding Android Programing with Android Studio","J.F.DiMarzio","2017","Wiley"},

    };

    public Buku (String idbuku){
        this.idbuku = idbuku;
        this.caridata();

    }

    private void caridata() {
        for (int i=0;i<this.data.length;i++){
            if (this.idbuku.equals(data[i][0])){
                this.judul=this.data[i][i];
                this.author = this.data[i][2];
                this.tahun = this.data[i][3];
                this.publisher= this.data[i][4];
            }
        }
    }

    public String getIdbuku() {
        return idbuku;
    }

    public void setIdbuku(String idbuku) {
        this.idbuku = idbuku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.idbuku);
        dest.writeString(this.judul);
        dest.writeString(this.author);
        dest.writeString(this.tahun);
        dest.writeString(this.publisher);
    }

    protected Buku(Parcel in) {
        this.idbuku = in.readString();
        this.judul = in.readString();
        this.author = in.readString();
        this.tahun = in.readString();
        this.publisher = in.readString();
    }

    public static final Parcelable.Creator<Buku> CREATOR = new Parcelable.Creator<Buku>() {
        @Override
        public Buku createFromParcel(Parcel source) {
            return new Buku(source);
        }

        @Override
        public Buku[] newArray(int size) {
            return new Buku[size];
        }
    };
}
