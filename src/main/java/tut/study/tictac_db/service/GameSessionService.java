package tut.study.tictac_db.service;

import org.springframework.stereotype.Service;
import tut.study.tictac_db.dto.GameSessionDto;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.model.GameSession;
import tut.study.tictac_db.model.Player;
import tut.study.tictac_db.repository.GameSessionRepository;

import javax.transaction.Transactional;

@Service
public class GameSessionService {
    private final GameSessionRepository gameSessionRepository;
    private final GameService gameService;
    private final PlayerService playerService;

    public GameSessionService(GameSessionRepository gameSessionRepository, GameService gameService, PlayerService playerService) {
        this.gameSessionRepository = gameSessionRepository;
        this.gameService = gameService;
        this.playerService = playerService;
    }

    @Transactional
    public void create(GameSessionDto dto) {
        Player player = playerService.get(dto.getPlayerId());
        Game game = gameService.get(dto.getGameId());
        GameSession gameSession = GameSession
                .builder()
                .result(dto.getResult())
                .build();
        player.getSessions().add(gameSession);
        game.getSessions().add(gameSession);
        gameSessionRepository.save(gameSession);
    }
}
