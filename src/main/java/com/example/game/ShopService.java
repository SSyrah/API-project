package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShopService {
    private int shieldupdate = 100;
    private int armorupdate = 200;
    private int swordupdate = 50;

    @Autowired
    private HeroRepository heroRepository;
    @Autowired
    private HeroService heroService;

    public ArrayList<Hero> getHeroes() { return  this.heroRepository.findAll(); }

    public Hero updateHero(Hero theHero){
        if (theHero.getGold() >= shieldupdate){
            theHero.setLevel(theHero.getLevel() + 1);
            theHero.setGold(theHero.getGold() - shieldupdate);
            this.heroRepository.save(theHero);
        }
        else {
            return null;
        }
        return theHero;
    }



}

