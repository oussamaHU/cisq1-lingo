package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Game {

    @Id
    private Long Id;
    private int score;
    private List<GameStatus>gameStatuses;
    private Round round;
    private List<Progress>progresses;

    public Game(int score) {
        this.score = score;

    }

    public Game() {

    }


    public void startGame(){
   List<GameStatus> gameStatuses = List.of(GameStatus.PLAYING);


    }
    public void startNewRound(String wordToGuess){
        Round round = new Round(wordToGuess, 0);
        setRound(round);
    }

    public void guess(String word){
        getRound().guess(word);

    }

    public String showProgress(){
        return progresses.get(0).toString();

    }



    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<GameStatus> getGameStatuses() {
        return gameStatuses;
    }

    public void setGameStatuses(List<GameStatus> gameStatuses) {
        this.gameStatuses = gameStatuses;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
