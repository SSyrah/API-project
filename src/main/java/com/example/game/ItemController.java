package com.example.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String getItems(Model model) {
        ArrayList<Item> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @PostMapping("/items")
    public String addItem(@RequestParam String itemName, int itemStrength, int itemDefense) {
        System.out.println("Saatiin: " + itemName);
        itemService.addItem(itemName, itemStrength, itemDefense);
        return "redirect:/items";
    }

    @GetMapping("items/{itemName}")
    public String getItemInfo(@PathVariable String itemName, Model model) {
        Item item = itemService.findItemByName(itemName);
        model.addAttribute("item", item);
        return "Item:";
    }
}
