package tut.study.tictac_db.service;

import org.springframework.stereotype.Service;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.repository.GameRepository;

import java.util.List;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void save(Game game) {
        gameRepository.save(game);
    }

    public Game get(int id) {
        return gameRepository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
    }

    public List<Game> getAll() {
        return gameRepository.findAll();
    }
}
