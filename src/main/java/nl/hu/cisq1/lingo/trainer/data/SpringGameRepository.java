package nl.hu.cisq1.lingo.trainer.data;

import nl.hu.cisq1.lingo.trainer.domain.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringGameRepository extends JpaRepository<Game, Long> {
    @Override
    List<Game> findAllById(Iterable<Long> iterable);

    @Override
    <S extends Game> S save(S s);
}
