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
    private WordService wordService;
    private SpringGameRepository gameRepository;
    private Game game = new Game();

    public TrainerService(WordService wordService, SpringGameRepository gameRepository) {
        this.wordService = wordService;
        this.gameRepository = gameRepository;
    }

    public Game startGame() {
        game.startGame();
        return game;


    }
    public Game startNewRound(String wordToGuess){
        game.startNewRound("woord");
        return game;

    }
    public boolean guess(String word){
        game.guess(word);
        return true;

    }
    public boolean showProgress(){
        game.showProgress();
        return true;
    }

}

