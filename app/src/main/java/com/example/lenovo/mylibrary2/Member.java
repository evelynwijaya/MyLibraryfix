package com.example.lenovo.mylibrary2;

import android.os.Parcel;

/**
 * Created by Lenovo on 17/12/2017.
 */

public class Member extends User {

    private String id_member = null;
    Pinjaman pinjaman;

    public Member (String email){
        this.setEmail(email);
        this.caridata();
    }

    private void caridata() {
        for (int i =0;i<this.data.length;i++){
            if (this.getEmail().equals(this.data[i][1])){
                this.setId_member(this.data[i][0]);
                this.setPassword(this.data[i][2]);
                this.setNamalengkap(this.data[i][3]);
                this.setTelp(this.data[i][4]);

                this.pinjaman = new Pinjaman(this.id_member);
            }
        }
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public Pinjaman getPinjaman() {
        return pinjaman;
    }

    public void setPinjaman(Pinjaman pinjaman) {
        this.pinjaman = pinjaman;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(this.id_member);
        dest.writeParcelable(this.pinjaman, flags);
    }

    protected Member(Parcel in) {
        super(in);
        this.id_member = in.readString();
        this.pinjaman = in.readParcelable(Pinjaman.class.getClassLoader());
    }

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            return new Member(source);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };
}
