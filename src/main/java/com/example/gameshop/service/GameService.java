package com.example.gameshop.service;


import com.example.gameshop.model.Game;
import com.example.gameshop.repasitory.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }


    public Game getById(int id) {
        return gameRepository.findById(id).orElseThrow(()->new ResponseStatusException(NOT_FOUND));
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }

    public Game addGame(Game game) {
       return gameRepository.save(game);
    }

    public void remove(Integer id){
        gameRepository.deleteById(id);
    }
}
