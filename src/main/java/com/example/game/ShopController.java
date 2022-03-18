package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ShopController {
    @Autowired
    private HeroService heroservice;
    @Autowired
    private ShopService shopService;

    @GetMapping("/shop")
    public String getShop(Model model){
        ArrayList<Hero> heroes = heroservice.getHeroes();
        model.addAttribute("heroes", heroes);
        return "shop";
    }

    @GetMapping("/shop/{heroName}")
    public String getHeroInfo(@PathVariable String heroName, Model model){
        Hero hero = heroservice.findHeroByName(heroName);
        model.addAttribute("hero", hero);
        return "updateHero";
    }

    @PostMapping("/shop/{heroName}")
    public String updateHero(@RequestParam String heroName, Model model){
        Hero hero = heroservice.findHeroByName(heroName);
        hero = shopService.updateHero(hero);
        model.addAttribute("hero", hero);
        return "updateHero";
    }

}

