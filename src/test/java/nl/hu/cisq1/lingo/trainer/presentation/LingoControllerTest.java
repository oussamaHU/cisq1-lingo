package nl.hu.cisq1.lingo.trainer.presentation;

import nl.hu.cisq1.lingo.CiTestConfiguration;
import nl.hu.cisq1.lingo.trainer.applicatie.TrainerService;
import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Mark;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@Import(CiTestConfiguration.class)
@AutoConfigureMockMvc
class LingoControllerTest {

    @Test
    void startNewRound() {
        WordService wordService = mock(WordService.class);
        when(wordService.provideRandomWord(any())).thenReturn("WOORD");

        Game game = new Game();
        game.startNewRound("TEST");
        SpringGameRepository gameRepositoryMock = mock(SpringGameRepository.class);
        when(gameRepositoryMock.findById(any())).thenReturn(Optional.of(game));
        TrainerService service = new TrainerService(wordService, gameRepositoryMock);

        assertEquals(1, game.getRoundsCount());
        service.startNewRound(1L);
        assertEquals(2, game.getRoundsCount());
    }


    @Test
    void guess() {
        Game game = new Game();
        game.startNewRound("woord");
        List<Mark> marks = List.of(Mark.ABSENT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT);
        assertEquals(game.guess("MOORD").getMarks(), marks);

    }
}