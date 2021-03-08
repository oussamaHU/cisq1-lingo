package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void guess() {
        Round round = new Round("woord", 1);
        List<Mark> marks = List.of(Mark.INVALID, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT);
        assertEquals(round.guess("moord"),marks );
        }


    @Test
    void getAttempts() {
        Round round = new Round("woord", 1);

        assertNotNull(round.getAttempts());

    }
}