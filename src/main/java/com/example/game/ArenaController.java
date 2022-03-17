package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ArenaController {

    @Autowired
    private HeroService heroService;

    @GetMapping("/arena")
    public String getArena(Model model) {
        ArrayList<Hero> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "arena";
    }

    @PostMapping("/fight")
    public String fight(@RequestParam Long hero1, @RequestParam Long hero2, Model model) {
        Hero winner = heroService.heroesFight(heroService.findHeroById(hero1), heroService.findHeroById(hero2));
        model.addAttribute("winner", winner);
        ArrayList<Hero> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "arena";
    }
}
