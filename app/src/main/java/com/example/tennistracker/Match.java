package com.example.tennistracker;

import android.net.Uri;

public class Match {
    public int id;
    public String place;
    public double latitude;
    public double longitude;
    public Player player1;
    public Player player2;
    // public ArrayList<Set> sets;

    public Match(int id, String place, double latitude, double longitude) {
        this.id = id;
        this.place = place;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Uri getUriLocation() {
        return Uri.parse("geo:" + getLatitude() + "," + getLongitude());
    }
    // https://developer.android.com/training/basics/intents/sending#complete-example

}
