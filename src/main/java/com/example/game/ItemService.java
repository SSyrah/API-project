package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ItemService {

        @Autowired
        private ItemRepository itemRepository;

        public ArrayList<Item> getItems() {
            return this.itemRepository.findAll();
        }

        public void addItem(String name, int strength, int defense)
        {
            itemRepository.save(new Item(name, strength, defense));
        }

        public Item findItemByName(String itemName) {
            return this.itemRepository.findByName(itemName).get(0);
        }
        public Item findItemById(Long itemId) {
            return this.itemRepository.findById(itemId).get();
        }
}
