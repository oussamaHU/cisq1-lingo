package nl.hu.cisq1.lingo.trainer.domain;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.trainer.applicatie.TrainerService;
import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Mark;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class TrainerServiceIntergrationTest {


    @ParameterizedTest
    @MethodSource({"geefId"})
    @DisplayName("geef id")
    void startNewRound(long id) {
        WordService wordService = mock(WordService.class);
        when(wordService.provideRandomWord(any())).thenReturn("WOORD");

        Game game = new Game("TEST");
        SpringGameRepository gameRepositoryMock = mock(SpringGameRepository.class);
        when(gameRepositoryMock.findById(any())).thenReturn(Optional.of(game));
        TrainerService service = new TrainerService(wordService, gameRepositoryMock);

        service.startNewRound(id);
        assertEquals(2, game.getRoundsCount());
    }
    static Stream<Arguments> geefId(){
        return Stream.of(
                Arguments.of(1),
                Arguments.of(3),
                Arguments.of(5)

        );
    }

    @ParameterizedTest
    @MethodSource({"geefWoord"})
    @DisplayName("guessing words")
    void guess(String wordtoguess, List<Mark> mark) {
        Game game = new Game("WOORD");
        assertEquals(game.guess(wordtoguess), mark);

    }
    static Stream<Arguments> geefWoord(){
        return Stream.of(
                Arguments.of("MOORD", List.of(Mark.INVALID, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT)),
                Arguments.of("WOORD", List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT)),
                Arguments.of("MOTOR", List.of(Mark.INVALID, Mark.CORRECT, Mark.INVALID, Mark.INVALID, Mark.INVALID))

        );
    }
}