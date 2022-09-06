package com.example.javaspring.controllers;

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
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private com.example.javaspring.repositorios.newsRepository newsRepository;

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
        return "news/add";
    }

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
