package com.example.game;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.HashSet;
import java.util.Set;

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

    private ItemRepository itemRepository;

    @ManyToMany
    @JoinTable(name="has_item",
            joinColumns = @JoinColumn(name="hero_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    private Set<Item> heldItems = new HashSet<>();
    // private int shield;

    public Hero(String name) {
        this.name = name;
        this.status = "This noob is waiting for the first quest!";
        this.level = 1;
        this.health = 3;
        this.gold = 0;
        // this.shield = 1;
    }

    public Set<Item> getHeldItems() {
        return heldItems;
    }

    public void addItem(Item item){
        heldItems.add(item);
        itemRepository.save(item);
    }
}
