package tut.study.tictac_db.dto;

import lombok.Getter;

@Getter
public class GameSessionDto {
    private int playerId;
    private int gameId;
    private int result;
}
