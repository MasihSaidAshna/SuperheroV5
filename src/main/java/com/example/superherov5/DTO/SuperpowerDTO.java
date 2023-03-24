package com.example.superherov5.DTO;
import java.util.List;

public record SuperpowerDTO (String heroName, String realName, List<String> superpowerList) {


    public SuperpowerDTO(String heroName, String realName, List<String> superpowerList) {
        this.heroName = heroName;
        this.realName = realName;
        this.superpowerList = superpowerList;
    }



}
