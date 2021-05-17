package tut.study.tictac_db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "gamesession")
public class GameSession {

    @EmbeddedId
    GameSessionId id;

    private int result;

    @ManyToOne
    @MapsId("playerId")
    private Player player;
    @ManyToOne
    @MapsId("gameId")
    private Game game;

    public GameSession(Player player, Game game) {
        this.player = player;
        this.game = game;
        this.id = new GameSessionId(player.getId(), game.getId());
    }
}
