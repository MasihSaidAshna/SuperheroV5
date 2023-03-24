package com.example.superherov5.controllers;

import com.example.superherov5.DTO.*;
import com.example.superherov5.models.*;
import com.example.superherov5.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("superhero")
public class SuperheroController {

    private final SuperheroRepository repo;

    public SuperheroController(SuperheroRepository repo) {
        this.repo = repo;
    }

    @GetMapping(path = "")
    public ResponseEntity<List<Superhero>> readSuperheroes() {
        List<Superhero> superheroList = repo.getSuperheroes();
        return new ResponseEntity<>(superheroList, HttpStatus.OK);
    }

}
