package com.example.javaspring.controllers;

import com.example.javaspring.models.Filial;
import com.example.javaspring.models.Worker;
import com.example.javaspring.repositorios.FilialResopitory;
import com.example.javaspring.repositorios.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/workers")
public class WorkerController {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private FilialResopitory filialRepository;

    @GetMapping("/worker")
    private String Main(Model model){
        Iterable<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        Iterable<Filial> filials = filialRepository.findAll();
        model.addAttribute("filials", filials);

        return "workers/worker";
    }

    @PostMapping("/worker/add")
    public String blogPostAdd(@RequestParam String worker, @RequestParam String filial, Model model)
    {
        Worker workerMod = workerRepository.findByName(worker);
        Filial filialMod = filialRepository.findByName(filial);
        workerMod.getFilials().add(filialMod);
        filialMod.getWorkers().add(workerMod);
        workerRepository.save(workerMod);
        filialRepository.save(filialMod);
        return "redirect:/workers/worker";
    }
    @GetMapping("/index")
    String index() {
        return "workers/index";
    }
}
