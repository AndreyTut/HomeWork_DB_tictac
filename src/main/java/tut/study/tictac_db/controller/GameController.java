package tut.study.tictac_db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.service.GameService;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getAll() {
        return gameService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Game game) {
        game.setTimestamp(new Timestamp(System.currentTimeMillis()));
        gameService.save(game);
    }
}
