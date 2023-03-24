package com.example.superherov5.models;

public class Superhero {

    private int ID;
    private String heroName;
    private String realName;
    private int creationYear;

    public Superhero(int ID, String heroName, String realName, int creationYear) {
        this.ID = ID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }
}
