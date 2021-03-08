package nl.hu.cisq1.lingo.trainer.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void startNewRound() {
     Game game = new Game(10);
     game.startGame();
     game.startNewRound("woord");
     assertNotNull(game.getRound());
    }



}