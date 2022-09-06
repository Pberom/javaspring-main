package com.example.javaspring.controllers;

import com.example.javaspring.models.laptops;
import com.example.javaspring.models.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/laptops")
public class LaptopsController {
    @Autowired
    private com.example.javaspring.repositorios.laptopsRepository laptopsRepository;

    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<laptops> laptops = laptopsRepository.findAll();
        model.addAttribute("laptops",laptops);
        return "laptops/laptops";
    }

    @GetMapping("/add")
    public String AddGet(Model model)
    {
        return "laptops/add";
    }

    @PostMapping("/add")
    public String AddPost(
            @RequestParam("title") String title,
            @RequestParam("OC") String oc,
            @RequestParam("GS") String gs,
            @RequestParam("Dick") String dick,
            @RequestParam("Display") Double display,
            @RequestParam("Gabarits") Double gabarits,
            @RequestParam("Mass") Double mass,
            Model model)
    {
        laptops newOne = new laptops(title,oc,gs,dick,display,gabarits,mass);
        laptopsRepository.save(newOne);
        return "redirect:/laptops/";
    }

    @GetMapping("/search")
    public String AddPost(
            @RequestParam("title") String title,
            Model model)
    {
        List<laptops> newsList = laptopsRepository.findByTitleContains(title);
        model.addAttribute("laptops", newsList);
        return "laptops/laptops";
    }
}
