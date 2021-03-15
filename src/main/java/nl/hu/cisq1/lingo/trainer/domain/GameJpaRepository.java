package nl.hu.cisq1.lingo.trainer.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameJpaRepository extends JpaRepository<Game, Long> {

    @Override
    List<Game> findAllById(Iterable<Long> iterable);

    @Override
    <S extends Game> S save(S s);
}
