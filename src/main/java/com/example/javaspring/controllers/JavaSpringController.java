package com.example.javaspring.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.spring.javaspring.JavaspringApplication;

@Controller
public class JavaSpringController {
    @GetMapping("/")
    public String greeting(Model model) {
        Integer a = 0;
        a = 1;
        model.addAttribute("title", a);
        return "home";
    }

    @GetMapping("/calc") //Страничка под калькулятор
    public String Calc(Model model) {
        model.addAttribute("title", 167);
        return "home";
    }

    @GetMapping("/res") //Получение информации со странички калькулятора
    public String Res(@RequestParam(value = "number1", required = false, defaultValue = "1") int a,
                      @RequestParam(value = "number2", required = false, defaultValue = "2") int b,
                      Model model) {
        int c = a+b;
        model.addAttribute("answer", c);
        return "result";
    }

    @PostMapping("/res") //Страничка под результат работы калькулятора
    public String Result(@RequestParam(value = "number1", required = false, defaultValue = "1") int a,
                      @RequestParam(value = "number2", required = false, defaultValue = "2") int b,
                      @RequestParam(value = "action", required = false) String act,
                      Model model) {

        int c = 0;

        switch (act) {
            case "+" -> {
                c = a + b;
                break;
            }
            case "-" -> {
                c = a - b;
                break;
            }
            case "*" -> {
                c = a * b;
                break;
            }
            case "/" -> {
                c = a / b;
                break;
            }
        }
        model.addAttribute("answer", c);
        return "result";
    }
}
