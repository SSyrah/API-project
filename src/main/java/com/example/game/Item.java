package com.example.game;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="name")
    private String name;

    @Column(name="strength")
    private int strength;

    @Column(name="defense")
    private int defense;

    public Item() {

    }

    public Item(String name, int strength, int defense) {
        this.name = name;
        this.strength = strength;
        this.defense = defense;
    }

    @Override
    public String toString(){
        return "Item{" +
                "Id= " + id +
                ", Name= " + name +
                ", Strength= " + strength +
                ", Defense = " + defense + "}";
    }

    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
}
