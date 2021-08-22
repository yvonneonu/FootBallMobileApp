package com.example.footballmobileapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "note_table")
public class LeagueModel {

    @PrimaryKey(autoGenerate = true)
    private int id;
    String name;
    @SerializedName("area")
    AreaModel CountryName;
    @SerializedName("currentSeason")
    CurrentSession currentSeason;
    private int priority;


    public LeagueModel() {
        CountryName = new AreaModel();
        currentSeason = new CurrentSession();
    }


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

    public AreaModel getCountryName() {
        return CountryName;
    }

    public void setCountryName(AreaModel countryName) {
        CountryName = countryName;
    }

    public CurrentSession getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(CurrentSession currentSeason) {
        this.currentSeason = currentSeason;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
