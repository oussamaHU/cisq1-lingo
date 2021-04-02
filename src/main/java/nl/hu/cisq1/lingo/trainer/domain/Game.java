package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Integer id;
    private int score;
    @OneToMany
    private  List<Round> rounds = new ArrayList<>();

    public Game(String wordToGuess) {
        startNewRound(wordToGuess);
    }


    public Game() {

    }

    public void startNewRound(String wordToGuess) {
        Round nextRound = new Round(wordToGuess);
        rounds.add(nextRound);
    }

    public List<Mark> guess(String word) {
        return getLastRound().guess(word);
    }



    public int getAttemptCount() {
        return getLastRound().getAttemptCount();
    }



    private Round getLastRound() {
        if (getRoundsCount() == 0) {
            return null;
        }
        return rounds.get(getRoundsCount() - 1);
    }

    public int getRoundsCount() {
        return rounds.size();
    }

    public int getScore() {
        return score;
    }

}
