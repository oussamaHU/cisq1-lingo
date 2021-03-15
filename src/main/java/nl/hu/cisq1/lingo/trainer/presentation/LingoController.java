package nl.hu.cisq1.lingo.trainer.presentation;


import nl.hu.cisq1.lingo.trainer.domain.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LingoGame/Game")
public class LingoController {
    private final LingoController lingoController;

    public LingoController(LingoController lingoController) {
        this.lingoController = lingoController;
    }
    @PostMapping("/game")
    public void startGame(){
        lingoController.startGame();

    }
    @PostMapping("/round")
    public void startNewRound(String wordToGuess){
        lingoController.startNewRound("appel");

    }
    @PostMapping("/guess")
    public void guess(String word){
        lingoController.guess(word);

    }
    @GetMapping("/showprogress")
    public void showProgress(){
        lingoController.showProgress();
    }
}
