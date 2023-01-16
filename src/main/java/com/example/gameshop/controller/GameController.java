package com.example.gameshop.controller;


import com.example.gameshop.model.Game;
import com.example.gameshop.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameServece;

    public GameController(GameService gameServece) {
        this.gameServece = gameServece;
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable int id) {
        return this.gameServece.getById(id);
    }

    @GetMapping()
    public List<Game> getAll() {
        return this.gameServece.getAll();
    }

    @PutMapping()
    public void save(@RequestBody Game game) {
          this.gameServece.addGame(game);
    }
}
