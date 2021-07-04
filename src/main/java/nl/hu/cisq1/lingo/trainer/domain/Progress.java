package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Progress {
    private int score;
    private String hint;
    private int roundNumber = 1;
    @Id
    @GeneratedValue
    private Long id;

    public Progress(int score, String hint, int roundNumber) {
        this.score = score;
        this.hint = hint;
        this.roundNumber = roundNumber;
    }

    public Progress() {

    }


    public int getRoundNumber() {
        return roundNumber;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getHint() {
        return hint;
    }

    public int getScore() {
        return score;
    }

    public Long getId() {
        return id;
    }
}
