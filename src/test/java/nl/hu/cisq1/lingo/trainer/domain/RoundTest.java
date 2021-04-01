package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @Test
    void guess() {
        Round round = new Round("woord");
        List<Mark> marks = List.of(Mark.INVALID, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT, Mark.CORRECT);
        assertEquals(round.guess("moord"), marks);
    }

    @Test
    void getAttemptCount(){
        Round round = new Round("woord");
        assertNotNull(round.getAttemptCount());
    }

    @Test
    void getCurrentWordLength(){
        Round round = new Round("woord");
        assertNotNull(round.getCurrentWordLength());
    }
    @Test
    void giveHint(){
        Round round = new Round("boot");
        assertNotNull(round.giveHint("boot"));
    }
}
