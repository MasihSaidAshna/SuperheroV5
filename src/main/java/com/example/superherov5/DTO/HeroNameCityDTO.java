package com.example.superherov5.DTO;
import java.util.List;

public record HeroNameCityDTO (String cityName, List<String> superheroes) {

    public HeroNameCityDTO (String cityName, List<String> superheroes) {
        this.cityName = cityName;
        this.superheroes = superheroes;
    }

}
