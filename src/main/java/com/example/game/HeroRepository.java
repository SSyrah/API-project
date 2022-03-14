package com.example.game;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    @Override
    ArrayList<Hero> findAll();
    ArrayList<Hero> findByName(String name);
    Optional<Hero> findById(Long id);
}
