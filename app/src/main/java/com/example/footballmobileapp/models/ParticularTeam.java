package com.example.footballmobileapp.models;

import java.util.List;

public class ParticularTeam {
    String name;
    String shortName;
    String address;
    String phone;
    String website;
    String crestUrl;
    String email;
    String founded;
    String clubColors;
    List<Squad> squad;

    public ParticularTeam() {
    }

    public String getCrestUrl() {
        return crestUrl;
    }

    public String getName() {
        return name;
    }

    public String getShortName() {
        return shortName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getFounded() {
        return founded;
    }

    public String getClubColors() {
        return clubColors;
    }

    public List<Squad> getSquad() {
        return squad;
    }
}
