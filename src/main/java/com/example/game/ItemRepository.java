package com.example.game;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
        @Override
        ArrayList<Item> findAll();
        ArrayList<Item> findByName(String name);
        Optional<Item> findById(Long id);
    }
