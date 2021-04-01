package nl.hu.cisq1.lingo.trainer.applicatie;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TrainerService {
    private final WordService wordService;
    private final SpringGameRepository gameRepository;


    public TrainerService(WordService wordService, SpringGameRepository gameRepository) {
        this.wordService = wordService;
        this.gameRepository = gameRepository;
    }


    public Game startNewRound(Long gameId){
        Game game = getGameById(gameId);
        String word = wordService.provideRandomWord(5);
        game.startNewRound(word);
        return gameRepository.save(game);
    }

    public void guess(Long gameId, String word){
        Game game = getGameById(gameId);
        game.guess(word);
        gameRepository.save(game);
    }

    private Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found."));
    }

}

