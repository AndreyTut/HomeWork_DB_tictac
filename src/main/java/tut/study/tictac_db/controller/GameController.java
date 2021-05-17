package tut.study.tictac_db.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.model.GameSession;
import tut.study.tictac_db.model.Player;
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

    @GetMapping("/{id}")
    public Game get(@PathVariable int id) {
        Game game = gameService.get(id);
        for (GameSession session: game.getSessions()) {
            session.setGame(makeNonRecursiveGame(game));
            session.setPlayer(makeNonRecursivePlayer(session.getPlayer()));
        }
        return game;
    }

    @PostMapping
    public void create(@RequestBody Game game) {
        game.setTimestamp(new Timestamp(System.currentTimeMillis()));
        gameService.save(game);
    }

    private Player makeNonRecursivePlayer(Player player) {
        return Player.builder()
                .email(player.getEmail())
                .name(player.getName())
                .id(player.getId())
                .build();
    }

    private Game makeNonRecursiveGame(Game game) {
        return Game.builder()
                .timestamp(game.getTimestamp())
                .steps(game.getSteps())
                .fieldWidth(game.getFieldWidth())
                .fieldHeight(game.getFieldHeight())
                .id(game.getId())
                .build();
    }
}
