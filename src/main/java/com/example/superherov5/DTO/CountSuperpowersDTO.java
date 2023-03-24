package com.example.superherov5.DTO;
import com.example.superherov5.models.Superpower;

import java.util.List;

public record CountSuperpowersDTO (String heroName, String realName, int countSuperpowers) {

    public CountSuperpowersDTO (String heroName, String realName, int countSuperpowers) {
        this.heroName = heroName;
        this.realName = realName;
        this.countSuperpowers = countSuperpowers;
    }


}
