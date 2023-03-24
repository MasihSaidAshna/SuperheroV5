package com.example.superherov5.models;

public class Superpower {

    private int powerID;
    private String powerName;

    public Superpower(int powerID, String powerName) {
        this.powerID = powerID;
        this.powerName = powerName;
    }

    public int getID() {
        return powerID;
    }

    public void setPowerID(int powerID) {
        this.powerID = powerID;
    }

    public String getPowerName() {
        return powerName;
    }

    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }
}
