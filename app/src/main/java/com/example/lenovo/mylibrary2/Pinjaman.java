package com.example.lenovo.mylibrary2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.SimpleTimeZone;

/**
 * Created by Lenovo on 17/12/2017.
 */

public class Pinjaman implements Parcelable {
   private Buku buku;
   private String tglpinjam;
   private String tglkembali;
   private String id_member;
   private int status =0;

   private String [][] data = new String [][]{
           {"B000931","001","05 Des 2017","12 Des 2017"},
           {"B001211","003","02 Des 2017","8 Des 2017"},
           {"B000931","004","03 Des 2017","9 Des 2017"},
   };


    public Pinjaman(String id_member) {
        this.id_member = id_member;
        this.caridata();

    }

    private void caridata() {
       for (int i = 0;i<this.data.length;i++){
          if (this.id_member.equals(data[i][1])){
              this.buku = new Buku(this.data[i][0]);
              this.tglpinjam = this.data[i][2];
              this.tglkembali =  this.data[i][3];

              this.status = 1;
          }
       }
    };

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public String getTglpinjam() {
        return tglpinjam;
    }

    public void setTglpinjam(String tglpinjam) {
        this.tglpinjam = tglpinjam;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.buku, flags);
        dest.writeString(this.tglpinjam);
        dest.writeString(this.tglkembali);
        dest.writeString(this.id_member);
        dest.writeInt(this.status);
    }

    protected Pinjaman(Parcel in) {
        this.buku = in.readParcelable(Buku.class.getClassLoader());
        this.tglpinjam = in.readString();
        this.tglkembali = in.readString();
        this.id_member = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<Pinjaman> CREATOR = new Parcelable.Creator<Pinjaman>() {
        @Override
        public Pinjaman createFromParcel(Parcel source) {
            return new Pinjaman(source);
        }

        @Override
        public Pinjaman[] newArray(int size) {
            return new Pinjaman[size];
        }
    };
}
