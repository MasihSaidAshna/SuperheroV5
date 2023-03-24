package com.example.superherov5.repositories;

import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.superherov5.DTO.*;
import com.example.superherov5.models.*;

@Repository
public class SuperheroRepository implements IRepository{

    public List<Superhero> getSuperheroes() {
        List<Superhero> superheroes = new ArrayList<>();
        try (Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT * FROM superpower_hero_city.superhero";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()) {
                int ID = rs.getInt("superheroID");
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroes.add(new Superhero(ID, heroName, realName, creationYear));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return superheroes;
    }

    public Superhero getSuperhero(String heroName) {
        Superhero superheroOBJ = null;
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT * FROM superhero WHERE heroName = ? ;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, heroName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int ID = rs.getInt("superheroID");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroOBJ = new Superhero(ID, heroName, realName, creationYear);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return superheroOBJ;
    }

    //Tæller måske ikke superpowers ordentligt idk?
    public List<CountSuperpowersDTO> countSuperheroesPowers() {
        List<CountSuperpowersDTO> superheroes = new ArrayList<>();
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT *  FROM superhero JOIN superpower WHERE superheroID = superpowerID";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                List<String> powerList = new ArrayList<>();
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String superpowerName = rs.getString("superpowerName");
                powerList.add(superpowerName);
                superheroes.add(new CountSuperpowersDTO(heroName, realName, powerList.size()));
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return superheroes;
    }

    public CountSuperpowersDTO countSuperheroPowers(String heroName) {
        CountSuperpowersDTO superhero = null;
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT *  FROM superhero JOIN superpower WHERE heroName = ? ;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, heroName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                List<String> powerList = new ArrayList<>();
                String realName = rs.getString("realName");
                String superpowerName = rs.getString("superpowerName");
                powerList.add(superpowerName);
                superhero = new CountSuperpowersDTO(heroName, realName, powerList.size());
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return superhero;
    }

    public List<SuperpowerDTO> getSuperheroesPowers() {
        List<SuperpowerDTO> superheroes = new ArrayList<>();
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT *  FROM superhero JOIN superpower WHERE superheroID = superpowerID";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                List<String> powerList = new ArrayList<>();
                String heroName = rs.getString("heroName");
                String realName = rs.getString("realName");
                String superpowerName = rs.getString("superpowerName");
                powerList.add(superpowerName);
                superheroes.add(new SuperpowerDTO(heroName, realName, powerList));
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return superheroes;
    }

    public SuperpowerDTO getSuperheroPowers(String heroName) {
        SuperpowerDTO superhero = null;
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT *  FROM superhero JOIN superpower WHERE heroName = ? ;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, heroName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                List<String> powerList = new ArrayList<>();
                String realName = rs.getString("realName");
                String superpowerName = rs.getString("superpowerName");
                powerList.add(superpowerName);
                superhero = new SuperpowerDTO(heroName, realName, powerList);
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return superhero;
    }

    public List<HeroNameCityDTO> getSuperheroesCities() {
        List<HeroNameCityDTO> City = new ArrayList<>();
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT *  FROM superpower_hero_city.superhero JOIN superpower_hero_city.city WHERE superheroID = cityID";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs.next()){
                List<String> superheroes = new ArrayList<>();
                String cityName = rs.getString("cityName");
                String superhero = rs.getString("heroName");
                superheroes.add(superhero);
                City.add(new HeroNameCityDTO(cityName, superheroes));
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return City;
    }

    //Finder ikke det rigtige superhero til byen
    public HeroNameCityDTO getSuperheroesCity(String cityName) {
        HeroNameCityDTO City = null;
        try(Connection con = ConnectionManager.getConnection()) {
            String SQL = "SELECT heroName, cityName FROM superhero JOIN city WHERE cityName = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cityName);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()){
                List<String> superheroes = new ArrayList<>();
                String superhero = rs.getString("heroName");
                superheroes.add(superhero);
                City = new HeroNameCityDTO(cityName, superheroes);
            }
        }
        catch (SQLException e){
            throw new RuntimeException();
        }
        return City;
    }

}
