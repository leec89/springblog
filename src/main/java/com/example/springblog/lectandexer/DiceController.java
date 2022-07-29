package com.example.springblog.lectandexer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

    @GetMapping(path = "/dice-roll/{num}")
    public String returnGuessDiceRoll(Model vModel, @PathVariable int num) {
        Random random = new Random();
        int randomRoll = random.nextInt(6) + 1;
        vModel.addAttribute("diceRoll", randomRoll);
        vModel.addAttribute("guessNum", num);
        return "lectandexer/dice-roll";
    }

    @GetMapping("/dice-guess")
    public String showJoinForm() {
        return "lectandexer/dice-guess";
    }

}