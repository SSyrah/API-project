package com.example.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
        @Override
        ArrayList<Item> findAll();
        ArrayList<Item> findByName(String name);
        Optional<Item> findById(Long id);
    }
