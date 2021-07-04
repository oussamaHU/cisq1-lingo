package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackTest {
    @Test
    @DisplayName("word is guessed if all letters are correct")
    void wordIsGuessed(){


        String poging = "PAARD";
        List<Mark> marks = List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT);
        Feedback feedback = new Feedback(poging, marks,"PAARD");


        assertTrue(feedback.isWordGuessed());
    }

    @Test
    @DisplayName("word is not guessed if all letters are correct")
    void wordIsNotGuessed(){


        String poging = "PAARD";
        List<Mark> marks = List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.ABSENT);
        Feedback feedback = new Feedback(poging, marks, "PAART");


        assertFalse((feedback.isWordGuessed()));
    }

    @Test
    @DisplayName("guess is invalid if word is not the correct length")
    void guessIsInvalid(){


        String poging = "PAARDT";
        List<Mark> marks = List.of(Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID, Mark.INVALID);
        Feedback feedback = new Feedback(poging, marks, "PAARD");


        assertTrue((feedback.isGuessInvalid()));
    }
    @Test
    @DisplayName("guess is valid if there are 5 letters")
    void guessIsValid(){


        String poging = "PAARD";
        List<Mark> marks = List.of(Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.ABSENT);
        Feedback feedback = new Feedback(poging, marks, "PAARD");


        assertTrue((feedback.isGuessvalid()));
    }
}
