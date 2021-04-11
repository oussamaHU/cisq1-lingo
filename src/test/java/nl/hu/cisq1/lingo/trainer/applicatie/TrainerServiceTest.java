package nl.hu.cisq1.lingo.trainer.applicatie;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Mark;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrainerServiceTest {


    @Test
    void startNewRound() {
        WordService wordService = mock(WordService.class);
        when(wordService.provideRandomWord(any())).thenReturn("WOORD");

        Game game = new Game("TEST");
        SpringGameRepository gameRepositoryMock = mock(SpringGameRepository.class);
        when(gameRepositoryMock.findById(any())).thenReturn(Optional.of(game));
        TrainerService service = new TrainerService(wordService, gameRepositoryMock);

        assertEquals(1, game.getRoundsCount());
        service.startNewRound(1L);
        assertEquals(2, game.getRoundsCount());
    }

    @Test
    void guess() {
        Game game = new Game("WOORD");
        List<Mark> marks = List.of(Mark.INVALID, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT);
        assertEquals(game.guess("MOORD"), marks);

    }
}