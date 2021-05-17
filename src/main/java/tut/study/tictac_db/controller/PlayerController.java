package tut.study.tictac_db.controller;

import org.springframework.web.bind.annotation.*;
import tut.study.tictac_db.model.Player;
import tut.study.tictac_db.service.PlayerService;

import java.util.List;

@RestController
@RequestMapping("player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    public List<Player> getAll() {
        return playerService.getAll();
    }

    @PostMapping
    public void create(@RequestBody Player player) {
        playerService.save(player);
    }

    @PutMapping
    public void update(@RequestBody Player player) {
        playerService.save(player);
    }
}
