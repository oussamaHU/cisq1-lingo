package nl.hu.cisq1.lingo.trainer.domain;

import java.util.List;

public class Game {
    private int score;
    private List<GameStatus>gameStatuses;
    private Round round;
    private List<Progress>progresses;

    public Game(int score) {
        this.score = score;

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


}
