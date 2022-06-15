package com.example.tennistracker;

public class Player {
    public String id;
    public String first;
    public String last;
    public String hand;
    public String dob;
    public String ioc;
    public String height;
    public String wikidata;

    public Player(String id, String first, String last, String hand, String dob, String ioc, String height, String wikidata) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.hand = hand;
        this.dob = dob;
        this.ioc = ioc;
        this.height = height;
        this.wikidata = wikidata;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst() {
        return this.first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getHand() {
        return this.hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIoc() {
        return this.ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWikidata() {
        return this.wikidata;
    }

    public void setWikidata(String wikidata) {
        this.wikidata = wikidata;
    }
}
