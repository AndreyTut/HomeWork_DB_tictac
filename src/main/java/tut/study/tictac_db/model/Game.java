package tut.study.tictac_db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int fieldWidth;
    private int fieldHeight;
    @Column(name = "steps_to_win")
    private int steps;
    private Timestamp timestamp;
    @OneToMany(mappedBy = "game")
    private List<GameSession> sessions;
}
