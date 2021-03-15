package nl.hu.cisq1.lingo.trainer.applicatie;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrainerServiceTest {

    @Test
    void startGame() {
        WordService wordService = mock(WordService.class);
        SpringGameRepository gameRepository = mock(SpringGameRepository.class);
        TrainerService service = new TrainerService(wordService, gameRepository);

        assertNotNull(service.startGame());

    }

    @Test
    void startNewRound() {
        WordService wordService = mock(WordService.class);
        SpringGameRepository gameRepository = mock(SpringGameRepository.class);
        TrainerService service = new TrainerService(wordService, gameRepository);

        assertNotNull(service.startNewRound("woord"));
    }

    @Test
    void guess() {
        WordService wordService = mock(WordService.class);
        SpringGameRepository gameRepository = mock(SpringGameRepository.class);
        TrainerService service = new TrainerService(wordService, gameRepository);

        when(wordService.provideRandomWord(5)).thenReturn("appel");
       assertTrue(service.guess("appel"));
    }
}