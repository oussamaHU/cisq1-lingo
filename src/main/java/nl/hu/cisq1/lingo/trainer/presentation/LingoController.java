package nl.hu.cisq1.lingo.trainer.presentation;


import nl.hu.cisq1.lingo.trainer.applicatie.TrainerService;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/LingoGame/Game")
public class LingoController {
    private final TrainerService trainerService;

    public LingoController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @PostMapping("/round")
    public void startNewRound(String wordToGuess) {
        trainerService.startNewRound(1L);

    }

    @PostMapping("/guess")
    public void guess(String word) {
        trainerService.guess(1L, "appel");

    }


}
