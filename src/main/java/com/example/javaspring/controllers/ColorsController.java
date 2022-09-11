package com.example.javaspring.controllers;
import com.example.javaspring.models.colors;
import com.example.javaspring.models.laptops;
import com.example.javaspring.models.news;
import com.example.javaspring.repositorios.colorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("colors", new colors());
        return "colors/add";
    }

    @GetMapping("/{id}")
    public String read (@PathVariable("id") Long id, Model model) {
        Optional<colors> colors = colorsRepository.findById(id);
        ArrayList<colors> arrayList = new ArrayList<>();
        colors.ifPresent(arrayList::add);
        model.addAttribute("colors", arrayList);
        return "colors/details";
    }
    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        Model model) {
        if (!colorsRepository.existsById(id)) {
            return "redirect:/colors/";
        }
        Optional<colors> colors = colorsRepository.findById(id);
        ArrayList<colors> arrayList = new ArrayList<>();
        colors.ifPresent(arrayList::add);
        model.addAttribute("colors", arrayList.get(0));
        return "colors/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id, Model model) {
        colorsRepository.deleteById(id);
        return "redirect:/colors/";
    }

   /* @PostMapping("/add")
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
    }*/
   @PostMapping("/add")
   public String AddPost(
           @ModelAttribute("colors") @Valid colors newsNews,
           BindingResult bindingResult,
           Model model)
   {
       if(bindingResult.hasErrors())
           return "colors/add";

       colorsRepository.save(newsNews);
       return "redirect:/colors/";
   }

    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        @ModelAttribute("colors") @Valid colors newOne, BindingResult bindingResult, Model model) {

        if (!colorsRepository.existsById(id)) {
            return "redirect:/colors/";
        }
        if (bindingResult.hasErrors()) {
            return "redirect:/colors/edit/{id}";
        }
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
