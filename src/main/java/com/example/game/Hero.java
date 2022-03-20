package com.example.game;


import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hero extends AbstractPersistable<Long> {
    private String name;
    private String status;
    private int strength;
    private int defense;
    private int level;
    private int health;
    private int gold;
    // private int shield;

    public Hero(String name) {
        this.name = name;
        this.status = "Ready to fight (or not....)";
        this.level = 1;
        this.health = 3;
        this.gold = 0;
        // this.shield = 1;
    }

    public void winBattle(){
        this.gold += 100;
        this.level += 1;
        this.status = "Hooray, who's the master!";
    }

    public void loseBattle() {
        if (this.gold < 50) {
            this.gold = 0;
        } else {
            this.gold -= 50;
        }
        if (this.level <= 1) {
            this.level = 0;
        } else {
            this.level -= 1;
        }
        this.status = "Better luck next time!";
    }
}
