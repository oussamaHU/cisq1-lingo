package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTest {

// ik heb de getters en setters getest voor line coverage
    @Test
    void getRoundNumber() {
        Progress progress = new Progress(5,"auto",1);
        assertEquals(1, progress.getRoundNumber());

    }
    @Test
    void checkId() {
        Progress progress = new Progress(1,"test",1);
        assertEquals(null, progress.getId());
    }
    @Test
    void checkHint() {
        Progress progress = new Progress(1,"test",1);
        assertEquals("test", progress.getHint());
    }
    @Test
    void checkScore() {
        Progress progress = new Progress(1,"test",1);
        assertEquals(1, progress.getScore());
    }
    @Test
    void checkSetterId() {
        Progress progress = new Progress(1,"test",1);
        progress.setId(2L);
        assertEquals(2, progress.getId());
    }

}