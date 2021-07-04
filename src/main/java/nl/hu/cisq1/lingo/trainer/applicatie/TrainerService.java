package nl.hu.cisq1.lingo.trainer.applicatie;

import nl.hu.cisq1.lingo.trainer.data.SpringGameRepository;
import nl.hu.cisq1.lingo.trainer.domain.Feedback;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Progress;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import nl.hu.cisq1.lingo.words.application.WordService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TrainerService {
    private final WordService wordService;
    private final SpringGameRepository gameRepository;
    private int wordLength = 5;


    public TrainerService(WordService wordService, SpringGameRepository gameRepository) {
        this.wordService = wordService;
        this.gameRepository = gameRepository;
    }

    public String startNewGame(){
        Game game = new Game();
        gameRepository.save(game);
        return "game id: "+game.getId();
    }


    public Progress startNewRound(Long gameId){
        Game game = getGameById(gameId);
        String word = wordService.provideRandomWord(wordLength);
        game.startNewRound(word);
        System.out.println("WORD LENGTH: "+wordLength);
        if(wordLength == 5){
            wordLength = 6;
        }else if(wordLength == 6){
            wordLength = 7;
        }else if(wordLength == 7){
            wordLength = 5;
        }   // na een 5 letter woord komt een 6 letter woord, daarna een 7 letter woord


        gameRepository.save(game);
        return game.generateFirstProgress();
    }

    public Feedback guess(Long gameId, String word){
        Game game = getGameById(gameId);
        game.guess(word);
        gameRepository.save(game);
        return game.getLastRound().getCurrentFeedback();
    }

    private Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found."));
    }

}

