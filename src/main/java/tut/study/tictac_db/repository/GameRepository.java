package tut.study.tictac_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tut.study.tictac_db.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
}
