package com.example.game;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HeroController {
    
    @Autowired
    private HeroService heroService;

    @Autowired
    private ItemService itemService;

    @GetMapping("/heroes")
    public String getHeroes(Model model) {
        ArrayList<Hero> heroes = heroService.getHeroes();
        model.addAttribute("heroes", heroes);
        return "heroes";
    }
    
    @PostMapping("/heroes")
    public String addHero(@RequestParam String heroName) {
        System.out.println("Saatiin: " + heroName);
        heroService.addHero(heroName);
        return "redirect:/heroes";
    }
    
    @GetMapping("heroes/{heroName}")
    public String getHeroInfo(@PathVariable String heroName, Model model) {
        Hero hero = heroService.findHeroByName(heroName);
        model.addAttribute("hero", hero);
        return "hero";
    }

    @PutMapping("shop/{heroName}")
    Item BuyItem(@PathVariable String heroName, long item_id){
        Hero hero =  heroService.findHeroByName(heroName);
        long hero_id = hero.getId();
        Item item = itemService.findItemById(item_id);

        hero.addItem(item);

        return item;
    }

}
