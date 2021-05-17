package tut.study.tictac_db.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tut.study.tictac_db.model.Player;
import tut.study.tictac_db.repository.PlayerRepository;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;
    private final PasswordEncoder encoder;

    public PlayerService(PlayerRepository repository, PasswordEncoder encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    public List<Player> getAll() {
        return repository.findAll();
    }

    public void save(Player player) {
        player.setPassword(encoder.encode(player.getPassword()));
        repository.save(player);
    }

    public Player get(int id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
    }
}
