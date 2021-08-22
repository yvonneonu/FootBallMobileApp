package com.example.footballmobileapp.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

public class CurrentSession implements Parcelable {

    int id;
    @SerializedName("startDate")
    String startDate;

    public CurrentSession(int id, String startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public CurrentSession() {
        Log.d("currentseason", "showseason");

    }

    protected CurrentSession(Parcel in) {
        id = in.readInt();
        startDate = in.readString();
    }

    public static final Creator<CurrentSession> CREATOR = new Creator<CurrentSession>() {
        @Override
        public CurrentSession createFromParcel(Parcel in) {
            return new CurrentSession(in);
        }

        @Override
        public CurrentSession[] newArray(int size) {
            return new CurrentSession[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(startDate);
    }
}
