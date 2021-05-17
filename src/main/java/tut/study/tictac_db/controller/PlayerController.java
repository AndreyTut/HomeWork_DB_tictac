package tut.study.tictac_db.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.model.GameSession;
import tut.study.tictac_db.model.Player;
import tut.study.tictac_db.service.PlayerService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/{id}")
    public Player get(@PathVariable int id) {
        Player player = playerService.get(id);
        for (GameSession session : player.getSessions()) {
            session.setPlayer(makeNonRecursivePlayer(player));
            session.setGame(makeNonRecursiveGame(session.getGame()));
        }
        return player;
    }

    @PostMapping
    public void create(@RequestBody Player player) {
        playerService.save(player);
    }

    @PutMapping
    public void update(@RequestBody Player player) {
        playerService.save(player);
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
