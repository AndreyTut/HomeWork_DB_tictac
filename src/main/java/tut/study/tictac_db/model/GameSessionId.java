package tut.study.tictac_db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GameSessionId implements Serializable {
    private int id;
}
