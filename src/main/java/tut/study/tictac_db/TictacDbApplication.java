package tut.study.tictac_db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tut.study.tictac_db.model.Game;
import tut.study.tictac_db.model.GameSession;
import tut.study.tictac_db.model.Player;
import tut.study.tictac_db.repository.GameRepository;
import tut.study.tictac_db.repository.GameSessionRepository;
import tut.study.tictac_db.repository.PlayerRepository;
import tut.study.tictac_db.service.PlayerService;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class TictacDbApplication implements CommandLineRunner {

    @Autowired
    private PlayerService playerService;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameSessionRepository gameSessionRepository;

    public static void main(String[] args) {
        SpringApplication.run(TictacDbApplication.class, args);

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Player player1 = Player.builder()
                .email("ivan@google.com")
                .name("ivan")
                .password("secret").build();

        Player player2 = Player.builder()
                .email("vano@google.com")
                .name("vano")
                .password("topsecret").build();

        Game game = Game.builder()
                .fieldHeight(10)
                .fieldWidth(10)
                .steps(4)
                .timestamp(new Timestamp(System.currentTimeMillis())).build();

        GameSession gameSession = GameSession.builder().result(1).build();
        player1.setSessions(List.of(gameSession));
        game.setSessions(List.of(gameSession));
        player1.setSessions(List.of(gameSession));
        game.setSessions(List.of(gameSession));
        playerService.save(player1);
        playerService.save(player2);
        gameRepository.save(game);
        gameSessionRepository.save(gameSession);

    }
}
