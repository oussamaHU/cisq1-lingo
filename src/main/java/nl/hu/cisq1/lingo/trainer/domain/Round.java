package nl.hu.cisq1.lingo.trainer.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Round {
    @Id
    @GeneratedValue
    private Integer id;
    private static final int MAX_ATTEMPTS = 5;

    private  String wordToGuess;
    @OneToMany
    private List<Feedback> feedbacks = new ArrayList<>();
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Mark> marks = new ArrayList<>();

    public Round(String wordToGuess) {
        this.wordToGuess = wordToGuess;
    }

    public Round() {

    }

    public List<Mark> guess(String attempt) {
        if (getAttemptCount() > MAX_ATTEMPTS) {
            throw new RuntimeException("Max attempts already reached");
        }
        for (int i = 0; i < getCurrentWordLength(); i++) {
            if (attempt.charAt(i) == wordToGuess.charAt(i)) {
                addMark(Mark.CORRECT);
            } else {
                addMark(Mark.INVALID);
            }

        }
        return getMarks();


    }

    public int getAttemptCount() {
        return feedbacks.size();
    }

    public void addMark(Mark mark) {
        marks.add(mark);

    }

    public String giveHint(String attempt) {
        String hint = "";
        for (int i = 0; i < getCurrentWordLength(); i++)
            if (attempt.charAt(i) == wordToGuess.charAt(i)) {
                hint = hint + wordToGuess.charAt(i);


            } else {
                hint = hint + ".";
            }

        return hint;
    }

    public int getCurrentWordLength() {
        return wordToGuess.length();

    }

    public List<Mark> getMarks() {
        return marks;
    }
}
