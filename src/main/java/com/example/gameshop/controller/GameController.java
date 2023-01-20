package com.example.gameshop.controller;


import com.example.gameshop.model.Game;
import com.example.gameshop.service.GameService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameServece;
    private final Map<Integer, Game> cacheGame= new HashMap<>();


    public GameController(GameService gameServece) {
        this.gameServece = gameServece;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "games", key = "#id")

    public Game getGame(@PathVariable int id) {
        System.out.println("@Cacheable");
        return cacheGame.computeIfAbsent(id, ket ->this.gameServece.getById(id));
    }

    @GetMapping()
    @Cacheable(value = "AllGames")
    public List<Game> getAll() {
        System.out.println("@Cacheable AllGames");
        return this.gameServece.getAll();
    }

    @PutMapping()
    public void save(@RequestBody Game game) {
          this.gameServece.addGame(game);
    }
}
