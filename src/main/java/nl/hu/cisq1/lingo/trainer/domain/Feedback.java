package nl.hu.cisq1.lingo.trainer.domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

import static nl.hu.cisq1.lingo.trainer.domain.Mark.CORRECT;
import static nl.hu.cisq1.lingo.trainer.domain.Mark.INVALID;
@Entity
public class Feedback {
    @Id
    @GeneratedValue
    private Integer id;
    private  String attempt;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Progress progress;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Mark> marks;
    private String hint = "";

    public Feedback(String attempt, List<Mark> mark, String wordtoguess) {
        this.attempt = attempt;
        this.marks = mark;
        giveHint(wordtoguess);
    }

    public Feedback() {

    }

    public String giveHint(String wordToGuess) {
        hint = "";
        for (int i = 0; i < getMarks().size(); i++)
            if (marks.get(i) == CORRECT) {
                hint = hint + wordToGuess.charAt(i);
            } else {
                hint = hint + ".";
            }
        setHint(hint);
        return hint;
    }

    public String getHint() {
        return hint;
    }

    public Progress getProgress() {
        return progress;
    }

    public List<Mark> getMarks() {
        return marks;
    }



    public boolean isWordGuessed(){
        return marks.stream().allMatch(mark -> mark == CORRECT);

    }
    public boolean isGuessvalid(){
        return marks.stream().noneMatch(mark -> mark == INVALID);
    }
    public boolean isGuessInvalid(){
        return marks.stream().allMatch(mark -> mark == INVALID);
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}