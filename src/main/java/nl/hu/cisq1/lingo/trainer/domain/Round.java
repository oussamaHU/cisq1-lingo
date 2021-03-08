package nl.hu.cisq1.lingo.trainer.domain;

import java.util.ArrayList;
import java.util.List;

public class Round {
    private String wordToGuess;
    private int attempts;
    private List<Feedback>feedbacks;
    private List<Mark> marks = new ArrayList<>();

    public Round(String wordToGuess, int attempts) {
        this.wordToGuess = wordToGuess;
        this.attempts = attempts;

    }
public List<Mark> guess(String attempt){


        if (attempts <= 5){
            if (attempt != wordToGuess){
                for(int i = 0 ; i  < getCurrentWordLength(); i++){
                    if(attempt.charAt(i) == wordToGuess.charAt(i)){
                      addMark(Mark.CORRECT);

                    }else {
                        addMark(Mark.INVALID);
                    }

                }
               return getMarks();

            }


        }
    return List.of(Mark.INVALID);
}
public void addMark(Mark mark){
        marks.add(mark);

    }

public String giveHint(){
      return feedbacks.toString()  ;

}

    public List<Feedback> getFeedbackHistory() {
        return feedbacks;
    }

    public int getAttempts() {
        return attempts;
    }
    public int getCurrentWordLength(){
        return wordToGuess.length();

    }
    public List<Mark> getMarks() {
        return marks;
    }
}
