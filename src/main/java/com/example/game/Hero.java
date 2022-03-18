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
    private int level;
    private int health;
    private int gold;
    // private int shield;

    public Hero(String name) {
        this.name = name;
        this.status = "This noob is waiting for the first quest!";
        this.level = 1;
        this.health = 3;
        this.gold = 0;
        // this.shield = 1;
    }
}
