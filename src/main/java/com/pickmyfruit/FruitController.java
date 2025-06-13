package com.pickmyfruit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FruitController {

    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping("/fruits")
    public String getFruits(Model model) {
        List<Fruit> fruits = fruitRepository.findAll();
        model.addAttribute("fruits", fruits);
        return "fruits";  // returns fruits.html
    }

    @GetMapping("/fruits/new")
    public String showAddFruitForm(Model model) {
        model.addAttribute("fruit", new Fruit());
        return "fruit-form";  // returns fruit-form.html
    }

    @PostMapping("/fruits/save")
    public String saveFruit(@ModelAttribute("fruit") Fruit fruit) {
        fruitRepository.save(fruit);
        return "redirect:/fruits";  // after save, redirect to fruit list page
    }

    // ✅ PASTE THIS BELOW THE EXISTING METHODS

    @GetMapping("/fruits/edit/{id}")
    public String editFruit(@PathVariable Integer id, Model model) {
        Fruit fruit = fruitRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Invalid fruit Id: " + id));
        model.addAttribute("fruit", fruit);
        return "fruit-form";  // Reuse the same form
    }

    @GetMapping("/fruits/delete/{id}")
    public String deleteFruit(@PathVariable Integer id) {
        fruitRepository.deleteById(id);
        return "redirect:/fruits";
    }
}
