package tut.study.tictac_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tut.study.tictac_db.model.GameSession;

@Repository
public interface GameSessionRepository extends JpaRepository<GameSession, Integer> {
}
