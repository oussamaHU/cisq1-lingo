package nl.hu.cisq1.lingo.trainer.domain;

public class Progress {
    private int score;
    private String hints;
    private int roundNumber = 1;

    public Progress(int score, String hints, int roundNumber) {
        this.score = score;
        this.hints = hints;
        this.roundNumber = roundNumber;
    }



    public void setHints(String hints) {
        this.hints = hints;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }


}
