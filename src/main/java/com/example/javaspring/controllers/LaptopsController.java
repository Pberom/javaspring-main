package com.example.javaspring.controllers;

import com.example.javaspring.models.laptops;
import com.example.javaspring.models.news;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id, Model model) {
        laptopsRepository.deleteById(id);
        return "redirect:/laptops/";
    }

    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        Model model) {
        if (!laptopsRepository.existsById(id)) {
            return "redirect:/laptops/";
        }
        Optional<laptops> news = laptopsRepository.findById(id);
        ArrayList<laptops> arrayList = new ArrayList<>();
        news.ifPresent(arrayList::add);
        model.addAttribute("laptops", arrayList);
        return "laptops/edit";
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

    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        @RequestParam("title") String title,
                        @RequestParam("OC") String oc,
                        @RequestParam("GS") String gs,
                        @RequestParam("Dick") String dick,
                        @RequestParam("Display") Double display,
                        @RequestParam("Gabarits") Double gabarits,
                        @RequestParam("Mass") Double mass,
                        Model model) {

        laptops news = laptopsRepository.findById(id).orElseThrow();

        news.setTitle(title);
        news.setDick(dick);
        news.setDisplay(display);
        news.setGabarits(gabarits);
        news.setMass(mass);
        news.setGS(gs);
        news.setOC(oc);

        laptopsRepository.save(news);
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
