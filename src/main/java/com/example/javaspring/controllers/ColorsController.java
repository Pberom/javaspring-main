package com.example.javaspring.controllers;
import com.example.javaspring.models.colors;
import com.example.javaspring.models.laptops;
import com.example.javaspring.models.news;
import com.example.javaspring.repositorios.colorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/colors")
public class ColorsController {
    @Autowired
    private com.example.javaspring.repositorios.colorsRepository colorsRepository;
    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<colors> colors = colorsRepository.findAll();
        model.addAttribute("colors",colors);
        return "colors/colors";
    }

    @GetMapping("/add")
    public String AddGet(Model model)
    {
        return "colors/add";
    }

    @PostMapping("/add")
    public String AddPost(
            @RequestParam("title") String title,
            @RequestParam("decription") String decription,
            @RequestParam("darkness") String darkness,
            @RequestParam("base") Integer base,
            @RequestParam("base_two") Double base_two,
            Model model)
    {
        colors newOne = new colors(title,decription,darkness,base,base_two);
        colorsRepository.save(newOne);
        return "redirect:/colors/";
    }

    @GetMapping("/search")
    public String AddPost(
            @RequestParam("title") String title,
            Model model)
    {
        List<colors> newsList = colorsRepository.findByTitle(title);
        model.addAttribute("colors", newsList);
        return "colors/colors";
    }
}
