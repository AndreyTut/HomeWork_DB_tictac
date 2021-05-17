package tut.study.tictac_db.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tut.study.tictac_db.dto.GameSessionDto;
import tut.study.tictac_db.service.GameSessionService;

@RestController
@RequestMapping("session")
public class GameSessionController {
    private final GameSessionService sessionService;

    public GameSessionController(GameSessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping
    public void create(@RequestBody GameSessionDto dto) {
        sessionService.create(dto);
    }
}
