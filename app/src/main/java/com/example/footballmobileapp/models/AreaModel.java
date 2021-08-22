package com.example.footballmobileapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class AreaModel implements Parcelable {

    int id;
    @SerializedName("name")
    String name;

    public AreaModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public AreaModel() {
    }

    protected AreaModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Parcelable.Creator<AreaModel> CREATOR = new Parcelable.Creator<AreaModel>() {
        @Override
        public AreaModel createFromParcel(Parcel in) {
            return new AreaModel(in);
        }

        @Override
        public AreaModel[] newArray(int size) {
            return new AreaModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }
}
