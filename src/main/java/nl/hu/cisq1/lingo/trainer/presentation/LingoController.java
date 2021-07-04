package nl.hu.cisq1.lingo.trainer.presentation;


import nl.hu.cisq1.lingo.trainer.applicatie.TrainerService;
import nl.hu.cisq1.lingo.trainer.domain.Feedback;
import nl.hu.cisq1.lingo.trainer.domain.Game;
import nl.hu.cisq1.lingo.trainer.domain.Progress;
import nl.hu.cisq1.lingo.trainer.domain.Round;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/LingoGame/Game")
public class LingoController {
    private final TrainerService trainerService;

    public LingoController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }


    @PostMapping("/game")
    public String startNewGame(){
        return trainerService.startNewGame();
    }   // hier wordt ID gereturned zodat de user weet wat de game ID is

    @PostMapping("/{gameId}/round")
    public Progress startNewRound(@PathVariable Long gameId) {
        return trainerService.startNewRound(gameId);
        // hier hoeft alleen de score gereturned te worden
    }

    @PostMapping("/{gameId}/guess")
    public Feedback guess(@PathVariable long gameId, @RequestParam String guess) {
        return trainerService.guess(gameId, guess);
        // hier wordt er feedback gereturned
    }


}
