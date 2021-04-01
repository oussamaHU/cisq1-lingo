package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressTest {


    @Test
    void getRoundNumber() {
        Progress progress = new Progress(5,"auto",1);
        assertEquals(1, progress.getRoundNumber());

    }
}