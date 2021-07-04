package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void startNewGame() {
        Game game = new Game();
        game.startNewRound("WOORD");
        assertEquals(0, game.getAttemptCount());
    }

    @Test
    void getAttemptCount(){
        Game game = new Game();
        game.startNewRound("auto");

        assertNotNull(game.getAttemptCount());
    }
    @Test
    void getRoundsCount(){
        Game game = new Game();
        game.startNewRound("random");
        assertNotNull(game.getRoundsCount());
    }
    @Test
    void getscore(){
        Game game = new Game();
        game.startNewRound("game");
        assertNotNull(game.getScore());
    }



}