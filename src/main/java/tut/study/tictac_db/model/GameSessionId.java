package tut.study.tictac_db.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class GameSessionId implements Serializable {
    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "game_id")
    private Integer gameId;
}
