package com.example.javaspring.controllers;

import com.example.javaspring.models.news;
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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private com.example.javaspring.repositorios.newsRepository newsRepository;

    //GetMapping
    @GetMapping("/")
    public String index(Model model)
    {
        Iterable<news> news = newsRepository.findAll();
        model.addAttribute("news",news);
        return "news/news";
    }

    @GetMapping("/add")
    public String AddGet(Model model)
    {
        model.addAttribute("news", new news());
        return "news/add";
    }

    @GetMapping("/{id}")
    public String read (@PathVariable("id") Long id, Model model) {
        Optional<news> news = newsRepository.findById(id);
        ArrayList<news> arrayList = new ArrayList<>();
        news.ifPresent(arrayList::add);
        model.addAttribute("news", arrayList);
        return "news/details";
    }
    @GetMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        Model model) {
        if (!newsRepository.existsById(id)) {
            return "redirect:/news/";
        }
        Optional<news> news = newsRepository.findById(id);
        ArrayList<news> arrayList = new ArrayList<>();
        news.ifPresent(arrayList::add);
        model.addAttribute("news", arrayList.get(0));
        return "news/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete (@PathVariable("id") Long id, Model model) {
        newsRepository.deleteById(id);
        return "redirect:/news/";
    }

    //PostMapping
    /*
    @PostMapping("/add")
    public String AddPost(
            @RequestParam("title") String title,
            @RequestParam("bodytext") String bodytext,
            @RequestParam("avtor") String avtor,
            @RequestParam("views") Integer views,
            @RequestParam("likes") Integer likes,
            Model model)
    {
        news newOne = new news(title,bodytext,avtor,likes,views);
        newsRepository.save(newOne);
        return "redirect:/news/";
    }
    */
    @PostMapping("/add")
    public String AddPost(
            @ModelAttribute("news") @Valid news newsNews,
            BindingResult bindingResult,
            Model model)
    {
        if(bindingResult.hasErrors())
            return "news/add";

        newsRepository.save(newsNews);
        return "redirect:/news/";
    }
    @PostMapping("/edit/{id}")
    public String edit (@PathVariable("id") Long id,
                        @ModelAttribute("news") @Valid news newOne, BindingResult bindingResult, Model model) {

        if (!newsRepository.existsById(id)) {
            return "redirect:/news/";
        }
        if (bindingResult.hasErrors()) {
            return "redirect:/news/edit/{id}";
        }
        newsRepository.save(newOne);
        return "redirect:/news/";
    }

    //Search GetMapping
    @GetMapping("/search")
    public String AddPost(
            @RequestParam("title") String title,
            Model model)
    {
        List<news> newsList = newsRepository.findByTitle(title);
        model.addAttribute("news", newsList);
        return "news/news";
    }
}
