package com.example.game;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    //private ArrayList<Hero> heroes;
    
    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private ItemRepository itemRepository;

    public ArrayList<Hero> getHeroes() {
        return this.heroRepository.findAll();
    }
    
    public void addHero(String name) {
        this.heroRepository.save(new Hero(name));
    }
    
    public Hero findHeroByName(String heroName) {
        return this.heroRepository.findByName(heroName).get(0);
    }
    public Hero findHeroById(Long heroId) {
        return this.heroRepository.findById(heroId).get();
    }

    public Hero heroesFight(Hero firstHero, Hero secondHero) {
        if (firstHero.equals(secondHero)){
            return null;
        } else {
            firstHero.setGold(firstHero.getGold()+10);
            secondHero.setGold(secondHero.getGold()-10);
            this.heroRepository.save(firstHero);
            this.heroRepository.save(secondHero);
            return firstHero;
        }
    }
}
