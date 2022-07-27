package com.example.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

    @GetMapping("/firstview")
    public String returnFirstView(Model vModel) {
        vModel.addAttribute("name", "Chris Lee");
        vModel.addAttribute("name2", "SpongeBob SquarePants");
        return "first-view";
    }

    // lecture to input a search form and pass to results

    @GetMapping("/search")
    public String returnSearchForm() {
        return "search";
    }

    @PostMapping("/search")
    public String returnSearchResults(@RequestParam String query, Model vModel) {
        vModel.addAttribute("search", query);
        return "search-results";
    }

    // mini exercise 2 - search for favorite city

    @GetMapping("/citysearch")
    public String returnCitySearchForm() {
        return "citysearch";
    }

    @PostMapping("citysearch")
    public String returnCitySearchResult(@RequestParam String cityParam, Model vModel) {
        vModel.addAttribute("city", cityParam);
        return "city-result";
    }

    // mini exercise 2 - search for favorite city with redirect

    @GetMapping("/cityinput")
    public String returnCityInputForm() {
        return "cityinput";
    }

    @PostMapping("cityinput")
    public String returnCityInputResult(@RequestParam String cityParam, Model vModel) {
        vModel.addAttribute("city", cityParam);
        return "cityinput-result";
    }


}
