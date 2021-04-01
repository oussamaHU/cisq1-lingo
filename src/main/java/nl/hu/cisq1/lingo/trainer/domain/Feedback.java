package nl.hu.cisq1.lingo.trainer.domain;

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
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<Mark> marks;

    public Feedback(String attempt, List<Mark> mark) {
        this.attempt = attempt;
        this.marks = mark;
    }

    public Feedback(String attempt) {

        this.attempt = attempt;
    }

    public Feedback() {

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
}