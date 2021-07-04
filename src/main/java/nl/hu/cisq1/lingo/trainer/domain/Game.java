package nl.hu.cisq1.lingo.trainer.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    @GeneratedValue
    private Long id;

    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OneToMany
    private  List<Round> rounds = new ArrayList<>();


    private Boolean isPlaying = false;
    private int score;




    public Game() {

    }

    public void startNewRound(String wordToGuess) {
        Round nextRound = new Round(wordToGuess);
        rounds.add(nextRound);
        isPlaying = true;
    }

    public Feedback guess(String word) {
        if(!isPlaying){
            System.out.println("je moet nog een round starten");
            return null;
        }
        getLastRound().guess(word);
        getLastRound().getCurrentFeedback().setProgress(new Progress(score, getLastRound().getCurrentFeedback().getHint(), getRoundsCount()));

        if(!getLastRound().getCurrentFeedback().getMarks().contains(Mark.ABSENT) &!getLastRound().getCurrentFeedback().getMarks().contains(Mark.INVALID)&!getLastRound().getCurrentFeedback().getMarks().contains(Mark.PRESENT)){
            isPlaying = false;
            score = score + (5 * ((5-getLastRound().getAttemptCount())+5));
            System.out.println("je hebt de round gewonnen!");
        }

        return getLastRound().getCurrentFeedback();

    }



    public int getAttemptCount() {
        return getLastRound().getAttemptCount();
    }

    public Progress generateFirstProgress(){  // dit is progress speciaal voor wanneer een nieuwe round wordt gestart
        return new Progress(score, getLastRound().getFirstHint() ,getRoundsCount());
    }

    public Round getLastRound() {
        if (getRoundsCount() == 0) {
            return null;
        }
        return rounds.get(getRoundsCount()-1);
    }

    public int getRoundsCount() {
        return rounds.size();
    }

    public int getScore() {
        return score;
    }


    public Long getId() {
        return id;
    }
}
