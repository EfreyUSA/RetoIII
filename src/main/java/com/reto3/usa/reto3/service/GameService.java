/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.reto3.usa.reto3.service;

import com.reto3.usa.reto3.entity.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.usa.reto3.repository.GameRepository;

/**
 *
 * @author Efrey Guerrero Angarita
 */
@Service
public class GameService {
    @Autowired
    private GameRepository repositoryG;
    
    //Crud - Create - post
    public Game saveGame(Game game){
        return repositoryG.save(game);
    }
    
    //cRud - Read - get
    public List<Game> getGameAll() {
        return repositoryG.findAll();
    }
    
    //crUd - Update - put
    public Game updateGame(Game game) {
        Game existGame=repositoryG.findById(game.getId()).orElse(null);
        existGame.setName(game.getName());
        existGame.setDeveloper(game.getDeveloper());
        existGame.setYear(game.getYear());
        existGame.setDescription(game.getDescription());
        return repositoryG.save(existGame);
    }

    //cruD - Delete - delete
    public String deleteGame(Game game){
        repositoryG.deleteById(game.getId());
        return "Registro de ID: "+game.getId()+" ha sido eliminado";
    }
}
