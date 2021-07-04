package nl.hu.cisq1.lingo.trainer.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Round {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Mark> marks = new ArrayList<>();

    private  String wordToGuess;
    private static final int MAX_ATTEMPTS = 5;


    public Round(String wordToGuess) {
        this.wordToGuess = wordToGuess;

    }

    public Round() {

    }

    public List<Mark> guess(String attempt) {

        marks.clear();
        if (getAttemptCount() > MAX_ATTEMPTS) {
            throw new RuntimeException("Max attempts already reached");
        } // als je je attempts hebt verbruikt
        attempt = attempt.toLowerCase();
        if (attempt.length() != wordToGuess.length()){
            for (int i = 0; i < wordToGuess.length(); i++) {
                addMark(Mark.INVALID);
            }
            feedbacks.add(new Feedback(attempt, getMarks(), wordToGuess));
            return getMarks();
        } // als je een invalid guess meegeeft

        for (int i = 0; i < getCurrentWordLength(); i++) {
            if (attempt.charAt(i) == wordToGuess.charAt(i)) {
                addMark(Mark.CORRECT);
            } else if(wordToGuess.contains(""+attempt.charAt(i))){
                addMark(Mark.PRESENT);
            }else {
                addMark(Mark.ABSENT);
            }
        }

        List<Mark> marksForFeedback = marks;
        for (int i =0; i<feedbacks.size(); i++){  // hints worden onthouden
            for (int i2 =0; i2<feedbacks.get(i).getMarks().size(); i2++){
                if(feedbacks.get(i).getMarks().get(i2) == Mark.CORRECT){
                    marksForFeedback.set(i2, Mark.CORRECT);
                }
            }
        }
        feedbacks.add(new Feedback(attempt, marksForFeedback, wordToGuess));
        return marks;
    }

    public int getAttemptCount() {
        if (feedbacks == null){
            return 0;
        }
        return feedbacks.size();
    }

    public void addMark(Mark mark) {
        marks.add(mark);
    }

    public Feedback getCurrentFeedback() {

       return feedbacks.get(feedbacks.size()-1);
    }

    public String getFirstHint(){
        String hint = "";
        for (int i = 0; i<wordToGuess.length(); i++){
            if (i==0){
                hint = hint+wordToGuess.charAt(i);
            }else{
                hint = hint+".";
            }
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
